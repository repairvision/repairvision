package org.sidiff.consistency.repair.validation.terms;

import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;

public class Variable extends Term {

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
	public Object evaluate() {
		return value;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void generateRepairs(IRepairDecision parentRepairDecision, RepairType type) {
		binding.generateRepairs(parentRepairDecision, type);
	}
}
