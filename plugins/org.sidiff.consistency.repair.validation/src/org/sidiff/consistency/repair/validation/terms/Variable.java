package org.sidiff.consistency.repair.validation.terms;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public class Variable extends Term {

	public Variable(String name) {
		this.name = name;
	}
	
	public void assign(Collection<EObject> value) {
		this.value = value;
	}
	
	@Override
	public Collection<EObject> evaluate() {
		return value;
	}

	@Override
	public Collection<EObject> getValue() {
		return value;
	}
}
