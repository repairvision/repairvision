package org.sidiff.consistency.repair.validation.terms.functions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.consistency.repair.validation.fix.Alternative;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;
import org.sidiff.consistency.repair.validation.terms.Term;

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
		
//		if (context.getValue() instanceof List<?>) {
//		
//			// TODO: Support for multi-path evaluation!? -> Repair!? -> ForAll!?
//			List<Object> newValue = new ArrayList<Object>();
//			
//			for (Object object : (List<?>) context.getValue()) {
//				if (feature.isMany()) {
//					for (Object subValue : (List<?>) ((EObject) object).eGet(feature)) {
//						newValue.add(subValue);
//					}
//				} else {
//					newValue.add(((EObject) object).eGet(feature));
//				}
//			}
//			
//			value = newValue.isEmpty() ? Collections.emptyList() : newValue;
//		} else {
			
			// Simple path:
			if (context.getValue() != null) {
				value = ((EObject) context.getValue()).eGet(feature);
			}
//	}
		
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		 Alternative alternative = Alternative.nextAlternative(parent);
		
		// ǫ := a.b | τ = <modify, a, b>
		if (context instanceof Get) {
			context.repair(alternative, RepairType.MODIFY);
		}
		
		// TODO: Did we have use for empty repairs ?
		if (context.getValue() != null) {
			Repair newRepair = new Repair(type, (EObject) context.getValue(), feature); 
			alternative.appendChildDecisions(newRepair);
		}
	}
}
