package org.sidiff.validation.constraint.interpreter.terms.functions;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class GetContainer extends Function {

	protected Term element;
	
	public GetContainer(Term element) {
		this.name = "getContainer";
		this.element = element;
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
	public void required(IDecisionNode parent) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		element.required(sequence);
		
		if ((element.getValue() != null) && (getValue() != null)) {
			ScopeNode.getScopeNode(sequence).addElement(getValue());
		}
	}

	@Override
	public void repair(IDecisionNode parent, RepairType type) {
		Alternative alternative = Alternative.nextAlternative(parent);
		
		element.repair(alternative, type);

		if ((element.getValue() != null) && (getValue() != null)) {
			RepairAction newRepair = new RepairAction(type, (EObject) value, ((EObject) element.getValue()).eContainmentFeature()); 
			alternative.appendChildDecisions(newRepair);
		}
	}
}
