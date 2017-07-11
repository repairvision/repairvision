package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import java.util.Collection;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class IsEmpty extends Predicate {

	protected Term term;
	
	public IsEmpty(Term term) {
		this.name = "isEmpty";
		this.term = term;
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
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
	public void required(IDecisionNode parent, boolean expected) {

		if (!expected && getResult()) {
			term.required(parent);
		}
	}
	
	@Override
	public void repair(IDecisionNode parent, boolean expected) {
		
		if (expected && !getResult()) {
			term.repair(parent, RepairType.DELETE);
		} 

		else if (!expected && getResult()) {
			term.repair(parent, RepairType.CREATE);
		}
	}
}
