package org.sidiff.consistency.repair.validation.formulas.predicates;

import org.sidiff.consistency.repair.validation.fix.Alternative;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;
import org.sidiff.consistency.repair.validation.terms.Constant;
import org.sidiff.consistency.repair.validation.terms.Term;
import org.sidiff.consistency.repair.validation.terms.Variable;

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
	public void repair(IRepairDecision parentRepairDecision, boolean expected) {
		
		if ((termA instanceof Variable) && (termB instanceof Constant)) {
			((Variable) termA).repair(parentRepairDecision, RepairType.MODIFY);
		}
		
		else if ((termB instanceof Variable) && (termA instanceof Constant)) {
			((Variable) termB).repair(parentRepairDecision, RepairType.MODIFY);
		}
		
		else {
			if ((termA instanceof Variable) && (termB instanceof Variable)) {
				Alternative newRepairAlternative = new Alternative();
				parentRepairDecision.appendChildDecisions(newRepairAlternative);
				
				((Variable) termA).repair(newRepairAlternative, RepairType.MODIFY);
				((Variable) termB).repair(newRepairAlternative, RepairType.MODIFY);
			}
		}
	}
}
