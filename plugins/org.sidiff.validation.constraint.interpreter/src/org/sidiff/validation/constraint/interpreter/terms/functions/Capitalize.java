package org.sidiff.validation.constraint.interpreter.terms.functions;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class Capitalize extends Function {

	protected Term string;
	
	public Capitalize(Term string) {
		this.name = "capitalize";
		this.string = string;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		String string_value = (String) string.evaluate(scope);
		
		value = ("" + string_value.charAt(0)).toUpperCase() + string_value.substring(1);
		
		return value;
	}

	@Override
	public void required(IDecisionNode parent) {
		string.required(parent);
	}
	
	@Override
	public void repair(IDecisionNode parent, RepairType type) {
		string.repair(parent, type);
	}
}
