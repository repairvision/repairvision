package org.sidiff.repair.history.evaluation.report.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.validation.constraint.api.library.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.api.library.IConstraintLibrary;
import org.sidiff.validation.constraint.api.library.util.ConstraintLibraryUtil;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class InconsistencyReportGenerator {
	
	private static final String[] COL_INCONSISTENCY = new String[] {"Consistency rule descriptions (with placeholders {i} for specific inconsistencies)", "Inconsistency Name"};
	
	private static final String[] COL_INCONSISTENCY_COUNT = new String[] {"Violations", "Inconsistency Violation Count"};
	
	private static final String[] COL_SUPPORTED_CONSTRAINT = new String[] {"Supported", "Supported Constraint"};
	
	private static final String[] COL_PROJECTS = new String[] {"Projects", "Projects in which the inconsistencies occur"};

	private String getProjectName(Problem problem) {
		String projectFullName = problem.eResource().getURI().segment(3); // TODO: Depends on local path
		
		if (projectFullName.contains(".")) {
			return projectFullName.substring(projectFullName.lastIndexOf(".") + 1, projectFullName.length());
		} else {
			return projectFullName;
		}
	}
	
	private class ProjectSet extends HashSet<String> {
		
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
		Map<String, LogTable> inconsistencyLogs = new LinkedHashMap<>();
		
		// Analyze metadata:
		for (File historyFile : ReportGenerator.getAllMetadata_Reduced()) {
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
		
		List<IConstraintLibrary> libraries = ConstraintLibraryRegistry.getLibraries().values().stream()
				.flatMap(Collection::stream).collect(Collectors.toList());
		
		for (String constraintName : inconsistencyLog.getColumn(COL_INCONSISTENCY[0], String.class)) {
			IConstraint constraint = ConstraintLibraryUtil.getConsistencyRule(libraries, constraintName);
			
			if (constraint != null) {
				supportedConstraints.add("yes");
			} else {
				supportedConstraints.add("no");
			}
		}
		
		inconsistencyLog.createColumn(COL_SUPPORTED_CONSTRAINT[0], supportedConstraints);
		
		// Print Latex table:
		System.out.println();
		System.out.println(LogUtil.convertToLatex(inconsistencyLog));
	}
}
