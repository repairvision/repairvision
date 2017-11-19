package org.sidiff.repair.ui.peo.integrated.app;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.historymodel.ValidationError;

/**
 * Encapsulates a concrete validation framework.
 * 
 * @author kehrer
 */
public interface IValidator {

	Collection<ValidationError> validate(Resource resource);
	
	boolean matchValidationError(ValidationError validationErrorA, ValidationError validationErrorB);
	
	EObject getContextElement(ValidationError validationError);
}
