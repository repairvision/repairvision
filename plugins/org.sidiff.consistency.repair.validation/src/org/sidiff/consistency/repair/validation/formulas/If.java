package org.sidiff.consistency.repair.validation.formulas;

public class If extends BinaryFormula {

	public If(Formula left, Formula right) {
		super(left, right);
		this.name = "implies";
	}

	@Override
	public boolean evaluate() {
		result = !left.evaluate() || right.evaluate();
		return result;
	}

}
