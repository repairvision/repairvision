package org.sidiff.repair.history.evaluation.report.generator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;
import org.sidiff.repair.history.evaluation.report.InconsistenciesLog;
import org.sidiff.validation.constraint.api.ValidationFacade;

public class NumberReportGenerator {
	
	private static String PATH_GRAPH_PATTERNS = "/org.sidiff.ecore.editrules.repair.evaluation/patterns/ecore.graphpattern";
	
	private static String PATH_EDIT_RULES = "/org.sidiff.ecore.editrules.repair.evaluation/patterns/ecore_editrules.graphpattern";
	
	private static Resource DOC_TYPE_RESOURCE_DUMMY = new ResourceImpl();
	
	private static boolean RQ3_RQ4_HOR_ONLY = false;
	
	static {
		DOC_TYPE_RESOURCE_DUMMY.getContents().add(EcoreFactory.eINSTANCE.createEPackage());
	}
	
	public NumberReportGenerator() {
		
		try {
			LogTable projectReport = new ProjectReportGenerator().generateProjectReport();
			LogTable rq3rq4Report = ProjectReportGeneratorDiagrams.generateRQ3RQ4PerProject(RQ3_RQ4_HOR_ONLY);
			
			// Some plausibility tests:
			
			// completions + undo + not observable = supported inconsistencies
			if (observableCompletionRepairs(projectReport) 
					+ observableUndoRepairs(projectReport)
					+ notObservableRepairs(projectReport)
					!= supportedInconsistencies(projectReport)) {
				throw new AssertionError("completions + undo + not observable == supported inconsistencies");
			}
			
			// missing CPEO + sub-rule to large + no repair = not observable:
			if (notObservableMissingCPEO() 
					+ notObservableSubRuleTooLarge()
					+ (supportedInconsistencies(projectReport) - atLeastOneRepairFound(projectReport))
					!= notObservableRepairs(projectReport)) {
				throw new AssertionError("missing CPEO + sub-rule to large + no repair = not observable");	
			}
			
			// Projects:
			System.out.println();
			System.out.println("% Projekte:");
			System.out.println("\\newcommand{\\projectCount}{" + allProjectCount() + "\\xspace}");
			
			// Configuration:
			System.out.println();
			System.out.println("% Configuration:");
			System.out.println("\\newcommand{\\minimalASGPatternCount}{" + minimalASGPatternCount() + "\\xspace}");
			System.out.println("\\newcommand{\\transformingEditRuleCount}{" + transformingEditRuleCount() + "\\xspace}");
			
			// Constraints:
			System.out.println();
			System.out.println("% Anzahl der für die Evaluation in FOL implementierten Constraints:");
			System.out.println("\\newcommand{\\constraintCount}{" + constraintCount() + "\\xspace}");
			System.out.println(
					"\\newcommand{\\ommitedWellFormedConstraintCount}{" + ommitedWellFormedConstraintCount() + "\\xspace}");
			System.out.println("\\newcommand{\\ommitedDomainSpecificConstraintCount}{"
					+ ommitedDomainSpecificConstraintCount() + "\\xspace}");
			System.out.println("\\newcommand{\\observedConstraintCount}{" + observedConstraintCount() + "\\xspace}");
			System.out.println(
					"\\newcommand{\\observedSupportedConstraintCount}{" + observedSupportedConstraintCount() + "\\xspace}");
			
			// Histories:
			System.out.println();
			System.out.println("% Zeitraum der Modellhistorien:");
			System.out.println("\\newcommand{\\oldestHistory}{" + oldestHistory() + "\\xspace}");
			System.out.println("\\newcommand{\\newestHistory}{" + newestHistory() + "\\xspace}");
			System.out.println();
			System.out.println("% Anzahl der Modellhistorien:");
			System.out.println("\\newcommand{\\allModelHistories}{" + allModelHistories(projectReport) + "\\xspace}");
			System.out.println("\\newcommand{\\inconsistentModelHistories}{" + inconsistentModelHistories(projectReport) + "\\xspace}");
			System.out.println();
			System.out.println("\\newcommand{\\allSourceRevisions}{" + allSourceRevisions(projectReport) + "\\xspace}");
			System.out.println("\\newcommand{\\allRevisions}{" + allRevisions(projectReport) + "\\xspace}");
			
			// RQ1:
			System.out.println();
			System.out.println("% RQ1:");
			System.out.println("\\newcommand{\\totalInconsistencies}{" + totalInconsistencies(projectReport) + "\\xspace}");
			System.out.println("\\newcommand{\\regexInconsistencies}{" + regexInconsistencies(projectReport) + "\\xspace}");
			System.out.println(
					"\\newcommand{\\domainSpecificInconsistencies}{" + domainSpecificInconsistencies() + "\\xspace}");
			System.out.println("\\newcommand{\\supportedInconsistencies}{" + supportedInconsistencies(projectReport) + "\\xspace}");
			System.out.println("\\newcommand{\\atLeastOneRepairFound}{" + atLeastOneRepairFound(projectReport) + "\\xspace}");
			
			// RQ2:
			System.out.println();
			System.out.println("% RQ2:");
			System.out.println("\\newcommand{\\totalObservableRepairs}{" + totalObservableRepairs(projectReport) + "\\xspace}");
			System.out
			.println("\\newcommand{\\observableCompletionRepairs}{" + observableCompletionRepairs(projectReport) + "\\xspace}");
			System.out.println("\\newcommand{\\observableUndoRepairs}{" + observableUndoRepairs(projectReport) + "\\xspace}");
			System.out.println("\\newcommand{\\notObservableRepairs}{" + notObservableRepairs(projectReport) + "\\xspace}");
			System.out.println("\\newcommand{\\notObservableMissingCPEO}{" + notObservableMissingCPEO() + "\\xspace}");
			System.out.println(
					"\\newcommand{\\notObservableSubRuleTooLarge}{" + notObservableSubRuleTooLarge() + "\\xspace}");
			System.out.println("\\newcommand{\\notObservableMissingCPEOsAndSubRuleTooLarge}{"
					+ notObservableMissingCPEOsAndSubRuleTooLarge() + "\\xspace}");
			System.out.println("\\newcommand{\\missingCPEOs}{" + missingCPEOs() + "\\xspace}");
			
			// RQ3:
			System.out.println();
			System.out.println("% RQ3");
			System.out.println("\\newcommand{\\rankingCountFirstPosition}{" + rankingCountFirstPosition(rq3rq4Report) + "\\xspace}");
			System.out.println("\\newcommand{\\rankingCountSecondPosition}{" + rankingCountSecondPosition(rq3rq4Report) + "\\xspace}");
			System.out.println("\\newcommand{\\inconsistenciesWithTenOrLessAlternatives}{"
					+ inconsistenciesWithTenOrLessAlternatives(rq3rq4Report) + "\\xspace}");
			System.out
			.println("\\newcommand{\\avgCountOfUnboundParameters}{" + avgCountOfUnboundParameters() + "\\xspace}");
			
			// RQ4:
			System.out.println();
			System.out.println("% RQ4");
			System.out.println("\\newcommand{\\exampleARuntimeUML}{" + exampleARuntimeUML() + "\\xspace}");
			System.out.println("\\newcommand{\\exampleAModelSizeUML}{" + exampleAModelSizeUML() + "\\xspace}");
			System.out.println("\\newcommand{\\exampleBRuntimeUML}{" + exampleBRuntimeUML() + "\\xspace}");
			System.out.println("\\newcommand{\\exampleBModelSizeUML}{" + exampleBModelSizeUML() + "\\xspace}");
			System.out.println("\\newcommand{\\exampleCRuntimeUML}{" + exampleCRuntimeUML() + "\\xspace}");
			System.out.println("\\newcommand{\\exampleCVersionCountUML}{" + exampleCVersionCountUML() + "\\xspace}");
			System.out.println("\\newcommand{\\recognitionRuntimeLessThenOneSecond}{"
					+ recognitionRuntimeLessThenOneSecond(rq3rq4Report) + "\\%\\xspace}");
			System.out.println(
					"\\newcommand{\\complementRuntimeLowerBorder}{" + complementRuntimeLowerBorder() + "\\xspace}");
			System.out.println(
					"\\newcommand{\\complementRuntimeUpperBorder}{" + complementRuntimeUpperBorder() + "\\xspace}");
			System.out.println(
					"\\newcommand{\\exampleDParameterClassesUML}{" + exampleDParameterClassesUML() + "\\xspace}");
			System.out.println(
					"\\newcommand{\\exampleDParameterSubClassesUML}{" + exampleDParameterSubClassesUML() + "\\xspace}");
		} catch (IllegalArgumentException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// Projects:

	public static int allProjectCount() {
		return consideredProjectCount() + unconsideredProjectCount();
	}

	public static int filteredProjectCount() {
		return ReportGenerator.getProjects_Reduced().size() - consideredProjectCount();
	}

	public static int consideredProjectCount() {
		try {
			return ReportGenerator.getEvaluationsPerProject().size();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Integer.MIN_VALUE;
	}

	public static int unconsideredProjectCount() {
		return ReportGenerator.getProjects_Original().size() - ReportGenerator.getProjects_Reduced().size();
	}
	
	// Configuration:

	public static int minimalASGPatternCount() {
		Resource patternResource = new ResourceSetImpl().getResource(URI.createPlatformPluginURI(PATH_GRAPH_PATTERNS, true), true);
		Set<String> patternNames = new HashSet<>();
		
		for (EObject element : (Iterable<EObject>) () -> patternResource.getAllContents()) {
			if (element instanceof GraphPattern) {
				patternNames.add(((GraphPattern) element).getName());
			}
		}
		
		return patternNames.size();
	}

	public static int transformingEditRuleCount() {
		Resource patternResource = new ResourceSetImpl().getResource(URI.createPlatformPluginURI(PATH_EDIT_RULES, true), true);
		Set<String> patternNames = new HashSet<>();
		
		for (EObject element : (Iterable<EObject>) () -> patternResource.getAllContents()) {
			if (element instanceof GraphPattern) {
				if (((GraphPattern) element).getStereotypes().contains(HenshinStereotypes.rule)) {
					patternNames.add(((GraphPattern) element).getName());
				}
			}
		}
		
		return patternNames.size();
	}
	
	// Constraints:

	public static int constraintCount() {
		return ValidationFacade.getConstraints(DOC_TYPE_RESOURCE_DUMMY).size();
	}

	public static int ommitedWellFormedConstraintCount() {
		return 5; // TODO: Derive...
	}

	public static int ommitedDomainSpecificConstraintCount() {
		return 3; // TODO: Derive...
	}

	public static int observedConstraintCount() {
		return 21; // TODO: Derive...
	}

	public static int observedSupportedConstraintCount() {
		return 15; // TODO: Derive...
	}
	
	// History:

	public static int oldestHistory() {
		return 2004; // TODO: Derive...
	}

	public static int newestHistory() {
		return 2018; // TODO: Derive...
	}

	public static int allModelHistories(LogTable projectReport) {
		List<Integer> columnAllModels = projectReport.getColumn(ProjectReportGenerator.COL_MODELS_ALL[0], Integer.class);
		return columnAllModels.get(columnAllModels.size() - 1);
	}

	public static int inconsistentModelHistories(LogTable projectReport) {
		List<Integer> columnInconsistentModels = projectReport.getColumn(ProjectReportGenerator.COL_MODELS_INCONSISTENT[0], Integer.class);
		return columnInconsistentModels.get(columnInconsistentModels.size() - 1);
	}

	public static int allSourceRevisions(LogTable projectReport) {
		List<Integer> columnSourceModels = projectReport.getColumn(ProjectReportGenerator.COL_REVISIONS_INCONSISTENT[0], Integer.class);
		return columnSourceModels.get(columnSourceModels.size() - 1);
	}

	public static int allRevisions(LogTable projectReport) {
		List<Integer> columnCoEvModels = projectReport.getColumn(ProjectReportGenerator.COL_REVISIONS_COEVOLVING[0], Integer.class);
		int coEvModelsCount = columnCoEvModels.get(columnCoEvModels.size() - 1);
		
		return allSourceRevisions(projectReport) + coEvModelsCount;
	}
	
	// RQ1:

	public static int totalInconsistencies(LogTable projectReport) {
		List<Integer> columnTotalInconsistencies = projectReport.getColumn(ProjectReportGenerator.COL_INCONSISTENCIES_RESOLVED[0], Integer.class);
		return columnTotalInconsistencies.get(columnTotalInconsistencies.size() - 1);
	}

	public static int regexInconsistencies(LogTable projectReport) {
		List<Integer> columnRegExInconsistencies = projectReport.getColumn(ProjectReportGenerator.COL_WELLFORMED_CONSTRAINTS[0], Integer.class);
		return columnRegExInconsistencies.get(columnRegExInconsistencies.size() - 1);
	}

	public static int domainSpecificInconsistencies() {
		return 3; // TODO: Derive...
	}

	public static int supportedInconsistencies(LogTable projectReport) {
		List<Integer> columnSupportedInconsistencies = projectReport.getColumn(ProjectReportGenerator.COL_INCONSISTENCIES_RESOLVED_SUPPORTED[0], Integer.class);
		return columnSupportedInconsistencies.get(columnSupportedInconsistencies.size() - 1);
	}

	public static int atLeastOneRepairFound(LogTable projectReport) {
		List<Integer> columntAtLeastOneRepairFound = projectReport.getColumn(ProjectReportGenerator.COL_REPAIRED_INCONSISTENCY[0], Integer.class);
		return columntAtLeastOneRepairFound.get(columntAtLeastOneRepairFound.size() - 1);
	}
	
	// RQ2:

	public static int totalObservableRepairs(LogTable projectReport) {
		return observableCompletionRepairs(projectReport) + observableUndoRepairs(projectReport);
	}

	public static int observableCompletionRepairs(LogTable projectReport) {
		List<Integer> columntObservableCompletionRepairs = projectReport.getColumn(ProjectReportGenerator.COL_HOR_COMPLETION[0], Integer.class);
		return columntObservableCompletionRepairs.get(columntObservableCompletionRepairs.size() - 1);
	}

	public static int observableUndoRepairs(LogTable projectReport) {
		List<Integer> columntObservableUndoRepairs = projectReport.getColumn(ProjectReportGenerator.COL_HOR_UNDO[0], Integer.class);
		return columntObservableUndoRepairs.get(columntObservableUndoRepairs.size() - 1);
	}

	public static int notObservableRepairs(LogTable projectReport) {
		List<Integer> columntNotObservableRepairs = projectReport.getColumn(ProjectReportGenerator.COL_HOR_NOT[0], Integer.class);
		return columntNotObservableRepairs.get(columntNotObservableRepairs.size() - 1);
	}

	public static int notObservableMissingCPEO() {
		return 38; // TODO: Derive...
	}

	public static int notObservableSubRuleTooLarge() {
		return 5; // TODO: Derive...
	}

	public static int notObservableMissingCPEOsAndSubRuleTooLarge() {
		return 3; // TODO: Derive...
	}

	public static int missingCPEOs() {
		return 8; // TODO: Derive...
	}
	
	// RQ3:

	public static String rankingCountFirstPosition(LogTable rq3rq4Report) {
		return "" + LogUtil.count(rq3rq4Report.getColumn(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class), 0);
	}

	public static String rankingCountSecondPosition(LogTable rq3rq4Report) {
		return "" + LogUtil.count(rq3rq4Report.getColumn(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class), 1);
	}

	public static int inconsistenciesWithTenOrLessAlternatives(LogTable rq3rq4Report) {
		return LogUtil.test(rq3rq4Report.getColumn(InconsistenciesLog.COL_COMPLEMENTS, Integer.class), a -> a <= 10);
	}

	public static String avgCountOfUnboundParameters() {
		// TODO Auto-generated method stub
		return "?";
	}
	
	// RQ4:
	
	private static int getModelSize(String path) {
		URI uri = URI.createFileURI(path);
		Resource resource = new ResourceSetImpl().getResource(uri, true);
		
		int count = 0;
		
		for (Iterator<?> iterator = resource.getAllContents(); iterator.hasNext();) {
			iterator.next();
			++count;
		}
		
		return count;
	}

	public static String exampleARuntimeUML() {
		return "300ms"; // TODO: Derive...
	}

	public static int exampleAModelSizeUML() {
		int cmof = getModelSize("C:/workspaces/sidiff-build/org.eclipse.git.evaluation_2018-11-02/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF.ecore/0009_2011-10-06T04-05-09Z_cab66f3576c668586ce408b840cb1d3e9108423b/plugins_org.eclipse.uml2.uml_model_CMOF.ecore");
		int cmof20 = getModelSize("C:/workspaces/sidiff-build/org.eclipse.git.evaluation_2018-11-02/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore/0004_2013-02-03T17-51-59Z_bb3ae2647564fc84f1bf5254c970e143693ef23c/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore");
		return cmof + cmof20;
	}

	public static String exampleBRuntimeUML() {
		return "2s"; // TODO: Derive...
	}

	public static int exampleBModelSizeUML() {
		int uml = getModelSize("C:/workspaces/sidiff-build/org.eclipse.git.evaluation_2018-11-02/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_UML.ecore/0083_2008-01-21T16-00-11Z_3c0e7ad91e38426f88a118f58605ea5183faeaa7/plugins_org.eclipse.uml2.uml_model_UML.ecore");
		return uml;
	}

	public static String exampleCRuntimeUML() {
		return "7s"; // TODO: Derive...
	}

	public static String exampleCVersionCountUML() {
		return "20"; // TODO: Derive...
	}

	public static long recognitionRuntimeLessThenOneSecond(LogTable rq3rq4Report) {
		List<Integer> recognitionTimes = rq3rq4Report.getColumn(InconsistenciesLog.COL_TIME_RECOGNITION, Integer.class);
		int recognitionRuntimeLessThenOneSecond = LogUtil.test(recognitionTimes, a -> a < 1000);
		
		return Math.round(((double) recognitionRuntimeLessThenOneSecond / (double) recognitionTimes.size()) * 100.0);
	}

	public static String complementRuntimeLowerBorder() {
		return "10s"; // TODO: Derive...
	}

	public static String complementRuntimeUpperBorder() {
		return "40s"; // TODO: Derive...
	}
	
	private String exampleDParameterClassesUML() {
		return "91"; // TODO: Derive...
	}

	public static String exampleDParameterSubClassesUML() {
		return "279"; // TODO: Derive...
	}
}
