package org.sidiff.common.ui.widgets;

import org.eclipse.swt.events.ModifyListener;

public interface IWidgetModification {
	/**
	 * Adds a ModifiyListener to the widget's control(s)
	 * @param listener
	 */
	public void addModifyListener(ModifyListener listener);
	/**
	 * Removes a ModifiyListener to the widget's control(s)
	 * @param listener
	 */
	public void removeModifyListener(ModifyListener listener);
}
