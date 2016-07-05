package org.sidiff.consistency.repair.validation.formulas;

public class And extends BinaryFormula {

	public And(Formula left, Formula right) {
		super(left, right);
		this.name = "and";
	}

	@Override
	public boolean evaluate() {
		result = left.evaluate() && right.evaluate();
		return result;
	}
}
