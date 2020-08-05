package org.sidiff.revision.repair.history.evaluation.driver;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.logging.util.LogUtil;
import org.sidiff.revision.common.ui.workbench.InfoConsole;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.api.configuration.RepairSettings;
import org.sidiff.revision.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.revision.repair.history.evaluation.report.EditRulesLog;
import org.sidiff.revision.repair.history.evaluation.report.HistoryLog;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;
import org.sidiff.revision.repair.history.evaluation.report.RecognitionLog;
import org.sidiff.revision.repair.history.evaluation.util.EvaluationUtil;

public class HistoryEvaluationDriver {
	
	public static int START_WITH_VERSION = 0;
	
	public static void calculateRepairs(
			ComplementationFacade<RepairJob, RepairSettings> repairFacade,
			HistoryInfo history,  
			Collection<Rule> editRules, 
			DifferenceSettings matchingSettings) {
		
		InfoConsole.printInfo("#################### Initialize Evaluation ####################");
		
		// Warm up run:
		for (InconsistencyTrace inconsistency : history.getRepairedInconsistencies()) {
			if (inconsistency.getModelVersionIntroduced().getIndex() >= START_WITH_VERSION) {
				InconsistencyEvaluationDriver.calculateRepairs(false, false, true,
						history, repairFacade, inconsistency, editRules, matchingSettings,
						new LogTable(), new LogTable());
				break;
			}
		}
		
		InfoConsole.printInfo("#################### Evaluation Started ####################");
		
		// Evaluate all inconsistencies of the actual history:
		LogTable inconsistenciesLog = new LogTable();
		LogTable runtimeComplexityLog = new LogTable();
		
		for (InconsistencyTrace inconsistency : history.getRepairedInconsistencies()) {
			if (inconsistency.getModelVersionIntroduced().getIndex() >= START_WITH_VERSION) {
				InconsistencyEvaluationDriver.calculateRepairs(false, false, true,
						history, repairFacade, inconsistency, editRules, matchingSettings,
						inconsistenciesLog, runtimeComplexityLog);
			}
		}
		
		// Report history setup:
		LogTable historyLog = evaluateHistory(history, inconsistenciesLog);
		LogTable editRuleLog = evaluateEditRules(history, editRules);
		
		String timestamp = EvaluationUtil.getTimestamp();
		
		EvaluationUtil.saveLog(history, inconsistenciesLog, timestamp, InconsistenciesLog.NAME);
		EvaluationUtil.saveLog(history, runtimeComplexityLog, timestamp, RecognitionLog.NAME);
		EvaluationUtil.saveLog(history, historyLog, timestamp, HistoryLog.NAME);
		EvaluationUtil.saveLog(history, editRuleLog, timestamp, EditRulesLog.NAME);
		EvaluationUtil.updateProject(history);
		
		InfoConsole.printInfo("#################### Evaluation Finished ####################");
	}

	private static LogTable evaluateHistory(HistoryInfo history, LogTable inconsistenciesLog) {
		LogTable historyLog = new LogTable();
		
		historyLog.append(HistoryLog.COL_HISTORY, history.getHistory().getName());
		historyLog.append(HistoryLog.COL_VERSIONS, history.getHistory().getVersions().size());
		historyLog.append(HistoryLog.COL_INCONSISTENT_VERSIONS, history.getVersionsWithInconsistencies());
		historyLog.append(HistoryLog.COL_AVG_ELEMENTS, LogUtil.division(history.getHistoryModelElements(), history.getVersionsWithInconsistencies()));
		historyLog.append(HistoryLog.COL_INCONSISTENCY_TRACES, history.getAllUniqueInconsistencies().size());
		historyLog.append(HistoryLog.COL_RESOLVED_INOCONSISTENCY_TRACES, history.getIntroducedAndResolvedUniqueInconsistencies().size());
		historyLog.append(HistoryLog.COL_SUPPORTED_RESOLEVED_INCONSISTENCY_TRACES, history.getSupportedIntroducedAndResolvedUniqueInconsistencies().size());
		historyLog.append(HistoryLog.COL_ANNOTATION_COMPLEX_REPAIRS, history.getComplexChangeAnnotations().size());
		historyLog.append(HistoryLog.COL_ANNOTATION_OBSERVABLE_COMPLEX_REPAIRS, LogUtil.count(inconsistenciesLog.getColumn(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS, Boolean.class), true));
		historyLog.append(HistoryLog.COL_ANNOTATION_SINGLE_CHANGE_REPAIRS, history.getSingleChangeAnnotations().size());
		historyLog.append(HistoryLog.COL_ANNOTATION_UNDO_REPAIRS, history.getUndoAnnotations().size());
		
		return historyLog;
	}
	
	private static LogTable evaluateEditRules(HistoryInfo history, Collection<Rule> editRules) {
		LogTable editRuleLog = new LogTable();
		
		// count nodes and edges:
		Integer[] sizeAll = new Integer[2];
		Arrays.fill(sizeAll, 0);
		
		for (Rule rule : editRules) {
			Integer[] size = evaluateEditRule(rule);
			sizeAll[0] = sizeAll[0] + size[0];
			sizeAll[1] = sizeAll[1] + size[1];
		}
		
		editRuleLog.append(EditRulesLog.COL_ALL_EDIT_RULES, editRules.size());
		editRuleLog.append(EditRulesLog.COL_AVG_NODE_EDGE_CHANGES, LogUtil.division(sizeAll[0], editRules.size()));
		editRuleLog.append(EditRulesLog.COL_AVG_ATTRIBUTE_CHANGES, LogUtil.division(sizeAll[1], editRules.size()));
		
		return editRuleLog;
	}
	
	private static Integer[] evaluateEditRule(Rule rule) {
		Integer[] size = new Integer[2];
		Arrays.fill(size, 0);
		
		rule.eResource().getAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				size[0] = size[0] + 1;
			} else if (element instanceof Edge) {
				size[1] = size[1] + 1;
			}
		});
		
		return size;
	}
}
