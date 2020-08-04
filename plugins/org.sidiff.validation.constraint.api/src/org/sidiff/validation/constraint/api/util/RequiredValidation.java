package org.sidiff.validation.constraint.api.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class RequiredValidation extends Validation {

	protected IDecisionNode requiredTree;
	
	public RequiredValidation(
			IConstraint rule, boolean result, 
			EClass contextType, EObject context,
			IDecisionNode requiredTree) {
		
		super(rule, result, contextType, context);
		this.requiredTree = requiredTree;
	}
	
	public IDecisionNode getRequiredTree() {
		return requiredTree;
	}
}
