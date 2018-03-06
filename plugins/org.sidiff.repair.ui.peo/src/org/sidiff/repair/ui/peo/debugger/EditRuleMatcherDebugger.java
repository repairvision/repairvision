package org.sidiff.repair.ui.peo.debugger;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.repair.api.peo.PEORepairCalculationEngineDebugger;
import org.sidiff.repair.ui.peo.debugger.model.DebuggingSession;

public class EditRuleMatcherDebugger extends ViewPart {

	//// UI ////
	
	public static final String ID = "org.sidiff.repair.ui.peo.debugger.EditRuleMatcherDebugger"; //$NON-NLS-1$
	
	protected TreeViewer debuggingSnapshots;
	
	protected Action actionCreateSnapshot;
	
	//// Application ////
	
	protected DebuggingSession debuggingSession;

	public EditRuleMatcherDebugger() {
	}
	
	public void setDebugger(PEORepairCalculationEngineDebugger debugger) {
		this.debuggingSession = new DebuggingSession(debugger.getLastComplementMonitor());
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		this.debuggingSnapshots = new TreeViewer(container, SWT.BORDER);

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			actionCreateSnapshot = new Action("Create Snapshot") {				public void run() {
					if (debuggingSession != null) {
						debuggingSession.createSnapshot();
						debuggingSnapshots.refresh();
					} else {
						WorkbenchUtil.showError("No active recognition engine!");
					}
				}
			};
		}
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
		toolbarManager.add(actionCreateSnapshot);
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
		menuManager.add(actionCreateSnapshot);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
