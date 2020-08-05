package org.sidiff.validation.constraint.interpreter.formulas;

import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.NamedElement;

public abstract class FormulaImpl extends NamedElement implements Formula {

	protected Boolean result;
	
	@Override
	public String toString() {
		return name + " = " + result;
	}
	
	@Override
	public abstract boolean evaluate(IScopeRecorder scope, boolean optimize);
	
	@Override
	public abstract void analyze(IDecisionBranch parent, boolean expected);
	
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
