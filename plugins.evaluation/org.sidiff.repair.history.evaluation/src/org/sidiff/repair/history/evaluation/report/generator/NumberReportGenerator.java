package org.sidiff.repair.history.evaluation.report.generator;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import org.sidiff.repair.history.evaluation.EvaluationDataSets;
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
	
	/* Latex Commands */
	
	public static final String CMD_PROJECT_COUNT = "projectCount";
	public static final String CMD_MINIMAL_ASG_PATTERN_COUNT = "minimalASGPatternCount";
	public static final String CMD_TRANSFORMING_EDIT_RULE_COUNT = "transformingEditRuleCount";
	public static final String CMD_CONSTRAINT_COUNT = "constraintCount";
	public static final String CMD_OMMITED_WELL_FORMED_CONSTRAINT_COUNT = "ommitedWellFormedConstraintCount";
	public static final String CMD_OMMITED_DOMAIN_SPECIFIC_CONSTRAINT_COUNT = "ommitedDomainSpecificConstraintCount";
	public static final String CMD_OBSERVED_SUPPORTED_CONSTRAINT_COUNT = "observedSupportedConstraintCount";
	public static final String CMD_OLDEST_HISTORY = "oldestHistory";
	public static final String CMD_NEWEST_HISTORY = "newestHistory";
	public static final String CMD_ALL_MODEL_HISTORIES = "allModelHistories";
	public static final String CMD_INCONSISTENT_MODEL_HISTORIES = "inconsistentModelHistories";
	public static final String CMD_ALL_SOURCE_REVISIONS = "allSourceRevisions";
	public static final String CMD_ALL_REVISIONS = "allRevisions";
	public static final String CMD_ALL_EVOLUTION_STEPS = "allEvolutionSteps";
	public static final String CMD_TOTAL_INCONSISTENCIES = "totalInconsistencies";
	public static final String CMD_REGEX_INCONSISTENCIES = "regexInconsistencies";
	public static final String CMD_DOMAIN_SPECIFIC_INCONSISTENCIES = "domainSpecificInconsistencies";
	public static final String CMD_SUPPORTED_INCONSISTENCIES = "supportedInconsistencies";
	public static final String CMD_AT_LEAST_ONE_REPAIR_FOUND = "atLeastOneRepairFound";
	public static final String CMD_PERCENTAGE_COVERED = "percentageCovered";
	public static final String CMD_PERCENTAGE_UNCOVERED_REGEX = "percentageUncoveredRegEx";
	public static final String CMD_TOTAL_OBSERVABLE_REPAIRS = "totalObservableRepairs";
	public static final String CMD_OBSERVABLE_COMPLETION_REPAIRS = "observableCompletionRepairs";
	public static final String CMD_OBSERVABLE_UNDO_REPAIRS = "observableUndoRepairs";
	public static final String CMD_NOT_OBSERVABLE_REPAIRS = "notObservableRepairs";
	public static final String CMD_NOT_OBSERVABLE_MISSING_CPEO = "notObservableMissingCPEO";
	public static final String CMD_NOT_OBSERVABLE_SUB_RULE_TOO_LARGE = "notObservableSubRuleTooLarge";
	public static final String CMD_NOT_OBSERVABLE_MISSING_CPEOS_AND_SUB_RULE_TOO_LARGE = "notObservableMissingCPEOsAndSubRuleTooLarge";
	public static final String CMD_MISSING_CPEOS = "missingCPEOs";
	public static final String CMD_PERCENTAGE_TOTAL_OBSERVABLE_REPAIRS = "percentageTotalObservableRepairs";
	public static final String CMD_PERCENTAGE_OBSERVABLE_COMPLETION_REPAIRS = "percentageObservableCompletionRepairs";;
	public static final String CMD_RANKING_COUNT_FIRST_POSITION = "rankingCountFirstPosition";
	public static final String CMD_RANKING_COUNT_SECOND_POSITION = "rankingCountSecondPosition";
	public static final String CMD_INCONSISTENCIES_WITH_TEN_OR_LESS_ALTERNATIVES = "inconsistenciesWithTenOrLessAlternatives";
	public static final String CMD_AVG_COUNT_OF_UNBOUND_PARAMETERS = "avgCountOfUnboundParameters";
	public static final String CMD_PERCENTAGE_TOP_RANKING = "percentageTopRanking";
	public static final String CMD_EXAMPLE_A_RUNTIME_UML = "exampleARuntimeUML";
	public static final String CMD_EXAMPLE_A_MODEL_SIZE_UML = "exampleAModelSizeUML";
	public static final String CMD_EXAMPLE_B_RUNTIME_UML = "exampleBRuntimeUML";
	public static final String CMD_EXAMPLE_B_MODEL_SIZE_UML = "exampleBModelSizeUML";
	public static final String CMD_EXAMPLE_C_RUNTIME_UML = "exampleCRuntimeUML";
	public static final String CMD_EXAMPLE_C_VERSION_COUNT_UML = "exampleCVersionCountUML";
	public static final String CMD_RECOGNITION_RUNTIME_LESS_THEN_ONE_SECOND = "recognitionRuntimeLessThenOneSecond";
	public static final String CMD_COMPLEMENT_RUNTIME_LOWER_BORDER = "complementRuntimeLowerBorder";
	public static final String CMD_COMPLEMENT_RUNTIME_UPPER_BORDER = "complementRuntimeUpperBorder";
	public static final String CMD_EXAMPLE_D_PARAMETER_CLASSES_UML = "exampleDParameterClassesUML";
	public static final String CMD_EXAMPLE_D_PARAMETER_SUB_CLASSES_UML = "exampleDParameterSubClassesUML";

	public NumberReportGenerator() {
		
		try {
			LogTable manuallyEvaluated = new LogTable();
			manuallyEvaluated.loadCSV(EvaluationDataSets.MANUALLY_EVALUATED_VALUES, true);
			
			LogTable projectReport = new ProjectReportGenerator().generateProjectReport();
			LogTable rq3rq4Report = ProjectReportGeneratorDiagrams.generateRQ3RQ4PerProject(RQ3_RQ4_HOR_ONLY);
			LogTable inconsistencyReport = InconsistencyReportGenerator.generate();
			
			/* Some plausibility tests */
			
			// completions + undo + not observable = supported inconsistencies
			if (observableCompletionRepairs(projectReport) 
					+ observableUndoRepairs(projectReport)
					+ notObservableRepairs(projectReport)
					!= supportedInconsistencies(projectReport)) {
				throw new AssertionError("completions + undo + not observable == supported inconsistencies");
			}
			
			// missing CPEO + sub-rule to large + no repair = not observable:
			if (notObservableMissingCPEO(manuallyEvaluated) 
					+ notObservableSubRuleTooLarge(manuallyEvaluated)
					+ (supportedInconsistencies(projectReport) - atLeastOneRepairFound(projectReport))
					!= notObservableRepairs(projectReport)) {
				throw new AssertionError("missing CPEO + sub-rule to large + no repair = not observable");	
			}
			
			// Projects:
			System.out.println();
			System.out.println(createComment("Projekte:"));
			System.out.println(createCommand(CMD_PROJECT_COUNT, allProjectCount()));
			
			// Configuration:
			System.out.println();
			System.out.println(createComment("Configuration:"));
			System.out.println(createCommand(CMD_MINIMAL_ASG_PATTERN_COUNT, minimalASGPatternCount()));
			System.out.println(createCommand(CMD_TRANSFORMING_EDIT_RULE_COUNT, transformingEditRuleCount()));
			
			// Constraints:
			System.out.println();
			System.out.println(createComment("Anzahl der für die Evaluation in FOL implementierten Constraints:"));
			System.out.println(createCommand(CMD_CONSTRAINT_COUNT, constraintCount()));
			System.out.println(createCommand(CMD_OMMITED_WELL_FORMED_CONSTRAINT_COUNT, ommitedWellFormedConstraintCount(inconsistencyReport, manuallyEvaluated)));
			System.out.println(createCommand(CMD_OMMITED_DOMAIN_SPECIFIC_CONSTRAINT_COUNT, ommitedDomainSpecificConstraintCount(manuallyEvaluated)));
			System.out.println(createCommand(CMD_OBSERVED_SUPPORTED_CONSTRAINT_COUNT, observedSupportedConstraintCount(inconsistencyReport)));
			
			// Histories:
			System.out.println();
			System.out.println(createComment("Zeitraum der Modellhistorien:"));
			System.out.println(createCommand(CMD_OLDEST_HISTORY, oldestHistory(manuallyEvaluated)));
			System.out.println(createCommand(CMD_NEWEST_HISTORY, newestHistory(manuallyEvaluated)));
			System.out.println();
			System.out.println(createComment("Anzahl der Modellhistorien:"));
			System.out.println(createCommand(CMD_ALL_MODEL_HISTORIES, allModelHistories(projectReport)));
			System.out.println(createCommand(CMD_INCONSISTENT_MODEL_HISTORIES, inconsistentModelHistories(projectReport)));
			System.out.println();
			System.out.println(createCommand(CMD_ALL_SOURCE_REVISIONS, allSourceRevisions(projectReport)));
			System.out.println(createCommand(CMD_ALL_REVISIONS, allRevisions(projectReport)));
			System.out.println(createCommand(CMD_ALL_EVOLUTION_STEPS, allEvolutionSteps(projectReport)));
			
			// RQ1:
			System.out.println();
			System.out.println(createComment("RQ1:"));
			System.out.println(createCommand(CMD_TOTAL_INCONSISTENCIES, totalInconsistencies(projectReport)));
			System.out.println(createCommand(CMD_REGEX_INCONSISTENCIES, regexInconsistencies(projectReport)));
			System.out.println(createCommand(CMD_DOMAIN_SPECIFIC_INCONSISTENCIES, domainSpecificInconsistencies(manuallyEvaluated)));
			System.out.println(createCommand(CMD_SUPPORTED_INCONSISTENCIES, supportedInconsistencies(projectReport)));
			System.out.println(createCommand(CMD_AT_LEAST_ONE_REPAIR_FOUND, atLeastOneRepairFound(projectReport)));
			System.out.println(createCommand(CMD_PERCENTAGE_COVERED, percentageCovered(projectReport)));
			System.out.println(createCommand(CMD_PERCENTAGE_UNCOVERED_REGEX, percentageUncoveredRegEx(projectReport)));
			
			// RQ2:
			System.out.println();
			System.out.println(createComment("RQ2:"));
			System.out.println(createCommand(CMD_TOTAL_OBSERVABLE_REPAIRS, totalObservableRepairs(projectReport)));
			System.out.println(createCommand(CMD_OBSERVABLE_COMPLETION_REPAIRS, observableCompletionRepairs(projectReport)));
			System.out.println(createCommand(CMD_OBSERVABLE_UNDO_REPAIRS, observableUndoRepairs(projectReport)));
			System.out.println(createCommand(CMD_NOT_OBSERVABLE_REPAIRS, notObservableRepairs(projectReport)));
			System.out.println(createCommand(CMD_NOT_OBSERVABLE_MISSING_CPEO, notObservableMissingCPEO(manuallyEvaluated)));
			System.out.println(createCommand(CMD_NOT_OBSERVABLE_SUB_RULE_TOO_LARGE, notObservableSubRuleTooLarge(manuallyEvaluated)));
			System.out.println(createCommand(CMD_NOT_OBSERVABLE_MISSING_CPEOS_AND_SUB_RULE_TOO_LARGE, notObservableMissingCPEOsAndSubRuleTooLarge(manuallyEvaluated)));
			System.out.println(createCommand(CMD_MISSING_CPEOS, missingCPEOs(manuallyEvaluated)));
			System.out.println(createCommand(CMD_PERCENTAGE_TOTAL_OBSERVABLE_REPAIRS, percentageTotalObservableRepairs(projectReport)));
			System.out.println(createCommand(CMD_PERCENTAGE_OBSERVABLE_COMPLETION_REPAIRS, percentageObservableCompletionRepairs(projectReport)));
			
			// RQ3:
			System.out.println();
			System.out.println(createComment("RQ3"));
			System.out.println(createCommand(CMD_RANKING_COUNT_FIRST_POSITION, rankingCountFirstPosition(rq3rq4Report)));
			System.out.println(createCommand(CMD_RANKING_COUNT_SECOND_POSITION, rankingCountSecondPosition(rq3rq4Report)));
			System.out.println(createCommand(CMD_INCONSISTENCIES_WITH_TEN_OR_LESS_ALTERNATIVES, inconsistenciesWithTenOrLessAlternatives(rq3rq4Report)));
			System.out.println(createCommand(CMD_AVG_COUNT_OF_UNBOUND_PARAMETERS, avgCountOfUnboundParameters(rq3rq4Report)));
			System.out.println(createCommand(CMD_PERCENTAGE_TOP_RANKING, percentageTopRanking(rq3rq4Report, projectReport)));
						
			// RQ4:
			System.out.println();
			System.out.println(createComment("RQ4"));
			System.out.println(createCommand(CMD_EXAMPLE_A_RUNTIME_UML, exampleARuntimeUML(manuallyEvaluated)));
			System.out.println(createCommand(CMD_EXAMPLE_A_MODEL_SIZE_UML, exampleAModelSizeUML()));
			System.out.println(createCommand(CMD_EXAMPLE_B_RUNTIME_UML, exampleBRuntimeUML(manuallyEvaluated)));
			System.out.println(createCommand(CMD_EXAMPLE_B_MODEL_SIZE_UML, exampleBModelSizeUML()));
			System.out.println(createCommand(CMD_EXAMPLE_C_RUNTIME_UML, exampleCRuntimeUML(manuallyEvaluated)));
			System.out.println(createCommand(CMD_EXAMPLE_C_VERSION_COUNT_UML, exampleCVersionCountUML(manuallyEvaluated)));
			System.out.println(createCommand(CMD_RECOGNITION_RUNTIME_LESS_THEN_ONE_SECOND, recognitionRuntimeLessThenOneSecond(rq3rq4Report)));
			System.out.println(createCommand(CMD_COMPLEMENT_RUNTIME_LOWER_BORDER, complementRuntimeLowerBorder(manuallyEvaluated)));
			System.out.println(createCommand(CMD_COMPLEMENT_RUNTIME_UPPER_BORDER, complementRuntimeUpperBorder(manuallyEvaluated)));
			System.out.println(createCommand(CMD_EXAMPLE_D_PARAMETER_CLASSES_UML, exampleDParameterClassesUML(manuallyEvaluated)));
			System.out.println(createCommand(CMD_EXAMPLE_D_PARAMETER_SUB_CLASSES_UML, exampleDParameterSubClassesUML(manuallyEvaluated)));
		} catch (IllegalArgumentException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// Generate Latex Commands:
	
	private static String createCommand(String name, Object value) {
		return "\\newcommand{\\" + name + "}{" + value + "\\xspace}";
	}
	
	private static String createComment(String text) {
		return "% " + text;
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
					String name = ((GraphPattern) element).getName();
					
					if (name.startsWith("Transform:")) {
						patternNames.add(name);
					}
				}
			}
		}
		
		return patternNames.size();
	}
	
	// Constraints:

	public static int constraintCount() {
		return ValidationFacade.getConstraints(DOC_TYPE_RESOURCE_DUMMY).size();
	}

	public static int ommitedWellFormedConstraintCount(LogTable inconsistencyReport, LogTable manuallyEvaluated) {
		int unsupportedDomainSpecific = ommitedDomainSpecificConstraintCount(manuallyEvaluated);
		int unsuporrtedAll = LogUtil.count(
				inconsistencyReport.getColumn(InconsistencyReportGenerator.COL_SUPPORTED_CONSTRAINT[0]),
				InconsistencyReportGenerator.VALUE_NO);
		return unsuporrtedAll - unsupportedDomainSpecific;
	}

	public static int ommitedDomainSpecificConstraintCount(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_OMMITED_DOMAIN_SPECIFIC_CONSTRAINT_COUNT, Integer.class).get(0);
	}

	public static int observedSupportedConstraintCount(LogTable inconsistencyReport) {
		return LogUtil.count(
				inconsistencyReport.getColumn(InconsistencyReportGenerator.COL_SUPPORTED_CONSTRAINT[0]),
				InconsistencyReportGenerator.VALUE_YES);
	}
	
	// History:

	public static int oldestHistory(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_OLDEST_HISTORY, Integer.class).get(0);
	}

	public static int newestHistory(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_NEWEST_HISTORY, Integer.class).get(0);
	}

	/**
	 * @return Summary value "All": number of all (consistent and inconsistent)
	 *         model histories.
	 */
	public static int allModelHistories(LogTable projectReport) {
		List<Integer> columnAllModels = projectReport.getColumn(ProjectReportGenerator.COL_MODELS_ALL[0], Integer.class);
		return columnAllModels.get(columnAllModels.size() - 1);
	}

	/**
	 * @return Summary value "Inc.": number of all model histories containing at
	 *         least one inconsistency.
	 */
	public static int inconsistentModelHistories(LogTable projectReport) {
		List<Integer> columnInconsistentModels = projectReport.getColumn(ProjectReportGenerator.COL_MODELS_INCONSISTENT[0], Integer.class);
		return columnInconsistentModels.get(columnInconsistentModels.size() - 1);
	}

	/**
	 * @return Summary value "Source": number of all source revisions of model
	 *         histories containing at least one inconsistency.
	 */
	public static int allSourceRevisions(LogTable projectReport) {
		List<Integer> columnSourceModels = projectReport.getColumn(ProjectReportGenerator.COL_REVISIONS_INCONSISTENT[0], Integer.class);
		return columnSourceModels.get(columnSourceModels.size() - 1);
	}
	
	/**
	 * @return Summary value "Co-ev.": number of all co-evolving revisions of model
	 *         histories containing at least one inconsistency.
	 */
	public static int allCoevolvingRevisions(LogTable projectReport) {
		List<Integer> columnCoEvModels = projectReport.getColumn(ProjectReportGenerator.COL_REVISIONS_COEVOLVING[0], Integer.class);
		return columnCoEvModels.get(columnCoEvModels.size() - 1);
	}

	/**
	 * @return Sum of revisions (source and co-evolving) of model histories
	 *         containing at least one inconsistency.
	 */
	public static int allRevisions(LogTable projectReport) {
		return allSourceRevisions(projectReport) + allCoevolvingRevisions(projectReport);
	}
	
	/**
	 * @return The number of evolution steps for one model history is the number of
	 *         its revisions minus one. The sum of all evolution steps (of model
	 *         histories containing at least one inconsistency) is the number of all
	 *         revisions (source and co-evolutions) minus the number of considered
	 *         model histories.
	 */
	public static int allEvolutionSteps(LogTable projectReport) {
		return allRevisions(projectReport) - inconsistentModelHistories(projectReport);
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

	public static int domainSpecificInconsistencies(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_DOMAIN_SPECIFIC_INCONSISTENCIES, Integer.class).get(0);
	}

	public static int supportedInconsistencies(LogTable projectReport) {
		List<Integer> columnSupportedInconsistencies = projectReport.getColumn(ProjectReportGenerator.COL_INCONSISTENCIES_RESOLVED_SUPPORTED[0], Integer.class);
		return columnSupportedInconsistencies.get(columnSupportedInconsistencies.size() - 1);
	}

	public static int atLeastOneRepairFound(LogTable projectReport) {
		List<Integer> columntAtLeastOneRepairFound = projectReport.getColumn(ProjectReportGenerator.COL_REPAIRED_INCONSISTENCY[0], Integer.class);
		return columntAtLeastOneRepairFound.get(columntAtLeastOneRepairFound.size() - 1);
	}
	
	private String percentageCovered(LogTable projectReport) {
		return percentage(atLeastOneRepairFound(projectReport), totalInconsistencies(projectReport));
	}
	
	private String percentageUncoveredRegEx(LogTable projectReport) {
		int noRepairFound = totalInconsistencies(projectReport) - atLeastOneRepairFound(projectReport);
		return percentage(regexInconsistencies(projectReport), noRepairFound);
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

	public static int notObservableMissingCPEO(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_NOT_OBSERVABLE_MISSING_CPEO, Integer.class).get(0);
	}

	public static int notObservableSubRuleTooLarge(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_NOT_OBSERVABLE_SUB_RULE_TOO_LARGE, Integer.class).get(0);
	}

	public static int notObservableMissingCPEOsAndSubRuleTooLarge(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_NOT_OBSERVABLE_MISSING_CPEOS_AND_SUB_RULE_TOO_LARGE, Integer.class).get(0);
	}

	public static int missingCPEOs(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_MISSING_CPEOS, Integer.class).get(0);
	}
	
	public static String percentageTotalObservableRepairs(LogTable projectReport) {
		return percentage(totalObservableRepairs(projectReport), supportedInconsistencies(projectReport));
	}
	
	public static String percentageObservableCompletionRepairs(LogTable projectReport) {
		return percentage(observableCompletionRepairs(projectReport), totalObservableRepairs(projectReport));
	}
	
	// RQ3:

	public static Object rankingCountFirstPosition(LogTable rq3rq4Report) {
		return LogUtil.count(rq3rq4Report.getColumn(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class), 0);
	}

	public static Object rankingCountSecondPosition(LogTable rq3rq4Report) {
		return LogUtil.count(rq3rq4Report.getColumn(InconsistenciesLog.COL_RANKING_OF_BEST_HOR, Integer.class), 1);
	}

	public static String inconsistenciesWithTenOrLessAlternatives(LogTable rq3rq4Report) {
		List<Integer> complementCount = rq3rq4Report.getColumn(InconsistenciesLog.COL_COMPLEMENTS, Integer.class);
		int tenOrLess = LogUtil.test(complementCount, a -> a <= 10);
		
		return percentage(tenOrLess, complementCount.size()) + "\\%";
	}

	public static Object avgCountOfUnboundParameters(LogTable rq3rq4Report) {
		return LogUtil.avg(rq3rq4Report.getColumn(InconsistenciesLog.COL_UNBOUND_PARAMETERS_OF_BEST_HOR, Integer.class));
	}
	
	public static String percentageTopRanking(LogTable rq3rq4Report, LogTable projectReport) {
		return percentage((int) rankingCountFirstPosition(rq3rq4Report), totalObservableRepairs(projectReport));
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

	public static String exampleARuntimeUML(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_EXAMPLE_A_RUNTIME_UML, String.class).get(0);
	}

	public static int exampleAModelSizeUML() {
		int cmof = getModelSize("C:/workspaces/sidiff-build/org.eclipse.git.evaluation_2018-11-02/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF.ecore/0009_2011-10-06T04-05-09Z_cab66f3576c668586ce408b840cb1d3e9108423b/plugins_org.eclipse.uml2.uml_model_CMOF.ecore");
		int cmof20 = getModelSize("C:/workspaces/sidiff-build/org.eclipse.git.evaluation_2018-11-02/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore/0004_2013-02-03T17-51-59Z_bb3ae2647564fc84f1bf5254c970e143693ef23c/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore");
		return cmof + cmof20;
	}

	public static String exampleBRuntimeUML(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_EXAMPLE_B_RUNTIME_UML, String.class).get(0);
	}

	public static int exampleBModelSizeUML() {
		int uml = getModelSize("C:/workspaces/sidiff-build/org.eclipse.git.evaluation_2018-11-02/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_UML.ecore/0083_2008-01-21T16-00-11Z_3c0e7ad91e38426f88a118f58605ea5183faeaa7/plugins_org.eclipse.uml2.uml_model_UML.ecore");
		return uml;
	}

	public static String exampleCRuntimeUML(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_EXAMPLE_C_RUNTIME_UML, String.class).get(0);
	}

	public static int exampleCVersionCountUML(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_EXAMPLE_C_VERSION_COUNT_UML, Integer.class).get(0);
	}

	public static String recognitionRuntimeLessThenOneSecond(LogTable rq3rq4Report) {
		List<Integer> recognitionTimes = rq3rq4Report.getColumn(InconsistenciesLog.COL_TIME_RECOGNITION, Integer.class);
		int recognitionRuntimeLessThenOneSecond = LogUtil.test(recognitionTimes, a -> a < 1000);
		
		return percentage(recognitionRuntimeLessThenOneSecond, recognitionTimes.size());
	}

	public static String complementRuntimeLowerBorder(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_COMPLEMENT_RUNTIME_LOWER_BORDER, String.class).get(0);
	}

	public static String complementRuntimeUpperBorder(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_COMPLEMENT_RUNTIME_UPPER_BORDER, String.class).get(0);
	}
	
	private int exampleDParameterClassesUML(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_EXAMPLE_D_PARAMETER_CLASSES_UML, Integer.class).get(0);
	}

	public static int exampleDParameterSubClassesUML(LogTable manuallyEvaluated) {
		return manuallyEvaluated.getColumn(CMD_EXAMPLE_D_PARAMETER_SUB_CLASSES_UML, Integer.class).get(0);
	}
	
	private static String percentage(int partial, int all) {
		 double percentage = ((double) partial / (double) all) * 100.0;
		 NumberFormat nf =  NumberFormat.getInstance(Locale.US);
		 nf.setMaximumFractionDigits(1);
		 return nf.format(percentage);
	}
}
