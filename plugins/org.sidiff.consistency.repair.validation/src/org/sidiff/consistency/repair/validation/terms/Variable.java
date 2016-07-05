package org.sidiff.consistency.repair.validation.terms;

public class Variable extends Term {

	public Variable(String name) {
		this.name = name;
	}
	
	public void assign(Object value) {
		this.value = value;
	}
	
	@Override
	public Object evaluate() {
		return value;
	}

	@Override
	public Object getValue() {
		return value;
	}
}
