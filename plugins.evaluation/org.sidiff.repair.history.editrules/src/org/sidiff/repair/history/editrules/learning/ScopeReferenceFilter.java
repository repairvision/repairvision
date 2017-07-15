package org.sidiff.repair.history.editrules.learning;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.editrule.recorder.util.IReferenceFilter;
import org.sidiff.validation.constraint.interpreter.scope.ReferenceScope;
import org.sidiff.validation.constraint.interpreter.scope.ScopeRecorder;

public class ScopeReferenceFilter implements IReferenceFilter {

	private ScopeRecorder scope;
	
	public ScopeReferenceFilter(ScopeRecorder scope) {
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
