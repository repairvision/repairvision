package org.sidiff.repair.history.evaluation.driver;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.InconsistencyTrace;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;

public class HistoryEvaluationDriver {
	
	public static int START_WITH_VERSION = 0;
	
	public static void calculateRepairs(
			IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade,
			HistoryInfo history,  
			Collection<Rule> editRules, 
			DifferenceSettings matchingSettings) {
		
		InfoConsole.printInfo("#################### Initialize Evaluation ####################");
		
		// Warm up run:
		for (InconsistencyTrace inconsistency : history.getRepairedInconsistencies()) {
			if (inconsistency.getModelVersionIntroduced().getIndex() >= START_WITH_VERSION) {
				InconsistencyEvaluationDriver.calculateRepairs(false,
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
				InconsistencyEvaluationDriver.calculateRepairs(false,
						history, repairFacade, inconsistency, editRules, matchingSettings,
						inconsistenciesLog, runtimeComplexityLog);
			}
		}
		
		// Report history setup:
		LogTable historyLog = evaluateHistory(history, inconsistenciesLog);
		LogTable editRuleLog = evaluateEditRules(history, editRules);
		
		String timestamp = EvaluationUtil.getTimestamp();
		
		EvaluationUtil.saveLog(history, inconsistenciesLog, timestamp, "inconsistencies");
		EvaluationUtil.saveLog(history, runtimeComplexityLog, timestamp, "runtime");
		EvaluationUtil.saveLog(history, historyLog, timestamp, "history");
		EvaluationUtil.saveLog(history, editRuleLog, timestamp, "editrules");
		EvaluationUtil.updateProject(history);
		
		InfoConsole.printInfo("#################### Evaluation Finished ####################");
	}

	private static LogTable evaluateHistory(HistoryInfo history, LogTable inconsistenciesLog) {
		LogTable historyLog = new LogTable();
		
		historyLog.append("History", history.getHistory().getName());
		historyLog.append("Versions", history.getHistory().getVersions().size());
		historyLog.append("Inconsistent Versions", history.getVersionsWithInconsistencies());
		historyLog.append("Avg. Elements", LogUtil.division(history.getHistoryModelElements(), history.getVersionsWithInconsistencies()));
		historyLog.append("Inconsistency Traces", history.getAllUniqueInconsistencies().size());
		historyLog.append("Resolved Inconsistency Traces", history.getIntroducedAndResolvedUniqueInconsistencies().size());
		historyLog.append("Supported Resolved Inconsistency Traces", history.getSupportedIntroducedAndResolvedUniqueInconsistencies().size());
		historyLog.append("[Annotation] Complex Repairs", history.getComplexChangeAnnotations().size());
		historyLog.append("[Annotation] Observable Complex Repairs", inconsistenciesLog.count(InconsistencyEvaluationDriver.COLUMN_OBSERVABLE, "true"));
		historyLog.append("[Annotation] Single Change Repairs", history.getSingleChangeAnnotations().size());
		historyLog.append("[Annotation] Undo Repairs", history.getUndoAnnotations().size());
		
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
		
		editRuleLog.append("Edit Rules (All)", editRules.size());
		editRuleLog.append("Avg. Node/Edge Changes", LogUtil.division(sizeAll[0], editRules.size()));
		editRuleLog.append("Avg. Attribute Changes", LogUtil.division(sizeAll[1], editRules.size()));
		
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
