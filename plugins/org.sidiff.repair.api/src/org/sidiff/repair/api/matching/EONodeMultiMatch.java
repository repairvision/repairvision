package org.sidiff.repair.api.matching;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.sidiff.consistency.common.emf.ModelingUtil;
import org.eclipse.emf.henshin.model.Node;

public class EONodeMultiMatch extends EONodeMatch {

	private Collection<EObject> modelAElements;
	
	private Collection<EObject> modelBElements;

	public EONodeMultiMatch(Type action, Node node) {
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
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append("<<" + getAction() + ">>");
		string.append(" " + getNode());
		string.append(" A: " + ModelingUtil.getNames(getModelAElements()));
		string.append(" B: " + ModelingUtil.getNames(getModelBElements()));
		
		return string.toString();
	}
}
