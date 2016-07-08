package org.sidiff.consistency.repair.validation.formulas;

import org.sidiff.consistency.repair.validation.fix.Alternative;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Sequence;

public class And extends BinaryFormula {

	public And(Formula left, Formula right) {
		super(left, right);
		this.name = "and";
	}

	@Override
	public boolean evaluate() {
		result = left.evaluate() && right.evaluate();
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		super.repair(parent, expected);
		
		// if σ = t, ςa = t, ςb = f : G(b, σ)
		if (expected && left.getResult() && !right.getResult()) {
			right.repair(parent, expected);
		}

		// if σ = t, ςa = f, ςb = t : G(a, σ)
		else if (expected && !left.getResult() && right.getResult()) {
			left.repair(parent, expected);
		}
		
		// if σ = t, ςa = f, ςb = f : G(a, σ) + G(b, σ)
		else if (expected && !left.getResult() && !right.getResult()) {
			Sequence newRepairSequence = new Sequence();
			parent.appendChildDecisions(newRepairSequence);
			left.repair(newRepairSequence, expected);
			right.repair(newRepairSequence, expected);
		}
		
		// if σ = f, ςa = t, ςb = t : G(a, σ) • G(b, σ)
		else if (!expected && left.getResult() && right.getResult()) {
			Alternative newRepairAlternative = new Alternative();
			parent.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, expected);
			right.repair(newRepairAlternative, expected);
		}
	}
}
