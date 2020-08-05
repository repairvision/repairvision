package org.sidiff.validation.constraint.interpreter.terms.functions.navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.ChangeActionFactory;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.functions.Function;

/**
 * Calculates the closure over a given reference type. The closure includes the
 * starting element and all elements that are reachable from this element.
 */
public class GetClosure extends Function {
	
	protected Term element;
	
	protected EReference feature;
	
	public GetClosure(Term element, EReference feature) {
		this.name = "getClosure";
		this.element = element;
		this.feature = feature;
	}
	
	@Override
	public EClassifier getType() {
		return feature.getEType();
	}

	@Override
	public String toString() {
		return element.getValue() + ", " + feature.getName() + " -> " + super.toString();
	}
	
	public EReference getFeature() {
		return feature;
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
	public void generate(IDecisionBranch parent, ConstraintType type) {
		Sequence sequence = Sequence.nextSequence(parent);
		element.generate(sequence, type);
		
		ConstraintAction newConstraint = new ConstraintAction(type, feature.getEContainingClass(), feature, feature.getEType());
		parent.appendChildDecisions(newConstraint);
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		// see: required(IScopeDecision parent, EObject valid)
	}
	
	public void required(IDecisionBranch parent, EObject valid) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		// Calculate transitive closure:
		if (element.getValue() != null) {
			List<EObject> closure = new ArrayList<EObject>();
			getScopeNext(null, (EObject) element.getValue(), closure, sequence, valid);
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean getScopeNext(EObject lastElement, EObject element, 
			List<EObject> closure, IDecisionBranch parent, EObject valid) {
		
		boolean validElementReachable = (element == valid);
		
		// Check for cycles:
		if (!closure.contains(element)) {
			
			// Calculate transitive closure:
			closure.add(element);
			
			if (feature.isMany()) {
				List<EObject> targets = (List<EObject>) element.eGet(feature);
				
				for (EObject target : targets) {
					if (getScopeNext(element, target, closure, parent, valid)) {
						validElementReachable = true;
					}
				}
			} else {
				EObject target = (EObject) element.eGet(feature);
				
				if (getScopeNext(element, target, closure, parent, valid)) {
					validElementReachable = true;
				}
			}
		}
		
		if (validElementReachable) {
			
			// Log all elements on the path to valid elements as scope:
			ScopeNode scope = ScopeNode.getScopeNode(parent);
			scope.addElement(element);
			
			if (lastElement != null) {
				scope.addReference(lastElement, element, getFeature());
			}
		}
		
		return validElementReachable;
	}
	
	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		// see: repair(IRepairDecision parent, RepairType type, EObject invalid)
	}

	public void repair(IDecisionBranch parent, RepairType type, EObject invalid) {
		Alternative alternative = Alternative.nextAlternative(parent);
		
		// Calculate transitive closure:
		if (element.getValue() != null) {
			List<EObject> closure = new ArrayList<EObject>();
			getRepairNext((EObject) element.getValue(), closure, alternative, type, invalid);
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean getRepairNext(EObject element, List<EObject> closure, 
			IDecisionBranch parent, RepairType type, EObject invalid) {
		
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
						ChangeAction newRepair = ChangeActionFactory.getInstance().create(type, element, feature); 
						parent.appendChildDecisions(newRepair);
						invalidElementReachable = true;
					}
				}
			} else {
				EObject target = (EObject) element.eGet(feature);
				if (getRepairNext(target, closure, parent, type, invalid)) {
					ChangeAction newRepair = ChangeActionFactory.getInstance().create(type, element, feature); 
					parent.appendChildDecisions(newRepair);
					invalidElementReachable = true;
				}
			}
		}
		
		return invalidElementReachable;
	}
}
