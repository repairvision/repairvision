package org.sidiff.validation.constraint.interpreter.scope;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface IScopeRecorder {
	
	public static final IScopeRecorder DUMMY = new IScopeRecorder() {
		
		@Override
		public Set<EObject> getScope() {
			return Collections.emptySet();
		}
		
		@Override
		public void addElement(Object modelElement) {
		}

		@Override
		public void addReference(EObject source, EObject target, EReference type) {
		}

		@Override
		public List<ReferenceScope> getOutgoings(EObject source) {
			return Collections.emptyList();
		}
	};

	void addElement(Object modelElement);
	
	void addReference(EObject source, EObject target, EReference type);
	
	Set<EObject> getScope();
	
	List<ReferenceScope> getOutgoings(EObject source);
}
