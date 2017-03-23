package org.sidiff.repair.validation.terms.functions;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
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
	public Object evaluate() {
		left.evaluate();
		right.evaluate();
		
		value = "" + left.getValue() + right.getValue(); 
		
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		left.repair(parent, type);
		right.repair(parent, type);
	}
}
