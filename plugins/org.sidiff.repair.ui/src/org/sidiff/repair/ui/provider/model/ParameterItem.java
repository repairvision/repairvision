package org.sidiff.repair.ui.provider.model;

import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.swt.graphics.Image;
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
	public Image getIcon() {
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
		return parent.getRepairPlanItem().getRepairPlan().getParameterDomain(parameter).toArray();
	}

	@Override
	public Object getParent() {
		return parent;
	}

	@Override
	public void actionDoubleClick() {
	}

	@Override
	public void actionSelection() {
	}
}
