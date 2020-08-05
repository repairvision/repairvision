package org.sidiff.validation.constraint.interpreter.terms.constants;

import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.Predicate;

public class BoolConstantFalse extends Constant implements Predicate {

	public BoolConstantFalse() {
		super(false);
	}
	
	@Override
	public String toString() {
		return "false";
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		return false;
	}

	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
	}

	@Override
	public void required(IDecisionBranch parent, boolean expected) {
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
	}

	@Override
	public Boolean getResult() {
		return false;
	}

	@Override
	public void clear() {
	}
}
