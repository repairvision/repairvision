package org.sidiff.repair.history.evaluation.report.generator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.repair.history.evaluation.driver.app.HistoryEvaluationApplication;
import org.sidiff.repair.history.evaluation.report.EditRulesLog;
import org.sidiff.repair.history.evaluation.report.HistoryLog;
import org.sidiff.repair.history.evaluation.report.InconsistenciesLog;
import org.sidiff.repair.history.evaluation.report.RecognitionLog;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;

public class ReportGenerator implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		for (String history : HistoryEvaluationApplication.HISTORIES) {
			File historyFolder = new File(HistoryEvaluationApplication.LOCAL_PATH + history).getParentFile();
			
			List<Path> evaluations = Files.find(Paths.get(historyFolder.getAbsolutePath()), 1, 
					(path, attributes) -> (EvaluationUtil.getTimestamp(path.getFileName().toString()) != null))
					.collect(Collectors.toList());
			
			Collections.sort(evaluations, new Comparator<Path>() {
				public int compare(Path p1, Path p2) {
					Date d1 = EvaluationUtil.getTimestamp(p1.getFileName().toString());
					Date d2 = EvaluationUtil.getTimestamp(p2.getFileName().toString());
					return d1.compareTo(d2);
				}
			});
			
			Path lastEvaluation = evaluations.get(evaluations.size() - 1);
			
			Path editRulesCSV =  Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString().endsWith(EditRulesLog.NAME + ".csv")).findAny().get();
					
			LogTable editRulesLog = new LogTable();
			editRulesLog.loadCSV(editRulesCSV.toString());
			
			Path historyCSV =  Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString().endsWith(HistoryLog.NAME + ".csv")).findAny().get();
			LogTable historyLog = new LogTable();
			historyLog.loadCSV(historyCSV.toString());
			
			Path inconsistenciesCSV =  Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString().endsWith(InconsistenciesLog.NAME + ".csv")).findAny().get();
			LogTable inconsistenciesLog = new LogTable();
			inconsistenciesLog.loadCSV(inconsistenciesCSV.toString());
			
			Path recognitionCSV =  Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString().endsWith(RecognitionLog.NAME + ".csv")).findAny().get();
			LogTable recognitionLog = new LogTable();
			recognitionLog.loadCSV(recognitionCSV.toString());
			
			generateReport(editRulesLog, historyLog, inconsistenciesLog, recognitionLog);
		}
		
		return IApplication.EXIT_OK;
	}
	
	private void generateReport(
			LogTable editRulesLog, 
			LogTable historyLog, 
			LogTable inconsistenciesLog, 
			LogTable recognitionLog) {
		
		editRulesLog.dump();
		historyLog.dump();
		inconsistenciesLog.dump();
		recognitionLog.dump();
	}

	@Override
	public void stop() {
	}

}
