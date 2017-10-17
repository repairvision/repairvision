package org.sidiff.repair.history.evaluation.driver;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.Match;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.history.evaluation.driver.data.InconsistencyTrace;
import org.sidiff.repair.history.evaluation.oracle.DeveloperIntentionOracle;

public class DeveloperIntentionOracleDriver {
	
	public static List<IRepairPlan> getHistoricallyObservable(
			Resource modelCurrent, Resource modelResolved, PEORepairJob repairJob, DifferenceSettings settings) {
		
		List<IRepairPlan> observable = new ArrayList<>();
		
		// The evolutionStep in which inconsistency has been resolved historically
		try {
			SymmetricDifference currentToResolved = deriveTechnicalDifference(
					modelCurrent, modelResolved, settings);
			
			for (IRepairPlan repair : repairJob.getRepairs()) {

				// The preMatch turning the complement rule into a repair operation.
				for (Match preMatch : repair.getComplementMatches()) {
					DeveloperIntentionOracle oracle = new DeveloperIntentionOracle();
					
					if (oracle.isHistoricallyObservable(
							preMatch, currentToResolved, 
							repairJob.getValidations())) {
						observable.add(repair);
					}
				}
			}
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		return observable;
	}

	public static List<IRepairPlan> getHistoricallyObservable(
			InconsistencyTrace repaired, PEORepairJob repairJob, DifferenceSettings settings) {
		
		return getHistoricallyObservable(repaired.getModelCurrent(), repaired.getModelResolved(), repairJob, settings);
	}
}
