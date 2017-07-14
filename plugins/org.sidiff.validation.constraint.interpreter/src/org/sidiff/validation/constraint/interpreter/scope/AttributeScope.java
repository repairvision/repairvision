package org.sidiff.validation.constraint.interpreter.scope;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class AttributeScope {

	private EObject object;
	
	private Object value;
	
	private EAttribute type;

	public AttributeScope(EObject object, Object value, EAttribute type) {
		super();
		this.object = object;
		this.value = value;
		this.type = type;
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

	public EAttribute getType() {
		return type;
	}

	public void setType(EAttribute type) {
		this.type = type;
	}
}
