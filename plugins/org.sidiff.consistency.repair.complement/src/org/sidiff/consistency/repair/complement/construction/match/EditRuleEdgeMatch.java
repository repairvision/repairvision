package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;

public class EditRuleEdgeMatch extends EditRuleMatch {

	private Edge edge;
	
	private EObject srcModelAElement;
	
	private EObject tgtModelAElement;
	
	private EObject srcModelBElement;
	
	private EObject tgtModelBElement;

	public EditRuleEdgeMatch(Type action, Edge edge) {
		super(action);
		this.edge = edge;
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
}
