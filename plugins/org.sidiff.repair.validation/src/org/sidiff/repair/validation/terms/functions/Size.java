package org.sidiff.repair.validation.terms.functions;

import java.util.Collection;

import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class Size extends Function {

	protected Term elements;
	
	public Size(Term elements) {
		this.name = "size";
		this.elements = elements;
	}
	
	@Override
	public Object evaluate() {
		elements.evaluate();
		
		if (elements.getValue() == null) {
			value = 0;
		} else {
			if (elements.getValue() instanceof Collection<?>) {
				value = ((Collection<?>) elements).size();
			} else {
				value = 1;
			}
		}
		
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		// size(x.q.w) -> (delete/add, ..., x/q/w) 
		elements.repair(parent, type);
	}
}
