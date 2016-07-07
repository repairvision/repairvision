package org.sidiff.consistency.repair.validation.formulas;

import org.sidiff.consistency.repair.validation.fix.Alternative;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Sequence;

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
	public void generateRepairs(IRepairDecision parentRepairDecision, boolean expected) {
		
		// if σ = t, ςa = t, ςb = f : G(a, σ) • G(b, σ)
		if (expected && left.getResult() && !right.getResult()) {
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.generateRepairs(newRepairAlternative, expected);
			right.generateRepairs(newRepairAlternative, expected);
		}

		// if σ = f, ςa = t, ςb = t : G(b, σ)
		else if (!expected && left.getResult() && right.getResult()) {
			right.generateRepairs(parentRepairDecision, expected);
		}
		
		// if σ = f, ςa = f, ςb = t : G(a, σ) + G(b, σ)
		else if (!expected && !left.getResult() && right.getResult()) {
			Sequence newRepairSequence = new Sequence();
			parentRepairDecision.appendChildDecisions(newRepairSequence);
			left.generateRepairs(newRepairSequence, expected);
			right.generateRepairs(newRepairSequence, expected);
		}
		
		// if σ = f, ςa = f, ςb = f : G(a, σ)
		else if (!expected && !left.getResult() && !right.getResult()) {
			left.generateRepairs(parentRepairDecision, expected);
		}
	}
}
