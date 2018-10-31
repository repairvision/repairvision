package org.sidiff.repair.history.evaluation.report.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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

// TODO:
// - Report: pro Constraint -> Gleiche Spalte wie bei Projekttabelle
// - Anzahl der Änderungen mit potentiell negativem Impact auswerten
// - Constraint -> Anzahl der Verletzungen
public class InconsistencyReportGenerator {
	
	private static final String[] COL_INCONSISTENCY = new String[] {"Inconsistency", "Inconsistency Name"};
	
	private static final String[] COL_INCONSISTENCY_COUNT = new String[] {"Violations", "Inconsistency Violation Count"};
	
	private static final String[] COL_SUPPORTED_CONSTRAINT = new String[] {"Supported", "Supported Constraint"};

	public InconsistencyReportGenerator() throws IOException {
		Map<String, LogTable> inconsistencyLogs = new LinkedHashMap<>();
		
		// Analyze metadata:
		for (File historyFile : ReportGenerator.getAllMetadata_Reduced()) {
			History history = (History) new ResourceSetImpl()
					.getResource(URI.createFileURI(historyFile.getAbsolutePath()), true)
					.getContents().get(0);  
			
			for (Problem problem : history.getUniqueProblems()) {
				String inconsistency = problem.getName();
				inconsistency = inconsistency.substring(0, Math.min(120, inconsistency.length())); // TODO
				
				LogTable reportForInconsistency = inconsistencyLogs.get(inconsistency);
				
				if (reportForInconsistency == null) {
					reportForInconsistency = new LogTable();
					inconsistencyLogs.put(inconsistency, reportForInconsistency);
					
					reportForInconsistency.append(COL_INCONSISTENCY[0], inconsistency);
					reportForInconsistency.append(COL_INCONSISTENCY_COUNT[0], 1);
				} else {
					int count = reportForInconsistency.getColumn(COL_INCONSISTENCY_COUNT[0], Integer.class).get(0);
					reportForInconsistency.set(COL_INCONSISTENCY_COUNT[0], 0, count + 1);
				}
			}
		}
		
		LogTable inconsistencyLog = LogUtil.merge(inconsistencyLogs.values().toArray(new LogTable[0]));
		
		// Supported constraints:
		List<Boolean> supportedConstraints = new ArrayList<>();
		
		for (String constraintName : inconsistencyLog.getColumn(COL_INCONSISTENCY[0], String.class)) {
			List<IConstraintLibrary> libraries = ConstraintLibraryRegistry.getLibraries().values().stream()
					.flatMap(Collection::stream).collect(Collectors.toList());
			IConstraint constraint = ConstraintLibraryUtil.getConsistencyRule(libraries, constraintName);
			
			if (constraint != null) {
				supportedConstraints.add(true);
			} else {
				supportedConstraints.add(false);
			}
		}
		
		inconsistencyLog.createColumn(COL_SUPPORTED_CONSTRAINT[0], supportedConstraints);
		
		// Print Latex table:
		System.out.println();
		System.out.println(LogUtil.convertToLatex(inconsistencyLog));
	}
}
