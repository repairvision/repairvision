package org.sidiff.repair.validation.formulas.predicates;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Constant;
import org.sidiff.repair.validation.terms.Term;

public class Equality extends Predicate {

	protected Term termA;
	
	protected Term termB;
	
	public Equality(Term termA, Term termB) {
		super();
		this.termA = termA;
		this.termB = termB;
	}

	@Override
	public boolean evaluate() {
		return termA.evaluate().equals(termB.evaluate());
	}

	public Term getTermA() {
		return termA;
	}

	public void setTermA(Term termA) {
		this.termA = termA;
	}

	public Term getTermB() {
		return termB;
	}

	public void setTermB(Term termB) {
		this.termB = termB;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		
		if (termB instanceof Constant) {
			termA.repair(parent, RepairType.MODIFY);
		}
		
		else if (termA instanceof Constant) {
			termB.repair(parent, RepairType.MODIFY);
		}
		
		else {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			termA.repair(newRepairAlternative, RepairType.MODIFY);
			termB.repair(newRepairAlternative, RepairType.MODIFY);
		}
	}
}
