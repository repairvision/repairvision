package org.sidiff.repair.history.editrules.learn.scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IReferenceFilter;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ReferenceScope;

public class ScopeReferenceFilter implements IReferenceFilter {

	private IScopeRecorder scope;
	
	public ScopeReferenceFilter(IScopeRecorder scope) {
		this.scope = scope;
	}
	
	@Override
	public boolean filter(EObject source, EReference type, EObject target) {
		
		for (ReferenceScope reference : scope.getOutgoings(source)) {
			if (reference.getType().equals(type) && reference.getTarget().equals(target)) {
				return false;
			}
		}
				
		return true;
	}
}
