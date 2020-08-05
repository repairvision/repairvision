package org.sidiff.revision.repair.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.editrules.complement.matching.finder.ComplementFinderEngine;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;
import org.sidiff.revision.repair.api.configuration.RepairSettings;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;
import org.sidiff.revision.repair.impact.negative.NegativeImpactAnalyzes;
import org.sidiff.revision.repair.impact.positive.PositiveImpactAnalyzes;

public class RepairCalculationEngine {
	
	protected RepairSettings settings;
	
	protected IRevision revision;
	
	public RepairCalculationEngine(RepairSettings settings, Resource modelA, Resource modelB) {
		this.settings = settings;
		this.revision = calculateDifference(modelA, modelB);
	}

	private IRevision calculateDifference(Resource modelA, Resource modelB) {
		
		LogTime diffTimer = new LogTime();
		IRevision revision = new Revision(modelA, modelB, settings.getDifferenceSettings());
		diffTimer.stop();
		
		// Report:
		if (settings.getLogger().isDebugging()) {
			settings.getLogger().logDifferenceTime(diffTimer);
			settings.getLogger().logChangeCount(revision.getDifference().getChanges().size());
		}

		if (settings.isSaveDifference()) {
			try {
				revision.getDifference().getSymmetricDifference().eResource().save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				if (settings.getLogger().isLogging()) {
					settings.getLogger().log(Level.SEVERE, "Problems occured during difference serialization.", e);
				}
			}
		}
			
		return revision;
	}
	
	public RepairJob getRepairs() {
		
		// Setup consistency rules?
		if (settings.getConsistencyRules() == null) {
			settings.setupConsistencyRules(revision.getVersionB().getTargetResource());
		}
		
		// Validate model and calculate abstract repairs:
		LogTime valiationTimer = new LogTime();
		
		RepairActionImpactScope repairActionImpactScope = new RepairActionImpactScope(
				settings.getValidationScope().iterator(), 
				settings.getConsistencyRules(), true);
		
		ImpactAnalyzes historicalImpactAnalyzes = new NegativeImpactAnalyzes(repairActionImpactScope);
		ImpactAnalyzes currentImpactAnalyzes = new PositiveImpactAnalyzes(repairActionImpactScope);
		
		valiationTimer.stop();

		// Report:
		if (settings.getLogger().isDebugging()) {
			settings.getLogger().logValidationTime(valiationTimer);
			settings.getLogger().logInconsistencyCount(repairActionImpactScope.getValidations().size());
			settings.getLogger().logEditRuleCount(settings.getEditRules().size());
		}

		// Henshin graph:
		EGraph graphModelB = new EGraphImpl(revision.getVersionB().getTargetResource());
		
		// Calculate repairs:
		ComplementFinderEngine complementFinderEngine = new ComplementFinderEngine(currentImpactAnalyzes, graphModelB);
		complementFinderEngine.start();
		
		List<ComplementationPlan> repairs = new ArrayList<>();
		
		LogTime complementMatchingTimer = new LogTime();
		int potentialEditRules = 0;
		int complementingOperationCount = 0;
		int repairCount = 0;
		
		for (Rule editRule : settings.getEditRules()) {
			
			// BREAKPOINT CONDITION: editRule.getName().contains("The name of the edit rule")
			
			RepairCaculation repairCaculation = createRepairCalculation(
					editRule, revision, historicalImpactAnalyzes, currentImpactAnalyzes, complementFinderEngine);
			RecognitionSettings recognitionSettings = repairCaculation.getComplementFinderSettings().getRecognitionEngineSettings();
			
			if (recognitionSettings.hasPotentialImpact()) {
				List<ComplementationPlan> repairsForEditRule = repairCaculation.findRepairs(complementMatchingTimer);
				repairs.addAll(repairsForEditRule);
				
				// Evaluation:
				++potentialEditRules;
				complementingOperationCount += repairsForEditRule.size();
				repairCount += repairCaculation.getRepairCount();
			}
		}

		complementFinderEngine.finish();
		
		// Report:
		if (settings.getLogger().isDebugging()) {
			settings.getLogger().logComplementMatchingTime(complementMatchingTimer);
			settings.getLogger().logPotentialEditRuleCount(potentialEditRules);
			settings.getLogger().logComplementOperationCount(complementingOperationCount);
			settings.getLogger().logComplementMatchingCount(repairCount);
		}
		
		// Create repair job:
		RepairJob repairJob = new RepairJob(repairActionImpactScope.getValidations(), repairs, revision, graphModelB);
		return repairJob;
	}
	
	protected RepairCaculation createRepairCalculation(
			Rule editRule, IRevision revision, 
			ImpactAnalyzes historicalImpactAnalyzes, ImpactAnalyzes currentImpactAnalyzes,
			ComplementFinderEngine complementFinderEngine) {
		
		return new RepairCaculation(settings, editRule, revision, historicalImpactAnalyzes, currentImpactAnalyzes, complementFinderEngine);
	}
}
