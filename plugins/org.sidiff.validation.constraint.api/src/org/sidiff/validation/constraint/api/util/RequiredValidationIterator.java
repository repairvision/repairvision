package org.sidiff.validation.constraint.api.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.decisiontree.DecisionTreeUtil;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;

public class RequiredValidationIterator extends ValidationIterator {

	protected boolean cleanupValidationTree = true;
	
	public RequiredValidationIterator(
			Resource modelResource, 
			List<IConstraint> consistencyRules, IValidationFilter validationFilter,
			boolean cleanupValidationTree) {
		
		super(validationFilter, true, false);
		this.cleanupValidationTree = cleanupValidationTree;
		init(modelResource, consistencyRules);
	}
	
	public boolean isCleanupValidationTree() {
		return cleanupValidationTree;
	}

	@Override
	public RequiredValidation next() {
		return (RequiredValidation) super.next();
	}
	
	protected void evaluate(EObject modelElement, EClass constraintContextType) {
		
		if (rules.containsKey(constraintContextType)) {
			for (IConstraint crule : rules.get(constraintContextType)) {
				crule.evaluate(modelElement);
				
				if (reportValidation(crule)) {
					IDecisionNode required = crule.required();
					required = cleanupValidationTree ? DecisionTreeUtil.cleanup(required) : required;
					
					RequiredValidation newValidation = new RequiredValidation(
							crule,
							crule.getResult(), 
							crule.getContextType(), 
							crule.getContext(), 
							required);
					
					next.add(newValidation);
				}
			}
		}
	}
}
