package org.sidiff.repair.validation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public class ScopeRecorder implements IScopeRecorder {

	private Set<EObject> scope = new HashSet<>();
	
	@Override
	public void addElement(Object element) {
		if (element instanceof EObject) {
			scope.add((EObject) element);
		}
	}
	
	@Override
	public void addElement(Collection<Object> elements) {
		for (Object element : elements) {
			addElement(element);
		}
	}

	@Override
	public Set<EObject> getScope() {
		return scope;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("Scope:\n");
		
		for (EObject element : scope) {
			string.append("  " + element + "\n");
		}
		
		return string.toString();
	}
}
