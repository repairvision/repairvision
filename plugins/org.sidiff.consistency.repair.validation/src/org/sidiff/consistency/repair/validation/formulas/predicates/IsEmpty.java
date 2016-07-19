package org.sidiff.consistency.repair.validation.formulas.predicates;

import java.util.Collection;

import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;
import org.sidiff.consistency.repair.validation.terms.Constant;
import org.sidiff.consistency.repair.validation.terms.Term;

public class IsEmpty extends Predicate {

	protected Term term;
	
	public IsEmpty(Term term) {
		super();
		this.term = term;
	}

	@Override
	public boolean evaluate() {
		if (term.getValue() == null) {
			return true;
		} else {
			if (term.getValue() instanceof Collection<?>) {
				return ((Collection<?>) term.getValue()).isEmpty();
			}
		}
		return false;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		if (!(term instanceof Constant)) {
			if (expected) {
				term.repair(parent, RepairType.DELETE);
			} else {
				term.repair(parent, RepairType.ADD);
			}
		}
	}
}
