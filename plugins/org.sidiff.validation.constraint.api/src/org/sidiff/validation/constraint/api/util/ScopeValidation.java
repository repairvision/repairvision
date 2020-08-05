package org.sidiff.validation.constraint.api.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class ScopeValidation extends Validation {

	protected IScopeRecorder scope;
	
	public ScopeValidation(
			IConstraint rule, boolean result, 
			EClass contextType, EObject context,
			IScopeRecorder scope) {
		
		super(rule, result, contextType, context);
		this.scope = scope;
	}
	
	public IScopeRecorder getScope() {
		return scope;
	}
}
