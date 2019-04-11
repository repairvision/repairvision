package org.sidiff.repair.history.editrules.learning;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.editrule.tools.recorder.filters.IReferenceFilter;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ReferenceScope;

public class MultiScopeReferenceFilter implements IReferenceFilter {

	private IScopeRecorder[] scopes;
	
	public MultiScopeReferenceFilter(IScopeRecorder... scopes) {
		this.scopes = scopes;
	}
	
	@Override
	public boolean filter(EObject source, EObject target, EReference type) {
		
		for (IScopeRecorder scope : scopes) {
			for (ReferenceScope reference : scope.getOutgoings(source)) {
				if (reference.getType().equals(type) && reference.getTarget().equals(target)) {
					return false;
				}
			}
		}
				
		return true;
	}
}
