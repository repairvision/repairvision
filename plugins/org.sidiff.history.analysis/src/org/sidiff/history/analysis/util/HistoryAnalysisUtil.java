package org.sidiff.history.analysis.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class HistoryAnalysisUtil {
	
	public static Problem getCorrespondingProblem(Problem validationError, Version model) {
		
		for(Problem nextProblem : model.getProblems()) {
			if (equalsValidation(validationError, nextProblem)) {
				return nextProblem;
			}
		}
		
		return null;
	}
	
	public static IConstraint getConsistencyRule(
			Problem validationError, List<IConstraint> consistencyRules) {
		
		for (IConstraint consistencyRule : consistencyRules) {
			if (getValidationID(consistencyRule).equalsIgnoreCase(getValidationID(validationError))) {
				return consistencyRule;
			}
		}
		
		return null;
	}
	
	public static List<Problem> getAllUniqueValidations(History history) {
		List<Problem> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (Problem validation : version.getProblems()) {
				
				// Is new validation error?
				if (!containsValidation(validations, validation)) {
					validations.add(validation);
				}
			}
		}
		
		return validations;
	}
	
	public static List<Problem> getResolvedUniqueValidations(History history) {
		List<Problem> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (Problem validation : version.getProblems()) {
				if (validation.getResolvedIn() != null) {
					
					// Is new validation error?
					if (!containsValidation(validations, validation)) {
						validations.add(validation);
					}
				}
			}
		}
		
		return validations;
	}
	
	public static Set<Problem> getSupportedValidations(
			List<Problem> inconsistenciesAll, List<IConstraint> consistencyRules) {
		
		Set<Problem> inconsistenciesSupported = new HashSet<>();
		
		for (IConstraint constraint : consistencyRules) {
			for (Problem validation : inconsistenciesAll) {
				if (getValidationID(validation).equalsIgnoreCase(constraint.getName())) {
					inconsistenciesSupported.add(validation);
				}
			}
		}
		
		return inconsistenciesSupported;
	}
	
	public static Problem getEqualValidation(List<Problem> validations, Problem validation) {
		for (Problem containedValidation : validations) {
			if (equalsValidation(containedValidation, validation)) {
				return containedValidation;
			}
		}
		return null;
	}
	
	public static boolean containsValidation(List<Problem> validations, Problem validation) {
		for (Problem containedValidation : validations) {
			if (equalsValidation(containedValidation, validation)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean equalsValidation(Problem validationA, Problem validationB) {
		// Check if the problems are in the same trace:
		return validationA == validationB 
				|| isSuccessor(validationA, validationB) 
				|| isPredecessor(validationA, validationB)
				|| isSuccessor(validationB, validationA)
				|| isPredecessor(validationB, validationA);
	}
	
	public static boolean isSuccessor(Problem predecessor, Problem successor) {
		if (predecessor.getSuccessor() != null) {
			if (predecessor.getSuccessor() == successor) {
				return true;
			} else {
				return isSuccessor(predecessor.getSuccessor(), successor);
			}
		}
		return false;
	}
	
	public static boolean isPredecessor(Problem successor, Problem predecessor) {
		if (successor.getPredecessor() != null) {
			if (successor.getPredecessor() == predecessor) {
				return true;
			} else {
				return isPredecessor(successor.getPredecessor(), successor);
			}
		}
		return false;
	}
	
	public static String getValidationID(IConstraint validation) {
		return validation.getName();
	}
	
	public static String getValidationID(Problem validation) {
		return validation.getName();
	}
}
