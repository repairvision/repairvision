package org.sidiff.repair.validation.formulas.predicates;

import java.util.Collection;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class IsEmpty extends Predicate {

	protected Term term;
	
	public IsEmpty(Term term) {
		this.name = "isEmpty";
		this.term = term;
	}

	@Override
	public boolean evaluate() {
		term.evaluate();
		
		if (term.getValue() == null) {
			result = true;
		} else {
			if (term.getValue() instanceof Collection<?>) {
				result = ((Collection<?>) term.getValue()).isEmpty();
			} else {
				result = false;
			}
		}
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		
		if (expected && !getResult()) {
			term.repair(parent, RepairType.DELETE);
		} 

		else if (!expected && getResult()) {
			term.repair(parent, RepairType.CREATE);
		}
	}
}
