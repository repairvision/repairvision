package org.sidiff.repair.api.peo;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recognition.scope.RepairActionFilter;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.repair.complement.peo.finder.ComplementFinderMonitor;

public class PEORepairCalculationEngineDebugger extends PEORepairCalculationEngine {

	protected ComplementFinderMonitor lastComplementFinderMonitor;
	
	public PEORepairCalculationEngineDebugger(PEORepairSettings settings, Resource modelA, Resource modelB) {
		super(settings, modelA, modelB);
	}
	
	public PEORepairCalculationEngineDebugger(PEORepairSettings settings, SymmetricDifference difference) {
		super(settings, difference);
	}
	
	@Override
	protected PEORepairCaculation createRepairCalculation(Rule editRule, RepairActionFilter repairFilter, ComplementFinderEngine complementFinderEngine) {
		PEORepairCaculation repairCaculation = super.createRepairCalculation(editRule, repairFilter, complementFinderEngine);
		
		lastComplementFinderMonitor = new ComplementFinderMonitor(repairCaculation.getComplementFinder());
		lastComplementFinderMonitor.setMatchingPathRecording(true);
		
		return repairCaculation;
	}
	
	public ComplementFinderMonitor getLastComplementFinderMonitor() {
		return lastComplementFinderMonitor;
	}
}
