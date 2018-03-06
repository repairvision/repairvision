package org.sidiff.editrule.recognition.pattern.domain;

import org.eclipse.emf.ecore.EAttribute;
import org.sidiff.graphpattern.AttributePattern;

public class AttributeConstant {

	protected AttributePattern attribute;
	
	protected EAttribute type;
	
	protected Object value;
	
	public AttributeConstant(AttributePattern attribute) {
		this.attribute = attribute;
		this.type = attribute.getType();
		this.value = parseConstant(attribute);
	}
	
	public AttributePattern getAttribute() {
		return attribute;
	}
	
	public EAttribute getType() {
		return type;
	}
	
	public Object getValue() {
		return value;
	}
	
	public static Object parseConstant(AttributePattern attribute) {
		
		// Parse string:
		if (attribute.getValue().startsWith("\"") && attribute.getValue().endsWith("\"")) {
			String attributeValue = attribute.getValue().substring(1, attribute.getValue().length() - 1);
			return attributeValue;
		}
		
		// Parse integer:
		try {
			return Integer.valueOf(attribute.getValue());
		} catch (Exception e) {
		}
		
		// Parse floating point:
		try {
			return Double.valueOf(attribute.getValue());
		} catch (Exception e) {
		}
		
		return null;
	}
}
