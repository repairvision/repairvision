package org.sidiff.repair.history.evaluation.driver;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.RepairedInconsistency;

public class InconsistencyEvaluationDriver {
	
	public static final String LOG_KEY = "Inconsistencies";
	
	public static PEORepairJob calculateRepairs(boolean saveDifference,
			HistoryInfo history, IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade,
			RepairedInconsistency repaired, Collection<Rule> editRules, DifferenceSettings matchingSettings) {
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " ####################");
		repaired.printModels();
		
		LogMonitor monitor = getMonitor(history, repaired);
		
		// Calculate repairs (filtered by validation):
		PEORepairSettings settings = new PEORepairSettings(editRules, matchingSettings);
		settings.setupValidationFilter(
				Collections.singleton(repaired.getValidationErrorActualModel().getContext()), 
				Collections.singletonList(repaired.getConsistencyRule(history.getSupportedConsistencyRules())));
		settings.setSaveDifference(saveDifference);
		
		PEORepairJob repairJob = repairFacade.getRepairs(
				repaired.getModelHistorical(), repaired.getModelActual(), settings);
		
		// Evaluate repairs for inconsistency:
		evaluate(monitor, history, repaired, repairJob, matchingSettings);
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " Finished ####################");
		
		return repairJob;
	}
	
	private static LogMonitor getMonitor(HistoryInfo history, RepairedInconsistency repaired) {
		
		LogMonitor monitor = new LogMonitor();
		LogTable log = monitor.getLog(LOG_KEY);
		
		log.append("Inconsistency", repaired.getValidationErrorActualModel().getName() + " - " 
				+ EcoreUtil.getURI(repaired.getValidationErrorActualModel().getContext()));
		log.append("Context Type", repaired.getValidationErrorActualModel().getContext().eClass().getName());
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
	
	private static void evaluate(LogMonitor monitor, HistoryInfo history,
			RepairedInconsistency repaired, PEORepairJob repairJob,  
			DifferenceSettings matchingSettings) {
		
		LogTable log = monitor.getLog(LOG_KEY);
		
		// evaluate repair results:
		InfoConsole.printInfo("Repairs Found: " + repairJob.getRepairs().size());
		log.append("Complements (Repairs)", repairJob.getRepairs().size());
		
		// search historical observable repair:
		List<IRepairPlan> observable = DeveloperIntentionOracleDriver.getHistoricallyObservable(
				repaired, repairJob, matchingSettings);
		
		InfoConsole.printInfo("Historically Observable Repairs: " + observable.size());
		log.append("Observable Repair (OR)", observable.size() > 0);
		
		// store evaluation data:
		String projectPath = EMFStorage.uriToPath(history.getHistory().eResource().getURI().trimSegments(1));
		monitor.toCSV(projectPath);
		
		try {
			String projectName = history.getHistory().eResource().getURI().trimSegments(1).lastSegment();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(projectName);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		
//		// RQ 01:
//		if (!repairJob.getValidations().isEmpty()) {
//			rq.getResearchQuestion01().atLeastOnRepairRE++;
//		}
//		if (!repairJob.getRepairs().isEmpty()) {
//			rq.getResearchQuestion01().atLeastOnRepairOPK++;
//		}
//		
//		// RQ 02:
//		// TODO: Oracle for Repair-Trees:
//		List<IRepairPlan> observable = DeveloperIntentionOracleDriver.getHistoricallyObservable(
//				repaired, repairJob, matchingSettings);
//		
//		InfoConsole.printInfo("Historically Observable Repairs: " + observable.size());
//		
//		if (!observable.isEmpty()) {
//			rq.getResearchQuestion02().repairAsObservedOPK++;
//		}
//		
//		// RQ 03:
//		ResearchQuestion03 rq03 = rq.createNewRQ03(repaired.getValidationErrorActualModel());
//		
//		RepairValidation validationForInconsistency = EvaluationUtil.getValidation(
//				repairJob.getValidations(), repaired.getValidationErrorActualModel());
//
//		int[] counter = new int[2];
//		DecisionTreeUtil.getPathCount(validationForInconsistency.getRepair(), counter);
//
//		rq03.repairActionsRE = counter[0];
//		rq03.repairTreePathsRE = counter[1];
//
//		for (Rule complement : repairJob.getRepairs().keySet()) {
//			rq03.addRepairsPerComplement(repairJob.getRepairs().get(complement).size());
//		}
//		
//		// RQ 04:
//		ResearchQuestion04 rq04 = rq.createNewRQ04(repaired.getValidationErrorActualModel());
//		List<Rule> complements = new LinkedList<>(repairJob.getRepairs().keySet());
//
//		// Calculate Ranking:
//		complements.sort(repairJob.getRanking());
//		
//		// Find best observable:
//		int position = Integer.MAX_VALUE;
//		Rule bestObservableComplement =  null;
//		IRepairPlan bestObservableRepair = null;
//		
//		for (IRepairPlan observableRepair : observable) {
//			Rule observableComplement = RepairAPIUtil.getComplement(repairJob, observableRepair);
//			int positionOfObservable = complements.indexOf(observableComplement);
//			
//			if (positionOfObservable < position) {
//				position = positionOfObservable;
//				bestObservableComplement = observableComplement;
//				bestObservableRepair = observableRepair;
//			}
//		}
//		
//		if (bestObservableComplement != null) {
//			rq04.positionOfComplement = position;
//			rq04.countOfRepairs = repairJob.getRepairs().get(bestObservableComplement).size();
//			rq04.countOfHistoricChanges = bestObservableRepair.getHistoricChanges().size();
//			rq04.countOfComplementingChanges = bestObservableRepair.getComplementingChanges().size();
//		}
	}
}
