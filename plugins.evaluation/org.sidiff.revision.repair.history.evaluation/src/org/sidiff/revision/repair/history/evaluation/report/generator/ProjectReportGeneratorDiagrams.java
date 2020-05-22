package org.sidiff.revision.repair.history.evaluation.report.generator;

import static org.sidiff.revision.common.logging.util.LogUtil.avg;
import static org.sidiff.revision.common.logging.util.LogUtil.merge;
import static org.sidiff.revision.common.logging.util.LogUtil.round;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.repair.history.evaluation.EvaluationDataSets;
import org.sidiff.revision.repair.history.evaluation.report.HistoryLog;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;

public class ProjectReportGeneratorDiagrams {
	
	public ProjectReportGeneratorDiagrams() {
		
		try {
			
			// RQ3:
			LogTable rq3_rq4 = generateRQ3RQ4PerProject(false);
			rq3_rq4.toCSV(EvaluationDataSets.RESULT_REPORT + "rq3-4.csv");
			
			// RQ3 (HOR only):
			LogTable rq3_rq4_hor = generateRQ3RQ4PerProject(true);
			rq3_rq4_hor.toCSV(EvaluationDataSets.RESULT_REPORT + "rq3-4_hor.csv");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static LogTable generateRQ3RQ4PerProject(boolean onlyHOR) throws IOException {
		Map<String, List<EvaluationData>> evaluationDataPerProjects = ReportGenerator.getEvaluationsPerProject();
		
		List<LogTable> rq3rq4PerProject = new ArrayList<>();

		for (Entry<String, List<EvaluationData>> evaluationDataPerProject : evaluationDataPerProjects.entrySet()) {
			List<LogTable> inconsistenciesLogs = evaluationDataPerProject.getValue().stream().map(evaluation -> evaluation.inconsistenciesLog).collect(Collectors.toList());
			List<LogTable> historyLogs = evaluationDataPerProject.getValue().stream().map(evaluation -> evaluation.historyLog).collect(Collectors.toList());
			
			String projectName = evaluationDataPerProject.getKey();
			String avgModelElementsOfProject = "" + round(avg(merge(HistoryLog.COL_AVG_ELEMENTS, Integer.class, historyLogs.toArray(new LogTable[0]))));
			
			// RQ3:
			LogTable rq3_repairs = merge(inconsistenciesLogs,
					InconsistenciesLog.COL_INCONSISTENCY,
					InconsistenciesLog.COL_CONTEXT_ELEMENT,
					InconsistenciesLog.COL_COMPLEMENTS,
					InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS,
					InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_UNDOS,
					InconsistenciesLog.COL_RANKING_OF_BEST_HOR,
					InconsistenciesLog.COL_TIME_LOAD_CALCULATE_REVISION,
					InconsistenciesLog.COL_TIME_RECOGNITION,
					InconsistenciesLog.COL_TIME_COMPLEMENT_MATCHING,
					InconsistenciesLog.COL_UNBOUND_PARAMETERS_OF_BEST_HOR);
			
			if (onlyHOR) {
				rq3_repairs.filterRows(row -> 
					!row.get(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS, Boolean.class) &&
					!row.get(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_UNDOS, Boolean.class));
			}
			
			// Add project name column:
			LogTable projectNamesRQ3 = new LogTable();
			String COL_PROJECT_NAME = "Project";
			
			String[] projectNameRQ3 = new String[rq3_repairs.size()];
			Arrays.fill(projectNameRQ3, projectName);
			projectNamesRQ3.createColumn(COL_PROJECT_NAME, Arrays.asList(projectNameRQ3));
			
			// Add project element count column:
			LogTable projectElementCountRQ3 = new LogTable();
			
			Object[] projectElementRQ3 = new String[rq3_repairs.size()];
			Arrays.fill(projectElementRQ3, avgModelElementsOfProject);
			projectElementCountRQ3.createColumn(HistoryLog.COL_AVG_ELEMENTS, Arrays.asList(projectElementRQ3));
			
			if (rq3_repairs.size() > 0) {
				rq3rq4PerProject.add(merge(projectNamesRQ3, projectElementCountRQ3, rq3_repairs));
			}
		}
		
		// RQ3:
		LogTable rq3_rq4 = merge(rq3rq4PerProject.toArray(new LogTable[0]));
		return rq3_rq4;
	}
}
