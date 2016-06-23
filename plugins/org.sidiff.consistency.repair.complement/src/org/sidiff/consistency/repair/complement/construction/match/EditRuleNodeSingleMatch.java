package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;

public class EditRuleNodeSingleMatch extends EditRuleNodeMatch {

	private EObject modelElement;

	public EditRuleNodeSingleMatch(Node node, Type action, EObject modelElement) {
		super(node, action);
		this.modelElement = modelElement;
	}

	public EObject getModelElement() {
		return modelElement;
	}

	public void setModelElement(EObject modelElement) {
		this.modelElement = modelElement;
	}
}
