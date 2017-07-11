package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.NamedElement;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public abstract class Formula extends NamedElement {

	protected Boolean result;
	
	public abstract boolean evaluate(IScopeRecorder scope, boolean optimize);
	
	public abstract void required(IDecisionNode parent, boolean expected);
	
	public abstract void repair(IDecisionNode parent, boolean expected);
	
	public Boolean getResult() {
		return result;
	}
	
	public void clear() {
		result = null;
	}
}
