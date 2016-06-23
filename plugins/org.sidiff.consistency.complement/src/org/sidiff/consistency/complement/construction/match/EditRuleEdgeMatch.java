package org.sidiff.consistency.complement.construction.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;

public abstract class EditRuleEdgeMatch extends EditRuleMatch {

	private Edge edge;
	
	private EObject srcModelElement;
	
	private EObject tgtModelElement;

	public EditRuleEdgeMatch(Edge edge, Type action, EObject srcModelElement, EObject tgtModelElement) {
		super();
		this.edge = edge;
		this.action = action;
		this.srcModelElement = srcModelElement;
		this.tgtModelElement = tgtModelElement;
	}

	public Edge getEdge() {
		return edge;
	}

	public void setEdge(Edge edge) {
		this.edge = edge;
	}

	public Type getAction() {
		return action;
	}

	public void setAction(Type action) {
		this.action = action;
	}

	public EObject getSrcModelElement() {
		return srcModelElement;
	}

	public void setSrcModelElement(EObject srcModelElement) {
		this.srcModelElement = srcModelElement;
	}

	public EObject getTgtModelElement() {
		return tgtModelElement;
	}

	public void setTgtModelElement(EObject tgtModelElement) {
		this.tgtModelElement = tgtModelElement;
	}
}
