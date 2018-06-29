package org.sidiff.repair.api.peo;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.editrule.recognition.scope.RepairActionFilter;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;

public class PEORepairCalculationEngine {
	
	protected PEORepairSettings settings;
	
	protected SymmetricDifference difference;
	
	public PEORepairCalculationEngine(PEORepairSettings settings, Resource modelA, Resource modelB) {
		this.settings = settings;
		this.difference = calculateDifference(modelA, modelB);
	}
	
	public PEORepairCalculationEngine(PEORepairSettings settings, SymmetricDifference difference) {
		this.settings = settings;
		this.difference = difference;
	}

	private SymmetricDifference calculateDifference(Resource modelA, Resource modelB) {
		
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
			log.append("Change Count (Historical->Actual)", difference.getChanges().size());
		}
		
		// TODO/FIXME[Workaround]: Handle "real" empty historic models, i.e. without root element!
		if (difference.getChanges().isEmpty()) {
			if (difference.getModelA().getContents().size() == 1) {
				AddObject addRoot = SymmetricFactory.eINSTANCE.createAddObject();
				addRoot.setObj(difference.getModelB().getContents().get(0));
				difference.getChanges().add(addRoot);
			}
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
	
	public PEORepairJob getRepairs() {
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
		System.out.println("Re.Vision[CPEOs]: " + settings.getEditRules().size());
		EGraph graphModelB = new EGraphImpl(modelB);
		
		ComplementFinderEngine complementFinderEngine = new ComplementFinderEngine(difference, modelA, modelB, graphModelB);
		complementFinderEngine.start();
		
		List<IRepairPlan> repairs = new ArrayList<>();
		
		LogTime complementMatchingTimer = new LogTime();
		int potentialEditRules = 0;
		int complementingEditRules = 0;
		int repairCount = 0;
		
		for (Rule editRule : settings.getEditRules()) {
			PEORepairCaculation repairCaculation = createRepairCalculation(editRule, repairFilter, complementFinderEngine);
			
			if (repairCaculation.isPotentialRepair()) {
				List<IRepairPlan> repairsForEditRule = repairCaculation.findRepairs(complementMatchingTimer);
				repairs.addAll(repairsForEditRule);
				
				// Evaluation:
				++potentialEditRules;
				complementingEditRules += repairsForEditRule.size();
				repairCount += repairCaculation.getRepairCount();
			}
		}

		complementFinderEngine.finish();
		
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
		PEORepairJob repairJob = new PEORepairJob(repairFilter.getValidations(), repairs, difference, graphModelB);
		return repairJob;
	}
	
	protected PEORepairCaculation createRepairCalculation(Rule editRule, RepairActionFilter repairFilter, ComplementFinderEngine complementFinderEngine) {
		return new PEORepairCaculation(settings, editRule, repairFilter, complementFinderEngine);
	}
}
