package org.sidiff.repair.validation.formulas.binary;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;

public class Xor extends BinaryFormula {

	public Xor(Formula left, Formula right) {
		super(left, right);
		this.name = "xor";
	}

	@Override
	public boolean evaluate(IScopeRecorder scope) {
		super.evaluate(scope);
		
		result = left.evaluate(scope) != right.evaluate(scope);
		return result;
	}

	@Override
	public void repair(IRepairDecision parentRepairDecision, boolean expected, IScopeRecorder scope) {
		super.repair(parentRepairDecision, expected, scope);
		
		// if σ = t, ςa = t, ςb = t : G(a, ¬σ) • G(b, ¬σ)
		if (expected && left.getResult() && !right.getResult()) {			// expected = true
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, !expected, scope); 			// G(left, false)
			right.repair(newRepairAlternative, !expected, scope);			// G(right, false)
		}

		// if σ = t, ςa = f, ςb = f : G(a, σ) • G(b, σ)
		else if (expected && !left.getResult() && right.getResult()) {		// expected = true
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, expected, scope);				// G(left, true)
			right.repair(newRepairAlternative, expected, scope);			// G(right, true)
		}
		
		// if σ = f, ςa = t, ςb = f : G(a, σ) • G(b, ¬σ)
		else if (!expected && left.getResult() && right.getResult()) {		// expected = false
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, expected, scope);				// G(left, false)
			right.repair(newRepairAlternative, !expected, scope);			// G(right, true)
		}
		
		// if σ = f, ςa = f, ςb = t : G(a, ¬σ) • G(b, σ)
		else if (!expected && !left.getResult() && !right.getResult()) {	// expected = false
			Alternative newRepairAlternative = new Alternative();
			parentRepairDecision.appendChildDecisions(newRepairAlternative);
			left.repair(newRepairAlternative, !expected, scope);			// G(left, true)
			right.repair(newRepairAlternative, expected, scope);			// G(left, false)
		}
	}
}
