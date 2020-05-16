package org.sidiff.revision.repair.history.evaluation.driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.api.util.ComplementMatching;
import org.sidiff.revision.repair.api.util.RecognitionMatching;
import org.sidiff.revision.repair.history.evaluation.oracle.DeveloperIntentionOracle;
import org.sidiff.validation.constraint.api.util.RepairValidation;

// TODO: Find first largest observable repair/undo!?
//       -> e.g. create unbound vs. bound generic type argument
//       -> 'unbound' is always observable even if 'bound' is observable
//       -> in general 'unbound' fixes the inconsistency -> least change

public class DeveloperIntentionOracleDriver {
	
	public static class HistoricalObservable {
		List<IRepairPlan> repairs;
		List<IRepairPlan> undos;
	}
	
	public static HistoricalObservable getHistoricallyObservable(InconsistencyTrace repaired, 
			List<IRepairPlan> repairs, Collection<RepairValidation> repairActions, 
			boolean findFirst, DifferenceSettings settings) {
		
		return getHistoricallyObservable(
				repaired.getModelCurrent(), repaired.getModelResolved(),
				repairs, repairActions, findFirst, settings);
	}
	
	private static HistoricalObservable getHistoricallyObservable(
			Resource modelCurrent, Resource modelResolved, 
			List<IRepairPlan> repairs, Collection<RepairValidation> repairActions, 
			boolean findFirst, DifferenceSettings settings) {
		
		HistoricalObservable observable = new HistoricalObservable();
		
		// The evolutionStep in which inconsistency has been resolved historically
		Revision currentToResolvedRevision = new Revision(modelCurrent, modelResolved, settings);
		DeveloperIntentionOracle oracle = new DeveloperIntentionOracle(currentToResolvedRevision);

		observable.repairs = getHistoricallyObservableRepair(oracle, repairs, repairActions, findFirst);
		observable.undos = getHistoricallyObservableUndos(oracle, repairs, repairActions, findFirst);
		
		return observable;
	}
	
	private static List<IRepairPlan> getHistoricallyObservableRepair(
			DeveloperIntentionOracle oracle, List<IRepairPlan> repairs, 
			Collection<RepairValidation> repairActions, boolean findFirst) {
		
		List<IRepairPlan> observable = new ArrayList<>();
		
		// The evolutionStep in which inconsistency has been resolved historically
		for (IRepairPlan repair : repairs) {
			if (oracle.isHistoricallyObservableRepair(
					new ComplementMatching(repair),
					repairActions)) {
				observable.add(repair);
				
				if (findFirst) {
					return observable;
				}
			}
		}
		
		return observable;
	}
	
	private static List<IRepairPlan> getHistoricallyObservableUndos(
			DeveloperIntentionOracle oracle, List<IRepairPlan> repairs, 
			Collection<RepairValidation> repairActions, boolean findFirst) {
		
		List<IRepairPlan> observable = new ArrayList<>();
		
		// The evolutionStep in which inconsistency has been resolved historically
		for (IRepairPlan repair : repairs) {
			if (oracle.isHistoricallyObservableUndo(
					new RecognitionMatching(repair),
					repairActions)) {
				observable.add(repair);
				
				if (findFirst) {
					return observable;
				}
			}
		}
		
		return observable;
	}
}
