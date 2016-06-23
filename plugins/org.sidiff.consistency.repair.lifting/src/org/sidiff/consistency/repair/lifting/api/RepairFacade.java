package org.sidiff.consistency.repair.lifting.api;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
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
	 * @param modelA
	 *            The historic model.
	 * @param modelB
	 *            The actual model.
	 * @param editRules
	 *            All edit-rules which are to be investigated for partial executions.
	 * @param settings
	 *            The settings for the difference calculation.
	 * @return All found repairs pre edit-rule.
	 */
	public static Map<Rule, List<Repair>> getRepairs(
			URI modelA, URI modelB, Collection<Rule> editRules, DifferenceSettings settings) {
		
		// Initialize:
		Map<Rule, List<Repair>> repairs = new LinkedHashMap<>();
		
		Resource modelAResource = EMFStorage.eLoad(modelA).eResource();
		Resource modelBResource = EMFStorage.eLoad(modelB).eResource();
		
		// Calculate difference:
		SymmetricDifference difference = null;
		
		try {
			difference = deriveTechnicalDifference(modelAResource, modelBResource, settings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		// Calculate repairs:
		ComplementFinder complementFinder = new ComplementFinder(modelAResource, modelBResource, difference);
		
		for (Rule editRule : editRules) {
			List<Repair> repairsPerRule = new ArrayList<>();
			repairs.put(editRule, repairsPerRule);
			
			for(ComplementRule complement : complementFinder.searchComplementRules(editRule)) {
				for (ComplementMatch preMatch : complement.getComplementPreMatches()) {
					repairsPerRule.add(new Repair(complement, preMatch));
				}
			}
		}
		
		return repairs;
	}
}
