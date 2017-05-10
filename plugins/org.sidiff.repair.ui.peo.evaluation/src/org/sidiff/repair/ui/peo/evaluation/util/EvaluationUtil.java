package org.sidiff.repair.ui.peo.evaluation.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;

public class EvaluationUtil {

	public static EObjectList toEObjectList(List<? extends EObject> list, String label) {
		EObjectList eObjectList = GraphpatternFactory.eINSTANCE.createEObjectList();
		eObjectList.setLabel(label);
		eObjectList.getContent().addAll(list);
		return eObjectList;
	}
	
	
	public static List<ValidationError> getValidations(History history) {
		List<ValidationError> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (ValidationError validation : version.getValidationErrors()) {
				// Is new validation error?
				if (!contains(validations, validation)) {
					validations.add(validation);
				}
			}
		}
		
		return validations;
	}
	
	public static boolean contains(List<ValidationError> validations, ValidationError validation) {
		for (ValidationError containedValidation : validations) {
			if (equals(containedValidation, validation)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean equals(ValidationError validationA, ValidationError validationB) {
		if (validationA.getIntroducedIn() == validationB.getIntroducedIn()) {
			if (validationA.getResolvedIn() == validationB.getResolvedIn()) {
				if (getValidationID(validationA).equals(getValidationID(validationB))) {
//					if (validationA.getInvalidElement().equals())
					return true;
				}
			}
		}
		return false;
	}
	
	public static String getValidationID(ValidationError validation) {
		return validation.getName();
	}
}
