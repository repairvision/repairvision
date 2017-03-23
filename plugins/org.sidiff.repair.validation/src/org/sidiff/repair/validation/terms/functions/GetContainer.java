package org.sidiff.repair.validation.terms.functions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class GetContainer extends Function {

	protected Term element;
	
	public GetContainer(Term element) {
		this.name = "getContainer";
		this.element = element;
	}
	
	@Override
	public Object evaluate() {
		element.evaluate();
		
		if (element.getValue() != null) {
			value = ((EObject) element.getValue()).eContainer();
		}
		
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		Alternative alternative = Alternative.nextAlternative(parent);
		
		if (element.getValue() instanceof Collection<?>) {
			System.err.println("List results must be repaired by ForAll or Exists!");
		} else {
			if (element.getValue() != null) {
				Repair newRepair = new Repair(type, (EObject) value, ((EObject) element.getValue()).eContainmentFeature()); 
				alternative.appendChildDecisions(newRepair);
			}
		}
	}
}
