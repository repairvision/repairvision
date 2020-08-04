package org.sidiff.revision.editrules.complement.util;

import org.eclipse.emf.henshin.model.Parameter;

public class ParameterBinding {

	protected Parameter parameter;
	
	protected Object value;

	public ParameterBinding(Parameter parameter) {
		this.parameter = parameter;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public boolean isSet() {
		return (value != null);
	}
}
