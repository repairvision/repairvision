package org.sidiff.repair.history.editrules.learning;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.editrule.tools.recorder.filters.IReferenceFilter;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ReferenceScope;

public class ScopeReferenceFilter implements IReferenceFilter {

	private IScopeRecorder scope;
	
	public ScopeReferenceFilter(IScopeRecorder scope) {
		this.scope = scope;
	}
	
	@Override
	public boolean filter(EObject source, EObject target, EReference type) {
		
		for (ReferenceScope reference : scope.getOutgoings(source)) {
			if (reference.getType().equals(type) && reference.getTarget().equals(target)) {
				return false;
			}
		}
				
		return true;
	}
}
