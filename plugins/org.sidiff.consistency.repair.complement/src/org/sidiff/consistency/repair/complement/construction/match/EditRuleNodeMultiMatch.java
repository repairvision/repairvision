package org.sidiff.consistency.repair.complement.construction.match;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;

public class EditRuleNodeMultiMatch extends EditRuleNodeMatch {

	private Collection<EObject> modelElements;

	public EditRuleNodeMultiMatch(Node node, Type action, Collection<EObject> modelElements) {
		super(node, action);
		this.modelElements = modelElements;
	}

	public Collection<EObject> getModelElements() {
		return modelElements;
	}

	public void setModelElements(Collection<EObject> modelElements) {
		this.modelElements = modelElements;
	}
}
