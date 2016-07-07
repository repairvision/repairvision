package org.sidiff.consistency.repair.validation.terms.functions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;
import org.sidiff.consistency.repair.validation.terms.Term;

public class Get extends Function {

	protected Term context;
	
	protected EStructuralFeature feature;
	
	public Get(Term context, EStructuralFeature feature) {
		super();
		this.context = context;
		this.feature = feature;
	}

	@Override
	public Object evaluate() {
		value = ((EObject) context.evaluate()).eGet(feature);
		return value;
	}

	@Override
	public void generateRepairs(IRepairDecision parentRepairDecision, RepairType type) {
		Repair newRepair = new Repair(type, (EObject) context.getValue(), feature); 
		parentRepairDecision.appendChildDecisions(newRepair);
	}
}
