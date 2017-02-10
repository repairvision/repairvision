package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;

public class BoolConstantFalse extends Term {

	@Override
	public Object evaluate() {
		return false;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		// Nothing to do...
	}
}
