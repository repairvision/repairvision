package org.sidiff.validation.constraint.interpreter.terms.functions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class GetContainments extends Function {

	protected Term element;
	
	public GetContainments(Term element) {
		this.name = "getContainments";
		this.element = element;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		element.evaluate(scope);
		
		if (element.getValue() != null) {
			value = ((EObject) element.getValue()).eContents();
			scope.addElement(value);
		}
		
		return value;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void required(IDecisionNode parent) {
		element.required(parent);
		ScopeNode scope = ScopeNode.getScopeNode(parent);
		
		if (getValue() instanceof EList<?>) {
			for (EObject content : (EList<EObject>) getValue()) {
				scope.addElement(content);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void repair(IDecisionNode parent, RepairType type) {
		element.repair(parent, type);
		
		if (getValue() instanceof EList<?>) {
			Set<EReference> containmentFeatures = new HashSet<>();
			
			for (EObject content : (EList<EObject>) getValue()) {
				EReference containmentFeature = content.eContainmentFeature();
				
				// Avoid duplicates:
				if (!containmentFeatures.contains(containmentFeature)) {
					RepairAction newRepair = new RepairAction(type, (EObject) element.getValue(), containmentFeature); 
					parent.appendChildDecisions(newRepair);
					containmentFeatures.add(containmentFeature);
				}
			}
		}
	}
}
