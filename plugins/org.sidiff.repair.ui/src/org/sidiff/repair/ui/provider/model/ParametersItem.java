package org.sidiff.repair.ui.provider.model;

import java.util.List;

import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.ui.Activator;

public class ParametersItem implements IItemProvider  {

	protected static final String TEXT_PARAMETERS = "Parameters";
	
	protected static Image ICON_PARAMETERS = Activator.getImageDescriptor("icons/parameters.gif").createImage();
	
	protected RepairPlanItem repairPlan;
	
	protected ParameterItem[] parameters;

	public ParametersItem(RepairPlanItem repairPlan) {
		this.repairPlan = repairPlan;
	}

	@Override
	public String getText() {
		return TEXT_PARAMETERS;
	}

	@Override
	public Image getIcon() {
		return ICON_PARAMETERS;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return getChildren().length > 0;
	}

	@Override
	public Object[] getChildren() {
		
		if (parameters == null) {
			List<Parameter> complementParameters = repairPlan.getRepairPlan().getParameters();
			parameters = new ParameterItem[complementParameters.size()];
			
			for (int i = 0; i < parameters.length; i++) {
				parameters[i] = new ParameterItem(this, complementParameters.get(i));
			}
		}
		
		return parameters;
	}
	
	@Override
	public Object getParent() {
		return repairPlan;
	}

	@Override
	public void actionDoubleClick() {
	}

	@Override
	public void actionSelection() {
	}

	public RepairPlanItem getRepairPlanItem() {
		return repairPlan;
	}
}
