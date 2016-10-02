package org.sidiff.consistency.repair.lifting.api;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getChanges;
import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.lifting.complement.AbstractRepairFilter;
import org.sidiff.consistency.repair.lifting.complement.ComplementFinder;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairFacade {

	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param uriModelA
	 *            The historic model.
	 * @param uriModelB
	 *            The actual model.
	 * @param editRules
	 *            All edit-rules which are to be investigated for partial executions.
	 * @param settings
	 *            The settings for the difference calculation.
	 * @return All found repairs.
	 */
	public static RepairJob getRepairs(
			URI uriModelA, URI uriModelB, Collection<Rule> editRules, DifferenceSettings settings) {
		
		// Initialize:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);

		// Calculate difference:
		SymmetricDifference difference = null;
		
		try {
			difference = deriveTechnicalDifference(modelA, modelB, settings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		// TODO: Support differences without resource...
		Resource differenceResource = differenceRSS.createResource(URI.createURI(""));
		differenceResource.getContents().add(difference);
		
		// Validate model and calculate abstract repairs:
		AbstractRepairFilter repairFilter = new AbstractRepairFilter(modelB, true);
		
		// Calculate repairs:
		ComplementFinder complementFinder = new ComplementFinder(modelA, modelB, difference);
		Map<Rule, List<Repair>> repairs = new LinkedHashMap<>();
		
		for (Rule editRule : editRules) {
			
			// Filter edit-rules by abstract repairs:
			if (repairFilter.filter(getChanges(editRule))) {
				List<Repair> repairsPerRule = new ArrayList<>();
				
				for(ComplementRule complement : complementFinder.searchComplementRules(editRule)) {
					if (complement.getComplementingChanges().size() > 0) {
						
						// Filter complements by abstract repairs:
						if (repairFilter.filter(complement.getComplementingChanges())) {
							for (ComplementMatch preMatch : complement.getComplementMatches()) {
								
								// Filter complement with pre-match by abstract repairs:
								if (repairFilter.filter(complement.getComplementingChanges(), preMatch.getNodeMatches())) {
									repairsPerRule.add(new Repair(complement, preMatch));
								}
							}
						}
					}
				}
				
				if (!repairsPerRule.isEmpty()) {
					repairs.put(editRule, repairsPerRule);
				}
			}
		}
		
		// Create repair job:
		RepairJob repairJob = new RepairJob();
		repairJob.setDifference(differenceResource);
		repairJob.setModelA(modelA);
		repairJob.setModelB(modelB);
		repairJob.setRepairs(repairs);
		repairJob.setValidations(repairFilter.getValidations());
		
		return repairJob;
	}
}
