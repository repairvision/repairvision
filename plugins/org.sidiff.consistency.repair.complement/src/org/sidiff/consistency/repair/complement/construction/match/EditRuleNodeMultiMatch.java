package org.sidiff.consistency.repair.complement.construction.match;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;

public class EditRuleNodeMultiMatch extends EditRuleNodeMatch {

	private Collection<EObject> modelAElements;
	
	private Collection<EObject> modelBElements;

	public EditRuleNodeMultiMatch(Type action, Node node) {
		super(action, node);
	}

	public Collection<EObject> getModelAElements() {
		return modelAElements;
	}

	public void setModelAElements(Collection<EObject> modelAElements) {
		this.modelAElements = modelAElements;
	}

	public Collection<EObject> getModelBElements() {
		return modelBElements;
	}

	public void setModelBElements(Collection<EObject> modelBElements) {
		this.modelBElements = modelBElements;
	}
}
