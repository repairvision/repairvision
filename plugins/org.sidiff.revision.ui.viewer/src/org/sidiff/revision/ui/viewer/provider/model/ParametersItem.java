package org.sidiff.revision.ui.viewer.provider.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.ui.viewer.Activator;
import org.sidiff.revision.ui.viewer.provider.IHighlightableElement;

public class ParametersItem implements IItemProvider, IHighlightableElement {

	protected static final String TEXT_PARAMETERS = "Parameters";
	
	protected static Image ICON_PARAMETERS = Activator.getImageDescriptor("icons/parameters.gif").createImage();
	
	protected ComplementationPlanItem complementationPlan;
	
	protected ParameterItem[] parameters;

	public ParametersItem(ComplementationPlanItem complementationPlan) {
		this.complementationPlan = complementationPlan;
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
			List<Parameter> complementParameters = complementationPlan.getComplementationPlan().getParameters();
			parameters = new ParameterItem[complementParameters.size()];
			
			for (int i = 0; i < parameters.length; i++) {
				parameters[i] = new ParameterItem(this, complementParameters.get(i));
			}
		}
		
		return parameters;
	}
	
	@Override
	public Object getParent() {
		return complementationPlan;
	}

	public ComplementationPlanItem getComplementationPlanItem() {
		return complementationPlan;
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		List<EObject> elements = new ArrayList<>();

		for (int i = 0; i < parameters.length; i++) {
			Parameter parameter = parameters[i].parameter;
			List<Object> parameterDomain = getComplementationPlanItem().getComplementationPlan().getParameterDomain(parameter);
			
			for (Object element : parameterDomain) {
				if (element instanceof EObject) {
					elements.add((EObject) element);
				}
			}
		}
		
		return elements.iterator();
	}
}
