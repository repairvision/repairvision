package org.sidiff.validation.constraint.interpreter.formulas.predicates.collections;

import java.util.Collection;

import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.PredicateImpl;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class IsEmpty extends PredicateImpl {

	protected Term term;
	
	public IsEmpty(Term term) {
		this.name = "isEmpty";
		this.term = term;
	}
	
	@Override
	public String toString() {
		return super.toString();
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
	public void analyze(IDecisionBranch parent, boolean expected) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		if (expected) {
			term.generate(sequence, ConstraintType.FORBID);
		} else {
			term.generate(sequence, ConstraintType.REQUIRE);
		}
	}

	@Override
	public void required(IDecisionBranch parent, boolean expected) {

		if (!expected && !getResult()) {
			term.required(parent);
		}
	}
	
	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		if (expected && !getResult()) {
			term.repair(parent, RepairType.DELETE);
		} 

		else if (!expected && getResult()) {
			term.repair(parent, RepairType.CREATE);
		}
	}
}
