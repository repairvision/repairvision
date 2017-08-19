package org.sidiff.repair.history.evaluation.driver;

import java.util.Collection;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.RepairedInconsistency;

public class HistoryEvaluationDriver {
	
	public static void calculateRepairs(IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade,
			HistoryInfo history,  Collection<Rule> editRules, DifferenceSettings matchingSettings) {
		
		InfoConsole.printInfo("#################### Evaluation Startet ####################");
		
		// Setup evaluation:
//		RepairEvaluation evaluation = new RepairEvaluation();
//		ResearchQuestions rq = evaluation.createNewResearchQuestion(history.getHistory());
//		
//		rq.getResearchQuestion01().countOfInconsistenciesAll = history.getAllUniqueInconsistencies().size();
//		rq.getResearchQuestion01().countOfInconsistenciesConfigured = history
//				.getSupportedIntroducedAndResolvedUniqueInconsistencies().size();
//		rq.getResearchQuestion01().revisionsAll = history.getHistory().getVersions().size();
//		rq.getResearchQuestion01().avgElements = ResearchQuestion01.getAVGElements(history.getHistory());
		
		// Evaluate all inconsistencies of the actual history:
		for (RepairedInconsistency inconsistency : history.getRepairedInconsistencies()) {
			InconsistencyEvaluationDriver.calculateRepairs(false,
					history, repairFacade, inconsistency, editRules, matchingSettings);
		}
		
		// Store Evaluation:
//		evaluation.store(rq);

		// Dump evaluation:
//		System.out.println("#################### Evaluation Result ####################");
//		evaluation.dump();
//		System.out.println("#################### Evaluation Finished ####################");
		
		InfoConsole.printInfo("#################### Evaluation Finished ####################");
	}
}
