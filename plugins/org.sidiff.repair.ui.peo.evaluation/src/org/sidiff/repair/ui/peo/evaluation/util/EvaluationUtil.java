package org.sidiff.repair.ui.peo.evaluation.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
				if ((validation.getIntroducedIn() != null) && (validation.getResolvedIn() != null)) {
					
					// Is new validation error?
					if (!contains(validations, validation)) {
						validations.add(validation);
					}
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
					EObject invalidElementA = validationA.getInvalidElement().get(0);
					EObject invalidElementB = validationB.getInvalidElement().get(0);
					
					// FIXME: Mapping from file: to platform:
//					if (invalidElementA.eIsProxy()) {
//						EcoreUtil.resolve(invalidElementA, validationA.eResource().getResourceSet());
//					}
//					if (invalidElementB.eIsProxy()) {
//						EcoreUtil.resolve(invalidElementB, validationB.eResource().getResourceSet());
//					}
					
//					if (EMFUtil.getXmiId(invalidElementA).equals(EMFUtil.getXmiId(invalidElementB))) {
					if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static String getValidationID(ValidationError validation) {
		return validation.getName().replaceAll("[^\\p{Alpha}]", "");
	}
}
