package org.sidiff.repair.ui.provider.model;

public class ParameterValueObjectItem implements IParameterInput {

	protected Object value;
	
	protected ParameterItem parameter;
	
	public ParameterValueObjectItem(Object value, ParameterItem parameter) {
		this.value = value;
		this.parameter = parameter;
	}

	public Object getValue() {
		return value;
	}
	
	public ParameterItem getParameter() {
		return parameter;
	}
	
	@Override
	public void setParameterValue() {
		parameter.getRepairPlan().setParameterValue(parameter.getParameter(), value);
	}
}
