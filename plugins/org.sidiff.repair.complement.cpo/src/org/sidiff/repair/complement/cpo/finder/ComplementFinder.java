package org.sidiff.repair.complement.cpo.finder;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.difference.rulebase.RecognitionRule;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.RuleBaseItem;
import org.sidiff.repair.complement.construction.ComplementConstructor;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.cpo.embedding.EmbeddingRulebase;
import org.sidiff.repair.complement.cpo.embedding.RuleEmbedding;
import org.sidiff.repair.complement.matching.RecognitionAttributeMatch;
import org.sidiff.repair.complement.matching.RecognitionEdgeMatch;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeMultiMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeSingleMatch;
import org.sidiff.repair.complement.util.ComplementUtil;

public class ComplementFinder {
	
	private ComplementConstructor complementConstructor;

	private EngineImpl engine;

	private EGraph graphModelB;

	private ILiftingRuleBase subRulebase;
	
	private Collection<Rule> subEditRules;
	
	private EmbeddingRulebase embeddings;
	
	private SymmetricDifference difference;
	
	private Set<RuleApplication> rrApplications;
	
	private Map<Rule, Collection<ComplementRule>> complements = new HashMap<>();

	public ComplementFinder(
			Set<RuleApplication> rrApplications,
			ILiftingRuleBase subRulebase,
			Collection<Rule> subEditRules, 
			EmbeddingRulebase embeddings,
			SymmetricDifference difference,
			EGraph graphModelB) {
		
		this.rrApplications = rrApplications;
		this.subRulebase = subRulebase;
		this.subEditRules = subEditRules;
		this.embeddings = embeddings;
		this.difference = difference;
		
		this.complementConstructor = new ComplementConstructor();
		this.graphModelB = graphModelB;
		this.engine = new EngineImpl();
		
		calculateComplementRules();
	}
	
	private void calculateComplementRules() {
		
		// Get mappings: SCS -> RR + Match -> EO
		Map<SemanticChangeSet, RuleApplication>  recognitionMatches = getRecognitionMatches(rrApplications);
		Map<Rule, EditRule> recognition2editRules = getRecognition2EditRules();
		
		// Match converter:
		RecognitionToEditRuleMatch matchConverter = new RecognitionToEditRuleMatch(difference);
		
		for (SemanticChangeSet scs : difference.getChangeSets()) {
			
			long calculatingComplement = System.currentTimeMillis();
			
			RuleApplication subRRApplication = recognitionMatches.get(scs);
			Rule subRRUnit = subRRApplication.getRule();
			Match subRRMatch = subRRApplication.getCompleteMatch();
			
			EditRule subEditRule = recognition2editRules.get(subRRUnit);
			Rule subEOUnit = (Rule) subEditRule.getExecuteMainUnit().getSubUnits(false).get(0);
			
			assert subEditRules.contains(subEOUnit);
				
			// Translate recognition to edit rule matching:
			List<RecognitionMatch> subEOMatch = matchConverter.createEditRuleMatch(subEditRule, subEOUnit, subRRMatch);

			// Calculate complements for corresponding source rule:
			for (Rule sourceEditRule : embeddings.getSuperRules(subEOUnit)) {
				Collection<ComplementRule> newSourceComplements = findComplementRule(sourceEditRule, subEOUnit, subEOMatch);

				if ((newSourceComplements != null) && (!newSourceComplements.isEmpty())) {
					Collection<ComplementRule> sourceComplements = complements.get(sourceEditRule);

					if (sourceComplements == null) {
						sourceComplements = new ArrayList<>();
					}

					sourceComplements.addAll(newSourceComplements);
					complements.put(sourceEditRule, sourceComplements);
				}
			}
			
			if (DebugUtil.statistic) {
				System.out.println("--------------------------------------");
				System.out.println("Complements for Sub-EO (" + subEOUnit.getName() + "):" + (System.currentTimeMillis() - calculatingComplement) + "ms");
				System.out.println("--------------------------------------");
			}
		}
	}
	
