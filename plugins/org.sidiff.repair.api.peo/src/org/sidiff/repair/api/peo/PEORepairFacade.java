package org.sidiff.repair.api.peo;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getChanges;
import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.peo.finder.AbstractRepairFilter;
import org.sidiff.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.repair.complement.repair.RepairOperation;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.api.util.RepairAPIUtil;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class PEORepairFacade implements IRepairFacade<PEORepairJob, PEORepairSettings> {

	@Override
	public PEORepairJob getRepairs(URI uriModelA, URI uriModelB, PEORepairSettings settings) {
		
		// Initialize:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);
	
		return getRepairs(modelA, modelB, settings);
	}
	
	@Override
	public PEORepairJob getRepairs(Resource modelA, Resource modelB, PEORepairSettings settings) {
		
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
		SymmetricDifference difference = null;
		
		try {
			difference = deriveTechnicalDifference(modelA, modelB, settings.getDifferenceSettings());
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		Resource differenceResource = differenceRSS.createResource(
				RepairAPIUtil.getDifferenceURI(modelA.getURI(), modelB.getURI()));
		differenceResource.getContents().add(difference);
		
		if (settings.saveDifference()) {
			try {
				differenceResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Validate model and calculate abstract repairs:
		AbstractRepairFilter repairFilter = new AbstractRepairFilter(modelB, true);
		
		// Calculate repairs:
		ComplementFinder complementFinder = createComplementFinder(modelA, modelB, difference);
		complementFinder.setSaveRecognitionRule(settings.saveRecognitionRules());
		
		Map<Rule, List<IRepair>> repairs = new LinkedHashMap<>();
		
		for (Rule editRule : settings.getEditRules()) {
			
			// Filter edit-rules by abstract repairs:
			if (repairFilter.filter(getChanges(editRule))) {
				List<IRepair> repairsPerRule = new ArrayList<>();
				
				for(ComplementRule complement : complementFinder.searchComplementRules(editRule)) {
					if (complement.getComplementingChanges().size() > 0) {
						
						// Filter complements by abstract repairs:
						if (repairFilter.filter(complement.getComplementingChanges())) {
							for (EditOperationMatching preMatch : complement.getComplementMatches()) {
								
								// Filter complement with pre-match by abstract repairs:
								if (repairFilter.filter(complement.getComplementingChanges(), preMatch)) {
									repairsPerRule.add(new RepairOperation(complement, preMatch));
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
		PEORepairJob repairJob = new PEORepairJob();
		repairJob.setDifference(differenceResource);
		repairJob.setModelA(modelA);
		repairJob.setModelB(modelB);
		repairJob.setRepairs(repairs);
		repairJob.setValidations(repairFilter.getValidations());
		
		return repairJob;
	}
	
	protected abstract ComplementFinder createComplementFinder(
			Resource modelAResource, Resource modelBResource, SymmetricDifference difference);
}
