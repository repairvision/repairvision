package org.sidiff.revision.repair.api.peo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.revision.repair.complement.construction.ComplementRule;
import org.sidiff.revision.repair.complement.peo.configuration.ComplementFinderSettings;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.revision.repair.complement.peo.impact.GraphActionImpactUtil;
import org.sidiff.revision.repair.complement.repair.RepairPlan;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class PEORepairCaculation {
	
	private ComplementFinderEngine complementFinderEngine;
	
	private ComplementFinderSettings complementFinderSettings;
	
	private ComplementFinder complementFinder;
	
	private int repairCount = 0;
	
	public PEORepairCaculation(PEORepairSettings settings, Rule editRule, IRevision revision,
			ImpactAnalyzes impact, ComplementFinderEngine complementFinderEngine) {
		
		this.complementFinderEngine = complementFinderEngine;
		
		// Validate difference:
		if (settings.isValidateDifference()) {
			for (Change change : revision.getDifference().getSymmetricDifference().getChanges()) {
				if (!SymmetricDifferenceUtil.isResolvableChange(change)) {
					settings.getLogger().logChangeValidation(change, "Unresolvable change: " + change);
				}
			}
		}
		
		// Create complement finder:
		this.complementFinderSettings = settings.getComplementFinderSettings();
		RecognitionSettings recognitionSettings = complementFinderSettings.getRecognitionEngineSettings();
		recognitionSettings.setEditRule(editRule);
		recognitionSettings.setRevision(revision);
		recognitionSettings.setImpactAnalyzes(impact);
		
		if (recognitionSettings.hasPotentialImpact()) {
			this.complementFinder = complementFinderEngine.createComplementFinder(settings.getComplementFinderSettings());
		}
	}
	
	public List<IRepairPlan> findRepairs(LogTime complementMatchingTimer) {
		RecognitionSettings recognitionSettings = complementFinderSettings.getRecognitionEngineSettings();
		ImpactAnalyzes impactAnalyzes = recognitionSettings.getImpactAnalyzes();
		
		repairCount = 0;
		
		if (recognitionSettings.hasPotentialImpact()) {
			List<IRepairPlan> repairs = new ArrayList<>();
			
			for(ComplementRule complement : complementFinder.findComplementRules()) {
				complementMatchingTimer.start();

				// Filter complements by abstract repairs:
				if (complement.getComplementingChanges().size() > 0) {
					
					if (GraphActionImpactUtil.potential(
							impactAnalyzes.getCurrentPotentialImpactAnalysis(), 
							complement.getComplementingBoundaryChanges()) 
					 && GraphActionImpactUtil.potential(
							 impactAnalyzes.getHistoricalPotentialImpactAnalysis(), 
							 complement.getRecognizedChanges())) {

						// Filter complement with pre-match by inconsistency impact:
						if (GraphActionImpactUtil.real(
								impactAnalyzes.getHistoricalImpactAnalysis(),
								complement.getRecognizedChanges(),
								complement.getRecognitionMatch())) {
							
							List<Match> repairMatches = complementFinderEngine.findComplementMatches(complement);
							
							if (!repairMatches.isEmpty()) {
								repairs.add(new RepairPlan(complement, repairMatches));
								repairCount += repairMatches.size();
							}
						}
					}
				}
				
				complementMatchingTimer.stop();
			}
			
			return repairs;
		} else {
			return Collections.emptyList();
		}
	}
	
	public ComplementFinderSettings getComplementFinderSettings() {
		return complementFinderSettings;
	}
	
	public ComplementFinder getComplementFinder() {
		return complementFinder;
	}
	
	public int getRepairCount() {
		return repairCount;
	}
	
}
