package org.sidiff.repair.validation.formulas;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Sequence;

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

	@Override
	public void repair(IRepairDecision parentRepairDecision, boolean expected) {
		super.repair(parentRepairDecision, expected);
		
		// if σ = t, ςa = t, ςb = f : G(a, σ) • G(b, σ)
		if (expected && left.getResult() && !right.getResult()) {
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, expected);
			right.repair(newRepairAlternative, expected);
		}

		// if σ = f, ςa = t, ςb = t : G(b, σ)
		else if (!expected && left.getResult() && right.getResult()) {
			right.repair(parentRepairDecision, expected);
		}
		
		// if σ = f, ςa = f, ςb = t : G(a, σ) + G(b, σ)
		else if (!expected && !left.getResult() && right.getResult()) {
			Sequence newRepairSequence = new Sequence();
			parentRepairDecision.appendChildDecisions(newRepairSequence);
			left.repair(newRepairSequence, expected);
			right.repair(newRepairSequence, expected);
		}
		
		// if σ = f, ςa = f, ςb = f : G(a, σ)
		else if (!expected && !left.getResult() && !right.getResult()) {
			left.repair(parentRepairDecision, expected);
		}
	}
}
