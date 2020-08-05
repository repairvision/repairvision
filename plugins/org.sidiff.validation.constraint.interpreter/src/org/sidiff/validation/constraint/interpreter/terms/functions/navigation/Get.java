package org.sidiff.validation.constraint.interpreter.terms.functions.navigation;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
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

public class Get extends Function {

	protected Term context;
	
	protected EStructuralFeature feature;
	
	public Get(Term context, EStructuralFeature feature) {
		super();
		this.name = "get";
		this.context = context;
		this.feature = feature;
	}
	
	@Override
	public EClassifier getType() {
		return feature.getEType();
	}
	
	@Override
	public String toString() {
		return context.getValue() + ", " + feature.getName() + " -> " + super.toString();
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
			} else {
				value = null;
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
	public void generate(IDecisionBranch parent, ConstraintType type) {
		Sequence sequence = Sequence.nextSequence(parent);
		context.generate(sequence, type);
		
		ConstraintAction newConstraint = new ConstraintAction(type, (EClass) context.getType(), feature, getType());
		parent.appendChildDecisions(newConstraint);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void required(IDecisionBranch parent) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		context.required(parent);
		
		if ((context.getValue() != null) && (getValue() != null)) {
			ScopeNode scope = ScopeNode.getScopeNode(sequence);
			scope.addElement(getValue());
			
			// Is Reference:
			if (getFeature() instanceof EReference) {
				EObject source = (EObject) getContext().getValue();
				
				if (((EReference) getFeature()).isMany()) {
					for (EObject target : (Collection<EObject>) getValue()) {
						scope.addReference(source, target, (EReference) getFeature());
					}
				} else {
					scope.addReference(source, (EObject) getValue(), (EReference) getFeature());
				}
			}
			
			// Is Attribute:
			else if (getFeature() instanceof EAttribute) {
				scope.addAttribute((EObject) getContext().getValue(), getValue(), (EAttribute) getFeature());
			}
		}
	}
	
	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		 Alternative alternative = Alternative.nextAlternative(parent);
		
		// ǫ := a.b | τ = <modify, a, b>
		context.repair(alternative, RepairType.MODIFY);
		
		if (context.getValue() != null) {
			ChangeAction newRepair = ChangeActionFactory.getInstance().create(type, (EObject) context.getValue(), feature); 
			alternative.appendChildDecisions(newRepair);
		}
	}
}
