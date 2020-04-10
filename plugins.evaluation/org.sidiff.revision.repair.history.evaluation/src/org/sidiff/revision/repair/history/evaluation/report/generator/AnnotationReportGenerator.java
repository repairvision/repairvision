package org.sidiff.revision.repair.history.evaluation.report.generator;

import java.util.function.Predicate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.historymodel.Annotation;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.revision.repair.history.evaluation.EvaluationDataSets;

public class AnnotationReportGenerator {
	
	public static String[] ANNOTATION_KEYS = new String[] {"NOTE", "FIXME"};
	
	public static Predicate<Problem> FILTER = (problem -> containsAllAnnotationKeys(problem, ANNOTATION_KEYS));

	public AnnotationReportGenerator() {
		int counter = 0;
		
		for (String historyPath : EvaluationDataSets.HISTORIES) {
			URI historyURI = URI.createFileURI(EvaluationDataSets.RESULTS_DATA_SET + historyPath);
			Resource historyResource = new ResourceSetImpl().getResource(historyURI, true);
			History history = (History) historyResource.getContents().get(0);
			
			for (Problem problem : history.getAllProblems()) {
				if (FILTER.test(problem)) {
					System.out.println(problem.getMessage());
					System.out.println(" " + EcoreUtil.getURI(problem.getContextElement()));
					
					for (Annotation annotation: problem.getAnnotations()) {
						System.out.print(" " + annotation.getKey() + ": ");
						System.out.println(annotation.getValue());
					}
					
					++counter;
				}
			}
		}
		
		System.out.println();
		System.out.println("Count: " + counter);
	}
	
	public boolean containsAnyAnnotationKeys(Problem problem, String... keys) {
		
		for (String key : keys) {
			if (containsAnnotationKey(problem, key) ) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean containsAllAnnotationKeys(Problem problem, String... keys) {
		
		for (String key : keys) {
			if (!containsAnnotationKey(problem, key) ) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean containsAnnotationKey(Problem problem, String key) {

		for (Annotation annotation: problem.getAnnotations()) {
			if (annotation.getKey().equals(key)) {
				return true;
			}
		}
		
		return false;
	}
	
}
