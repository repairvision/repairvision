package org.sidiff.consistency.repair.validation.formulas;

import org.sidiff.consistency.repair.validation.fix.IRepairDecision;

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

	@Override
	public void generateRepairs(IRepairDecision parentRepairDecision, boolean expected) {
		// G(a, ¬σ)
		generateRepairs(parentRepairDecision, !expected);
	}
}
