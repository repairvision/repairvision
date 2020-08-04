package org.sidiff.revision.repair.ui.controls;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.sidiff.common.utilities.ui.widgets.IDisposableControl;
import org.sidiff.common.utilities.ui.widgets.IUnsetableControl;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.repair.ui.app.IRepairApplication;
import org.sidiff.revision.repair.ui.app.IResultChangedListener;

/**
 * Creates the UI input controls and provides.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <A>
 *            The application which controls the UI access.
 */
public interface IRepairUI<A extends IRepairApplication<?, ?>> 
			extends IUnsetableControl, IResultChangedListener<ComplementationJob<?>>, IDisposableControl {

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
	public void createPartControls(Composite parent, IWorkbenchPartSite site);
	
	/**
	 * Creates the tool-bar actions of the repair view.
	 */
	public void createLocalToolBar(IToolBarManager manager);
	
	/**
	 * Creates the pull down actions of the repair view.
	 */
	public void createLocalPullDown(IMenuManager manager);
	
	/**
	 * Creates the context actions of the repair view.
	 */
	public void createContextMenu(IMenuManager manager);
	
	/**
	 * Setups the main menu on an viewer.
	 */
	public void hookContextMenu(MenuManager manager);
	
	/**
	 * @return Provides a selection to the workbench.
	 */
	public ISelectionProvider getSelectionProvider();
	
	/**
	 * Asks this part to take focus within the workbench.
	 */
	public void setFocus();
}
