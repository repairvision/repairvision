package org.sidiff.repair.api.peo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.impact.GraphActionImpactAnalysis;
import org.sidiff.editrule.recognition.impact.PotentialGraphActionImpactAnalysis;
import org.sidiff.editrule.recognition.impact.scope.ChangeScope;
import org.sidiff.editrule.recognition.impact.scope.RepairScope;
import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.repair.complement.repair.RepairPlan;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class PEORepairCaculation {
	
	protected Rule editRule;
	
	protected ImpactAnalyzes impact;
	
	protected RepairScope repairScope;
	
	protected ChangeScope changeScope;
	
	protected ComplementFinderEngine complementFinderEngine;
	
	protected ComplementFinder complementFinder;
	
	protected int repairCount = 0;
	
	public PEORepairCaculation(PEORepairSettings settings, Rule editRule, IRevision revision,
			ImpactAnalyzes impact, ComplementFinderEngine complementFinderEngine) {
		
		this.editRule = editRule;
		this.impact = impact;
		this.complementFinderEngine = complementFinderEngine;
		
		// Filter edit-rules by abstract repairs:
		List<GraphElement> changes = ChangePatternUtil.getPotentialChanges(editRule);
		this.repairScope = new RepairScope(changes, impact.getPositiveImpactAnalysis());
		this.changeScope = new ChangeScope(changes, impact.getNegativeImpactAnalysis(), revision);
		
		// Create complement finder:
		if (isPotentialRepair()) {
			complementFinder = complementFinderEngine.createComplementFinder(
					editRule, repairScope, settings.getMonitor(), settings.getRuntimeComlexityLog());
		}
	}
	
	public boolean isPotentialRepair() {
		return !repairScope.isEmpty() && !changeScope.isEmpty();
	}
	
	public ComplementFinder getComplementFinder() {
		return complementFinder;
	}
	
	public List<IRepairPlan> findRepairs(LogTime complementMatchingTimer) {
		repairCount = 0;
		
		if (isPotentialRepair()) {
			List<IRepairPlan> repairs = new ArrayList<>();
			
			PotentialGraphActionImpactAnalysis positivePotentialImpact = 
					new PotentialGraphActionImpactAnalysis(impact.getPositivePotentialImpactAnalysis());
			GraphActionImpactAnalysis positiveImpact = 
					new GraphActionImpactAnalysis(impact.getPositiveImpactAnalysis());
			PotentialGraphActionImpactAnalysis negativePotentialImpact = 
					new PotentialGraphActionImpactAnalysis(impact.getNegativePotentialImpactAnalysis());
			GraphActionImpactAnalysis negativeImpact = 
					new GraphActionImpactAnalysis(impact.getNegativeImpactAnalysis());
			
			for(ComplementRule complement : complementFinder.findComplementRules()) {
				complementMatchingTimer.start();

				// Filter complements by abstract repairs:
				if (complement.getComplementingChanges().size() > 0) {
					
					if (positivePotentialImpact.check(complement.getComplementingChanges()) 
							&& negativePotentialImpact.check(complement.getRecognizedChanges())) {
						
						List<Match> complementMatches = complementFinderEngine.findComplementMatches(complement, Collections.emptyList());
						List<Match> repairMatches = new ArrayList<>(complementMatches.size());

						// Filter complement with pre-match by abstract repairs:
						for (Match complementMatch : complementMatches) {
							
							if (positiveImpact.check(complement.getComplementingChanges(), complementMatch)
									&& negativeImpact.check(complement.getComplementingChanges(), complementMatch)) {
								
								repairMatches.add(complementMatch);
							}
						}

						if (!repairMatches.isEmpty()) {
							repairs.add(new RepairPlan(complement, repairMatches));
							repairCount += repairMatches.size();
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
	
	public int getRepairCount() {
		return repairCount;
	}
}
