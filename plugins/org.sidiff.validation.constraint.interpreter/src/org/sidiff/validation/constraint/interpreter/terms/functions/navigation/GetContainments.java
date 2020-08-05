package org.sidiff.validation.constraint.interpreter.terms.functions.navigation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.ChangeActionFactory;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.functions.Function;

public class GetContainments extends Function {

	protected Term element;
	
	public GetContainments(Term element) {
		this.name = "getContainments";
		this.element = element;
	}
	
	@Override
	public EClassifier getType() {
		return EcorePackage.eINSTANCE.getEObject();
	}
	
	@Override
	public String toString() {
		return element.getValue() + " -> " + super.toString();
	}
	
	public Term getElement() {
		return element;
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
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		Sequence sequence = Sequence.nextSequence(parent);
		element.generate(sequence, type);
		
		// TODO: Alternative of all possible classes that can be contained by the element.
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void required(IDecisionBranch parent) {
		element.required(parent);
		ScopeNode scope = ScopeNode.getScopeNode(parent);
		
		if (getValue() instanceof EList<?>) {
			for (EObject content : (EList<EObject>) getValue()) {
				scope.addElement(content);
				scope.addReference((EObject) getElement().getValue(), content, content.eContainmentFeature());
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		element.repair(parent, type);
		
		if (getValue() instanceof EList<?>) {
			Set<EReference> containmentFeatures = new HashSet<>();
			
			for (EObject content : (EList<EObject>) getValue()) {
				EReference containmentFeature = content.eContainmentFeature();
				
				// Avoid duplicates:
				if (!containmentFeatures.contains(containmentFeature)) {
					ChangeAction newRepair = ChangeActionFactory.getInstance().create(type, (EObject) element.getValue(), containmentFeature); 
					parent.appendChildDecisions(newRepair);
					containmentFeatures.add(containmentFeature);
				}
			}
		}
	}
}
