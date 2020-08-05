package org.sidiff.revision.editrules.recognition.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.GraphElement;
import org.sidiff.revision.common.emf.ModelingUtil;

public class RecognitionAttributeMatch extends RecognitionActionMatch {

	private Attribute attribute;
	
	private EObject object;
	
	private Object value;

	public RecognitionAttributeMatch(Attribute attribute, EObject object, Object value) {
		super(Type.CREATE);
		this.object = object;
		this.attribute = attribute;
		this.value = value;
	}
	
	@Override
	public GraphElement getGraphElement() {
		return attribute;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public EObject getObject() {
		return object;
	}

	public void setObject(EObject object) {
		this.object = object;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append("<<" + getAction() + ">>");
		string.append(" " + getAttribute());
		string.append(" Object: " + ModelingUtil.getName(getObject()));
		string.append(" Value: " + getValue());
		
		return string.toString();
	}
}
