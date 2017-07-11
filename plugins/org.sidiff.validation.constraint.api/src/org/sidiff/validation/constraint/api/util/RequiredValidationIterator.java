package org.sidiff.validation.constraint.api.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class RequiredValidationIterator extends ValidationIterator {

	protected boolean cleanupValidationTree = true;
	
	public RequiredValidationIterator(
			Resource modelResource, List<IConstraint> consistencyRules,
			boolean cleanupValidationTree) {
		super(modelResource, consistencyRules, true, false);
		this.cleanupValidationTree = cleanupValidationTree;
	}

	@Override
	public RequiredValidation next() {
		return (RequiredValidation) super.next();
	}
	
	protected void evaluate(EObject modelElement, EClass constraintContextType) {
		
		if (rules.containsKey(constraintContextType)) {
			for (IConstraint crule : rules.get(constraintContextType)) {
				if (reportValidation(crule)) {
					crule.evaluate(modelElement);
					
					RequiredValidation newValidation = new RequiredValidation(
							crule,
							crule.getResult(), 
							crule.getContextType(), 
							crule.getContext(), 
							crule.required());
					
					next.add(newValidation);
				}
			}
		}
	}
}
