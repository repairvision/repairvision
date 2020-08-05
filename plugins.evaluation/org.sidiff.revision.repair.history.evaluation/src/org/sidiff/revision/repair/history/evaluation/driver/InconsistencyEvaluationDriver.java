package org.sidiff.revision.repair.history.evaluation.driver;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.generic.matcher.uuid.UUIDResource;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.ui.workbench.InfoConsole;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.api.configuration.RepairSettings;
import org.sidiff.revision.repair.history.evaluation.driver.DeveloperIntentionOracleDriver.HistoricalObservable;
import org.sidiff.revision.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;
import org.sidiff.revision.repair.history.evaluation.report.logger.ComplementFinderTableLogger;
import org.sidiff.revision.repair.history.evaluation.report.logger.PEORepairTableLogger;
import org.sidiff.revision.repair.history.evaluation.report.logger.RecognitionTableLogger;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.ScopeValidation;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class InconsistencyEvaluationDriver {
	
	public static RepairJob calculateRepairs(
			boolean saveDifference, boolean validateDifference, boolean searchOnlyFirstObservable,
			HistoryInfo history, 
			ComplementationFacade<RepairJob, RepairSettings> repairFacade,
			InconsistencyTrace repaired, 
			Collection<Rule> editRules, 
			DifferenceSettings matchingSettings, 
			LogTable inconsistencies,
			LogTable runtimeComplexityLog) {
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " ####################");
		InfoConsole.printInfo(repaired);
		
		List<IConstraint> constraint = Collections.singletonList(repaired.getConsistencyRule(history.getSupportedConsistencyRules()));
		
		// TODO: WORKAROUND: Empty Model -> Just erase inconsistency scope..
		if (history.getHistory().getVersions().indexOf(repaired.getModelVersionIntroduced()) == 1) {
			prepareInitialModelVersion(history, repaired, constraint);
		}
		
		logInconsistency(history, repaired, inconsistencies);
		
		// Calculate repairs (filtered by validation):
		RepairSettings settings = new RepairSettings(
				Collections.singleton(repaired.getProblemCurrentModel().getContextElement()), editRules, matchingSettings);
		settings.setConsistencyRules(constraint);
		settings.setSaveDifference(saveDifference);
		settings.setValidateDifference(validateDifference);
		
		// Setup logging:
		settings.setLogger(new PEORepairTableLogger(inconsistencies));
		settings.getComplementFinderSettings().setMonitor(new ComplementFinderTableLogger(inconsistencies));
		settings.getComplementFinderSettings().getRecognitionEngineSettings().setLogger(new RecognitionTableLogger(runtimeComplexityLog));
		
		RepairJob repairJob = repairFacade.getComplementations(
				repaired.getModelHistorical(), repaired.getModelCurrent(), settings);
		
		// Evaluate repairs for inconsistency:
		evaluateRepairs(inconsistencies, history, repaired, repairJob, matchingSettings, searchOnlyFirstObservable);
		
		InfoConsole.printInfo("#################### " + repaired.getName() + " Finished ####################");
		
		return repairJob;
	}

	protected static void prepareInitialModelVersion(HistoryInfo history, InconsistencyTrace repaired, List<IConstraint> constraint) {
		EObject contextElement = repaired.getProblemInIntroducedModel().getContextElement();
		contextElement = history.getHistory().getVersions().get(0).getElement(EcoreUtil.getURI(contextElement).fragment());
		
		// could be deleted by earlier repairs...
		if (contextElement != null) {
			
			// Erase inconsistency scope:
			List<ScopeValidation> inconsistency = ValidationFacade.analyzeScope(
					JUtil.singeltonIterator(contextElement), constraint, false, true);
			
			for (ScopeValidation scopeValidation : inconsistency) {
				for (EObject elementInScope : scopeValidation.getScope().getScope()) {
					if (UUIDResource.isDynamic(elementInScope)) {
						EcoreUtil.delete(elementInScope.eContainer(), true);
					} else {
						EcoreUtil.delete(elementInScope, true);
					}
				}
			}
		}
	}
	
	private static void logInconsistency(HistoryInfo history, InconsistencyTrace repaired, LogTable log) {
		log.append(InconsistenciesLog.COL_INCONSISTENCY, repaired.getProblemCurrentModel().getName());
		log.append(InconsistenciesLog.COL_CONTEXT_ELEMENT, EcoreUtil.getURI(repaired.getProblemCurrentModel().getContextElement()));
		log.append(InconsistenciesLog.COL_CONTEXT_TYPE, repaired.getProblemCurrentModel().getContextElement().eClass().getName());
		log.append(InconsistenciesLog.COL_HISTORY, history.getHistory().getName());
		log.append(InconsistenciesLog.COL_HISTORICAL_VERSION, repaired.getModelVersionHistorical().getIndex());
		log.append(InconsistenciesLog.COL_INTRODUCED_VERSION, repaired.getModelVersionIntroduced().getIndex());
		log.append(InconsistenciesLog.COL_CURRENT_VERSION, repaired.getModelVersionCurrent().getIndex());
		log.append(InconsistenciesLog.COL_RESOLVED_VERSION, repaired.getModelVersionResolved().getIndex());
	}
	
	private static void evaluateRepairs(LogTable log, HistoryInfo history,
			InconsistencyTrace repaired, RepairJob repairJob,  
			DifferenceSettings matchingSettings, boolean searchOnlyFirstObservable) {
		
		// evaluate repair results:
		InfoConsole.printInfo("Repairs Found: " + repairJob.getComplementationPlans().size());
		
		// calculate Ranking:
		List<ComplementationPlan> repairRanking = new LinkedList<>(repairJob.getComplementationPlans());
		repairRanking.sort(repairJob.getRanking());
		
		// search historical observable repair:
		HistoricalObservable observable = DeveloperIntentionOracleDriver.getHistoricallyObservable(
				repaired, repairRanking, repairJob.getRepairTrees(), searchOnlyFirstObservable, matchingSettings);
		
		InfoConsole.printInfo("Historically Observable Repairs: " + observable.repairs.size());
		InfoConsole.printInfo("Historically Observable Repair Positions: " + printPositions(observable.repairs, repairRanking));
		InfoConsole.printInfo("Historically Observable Undos: " + observable.undos.size());
		InfoConsole.printInfo("Historically Observable Undo Positions: " + printPositions(observable.undos, repairRanking));
		
		log.append(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS, observable.repairs.size() > 0);
		log.append(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_UNDOS, observable.undos.size() > 0);
		
		Object[] bestObservable = findBestObservableRepair(observable, repairRanking);
		int bestPositionOfObservable = (int) bestObservable[0];
		
		InfoConsole.printInfo("Best Observable Repair/Undo Positions: " + bestPositionOfObservable);
		
		if (bestPositionOfObservable != -1) {
			ComplementationPlan bestObservableRepair = (ComplementationPlan) bestObservable[1];
			
			log.append(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, bestPositionOfObservable);
			log.append(InconsistenciesLog.COL_BEST_HOR_IS_UNDO, bestObservable[2]);
			log.append(InconsistenciesLog.COL_REPAIR_MATCHINGS_FOR_BEST_HOR, bestObservableRepair.getComplementMatches().size());
			log.append(InconsistenciesLog.COL_HISTORICAL_CHANGES_OF_BEST_HOR, bestObservableRepair.getRecognizedChanges().size());
			log.append(InconsistenciesLog.COL_COMPLEMENTING_CHANGES_OF_BEST_HOR, bestObservableRepair.getComplementingChanges().size());
			log.append(InconsistenciesLog.COL_UNBOUND_PARAMETERS_OF_BEST_HOR, countUnboudParameters(bestObservableRepair));
		} else {
			log.append(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, LogTable.NA);
			log.append(InconsistenciesLog.COL_BEST_HOR_IS_UNDO, LogTable.NA);
			log.append(InconsistenciesLog.COL_REPAIR_MATCHINGS_FOR_BEST_HOR, LogTable.NA);
			log.append(InconsistenciesLog.COL_HISTORICAL_CHANGES_OF_BEST_HOR, LogTable.NA);
			log.append(InconsistenciesLog.COL_COMPLEMENTING_CHANGES_OF_BEST_HOR, LogTable.NA);
			log.append(InconsistenciesLog.COL_UNBOUND_PARAMETERS_OF_BEST_HOR, LogTable.NA);
		}
		
		// evaluate repair tree:
		log.append(InconsistenciesLog.COL_COUNT_OF_REPAIR_TREES, repairJob.getValidations().size());
		log.append(InconsistenciesLog.COL_COUNT_OF_REPAIR_ACTIONS, countRepairTreeActions(repairJob.getRepairTrees()));
//		log.append("Count of Repair Tree Combinations", countRepairTreeCombinations(repairJob.getValidations()));
	}
	
	private static String printPositions(List<ComplementationPlan> selectedRepairs, List<ComplementationPlan> allRepairs) {
		StringBuilder positions = new StringBuilder();
		
		for (ComplementationPlan selectedRepair : selectedRepairs) {
			if (selectedRepair != selectedRepairs.get(0)) {
				positions.append("; ");
			}
			positions.append(allRepairs.indexOf(selectedRepair));
		}
		
		return positions.toString();
	}

	private static Object[] findBestObservableRepair(HistoricalObservable observable, List<ComplementationPlan> repairRanking) {
		
		// Find best observable:
		int bestPositionOfObservable = Integer.MAX_VALUE;
		ComplementationPlan bestObservableRepair =  null;
		boolean isUndo = false;
		

		for (ComplementationPlan observableUndo : observable.undos) {
			int positionOfObservable = repairRanking.indexOf(observableUndo);
			
			if (positionOfObservable < bestPositionOfObservable) {
				bestPositionOfObservable = positionOfObservable;
				bestObservableRepair = observableUndo;
				isUndo = true;
			}
		}
		
		for (ComplementationPlan observableRepair : observable.repairs) {
			int positionOfObservable = repairRanking.indexOf(observableRepair);
			
			if (positionOfObservable < bestPositionOfObservable) {
				bestPositionOfObservable = positionOfObservable;
				bestObservableRepair = observableRepair;
				isUndo = false;
			}
		}
		
		if (bestObservableRepair != null) {
			return new Object[] {bestPositionOfObservable, bestObservableRepair, isUndo};
		} else {
			return new Object[] {-1, LogTable.NA, LogTable.NA};
		}
	}
	
	private static int countUnboudParameters(ComplementationPlan repair) {
		int count = 0;

		for (Parameter parameter : repair.getParameters()) {
			if (repair.getParameterValue(parameter) == null) {
				++count;
			}
		}

		return count;
	}
	
	private static int countRepairTreeActions(Collection<RepairValidation> validations) {
		int repairActions = 0;
		
		for (RepairValidation validation : validations) {
			for (Iterator<? extends IDecisionNode> iterator = validation.getRepair().traversal(); iterator.hasNext();) {
				IDecisionNode treeNode = iterator.next();
				
				if (treeNode instanceof ChangeAction) {
					++repairActions;
				}
			}
		}
		
		return repairActions;
	}
	
//	private static int countRepairTreeCombinations(Collection<RepairValidation> validations) {
//		int repairActionCombinations = 0;
//		
//		for (RepairValidation validation : validations) {
//			for (Iterator<List<? extends IDecisionNode>> iterator = validation.getRepair().combinations(); iterator.hasNext();) {
//				++repairActionCombinations;
//			}
//		}
//		
//		return repairActionCombinations;
//	}
}
