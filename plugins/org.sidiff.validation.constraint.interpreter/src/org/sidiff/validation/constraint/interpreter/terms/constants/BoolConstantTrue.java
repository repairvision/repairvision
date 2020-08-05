package org.sidiff.validation.constraint.interpreter.terms.constants;

import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.Predicate;

public class BoolConstantTrue extends Constant implements Predicate {

	public BoolConstantTrue() {
		super(true);
	}
	
	@Override
	public String toString() {
		return "true";
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		return true;
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
		return true;
	}

	@Override
	public void clear() {
	}
}
