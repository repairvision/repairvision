package org.sidiff.consistency.repair.validation.terms;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

public class Constant extends Term {

	public Constant(String name, EObject constant) {
		this.value = Collections.singletonList(constant);
		this.name = name;
	}

	@Override
	public Collection<EObject> evaluate() {
		return value;
	}
}
