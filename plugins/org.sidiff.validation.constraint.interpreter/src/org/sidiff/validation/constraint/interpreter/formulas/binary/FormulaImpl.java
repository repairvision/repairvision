package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.NamedElement;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public abstract class FormulaImpl extends NamedElement implements Formula {

	protected Boolean result;
	
	@Override
	public String toString() {
		return name + " = " + result;
	}
	
	@Override
	public abstract boolean evaluate(IScopeRecorder scope, boolean optimize);
	
	@Override
	public abstract void generate(IDecisionBranch parent, boolean expected);
	
	@Override
	public abstract void required(IDecisionBranch parent, boolean expected);
	
	@Override
	public abstract void repair(IDecisionBranch parent, boolean expected);
	
	@Override
	public Boolean getResult() {
		return result;
	}
	
	@Override
	public void clear() {
		result = null;
	}

}
