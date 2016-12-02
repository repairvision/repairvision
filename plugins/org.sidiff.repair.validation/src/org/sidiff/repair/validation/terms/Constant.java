package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;

public class Constant extends Term {
	
	public Constant(String name, Object constant) {
		this.value = constant;
		this.name = name;
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
