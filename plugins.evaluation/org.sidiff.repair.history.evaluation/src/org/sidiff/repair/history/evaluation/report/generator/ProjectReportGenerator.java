package org.sidiff.repair.history.evaluation.report.generator;

import static org.sidiff.consistency.common.monitor.LogUtil.NA;
import static org.sidiff.consistency.common.monitor.LogUtil.assertPositive;
import static org.sidiff.consistency.common.monitor.LogUtil.avg;
import static org.sidiff.consistency.common.monitor.LogUtil.convertToLatex;
import static org.sidiff.consistency.common.monitor.LogUtil.convertToLatexHeader;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.repair.history.evaluation.report.HistoryLog;
import org.sidiff.repair.history.evaluation.report.InconsistenciesLog;

public class ProjectReportGenerator {
	
	private static final boolean PROJECT_REPORT = true;
	
	private static final boolean MODEL_REPORT = false;
	
	private static final boolean LEGEND = true;
	
	private static final boolean LATEX_HEADER = true;
	
	private static final boolean RQ1 = true;
	private static final boolean RQ2 = true;
	private static final boolean RQ3 = false;
	private static final boolean RQ4 = false;
	
	// --------------------------------------------------------------------------------
	// Data Columns:
	// --------------------------------------------------------------------------------
		
	private static final String[] COL_NAME = {"Name", "colProjectName", "Project Name", "Project Name"};
	
	private static final String[] COL_MODELS_ALL = {"All", "colAllInconsistencies", "All Models", "Models (Count of all model histories in the project)"};
	
	private static final String[] COL_MODELS_INCONSISTENT = {"Inc.", "colInconsistentModels", "Inc. Models", "Models (Count of model histories with inconsistencies)"};
	
	private static final String[] COL_REVISIONS_INCONSISTENT = {"Source", "colSourceRevisions", "Source Revisions", "Revisions (Revisions of the model histories with inconsistencies)"};
	
	private static final String[] COL_REVISIONS_COEVOLVING = {"Co-ev.", "colCoRevisions", "Co-ev. Revisions", "Revisions (Revisions of other coevolving models (of the model histories with inconsistencie))"};
	
	private static final String[] COL_ELEMENTS = {"Avg.", "colAvgElements", "Avg. Elements", "Elements (We calculated the average of model elements for each revision (wich introduced and resolved an inconsistency) of a model history."};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_GROUP_PROJECT = {"Project", "Project Name", 
			COL_NAME};
	
	private static final Object[] COL_GROUP_MODELS = {"Models", "Model histories in the project", 
			COL_MODELS_ALL, COL_MODELS_INCONSISTENT};
	
	private static final Object[] COL_GROUP_REVISIONS = {"Revisions", "Revisions of the model histories in the projects", 
			COL_REVISIONS_INCONSISTENT, COL_REVISIONS_COEVOLVING};
	
	private static final Object[] COL_GROUP_ELEMENTS = {"Elements",  "Avg. count of model elements", 
			COL_ELEMENTS};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_RQ_SUBJECTS = {"Subject", "Selected evaluation subjects", 
			COL_GROUP_PROJECT, COL_GROUP_MODELS, COL_GROUP_REVISIONS, COL_GROUP_ELEMENTS};
	
	// --------------------------------------------------------------------------------
	
	private static final String[] COL_INCONSISTENCIES_RESOLVED = {"Total", "colTotalInconsistencies", "Total Inconsistencies", "RQ1 Inconsistencies (Count of all resolved inconsistencies)"};
	
	private static final String[] COL_INCONSISTENCIES_RESOLVED_SUPPORTED = {"Supp.", "colSupportedInconsistencies", "Supp. Inconsistencies", "RQ1 Inconsistencies (Count of supported resolved inconsistencies)"}; 
	
	private static final String[] COL_WELLFORMED_CONSTRAINTS = {"RegEx", "colRegExInconsistencies", "RegEx Inconsistencies", "Not Well Formed Constraints"}; 
	
	private static final String[] COL_REPAIRED_INCONSISTENCY = {"(At Least One)", "colRepairsFound", "Repairs Found", "RQ1 Repaired Inconsistencies (Supported resolved inconsistencies for wich we found at least one repair.)"};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_GROUP_INCONSISTENCIES = {"Inconsistencies", 
			COL_INCONSISTENCIES_RESOLVED, COL_WELLFORMED_CONSTRAINTS, COL_INCONSISTENCIES_RESOLVED_SUPPORTED};
	
