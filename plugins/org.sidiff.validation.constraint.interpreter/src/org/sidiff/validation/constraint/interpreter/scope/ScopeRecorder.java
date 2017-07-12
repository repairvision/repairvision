package org.sidiff.validation.constraint.interpreter.scope;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public class ScopeRecorder implements IScopeRecorder {

	private Set<EObject> scope = new HashSet<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void addElement(Object element) {
		if (element instanceof EObject) {
			scope.add((EObject) element);
		} else if (element instanceof Collection<?>) {
			addElements((Collection<Object>) element);
		}
	}
	
	public void addElements(Collection<Object> elements) {
		for (Object element : elements) {
			addElement(element);
		}
	}

	@Override
	public Set<EObject> getScope() {
		return scope;
	}
	
	public String toString(int indent) {
		StringBuffer string = new StringBuffer();
		
		if (!scope.isEmpty()) {
			boolean first = true;
			
			for (EObject element : scope) {
				if (!first) {
					string.append("\n");
				} else {
					first = false;
				}
				appendIndent(indent, string);
				string.append(element);
			}
		} else {
			appendIndent(indent, string);
			string.append("<empty>");
		}
		
		return string.toString();
	}
	
	private void appendIndent(int indent, StringBuffer print) {
		for (int i = 0; i < indent; i++) {
			print.append(" ");
		}
	}
	
	@Override
	public String toString() {
		return toString(0);
	}
}
