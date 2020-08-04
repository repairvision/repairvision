package org.sidiff.revision.repair.api;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.editrules.complement.matching.finder.ComplementFinderEngine;
import org.sidiff.revision.editrules.complement.matching.finder.ComplementFinderRecorder;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;
import org.sidiff.revision.repair.api.configuration.RepairSettings;

public class RepairCalculationEngineDebugger extends RepairCalculationEngine {

	protected ComplementFinderRecorder lastComplementFinderMonitor;
	
	public RepairCalculationEngineDebugger(RepairSettings settings, Resource modelA, Resource modelB) {
		super(settings, modelA, modelB);
	}
	
	@Override
	protected RepairCaculation createRepairCalculation(
			Rule editRule, IRevision revision, 
			ImpactAnalyzes historicalImpactAnalyzes, ImpactAnalyzes currentImpactAnalyzes,
			ComplementFinderEngine complementFinderEngine) {
		
		RepairCaculation repairCaculation = super.createRepairCalculation(
				editRule, revision, historicalImpactAnalyzes, currentImpactAnalyzes, complementFinderEngine);
		
		lastComplementFinderMonitor = new ComplementFinderRecorder(repairCaculation.getComplementFinder());
		lastComplementFinderMonitor.setMatchingPathRecording(true);
		
		return repairCaculation;
	}
	
	public ComplementFinderRecorder getLastComplementFinderMonitor() {
		return lastComplementFinderMonitor;
	}
}
