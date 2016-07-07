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

	public Term getContext() {
		return context;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	@Override
	public Object evaluate() {
		value = ((EObject) context.evaluate()).eGet(feature);
		return value;
	}

	@Override
	public void repair(IRepairDecision parentRepairDecision, RepairType type) {
		
		// TODO Alternativ?: ǫ := a.b | τ = <modify, a, b>
		context.repair(parentRepairDecision, RepairType.MODIFY);
		
		Repair newRepair = new Repair(type, (EObject) context.getValue(), feature); 
		parentRepairDecision.appendChildDecisions(newRepair);
	}
}
