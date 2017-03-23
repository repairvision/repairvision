package org.sidiff.repair.validation.terms.functions;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class GetContainments extends Function {

	protected Term element;
	
	public GetContainments(Term element) {
		this.name = "getContainments";
		this.element = element;
	}
	
	@Override
	public Object evaluate() {
		element.evaluate();
		
		if (element.getValue() != null) {
			value = ((EObject) element.getValue()).eContents();
		}
		
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		System.err.println("List results must be repaired by ForAll or Exists!");
	}
}
