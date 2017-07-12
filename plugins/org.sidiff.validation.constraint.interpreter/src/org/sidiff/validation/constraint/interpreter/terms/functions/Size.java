package org.sidiff.validation.constraint.interpreter.terms.functions;

import java.util.Collection;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class Size extends Function {

	protected Term elements;
	
	public Size(Term elements) {
		this.name = "size";
		this.elements = elements;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		elements.evaluate(scope);
		
		if (elements.getValue() == null) {
			value = 0;
		} else {
			if (elements.getValue() instanceof Collection<?>) {
				value = ((Collection<?>) elements.getValue()).size();
			} else {
				value = 1;
			}
		}
		
		return value;
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		elements.required(parent);
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		// size(x.q.w) -> (delete/add, ..., x/q/w) 
		elements.repair(parent, type);
	}

}
