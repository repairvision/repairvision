package org.sidiff.repair.history.evaluation.report.generator;

import static org.sidiff.consistency.common.monitor.LogUtil.merge;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.repair.history.evaluation.report.HistoryLog;
import org.sidiff.repair.history.evaluation.report.InconsistenciesLog;

public class ProjectReportGeneratorDiagrams {
	
	private static final boolean ENABLED = false;
	
	public ProjectReportGeneratorDiagrams() throws IOException, IllegalArgumentException, IllegalAccessException  {
		if (!ENABLED) return;
		
		Map<String, List<EvaluationData>> evaluationDataPerProjects = ReportGenerator.getEvaluationsPerProject();

		for (Entry<String, List<EvaluationData>> evaluationDataPerProject : evaluationDataPerProjects.entrySet()) {
			List<LogTable> inconsistenciesLogs = evaluationDataPerProject.getValue().stream().map(evaluation -> evaluation.inconsistenciesLog).collect(Collectors.toList());
			List<LogTable> historyLogs = evaluationDataPerProject.getValue().stream().map(evaluation -> evaluation.historyLog).collect(Collectors.toList());
			
			LogTable rq3_repairs = merge(inconsistenciesLogs,
					InconsistenciesLog.COL_INCONSISTENCY,
					InconsistenciesLog.COL_CONTEXT_ELEMENT,
					InconsistenciesLog.COL_COMPLEMENTS,
					InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS,
					InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_UNDOS,
					InconsistenciesLog.COL_RANKING_OF_BEST_HOR);
			
			rq3_repairs.toCSV(ReportGenerator.OUTPUT_FOLDER + evaluationDataPerProject.getKey() + "_rq3_repairs.csv");
			
			LogTable rq3_repairs_hor = merge(inconsistenciesLogs,
					InconsistenciesLog.COL_INCONSISTENCY,
					InconsistenciesLog.COL_CONTEXT_ELEMENT,
					InconsistenciesLog.COL_COMPLEMENTS,
					InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS,
					InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_UNDOS,
					InconsistenciesLog.COL_RANKING_OF_BEST_HOR);
			
			rq3_repairs_hor.filterRows(row -> 
				!row.get(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS, Boolean.class) &&
				!row.get(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_UNDOS, Boolean.class));
			
			rq3_repairs_hor.toCSV(ReportGenerator.OUTPUT_FOLDER + evaluationDataPerProject.getKey() + "_rq3_repairs_hor.csv");
			
			
			LogTable rq4_modelelements = merge(historyLogs,
					HistoryLog.COL_HISTORY,
					HistoryLog.COL_AVG_ELEMENTS);
			
			rq4_modelelements.toCSV(ReportGenerator.OUTPUT_FOLDER + evaluationDataPerProject.getKey() + "_rq4_modelelements.csv");
			
			LogTable rq4_repairs = merge(inconsistenciesLogs,
					InconsistenciesLog.COL_INCONSISTENCY,
					InconsistenciesLog.COL_CONTEXT_ELEMENT,
					InconsistenciesLog.COL_TIME_LOAD_CALCULATE_REVISION,
					InconsistenciesLog.COL_TIME_RECOGNITION,
					InconsistenciesLog.COL_TIME_COMPLEMENT_MATCHING);
			
			rq4_repairs.toCSV(ReportGenerator.OUTPUT_FOLDER + evaluationDataPerProject.getKey() + "_rq4_runtime.csv");
		}
	}
}
