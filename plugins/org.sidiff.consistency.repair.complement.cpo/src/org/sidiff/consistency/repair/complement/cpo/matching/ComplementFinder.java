package org.sidiff.consistency.repair.complement.cpo.matching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.api.matching.EOMatch;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.cpo.construction.CPOComplementConstructor;
import org.sidiff.consistency.repair.complement.cpo.embedding.EmbeddingRulebase;
import org.sidiff.difference.rulebase.RecognitionRule;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.RuleBaseItem;

public class ComplementFinder {
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;

	/**
	 * The working graph, i.e. the actual version of the model.
	 */
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
			List<EOMatch> subEOMatch = matchConverter.createEditRuleMatch(subEditRule, subEOUnit, subRRMatch);

			// Calculate complements for corresponding source rule:
			for (Rule sourceEditRule : embeddings.getSuperRules(subEOUnit)) {
				CPOComplementConstructor complementConstructor = new CPOComplementConstructor(
						sourceEditRule, embeddings, engine, graphModelB);

				Collection<ComplementRule> newSourceComplements = complementConstructor
						.createComplementRule(subEOUnit, subEOMatch);

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
}
