package org.sidiff.common.emf.access;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class Field {

	private EObject container;
	
	private EAttribute type;
	
	private String value;

	public Field(EObject container, EAttribute type, String value) {
		super();
		this.container = container;
		this.type = type;
		this.value = value;
	}

	public EObject getContainer() {
		return container;
	}

	public EAttribute getType() {
		return type;
	}


	public String getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Field){
			Field field = (Field)o;
			if(this.container.equals(field.container) && this.type.equals(field.type)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return container.hashCode()+type.hashCode();
	}
	
}
