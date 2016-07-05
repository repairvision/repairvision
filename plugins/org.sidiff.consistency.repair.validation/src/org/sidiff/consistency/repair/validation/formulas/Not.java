package org.sidiff.consistency.repair.validation.formulas;

public class Not extends UnaryFormula {

	public Not(Formula child) {
		super(child);
		this.name = "not";
	}

	@Override
	public boolean evaluate() {
		result = !child.evaluate();
		return result;
	}
}
