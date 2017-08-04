package org.sidiff.repair.complement.cpo.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.sidiff.repair.api.matching.EOAttributeMatch;
import org.sidiff.repair.api.matching.EOEdgeMatch;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EONodeMatch;
import org.sidiff.repair.api.matching.EONodeMultiMatch;
import org.sidiff.repair.api.matching.EONodeSingleMatch;
import org.sidiff.repair.complement.construction.ComplementConstructor;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.cpo.embedding.EmbeddingRulebase;
import org.sidiff.repair.complement.cpo.embedding.RuleEmbedding;
import org.sidiff.repair.complement.util.ComplementUtil;

/**
 * Convert sub-rule match to partial super-rule match and constructs the
 * complement-rule = super-rule (-) partial-edit-rule-match.
 * 
 * @author Manuel Ohrndorf
 */
public class CPOComplementConstructor extends ComplementConstructor {

	/**
	 * The rulebase that stores all embeddings from sub-rules to CPOs.
	 */
	private EmbeddingRulebase embeddings;
	
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
	 * @param embeddings
	 *            The rulebase that stores all embeddings from sub-rules to CPOs.
	 * @param engine
	 *            The (Henshin) engine which applies the rules.
	 * @param graph
	 *            The working graph, i.e. the actual version of the model.
	 */
	public CPOComplementConstructor(Rule sourceRule, EmbeddingRulebase embeddings, EngineImpl engine, EGraph graph) {
		super(sourceRule);
		this.embeddings = embeddings;
		this.engine = engine;
		this.graph = graph;
	}

	public Collection<ComplementRule> createComplementRule(Rule subRule, Collection<EOMatch> subRuleMatch) {
		Collection<ComplementRule> complementRules = new ArrayList<>();

		if (DebugUtil.isActive) {
			LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
			LogUtil.log(LogEvent.NOTICE, "------------------ CREATE COMPLEMENT RULE ------------------");
			LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");

			LogUtil.log(LogEvent.NOTICE, "\nSub-Rule: " + subRule.getName());
			LogUtil.log(LogEvent.NOTICE, "\nSub-Rule-Match: \n\n" + ComplementUtil.printEditRuleMatch(subRuleMatch));
		}

		// Calculate complement for embedding:
		for (RuleEmbedding embedding : embeddings.getEmbeddings(sourceRule, subRule)) {

			// Convert sub-rule match to partial super-rule match:
			List<EOMatch> superRuleMatch = convertToPartialMatch(embedding, subRuleMatch);

			if (DebugUtil.isActive) {
				LogUtil.log(LogEvent.NOTICE, "\nSource-Rule: " + sourceRule.getName());
				LogUtil.log(LogEvent.NOTICE,
						"\nCPO-Match (partial): \n\n" + ComplementUtil.printEditRuleMatch(superRuleMatch));
			}

			// Create the complement = super - sub:
			ComplementRule complementRule = createComplementRule(superRuleMatch, Collections.emptyList());

			if (complementRule != null) {
				complementRules.add(complementRule);
			}
		}

		return complementRules;
	}

	private List<EOMatch> convertToPartialMatch(RuleEmbedding embedding, Collection<EOMatch> subEditRuleMatching) {

		List<EOMatch> superEditRuleMatch = new ArrayList<>();

		for (EOMatch subEditRuleMatch : subEditRuleMatching) {

			// Node-Matches:
			if (subEditRuleMatch instanceof EONodeMatch) {
				Node subRuleNode = ((EONodeMatch) subEditRuleMatch).getNode();
				Node superRuleNode = embedding.getSuperRuleNode(subRuleNode);

				if (subEditRuleMatch instanceof EONodeSingleMatch) {
					EObject matchA = ((EONodeSingleMatch) subEditRuleMatch).getModelAElement();
					EObject matchB = ((EONodeSingleMatch) subEditRuleMatch).getModelBElement();

					EONodeSingleMatch superEditRuleNodeMatch = new EONodeSingleMatch(subEditRuleMatch.getAction(),
							superRuleNode);
					superEditRuleNodeMatch.setModelAElement(matchA);
					superEditRuleNodeMatch.setModelBElement(matchB);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}

				else if (subEditRuleMatch instanceof EONodeMultiMatch) {
					Collection<EObject> matchesA = ((EONodeMultiMatch) subEditRuleMatch).getModelAElements();
					Collection<EObject> matchesB = ((EONodeMultiMatch) subEditRuleMatch).getModelBElements();

					EONodeMultiMatch superEditRuleNodeMatch = new EONodeMultiMatch(subEditRuleMatch.getAction(),
							superRuleNode);
					superEditRuleNodeMatch.setModelAElements(matchesA);
					superEditRuleNodeMatch.setModelBElements(matchesB);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}
			}

			// Attribute-Matches:
			if (subEditRuleMatch instanceof EOAttributeMatch) {
				Attribute subRuleAttribute = ((EOAttributeMatch) subEditRuleMatch).getAttribute();
				EObject object = ((EOAttributeMatch) subEditRuleMatch).getObject();
				Object value = ((EOAttributeMatch) subEditRuleMatch).getValue();
				Node subRuleNode = getLHS(subRuleAttribute.getNode());

				Attribute superRuleAttribute = getRHS(embedding.getSuperRuleNode(subRuleNode))
						.getAttribute(subRuleAttribute.getType());

				EOAttributeMatch superEditRuleAttributeMatch = new EOAttributeMatch(superRuleAttribute, object, value);
				superEditRuleMatch.add(superEditRuleAttributeMatch);
			}

			// Edge-Matches:
			else if (subEditRuleMatch instanceof EOEdgeMatch) {
				Edge subRuleEdge = ((EOEdgeMatch) subEditRuleMatch).getEdge();
				Edge superRuleEdge = embedding.getSuperRuleEdge(subRuleEdge);

				assert (superRuleEdge != null);

				EObject srcMatchA = ((EOEdgeMatch) subEditRuleMatch).getSrcModelAElement();
				EObject tgtMatchA = ((EOEdgeMatch) subEditRuleMatch).getTgtModelAElement();

				EObject srcMatchB = ((EOEdgeMatch) subEditRuleMatch).getSrcModelBElement();
				EObject tgtMatchB = ((EOEdgeMatch) subEditRuleMatch).getTgtModelBElement();

				EOEdgeMatch superEditRuleNodeMatch = new EOEdgeMatch(((EOEdgeMatch) subEditRuleMatch).getAction(),
						superRuleEdge);
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
