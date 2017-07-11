package org.sidiff.validation.constraint.interpreter.terms.functions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;

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
	public Object evaluate(IScopeRecorder scope) {
		context.evaluate(scope);

		if (context.getValue() instanceof Collection<?>) {
			throw new RuntimeException("Navigation on Collection!");
		} else {

			// Simple path:
			if (context.getValue() != null) {
				value = getFeature(context.getValue(), feature);
				scope.addElement(value);
			}
		}

		return value;
	}
	
	private Object getFeature(Object obj, EStructuralFeature feature) {
		
		if (obj instanceof EObject) {
			// Ignore types which does not support this feature:
			if (((EObject) obj).eClass().getEAllStructuralFeatures().contains(feature)) {
				return ((EObject) obj).eGet(feature);
			}
		}
		
		return null;
	}
	
	@Override
	public void required(IDecisionNode parent) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		context.required(parent);
		
		if ((context.getValue() != null) && (getValue() != null)) {
			ScopeNode.getScopeNode(sequence).addElement(getValue());
		}
	}
	
	@Override
	public void repair(IDecisionNode parent, RepairType type) {
		 Alternative alternative = Alternative.nextAlternative(parent);
		
		// ǫ := a.b | τ = <modify, a, b>
		context.repair(alternative, RepairType.MODIFY);
		
		if (context.getValue() != null) {
			RepairAction newRepair = new RepairAction(type, (EObject) context.getValue(), feature); 
			alternative.appendChildDecisions(newRepair);
		}
	}
}
