package org.sidiff.validation.constraint.interpreter.terms;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public class Variable extends Term {

	public Variable(String name) {
		this.name = name;
	}
	
	public void assign(Object value) {
		this.value = value;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		scope.addElement(value);
		return value;
	}

	@Override
	public Object getValue() {
		return value;
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		// nothing to do...
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		// nothing to do...
	}
}