	/**
	 * @return Recognition-Rule -> Edit-Rules
	 */
	private Map<Rule, EditRule> getRecognition2EditRules() {
		Map<Rule, EditRule> editRules = new HashMap<>();
		
		for (RuleBaseItem item : subRulebase.getRuleBase().getItems()) {
			editRules.put((Rule) item.getEditRuleAttachment(
					RecognitionRule.class).getRecognitionMainUnit(),
					item.getEditRule());
		}
		
		return editRules;
	}
	
	private Map<SemanticChangeSet, RuleApplication> getRecognitionMatches(
			Collection<RuleApplication> ruleApplications) {
		
		Map<SemanticChangeSet, RuleApplication> rrMatches = new HashMap<>();
		
		for (RuleApplication ruleApplication : ruleApplications) {
			rrMatches.put(getSemanticChangeSet(ruleApplication), ruleApplication);
		}
		
		return rrMatches;
	}
	
	private SemanticChangeSet getSemanticChangeSet(RuleApplication recognitionRuleApp) {
		Collection<EObject> values = recognitionRuleApp.getResultMatch().getNodeTargets();
		
		for (EObject eObject : values) {
			if (eObject instanceof SemanticChangeSet) {
				return (SemanticChangeSet) eObject;
			}
		}

		return null;
	}
	
	public Collection<Rule> getSourceRules() {
		return complements.keySet();
	}

	public Collection<ComplementRule> getComplementRules(Rule cpEditRule) {
		return complements.getOrDefault(cpEditRule, Collections.emptySet());
	}
	
	public Collection<ComplementRule> findComplementRule(Rule sourceRule, Rule subRule, Collection<RecognitionMatch> subRuleMatch) {
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
			List<RecognitionMatch> superRuleMatch = convertToPartialMatch(embedding, subRuleMatch);

			if (DebugUtil.isActive) {
				LogUtil.log(LogEvent.NOTICE, "\nSource-Rule: " + sourceRule.getName());
				LogUtil.log(LogEvent.NOTICE,
						"\nCPO-Match (partial): \n\n" + ComplementUtil.printEditRuleMatch(superRuleMatch));
			}

			// Create the complement = super - sub:
			ComplementRule complementRule = complementConstructor.createComplementRule(sourceRule, superRuleMatch);

			if (complementRule != null) {
				complementRules.add(complementRule);
			}
		}

