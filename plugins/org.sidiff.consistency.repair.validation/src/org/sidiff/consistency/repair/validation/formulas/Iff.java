package org.sidiff.consistency.repair.validation.formulas;

public class Iff extends BinaryFormula {

	protected Iff(Formula left, Formula right) {
		super(left, right);
		this.name = "equals";
	}

	@Override
	public boolean evaluate() {
		left.evaluate();
		right.evaluate();
		
		// (l -> r) & (r -> l)
		result = (!left.getResult() || right.getResult()) && (!right.getResult() || left.getResult());
		return result;
	}

}
