package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;

public class EditRuleEdgeDeleteMatch extends EditRuleEdgeMatch {

	private EObject srcModelBElement;
	
	private EObject tgtModelBElement;
	
	public EditRuleEdgeDeleteMatch(Edge edge, EObject srcModelElement, EObject tgtModelElement) {
		super(edge, Type.DELETE, srcModelElement, tgtModelElement);
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
