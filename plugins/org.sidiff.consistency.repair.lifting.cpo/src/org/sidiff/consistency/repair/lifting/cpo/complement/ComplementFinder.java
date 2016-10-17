package org.sidiff.consistency.repair.lifting.cpo.complement;

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
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.cpo.CPOComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.difference.lifting.recognitionengine.IRecognitionEngine;
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

	private IRecognitionEngine recognitionEngine;
	
	private ILiftingRuleBase subRulebase;
	
	private Collection<Rule> subEditRules;
	
	private Collection<Rule> sourceEditRules;
	
	private SymmetricDifference difference;
	
	private Map<Rule, Collection<ComplementRule>> complements = new HashMap<>();

	public ComplementFinder(
			IRecognitionEngine recognitionEngine,
			ILiftingRuleBase subRulebase,
			Collection<Rule> subEditRules, 
			Collection<Rule> sourceEditRules,
			SymmetricDifference difference,
			EGraph graphModelB) {
		
		this.recognitionEngine = recognitionEngine;
		this.subRulebase = subRulebase;
		this.subEditRules = subEditRules;
		this.sourceEditRules = sourceEditRules;
		this.difference = difference;
		
		this.graphModelB = graphModelB;
		this.engine = new EngineImpl();
		
		calculateComplementRules();
	}
	
	private void calculateComplementRules() {
		
		// Get mappings: SCS -> RR + Match -> EO
		Set<RuleApplication> ruleApplications = recognitionEngine.getRecognitionRuleApplications();
		Map<SemanticChangeSet, RuleApplication>  recognitionMatches = getRecognitionMatches(ruleApplications);
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
			
			// Is sub-rule (source-rule otherwise)
			// TODO: change if to an assertion
			if (subEditRules.contains(subEOUnit)) {
				
				
				// Translate recognition to edit rule matching:
				List<EditRuleMatch> subEOMatch = matchConverter.createEditRuleMatch(subEditRule, subEOUnit, subRRMatch);
				
				// FIXME: Filter sub-rules that are embedded in sub-rules!
				// TODO[Precalculate]: Find corresponding source rule:
				for (Rule sourceEditRule : sourceEditRules) {
					CPOComplementConstructor complementConstructor = new CPOComplementConstructor(
							sourceEditRule, engine, graphModelB);

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
