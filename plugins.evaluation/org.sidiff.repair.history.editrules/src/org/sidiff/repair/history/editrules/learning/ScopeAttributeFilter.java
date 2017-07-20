package org.sidiff.repair.history.editrules.learning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.editrule.recorder.filter.IAttributeFilter;
import org.sidiff.validation.constraint.interpreter.scope.AttributeScope;
import org.sidiff.validation.constraint.interpreter.scope.ScopeRecorder;

public class ScopeAttributeFilter implements IAttributeFilter {

	private ScopeRecorder scope;
	
	public ScopeAttributeFilter(ScopeRecorder scope) {
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
