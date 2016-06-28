package org.sidiff.consistency.repair.lifting.api;

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
			URI uriModelA, URI uriModelB, Collection<Rule> editRules, DifferenceSettings settings) {
		
		// Initialize:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);
		
//		// TODO: Remove this....
//		URI diffURI = URI.createFileURI("D:/Workspace/SiLift/org.sidiff.consistency.graphpattern.testmodels/models/M0001-PulUpAttribute/M0001A_x_M0001B_EMFCompare_technical.symmetric");
//		SymmetricDifference difference = (SymmetricDifference)differenceRSS.getResource(diffURI, true).getContents().get(0);
		
		// Calculate difference:
		SymmetricDifference difference = null;
		
		try {
			difference = deriveTechnicalDifference(modelA, modelB, settings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		// FIXME [WORKAROUND]: Support differences without resource...
		Resource differenceResource = differenceRSS.createResource(URI.createURI("NA"));
		differenceResource.getContents().add(difference);
		
		// Calculate repairs:
		ComplementFinder complementFinder = new ComplementFinder(modelA, modelB, difference);
		Map<Rule, List<Repair>> repairs = new LinkedHashMap<>();
		
		for (Rule editRule : editRules) {
			List<Repair> repairsPerRule = new ArrayList<>();
			
			for(ComplementRule complement : complementFinder.searchComplementRules(editRule)) {
				for (ComplementMatch preMatch : complement.getComplementPreMatches()) {
					repairsPerRule.add(new Repair(complement, preMatch));
				}
			}
			
			if (!repairsPerRule.isEmpty()) {
				repairs.put(editRule, repairsPerRule);
			}
		}
		
		return repairs;
	}
}
