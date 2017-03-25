package org.sidiff.repair.validation.formulas.predicates;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class IsGreater extends Comparison {

	public IsGreater(Term left, Term right) {
		super("isGreater", left, right);
	}
	
	@Override
	public boolean evaluate() {
		left.evaluate();
		right.evaluate();
		
		Integer left_value = (Integer) left.getValue();
		Integer right_value = (Integer) right.getValue();
		result = left_value > right_value;
		
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		
		if (expected && !getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.ADD);
			right.repair(newRepairAlternative, RepairType.DELETE);
		} 
		
		else if (!expected && getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.DELETE);
			right.repair(newRepairAlternative, RepairType.ADD);
		}
	}
}
