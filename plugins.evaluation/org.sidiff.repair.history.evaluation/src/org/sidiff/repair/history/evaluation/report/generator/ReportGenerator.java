package org.sidiff.repair.history.evaluation.report.generator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.repair.history.evaluation.driver.app.HistoryEvaluationApplication;
import org.sidiff.repair.history.evaluation.report.EditRulesLog;
import org.sidiff.repair.history.evaluation.report.HistoryLog;
import org.sidiff.repair.history.evaluation.report.InconsistenciesLog;
import org.sidiff.repair.history.evaluation.report.RecognitionLog;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;

// TODO:
// - Alle Versionen pro Modellhistorie zählen
// - Alle Inkonsistenzen und inkonsistente Versionen zählen
// - HOR Undos erkennen/zählen
// - Anzahl der (nicht) unterstützen Inkonsistenzen/Constraints
// - Anzahl der Änderungen mit potentiell negativem Impact auswerten
// - RQ3, RQ4 -> min, max, avg, median für Box-Plot
// - Bei Anzahl der Elemente zwischen Kanten und Knoten unterscheiden
//
// - Report: pro Constraint -> Gleiche Spalte wie bei Projekttabelle
//   - Constraint -> Anzahl der Verletzungen
// - Report: Für HOR -> CPEO x Violated Constraint
// - Report: Kennzahlen für vollständigen Datensatz

// TODO: Separate tables and output format!
public class ReportGenerator implements IApplication {
	
	private static final String[] COL_NAME = {"History", "Project Name"};
	
	private static final String[] COL_REVISIONS = {"Rev.", "Revisions (all / inconsistent)"};
	
	private static final String[] COL_ELEMENTS = {"Elem.", "Elements of the Model"};
	
	private static final String[] COL_REPAIRED_INCONSISTENCY = {"RI", "RQ1 Repaired Inconsistencies (Inconsistency Traces / At Least One Repair)"};
	
	private static final String[] COL_HOR = {"HOR", "RQ2 Historically Observable Repairs"};
	
	private static final String[] COL_UNDO = {"Undo", "RQ2 Undo"};
	
	private static final String[] COL_REPAIR_ACTIONS = {"M/A", "RQ3 Abstract Repair Actions"};
	
	private static final String[] COL_REPIAR_ALTERNATIVE = {"RA", "RQ3 Repair Alternatives (avg. / median)"}; // FIXME
	
	private static final String[] COL_HOR_RANKING = {"Prio.", "RQ3 Avg. Ranking of HOR (position / matchings)"};
	
	private static final String[] COL_RUNTIME = {"T [ms]", "RQ4 Avg. Runtime [ms] (Difference / Partial Recognition / Complement Matching)"};
	
	private static final boolean PROJECT_REPORT = true;
	
	private static final boolean MODEL_REPORT = false;
	
	private static final boolean LEGEND = true;

	private class EvaluationData {
		LogTable editRulesLog, historyLog, inconsistenciesLog, recognitionLog;
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		LogTable projectReport = new LogTable();
		
		for (Entry<String, List<EvaluationData>> evaluationDataPerProject : getEvaluationsPerProject().entrySet()) {
			
			if (PROJECT_REPORT) {
				generateProjectReport(projectReport,
						new File(evaluationDataPerProject.getKey()).getName(),
						evaluationDataPerProject.getValue().stream().map(data -> data.editRulesLog).collect(Collectors.toList()),
						evaluationDataPerProject.getValue().stream().map(data -> data.historyLog).collect(Collectors.toList()),
						evaluationDataPerProject.getValue().stream().map(data -> data.inconsistenciesLog).collect(Collectors.toList()),
						evaluationDataPerProject.getValue().stream().map(data -> data.recognitionLog).collect(Collectors.toList()));
			}
			
			if (MODEL_REPORT) {
				for (EvaluationData evaluationData : evaluationDataPerProject.getValue()) {
					LogTable modelReport = new LogTable();
					
					generateModelReport(modelReport,
							evaluationData.historyLog.getColumn(HistoryLog.COL_HISTORY, String.class).get(0),
							evaluationData.editRulesLog,
							evaluationData.historyLog,
							evaluationData.inconsistenciesLog,
							evaluationData.recognitionLog);
					
					System.out.println();
					System.out.println(LogUtil.convertToLatex(modelReport));
				}
			}
		}
		
