package org.sidiff.repair.validation.terms.functions;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class Capitalize extends Function {

	protected Term string;
	
	public Capitalize(Term string) {
		this.name = "capitalize";
		this.string = string;
	}
	
	@Override
	public Object evaluate() {
		String string_value = (String) string.evaluate();
		
		value = ("" + string_value.charAt(0)).toUpperCase() + string_value.substring(1);
		
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		string.repair(parent, type);
	}
}
