package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;

public class BoolConstantTrue extends Term {

	public BoolConstantTrue() {
		this.value = true;
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
