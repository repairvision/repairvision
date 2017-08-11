package org.sidiff.repair.history.evaluation.driver;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.history.evaluation.data.ResearchQuestion03;
import org.sidiff.repair.history.evaluation.data.ResearchQuestion04;
import org.sidiff.repair.history.evaluation.data.ResearchQuestions;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.RepairedInconsistency;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.interpreter.decisiontree.DecisionTreeUtil;

public class InconsistencyEvaluationDriver {
	
	public static PEORepairJob calculateRepairs(
			HistoryInfo history, IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade, ResearchQuestions rq,
			RepairedInconsistency repaired, Collection<Rule> editRules, DifferenceSettings matchingSettings) {
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " ####################");
		repaired.printModels();
		
		// Calculate repairs (filtered by validation):
		PEORepairSettings settings = new PEORepairSettings(editRules, matchingSettings);
		settings.setupValidationFilter(
				Collections.singleton(repaired.getValidationErrorActualModel().getInvalidElement().get(0)), 
				Collections.singletonList(repaired.getConsistencyRule(history.getSupportedConsistencyRules())));
		
		PEORepairJob repairJob = repairFacade.getRepairs(
				repaired.getModelHistorical(), repaired.getModelActual(), settings);
		
		// Evaluate repairs for inconsistency:
		evaluate(repairJob, rq, repaired, editRules, matchingSettings);
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " Finished ####################");
		
		return repairJob;
	}
	
	private static void evaluate(PEORepairJob repairJob, ResearchQuestions rq, 
			RepairedInconsistency repaired, Collection<Rule> editRules, DifferenceSettings matchingSettings) {
		
		InfoConsole.printInfo("Repairs Found: " + repairJob.getRepairs().size());
		
		// RQ 01:
		if (!repairJob.getValidations().isEmpty()) {
			rq.getResearchQuestion01().atLeastOnRepairRE++;
		}
		if (!repairJob.getRepairs().isEmpty()) {
			rq.getResearchQuestion01().atLeastOnRepairOPK++;
		}
		
		// RQ 02:
		// TODO: Oracle for Repair-Trees:
		List<IRepairPlan> observable = EvaluationUtil.historicallyObservable(
				repairJob, matchingSettings, repaired.getModelActual(), repaired.getModelResolved());
		
		InfoConsole.printInfo(observable.size() + " Historically Observable Repair(s) Found!");
		
		if (!observable.isEmpty()) {
			rq.getResearchQuestion02().repairAsObservedOPK++;
		}
		
		// RQ 03:
		ResearchQuestion03 rq03 = rq.createNewRQ03(repaired.getValidationErrorActualModel());
		
		RepairValidation validationForInconsistency = EvaluationUtil.getValidation(
				repairJob.getValidations(), repaired.getValidationErrorActualModel());

		int[] counter = new int[2];
		DecisionTreeUtil.getPathCount(validationForInconsistency.getRepair(), counter);

		rq03.repairActionsRE = counter[0];
		rq03.repairTreePathsRE = counter[1];

		for (Rule complement : repairJob.getRepairs().keySet()) {
			rq03.addRepairsPerComplement(repairJob.getRepairs().get(complement).size());
		}
		
		// RQ 04:
		ResearchQuestion04 rq04 = rq.createNewRQ04(repaired.getValidationErrorActualModel());
		List<Rule> complements = new LinkedList<>(repairJob.getRepairs().keySet());

		// Calculate Ranking:
		complements.sort(repairJob.getRanking());
		
		// Find best observable:
		int position = Integer.MAX_VALUE;
		Rule bestObservableComplement =  null;
		IRepairPlan bestObservableRepair = null;
		
		for (IRepairPlan observableRepair : observable) {
			Rule observableComplement = RepairAPIUtil.getComplement(repairJob, observableRepair);
			int positionOfObservable = complements.indexOf(observableComplement);
			
			if (positionOfObservable < position) {
				position = positionOfObservable;
				bestObservableComplement = observableComplement;
				bestObservableRepair = observableRepair;
			}
		}
		
		if (bestObservableComplement != null) {
			rq04.positionOfComplement = position;
			rq04.countOfRepairs = repairJob.getRepairs().get(bestObservableComplement).size();
			rq04.countOfHistoricChanges = bestObservableRepair.getHistoricChanges().size();
			rq04.countOfComplementingChanges = bestObservableRepair.getComplementingChanges().size();
		}
	}
}
