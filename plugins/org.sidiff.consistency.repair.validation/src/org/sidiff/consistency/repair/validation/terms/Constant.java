package org.sidiff.consistency.repair.validation.terms;

public class Constant extends Term {

	public Constant(String name, Object constant) {
		this.value = constant;
		this.name = name;
	}

	@Override
	public Object evaluate() {
		return value;
	}
}
