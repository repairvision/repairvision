package org.sidiff.consistency.repair.lifting.cpo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.api.RepairJob;
import org.sidiff.consistency.repair.lifting.cpo.complement.ComplementFinder;
import org.sidiff.consistency.repair.lifting.cpo.lifting.BasicCPOLifting;
import org.sidiff.consistency.repair.lifting.cpo.lifting.FragmentedCPOLifting;
import org.sidiff.consistency.repair.lifting.cpo.util.StatisticUtil;
import org.sidiff.difference.lifting.recognitionengine.IRecognitionEngine;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class CPORepairFacade {
	
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
		
		// Load models:
		long startLoadModels = System.currentTimeMillis();
		
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);
		
		if (DebugUtil.statistic) {
			System.out.println("#DONE# Loading Models: " + (System.currentTimeMillis() - startLoadModels) + "ms");
		}
		
		return getRepairs(modelA, modelB, subEditRules, cpEditRules, documentType, settings);
	}
	
	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param modelA
	 *            The historic model.
	 * @param modelB
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
			Resource modelA, Resource modelB, 
			Collection<Rule> subEditRules, Collection<Rule> cpEditRules, 
			String documentType, DifferenceSettings settings) {
		
		long repairJobTime = System.currentTimeMillis();
		
		// Initialize:
		assert (modelA.getResourceSet() == modelB.getResourceSet());
		ResourceSet differenceRSS = modelA.getResourceSet(); 
		
		// TODO: Create fresh resource set!?
		// [Workaround] (Cleanup) Remove old difference:
		for (Iterator<Resource> it = differenceRSS.getResources().iterator(); it.hasNext();) {
			Resource res = it.next();
			
			if (res instanceof SymmetricDifference) {
				it.remove();
			}
		}
		
		// Calculate difference:
		BasicCPOLifting lifting = new FragmentedCPOLifting();
		lifting.findSubEditRules(modelA, modelB, subEditRules, cpEditRules, documentType, settings);
		
		SymmetricDifference difference = lifting.getDifference();
		IRecognitionEngine recognitionEngine = lifting.getRecognitionEngine();
		ILiftingRuleBase rulebases_sub = lifting.getRulebasesSub();
		
		// TODO: if (difference.getChangeSets().size() > 0) 
			
		// TODO: Support differences without resource...
		Resource differenceResource = differenceRSS.createResource(URI.createURI(""));
		differenceResource.getContents().add(difference);
		
		// Repair application:
		EngineImpl henshinEngine = new EngineImpl();
		
		// Use the graph of the recognition engine or with merged imports!
		EGraph modelBGraph = recognitionEngine.getGraphModelB();
		
		// Calculate repairs:
		long calculateComplements = System.currentTimeMillis();
		
		ComplementFinder complementFinder = new ComplementFinder(
				recognitionEngine, rulebases_sub, subEditRules, cpEditRules, 
				difference, modelBGraph);
		
		Map<Rule, List<Repair>> repairs = new LinkedHashMap<>();
		
		if (DebugUtil.statistic) {
			System.out.println("#DONE# Complement Calculation: " + (System.currentTimeMillis() - calculateComplements) + "ms");
		}
		
		long calculateRepairs = System.currentTimeMillis();
		
		for (Rule cpEditRule : complementFinder.getSourceRules()) {
			List<Repair> repairsPerRule = new ArrayList<>();

			for(ComplementRule complement : complementFinder.getComplementRules(cpEditRule)) {
				if (complement.getComplementingChanges().size() > 0) {
					for (ComplementMatch preMatch : complement.getComplementMatches()) {
						repairsPerRule.add(new Repair(complement, preMatch));
					}
					complement.initialize(henshinEngine, modelBGraph);
				}
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

		if (DebugUtil.statistic) {
			System.out.println("#DONE# Calculate Repairs: " + (System.currentTimeMillis() - calculateRepairs) + "ms");
			System.out.println("#DONE# Full Repair Job: " + (System.currentTimeMillis() - repairJobTime) + "ms");
			
			StatisticUtil.analyzeSetup(subEditRules, cpEditRules, difference);
		}
		
		return repairJob;
	}
}
