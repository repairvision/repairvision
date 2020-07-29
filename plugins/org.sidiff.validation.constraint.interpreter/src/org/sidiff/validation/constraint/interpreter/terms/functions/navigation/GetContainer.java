package org.sidiff.validation.constraint.interpreter.terms.functions.navigation;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.decisiontree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.RepairActionFactory;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ReferenceScope;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.functions.Function;

public class GetContainer extends Function {

	protected Term element;
	
	public GetContainer(Term element) {
		this.name = "getContainer";
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
			value = ((EObject) element.getValue()).eContainer();
			scope.addElement(value);
		}
		
		return value;
	}
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		Sequence sequence = Sequence.nextSequence(parent);
		element.generate(sequence, type);
		
		// TODO: Alternative of all possible classes that can contain the element.
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		element.required(sequence);
		
		if ((element.getValue() != null) && (getValue() != null)) {
			ScopeNode scope = ScopeNode.getScopeNode(sequence);
			scope.addElement(getValue());
			scope.addReference((EObject) getElement().getValue(), (EObject) getValue(), ReferenceScope.ECONTAINER);
		}
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		Alternative alternative = Alternative.nextAlternative(parent);
		
		element.repair(alternative, type);

		if ((element.getValue() != null) && (getValue() != null)) {
			RepairAction newRepair = RepairActionFactory.getInstance().create(type, (EObject) value, ((EObject) element.getValue()).eContainmentFeature()); 
			alternative.appendChildDecisions(newRepair);
		}
	}
}