	private static final Object[] COL_GROUP_REPAIRED_INCONSISTENCY = {"Repairs Found", 
			COL_REPAIRED_INCONSISTENCY};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_RQ_1 = {"RQ1", "Coverage: How many inconsistencies can be resolved by our approach?",
			COL_GROUP_INCONSISTENCIES, COL_GROUP_REPAIRED_INCONSISTENCY};
	
	// --------------------------------------------------------------------------------
	
	private static final String[] COL_HOR_COMPLETION = {"Completion", "colObservableCompletion", "Observable Completion", "RQ2 Historically Observable Repairs (Repaired by completion)"};
	
	private static final String[] COL_HOR_UNDO = {"Undo", "colObservableUndo", "Observable Undo", "RQ2 Historically Observable Repairs (Repaired by undo)"};
	
	private static final String[] COL_NOT_HOR_UNDO = {"Not Obs.", "colNotObservable", "Not Observable", "RQ2 Not Historically Observable Inconsistencies"};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_GROUP_OBSERVABLE = {"Observable", "Observable Repairs",
			COL_HOR_COMPLETION, COL_HOR_UNDO, COL_NOT_HOR_UNDO}; 
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_RQ_2 = {"RQ2", "If an inconsistency can be resolved by our approach, do we generate a repair alternative which corresponds to the changes that have been actually performed to resolve the respective inconsistency?",
			COL_GROUP_OBSERVABLE};
	
	// --------------------------------------------------------------------------------
	
	private static final String[] COL_REPIAR_ALTERNATIVE = {"RA", "colRepairAlternative", "Repair Alternatives", "RQ3 Repair Alternatives (min; avg; median; max)"};
	
	private static final String[] COL_HOR_RANKING = {"Prio.", "colHORRanking", "Prio.", "RQ3 Ranking Position of HOR (min; avg; median; max)"};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_GROUP_ALTERNATIVES = {"Alternatives", "Repair Alternatives",
			COL_REPIAR_ALTERNATIVE, COL_HOR_RANKING};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_RQ_3 = {"RQ3", "Efficiency: How many repair alternatives must be inspected by developers until they find a relevant one?",
			COL_GROUP_ALTERNATIVES};
	
	// --------------------------------------------------------------------------------
	
	private static final String[] COL_RUNTIME_DIFF = {"Diff.", "colRuntimeDiff", "Diff.", "RQ4 Avg. Runtime [ms] (Loading the model revision and calculate the difference)"};
	
	private static final String[] COL_RUNTIME_RECOGNITION = {"Sub-R.", "colRuntimeRecognition", "Sub-R.", "RQ4 Avg. Runtime [ms] (Partial recognition of sub-rules)"};
	
	private static final String[] COL_RUNTIME_COMPLEMENT = {"Compl.-R.", "colRuntimeComplement", "Compl.-R.", "RQ4 Avg. Runtime [ms] (Deriving and matching the complement rule)"};

	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_GROUP_RUNTIME = {"Runtime [ms]", "Runtimes per calculation phase",
			COL_RUNTIME_DIFF, COL_RUNTIME_RECOGNITION, COL_RUNTIME_COMPLEMENT};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COL_RQ_4 = {"RQ4", " Performance: How long does it take to generate the repair alternatives for a given inconsistency?",
			COL_GROUP_RUNTIME};
	
	// --------------------------------------------------------------------------------
	
	private static final Object[] COLS = {COL_RQ_SUBJECTS, COL_RQ_1, COL_RQ_2, COL_RQ_3, COL_RQ_4};
	
	// --------------------------------------------------------------------------------
	
