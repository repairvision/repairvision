package org.sidiff.repair.validation.formulas.predicates;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class Equality extends Comparison {

	public Equality(Term left, Term right) {
		super("equality", left, right);
	}

	@Override
	public boolean evaluate() {
		left.evaluate();
		right.evaluate();
		
		result = left.getValue().equals(right.getValue());
		
		return result;
	}

	public Term getTermA() {
		return left;
	}

	public void setTermA(Term termA) {
		this.left = termA;
	}

	public Term getTermB() {
		return right;
	}

	public void setTermB(Term termB) {
		this.right = termB;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		
		if (expected != getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.MODIFY);
			right.repair(newRepairAlternative, RepairType.MODIFY);
		}
	}
}
