package org.sidiff.revision.repair.history.evaluation.report.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.logging.util.LogUtil;
import org.sidiff.revision.repair.history.evaluation.EvaluationDataSets;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryExtension;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.registry.IConstraintLibrary;
import org.sidiff.validation.constraint.project.registry.util.ConstraintLibraryUtil;

public class InconsistencyReportGenerator {
	
	public static final String[] COL_INCONSISTENCY = new String[] {"Consistency rule descriptions (with placeholders {i} for specific inconsistencies)", "Inconsistency Name"};
	
	public static final String[] COL_INCONSISTENCY_COUNT = new String[] {"Violations", "Inconsistency Violation Count"};
	
	public static final String[] COL_SUPPORTED_CONSTRAINT = new String[] {"Supported", "Supported Constraint"};
	
	public static final String[] COL_PROJECTS = new String[] {"Projects", "Projects in which the inconsistencies occur"};
	
	public static final String VALUE_YES = "yes";
	
	public static final String VALUE_NO = "no";

	private static class ProjectSet extends HashSet<String> {
		
		private static final long serialVersionUID = 1L;

		@Override
		public String toString() {
			StringBuilder string = new StringBuilder();
			
			for (String project : this) {
				string.append(project);
				string.append(", ");
			}
			
			string.setLength(string.length() - 2);
			return string.toString();
		}
	}
	
	public InconsistencyReportGenerator() throws IOException {
		
		// Print Latex table:
		System.out.println();
		System.out.println(LogUtil.convertToLatex(generate()));
	}
	
	public static LogTable generate() throws IOException {
		Map<String, LogTable> inconsistencyLogs = new LinkedHashMap<>();
		
		// Analyze metadata:
		for (File historyFile : ReportGenerator.getAllMetadata_Result()) {
			History history = (History) new ResourceSetImpl()
					.getResource(URI.createFileURI(historyFile.getAbsolutePath()), true)
					.getContents().get(0);  
			
			for (Problem problem : history.getUniqueProblems()) {
				String inconsistency = problem.getName();
				inconsistency = inconsistency.substring(0, Math.min(120, inconsistency.length()));
				LogTable reportForInconsistency = inconsistencyLogs.get(inconsistency);
				
				String project = getProjectName(problem);
				
				if (reportForInconsistency == null) {
					reportForInconsistency = new LogTable();
					inconsistencyLogs.put(inconsistency, reportForInconsistency);
					
					reportForInconsistency.append(COL_INCONSISTENCY[0], inconsistency);
					reportForInconsistency.append(COL_INCONSISTENCY_COUNT[0], 1);
					
					ProjectSet projects = new ProjectSet();
					projects.add(project);
					reportForInconsistency.append(COL_PROJECTS[0], projects);
				} else {
					int count = reportForInconsistency.getColumn(COL_INCONSISTENCY_COUNT[0], Integer.class).get(0);
					reportForInconsistency.set(COL_INCONSISTENCY_COUNT[0], 0, count + 1);
					
					ProjectSet projects = reportForInconsistency.getColumn(COL_PROJECTS[0], ProjectSet.class).get(0);
					
					if (!projects.contains(project)) {
						projects.add(project);
					}
				}
			}
		}
		
		LogTable inconsistencyLog = LogUtil.merge(inconsistencyLogs.values().toArray(new LogTable[0]));
		
		// Supported constraints:
		List<String> supportedConstraints = new ArrayList<>();
		
		List<IConstraintLibrary> libraries = ConstraintLibraryRegistry.getConstraintLibraries().stream()
				.map(ConstraintLibraryExtension::getConstraintLibrary).collect(Collectors.toList());

		for (String constraintName : inconsistencyLog.getColumn(COL_INCONSISTENCY[0], String.class)) {
			IConstraint constraint = ConstraintLibraryUtil.getConsistencyRule(libraries, constraintName);
			
			if (constraint != null) {
				supportedConstraints.add(VALUE_YES);
			} else {
				supportedConstraints.add(VALUE_NO);
			}
		}
		
		inconsistencyLog.createColumn(COL_SUPPORTED_CONSTRAINT[0], supportedConstraints);
		
		return inconsistencyLog;
	}
	
	private static String getProjectName(Problem problem) {
		String projectFullName = problem.eResource().getURI().toFileString();
		projectFullName = projectFullName.substring(EvaluationDataSets.RESULTS_DATA_SET.length(), projectFullName.length());
		projectFullName = projectFullName.replace("\\", "/");
		projectFullName = projectFullName.substring(0, projectFullName.indexOf("/"));
		
		if (projectFullName.contains(".")) {
			return projectFullName.substring(projectFullName.lastIndexOf(".") + 1, projectFullName.length());
		} else {
			return projectFullName;
		}
	}
}
