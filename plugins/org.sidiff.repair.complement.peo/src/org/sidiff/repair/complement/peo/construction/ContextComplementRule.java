package org.sidiff.repair.complement.peo.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.repair.api.matching.EOAttributeMatch;
import org.sidiff.repair.api.matching.EOEdgeMatch;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EONodeSingleMatch;
import org.sidiff.repair.api.matching.EOParameterMatch;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.complement.construction.ComplementRule;

/**
 * Constructs the complement-rule = source-rule (-) partial-edit-rule-match.
 * Requires that the context of the complement-rule can be completely matched.
 * 
 * @author Manuel Ohrndorf
 */
public class ContextComplementRule extends ComplementRule {

	public ContextComplementRule(
			Rule sourceRule, Rule complementRule, 
			EngineImpl engine, EGraph graph) {
		
		super(sourceRule, complementRule);
		initialize(engine, graph);
	}

	protected List<EditOperationMatching> createComplementMatches(List<EOMatch> partialSourceMatch) {

		// Create complement pre-match by partial source-rule match:
		Match complementMatche = new MatchImpl(complementRule);

		// Get change context as pre-match:
		for (EOMatch sourceRuleMatch : partialSourceMatch) {

			if (sourceRuleMatch instanceof EOEdgeMatch) {
				EOEdgeMatch sourceEdgeMatch = (EOEdgeMatch) sourceRuleMatch;
				
				if (sourceEdgeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementMatche,
							sourceEdgeMatch.getEdge().getSource(),
							sourceEdgeMatch.getSrcModelBElement());
					addMatch(complementMatche,
							sourceEdgeMatch.getEdge().getTarget(),
							sourceEdgeMatch.getTgtModelBElement());
				}
				
				else if (sourceEdgeMatch.getAction().equals(Type.DELETE)) {
					EObject src = ((EOEdgeMatch) sourceRuleMatch).getSrcModelBElement();
					
					if (src != null) {
						addMatch(complementMatche, sourceEdgeMatch.getEdge().getSource(), src);
					}
					
					EObject tgt = sourceEdgeMatch.getTgtModelBElement();
					
					if (tgt != null) {
						addMatch(complementMatche, sourceEdgeMatch.getEdge().getTarget(), tgt);
					}
				}
			}

			else if (sourceRuleMatch instanceof EONodeSingleMatch) {
				EONodeSingleMatch sourceNodeMatch = (EONodeSingleMatch) sourceRuleMatch;
				
				if (sourceNodeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementMatche,
							sourceNodeMatch.getNode(),
							sourceNodeMatch.getModelBElement());
				}
			}
			
			else if (sourceRuleMatch instanceof EOAttributeMatch) {
				EOAttributeMatch sourceAttributeMatch = (EOAttributeMatch) sourceRuleMatch;
				
				if (sourceAttributeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementMatche,
							sourceAttributeMatch.getAttribute().getNode(),
							sourceAttributeMatch.getObject());
				}
			}
			
			else if (sourceRuleMatch instanceof EOParameterMatch) {
				EOParameterMatch sourceParameterMatch = (EOParameterMatch) sourceRuleMatch;
				
				addMatch(complementMatche, 
						sourceParameterMatch.getParameter(), 
						sourceParameterMatch.getValue());
			}

			// NOTE: Ignore EditRuleNodeMulitMatches... only unique context!
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<EditOperationMatching> complementPreMatches = new ArrayList<>();
		Iterator<Match> matchFinder = getEngine().findMatches(complementRule, getGraph(), complementMatche).iterator();
		
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			EditOperationMatching nextComplementMatch = new EditOperationMatching(nextMatch);
			complementPreMatches.add(nextComplementMatch);
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
	}
	
	private void addMatch(Match complementPreMatches, Parameter sourceParameter, Object value) {
		Parameter complementParameter = getTrace(sourceParameter);
		
		if (complementParameter != null) {
			complementPreMatches.setParameterValue(complementParameter, value);
		}
	}
	
	private void addMatch(Match complementPreMatches, Node sourceNode, EObject match) {
		Node complementNode = getLHS(getTrace(sourceNode));
		
		if (complementNode != null) {
			complementPreMatches.setNodeTarget(complementNode, match);
		}
	}
}
