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
import org.sidiff.consistency.common.monitor.LogUtil;
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
			
			System.out.println("######################################################");
			generateModelReport(editRulesLog, historyLog, inconsistenciesLog, recognitionLog);
			System.out.println("######################################################");
		}
		
		return IApplication.EXIT_OK;
	}
	
	private void generateProjectReport(
			List<LogTable> editRulesLog, 
			List<LogTable> historyLog, 
			List<LogTable> inconsistenciesLog, 
			List<LogTable> recognitionLog) {
		
		System.out.println("Name: " 
				+ getName(historyLog.toArray(new LogTable[0])));
		System.out.println("Revisions (all / inconsistent): " 
				+ countAllVersions(historyLog.toArray(new LogTable[0])) + " / "
				+ countInconsistentVersions(historyLog.toArray(new LogTable[0])));
		System.out.println("Elements: "
				+ avgModelElementCount(historyLog.toArray(new LogTable[0])));
		System.out.println("RQ1 Repaired Inconsistencies (Inconsistency Traces / At Least One Repair): " 
				+ countInconsistencies(historyLog.toArray(new LogTable[0]))
				+ "/" + sumInconsistenciesWithAtLeastOneRepair(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println("RQ2 Historically Observable Repairs: " 
				+ countHistoricallyObservableRepairs(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println("RQ2 Undo: " 
				+ "TODO");
		System.out.println("RQ3 Abstract Repair Actions: " 
				+ avgRepairActions(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println("RQ3 Repair Alternatives (avg. / median): " 
				+ avgRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])) 
				+ " / " + medianRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println("RQ3 Avg. Ranking of HOR (position / matchings): "
				+ avgHORPriority(inconsistenciesLog.toArray(new LogTable[0])) 
				+ " / " + avgHORMatchings(inconsistenciesLog.toArray(new LogTable[0])));
		System.out.println("RQ 4 Avg. Runtime [ms] (Difference / Partial Recognition / Complement Matching): " 
				+ avgDifferenceTime(inconsistenciesLog.toArray(new LogTable[0]))
				+ " / " + avgRecognitionTime(inconsistenciesLog.toArray(new LogTable[0]))
				+ " / " + avgComplementMatchingTime(inconsistenciesLog.toArray(new LogTable[0])));
	}
	
	private void generateModelReport(
			LogTable editRulesLog, 
			LogTable historyLog, 
			LogTable inconsistenciesLog, 
			LogTable recognitionLog) {
		
		System.out.println("Name: " 
				+ getName(historyLog));
		System.out.println("Revisions (all / inconsistent): " 
				+ countAllVersions(historyLog) + " / "
				+ countInconsistentVersions(historyLog));
		System.out.println("Elements: "
				+ avgModelElementCount(historyLog));
		System.out.println("RQ1 Repaired Inconsistencies (Inconsistency Traces / At Least One Repair): " 
				+ countInconsistencies(historyLog) + "/" 
				+ sumInconsistenciesWithAtLeastOneRepair(inconsistenciesLog));
		System.out.println("RQ2 Historically Observable Repairs: " 
				+ countHistoricallyObservableRepairs(inconsistenciesLog));
		System.out.println("RQ2 Undo: " 
				+ countHistoricallyObservedUndo(inconsistenciesLog));
		System.out.println("RQ3 Abstract Repair Actions: " 
				+ avgRepairActions(inconsistenciesLog));
		System.out.println("RQ3 Repair Alternatives (avg. / median): " 
				+ avgRepairAlternatives(inconsistenciesLog) + " / "
				+ medianRepairAlternatives(inconsistenciesLog));
		System.out.println("RQ3 Avg. Ranking of HOR (position / matchings): "
				+ avgHORPriority(inconsistenciesLog) + " / " 
				+ avgHORMatchings(inconsistenciesLog));
		System.out.println("RQ 4 Avg. Runtime [ms] (Difference / Partial Recognition / Complement Matching): " 
				+ avgDifferenceTime(inconsistenciesLog) + " / " 
				+ avgRecognitionTime(inconsistenciesLog) + " / " 
				+ avgComplementMatchingTime(inconsistenciesLog));
	}
	
	private String getName(LogTable... historyLogs) {
		String name = historyLogs[0].getColumn(HistoryLog.COL_HISTORY, String.class).get(0);
		
		for (LogTable historyLog : historyLogs) {
			String nextName = historyLog.getColumn(HistoryLog.COL_HISTORY, String.class).get(0);
			name = longestCommonPrefix(name, nextName);
		}
		
		return name;
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

	private int countInconsistencies(LogTable... historyLogs) {
		return sum(LogUtil.merge(HistoryLog.COL_INCONSISTENCY_TRACES, Integer.class, historyLogs));
	}
	
	private int sumInconsistenciesWithAtLeastOneRepair(LogTable... inconsistenciesLog) {
		return sum(LogUtil.merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLog));
	}

	private int countHistoricallyObservableRepairs(LogTable... inconsistenciesLogs) {
		return count(LogUtil.merge(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS, Boolean.class, inconsistenciesLogs), true);
	}
	
	private int countHistoricallyObservedUndo(LogTable... inconsistenciesLogs) {
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
		int sum = 0;
		
		for (int value : list) {
			if (value > 0) {
				++sum;
			}
		}
		
		return sum;
	}
	
	private double avg(List<Integer> list) {
		double sum = 0.0;
		double count = 0.0;
		
		for (int value : list) {
			sum += value;
			++count;
		}
		
		return (((double) ((int) ((sum / count) * 100))) / 100);
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
	
	private String longestCommonPrefix(String a, String b) {
		int minLength = Math.min(a.length(), b.length());
		
		for (int i = 0; i < minLength; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				return a.substring(0, i);
			}
		}
		
		return a.substring(0, minLength);
	}
	
	@Override
	public void stop() {
	}

}
