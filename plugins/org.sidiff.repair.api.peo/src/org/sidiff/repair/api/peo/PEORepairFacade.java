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
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.complement.ComplementFinder;
import org.sidiff.editrule.partialmatcher.scope.RepairActionFilter;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.editrule.partialmatcher.scope.SettingAttributeFilter;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
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
		return getRepairs(calculateDifference(modelA, modelB, settings), settings);
	}
	
	public SymmetricDifference calculateDifference(Resource modelA, Resource modelB, PEORepairSettings settings) {
		
		// Disable merge imports:
		// FIXME: setMergeImports(true) -> Wrong technical difference for EGenericTypes!
		settings.getDifferenceSettings().setMergeImports(false);
//		settings.getDifferenceSettings().setScope(Scope.RESOURCE);
		
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
		
		LogTime diffTimer = new LogTime();
		try {
			difference = deriveTechnicalDifference(modelA, modelB, settings.getDifferenceSettings());
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		diffTimer.stop();
		System.out.println("Re.Vision[Difference Time]: " + diffTimer + "ms");
		
		// Report:
		if (settings.getMonitor() instanceof LogMonitor) {
			LogTable log = ((LogMonitor) settings.getMonitor()).getLog();
			log.append("[Time (ms)] Calculate Difference", diffTimer);
			log.append("Change Count (Historical->Resolved)", difference.getChanges().size());
		}
		
		// Create difference resource:
		Resource differenceResource = differenceRSS.createResource(
				RepairAPIUtil.getDifferenceURI(modelA.getURI(), modelB.getURI()));
		differenceResource.getContents().add(difference);
		
		if (settings.saveDifference()) {
			try {
				differenceResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
		
		return difference;
	}
	
	public PEORepairJob getRepairs(SymmetricDifference difference, PEORepairSettings settings) {
		Resource modelA = difference.getModelA();
		Resource modelB = difference.getModelB();
		
		// Setup consistency rules?
		if (settings.getConsistencyRules() == null) {
			settings.setupConsistencyRules(difference.getModelB());
		}
		
		// Validate model and calculate abstract repairs:
		LogTime valiationTimer = new LogTime();
		
		RepairActionFilter repairFilter = new RepairActionFilter(modelB, 
				settings.getConsistencyRules(), settings.getValidationFilter(), true);
		
		valiationTimer.stop();
		System.out.println("Re.Vision[Validation Time]: " + valiationTimer + "ms");
		System.out.println("Re.Vision[Inconsistencies]: " + repairFilter.getValidations().size());

		// Report validation:
		if (settings.getMonitor() instanceof LogMonitor) {
			LogTable log = ((LogMonitor) settings.getMonitor()).getLog();
//			log.append("[Time (ms)] Validation", valiationTimer);
			log.append("Inconsistencies", repairFilter.getValidations().size());
		}
		
		// Calculate repairs:
		ComplementFinder complementFinder = createComplementFinder(modelA, modelB, difference);
		complementFinder.setSaveRecognitionRule(settings.saveRecognitionRules());
		complementFinder.start();
		
		Map<Rule, List<IRepairPlan>> repairs = new LinkedHashMap<>();
		
		LogTime complementMatchingTimer = new LogTime();
		int potentialEditRules = 0;
		int complementingEditRules = 0;
		int repairCount = 0;
		
		for (Rule editRule : settings.getEditRules()) {
			
			// Filter edit-rules by abstract repairs:
			RepairScope scope = repairFilter.getScope(ChangePatternUtil.getPotentialChanges(editRule));
			
			if (!scope.isEmpty()) {
				List<ComplementRule> complements = complementFinder.searchComplementRules(
						settings.getMonitor(), settings.getRuntimeComlexityLog(), editRule, scope);
				++potentialEditRules;
				
				for(ComplementRule complement : complements) {
					List<IRepairPlan> repairsPerComplementRule = new ArrayList<>();

					// Filter complements by abstract repairs:
					if (complement.getComplementingChanges().size() > 0) {
						if (repairFilter.filter(complement.getComplementingChanges())) {
							complementMatchingTimer.start();
							List<EditOperationMatching> preMatches = complement.getComplementMatches();
							complementMatchingTimer.stop();
							
							for (EditOperationMatching preMatch : preMatches) {
								
								// Filter setting attributes that do not overlap with an repair action:
								filterSettingAttributes(complement, preMatch, repairFilter);
								
								// Filter complement with pre-match by abstract repairs:
								if (repairFilter.filter(complement.getComplementingChanges(), preMatch.getMatch())) {
									repairsPerComplementRule.add(new RepairOperation(complement, preMatch));
									++repairCount;
								}
							}
						}
					}
					
					if (!repairsPerComplementRule.isEmpty()) {
						repairs.put(complement.getComplementRule(), repairsPerComplementRule);
						
						// Report complements:
						++complementingEditRules;
					}
				}
			}
		}

		complementFinder.finish();
		
		// Report:
		System.out.println("Re.Vision[Repair Count]: " + repairCount);
		
		if (settings.getMonitor() instanceof LogMonitor) {
			LogTable log = ((LogMonitor) settings.getMonitor()).getLog();
			log.append("[Time (ms)] Complement Matching", complementMatchingTimer);
			log.append("Potential Edit Rules", potentialEditRules);
			log.append("Complements (Repairs)", complementingEditRules);
			log.append("Complement Matchings", repairCount);
		}
		
		// Create repair job:
		PEORepairJob repairJob = new PEORepairJob();
		repairJob.setDifference(difference.eResource());
		repairJob.setModelA(modelA);
		repairJob.setModelB(modelB);
		repairJob.setRepairs(repairs);
		repairJob.setValidations(repairFilter.getValidations());
		
		return repairJob;
	}
	
	public void filterSettingAttributes(ComplementRule complementRule, 
			EditOperationMatching prematch, RepairActionFilter repairActionFilter) {
		
		// Filter setting attributes that do not overlap with an repair action:
		SettingAttributeFilter.filterSettingAttributes(
				complementRule.getComplementRule(), prematch, repairActionFilter);
		
		// Clear cache:
		complementRule.setComplementingChanges(null);
		complementRule.setHistoricChanges(null);
	}
	
	protected ComplementFinder createComplementFinder(
			Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		return new ComplementFinder(modelAResource, modelBResource, difference);
	}
}
