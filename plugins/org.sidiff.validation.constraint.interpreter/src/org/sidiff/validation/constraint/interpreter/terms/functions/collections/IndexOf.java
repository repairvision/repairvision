package org.sidiff.validation.constraint.interpreter.terms.functions.collections;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.ChangeActionFactory;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.functions.Function;

public class IndexOf extends Function {

	protected Term container;
	
	protected EStructuralFeature feature;
	
	protected Term element;
	
	public IndexOf(Term container, EStructuralFeature feature, Term element) {
		this.name = "indexOf";
		this.container = container;
		this.feature = feature;
		this.element = element;
	}
	
	@Override
	public EClassifier getType() {
		return EcorePackage.eINSTANCE.getEInt();
	}
	
	@Override
	public String toString() {
		return container.getValue() + "." + feature.getName() + " = " + element.getValue() + " -> " + super.toString();
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		container.evaluate(scope);
		element.evaluate(scope);
		value = -1;  
		
		if (feature.isMany()) {
			@SuppressWarnings("unchecked")
			List<EObject> list = (List<EObject>) ((EObject) container.getValue()).eGet(feature);
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(element.getValue())) {
					value = i;
				}
			}
		} else {
			if (((EObject) container.getValue()).eGet(feature) == element.getValue()) {
				value = 0;
			}
		}
		
		return value;
	}
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		container.generate(parent, type);
		element.generate(parent, type);
		
		// TODO: ...?
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		container.required(parent);
		element.required(parent);
		
		// TODO: ...?
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		container.repair(parent, type);
		element.repair(parent, type);

		ChangeAction newRepair = ChangeActionFactory.getInstance().create(RepairType.MODIFY, (EObject) container.getValue(), feature);
		parent.appendChildDecisions(newRepair);
	}
}
