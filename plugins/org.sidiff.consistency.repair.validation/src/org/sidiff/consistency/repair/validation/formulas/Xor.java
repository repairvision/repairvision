package org.sidiff.consistency.repair.validation.formulas;

public class Xor extends BinaryFormula {

	protected Xor(Formula left, Formula right) {
		super(left, right);
		this.name = "xor";
	}

	@Override
	public boolean evaluate() {
		left.evaluate();
		right.evaluate();
		
		// (A | B) & !(A & B) 
		result = (left.getResult() || right.getResult()) && !(left.getResult() && right.getResult());
		return result;
	}
}
