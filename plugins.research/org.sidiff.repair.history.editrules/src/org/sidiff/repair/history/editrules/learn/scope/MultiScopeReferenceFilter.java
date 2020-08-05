package org.sidiff.repair.history.editrules.learn.scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IReferenceFilter;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ReferenceScope;

public class MultiScopeReferenceFilter implements IReferenceFilter {

	private IScopeRecorder[] scopes;
	
	public MultiScopeReferenceFilter(IScopeRecorder... scopes) {
		this.scopes = scopes;
	}
	
	@Override
	public boolean filter(EObject source, EReference type, EObject target) {
		
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
