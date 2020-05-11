package org.sidiff.revision.editrules.recognition.pattern.graph;

import org.eclipse.emf.ecore.EAttribute;
import org.sidiff.graphpattern.attributes.JavaSciptParser;

public class ActionAttributeConstraintConstant implements ActionAttributeConstraint {

	protected EAttribute type;
	
	protected Object value;
	
	public ActionAttributeConstraintConstant(EAttribute type, Object value) {
		this.type = type;
		this.value = value;
	}

	public static ActionAttributeConstraintConstant create(EAttribute type, String value) {
		Object parsedValue = JavaSciptParser.getConstant(type.getEAttributeType(), value);
		
		if (parsedValue != null) {
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
}
