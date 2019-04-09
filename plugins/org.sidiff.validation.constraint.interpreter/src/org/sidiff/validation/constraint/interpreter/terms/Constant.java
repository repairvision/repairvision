package org.sidiff.validation.constraint.interpreter.terms;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;

public class Constant extends Term {
	
	public Constant(Object constant) {
		this.value = constant;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Object evaluate(IScopeRecorder scope) {
		return value;
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		ScopeNode.getScopeNode(parent).addElement(value);
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		// Nothing to do...
	}
}
