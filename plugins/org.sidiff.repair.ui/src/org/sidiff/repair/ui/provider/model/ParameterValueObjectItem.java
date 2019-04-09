package org.sidiff.repair.ui.provider.model;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.common.java.JUtil;
import org.sidiff.repair.ui.provider.IHighlightableElement;

public class ParameterValueObjectItem implements IParameterInput, IHighlightableElement {

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

	@Override
	public Iterator<? extends EObject> getModelElements() {
		if (value instanceof EObject) {
			return JUtil.singeltonIterator((EObject) value);
		} else {
			return JUtil.emptyIterator();
		}
	}
}
