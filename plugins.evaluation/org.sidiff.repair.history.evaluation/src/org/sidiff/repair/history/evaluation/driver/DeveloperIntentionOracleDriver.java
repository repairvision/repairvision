package org.sidiff.repair.history.evaluation.driver;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.history.evaluation.driver.data.InconsistencyTrace;
import org.sidiff.repair.history.evaluation.oracle.DeveloperIntentionOracle;

public class DeveloperIntentionOracleDriver {
	
	public static class HistoricalObservable {
		List<IRepairPlan> repairs;
		List<IRepairPlan> undos;
	}
	
	private static HistoricalObservable getHistoricallyObservable(
			Resource modelCurrent, Resource modelResolved, PEORepairJob repairJob, DifferenceSettings settings) {
		
		HistoricalObservable observable = new HistoricalObservable();
		
		// The evolutionStep in which inconsistency has been resolved historically
		// FIXME: Comparison a model with itself should result in an empty difference!
		Revision currentToResolvedRevision = new Revision(modelCurrent, modelResolved, settings);
		DeveloperIntentionOracle oracle = new DeveloperIntentionOracle(currentToResolvedRevision);

		observable.repairs = getHistoricallyObservableRepair(oracle, repairJob);
		observable.undos = getHistoricallyObservableUndos(oracle, repairJob);
		
		return observable;
	}
	
	private static List<IRepairPlan> getHistoricallyObservableRepair(
			DeveloperIntentionOracle oracle, PEORepairJob repairJob) {
		
		List<IRepairPlan> observable = new ArrayList<>();
		
		// The evolutionStep in which inconsistency has been resolved historically
		for (IRepairPlan repair : repairJob.getRepairs()) {
			if (oracle.isHistoricallyObservableRepair(
					repair.getComplementingChanges(),
					repair.getComplementMatches(),
					repairJob.getRepairTrees())) {
				observable.add(repair);
			}
		}
		
		return observable;
	}
	
	private static List<IRepairPlan> getHistoricallyObservableUndos(
			DeveloperIntentionOracle oracle, PEORepairJob repairJob) {
		
		List<IRepairPlan> observable = new ArrayList<>();
		
		// The evolutionStep in which inconsistency has been resolved historically
		for (IRepairPlan repair : repairJob.getRepairs()) {
			if (oracle.isHistoricallyObservableUndo(
					repair.getRecognizedChanges(), 
					repair.getComplementMatches(),
					repairJob.getRepairTrees())) {
				observable.add(repair);
			}
		}
		
		return observable;
	}

	public static HistoricalObservable getHistoricallyObservable(
			InconsistencyTrace repaired, PEORepairJob repairJob, DifferenceSettings settings) {
		
		return getHistoricallyObservable(repaired.getModelCurrent(), repaired.getModelResolved(), repairJob, settings);
	}
}
