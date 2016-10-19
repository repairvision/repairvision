package org.sidiff.consistency.repair.complement.construction.cpo;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;

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
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.complement.construction.ComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleAttributeMatch;
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
					EObject matchA = ((EditRuleNodeSingleMatch) subEditRuleMatch).getModelAElement();
					EObject matchB = ((EditRuleNodeSingleMatch) subEditRuleMatch).getModelBElement();
					
					EditRuleNodeSingleMatch superEditRuleNodeMatch = new  EditRuleNodeSingleMatch(
							subEditRuleMatch.getAction(), superRuleNode);
					superEditRuleNodeMatch.setModelAElement(matchA);
					superEditRuleNodeMatch.setModelBElement(matchB);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}
				
				else if (subEditRuleMatch instanceof EditRuleNodeMultiMatch) {
					Collection<EObject> matchesA = ((EditRuleNodeMultiMatch) subEditRuleMatch).getModelAElements();
					Collection<EObject> matchesB = ((EditRuleNodeMultiMatch) subEditRuleMatch).getModelBElements();

					EditRuleNodeMultiMatch superEditRuleNodeMatch = new  EditRuleNodeMultiMatch(
							subEditRuleMatch.getAction(), superRuleNode);
					superEditRuleNodeMatch.setModelAElements(matchesA);
					superEditRuleNodeMatch.setModelBElements(matchesB);
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
				
				EObject srcMatchA = ((EditRuleEdgeMatch) subEditRuleMatch).getSrcModelAElement();
				EObject tgtMatchA = ((EditRuleEdgeMatch) subEditRuleMatch).getTgtModelAElement();
				
				EObject srcMatchB = ((EditRuleEdgeMatch) subEditRuleMatch).getSrcModelBElement();
				EObject tgtMatchB = ((EditRuleEdgeMatch) subEditRuleMatch).getTgtModelBElement();
				
				EditRuleEdgeMatch superEditRuleNodeMatch = new EditRuleEdgeMatch(
						((EditRuleEdgeMatch) subEditRuleMatch).getAction(), superRuleEdge);
				superEditRuleNodeMatch.setSrcModelAElement(srcMatchA);
				superEditRuleNodeMatch.setTgtModelAElement(tgtMatchA);
				superEditRuleNodeMatch.setSrcModelBElement(srcMatchB);
				superEditRuleNodeMatch.setTgtModelBElement(tgtMatchB);
				
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
