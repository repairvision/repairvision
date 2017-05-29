package org.sidiff.repair.validation.terms.functions;

import java.util.Collection;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.terms.Term;

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
	public void repair(IRepairDecision parent, RepairType type, IScopeRecorder scope) {
		// size(x.q.w) -> (delete/add, ..., x/q/w) 
		elements.repair(parent, type, scope);
	}
}
