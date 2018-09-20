package org.sidiff.editrule.recognition.pattern.graph;

import org.eclipse.emf.ecore.EAttribute;

public class ActionAttributeConstraintConstant implements ActionAttributeConstraint {

	protected EAttribute type;
	
	protected Object value;
	
	public ActionAttributeConstraintConstant(EAttribute type, Object value) {
		this.type = type;
		this.value = value;
	}

	public static ActionAttributeConstraintConstant create(EAttribute type, String value) {
		Object parsedValue = parseConstant(value);
		
		if (value != null) {
			return new ActionAttributeConstraintConstant(type, parsedValue);
		} else {
			return null;
		}
	}
	
	@Override
	public EAttribute getType() {
		return type;
	}
	
	@Override
	public boolean check(Object value) {
		return this.value.equals(value);
	}
	
	private static Object parseConstant(String value) {
		
		// Parse string:
		String trimmedValue = null;
		
		if (value.startsWith("\"") && value.endsWith("\"") && !value.substring(1, value.length() - 1).contains("\"")) {
			trimmedValue = value.substring(1, value.length() - 1);
		}
		
		// Parse integer:
		try {
			if (trimmedValue != null) {
				return Integer.valueOf(trimmedValue);
			} else {
				return Integer.valueOf(value);
			}
		} catch (Exception e) {
		}
		
		// Parse floating point:
		try {
			if (trimmedValue != null) {
				return Double.valueOf(trimmedValue);
			} else {
				return Double.valueOf(value);
			}
		} catch (Exception e) {
		}
		
		// Parse boolean:
		try {
			if (trimmedValue != null) {
				return Boolean.valueOf(trimmedValue);
			} else {
				return Boolean.valueOf(value);
			}
		} catch (Exception e) {
		}
		
		if (trimmedValue != null) {
			return trimmedValue;
		} else {
			return null;
		}
	}
}
