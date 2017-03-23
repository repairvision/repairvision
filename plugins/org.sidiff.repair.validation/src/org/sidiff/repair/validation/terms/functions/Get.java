package org.sidiff.repair.validation.terms.functions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class Get extends Function {

	protected Term context;
	
	protected EStructuralFeature feature;
	
	public Get(Term context, EStructuralFeature feature) {
		super();
		this.name = "get";
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
		context.evaluate();

		if (context.getValue() instanceof Collection<?>) {
			System.err.println("List results must be repaired by ForAll or Exists!");
		} else {

			// Simple path:
			if (context.getValue() != null) {
				// TODO: Better way to ignore unsupported types!?
				if (((EObject) context.getValue()).eClass().getEAllStructuralFeatures().contains(feature)) {
					value = ((EObject) context.getValue()).eGet(feature);
				}
			}
		}

		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		 Alternative alternative = Alternative.nextAlternative(parent);
		
		// ǫ := a.b | τ = <modify, a, b>
		if (context instanceof Get) {
			context.repair(alternative, RepairType.MODIFY);
		}
		
		// TODO: Did we have use for empty repairs?
		if (context.getValue() != null) {
			Repair newRepair = new Repair(type, (EObject) context.getValue(), feature); 
			alternative.appendChildDecisions(newRepair);
		}
	}
}
