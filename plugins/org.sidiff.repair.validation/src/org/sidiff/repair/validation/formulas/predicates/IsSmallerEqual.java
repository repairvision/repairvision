package org.sidiff.repair.validation.formulas.predicates;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.terms.Term;

public class IsSmallerEqual extends Comparison  {

	public IsSmallerEqual(Term left, Term right) {
		super("isSmallerEqual", left, right);
	}
	
	@Override
	public boolean evaluate() {
		left.evaluate();
		right.evaluate();
		
		// TODO: sizeOf(...)
		Integer left_value = (Integer) left.getValue();
		Integer right_value = (Integer) right.getValue();
		result = left_value <= right_value;
		
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		// TODO: Implement repair function!
	}
}
