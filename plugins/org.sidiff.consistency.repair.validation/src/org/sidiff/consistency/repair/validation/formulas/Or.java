package org.sidiff.consistency.repair.validation.formulas;

public class Or extends BinaryFormula {

	public Or(Formula left, Formula right) {
		super(left, right);
		this.name = "or";
	}

	@Override
	public boolean evaluate() {
		result = left.evaluate() || right.evaluate();
		return result;
	}

}
