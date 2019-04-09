package org.sidiff.validation.constraint.api.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class Validation {
	
	protected IConstraint rule;
	protected boolean result;
	protected EClass contextType;
	protected EObject context;
	
	public Validation(
			IConstraint rule, boolean result, 
			EClass contextType, EObject context) {
		
		this.rule = rule;
		this.result = result;
		this.contextType = contextType;
		this.context = context;
	}
	
	public IConstraint getRule() {
		return rule;
	}

	public boolean getResult() {
		return result;
	}
	
	public EClass getContextType() {
		return contextType;
	}
	
	public EObject getContext() {
		return context;
	}
}

