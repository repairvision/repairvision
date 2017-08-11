package org.sidiff.validation.constraint.api.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class ContextValidationFilter implements IValidationFilter {

	protected Collection<EObject> selectedContextElements;
	
	public ContextValidationFilter(Collection<EObject> selectedContextElements) {
		this.selectedContextElements = selectedContextElements;
	}
	
	@Override
	public boolean validate(EObject contextElement, IConstraint consistencyRule) {
		return selectedContextElements.contains(contextElement);
	}
}
