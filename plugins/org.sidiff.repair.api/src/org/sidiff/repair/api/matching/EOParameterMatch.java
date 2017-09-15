package org.sidiff.repair.api.matching;

import org.eclipse.emf.henshin.model.Parameter;

public class EOParameterMatch extends EOMatch {

	private Parameter parameter;
	
	private Object value;
	
	public EOParameterMatch(Parameter parameter, Object value) {
		this.parameter = parameter;
		this.value = value;
	}
	
	public Parameter getParameter() {
		return parameter;
	}

	public Object getValue() {
		return value;
	}
}
