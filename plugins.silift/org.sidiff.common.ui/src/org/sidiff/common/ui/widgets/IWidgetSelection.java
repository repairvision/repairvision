package org.sidiff.common.ui.widgets;

import org.eclipse.swt.events.SelectionListener;

public interface IWidgetSelection {
	/**
	 * Add a selection listener to the widget control(s).
	 *
	 * @param listener The new listener.
	 */
	public void addSelectionListener(SelectionListener listener);

	/**
	 * Remove a selection listener from the widget control(s).
	 *
	 * @param listener The listener to remove.
	 */
	public void removeSelectionListener(SelectionListener listener);
}
