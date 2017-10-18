package org.sidiff.repair.ui.provider.model;

import java.util.List;

import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.ui.Activator;

public class ParameterItem implements IItemProvider {

	protected static Image ICON_PARAMETER_UNASSIGNED = Activator.getImageDescriptor("icons/parameter_unassigned.gif").createImage();
	
	protected static Image ICON_PARAMETER_ASSIGNED = Activator.getImageDescriptor("icons/parameter_assigned.gif").createImage();
	
	protected ParametersItem parent;
	
	protected Parameter parameter;
	
	public ParameterItem(ParametersItem parent, Parameter parameter) {
		this.parent = parent;
		this.parameter = parameter;
	}

	@Override
	public String getText() {
		Object value = parent.getRepairPlanItem().getRepairPlan().getParameterValue(parameter);
		
		if (value != null) {
			return "Assigned Parameter: " + " " + parameter.getName();
		} else {
			return "Unassigned Parameter: " + " " + parameter.getName();
		}
	}

	@Override
	public Image getImage() {
		Object value = parent.getRepairPlanItem().getRepairPlan().getParameterValue(parameter);
		
		if (value != null) {
			return ICON_PARAMETER_ASSIGNED;
		} else {
			return ICON_PARAMETER_UNASSIGNED;
		}
	}

	@Override
	public boolean hasChildren(Object element) {
		return true;
	}
	
	@Override
	public Object[] getChildren() {
		List<Object> parameterDomain = parent.getRepairPlanItem().getRepairPlan().getParameterDomain(parameter);
		ParameterValueItem[] parameterValueItems = new ParameterValueItem[parameterDomain.size()];
		
		for (int i = 0; i < parameterValueItems.length; i++) {
			parameterValueItems[i] = new ParameterValueItem(parameterDomain.get(i), this);
		}
		
		return parameterValueItems;
	}

	@Override
	public Object getParent() {
		return parent;
	}
	
	public Parameter getParameter() {
		return parameter;
	}
	
	public IRepairPlan getRepairPlan() {
		return parent.getRepairPlanItem().getRepairPlan();
	}
	
	public void unsetParameter() {
		getRepairPlan().setParameterValue(getParameter(), null);
	}
}
