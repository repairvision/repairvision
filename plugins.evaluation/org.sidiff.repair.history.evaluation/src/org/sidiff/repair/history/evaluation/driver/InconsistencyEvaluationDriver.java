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
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.InconsistencyTrace;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;

public class InconsistencyEvaluationDriver {
	
	public static final String COLUMN_OBSERVABLE = "Historically Observable Repairs (HOR)";
	
	public static PEORepairJob calculateRepairs(
			boolean saveDifference, 
			HistoryInfo history, 
			IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade,
			InconsistencyTrace repaired, 
			Collection<Rule> editRules, 
			DifferenceSettings matchingSettings, 
			LogTable inconsistencies,
			LogTable runtimeComplexityLog) {
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " ####################");
		repaired.printModels();
		
		LogMonitor monitor = getMonitor(history, repaired, inconsistencies);
		
		// Calculate repairs (filtered by validation):
		PEORepairSettings settings = new PEORepairSettings(
				Collections.singleton(repaired.getProblemCurrentModel().getContextElement()), editRules, matchingSettings);
		settings.setConsistencyRules(Collections.singletonList(repaired.getConsistencyRule(history.getSupportedConsistencyRules())));
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
	
	private static LogMonitor getMonitor(HistoryInfo history, InconsistencyTrace repaired, LogTable log) {
		
		LogMonitor monitor = new LogMonitor(log);
		
		log.append("Inconsistency", repaired.getProblemCurrentModel().getName());
		log.append("Context Element", EcoreUtil.getURI(repaired.getProblemCurrentModel().getContextElement()));
		log.append("Context Type", repaired.getProblemCurrentModel().getContextElement().eClass().getName());
		log.append("History", history.getHistory().getName());
		log.append("Historical Version (consistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionHistorical()));
		log.append("Introduced Version (inconsistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionIntroduced()));
		log.append("Current Version (inconsistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionCurrent()));
		log.append("Resolved Version (consistent)", history.getHistory().getVersions().indexOf(
				repaired.getModelVersionResolved()));
		
		return monitor;
	}
	
	private static void evaluateRepairs(LogMonitor monitor, HistoryInfo history,
			InconsistencyTrace repaired, PEORepairJob repairJob,  
			DifferenceSettings matchingSettings) {
		
		// evaluate repair results:
		LogTable log = monitor.getLog();
		InfoConsole.printInfo("Repairs Found: " + repairJob.getRepairs().size());
		
		// search historical observable repair:
		List<IRepairPlan> observable = DeveloperIntentionOracleDriver.getHistoricallyObservable(
				repaired, repairJob, matchingSettings);
		
		InfoConsole.printInfo("Historically Observable Repairs: " + observable.size());
		
		log.append(COLUMN_OBSERVABLE, observable.size() > 0);
		
		Object[] bestObservable = findBestObservableRepair(observable, repairJob);
		int bestPositionOfObservable = (int) bestObservable[0];
		
		if (bestPositionOfObservable != -1) {
			IRepairPlan bestObservableRepair = (IRepairPlan) bestObservable[1];
			
			log.append("Ranking of Best HOR", bestPositionOfObservable);
			log.append("Repair Matchings for Best HOR", bestObservableRepair.getComplementMatches().size());
			log.append("Historic Changes of Best HOR", bestObservableRepair.getRecognizedChanges().size());
			log.append("Complementing Changes of Best HOR", bestObservableRepair.getComplementingChanges().size());
		} else {
			log.append("Ranking of Best HOR", LogTable.NA);
			log.append("Repair Matchings for Best HOR", LogTable.NA);
			log.append("Historic Changes of Best HOR", LogTable.NA);
			log.append("Complementing Changes of Best HOR", LogTable.NA);
		}
		
		// evaluate repair tree:
		log.append("Count of Repair Trees", repairJob.getValidations().size());
		log.append("Count of Repair Actions", countRepairTreeActions(repairJob.getRepairTrees()));
//		log.append("Count of Repair Tree Combinations", countRepairTreeCombinations(repairJob.getValidations()));
	}

	private static Object[] findBestObservableRepair(List<IRepairPlan> observable, PEORepairJob repairJob) {
		
		// Calculate Ranking:
		List<IRepairPlan> repairRanking = new LinkedList<>(repairJob.getRepairs());
		repairRanking.sort(repairJob.getRanking());
		
		// Find best observable:
		int bestPositionOfObservable = Integer.MAX_VALUE;
		IRepairPlan bestObservableRepair =  null;
		
		for (IRepairPlan observableRepair : observable) {
			int positionOfObservable = repairRanking.indexOf(observableRepair);
			
			if (positionOfObservable < bestPositionOfObservable) {
				bestPositionOfObservable = positionOfObservable;
				bestObservableRepair = observableRepair;
			}
		}
		
		if (bestObservableRepair != null) {
			return new Object[] {bestPositionOfObservable, bestObservableRepair};
		} else {
			return new Object[] {-1, LogTable.NA};
		}
	}
	
	private static int countRepairTreeActions(Collection<RepairValidation> validations) {
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