		if (PROJECT_REPORT) {
			System.out.println();
			System.out.println(LogUtil.convertToLatex(projectReport));
		}
		
		if (LEGEND) {
			for (Field columnField : this.getClass().getDeclaredFields()) {
				if (columnField.getName().startsWith("COL_")) {
					String[] columnDefinition = (String[]) columnField.get(this);
					System.out.println("% " + columnDefinition[0] + " => " + columnDefinition[1]);
				}
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	private Map<String, List<EvaluationData>> getEvaluationsPerProject() throws IOException {
		Map<String, List<EvaluationData>> evaluationDataPerProject = new LinkedHashMap<>();
		
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
			
			EvaluationData data = new EvaluationData();
			data.editRulesLog = editRulesLog;
			data.historyLog = historyLog;
			data.inconsistenciesLog = inconsistenciesLog;
			data.recognitionLog = recognitionLog;
			
			String projectFolder = historyFolder.getParentFile().getAbsolutePath();
			List<EvaluationData> dataPerProject = evaluationDataPerProject.getOrDefault(projectFolder, new ArrayList<>());
			evaluationDataPerProject.put(projectFolder, dataPerProject);
			dataPerProject.add(data);
		}
		
		return evaluationDataPerProject;
	}
	
	private void generateProjectReport(
			LogTable report,
			String name,
			List<LogTable> editRulesLog, 
			List<LogTable> historyLog, 
			List<LogTable> inconsistenciesLog, 
			List<LogTable> recognitionLog) {
		
		report.append(COL_NAME[0], name);
		report.append(COL_REVISIONS[0],
				countAllVersions(historyLog.toArray(new LogTable[0])) + " / "
				+ countInconsistentVersions(historyLog.toArray(new LogTable[0])));
		report.append(COL_ELEMENTS[0],
				Math.round(avgModelElementCount(historyLog.toArray(new LogTable[0]))));
		report.append(COL_REPAIRED_INCONSISTENCY[0],
				sumInconsistencies(historyLog.toArray(new LogTable[0])) + "/" 
				+ countInconsistenciesWithAtLeastOneRepair(inconsistenciesLog.toArray(new LogTable[0])));
		report.append(COL_HOR[0],
				countHistoricallyObservableRepairs(inconsistenciesLog.toArray(new LogTable[0])));
		report.append(COL_UNDO[0],
				countHistoricallyObservedUndos(inconsistenciesLog.toArray(new LogTable[0])));
		report.append(COL_REPAIR_ACTIONS[0],
				Math.round(avgRepairActions(inconsistenciesLog.toArray(new LogTable[0]))));
		report.append(COL_REPIAR_ALTERNATIVE[0],
				Math.round(avgRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0]))) + " / "
				+ medianRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])));
		report.append(COL_HOR_RANKING[0],
				Math.round(avgHORPriority(inconsistenciesLog.toArray(new LogTable[0]))) + " / " 
				+ Math.round(avgHORMatchings(inconsistenciesLog.toArray(new LogTable[0]))));
		report.append(COL_RUNTIME[0],
				Math.round(avgDifferenceTime(inconsistenciesLog.toArray(new LogTable[0]))) + " + " 
				+ Math.round(avgRecognitionTime(inconsistenciesLog.toArray(new LogTable[0]))) + " + " 
				+ Math.round(avgComplementMatchingTime(inconsistenciesLog.toArray(new LogTable[0]))));
	}
	
	private void generateModelReport(
			LogTable report,
			String name,
			LogTable editRulesLog, 
			LogTable historyLog, 
			LogTable inconsistenciesLog, 
			LogTable recognitionLog) {
		
		generateProjectReport(report, name, 
				Collections.singletonList(editRulesLog), 
				Collections.singletonList(historyLog), 
				Collections.singletonList(inconsistenciesLog), 
				Collections.singletonList(recognitionLog));
	}
	
	private int countAllVersions(LogTable... historyLogs) {
		return -404; // TODO
	}

	private int countInconsistentVersions(LogTable... historyLogs) {
		return sum(LogUtil.merge(HistoryLog.COL_INCONSISTENT_VERSIONS, Integer.class, historyLogs));
	}
	
	private int avgModelElementCount(LogTable... historyLogs) {
		return sum(LogUtil.merge(HistoryLog.COL_AVG_ELEMENTS, Integer.class, historyLogs));
	}

	private int sumInconsistencies(LogTable... historyLogs) {
		return sum(LogUtil.merge(HistoryLog.COL_INCONSISTENCY_TRACES, Integer.class, historyLogs));
	}
	
	private int countInconsistenciesWithAtLeastOneRepair(LogTable... inconsistenciesLog) {
		int count = 0;
		
		for (int complementCount : LogUtil.merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLog)) {
			if (complementCount > 0) {
				++count;
			}
		}
		
		
		return count;
	}

	private int countHistoricallyObservableRepairs(LogTable... inconsistenciesLogs) {
		return count(LogUtil.merge(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS, Boolean.class, inconsistenciesLogs), true);
	}
	
	private int countHistoricallyObservedUndos(LogTable... inconsistenciesLogs) {
		return -404; // TODO
	}

	private double avgRepairActions(LogTable... inconsistenciesLogs) {
		return avg(LogUtil.merge(InconsistenciesLog.COL_COUNT_OF_REPAIR_ACTIONS, Integer.class, inconsistenciesLogs));
	}

	private double avgRepairAlternatives(LogTable... inconsistenciesLogs) {
		return avg(LogUtil.merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLogs));
	}

	private int medianRepairAlternatives(LogTable... inconsistenciesLogs) {
		return median(LogUtil.merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLogs));
	}

	private double avgHORPriority(LogTable... inconsistenciesLogs) {
		return avg(LogUtil.merge(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class, inconsistenciesLogs));
	}

	private double avgHORMatchings(LogTable... inconsistenciesLogs) {
		return avg(LogUtil.merge(InconsistenciesLog.COL_REPAIR_MATCHINGS_FOR_BEST_HOR, Integer.class, inconsistenciesLogs));
	}

	private double avgDifferenceTime(LogTable... inconsistenciesLogs) {
		return avg(LogUtil.merge(InconsistenciesLog.COL_TIME_LOAD_CALCULATE_REVISION, Integer.class, inconsistenciesLogs));
	}

	private double avgRecognitionTime(LogTable... inconsistenciesLogs) {
		return avg(LogUtil.merge(InconsistenciesLog.COL_TIME_RECOGNITION, Integer.class, inconsistenciesLogs));
	}

	private double avgComplementMatchingTime(LogTable... inconsistenciesLogs) {
		return avg(LogUtil.merge(InconsistenciesLog.COL_TIME_COMPLEMENT_MATCHING, Integer.class, inconsistenciesLogs));
	}
	
	private <T> int count(List<T> list, T valueToCount) {
		int sum = 0;
		
		for (T value : list) {
			if (value.equals(valueToCount)) {
				++sum;
			}
		}
		
		return sum;
	}

	private int sum(List<Integer> list) {
		if (list.size() > 0) {
			int sum = 0;
			
			for (int value : list) {
				sum += value;
			}
			
			return sum;
		} else {
			return -1;
		}
	}
	
	private double avg(List<Integer> list) {
		if (list.size() > 0) {
			double sum = 0.0;
			double count = 0.0;
			
			for (int value : list) {
				sum += value;
				++count;
			}
			
			return (((double) ((int) ((sum / count) * 100))) / 100);
		} else {
			return -1;
		}
	}
	
	private int median(List<Integer> list) {
		Collections.sort(list);
		
		if (list.size() > 0) {
			if ((list.size() % 2) == 0) {
				return list.get(list.size() / 2) + list.get(list.size() / 2 - 1) / 2;
			} else {
				return list.get(list.size() / 2);
			}
		} else {
			return -1;
		}
	}
	
	@Override
	public void stop() {
	}

}
