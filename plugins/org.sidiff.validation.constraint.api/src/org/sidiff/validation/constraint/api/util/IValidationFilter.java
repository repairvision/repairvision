package org.sidiff.validation.constraint.api.util;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public interface IValidationFilter {

	public static IValidationFilter DUMMY = new IValidationFilter() {

		@Override
		public boolean validate(EObject contextElement, IConstraint consistencyRule) {
			return true;
		}
	};
	
	boolean validate(EObject contextElement, IConstraint consistencyRule); 
}
