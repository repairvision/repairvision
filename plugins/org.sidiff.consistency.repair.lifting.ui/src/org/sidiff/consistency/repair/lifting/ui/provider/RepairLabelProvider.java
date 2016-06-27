package org.sidiff.consistency.repair.lifting.ui.provider;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.repair.lifting.api.Repair;

public class RepairLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		return super.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof Repair) {
			return ((Repair) element).getEditRule().getName();
		}
		
		return super.getText(element);
	}
}
