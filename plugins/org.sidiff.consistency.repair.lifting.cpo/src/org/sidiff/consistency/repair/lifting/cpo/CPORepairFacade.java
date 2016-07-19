package org.sidiff.consistency.repair.lifting.cpo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.henshin.HenshinModuleAnalysis;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.api.RepairJob;
import org.sidiff.consistency.repair.lifting.cpo.complement.ComplementFinder;
import org.sidiff.difference.lifting.api.LiftingFacade;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.lifting.recognitionengine.ruleapplication.RecognitionEngine;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.rulebase.view.LiftingRuleBase;
import org.sidiff.difference.rulebase.wrapper.EditWrapper2RecognitionWrapper;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.RuleBase;
import org.sidiff.editrule.rulebase.RuleBaseItem;
import org.sidiff.editrule.rulebase.RulebaseFactory;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class CPORepairFacade {

	private static class CPOLiftingFacade extends  LiftingFacade {
		public static RecognitionEngine getRecognitionEngine() {
			return recognitionEngine;
		}
	}
	
	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param uriModelA
	 *            The historic model.
	 * @param uriModelB
	 *            The actual model.
	 * @param subEditRules
	 *            All edit-rules which are to be investigated for partial executions.
	 * @param cpEditRules
	 *            All consistency-preserving edit-operations.
	 * @param documentType
	 * @param settings
	 *            The settings for the difference calculation.
	 * @return All found repairs.
	 */
	public static RepairJob getRepairs(
			URI uriModelA, URI uriModelB, 
			Collection<Rule> subEditRules, Collection<Rule> cpEditRules, 
			String documentType, DifferenceSettings settings) {
		
		// Initialize:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);

		// Create a (temporary) sub-edit-rule rulebase:
		Set<ILiftingRuleBase> ruleBases = new HashSet<>();
		ILiftingRuleBase subEditRuleBase = createRuleBase(subEditRules); 
		ruleBases.add(subEditRuleBase);
		
		// Calculate difference:
		SymmetricDifference difference = null;
		RecognitionEngine recognitionEngine = null;
		
		try {
			// Calculate lifted difference:
			LiftingSettings liftingSettings = new LiftingSettings(Collections.singleton(documentType));
			liftingSettings.setMatcher(settings.getMatcher());
			liftingSettings.setRuleBases(ruleBases);
			liftingSettings.setCalculateEditRuleMatch(false);
			difference = CPOLiftingFacade.liftTechnicalDifference(modelA, modelB, liftingSettings);
			
			// Save used recognition engine:
			recognitionEngine = CPOLiftingFacade.getRecognitionEngine();
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		// TODO: Support differences without resource...
		Resource differenceResource = differenceRSS.createResource(URI.createURI(""));
		differenceResource.getContents().add(difference);
		
		// Repair application:
		EngineImpl henshinEngine = new EngineImpl();
		
		// FIXME: Use the graph of the recognition engine or with merged imports!
		EGraph modelBGraph = new EGraphImpl(modelB);
		
		// Calculate repairs:
		ComplementFinder complementFinder = new ComplementFinder(
				subEditRuleBase, recognitionEngine, cpEditRules, difference);
		Map<Rule, List<Repair>> repairs = new LinkedHashMap<>();
		
		for (Rule cpEditRule : complementFinder.getSourceRules()) {
			List<Repair> repairsPerRule = new ArrayList<>();

			for(ComplementRule complement : complementFinder.getComplementRules(cpEditRule)) {
				for (ComplementMatch preMatch : complement.getComplementPreMatches()) {
					repairsPerRule.add(new Repair(complement, preMatch));
				}
				complement.initialize(henshinEngine, modelBGraph);
			}

			if (!repairsPerRule.isEmpty()) {
				repairs.put(cpEditRule, repairsPerRule);
			}
		}

		// Create repair job:
		RepairJob repairJob = new RepairJob();
		repairJob.setDifference(differenceResource);
		repairJob.setModelA(modelA);
		repairJob.setModelB(modelB);
		repairJob.setRepairs(repairs);
		// repairJob.setValidations(); // TODO: Add a common interface...

		return repairJob;
	}
	
	private static LiftingRuleBase createRuleBase(Collection<Rule> editRules) {
		LiftingRuleBase rulebaseView = new LiftingRuleBase();
		
		RuleBase rulebase = RulebaseFactory.eINSTANCE.createRuleBase();
		rulebase.setName("Sub-Edit-Rules");
		rulebaseView.init(rulebase);
		
		for (Rule subEditRule : editRules) {

			// Add edit rule:
			EditRule editRuleWrapper = createEditRule(subEditRule.getModule());
			RuleBaseItem rulebaseItem = createItem(editRuleWrapper);
			rulebase.getItems().add(rulebaseItem);

			// Transform edit- to recognition-rule:
			try {
				EditWrapper2RecognitionWrapper edit2Recognition = new EditWrapper2RecognitionWrapper();
				edit2Recognition.transform(rulebaseItem);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return rulebaseView;
	}
	
	/**
	 * Initializes a rule base edit rule wrapper.
	 * 
	 * @return an edit rule wrapper.
	 * @throws NoMainUnitFoundException 
	 */
	private static EditRule createEditRule(Module editModule) {

		// Create edit rule
		try {
			EditRule editRule = RulebaseFactory.eINSTANCE.createEditRule();
			editRule.setExecuteMainUnit(HenshinUnitAnalysis.findExecuteMainUnit(editModule));
			editRule.setUseDerivedFeatures(HenshinModuleAnalysis.hasDerivedReferences(editModule));
			
			return editRule;
		} catch (NoMainUnitFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Creates a new rule base item which includes an edit rule.
	 * 
	 * @param editRule
	 *            The Henshin edit-rule.
	 * 
	 * @return A new rule base item.
	 */
	private static RuleBaseItem createItem(EditRule editRule) {
		
		// Create rule base element
		RuleBaseItem item = RulebaseFactory.eINSTANCE.createRuleBaseItem();
		item.setEditRule(editRule);
		
		return item;
	}
}
