package org.sidiff.revision.ui.viewer.provider.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.ui.viewer.Activator;
import org.sidiff.revision.ui.viewer.provider.IHighlightableElement;

public class ParameterItem implements IItemProvider, IHighlightableElement {

	protected static Image ICON_PARAMETER_UNASSIGNED = Activator.getImageDescriptor("icons/parameter_unassigned.gif").createImage();
	
	protected static Image ICON_PARAMETER_ASSIGNED = Activator.getImageDescriptor("icons/parameter_assigned.gif").createImage();
	
	protected ParametersItem parent;
	
	protected Parameter parameter;
	
	protected int domainSize;
	
	public ParameterItem(ParametersItem parent, Parameter parameter) {
		this.parent = parent;
		this.parameter = parameter;
		this.domainSize = parent.getComplementationPlanItem().getComplementationPlan().getParameterDomain(parameter).size();
	}

	@Override
	public String getText() {
		ComplementationPlan complementationPlan = parent.getComplementationPlanItem().getComplementationPlan();
		int currentDomainSize = parent.getComplementationPlanItem().getComplementationPlan().getParameterDomain(parameter).size();
		
		if (complementationPlan.isSetParameter(parameter)) {
			return "Assigned Parameter [" + currentDomainSize + " out of " + domainSize + "]: " + parameter.getName();
		} else {
			return "Unassigned Parameter [" + currentDomainSize + " out of " +  domainSize + "]: " + parameter.getName();
		}
	}

	@Override
	public Image getImage() {
		Object value = parent.getComplementationPlanItem().getComplementationPlan().getParameterValue(parameter);
		
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
		List<Object> parameterDomain = parent.getComplementationPlanItem().getComplementationPlan().getParameterDomain(parameter);
		
		if ((parameterDomain != null) && (!parameterDomain.isEmpty())) {
			ParameterValueObjectItem[] parameterValueItems = new ParameterValueObjectItem[parameterDomain.size()];
			
			for (int i = 0; i < parameterValueItems.length; i++) {
				parameterValueItems[i] = new ParameterValueObjectItem(parameterDomain.get(i), this);
			}
			
			return parameterValueItems;
		} else {
			return new Object[] {new ParameterValueInputItem(this)};
		}
	}

	@Override
	public Object getParent() {
		return parent;
	}
	
	public Parameter getParameter() {
		return parameter;
	}
	
	public ComplementationPlan getComplementationPlan() {
		return parent.getComplementationPlanItem().getComplementationPlan();
	}
	
	public void unsetParameter() {
		getComplementationPlan().setParameterValue(getParameter(), null);
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		List<EObject> elements = new ArrayList<>();
		List<Object> parameterDomain = parent.getComplementationPlanItem().getComplementationPlan().getParameterDomain(parameter);

		for (Object element : parameterDomain) {
			if (element instanceof EObject) {
				elements.add((EObject) element);
			}
		}

		return elements.iterator();
	}
}
