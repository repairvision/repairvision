package org.sidiff.validation.constraint.interpreter.terms.functions;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class Concatenate extends Function {

	protected Term left;
	
	protected Term right;
	
	public Concatenate(Term left, Term right) {
		this.name = "concatenate";
		this.left = left;
		this.right = right;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		left.evaluate(scope);
		right.evaluate(scope);
		
		value = "" + left.getValue() + right.getValue(); 
		
		return value;
	}

	@Override
	public void required(IDecisionBranch parent) {
		left.required(parent);
		right.required(parent);
	}
	
	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		left.repair(parent, type);
		right.repair(parent, type);
	}
}
