package org.sidiff.validation.constraint.interpreter.terms;

public class BoolConstantFalse extends Constant {

	public BoolConstantFalse() {
		super(false);
	}
	
	@Override
	public String toString() {
		return "false";
	}
}
