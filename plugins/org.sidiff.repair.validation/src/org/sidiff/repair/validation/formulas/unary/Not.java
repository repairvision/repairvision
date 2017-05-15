package org.sidiff.repair.validation.formulas.unary;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.formulas.binary.Formula;

public class Not extends UnaryFormula {

	public Not(Formula child) {
		super(child);
		this.name = "not";
	}

	@Override
	public boolean evaluate(IScopeRecorder scope) {
		super.evaluate(scope);
		
		result = !child.evaluate(scope);
		return result;
	}

	@Override
	public void repair(IRepairDecision parentRepairDecision, boolean expected, IScopeRecorder scope) {
		// G(a, ¬σ)
		child.repair(parentRepairDecision, !expected, scope);
	}
}
