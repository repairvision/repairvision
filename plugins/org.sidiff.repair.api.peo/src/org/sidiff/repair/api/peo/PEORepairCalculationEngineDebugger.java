package org.sidiff.repair.api.peo;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.repair.complement.peo.finder.ComplementFinderRecorder;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class PEORepairCalculationEngineDebugger extends PEORepairCalculationEngine {

	protected ComplementFinderRecorder lastComplementFinderMonitor;
	
	public PEORepairCalculationEngineDebugger(PEORepairSettings settings, Resource modelA, Resource modelB) {
		super(settings, modelA, modelB);
	}
	
	@Override
	protected PEORepairCaculation createRepairCalculation(Rule editRule, ImpactAnalyzes impact, IRevision revision, ComplementFinderEngine complementFinderEngine) {
		PEORepairCaculation repairCaculation = super.createRepairCalculation(editRule, impact, revision, complementFinderEngine);
		
		lastComplementFinderMonitor = new ComplementFinderRecorder(repairCaculation.getComplementFinder());
		lastComplementFinderMonitor.setMatchingPathRecording(true);
		
		return repairCaculation;
	}
	
	public ComplementFinderRecorder getLastComplementFinderMonitor() {
		return lastComplementFinderMonitor;
	}
}
