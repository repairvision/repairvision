package org.sidiff.repair.ui.provider.model;

public class ParameterValueItem {

	protected Object value;
	
	protected ParameterItem parameter;
	
	public ParameterValueItem(Object value, ParameterItem parameter) {
		this.value = value;
		this.parameter = parameter;
	}

	public Object getValue() {
		return value;
	}
	
	public ParameterItem getParameter() {
		return parameter;
	}
	
	public void setParameterValue() {
		parameter.getRepairPlan().setParameterValue(parameter.getParameter(), value);
	}
}
