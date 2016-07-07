package org.sidiff.consistency.repair.validation.formulas;

import org.sidiff.consistency.repair.validation.fix.Alternative;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;

public class Xor extends BinaryFormula {

	public Xor(Formula left, Formula right) {
		super(left, right);
		this.name = "xor";
	}

	@Override
	public boolean evaluate() {
		result = left.evaluate() != right.evaluate();
		return result;
	}

	@Override
	public void generateRepairs(IRepairDecision parentRepairDecision, boolean expected) {
		
		// if σ = t, ςa = t, ςb = t : G(a, ¬σ) • G(b, ¬σ)
		if (expected && left.getResult() && !right.getResult()) {			// expected = true
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.generateRepairs(newRepairAlternative, !expected); 			// G(left, false)
			right.generateRepairs(newRepairAlternative, !expected);			// G(right, false)
		}

		// if σ = t, ςa = f, ςb = f : G(a, σ) • G(b, σ)
		else if (expected && !left.getResult() && right.getResult()) {		// expected = true
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.generateRepairs(newRepairAlternative, expected);			// G(left, true)
			right.generateRepairs(newRepairAlternative, expected);			// G(right, true)
		}
		
		// if σ = f, ςa = t, ςb = f : G(a, σ) • G(b, ¬σ)
		else if (!expected && left.getResult() && right.getResult()) {		// expected = false
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.generateRepairs(newRepairAlternative, expected);			// G(left, false)
			right.generateRepairs(newRepairAlternative, !expected);			// G(right, true)
		}
		
		// if σ = f, ςa = f, ςb = t : G(a, ¬σ) • G(b, σ)
		else if (!expected && !left.getResult() && !right.getResult()) {	// expected = false
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.generateRepairs(newRepairAlternative, !expected);			// G(left, true)
			right.generateRepairs(newRepairAlternative, expected);			// G(left, false)
		}
	}
}
