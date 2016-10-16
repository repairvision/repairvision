package org.sidiff.consistency.repair.complement.construction.cpo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.*;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.complement.construction.ComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleAttributeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeCreateMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeDeleteMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMultiMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
import org.sidiff.consistency.repair.complement.util.ComplementUtil;

/**
 * Convert sub-rule match to partial super-rule match and constructs the
 * complement-rule = super-rule (-) partial-edit-rule-match.
 * 
 * @author Manuel Ohrndorf
 */
public class CPOComplementConstructor extends ComplementConstructor {

	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;
	
	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graph;
	
	/**
	 * @param sourceRule
	 *            The partially executed edit-rule.
	 * @param engine
	 *            The (Henshin) engine which applies the rules.
	 * @param graph
	 *            The working graph, i.e. the actual version of the model.
	 */
	public CPOComplementConstructor(Rule sourceRule, EngineImpl engine, EGraph graph) {
		super(sourceRule);
		this.engine = engine;
		this.graph = graph;
	}

	public Collection<ComplementRule> createComplementRule(Rule subRule, Collection<EditRuleMatch> subRuleMatch) {
		Collection<ComplementRule> complementRules = new ArrayList<>();
		
		if (DebugUtil.isActive) {
			LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
			LogUtil.log(LogEvent.NOTICE, "------------------ CREATE COMPLEMENT RULE ------------------");
			LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
			
			LogUtil.log(LogEvent.NOTICE, "\nSub-Rule-Match: \n\n" + ComplementUtil.printEditRuleMatch(subRuleMatch));
		}
		
		// TODO[Precalculate]: Calculate rule embedding:
		for (RuleEmbedding embedding : RuleEmbeddingCalculator.calculateRuleEmbedding(sourceRule, subRule)) {
			
			// Convert sub-rule match to partial super-rule match:
			List<EditRuleMatch> superRuleMatch = convertToPartialMatch(embedding, subRuleMatch);
			
			if (DebugUtil.isActive) {
				LogUtil.log(LogEvent.NOTICE, "\nCPO-Match (partial): \n\n" + ComplementUtil.printEditRuleMatch(superRuleMatch));
			}
			
			// Create the complement = super - sub:
			ComplementRule complementRule = createComplementRule(superRuleMatch);
			
			if (complementRule != null) {
				complementRules.add(complementRule);
			}
		}
		
		return complementRules;
	}

	private List<EditRuleMatch> convertToPartialMatch(
			RuleEmbedding embedding, Collection<EditRuleMatch> subEditRuleMatching) {

		List<EditRuleMatch> superEditRuleMatch = new ArrayList<>();
		
		for (EditRuleMatch subEditRuleMatch : subEditRuleMatching) {
			
			// Node-Matches:
			if (subEditRuleMatch instanceof EditRuleNodeMatch) {
				Node subRuleNode = ((EditRuleNodeMatch) subEditRuleMatch).getNode();
				Node superRuleNode = embedding.getSuperRuleNode(subRuleNode);
				
				if (subEditRuleMatch instanceof EditRuleNodeSingleMatch) {
					EObject match = ((EditRuleNodeSingleMatch) subEditRuleMatch).getModelElement();
					
					EditRuleNodeMatch superEditRuleNodeMatch = new  EditRuleNodeSingleMatch(
							superRuleNode, subEditRuleMatch.getAction(), match);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}
				
				else  if (subEditRuleMatch instanceof EditRuleNodeMultiMatch) {
					Collection<EObject> matches = ((EditRuleNodeMultiMatch) subEditRuleMatch).getModelElements();

					EditRuleNodeMatch superEditRuleNodeMatch = new  EditRuleNodeMultiMatch(
							superRuleNode, subEditRuleMatch.getAction(), matches);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}
			}
			
			// Attribute-Matches:
			if (subEditRuleMatch instanceof EditRuleAttributeMatch) {
				Attribute subRuleAttribute = ((EditRuleAttributeMatch) subEditRuleMatch).getAttribute();
				Object value = ((EditRuleAttributeMatch) subEditRuleMatch).getValue();
				Node subRuleNode = getLHS(subRuleAttribute.getNode());
				
				Attribute superRuleAttribute = getRHS(embedding.getSuperRuleNode(subRuleNode))
						.getAttribute(subRuleAttribute.getType());
				
				EditRuleAttributeMatch superEditRuleAttributeMatch = new EditRuleAttributeMatch(superRuleAttribute, value);
				superEditRuleMatch.add(superEditRuleAttributeMatch);
			}
			
			// Edge-Matches:
			else if (subEditRuleMatch instanceof EditRuleEdgeMatch) {
				Edge subRuleEdge = ((EditRuleEdgeMatch) subEditRuleMatch).getEdge();
				Edge superRuleEdge = embedding.getSuperRuleEdge(subRuleEdge);
				
				assert (superRuleEdge != null);
				
				EObject srcMatch = ((EditRuleEdgeMatch) subEditRuleMatch).getSrcModelElement();
				EObject tgtMatch = ((EditRuleEdgeMatch) subEditRuleMatch).getTgtModelElement();
				
				EditRuleEdgeMatch superEditRuleNodeMatch = null;
				
				if (subEditRuleMatch instanceof EditRuleEdgeDeleteMatch) {
					superEditRuleNodeMatch = new  EditRuleEdgeDeleteMatch(superRuleEdge, srcMatch, tgtMatch);
				}
				
				else if (subEditRuleMatch instanceof EditRuleEdgeCreateMatch) {
					superEditRuleNodeMatch = new  EditRuleEdgeCreateMatch(superRuleEdge, srcMatch, tgtMatch);
				}
				
				assert (superEditRuleNodeMatch != null);
				superEditRuleMatch.add(superEditRuleNodeMatch);
			}
		}
		
		return superEditRuleMatch;
	}

	@Override
	protected ComplementRule createComplementRule(Rule sourceRule, Rule complementRule) {
		return new CPOComplementRule(sourceRule, complementRule, engine, graph);
	}
}
