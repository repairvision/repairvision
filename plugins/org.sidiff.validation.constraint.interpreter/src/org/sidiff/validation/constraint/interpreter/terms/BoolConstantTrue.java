package org.sidiff.validation.constraint.interpreter.terms;

public class BoolConstantTrue extends Constant {

	public BoolConstantTrue() {
		super(true);
	}
	
	@Override
	public String toString() {
		return "true";
	}
}
