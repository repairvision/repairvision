package org.sidiff.repair.validation.formulas.binary;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Sequence;

public class If extends BinaryFormula {

	public If(Formula left, Formula right) {
		super(left, right);
		this.name = "implies";
	}

	@Override
	public boolean evaluate(IScopeRecorder scope) {
		super.evaluate(scope);
		
		result = !left.evaluate(scope) || right.evaluate(scope);
		return result;
	}

	@Override
	public void repair(IRepairDecision parentRepairDecision, boolean expected, IScopeRecorder scope) {
		super.repair(parentRepairDecision, expected, scope);
		
		// NOTE: Missing inverting expected results in paper!?
		
		// if σ = t, ςa = t, ςb = f : G(a, σ) • G(b, σ)
		if (expected && left.getResult() && !right.getResult()) {
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, !expected, scope);
			right.repair(newRepairAlternative, expected, scope);
		}

		// if σ = f, ςa = t, ςb = t : G(b, σ)
		else if (!expected && left.getResult() && right.getResult()) {
			right.repair(parentRepairDecision, !expected, scope);
		}
		
		// if σ = f, ςa = f, ςb = t : G(a, σ) + G(b, σ)
		else if (!expected && !left.getResult() && right.getResult()) {
			Sequence newRepairSequence = new Sequence();
			parentRepairDecision.appendChildDecisions(newRepairSequence);
			left.repair(newRepairSequence, expected, scope);
			right.repair(newRepairSequence, !expected, scope);
		}
		
		// if σ = f, ςa = f, ςb = f : G(a, σ)
		else if (!expected && !left.getResult() && !right.getResult()) {
			left.repair(parentRepairDecision, !expected, scope);
		}
	}
}
