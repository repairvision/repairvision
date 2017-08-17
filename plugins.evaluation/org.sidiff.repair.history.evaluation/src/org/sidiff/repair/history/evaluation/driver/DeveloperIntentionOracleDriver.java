package org.sidiff.repair.history.evaluation.driver;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.history.evaluation.driver.data.RepairedInconsistency;
import org.sidiff.repair.history.evaluation.oracle.DeveloperIntentionOracle;

public class DeveloperIntentionOracleDriver {

	public static List<IRepairPlan> getHistoricallyObservable(
			RepairedInconsistency repaired, PEORepairJob repairJob, DifferenceSettings settings) {
		
		List<IRepairPlan> observable = new ArrayList<>();
		
		// The evolutionStep in which inconsistency has been resolved historically
		try {
			SymmetricDifference actualToResolved = deriveTechnicalDifference(
					repaired.getModelActual(), repaired.getModelResolved(), settings);
			
			for (Rule complementRule : repairJob.getRepairs().keySet()) {
				for (IRepairPlan repair : repairJob.getRepairs().get(complementRule)) {
					
					// The preMatch turning the complement rule into a repair operation.
					Match preMatch = repair.getRepairPreMatch().getMatch();
					
					// Mode
					DeveloperIntentionOracle oracle = new DeveloperIntentionOracle();

					if (oracle.isHistoricallyObservable(
							preMatch, actualToResolved, 
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
}
