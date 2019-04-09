package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.NamedElement;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public abstract class Formula extends NamedElement {

	protected Boolean result;
	
	@Override
	public String toString() {
		return name + " = " + result;
	}
	
	public abstract boolean evaluate(IScopeRecorder scope, boolean optimize);
	
	public abstract void required(IDecisionBranch parent, boolean expected);
	
	public abstract void repair(IDecisionBranch parent, boolean expected);
	
	public Boolean getResult() {
		return result;
	}
	
	public void clear() {
		result = null;
	}
}
