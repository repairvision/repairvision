package org.sidiff.repair.ui.provider.model;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.sidiff.repair.ui.Activator;

public class ParameterValueInputItem implements IItemProvider, IParameterInput {

	protected static Image IMG_VALUE_INPUT = Activator.getImageDescriptor("icons/question_mark.png").createImage();
	
	protected ParameterItem parameter;

	public ParameterValueInputItem(ParameterItem parameter) {
		this.parameter = parameter;
	}

	@Override
	public String getText() {
		if (parameter.getRepairPlan().isSetParameter(parameter.getParameter())) {
			return parameter.getRepairPlan().getParameterValue(parameter.getParameter()).toString();
		} else {
			return "Set Input Value";
		}
	}

	@Override
	public Image getImage() {
		return IMG_VALUE_INPUT;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

	@Override
	public Object[] getChildren() {
		return new Object[0];
	}

	@Override
	public Object getParent() {
		return parameter;
	}

	@Override
	public void setParameterValue() {
		InputDialog setValueDialog = new InputDialog(Display.getDefault().getActiveShell(), 
				"New Input Value", "Enter a value:", "", null);
		
		setValueDialog.open();
		
		if (setValueDialog.getValue() != null) {
			parameter.getRepairPlan().setParameterValue(parameter.getParameter(), setValueDialog.getValue());
		}
	}
}
