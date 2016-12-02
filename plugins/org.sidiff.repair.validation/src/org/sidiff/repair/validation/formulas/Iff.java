package org.sidiff.repair.validation.formulas;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;

public class Iff extends BinaryFormula {

	public Iff(Formula left, Formula right) {
		super(left, right);
		this.name = "equals";
	}

	@Override
	public boolean evaluate() {
		result = left.evaluate() == right.evaluate();
		return result;
	}

	@Override
	public void repair(IRepairDecision parentRepairDecision, boolean expected) {
		super.repair(parentRepairDecision, expected);
		
		// if σ = t, ςa = t, ςb = f : G(a, ¬σ) • G(b, σ)
		if (expected && left.getResult() && !right.getResult()) {			// expected = true
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, !expected); 					// G(left, false)
			right.repair(newRepairAlternative, expected);					// G(right, true)
		}

		// if σ = t, ςa = f, ςb = t : G(a, σ) • G(b, ¬σ)
		else if (expected && !left.getResult() && right.getResult()) {		// expected = true
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, expected);					// G(left, true)
			right.repair(newRepairAlternative, !expected);					// G(right, false)
		}
		
		// if σ = f, ςa = t, ςb = t : G(a, σ) • G(b, σ)
		else if (!expected && left.getResult() && right.getResult()) {		// expected = false
			Alternative newRepairSequence = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairSequence);
			left.repair(newRepairSequence, expected);						// G(left, false)
			right.repair(newRepairSequence, expected);						// G(right, false)
		}
		
		// if σ = f, ςa = f, ςb = f : G(a, ¬σ) • G(b, ¬σ)
		else if (!expected && !left.getResult() && !right.getResult()) {	// expected = false
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, !expected);				// G(left, true)
			right.repair(newRepairAlternative, !expected);			// G(left, true)
		}
	}
}
