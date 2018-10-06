package org.sidiff.repair.history.evaluation.report.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
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

public class ReportGenerator implements IApplication {
	
	private static final String COL_SEPERATOR = ": ";
	
	private static final String COL_NAME = "Name";
	
	private static final String COL_REVISIONS = "Revisions (all / inconsistent)";
	
	private static final String COL_ELEMENTS = "Elements";
	
	private static final String COL_REPAIRED_INCONSISTENCY = "RQ1 Repaired Inconsistencies (Inconsistency Traces / At Least One Repair)";
	
	private static final String COL_HOR = "RQ2 Historically Observable Repairs";
	
	private static final String COL_UNDO = "RQ2 Undo";
	
	private static final String COL_REPAIR_ACTIONS = "RQ3 Abstract Repair Actions";
	
	private static final String COL_REPIAR_ALTERNATIVE = "RQ3 Repair Alternatives (avg. / median)";
	
	private static final String COL_HOR_RANKING = "RQ3 Avg. Ranking of HOR (position / matchings)";
	
	private static final String COL_RUNTIME = "RQ4 Avg. Runtime [ms] (Difference / Partial Recognition / Complement Matching)";
	
	private static final boolean PROJECT_REPORT = true;
	
	private static final boolean MODEL_REPORT = false;

	private class EvaluationData {
		LogTable editRulesLog, historyLog, inconsistenciesLog, recognitionLog;
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		for (Entry<String, List<EvaluationData>> evaluationDataPerProject : getEvaluationsPerProject().entrySet()) {
			
			if (PROJECT_REPORT) {
				System.out.println("######################################################");
				generateProjectReport(
						new File(evaluationDataPerProject.getKey()).getName(),
						evaluationDataPerProject.getValue().stream().map(data -> data.editRulesLog).collect(Collectors.toList()),
						evaluationDataPerProject.getValue().stream().map(data -> data.historyLog).collect(Collectors.toList()),
						evaluationDataPerProject.getValue().stream().map(data -> data.inconsistenciesLog).collect(Collectors.toList()),
						evaluationDataPerProject.getValue().stream().map(data -> data.recognitionLog).collect(Collectors.toList()));
				System.out.println("######################################################");
			}
			
			if (MODEL_REPORT) {
				for (EvaluationData evaluationData : evaluationDataPerProject.getValue()) {
					System.out.println("######################################################");
					generateModelReport(
							evaluationData.historyLog.getColumn(HistoryLog.COL_HISTORY, String.class).get(0),
							evaluationData.editRulesLog,
							evaluationData.historyLog,
							evaluationData.inconsistenciesLog,
							evaluationData.recognitionLog);
					System.out.println("######################################################");
				}
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	private Map<String, List<EvaluationData>> getEvaluationsPerProject() throws IOException {
		Map<String, List<EvaluationData>> evaluationDataPerProject = new HashMap<>();
		
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
			String name,
			List<LogTable> editRulesLog, 
			List<LogTable> historyLog, 
			List<LogTable> inconsistenciesLog, 
			List<LogTable> recognitionLog) {
		
		System.out.println("Models: " + historyLog.size());
		System.out.println(COL_NAME + COL_SEPERATOR
				+ name);
		System.out.println(COL_REVISIONS + COL_SEPERATOR
				+ countAllVersions(historyLog.toArray(new LogTable[0])) + " / "
				+ countInconsistentVersions(historyLog.toArray(new LogTable[0])));
		System.out.println(COL_ELEMENTS + COL_SEPERATOR
				+ avgModelElementCount(historyLog.toArray(new LogTable[0])));
		System.out.println(COL_REPAIRED_INCONSISTENCY + COL_SEPERATOR
				+ sumInconsistencies(historyLog.toArray(new LogTable[0]))
				+ "/" + countInconsistenciesWithAtLeastOneRepair(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println(COL_HOR + COL_SEPERATOR 
				+ countHistoricallyObservableRepairs(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println(COL_UNDO + COL_SEPERATOR
				+ countHistoricallyObservedUndos(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println(COL_REPAIR_ACTIONS + COL_SEPERATOR
				+ avgRepairActions(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println(COL_REPIAR_ALTERNATIVE + COL_SEPERATOR
				+ avgRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])) 
				+ " / " + medianRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println(COL_HOR_RANKING + COL_SEPERATOR
				+ avgHORPriority(inconsistenciesLog.toArray(new LogTable[0])) 
				+ " / " + avgHORMatchings(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println(COL_RUNTIME+ COL_SEPERATOR
				+ avgDifferenceTime(inconsistenciesLog.toArray(new LogTable[0]))
				+ " / " + avgRecognitionTime(inconsistenciesLog.toArray(new LogTable[0]))
				+ " / " + avgComplementMatchingTime(inconsistenciesLog.toArray(new LogTable[0])));
	}
	
	private void generateModelReport(
			String name,
			LogTable editRulesLog, 
			LogTable historyLog, 
			LogTable inconsistenciesLog, 
			LogTable recognitionLog) {
		
		System.out.println(COL_NAME + COL_SEPERATOR
				+ name);
		System.out.println(COL_REVISIONS + COL_SEPERATOR
				+ countAllVersions(historyLog) + " / "
				+ countInconsistentVersions(historyLog));
		System.out.println(COL_ELEMENTS + COL_SEPERATOR
				+ avgModelElementCount(historyLog));
		System.out.println(COL_REPAIRED_INCONSISTENCY + COL_SEPERATOR
				+ sumInconsistencies(historyLog) + "/" 
				+ countInconsistenciesWithAtLeastOneRepair(inconsistenciesLog));
		System.out.println(COL_HOR + COL_SEPERATOR
				+ countHistoricallyObservableRepairs(inconsistenciesLog));
		System.out.println(COL_UNDO + COL_SEPERATOR
				+ countHistoricallyObservedUndos(inconsistenciesLog));
		System.out.println(COL_REPAIR_ACTIONS + COL_SEPERATOR
				+ avgRepairActions(inconsistenciesLog));
		System.out.println(COL_REPIAR_ALTERNATIVE + COL_SEPERATOR
				+ avgRepairAlternatives(inconsistenciesLog) + " / "
				+ medianRepairAlternatives(inconsistenciesLog));
		System.out.println(COL_HOR_RANKING + COL_SEPERATOR
				+ avgHORPriority(inconsistenciesLog) + " / " 
				+ avgHORMatchings(inconsistenciesLog));
		System.out.println(COL_RUNTIME+ COL_SEPERATOR
				+ avgDifferenceTime(inconsistenciesLog) + " / " 
				+ avgRecognitionTime(inconsistenciesLog) + " / " 
				+ avgComplementMatchingTime(inconsistenciesLog));
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
