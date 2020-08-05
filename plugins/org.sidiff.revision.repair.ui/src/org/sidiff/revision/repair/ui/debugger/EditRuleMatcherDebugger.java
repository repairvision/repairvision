package org.sidiff.revision.repair.ui.debugger;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.repair.api.RepairCalculationEngineDebugger;
import org.sidiff.revision.repair.ui.debugger.model.DebuggingSession;

public class EditRuleMatcherDebugger extends ViewPart {

	//// UI ////
	
	public static final String ID = "org.sidiff.revision.repair.ui.debugger.EditRuleMatcherDebugger"; //$NON-NLS-1$
	
	protected TreeViewer debuggingSnapshots;
	
	protected Action actionCreateSnapshot;
	
	//// Application ////
	
	protected DebuggingSession debuggingSession;

	public EditRuleMatcherDebugger() {
	}
	
	public void setDebugger(RepairCalculationEngineDebugger debugger) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				EditRuleMatcherDebugger.this.debuggingSession = new DebuggingSession(debugger);
				EditRuleMatcherDebugger.this.debuggingSnapshots.setInput(debuggingSession);
			}
		});
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TreeItemProvider itemProvider = new TreeItemProvider();
		
		this.debuggingSnapshots = new TreeViewer(container, SWT.BORDER);
		this.debuggingSnapshots.setContentProvider(itemProvider);
		this.debuggingSnapshots.setLabelProvider(itemProvider);

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
