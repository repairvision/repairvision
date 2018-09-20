package org.sidiff.repair.api.peo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;
import org.sidiff.validation.constraint.impact.index.RepairActionIndex;

public class PEORepairCalculationEngine {
	
	protected PEORepairSettings settings;
	
	protected IRevision revision;
	
	public PEORepairCalculationEngine(PEORepairSettings settings, Resource modelA, Resource modelB) {
		this.settings = settings;
		this.revision = calculateDifference(modelA, modelB);
	}

	private IRevision calculateDifference(Resource modelA, Resource modelB) {
		
		LogTime diffTimer = new LogTime();
		IRevision revision = new Revision(modelA, modelB, settings.getDifferenceSettings());
		diffTimer.stop();
		
		System.out.println("Re.Vision[Load/Calculate Revision Time]: " + diffTimer + "ms");
		
		// Report:
		if (settings.getMonitor() instanceof LogMonitor) {
			LogTable log = ((LogMonitor) settings.getMonitor()).getLog();
			log.append("[Time (ms)] Load/Calculate Revision", diffTimer);
			log.append("Change Count (Historical->Actual)", revision.getDifference().getChanges().size());
		}

		if (settings.saveDifference()) {
			try {
				revision.getDifference().getSymmetricDifference().eResource().save(Collections.EMPTY_MAP);
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
			
		return revision;
	}
	
	public PEORepairJob getRepairs() {
		
		// Setup consistency rules?
		if (settings.getConsistencyRules() == null) {
			settings.setupConsistencyRules(revision.getVersionB().getTargetResource());
		}
		
		// Validate model and calculate abstract repairs:
		LogTime valiationTimer = new LogTime();
		
		ImpactAnalyzes impact = new ImpactAnalyzes(new RepairActionIndex(
				settings.getValidationScope().iterator(), 
				settings.getConsistencyRules(), true));
		
		valiationTimer.stop();
		System.out.println("Re.Vision[Validation Time]: " + valiationTimer + "ms");
		System.out.println("Re.Vision[Inconsistencies]: " + impact.getValidations().size());

		// Report validation:
		if (settings.getMonitor() instanceof LogMonitor) {
			LogTable log = ((LogMonitor) settings.getMonitor()).getLog();
//			log.append("[Time (ms)] Validation", valiationTimer);
			log.append("Inconsistencies", impact.getValidations().size());
		}
		
		// Calculate repairs:
		System.out.println("Re.Vision[CPEOs]: " + settings.getEditRules().size());
		EGraph graphModelB = new EGraphImpl(revision.getVersionB().getTargetResource());
		
		ComplementFinderEngine complementFinderEngine = new ComplementFinderEngine(revision, graphModelB);
		complementFinderEngine.start();
		
		List<IRepairPlan> repairs = new ArrayList<>();
		
		LogTime complementMatchingTimer = new LogTime();
		int potentialEditRules = 0;
		int complementingEditRules = 0;
		int repairCount = 0;
		
		for (Rule editRule : settings.getEditRules()) {
//			if (editRule.getName().contains("Create: Accessor Operation for Structural Feature")) {
//				System.out.println(editRule.getName());
//			}
			
			PEORepairCaculation repairCaculation = createRepairCalculation(editRule, impact, revision, complementFinderEngine);
			
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
		System.out.println("Re.Vision[Potential CPEOs]: " + potentialEditRules);
		System.out.println("Re.Vision[Repair Count]: " + repairCount);
		
		if (settings.getMonitor() instanceof LogMonitor) {
			LogTable log = ((LogMonitor) settings.getMonitor()).getLog();
			log.append("[Time (ms)] Complement Matching", complementMatchingTimer);
			log.append("Potential Edit Rules", potentialEditRules);
			log.append("Complements (Repairs)", complementingEditRules);
			log.append("Complement Matchings", repairCount);
		}
		
		// Create repair job:
		PEORepairJob repairJob = new PEORepairJob(impact.getValidations(), repairs, revision, graphModelB);
		return repairJob;
	}
	
	protected PEORepairCaculation createRepairCalculation(Rule editRule, ImpactAnalyzes impact, IRevision revision, ComplementFinderEngine complementFinderEngine) {
		return new PEORepairCaculation(settings, editRule, revision, impact, complementFinderEngine);
	}
}
