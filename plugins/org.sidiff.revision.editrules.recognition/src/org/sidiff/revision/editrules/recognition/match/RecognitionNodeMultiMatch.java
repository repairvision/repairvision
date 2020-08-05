package org.sidiff.revision.editrules.recognition.match;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.common.emf.ModelingUtil;

public class RecognitionNodeMultiMatch extends RecognitionNodeMatch {

	private List<EObject> modelAElements;
	
	private List<EObject> modelBElements;

	public RecognitionNodeMultiMatch(Type action, Node node) {
		super(action, node);
	}
	
	public List<EObject> getModelAElements() {
		return modelAElements;
	}

	public void setModelAElements(List<EObject> modelAElements) {
		this.modelAElements = modelAElements;
	}

	public List<EObject> getModelBElements() {
		return modelBElements;
	}

	public void setModelBElements(List<EObject> modelBElements) {
		this.modelBElements = modelBElements;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append("<<" + getAction() + ">>");
		string.append(" " + getNode());
		string.append(" A: " + getNames(getModelAElements()));
		string.append(" B: " + getNames(getModelBElements()));
		
		return string.toString();
	}
	
	private static String getNames(Collection<? extends EObject> objects) {
		StringBuffer string = new StringBuffer();
		
		string.append("[");
		
		for (EObject object : objects) {
			string.append(ModelingUtil.getName(object));
			string.append(", ");
		}
		string.replace(string.length() - 2, string.length(), "");
		string.append("]");
		
		return string.toString();
	}
}
