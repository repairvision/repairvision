package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;

public class BoolConstantTrue extends Term {

	public BoolConstantTrue() {
		this.value = true;
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
