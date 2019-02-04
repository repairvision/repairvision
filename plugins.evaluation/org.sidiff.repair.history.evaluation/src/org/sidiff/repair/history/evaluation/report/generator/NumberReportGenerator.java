package org.sidiff.repair.history.evaluation.report.generator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;

public class NumberReportGenerator {
	
	private static String PATH_GRAPH_PATTERNS = "/org.sidiff.ecore.editrules.repair.evaluation/patterns/ecore.graphpattern";
	
	private static String PATH_EDIT_RULES = "/org.sidiff.ecore.editrules.repair.evaluation/patterns/ecore_editrules.graphpattern";

	public NumberReportGenerator() {

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
		System.out.println("\\newcommand{\\allModelHistories}{" + allModelHistories() + "\\xspace}");
		System.out.println("\\newcommand{\\inconsistentModelHistories}{" + inconsistentModelHistories() + "\\xspace}");
		System.out.println();
		System.out.println("\\newcommand{\\allSourceRevisions}{" + allSourceRevisions() + "\\xspace}");
		System.out.println("\\newcommand{\\allRevisions}{" + allRevisions() + "\\xspace}");

		// RQ1:
		System.out.println();
		System.out.println("% RQ1:");
		System.out.println("\\newcommand{\\totalInconsistencies}{" + totalInconsistencies() + "\\xspace}");
		System.out.println("\\newcommand{\\regexInconsistencies}{" + regexInconsistencies() + "\\xspace}");
		System.out.println(
				"\\newcommand{\\domainSpecificInconsistencies}{" + domainSpecificInconsistencies() + "\\xspace}");
		System.out.println("\\newcommand{\\supportedInconsistencies}{" + supportedInconsistencies() + "\\xspace}");
		System.out.println("\\newcommand{\\atLeastOneRepairFound}{" + atLeastOneRepairFound() + "\\xspace}");

		// RQ2:
		System.out.println();
		System.out.println("% RQ2:");
		System.out.println("\\newcommand{\\totalObservableRepairs}{" + totalObservableRepairs() + "\\xspace}");
		System.out
				.println("\\newcommand{\\observableCompletionRepairs}{" + observableCompletionRepairs() + "\\xspace}");
		System.out.println("\\newcommand{\\observableUndoRepairs}{" + observableUndoRepairs() + "\\xspace}");
		System.out.println("\\newcommand{\\notObservableRepairs}{" + notObservableRepairs() + "\\xspace}");
		System.out.println("\\newcommand{\\notObservableMissingCPEO}{" + notObservableMissingCPEO() + "\\xspace}");
		System.out.println(
				"\\newcommand{\\notObservableSubRuleTooLarge}{" + notObservableSubRuleTooLarge() + "\\xspace}");
		System.out.println("\\newcommand{\\notObservableMissingCPEOsAndSubRuleTooLarge}{"
				+ notObservableMissingCPEOsAndSubRuleTooLarge() + "\\xspace}");
		System.out.println("\\newcommand{\\missingCPEOs}{" + missingCPEOs() + "\\xspace}");

		// RQ3:
		System.out.println();
		System.out.println("% RQ3");
		System.out.println("\\newcommand{\\rankingCountFirstPosition}{" + rankingCountFirstPosition() + "\\xspace}");
		System.out.println("\\newcommand{\\rankingCountSecondPosition}{" + rankingCountSecondPosition() + "\\xspace}");
		System.out.println("\\newcommand{\\inconsistenciesWithTenOrLessAlternatives}{"
				+ inconsistenciesWithTenOrLessAlternatives() + "\\xspace}");
		System.out.println(
				"\\newcommand{\\numberOfClassesInTheUMLMetamodel}{" + numberOfClassesInTheUMLMetamodel() + "\\xspace}");
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
				+ recognitionRuntimeLessThenOneSecond() + "\\%\\xspace}");
		System.out.println(
				"\\newcommand{\\complementRuntimeLowerBorder}{" + complementRuntimeLowerBorder() + "\\xspace}");
		System.out.println(
				"\\newcommand{\\complementRuntimeUpperBorder}{" + complementRuntimeUpperBorder() + "\\xspace}");
		System.out.println(
				"\\newcommand{\\exampleDParameterClassesUML}{" + exampleDParameterSubClassesUML() + "\\xspace}");
		System.out.println(
				"\\newcommand{\\exampleDParameterSubClassesUML}{" + exampleDParameterSubClassesUML() + "\\xspace}");
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

	public static String minimalASGPatternCount() {
		Resource patternResource = new ResourceSetImpl().getResource(URI.createPlatformPluginURI(PATH_GRAPH_PATTERNS, true), true);
		Set<String> patternNames = new HashSet<>();
		
		for (EObject element : (Iterable<EObject>) () -> patternResource.getAllContents()) {
			if (element instanceof GraphPattern) {
				patternNames.add(((GraphPattern) element).getName());
			}
		}
		
		return patternNames.size() + "";
	}

	public static String transformingEditRuleCount() {
		Resource patternResource = new ResourceSetImpl().getResource(URI.createPlatformPluginURI(PATH_EDIT_RULES, true), true);
		Set<String> patternNames = new HashSet<>();
		
		for (EObject element : (Iterable<EObject>) () -> patternResource.getAllContents()) {
			if (element instanceof GraphPattern) {
				if (((GraphPattern) element).getStereotypes().contains(HenshinStereotypes.rule)) {
					patternNames.add(((GraphPattern) element).getName());
				}
			}
		}
		
		return patternNames.size() + "";
	}
	
	// Constraints:

	public static int constraintCount() {
		return 20; // TODO: Derive...
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

	public static String allModelHistories() {
		return null;
	}

	public static String inconsistentModelHistories() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String allSourceRevisions() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String allRevisions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// RQ1:

	public static String totalInconsistencies() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String regexInconsistencies() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String domainSpecificInconsistencies() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String supportedInconsistencies() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String atLeastOneRepairFound() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// RQ2:

	public static String totalObservableRepairs() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String observableCompletionRepairs() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String observableUndoRepairs() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String notObservableRepairs() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String notObservableMissingCPEO() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String notObservableSubRuleTooLarge() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String notObservableMissingCPEOsAndSubRuleTooLarge() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String missingCPEOs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// RQ3:

	public static String rankingCountFirstPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String rankingCountSecondPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String inconsistenciesWithTenOrLessAlternatives() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String numberOfClassesInTheUMLMetamodel() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String avgCountOfUnboundParameters() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// RQ4:

	public static String exampleARuntimeUML() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String exampleAModelSizeUML() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String exampleBRuntimeUML() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String exampleBModelSizeUML() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String exampleCRuntimeUML() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String exampleCVersionCountUML() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String recognitionRuntimeLessThenOneSecond() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String complementRuntimeLowerBorder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String complementRuntimeUpperBorder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String exampleDParameterSubClassesUML() {
		// TODO Auto-generated method stub
		return null;
	}
}
