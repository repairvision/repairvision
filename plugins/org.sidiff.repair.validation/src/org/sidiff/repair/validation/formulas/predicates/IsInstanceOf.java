package org.sidiff.repair.validation.formulas.predicates;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class IsInstanceOf extends Predicate {

	protected Term term;
	
	protected EClass type;
	
	public IsInstanceOf(Term term, EClass type) {
		this.name = "isInstanceOf";
		this.term = term;
		this.type = type;
	}
	
	@Override
	public boolean evaluate() {
		term.evaluate();
		
		result = (((EObject) term.getValue()).eClass() == type);
		
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		term.repair(parent, RepairType.MODIFY);
	}
}
