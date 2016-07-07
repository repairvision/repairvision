package org.sidiff.consistency.repair.validation.terms;

import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;

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
	public void generateRepairs(IRepairDecision parentRepairDecision, RepairType type) {
		// Nothing to do...
	}
}
