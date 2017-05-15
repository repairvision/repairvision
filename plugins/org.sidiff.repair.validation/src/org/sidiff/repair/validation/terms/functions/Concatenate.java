package org.sidiff.repair.validation.terms.functions;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.terms.Term;

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
	public void repair(IRepairDecision parent, RepairType type, IScopeRecorder scope) {
		left.repair(parent, type, scope);
		right.repair(parent, type, scope);
	}
}
