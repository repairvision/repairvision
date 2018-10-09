package org.sidiff.repair.history.evaluation.report.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
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

public class ReportGenerator implements IApplication {
	
	private static List<String> HISTORIES = HistoryEvaluationApplication.HISTORIES;
	
	private static final String ORIGINAL_DATA_SET = "C:\\evaluations\\org.eclipse.git_2018-08-22\\org.eclipse.git";
	
	private static final String RESOLVED_DATA_SET = "C:\\evaluations\\org.eclipse.git_2018-08-22\\org.eclipse.git.resolved";
	
	private static final String REDUCED_DATA_SET = "C:\\evaluations\\org.eclipse.git_2018-08-22\\org.eclipse.git.reduced";
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		new ProjectReportGenerator();
		new InconsistencyReportGenerator();
		new EditRuleReportGenerator();
		
		return IApplication.EXIT_OK;
	}
	
	public static Map<String, List<EvaluationData>> getEvaluationsPerProject() throws IOException {
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
			
			String projectName = getProjectName(historyFolder.getParentFile());
			List<EvaluationData> dataPerProject = evaluationDataPerProject.getOrDefault(projectName, new ArrayList<>());
			evaluationDataPerProject.put(projectName, dataPerProject);
			dataPerProject.add(data);
		}
		
		// sort by key:
		evaluationDataPerProject = evaluationDataPerProject.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(
						Entry::getKey, Entry::getValue,
						(a, b) -> {a.addAll(b); return a;},
						LinkedHashMap::new));
		
		return evaluationDataPerProject;
	}
	
	private static String getProjectName(File modelPath) {
		String name = modelPath.getName();
		name = name.substring(name.lastIndexOf(".") + 1, name.length());
		return name;
	}
	
	public static Set<String> collectDatesPerModel(File... modelPaths) {
		Set<String> evoluations = new HashSet<>();
		
		// TODO: Convenient way to get metadata!?
		for (File file : modelPaths) {
			File datafile = new File(ReportGenerator.ORIGINAL_DATA_SET + file.getPath() +  ".json");
			HistoryMetadata metadata = new HistoryMetadata(datafile, true);
			
			for (VersionMetadata version : metadata.getVersions()) {
				evoluations.add(version.getDate());
			}
		}
		
		return evoluations;
	}
	
	public static Set<String> collectCoevolutionDatesPerModel(File... modelPaths) {
		Set<String> coevoluations = new HashSet<>();
		
		// TODO: Convenient way to get metadata!?
		for (File file : modelPaths) {
			File datafile = new File(ReportGenerator.RESOLVED_DATA_SET + file.getPath() + File.separator + file.getName() +  ".json");
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
	
	public static List<File> getAllMetadata_Reduced() throws IOException {
//		return Files.find(Paths.get(ReportGenerator.REDUCED_DATA_SET), Integer.MAX_VALUE, 
//				(path, attribte) -> path.getFileName().toString().endsWith(".history"))
//				.map(Path::toFile).collect(Collectors.toList());
		return HISTORIES.stream().map(path -> new File(path.replace("/org.eclipse.git.evaluation", REDUCED_DATA_SET))).collect(Collectors.toList());
	}
	
	public static List<File> getAllMetadata_Original() throws IOException {
		return Files.find(Paths.get(ReportGenerator.ORIGINAL_DATA_SET), Integer.MAX_VALUE, 
				(path, attribte) -> path.getFileName().toString().endsWith(".json"))
				.map(Path::toFile).collect(Collectors.toList());
	}
	
	public static List<File> getProjectMetadata_Original(File projectFolder) {
		List<File> files = new ArrayList<>(); 
		
		// TODO: Convenient way to get metadata!?
		File projectPath = new File(ReportGenerator.ORIGINAL_DATA_SET + projectFolder.getPath());
		
		for (File metadata : projectPath.listFiles()) {
			if (metadata.getName().endsWith(".json")) {
				files.add(metadata);
			}
		}
		
		return files;
	}
	
	public static List<File> getProjects_Original() {
		return Arrays.asList(new File(ReportGenerator.ORIGINAL_DATA_SET).listFiles());
	}
	
	public static List<File> getProjects_Reduced() {
		return Arrays.asList(new File(ReportGenerator.REDUCED_DATA_SET).listFiles());
	}
	
	@Override
	public void stop() {
	}

}
