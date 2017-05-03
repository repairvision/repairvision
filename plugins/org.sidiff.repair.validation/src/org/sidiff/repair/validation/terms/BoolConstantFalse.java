package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;

public class BoolConstantFalse extends Term {

	public BoolConstantFalse() {
		this.value = false;
	}
	
	@Override
	public Object evaluate() {
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		// Nothing to do...
	}
}
