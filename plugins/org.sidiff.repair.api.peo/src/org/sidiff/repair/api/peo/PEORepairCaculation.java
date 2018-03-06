package org.sidiff.repair.api.peo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.scope.RepairActionFilter;
import org.sidiff.editrule.recognition.scope.RepairScope;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.repair.complement.repair.RepairPlan;

public class PEORepairCaculation {
	
	protected Rule editRule;
	
	protected RepairActionFilter repairFilter;
	
	protected RepairScope scope;
	
	protected ComplementFinderEngine complementFinderEngine;
	
	protected ComplementFinder complementFinder;
	
	protected int repairCount = 0;
	
	public PEORepairCaculation(PEORepairSettings settings, Rule editRule, RepairActionFilter repairFilter, ComplementFinderEngine complementFinderEngine) {
		this.editRule = editRule;
		this.repairFilter = repairFilter;
		this.complementFinderEngine = complementFinderEngine;
		
		// Filter edit-rules by abstract repairs:
		this.scope = repairFilter.getScope(ChangePatternUtil.getPotentialChanges(editRule));
		
		// Create complement finder:
		if (isPotentialRepair()) {
			complementFinder = complementFinderEngine.createComplementFinder(
					editRule, scope, settings.getMonitor(), settings.getRuntimeComlexityLog());
		}
	}
	
	public boolean isPotentialRepair() {
		return !scope.isEmpty();
	}
	
	public ComplementFinder getComplementFinder() {
		return complementFinder;
	}
	
	public List<IRepairPlan> findRepairs(LogTime complementMatchingTimer) {
		repairCount = 0;
		
		if (isPotentialRepair()) {
			List<IRepairPlan> repairs = new ArrayList<>();
			
			for(ComplementRule complement : complementFinder.findComplementRules()) {

				// Filter complements by abstract repairs:
				if (complement.getComplementingChanges().size() > 0) {
					if (repairFilter.filter(complement.getComplementingChanges())) {
						complementMatchingTimer.start();
						List<Match> complementMatches = complementFinderEngine.findComplementMatches(complement, Collections.emptyList());
						complementMatchingTimer.stop();

						List<Match> repairMatches = new ArrayList<>(complementMatches.size());

						// Filter complement with pre-match by abstract repairs:
						for (Match complementMatch : complementMatches) {
							if (repairFilter.filter(complement.getComplementingChanges(), complementMatch)) {
								repairMatches.add(complementMatch);
							}
						}

						if (!repairMatches.isEmpty()) {
							repairs.add(new RepairPlan(complement, repairMatches));
							repairCount += repairMatches.size();
						}
					}
				}
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
