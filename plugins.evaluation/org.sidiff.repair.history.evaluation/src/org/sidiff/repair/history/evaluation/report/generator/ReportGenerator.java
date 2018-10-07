package org.sidiff.repair.history.evaluation.report.generator;

import static org.sidiff.consistency.common.monitor.LogUtil.NA;
import static org.sidiff.consistency.common.monitor.LogUtil.TODO;
import static org.sidiff.consistency.common.monitor.LogUtil.assertPositive;
import static org.sidiff.consistency.common.monitor.LogUtil.avg;
import static org.sidiff.consistency.common.monitor.LogUtil.convertToLatex;
import static org.sidiff.consistency.common.monitor.LogUtil.count;
import static org.sidiff.consistency.common.monitor.LogUtil.max;
import static org.sidiff.consistency.common.monitor.LogUtil.median;
import static org.sidiff.consistency.common.monitor.LogUtil.merge;
import static org.sidiff.consistency.common.monitor.LogUtil.min;
import static org.sidiff.consistency.common.monitor.LogUtil.round;
import static org.sidiff.consistency.common.monitor.LogUtil.sum;
import static org.sidiff.consistency.common.monitor.LogUtil.test;

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
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.metadata.coevolution.CoevolutionHistoryMetadata;
import org.sidiff.repair.history.generator.metadata.coevolution.CoevolutionVersionMetadata;

// TODO:
// - Zeile "others" mit aufnehmen, welche alle nicht betrachteten Modellhistorien summiert (Rev., Elem.,).

// - Report: pro Constraint -> Gleiche Spalte wie bei Projekttabelle
//   - Anzahl der Änderungen mit potentiell negativem Impact auswerten
//   - Constraint -> Anzahl der Verletzungen
// - Report: Für HOR -> CPEO x Violated Constraint

public class ReportGenerator implements IApplication {
	
	private static List<String> HISTORIES = HistoryEvaluationApplication.HISTORIES;
	
	private static final String ORIGINAL_DATA_SET = "C:\\evaluations\\org.eclipse.git_2018-08-22\\org.eclipse.git";
	
	private static final String RESOLVED_DATA_SET = "C:\\evaluations\\org.eclipse.git_2018-08-22\\org.eclipse.git.resolved";
	
	
	private static final boolean PROJECT_REPORT = true;
	
	private static final boolean MODEL_REPORT = false;
	
	private static final boolean LEGEND = true;
	
	
	private static final String[] COL_NAME = {"Project", "Project Name"};
	
	private static final String[] COL_MODELS = {"Models", "(Count of considered (inconsistent) models of the project. / Count of models in the project)"};
	
	private static final String[] COL_REVISIONS = {"Rev.", "Revisions (Commits of the considered models in the project. + Commits of other coevolving models.)"};
	
	private static final String[] COL_ELEMENTS = {"Elem.", "Elements (We first calculate the average of model elements of all revisions for each model. Then we sum the average model elements of all models."};
	
	private static final String[] COL_INCONSISTENCIES = {"Inc.", "RQ1 Inconsistencies (Count of all introduced inconsistencies in the project. | Count of all resolved inconsistencies. | Count of supported resolved inconsistencies.)"}; 
	
	private static final String[] COL_REPAIRED_INCONSISTENCY = {"RI", "RQ1 Repaired Inconsistencies (Supported resolved inconsistencies for wich we found at least one repair.)"};
	
	private static final String[] COL_HOR = {"HOR", "RQ2 Historically Observable Repairs (Repaired by completion. + Repaired by undo.)"};
	
	private static final String[] COL_REPIAR_ALTERNATIVE = {"RA", "RQ3 Repair Alternatives (min; avg; median; max)"};
	
	private static final String[] COL_HOR_RANKING = {"Prio.", "RQ3 Ranking Position of HOR (min; avg; median; max)"};
	
	private static final String[] COL_RUNTIME = {"T [ms]", "RQ4 Avg. Runtime [ms] (Loading the model revision and calculate the difference. + Partial recognition of sub-rules. + Deriving and matching the complement rule.)"};
	
	private class EvaluationData {
		File modelPath;
		LogTable editRulesLog, historyLog, inconsistenciesLog, recognitionLog;
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		LogTable projectReport = new LogTable();
		
		for (Entry<String, List<EvaluationData>> evaluationDataPerProject : getEvaluationsPerProject().entrySet()) {
			
			if (PROJECT_REPORT) {
				String name = new File(evaluationDataPerProject.getKey()).getName();
				name = name.substring(name.lastIndexOf(".") + 1, name.length());
				
				generateProjectReport(projectReport, name,
						evaluationDataPerProject.getValue().stream().map(data -> data.modelPath).collect(Collectors.toList()),
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
							evaluationData.modelPath,
							evaluationData.editRulesLog,
							evaluationData.historyLog,
							evaluationData.inconsistenciesLog,
							evaluationData.recognitionLog);
					
					System.out.println();
					System.out.println(convertToLatex(modelReport));
				}
			}
		}
		
