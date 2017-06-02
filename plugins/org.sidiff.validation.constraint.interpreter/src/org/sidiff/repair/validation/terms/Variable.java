package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;

public class Variable extends Term {

	// TODO: Do we need this!?
	protected Term binding;
	
	public Variable(String name) {
		this.name = name;
	}
	
	public void bind(Term binding) {
		this.binding = binding;
	}

	public void assign(Object value) {
		this.value = value;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		scope.addElement(value);
		return value;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type, IScopeRecorder scope) {
		binding.repair(parent, type, scope);
	}
}
