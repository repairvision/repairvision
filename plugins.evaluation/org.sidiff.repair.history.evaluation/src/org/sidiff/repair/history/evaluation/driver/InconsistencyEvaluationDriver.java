package org.sidiff.repair.history.evaluation.driver;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.RepairedInconsistency;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;

public class InconsistencyEvaluationDriver {
	
	public static final String COLUMN_OBSERVABLE = "Historically Observable Repairs (HOR)";
	
	public static PEORepairJob calculateRepairs(
			boolean saveDifference, 
			HistoryInfo history, 
			IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade,
			RepairedInconsistency repaired, 
			Collection<Rule> editRules, 
			DifferenceSettings matchingSettings, 
			LogTable inconsistencies,
			LogTable runtimeComplexityLog) {
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " ####################");
		repaired.printModels();
		
		LogMonitor monitor = getMonitor(history, repaired, inconsistencies);
		
		// Calculate repairs (filtered by validation):
		PEORepairSettings settings = new PEORepairSettings(editRules, matchingSettings);
		settings.setupValidationFilter(
				Collections.singleton(repaired.getValidationErrorCurrentModel().getContext()), 
				Collections.singletonList(repaired.getConsistencyRule(history.getSupportedConsistencyRules())));
		settings.setSaveDifference(saveDifference);
		settings.setMonitor(monitor);
		settings.setRuntimeComlexityLog(runtimeComplexityLog);
		
		PEORepairJob repairJob = repairFacade.getRepairs(
				repaired.getModelHistorical(), repaired.getModelCurrent(), settings);
		
		// Evaluate repairs for inconsistency:
		evaluateRepairs(monitor, history, repaired, repairJob, matchingSettings);
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " Finished ####################");
		
		return repairJob;
	}
	
	private static LogMonitor getMonitor(HistoryInfo history, RepairedInconsistency repaired, LogTable log) {
		
		LogMonitor monitor = new LogMonitor(log);
		
		log.append("Inconsistency", repaired.getValidationErrorCurrentModel().getName() + " - " 
				+ EcoreUtil.getURI(repaired.getValidationErrorCurrentModel().getContext()));
		log.append("Context Type", repaired.getValidationErrorCurrentModel().getContext().eClass().getName());
		log.append("History", history.getHistory().getName());
		log.append("Historical Version (consistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionHistorical()));
		log.append("Introduced Version (inconsistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionIntroduced()));
		log.append("Actual Version (inconsistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionActual()));
		log.append("Resolved Version (consistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionResolved()));
		
		return monitor;
	}
	
	private static void evaluateRepairs(LogMonitor monitor, HistoryInfo history,
			RepairedInconsistency repaired, PEORepairJob repairJob,  
			DifferenceSettings matchingSettings) {
		
		// evaluate repair results:
		LogTable log = monitor.getLog();
		InfoConsole.printInfo("Repairs Found: " + repairJob.getRepairs().size());
		
		// search historical observable repair:
		List<IRepairPlan> observable = DeveloperIntentionOracleDriver.getHistoricallyObservable(
				repaired, repairJob, matchingSettings);
		Object[] rankingOfBestObservable = findBestObservableRepair(observable, repairJob);
		
		InfoConsole.printInfo("Historically Observable Repairs: " + observable.size());
		
		log.append(COLUMN_OBSERVABLE, observable.size() > 0);
		log.append("Ranking of HOR", rankingOfBestObservable[0]);
		
		if (rankingOfBestObservable[1] instanceof Rule) {
			Rule bestObservableComplementRule = (Rule) rankingOfBestObservable[1];
			List<IRepairPlan> repairs = repairJob.getRepairs().get(bestObservableComplementRule);
			
			log.append("Repair Matchings for HOR", repairs.size());
			log.append("Historic Changes of HOR", repairs.get(0).getHistoricChanges().size());
			log.append("Complementing Changes of HOR", repairs.get(0).getComplementingChanges().size());
		}
		
		// evaluate repair tree:
		log.append("Count of Repair Trees", repairJob.getValidations().size());
		log.append("Count of Repair Tree Actions/Paths", countRepairTreeAction(repairJob.getValidations()));
//		log.append("Count of Repair Tree Combinations", countRepairTreeCombinations(repairJob.getValidations()));
	}

	private static Object[] findBestObservableRepair(List<IRepairPlan> observable, PEORepairJob repairJob) {
		
		// Calculate Ranking:
		List<Rule> complements = new LinkedList<>(repairJob.getRepairs().keySet());
		complements.sort(repairJob.getRanking());
		
		// Find best observable:
		int position = Integer.MAX_VALUE;
		Rule bestObservableComplement =  null;
		
		for (IRepairPlan observableRepair : observable) {
			Rule observableComplement = RepairAPIUtil.getComplement(repairJob, observableRepair);
			int positionOfObservable = complements.indexOf(observableComplement);
			
			if (positionOfObservable < position) {
				position = positionOfObservable;
				bestObservableComplement = observableComplement;
			}
		}
		
		if (bestObservableComplement != null) {
			return new Object[] {position, bestObservableComplement};
		} else {
			return new Object[] {-1, LogTable.NA};
		}
	}
	
	private static int countRepairTreeAction(Collection<RepairValidation> validations) {
		int repairActions = 0;
		
		for (RepairValidation validation : validations) {
			for (Iterator<? extends IDecisionNode> iterator = validation.getRepair().traversal(); iterator.hasNext();) {
				IDecisionNode treeNode = iterator.next();
				
				if (treeNode instanceof RepairAction) {
					++repairActions;
				}
			}
		}
		
		return repairActions;
	}
	
	@SuppressWarnings("unused")
	private static int countRepairTreeCombinations(Collection<RepairValidation> validations) {
		int repairActionCombinations = 0;
		
		for (RepairValidation validation : validations) {
			for (Iterator<List<? extends IDecisionNode>> iterator = validation.getRepair().combinations(); iterator.hasNext();) {
				++repairActionCombinations;
			}
		}
		
		return repairActionCombinations;
	}
}
