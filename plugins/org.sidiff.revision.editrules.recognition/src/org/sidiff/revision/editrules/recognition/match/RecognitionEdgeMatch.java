package org.sidiff.revision.editrules.recognition.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.sidiff.revision.common.emf.ModelingUtil;

public class RecognitionEdgeMatch extends RecognitionActionMatch {

	private Edge edge;
	
	private EObject srcModelAElement;
	
	private EObject tgtModelAElement;
	
	private EObject srcModelBElement;
	
	private EObject tgtModelBElement;

	public RecognitionEdgeMatch(Type action, Edge edge) {
		super(action);
		this.edge = edge;
	}
	
	@Override
	public GraphElement getGraphElement() {
		return edge;
	}

	public Edge getEdge() {
		return edge;
	}

	public void setEdge(Edge edge) {
		this.edge = edge;
	}

	public EObject getSrcModelAElement() {
		return srcModelAElement;
	}

	public void setSrcModelAElement(EObject srcModelAElement) {
		this.srcModelAElement = srcModelAElement;
	}

	public EObject getTgtModelAElement() {
		return tgtModelAElement;
	}

	public void setTgtModelAElement(EObject tgtModelAElement) {
		this.tgtModelAElement = tgtModelAElement;
	}

	public EObject getSrcModelBElement() {
		return srcModelBElement;
	}

	public void setSrcModelBElement(EObject srcModelBElement) {
		this.srcModelBElement = srcModelBElement;
	}

	public EObject getTgtModelBElement() {
		return tgtModelBElement;
	}

	public void setTgtModelBElement(EObject tgtModelBElement) {
		this.tgtModelBElement = tgtModelBElement;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append("<<" + getAction() + ">>");
		string.append(" " + getEdge());
		string.append(" A-SRC: " + ModelingUtil.getName(getSrcModelAElement()));
		string.append(" B-SRC: " + ModelingUtil.getName(getSrcModelBElement()));
		string.append(" A-TGT: " + ModelingUtil.getName(getTgtModelAElement()));
		string.append(" B-TGT: " + ModelingUtil.getName(getTgtModelBElement()));
		
		return string.toString();
	}
}
