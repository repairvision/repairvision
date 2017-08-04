package org.sidiff.repair.api.peo;

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
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.complement.ComplementFinder;
import org.sidiff.editrule.partialmatcher.scope.RepairActionFilter;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.repair.RepairOperation;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class PEORepairFacade implements IRepairFacade<PEORepairJob, PEORepairSettings> {

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
		
		// Disable merge imports:
		settings.getDifferenceSettings().setMergeImports(false);
		
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
		
		long start = System.currentTimeMillis();
		try {
			difference = deriveTechnicalDifference(modelA, modelB, settings.getDifferenceSettings());
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		System.out.println("EVALUATION[Difference]: " + (System.currentTimeMillis() - start) + "ms");
		
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
		
		// Calculate repairs:
		return getRepairs(difference, settings);
	}
	
	public PEORepairJob getRepairs(SymmetricDifference difference, PEORepairSettings settings) {
		Resource modelA = difference.getModelA();
		Resource modelB = difference.getModelB();
		
		// Validate model and calculate abstract repairs:
		long start = System.currentTimeMillis();
		RepairActionFilter repairFilter = new RepairActionFilter(modelB, true);
		System.out.println("EVALUATION[Validierung]: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println("EVALUATION[Validierung]: " + repairFilter.getValidations().size() + " Validierungen");
		
		// Calculate repairs:
		ComplementFinder complementFinder = createComplementFinder(modelA, modelB, difference);
		complementFinder.setSaveRecognitionRule(settings.saveRecognitionRules());
		complementFinder.start();
		
		Map<Rule, List<IRepairPlan>> repairs = new LinkedHashMap<>();
		int repairCount = 0;
		
//		for (Rule editRule : settings.getEditRules()) {
//			
//			// Filter edit-rules by abstract repairs:
//			if (repairFilter.filter(ChangePatternUtil.getChanges(editRule))) {
//				List<IRepair> repairsPerRule = new ArrayList<>();
//				
//				for(ComplementRule complement : complementFinder.searchComplementRules(editRule)) {
//					if (complement.getComplementingChanges().size() > 0) {
//						
//						// Filter complements by abstract repairs:
//						if (repairFilter.filter(complement.getComplementingChanges())) {
//							for (EditOperationMatching preMatch : complement.getComplementMatches()) {
//								
//								// Filter complement with pre-match by abstract repairs:
//								if (repairFilter.filter(complement.getComplementingChanges(), preMatch)) {
//									repairCount++;
//									repairsPerRule.add(new RepairOperation(complement, preMatch));
//								}
//							}
//						}
//					}
//				}
//				
//				if (!repairsPerRule.isEmpty()) {
//					repairs.put(editRule, repairsPerRule);
//				}
//			}
//		}
		
		for (Rule editRule : settings.getEditRules()) {
			
			// Filter edit-rules by abstract repairs:
			RepairScope scope = repairFilter.getScope(ChangePatternUtil.getPotentialChanges(editRule));
			
			if (!scope.isEmpty()) {
				for(ComplementRule complement : complementFinder.searchComplementRules(editRule, scope)) {
					List<IRepairPlan> repairsPerComplementRule = new ArrayList<>();

					if (complement.getComplementingChanges().size() > 0) {

						// Filter complements by abstract repairs:
						if (repairFilter.filter(complement.getComplementingChanges())) {
							for (EditOperationMatching preMatch : complement.getComplementMatches()) {

								// Filter complement with pre-match by abstract repairs:
								if (repairFilter.filter(complement.getComplementingChanges(), preMatch)) {
									repairCount++;
									repairsPerComplementRule.add(new RepairOperation(complement, preMatch));
								}
							}
						}
					}
					
					if (!repairsPerComplementRule.isEmpty()) {
						repairs.put(complement.getComplementRule(), repairsPerComplementRule);
					}
				}
			}
		}

		complementFinder.finish();
		
		System.out.println("###Repair Count: " + repairCount);
		
		// Create repair job:
		PEORepairJob repairJob = new PEORepairJob();
		repairJob.setDifference(difference.eResource());
		repairJob.setModelA(modelA);
		repairJob.setModelB(modelB);
		repairJob.setRepairs(repairs);
		repairJob.setValidations(repairFilter.getValidations());
		
		return repairJob;
	}
	
	protected ComplementFinder createComplementFinder(
			Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		return new ComplementFinder(modelAResource, modelBResource, difference);
	}
}
