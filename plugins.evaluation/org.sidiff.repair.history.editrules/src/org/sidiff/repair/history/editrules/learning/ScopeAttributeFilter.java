package org.sidiff.repair.history.editrules.learning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.editrule.recorder.filters.IAttributeFilter;
import org.sidiff.validation.constraint.interpreter.scope.AttributeScope;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public class ScopeAttributeFilter implements IAttributeFilter {

	private IScopeRecorder scope;
	
	public ScopeAttributeFilter(IScopeRecorder scope) {
		this.scope = scope;
	}
	
	@Override
	public boolean filter(EObject object, Object value, EAttribute type) {
		
		for (AttributeScope attribute : scope.getAttributes(object)) {
			if (attribute.getType().equals(type) && attribute.getValue().equals(value)) {
				return false;
			}
		}
				
		return true;
	}
}
