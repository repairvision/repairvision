package org.sidiff.repair.validation.formulas.predicates;

import java.util.Collection;

import org.sidiff.repair.validation.IScopeRecorder;
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
	public boolean evaluate(IScopeRecorder scope) {
		term.evaluate(scope);
		
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
	public void repair(IRepairDecision parent, boolean expected, IScopeRecorder scope) {
		
		if (expected && !getResult()) {
			term.repair(parent, RepairType.DELETE, scope);
		} 

		else if (!expected && getResult()) {
			term.repair(parent, RepairType.CREATE, scope);
		}
	}
}
