package org.sidiff.repair.ui.controls;

import org.eclipse.swt.widgets.Composite;
import org.sidiff.repair.ui.app.IRepairApplication;

/**
 * Creates the UI input controls and provides.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <A>
 *            The application which controls the UI access.
 */
public interface IRepairUI<C extends Composite, A extends IRepairApplication<?, ?>> extends IUnsetableControl {

	/**
	 * @param application
	 *            The application which controls the UI access.
	 */
	public void initialize(A application);
	
	/**
	 * @return The corresponding repair application.
	 */
	public A getApplication();

	/**
	 * Creates the UI input controls.
	 * 
	 * @param parent
	 *            The parent control.
	 */
	public void createPartControls(C parent);
	
	/**
	 * Dispose all part controls.
	 */
	public void dispose();
}
