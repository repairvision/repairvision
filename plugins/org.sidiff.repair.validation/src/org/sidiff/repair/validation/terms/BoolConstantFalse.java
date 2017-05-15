package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;

public class BoolConstantFalse extends Term {

	public BoolConstantFalse() {
		this.value = false;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type, IScopeRecorder scope) {
		// Nothing to do...
	}
}
