package org.sidiff.validation.constraint.api.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeRecorder;

public class ScopeValidationIterator extends ValidationIterator {
	
	public ScopeValidationIterator(
			Iterator<? extends EObject> model, 
			List<IConstraint> consistencyRules, IValidationFilter validationFilter,
			boolean showPositiveResults, boolean showNegativeResults) {
		
		super(model, consistencyRules, validationFilter, showPositiveResults, showNegativeResults);
	}
	
	protected void evaluate(EObject modelElement, EClass constraintContextType) {
		
		if (rules.containsKey(constraintContextType)) {
			for (IConstraint crule : rules.get(constraintContextType)) {
				if (validationFilter.validate(modelElement, crule)) {
					IScopeRecorder scopeRecorder = new ScopeRecorder();
					crule.evaluate(modelElement, scopeRecorder);
					
					if (reportValidation(crule)) {
						ScopeValidation newValidation = new ScopeValidation(
								crule,
								crule.getResult(), 
								crule.getContextType(), 
								crule.getContext(), 
								scopeRecorder);
						
						next.add(newValidation);
					}
				}
			}
		}
	}
}
