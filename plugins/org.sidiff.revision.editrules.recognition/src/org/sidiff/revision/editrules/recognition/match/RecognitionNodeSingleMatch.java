package org.sidiff.revision.editrules.recognition.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.common.emf.ModelingUtil;

public class RecognitionNodeSingleMatch extends RecognitionNodeMatch {

	private EObject modelAElement;
	
	private EObject modelBElement;

	public RecognitionNodeSingleMatch(Type action, Node node) {
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
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append("<<" + getAction() + ">>");
		string.append(" " + getNode());
		string.append(" A: " + ModelingUtil.getName(getModelAElement()));
		string.append(" B: " + ModelingUtil.getName(getModelBElement()));
		
		return string.toString();
	}
}