	public ProjectReportGenerator() throws IOException, IllegalArgumentException, IllegalAccessException  {
		LogTable projectReport = new LogTable();
		Map<String, List<EvaluationData>> evaluationDataPerProjects = ReportGenerator.getEvaluationsPerProject();
		
		ReportGeneratorUtil.printSupportedResolvedInconsistencies(evaluationDataPerProjects.values().stream()
				.flatMap(Collection::stream)
				.map(data -> data.inconsistenciesLog)
				.collect(Collectors.toList()).toArray(new LogTable[0]));
		
		for (Entry<String, List<EvaluationData>> evaluationDataPerProject : evaluationDataPerProjects.entrySet()) {
			
			if (PROJECT_REPORT) {
				generateProjectReport(projectReport, evaluationDataPerProject.getKey(),
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
		
		generateOtherModelsReport(projectReport, evaluationDataPerProjects);
		generateSummaryOfProjectReport(projectReport);
		
		// Output:
		
		if (PROJECT_REPORT) {
			System.out.println();
			System.out.println(convertToLatexHeader(COLS));
			System.out.println(convertToLatex(projectReport));
			
			projectReport.toCSV(ReportGenerator.OUTPUT_FOLDER + "rq1-4.csv");
		}
		
		if (LATEX_HEADER) {
			System.out.println("% Tabellenkopf:");
			
			for (Field columnField : this.getClass().getDeclaredFields()) {
				if (columnField.getName().startsWith("COL_")) {
					if (columnField.get(this) instanceof String[]) {
						String[] columnDefinition = (String[]) columnField.get(this);
						System.out.println("\\newcommand{\\" + columnDefinition[1] + "}{\\textit{" + columnDefinition[2] + "}\\xspace}");
					}
				}
			}
		}
		
		if (LEGEND) {
			System.out.println();
			System.out.println("\\begin{itemize}");
			System.out.println("\\begin{tiny}");
			
			for (Field columnField : this.getClass().getDeclaredFields()) {
				if (columnField.getName().startsWith("COL_")) {
					if (columnField.get(this) instanceof String[]) {
						String[] columnDefinition = (String[]) columnField.get(this);
						System.out.println("  \\item " + columnDefinition[0] + " $\\to$ " + columnDefinition[3]);
					}
				}
			}
			
			System.out.println("\\end{tiny}");
			System.out.println("\\end{itemize}");
		}
	}
	
	private void generateProjectReport(
			LogTable report,
			String name,
			List<File> modelPaths,
			List<LogTable> editRulesLog, 
			List<LogTable> historyLog, 
			List<LogTable> inconsistenciesLog, 
			List<LogTable> recognitionLog) throws IOException {
		
		List<History> histories = ReportGenerator.getProjectHistory_Reduced(modelPaths.get(0).getParentFile());
		LogTable[] inconsistencies = inconsistenciesLog.toArray(new LogTable[0]);
		
		report.append(COL_NAME[0], 
				name);
		report.append(COL_MODELS_ALL[0], 
				countAllModelsPerProject(modelPaths.get(0).getParentFile()));
		report.append(COL_MODELS_INCONSISTENT[0],
				countConsideredModelsPerProject(modelPaths));
		report.append(COL_REVISIONS_INCONSISTENT[0],
				countVersionsPerModel(modelPaths.toArray(new File[0])));
		report.append(COL_REVISIONS_COEVOLVING[0],
				countCoevolutionVersionPerModel(modelPaths.toArray(new File[0])));
		report.append(COL_ELEMENTS[0],
				avgModelElementCount(historyLog.toArray(new LogTable[0])));
		
		if (RQ1) {
			report.append(COL_INCONSISTENCIES_RESOLVED[0],
					sumResolvedInconsistencies(histories.toArray(new History[0])));
			report.append(COL_WELLFORMED_CONSTRAINTS[0], 
					sumWellFormedConstraints(histories.toArray(new History[0])));
			report.append(COL_INCONSISTENCIES_RESOLVED_SUPPORTED[0],
					sumSupportedResolvedInconsistencies(inconsistencies));
			report.append(COL_REPAIRED_INCONSISTENCY[0],
					countInconsistenciesWithAtLeastOneRepair(inconsistencies));
		}
		
		if (RQ2) {
			report.append(COL_HOR_COMPLETION[0],
					countHistoricallyObservableRepairs(inconsistencies));
			report.append(COL_HOR_UNDO[0],
					countHistoricallyObservableUndos(inconsistencies));
			report.append(COL_NOT_HOR_UNDO[0], 
					calculateNotHistoricallyObservables(inconsistencies));
		}
		
		if (RQ3) {
			report.append(COL_REPIAR_ALTERNATIVE[0], ReportGeneratorUtil.formatResults(
					minRepairAlternatives(inconsistencies),
					avgRepairAlternatives(inconsistencies),
					medianRepairAlternatives(inconsistencies),
					maxRepairAlternatives(inconsistencies)));
			report.append(COL_HOR_RANKING[0], ReportGeneratorUtil.formatResults(
					minHORPriority(inconsistencies),
					avgHORPriority(inconsistencies),
					medianHORPriority(inconsistencies),
					maxHORPriority(inconsistencies)));
		}
		
		if (RQ4) {
			report.append(COL_RUNTIME_DIFF[0],
					avgDifferenceTime(inconsistencies));
			report.append(COL_RUNTIME_RECOGNITION[0],
					avgRecognitionTime(inconsistencies));
			report.append(COL_RUNTIME_COMPLEMENT[0],
					avgComplementMatchingTime(inconsistencies));
		}
	}

	private void generateOtherModelsReport(LogTable report, Map<String, List<EvaluationData>> evaluationDataPerProjects) throws IOException {
		
		// Count all models:
		long allModels = ReportGenerator.getAllMetadata_Original().size();
		
		// Count all models of considered projects:
		int consideredModels = 0;
		
		for (List<EvaluationData> data : evaluationDataPerProjects.values()) {
			Object modelsPerProject = countAllModelsPerProject(data.get(0).modelPath.getParentFile());
			
			if (modelsPerProject instanceof Integer) {
				consideredModels += (int) modelsPerProject;
			}
		}
		
		// Count all unconsidered projects:
		int unconsideredProjects = ReportGenerator.getProjects_Original().size() - ReportGenerator.getProjects_Reduced().size();
		
		report.append(COL_NAME[0], unconsideredProjects + " Others");
		report.append(COL_MODELS_ALL[0], allModels - consideredModels);
		report.append(COL_MODELS_INCONSISTENT[0], 0);
		report.append(COL_REVISIONS_INCONSISTENT[0], NA);
		report.append(COL_REVISIONS_COEVOLVING[0], NA);
		report.append(COL_ELEMENTS[0], NA);
		
		if (RQ1) {
			report.append(COL_INCONSISTENCIES_RESOLVED[0], 0); // TODO: automatically re-check
			report.append(COL_WELLFORMED_CONSTRAINTS[0], 0); // TODO: automatically re-check
			report.append(COL_INCONSISTENCIES_RESOLVED_SUPPORTED[0], 0); // TODO: automatically re-check
			report.append(COL_REPAIRED_INCONSISTENCY[0], NA);
		}
		
		if (RQ2) {
			report.append(COL_HOR_COMPLETION[0], NA);
			report.append(COL_HOR_UNDO[0], NA);
			report.append(COL_NOT_HOR_UNDO[0], NA);
		}
		
		if (RQ3) {
			report.append(COL_REPIAR_ALTERNATIVE[0], NA);
			report.append(COL_HOR_RANKING[0], NA);
		}
		
		if (RQ4) {
			report.append(COL_RUNTIME_DIFF[0], NA);
			report.append(COL_RUNTIME_RECOGNITION[0], NA);
			report.append(COL_RUNTIME_COMPLEMENT[0], NA);
		}
	}
	
	private void generateSummaryOfProjectReport(LogTable report) {
		
		// Summarize all projects:
		report.append(COL_NAME[0], "Summary");
		report.append(COL_MODELS_ALL[0], sum(report.getColumn(COL_MODELS_ALL[0], Integer.class)));
		report.append(COL_MODELS_INCONSISTENT[0], sum(report.getColumn(COL_MODELS_INCONSISTENT[0], Integer.class)));
		report.append(COL_REVISIONS_INCONSISTENT[0], sum(report.getColumn(COL_REVISIONS_INCONSISTENT[0], Integer.class)));
		report.append(COL_REVISIONS_COEVOLVING[0], sum(report.getColumn(COL_REVISIONS_COEVOLVING[0], Integer.class)));
		report.append(COL_ELEMENTS[0], round(avg(report.getColumn(COL_ELEMENTS[0], Long.class))));
		
		if (RQ1) {
			report.append(COL_INCONSISTENCIES_RESOLVED[0], sum(report.getColumn(COL_INCONSISTENCIES_RESOLVED[0], Integer.class)));
			report.append(COL_WELLFORMED_CONSTRAINTS[0], sum(report.getColumn(COL_WELLFORMED_CONSTRAINTS[0], Integer.class)));
			report.append(COL_INCONSISTENCIES_RESOLVED_SUPPORTED[0], sum(report.getColumn(COL_INCONSISTENCIES_RESOLVED_SUPPORTED[0], Integer.class)));
			report.append(COL_REPAIRED_INCONSISTENCY[0], sum(report.getColumn(COL_REPAIRED_INCONSISTENCY[0], Integer.class)));
		}
		
		if (RQ2) {
			report.append(COL_HOR_COMPLETION[0], sum(report.getColumn(COL_HOR_COMPLETION[0], Integer.class)));
			report.append(COL_HOR_UNDO[0], sum(report.getColumn(COL_HOR_UNDO[0], Integer.class)));
			report.append(COL_NOT_HOR_UNDO[0], sum(report.getColumn(COL_NOT_HOR_UNDO[0], Integer.class)));
		}
		
		if (RQ3) {
			report.append(COL_REPIAR_ALTERNATIVE[0], sum(report.getColumn(COL_REPIAR_ALTERNATIVE[0], Integer.class)));
			report.append(COL_HOR_RANKING[0], sum(report.getColumn(COL_HOR_RANKING[0], Integer.class)));
		}
		
		if (RQ4) {
			report.append(COL_RUNTIME_DIFF[0], sum(report.getColumn(COL_RUNTIME_DIFF[0], Integer.class)));
			report.append(COL_RUNTIME_RECOGNITION[0], sum(report.getColumn(COL_RUNTIME_RECOGNITION[0], Integer.class)));
			report.append(COL_RUNTIME_COMPLEMENT[0], sum(report.getColumn(COL_RUNTIME_COMPLEMENT[0], Integer.class)));
		}
	}
	
	private void generateModelReport(
			LogTable report,
			String name,
			File modelPath,
			LogTable editRulesLog, 
			LogTable historyLog, 
			LogTable inconsistenciesLog, 
			LogTable recognitionLog) throws IOException {
		
		generateProjectReport(report, name, 
				Collections.singletonList(modelPath), 
				Collections.singletonList(editRulesLog), 
				Collections.singletonList(historyLog), 
				Collections.singletonList(inconsistenciesLog), 
				Collections.singletonList(recognitionLog));
	}
	
	private Object countConsideredModelsPerProject(List<File> modelPaths) {
		return modelPaths.size();
	}

	private Object countAllModelsPerProject(File projectFolder) {
		return ReportGenerator.getProjectMetadata_Original(projectFolder).size();
	}

	private Object countVersionsPerModel(File... modelPaths) {
		return assertPositive(ReportGenerator.collectDatesPerModel(modelPaths).size());
	}
	
	private Object countCoevolutionVersionPerModel(File... modelPaths) {
		Set<String> coevoluations = ReportGenerator.collectCoevolutionDatesPerModel(modelPaths);
		coevoluations.removeAll(ReportGenerator.collectDatesPerModel(modelPaths));
		return assertPositive(coevoluations.size());
	}

	private Object avgModelElementCount(LogTable... historyLogs) {
		return assertPositive(round(avg(merge(HistoryLog.COL_AVG_ELEMENTS, Integer.class, historyLogs))));
	}
	
//	private Object sumResolvedInconsistencies(LogTable... inconsistenciesLog) {
	private Object sumResolvedInconsistencies(History... histories) {
		
		// TODO: Report all resolved inconsistencies...
//		return merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLog).size();
		int count = 0;
		
		for (History history : histories) {
			count += history.getUniqueProblems().stream().filter(Problem::isResolved).count();
		}
		
		return count;
	}
	
	private Object sumSupportedResolvedInconsistencies(LogTable... inconsistenciesLog) {
		return assertPositive(test(merge(InconsistenciesLog.COL_COUNT_OF_REPAIR_TREES, Integer.class, inconsistenciesLog), (r) -> (r > 0)));
	}
	
	private Object sumWellFormedConstraints(History... histories) {
		int sumOfNotWellFormedConstraints = 0;
		
		for (History history : histories) {
			for (Problem problem : history.getUniqueProblems()) {
				if (problem.getName().contains("NotWellFormed")) {
					++sumOfNotWellFormedConstraints;
				}
			}
		}
		
		return sumOfNotWellFormedConstraints;
	}
	
	private Object countInconsistenciesWithAtLeastOneRepair(LogTable... inconsistenciesLog) {
		return assertPositive(test(merge(InconsistenciesLog.COL_COMPLEMENTS, Integer.class, inconsistenciesLog), (r) -> (r > 0)));
	}

	private Object countHistoricallyObservableRepairs(LogTable... inconsistenciesLogs) {
		return assertPositive(count(merge(InconsistenciesLog.COL_BEST_HOR_IS_UNDO, Boolean.class, inconsistenciesLogs), false));
	}

	private Object countHistoricallyObservableUndos(LogTable... inconsistenciesLogs) {
		return assertPositive(count(merge(InconsistenciesLog.COL_BEST_HOR_IS_UNDO, Boolean.class, inconsistenciesLogs), true));
	}
	
	private Object calculateNotHistoricallyObservables(LogTable... inconsistenciesLogs) {
		Object hou = countHistoricallyObservableUndos(inconsistenciesLogs);
		Object hor = countHistoricallyObservableRepairs(inconsistenciesLogs);
		Object supportedInconsistencies = sumSupportedResolvedInconsistencies(inconsistenciesLogs);
		
		if ((hou instanceof Integer) && (hor instanceof Integer) && (supportedInconsistencies instanceof Integer)) {
			return (int) supportedInconsistencies - ((int) hou + (int) hor);
		}
		
		return LogUtil.FIXME;
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
}
