package org.sidiff.revision.editrules.recognition.match;

import org.eclipse.emf.henshin.model.Parameter;

public class RecognitionParameterMatch extends RecognitionMatch {

	private Parameter parameter;
	
	private Object value;
	
	public RecognitionParameterMatch(Parameter parameter, Object value) {
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