		return complementRules;
	}

	private List<RecognitionMatch> convertToPartialMatch(RuleEmbedding embedding, Collection<RecognitionMatch> subEditRuleMatching) {

		List<RecognitionMatch> superEditRuleMatch = new ArrayList<>();

		for (RecognitionMatch subEditRuleMatch : subEditRuleMatching) {

			// Node-Matches:
			if (subEditRuleMatch instanceof RecognitionNodeMatch) {
				Node subRuleNode = ((RecognitionNodeMatch) subEditRuleMatch).getNode();
				Node superRuleNode = embedding.getSuperRuleNode(subRuleNode);

				if (subEditRuleMatch instanceof RecognitionNodeSingleMatch) {
					EObject matchA = ((RecognitionNodeSingleMatch) subEditRuleMatch).getModelAElement();
					EObject matchB = ((RecognitionNodeSingleMatch) subEditRuleMatch).getModelBElement();

					RecognitionNodeSingleMatch superEditRuleNodeMatch = new RecognitionNodeSingleMatch(
							((RecognitionNodeSingleMatch) subEditRuleMatch).getAction(), superRuleNode);
					superEditRuleNodeMatch.setModelAElement(matchA);
					superEditRuleNodeMatch.setModelBElement(matchB);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}

				else if (subEditRuleMatch instanceof RecognitionNodeMultiMatch) {
					List<EObject> matchesA = ((RecognitionNodeMultiMatch) subEditRuleMatch).getModelAElements();
					List<EObject> matchesB = ((RecognitionNodeMultiMatch) subEditRuleMatch).getModelBElements();

					RecognitionNodeMultiMatch superEditRuleNodeMatch = new RecognitionNodeMultiMatch(
							((RecognitionNodeMultiMatch) subEditRuleMatch).getAction(), superRuleNode);
					superEditRuleNodeMatch.setModelAElements(matchesA);
					superEditRuleNodeMatch.setModelBElements(matchesB);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}
			}

			// Attribute-Matches:
			if (subEditRuleMatch instanceof RecognitionAttributeMatch) {
				Attribute subRuleAttribute = ((RecognitionAttributeMatch) subEditRuleMatch).getAttribute();
				EObject object = ((RecognitionAttributeMatch) subEditRuleMatch).getObject();
				Object value = ((RecognitionAttributeMatch) subEditRuleMatch).getValue();
				Node subRuleNode = getLHS(subRuleAttribute.getNode());

				Attribute superRuleAttribute = getRHS(embedding.getSuperRuleNode(subRuleNode))
						.getAttribute(subRuleAttribute.getType());

				RecognitionAttributeMatch superEditRuleAttributeMatch = new RecognitionAttributeMatch(superRuleAttribute, object, value);
				superEditRuleMatch.add(superEditRuleAttributeMatch);
			}

			// Edge-Matches:
			else if (subEditRuleMatch instanceof RecognitionEdgeMatch) {
				Edge subRuleEdge = ((RecognitionEdgeMatch) subEditRuleMatch).getEdge();
				Edge superRuleEdge = embedding.getSuperRuleEdge(subRuleEdge);

				assert (superRuleEdge != null);

				EObject srcMatchA = ((RecognitionEdgeMatch) subEditRuleMatch).getSrcModelAElement();
				EObject tgtMatchA = ((RecognitionEdgeMatch) subEditRuleMatch).getTgtModelAElement();

				EObject srcMatchB = ((RecognitionEdgeMatch) subEditRuleMatch).getSrcModelBElement();
				EObject tgtMatchB = ((RecognitionEdgeMatch) subEditRuleMatch).getTgtModelBElement();

				RecognitionEdgeMatch superEditRuleNodeMatch = new RecognitionEdgeMatch(((RecognitionEdgeMatch) subEditRuleMatch).getAction(),
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
	
	public List<Match> findComplementMatches(ComplementRule complement) {
		Rule complementRule = complement.getComplementRule();
		long parameterMatching = System.currentTimeMillis();
		
		// Create complement pre-match by partial source-rule match:
		Match complementPreMatche = new MatchImpl(complementRule);
		
		for (RecognitionMatch sourceMatch : complement.getRecognitionMatch()) {
			
			// NOTE: The matching unambiguously in CPO approach (regarding EditRuleNodeMultiMatch):
			if (sourceMatch instanceof RecognitionNodeSingleMatch) {
				RecognitionNodeSingleMatch nodeMatch = (RecognitionNodeSingleMatch) sourceMatch;
				
				// Collect all << create >> and << preserve >> node matches:
				if (!nodeMatch.getAction().equals(Type.DELETE)) {
					Node complementNode = getLHS(complement.getTrace(nodeMatch.getNode()));
					
					if (complementNode != null) {
						complementPreMatche.setNodeTarget(complementNode, nodeMatch.getModelBElement());
						
//						if (isPreservedNode(complementNode) && (nodeMatch.getModelBElement() == null)) {
//							return Collections.emptyList();
//						}
					}
				}
			}
		}
		
		// FIXME !?
//		assert (complementPreMatche.getNodeTargets().size() != 0);
		
		if (complementPreMatche.getNodeTargets().size() != 0) {
			
			// Check context rule (with restricted working graph):
			ArrayList<Match> complementMatches = new ArrayList<>();
			Iterator<Match> matchFinder = engine.findMatches(complementRule, graphModelB, complementPreMatche).iterator();
			
			while (matchFinder.hasNext()) {
				Match nextMatch = matchFinder.next();
				
				// Create complement pre-match:
				complementMatches.add(nextMatch);
			}
			
			if (DebugUtil.statistic) {
				System.out.println("Parameter Matching (" + complementRule.getName() + "): " + (System.currentTimeMillis() - parameterMatching) + "ms");
			}
			
			complementMatches.trimToSize();
			return complementMatches;
		}
		
		return Collections.emptyList();
	}
}