		if (PROJECT_REPORT) {
			System.out.println();
			System.out.println(convertToLatex(projectReport));
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
	
	private void generateProjectReport(
			LogTable report,
			String name,
			List<File> modelPaths,
			List<LogTable> editRulesLog, 
			List<LogTable> historyLog, 
			List<LogTable> inconsistenciesLog, 
			List<LogTable> recognitionLog) {
		
		report.append(COL_NAME[0], name);
		report.append(COL_MODELS[0], formatFraction(
				countConsideredModelsPerProject(modelPaths), 
				countAllModelsPerProject(modelPaths)));
		report.append(COL_REVISIONS[0],formatSum(
				countVersionsPerModel(modelPaths.toArray(new File[0])),
				countCoevolutionVersionPerModel(modelPaths.toArray(new File[0]))));
		report.append(COL_ELEMENTS[0],
				sumAvgModelElementCount(historyLog.toArray(new LogTable[0])));
		report.append(COL_INCONSISTENCIES[0], formatFilter(
				sumAllInconsistencies(historyLog.toArray(new LogTable[0])),
				sumResolvedInconsistencies(inconsistenciesLog.toArray(new LogTable[0])),
				sumSupportedResolvedInconsistencies(inconsistenciesLog.toArray(new LogTable[0]))));
		report.append(COL_REPAIRED_INCONSISTENCY[0],
				countInconsistenciesWithAtLeastOneRepair(inconsistenciesLog.toArray(new LogTable[0])));
		report.append(COL_HOR[0], formatSum(
				countHistoricallyObservableRepairs(inconsistenciesLog.toArray(new LogTable[0])),
				countHistoricallyObservableUndos(inconsistenciesLog.toArray(new LogTable[0]))));
		report.append(COL_REPIAR_ALTERNATIVE[0], formatResults(
				minRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])),
				avgRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])),
				medianRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0])),
				maxRepairAlternatives(inconsistenciesLog.toArray(new LogTable[0]))));
		report.append(COL_HOR_RANKING[0], formatResults(
				minHORPriority(inconsistenciesLog.toArray(new LogTable[0])),
				avgHORPriority(inconsistenciesLog.toArray(new LogTable[0])),
				medianHORPriority(inconsistenciesLog.toArray(new LogTable[0])),
				maxHORPriority(inconsistenciesLog.toArray(new LogTable[0]))));
		report.append(COL_RUNTIME[0], formatSum(
				avgDifferenceTime(inconsistenciesLog.toArray(new LogTable[0])),
				avgRecognitionTime(inconsistenciesLog.toArray(new LogTable[0])),
				avgComplementMatchingTime(inconsistenciesLog.toArray(new LogTable[0]))));
	}
	
	private void generateModelReport(
			LogTable report,
			String name,
			File modelPath,
			LogTable editRulesLog, 
			LogTable historyLog, 
			LogTable inconsistenciesLog, 
			LogTable recognitionLog) {
		
		generateProjectReport(report, name, 
				Collections.singletonList(modelPath), 
				Collections.singletonList(editRulesLog), 
				Collections.singletonList(historyLog), 
				Collections.singletonList(inconsistenciesLog), 
				Collections.singletonList(recognitionLog));
	}
	
	private String formatSum(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append(" + ");
				}
			}
			
			return text.toString();
		}
	}
	
	private String formatFraction(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append("/");
				}
			}
			
			return text.toString();
		}
	}
	
	private String formatFilter(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append(" $\\geq$ ");
				}
			}
			
			return text.toString();
		}
	}
	
	private String formatResults(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append(" ; ");
				}
			}
			
			return text.toString();
		}
	}
	
	private boolean isNotAvailable(Object... values) {
		for (Object value : values) {
			if (value != NA) {
				return false;
			}
		}
		return true;
	}
	
	private Map<String, List<EvaluationData>> getEvaluationsPerProject() throws IOException {
		Map<String, List<EvaluationData>> evaluationDataPerProject = new LinkedHashMap<>();
		
		for (String history : HISTORIES) {
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
			
			// TODO: Better solution for getting the project relative path!?
			String modelPath = history.substring(history.indexOf("/") + 1, history.length());
			modelPath = modelPath.substring(modelPath.indexOf("/"), modelPath.length());
			
			EvaluationData data = new EvaluationData();
			data.modelPath = new File(modelPath).getParentFile();	
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
	
	private Object countConsideredModelsPerProject(List<File> modelPaths) {
		return TODO; // TODO
	}

	private Object countAllModelsPerProject(List<File> modelPaths) {
		return TODO; // TODO
	}

	private Object countVersionsPerModel(File... modelPaths) {
		return assertPositive(collectDatesPerModel(modelPaths).size());
	}
	
	private Set<String> collectDatesPerModel(File... modelPaths) {
		Set<String> evoluations = new HashSet<>();
		
		// TODO: Convenient way to get metadata!?
		for (File file : modelPaths) {
			File datafile = new File(ORIGINAL_DATA_SET + file.getPath() +  ".json");
			HistoryMetadata metadata = new HistoryMetadata(datafile, true);
			
			for (VersionMetadata version : metadata.getVersions()) {
				evoluations.add(version.getDate());
			}
		}
		
		return evoluations;
	}
	
	private Object countCoevolutionVersionPerModel(File... modelPaths) {
		Set<String> coevoluations = collectCoevolutionDatesPerModel(modelPaths);
		coevoluations.removeAll(collectDatesPerModel(modelPaths));
		return assertPositive(coevoluations.size());
	}
	
	private Set<String> collectCoevolutionDatesPerModel(File... modelPaths) {
		Set<String> coevoluations = new HashSet<>();
		
		// TODO: Convenient way to get metadata!?
		for (File file : modelPaths) {
			File datafile = new File(RESOLVED_DATA_SET + file.getPath() + File.separator + file.getName() +  ".json");
			CoevolutionHistoryMetadata metadata = new CoevolutionHistoryMetadata(datafile, true);
			
			for (VersionMetadata version : metadata.getVersions()) {
				CoevolutionVersionMetadata coVersion = (CoevolutionVersionMetadata) version;
				
				if (coVersion.hasCoevolutionDate()) {
					coevoluations.add(coVersion.getCoevolutionDate());
				}
			}
		}
		
		return coevoluations;
	}
	
	private Object sumAvgModelElementCount(LogTable... historyLogs) {
		return assertPositive(round(sum(merge(HistoryLog.COL_AVG_ELEMENTS, Integer.class, historyLogs))));
	}

	private Object sumAllInconsistencies(LogTable... historyLogs) {
		return assertPositive(sum(merge(HistoryLog.COL_INCONSISTENCY_TRACES, Integer.class, historyLogs)));
	}

	private Object sumSupportedResolvedInconsistencies(LogTable... inconsistenciesLog) {
		return test(merge(InconsistenciesLog.COL_COUNT_OF_REPAIR_TREES, Integer.class, inconsistenciesLog), (r) -> (r > 0));
	}

	private Object sumResolvedInconsistencies(LogTable... inconsistenciesLog) {
		return merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLog).size();
	}
	
	private Object countInconsistenciesWithAtLeastOneRepair(LogTable... inconsistenciesLog) {
		return assertPositive(test(merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLog), (r) -> (r > 0)));
	}

	private Object countHistoricallyObservableRepairs(LogTable... inconsistenciesLogs) {
		return assertPositive(count(merge(InconsistenciesLog.COL_HISTORICALLY_OBSERVABLE_REPAIRS, Boolean.class, inconsistenciesLogs), true));
	}

	private Object countHistoricallyObservableUndos(LogTable... inconsistenciesLogs) {
		return TODO; // TODO
	}

	private Object minRepairAlternatives(LogTable... inconsistenciesLogs) {
		return assertPositive(min(merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLogs)));
	}

	private Object avgRepairAlternatives(LogTable... inconsistenciesLogs) {
		return assertPositive(round(avg(merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLogs))));
	}

	private Object medianRepairAlternatives(LogTable... inconsistenciesLogs) {
		return assertPositive(median(merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLogs)));
	}

	private Object maxRepairAlternatives(LogTable... inconsistenciesLogs) {
		return assertPositive(max(merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLogs)));
	}

	private Object minHORPriority(LogTable... inconsistenciesLogs) {
		return assertPositive(min(merge(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class, inconsistenciesLogs)));
	}

	private Object avgHORPriority(LogTable... inconsistenciesLogs) {
		return assertPositive(round(avg(merge(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class, inconsistenciesLogs))));
	}

	private Object medianHORPriority(LogTable... inconsistenciesLogs) {
		return assertPositive(round(median(merge(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class, inconsistenciesLogs))));
	}

	private Object maxHORPriority(LogTable... inconsistenciesLogs) {
		return assertPositive(max(merge(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class, inconsistenciesLogs)));
	}

	private Object avgDifferenceTime(LogTable... inconsistenciesLogs) {
		return assertPositive(round(avg(merge(InconsistenciesLog.COL_TIME_LOAD_CALCULATE_REVISION, Integer.class, inconsistenciesLogs))));
	}

	private Object avgRecognitionTime(LogTable... inconsistenciesLogs) {
		return assertPositive(round(avg(merge(InconsistenciesLog.COL_TIME_RECOGNITION, Integer.class, inconsistenciesLogs))));
	}

	private Object avgComplementMatchingTime(LogTable... inconsistenciesLogs) {
		return assertPositive(round(avg(merge(InconsistenciesLog.COL_TIME_COMPLEMENT_MATCHING, Integer.class, inconsistenciesLogs))));
	}
	
	@Override
	public void stop() {
	}

}
