package org.sidiff.repair.validation.terms.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class GetClosure extends Function {
	
	protected Term element;
	
	protected EReference feature;
	
	public GetClosure(Term element, EReference feature) {
		this.name = "getClosure";
		this.element = element;
		this.feature = feature;
	}

	@Override
	public Object evaluate() {
		element.evaluate();
		
		// Calculate transitive closure:
		if (element.getValue() != null) {
			List<EObject> closure = new ArrayList<EObject>();
			getNext(Collections.singletonList((EObject) element.getValue()), closure);
			value = closure;
		} else {
			value = Collections.emptyList();
		}
		
		return value;
	}
	
	@SuppressWarnings("unchecked")
	private void getNext(List<EObject> elements, List<EObject> closure) {
		
		// Check for cycles:
		elements.removeAll(closure);
		
		// Calculate transitive closure:
		closure.addAll(elements);
		
		for (EObject element : elements) {
			if (feature.isMany()) {
				getNext((List<EObject>) element.eGet(feature), closure);
			} else {
				getNext(Collections.singletonList((EObject) element.eGet(feature)), closure);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		// TODO Repair decision type?
		Alternative alternative = Alternative.nextAlternative(parent);
		
		for (EObject closure : (List<EObject>) value) {
			Repair newRepair = new Repair(type, closure, feature); 
			alternative.appendChildDecisions(newRepair);
		}
	}
}
