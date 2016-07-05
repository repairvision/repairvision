package org.sidiff.consistency.repair.validation.formulas;

public class Not extends UnaryFormula {

	protected Not(Formula child) {
		super(child);
		this.name = "not";
	}

	@Override
	public boolean evaluate() {
		result = !child.evaluate();
		return result;
	}
}
