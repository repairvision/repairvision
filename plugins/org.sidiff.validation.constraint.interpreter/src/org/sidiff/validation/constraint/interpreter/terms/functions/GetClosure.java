package org.sidiff.validation.constraint.interpreter.terms.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class GetClosure extends Function {
	
	protected Term element;
	
	protected EReference feature;
	
	public GetClosure(Term element, EReference feature) {
		this.name = "getClosure";
		this.element = element;
		this.feature = feature;
	}

	@Override
	public Object evaluate(IScopeRecorder scope) {
		element.evaluate(scope);
		
		// Calculate transitive closure:
		if (element.getValue() != null) {
			List<EObject> closure = new ArrayList<EObject>();
			getNext((EObject) element.getValue(), closure);
			value = closure;
			
			scope.addElement(value);
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
	
	@Override
	public void required(IDecisionNode parent) {
		// see: consistency(IScopeDecision parent, EObject valid)
	}
	
	public void required(IDecisionNode parent, EObject valid) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		// Calculate transitive closure:
		if (element.getValue() != null) {
			List<EObject> closure = new ArrayList<EObject>();
			getScopeNext((EObject) element.getValue(), closure, sequence, valid);
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean getScopeNext(EObject element, List<EObject> closure, IDecisionNode parent, EObject valid) {
		boolean validElementReachable = (element == valid);
		
		// Check for cycles:
		if (!closure.contains(element)) {
			
			// Calculate transitive closure:
			closure.add(element);
			
			if (feature.isMany()) {
				List<EObject> targets = (List<EObject>) element.eGet(feature);
				
				for (EObject target : targets) {
					if (getScopeNext(target, closure, parent, valid)) {
						validElementReachable = true;
					}
				}
			} else {
				EObject target = (EObject) element.eGet(feature);
				
				if (getScopeNext(target, closure, parent, valid)) {
					validElementReachable = true;
				}
			}
		}
		
		if (validElementReachable) {
			ScopeNode.getScopeNode(parent).addElement(element);
		}
		
		return validElementReachable;
	}
	
	@Override
	public void repair(IDecisionNode parent, RepairType type) {
		// see: repair(IRepairDecision parent, RepairType type, EObject invalid)
	}

	public void repair(IDecisionNode parent, RepairType type, EObject invalid) {
		Alternative alternative = Alternative.nextAlternative(parent);
		
		// Calculate transitive closure:
		if (element.getValue() != null) {
			List<EObject> closure = new ArrayList<EObject>();
			getRepairNext((EObject) element.getValue(), closure, alternative, type, invalid);
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean getRepairNext(EObject element, List<EObject> closure, 
			IDecisionNode parent, RepairType type, EObject invalid) {
		
		boolean invalidElementReachable = (element == invalid);
		
		// Check for cycles:
		if (!closure.contains(element)) {
			
			// Calculate transitive closure:
			closure.add(element);
			
			if (feature.isMany()) {
				List<EObject> targets = (List<EObject>) element.eGet(feature);
				Sequence sequence = Sequence.nextSequence(parent);
				
				for (EObject target : targets) {
					if (getRepairNext(target, closure, sequence, type, invalid)) {
						invalidElementReachable = true;
					}
				}
			} else {
				EObject target = (EObject) element.eGet(feature);
				if (getRepairNext(target, closure, parent, type, invalid)) {
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
}
