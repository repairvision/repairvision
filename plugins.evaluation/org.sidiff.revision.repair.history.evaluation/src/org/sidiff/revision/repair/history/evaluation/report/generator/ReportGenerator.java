package org.sidiff.revision.repair.history.evaluation.report.generator;

import java.io.File;
import java.io.FileFilter;
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
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.historymodel.History;
import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.repair.history.evaluation.EvaluationDataSets;
import org.sidiff.revision.repair.history.evaluation.report.EditRulesLog;
import org.sidiff.revision.repair.history.evaluation.report.HistoryLog;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;
import org.sidiff.revision.repair.history.evaluation.report.RecognitionLog;
import org.sidiff.revision.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.VersionMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.coevolution.CoevolutionHistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.coevolution.CoevolutionVersionMetadata;

public class ReportGenerator implements IApplication {
	
	private static FileFilter FILTER_INVISIBLE = new FileFilter() {
		
		@Override
		public boolean accept(File pathname) {
			return !pathname.getName().startsWith(".");
		}
	};
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		System.out.println(EvaluationDataSets.print());
		
		new ProjectReportGenerator();
		new ProjectReportGeneratorDiagrams();
		new InconsistencyReportGenerator();
		new AnnotationReportGenerator();
		new NumberReportGenerator();
		
		return IApplication.EXIT_OK;
	}
	
	public static Map<String, List<EvaluationData>> getEvaluationsPerProject() throws IOException {
		Map<String, List<EvaluationData>> evaluationDataPerProject = new LinkedHashMap<>();
		
		for (String modelPath : EvaluationDataSets.HISTORIES) {
			File historyFolder = new File(EvaluationDataSets.RESULTS_DATA_SET + modelPath).getParentFile();
			EvaluationData data = new EvaluationData();
			data.modelPath = new File(modelPath).getParentFile();
			
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

			Optional<Path> editRulesCSVPath = Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString()
					.endsWith(EditRulesLog.NAME + ".csv")).findAny();

			if (editRulesCSVPath.isPresent()) {
				Path editRulesCSV =  editRulesCSVPath.get();
				LogTable editRulesLog = new LogTable();
				editRulesLog.loadCSV(editRulesCSV.toString());
				
				data.editRulesLog = editRulesLog;
			}
			
			Optional<Path> historyCSVPath = Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString()
					.endsWith(HistoryLog.NAME + ".csv")).findAny();
			
			if (historyCSVPath.isPresent()) {
				Path historyCSV =  historyCSVPath.get();
				LogTable historyLog = new LogTable();
				historyLog.loadCSV(historyCSV.toString());
				
				data.historyLog = historyLog;
			}
			
			Optional<Path> inconsistenciesCSVPath = Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString()
					.endsWith(InconsistenciesLog.NAME + ".csv")).findAny();
			
			if (inconsistenciesCSVPath.isPresent()) {
				Path inconsistenciesCSV =  inconsistenciesCSVPath.get();
				LogTable inconsistenciesLog = new LogTable();
				inconsistenciesLog.loadCSV(inconsistenciesCSV.toString());
				
				data.inconsistenciesLog = inconsistenciesLog;
			}
			
			Optional<Path> recognitionCSVPath = Files.find(lastEvaluation, 1,
					(path, attributes) -> path.getFileName().toString()
					.endsWith(RecognitionLog.NAME + ".csv")).findAny();
			
			if (recognitionCSVPath.isPresent()) {
				Path recognitionCSV =  recognitionCSVPath.get();
				LogTable recognitionLog = new LogTable();
				recognitionLog.loadCSV(recognitionCSV.toString());
				
				data.recognitionLog = recognitionLog;
			}
			
			if (data.isComplete()) {
				String projectName = getProjectName(historyFolder.getParentFile());
				List<EvaluationData> dataPerProject = evaluationDataPerProject.getOrDefault(projectName, new ArrayList<>());
				evaluationDataPerProject.put(projectName, dataPerProject);
				dataPerProject.add(data);
			} else {
				System.err.println("Incomplete Evaluation Data: " + data.modelPath);
			}
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
		
		for (File file : modelPaths) {
			File datafile = new File(EvaluationDataSets.ORIGINAL_DATA_SET + file.getPath() +  ".json");
			HistoryMetadata metadata = new HistoryMetadata(datafile, true);
			
			for (VersionMetadata version : metadata.getVersions()) {
				evoluations.add(version.getDate());
			}
		}
		
		return evoluations;
	}
	
	public static Set<String> collectCoevolutionDatesPerModel(File... modelPaths) {
		Set<String> coevoluations = new HashSet<>();
		
		for (File file : modelPaths) {
			File datafile = new File(EvaluationDataSets.RESOLVED_DATA_SET + file.getPath() + File.separator + file.getName() +  ".json");
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
	
	public static List<File> getAllMetadata_Result() throws IOException {
		return EvaluationDataSets.HISTORIES.stream().map(path -> new File(EvaluationDataSets.RESULTS_DATA_SET + path)).collect(Collectors.toList());
	}
	
	public static List<File> getAllMetadata_Original() throws IOException {
		return Files.find(Paths.get(EvaluationDataSets.ORIGINAL_DATA_SET), Integer.MAX_VALUE, 
				(path, attribte) -> path.getFileName().toString().endsWith(".json"))
				.map(Path::toFile).collect(Collectors.toList());
	}
	
	public static List<File> getProjectMetadata_Original(File projectFolder) {
		List<File> files = new ArrayList<>(); 
		File projectPath = new File(EvaluationDataSets.ORIGINAL_DATA_SET + projectFolder.getPath());
		
		for (File metadata : projectPath.listFiles()) {
			if (metadata.getName().endsWith(".json")) {
				files.add(metadata);
			}
		}
		
		return files;
	}
	
	public static List<File> getProjectMetadata_Result(File projectFolder) throws IOException {
		return EvaluationDataSets.HISTORIES.stream().map(path -> new File(EvaluationDataSets.RESULTS_DATA_SET + path))
				.filter(file -> file.getPath().contains(projectFolder.getPath())).collect(Collectors.toList());
	}
	
	public static List<History> getProjectHistory_Result(File projectFolder) throws IOException {
		List<History> histories = new ArrayList<>();
		
		for (File historyFile : ReportGenerator.getProjectMetadata_Result(projectFolder)) {
			History history = (History) new ResourceSetImpl()
					.getResource(URI.createFileURI(historyFile.getAbsolutePath()), true)
					.getContents().get(0); 
			histories.add(history);
		}
		
		return histories;
	}
	
	public static List<File> getProjects_Original() {
		return Arrays.asList(new File(EvaluationDataSets.ORIGINAL_DATA_SET).listFiles(FILTER_INVISIBLE));
	}
	
	public static List<File> getProjects_Reduced() {
		return Arrays.asList(new File(EvaluationDataSets.REDUCED_DATA_SET).listFiles(FILTER_INVISIBLE));
	}
	
	@Override
	public void stop() {
	}
}
