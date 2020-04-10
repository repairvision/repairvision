package org.sidiff.revision.repair.ui.provider.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.provider.IHighlightableElement;

public class ParametersItem implements IItemProvider, IHighlightableElement {

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
	public Image getImage() {
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

	public RepairPlanItem getRepairPlanItem() {
		return repairPlan;
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		List<EObject> elements = new ArrayList<>();

		for (int i = 0; i < parameters.length; i++) {
			Parameter parameter = parameters[i].parameter;
			List<Object> parameterDomain = getRepairPlanItem().getRepairPlan().getParameterDomain(parameter);
			
			for (Object element : parameterDomain) {
				if (element instanceof EObject) {
					elements.add((EObject) element);
				}
			}
		}
		
		return elements.iterator();
	}
}
