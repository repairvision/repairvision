package org.sidiff.consistency.repair.complement.construction.context;

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
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;

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

	protected List<ComplementMatch> createComplementMatches(List<EditRuleMatch> partialSourceMatch) {
		
		// Create complement pre-match by partial source-rule match:
		Match complementMatche = new MatchImpl(complementRule);

		// Get change context as pre-match:
		for (EditRuleMatch sourceRuleMatch : partialSourceMatch) {

			if (sourceRuleMatch instanceof EditRuleEdgeMatch) {
				if (sourceRuleMatch.getAction().equals(Type.CREATE)) {

					addMatch(complementMatche,
							((EditRuleEdgeMatch) sourceRuleMatch).getEdge().getSource(),
							((EditRuleEdgeMatch) sourceRuleMatch).getSrcModelBElement());
					addMatch(complementMatche,
							((EditRuleEdgeMatch) sourceRuleMatch).getEdge().getTarget(),
							((EditRuleEdgeMatch) sourceRuleMatch).getTgtModelBElement());
				}
				
				else if (sourceRuleMatch.getAction().equals(Type.DELETE)) {

					EObject src = ((EditRuleEdgeMatch) sourceRuleMatch).getSrcModelBElement();
					
					if (src != null) {
						addMatch(complementMatche,
								((EditRuleEdgeMatch) sourceRuleMatch).getEdge().getSource(), src);
					}
					
					EObject tgt = ((EditRuleEdgeMatch) sourceRuleMatch).getTgtModelBElement();
					
					if (tgt != null) {
						addMatch(complementMatche,
								((EditRuleEdgeMatch) sourceRuleMatch).getEdge().getTarget(), tgt);
					}
				}
			}

			else if (sourceRuleMatch instanceof EditRuleNodeSingleMatch) {
				if (sourceRuleMatch.getAction().equals(Type.CREATE)) {

					addMatch(complementMatche,
							((EditRuleNodeSingleMatch) sourceRuleMatch).getNode(),
							((EditRuleNodeSingleMatch) sourceRuleMatch).getModelBElement());
				}
			}

			// NOTE: Ignore EditRuleNodeMulitMatches... only unique context!
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<ComplementMatch> complementPreMatches = new ArrayList<>();
		Iterator<Match> matchFinder = getEngine().findMatches(complementRule, getGraph(), complementMatche).iterator();
		
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			ComplementMatch nextComplementMatch = new ComplementMatch(nextMatch);
			complementPreMatches.add(nextComplementMatch);
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
	}
	
	private void addMatch(Match complementPreMatches, Node sourceNode, EObject match) {
		Node complementNode = getLHS(getTrace(sourceNode));
		
		if (complementNode != null) {
			complementPreMatches.setNodeTarget(complementNode, match);
		}
	}
}
