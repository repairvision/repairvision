package org.sidiff.history.analysis.validation;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.historymodel.Problem;

/**
 * Encapsulates a concrete validation framework.
 * 
 * @author kehrer
 */
public interface IValidator {

	Collection<Problem> validate(Resource resource);
	
	boolean matchValidationError(Problem validationErrorA, Problem validationErrorB);
	
	EObject getContextElement(Problem validationError);
}
