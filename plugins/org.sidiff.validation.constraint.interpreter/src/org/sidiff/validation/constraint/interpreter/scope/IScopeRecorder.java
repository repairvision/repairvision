package org.sidiff.validation.constraint.interpreter.scope;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public interface IScopeRecorder {
	
	public static final IScopeRecorder DUMMY = new IScopeRecorder() {
		
		@Override
		public Set<EObject> getScope() {
			return Collections.emptySet();
		}
		
		@Override
		public void addElement(Object modelElement) {
		}
	};

	void addElement(Object modelElement);
	
	Set<EObject> getScope();
}
