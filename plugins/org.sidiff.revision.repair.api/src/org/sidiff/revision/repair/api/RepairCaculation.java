package org.sidiff.revision.repair.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.complement.construction.ComplementRule;
import org.sidiff.revision.editrules.complement.matching.configuration.ComplementFinderSettings;
import org.sidiff.revision.editrules.complement.matching.finder.ComplementFinder;
import org.sidiff.revision.editrules.complement.matching.finder.ComplementFinderEngine;
import org.sidiff.revision.editrules.complement.plan.ComplementationPlanImpl;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactAnalysis;
import org.sidiff.revision.editrules.impact.graph.PotentialGraphActionImpactAnalysis;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;
import org.sidiff.revision.repair.api.configuration.RepairSettings;

public class RepairCaculation {
	
	private ComplementFinderEngine complementFinderEngine;
	
	private ComplementFinderSettings complementFinderSettings;
	
	private ComplementFinder complementFinder;
	
	private int repairCount = 0;
	
	public RepairCaculation(
			RepairSettings settings, Rule editRule, IRevision revision,
			ImpactAnalyzes historicalImpactAnalyzes, ImpactAnalyzes currentImpactAnalyzes, 
			ComplementFinderEngine complementFinderEngine) {
		
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
		recognitionSettings.setImpactAnalyzes(historicalImpactAnalyzes, currentImpactAnalyzes);
		
		if (recognitionSettings.hasPotentialImpact()) {
			this.complementFinder = complementFinderEngine.createComplementFinder(settings.getComplementFinderSettings());
		}
	}
	
	public List<ComplementationPlan> findRepairs(LogTime complementMatchingTimer) {
		RecognitionSettings recognitionSettings = complementFinderSettings.getRecognitionEngineSettings();
		
		PotentialGraphActionImpactAnalysis historicalPotentialImpact = new PotentialGraphActionImpactAnalysis(
				recognitionSettings.getHistoricalImpactAnalyzes().getPotentialImpactAnalysis());
		
		PotentialGraphActionImpactAnalysis currentPotentialImpact = new PotentialGraphActionImpactAnalysis(
				recognitionSettings.getCurrentImpactAnalyzes().getPotentialImpactAnalysis());
		
		GraphActionImpactAnalysis historicalImpact = new GraphActionImpactAnalysis(
				recognitionSettings.getHistoricalImpactAnalyzes().getImpactAnalysis());
		
		
		repairCount = 0;
		
		if (recognitionSettings.hasPotentialImpact()) {
			List<ComplementationPlan> repairs = new ArrayList<>();
			
			for(ComplementRule complement : complementFinder.findComplementRules()) {
				complementMatchingTimer.start();

				// Filter complements by abstract repairs:
				if (complement.getComplementingChanges().size() > 0) {
					
					if (currentPotentialImpact.hasImpact(complement.getComplementingBoundaryChanges()) 
							&& historicalPotentialImpact.hasImpact(complement.getRecognizedChanges())) {

						// Filter complement with pre-match by inconsistency impact:
						if (historicalImpact.hasImpact(complement.getRecognizedChanges(), complement.getRecognitionMatching())) {
							List<Match> repairMatches = complementFinderEngine.findComplementMatches(complement);
							
							if (!repairMatches.isEmpty()) {
								repairs.add(new ComplementationPlanImpl(complement, repairMatches));
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
