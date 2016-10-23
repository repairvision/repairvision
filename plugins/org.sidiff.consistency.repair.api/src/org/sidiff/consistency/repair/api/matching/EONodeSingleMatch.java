package org.sidiff.consistency.repair.api.matching;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;

public class EONodeSingleMatch extends EONodeMatch {

	private EObject modelAElement;
	
	private EObject modelBElement;

	public EONodeSingleMatch(Type action, Node node) {
		super(action, node);
	}
	
	public EObject getModelAElement() {
		return modelAElement;
	}

	public void setModelAElement(EObject modelAElement) {
		this.modelAElement = modelAElement;
	}

	public EObject getModelBElement() {
		return modelBElement;
	}

	public void setModelBElement(EObject modelBElement) {
		this.modelBElement = modelBElement;
	}
}
