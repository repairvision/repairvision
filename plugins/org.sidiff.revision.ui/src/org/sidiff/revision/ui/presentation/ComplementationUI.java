package org.sidiff.revision.ui.presentation;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.common.ui.widgets.IDisposableControl;
import org.sidiff.revision.common.ui.widgets.IUnsetableControl;
import org.sidiff.revision.ui.application.ComplementationApplication;
import org.sidiff.revision.ui.application.ResultChangedListener;

/**
 * Creates the UI input controls and provides.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <A>
 *            The application which controls the UI access.
 */
public interface ComplementationUI<A extends ComplementationApplication<?, ?>> 
			extends IUnsetableControl, ResultChangedListener<ComplementationJob<?>>, IDisposableControl {

	/**
	 * @param application
	 *            The application which controls the UI access.
	 */
	public void initialize(A application);
	
	/**
	 * @return The corresponding complementation application.
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
	 * Creates the tool-bar actions of the complementation view.
	 */
	public void createLocalToolBar(IToolBarManager manager);
	
	/**
	 * Creates the pull down actions of the complementation view.
	 */
	public void createLocalPullDown(IMenuManager manager);
	
	/**
	 * Creates the context actions of the complementation view.
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
