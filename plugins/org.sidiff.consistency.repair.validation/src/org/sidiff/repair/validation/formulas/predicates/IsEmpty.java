package org.sidiff.repair.validation.formulas.predicates;

import java.util.Collection;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Constant;
import org.sidiff.repair.validation.terms.Term;

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
