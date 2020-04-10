package org.sidiff.revision.repair.api.peo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.utilities.monitor.LogTime;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.validation.constraint.impact.repair.RepairImpactAnalyzes;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;
import org.sidiff.validation.constraint.impact.repair.RepairActionIndex;

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
		
		// Report:
		if (settings.getMonitor().isLogging()) {
			settings.getMonitor().logDifferenceTime(diffTimer);
			settings.getMonitor().logChangeCount(revision.getDifference().getChanges().size());
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
		
		RepairImpactAnalyzes impact = new RepairImpactAnalyzes(new RepairActionIndex(
				settings.getValidationScope().iterator(), 
				settings.getConsistencyRules(), true));
		
		valiationTimer.stop();

		// Report:
		if (settings.getMonitor().isLogging()) {
			settings.getMonitor().logValidationTime(valiationTimer);
			settings.getMonitor().logInconsistencyCount(impact.getValidations().size());
			settings.getMonitor().logEditRuleCount(settings.getEditRules().size());
		}

		// Henshin graph:
		EGraph graphModelB = new EGraphImpl(revision.getVersionB().getTargetResource());
		
		// Calculate repairs:
		ComplementFinderEngine complementFinderEngine = new ComplementFinderEngine(revision, impact, graphModelB);
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
		if (settings.getMonitor().isLogging()) {
			settings.getMonitor().logComplementMatchingTime(complementMatchingTimer);
			settings.getMonitor().logPotentialEditRuleCount(potentialEditRules);
			settings.getMonitor().logComplementOperationCount(complementingEditRules);
			settings.getMonitor().logComplementMatchingCount(repairCount);
		}
		
		// Create repair job:
		PEORepairJob repairJob = new PEORepairJob(impact.getValidations(), repairs, revision, graphModelB);
		return repairJob;
	}
	
	protected PEORepairCaculation createRepairCalculation(Rule editRule, ImpactAnalyzes impact, IRevision revision, ComplementFinderEngine complementFinderEngine) {
		return new PEORepairCaculation(settings, editRule, revision, impact, complementFinderEngine);
	}
}
