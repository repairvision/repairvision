package org.sidiff.repair.validation.terms.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.fix.Sequence;
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
			getNext((EObject) element.getValue(), closure);
			value = closure;
		} else {
			value = Collections.emptyList();
		}
		
		return value;
	}
	
	@SuppressWarnings("unchecked")
	private void getNext(EObject element, List<EObject> closure) {
		
		// Check for cycles:
		if (!closure.contains(element)) {
			
			// Calculate transitive closure:
			closure.add(element);
			
			if (feature.isMany()) {
				List<EObject> targets = (List<EObject>) element.eGet(feature);
				
				for (EObject target : targets) {
					getNext(target, closure);
				}
			} else {
				EObject target = (EObject) element.eGet(feature);
				getNext(target, closure);
			}
		}
	}
	
	public void repair(IRepairDecision parent, RepairType type, Set<Object> invalids) {
		Alternative alternative = Alternative.nextAlternative(parent);
		
		// Calculate transitive closure:
		if (element.getValue() != null) {
			List<EObject> closure = new ArrayList<EObject>();
			getRepairNext((EObject) element.getValue(), closure, alternative, type, invalids);
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean getRepairNext(EObject element, List<EObject> closure, 
			IRepairDecision parent, RepairType type, Set<Object> invalids) {
		
		boolean invalidElementReachable = false;
		
		// Check for cycles:
		if (!closure.contains(element)) {
			
			// Calculate transitive closure:
			closure.add(element);
			
			if (feature.isMany()) {
				List<EObject> targets = (List<EObject>) element.eGet(feature);
				Sequence sequence = Sequence.nextSequence(parent);
				
				for (EObject target : targets) {
					invalidElementReachable = getRepairNext(target, closure, sequence, type, invalids);
					
					if (invalids.contains(target)) {
						invalidElementReachable = true;
					}
				}
			} else {
				EObject target = (EObject) element.eGet(feature);
				invalidElementReachable = getRepairNext(target, closure, parent, type, invalids);
				
				if (invalids.contains(target)) {
					invalidElementReachable = true;
				}
			}
		}
		
		if (invalidElementReachable) {
			RepairAction newRepair = new RepairAction(type, element, feature); 
			parent.appendChildDecisions(newRepair);
		}
		
		return invalidElementReachable;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type) {
		throw new UnsupportedOperationException();
//		Alternative alternative = Alternative.nextAlternative(parent);

//		Repair newRepair = new Repair(type, (EObject) element.getValue(), feature); 
//		alternative.appendChildDecisions(newRepair);

//		for (EObject closure : (List<EObject>) value) {
//			Repair newRepair = new Repair(type, closure, feature); 
//			alternative.appendChildDecisions(newRepair);
//		}
	}
}
