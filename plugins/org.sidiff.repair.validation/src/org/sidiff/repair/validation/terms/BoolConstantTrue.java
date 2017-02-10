package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;

public class BoolConstantTrue extends Term {

	@Override
	public Object evaluate() {
		return true;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		// Nothing to do...
	}
}
