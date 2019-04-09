package org.sidiff.repair.ui.views;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.config.RepairDectectionEngineProvider;
import org.sidiff.repair.ui.config.RepairPreferencePage;
import org.sidiff.repair.ui.controls.IRepairUI;

public class RepairView extends ViewPart implements IResultChangedListener<RepairJob<?>> {

	public static final String ID = "org.sidiff.repair.lifting.ui.views.RepairView";

	protected IRepairUI<?>  presentation;
	
	protected RepairDectectionEngineProvider repairEgineProvider;
	
	public RepairView() {
	}

	public void createPartControl(Composite parent) {

		// Create controls:
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		gl_composite.horizontalSpacing = 0;
		container.setLayout(gl_composite);

		// Setup repair engine:
		repairEgineProvider = RepairPreferencePage.getRepairDectectionProvider();
		repairEgineProvider.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				// The selected (settings) repair engine has changed:
				presentation.getApplication().removeResultChangeListener(RepairView.this);
				presentation.dispose();

				container.dispose();
				createPartControl(parent);
				parent.layout();

				repairEgineProvider.removeSelectionChangedListener(this);
			}
		});
		
		// Add repair engine:
		setupRepairEngine(container);
		
		// Setup actions:
		hookContextMenu();
		
		// Setup actions:
		contributeToActionBars();
	}
	
	protected void setupRepairEngine(Composite parent) {
		presentation = (IRepairUI<?>) repairEgineProvider.getSelectedEngine()
				.getPresentationInstance().getRepairPresentation();

		presentation.createPartControls(parent, getSite());
		presentation.getApplication().addResultChangedListener(this);
	}

	protected void hookContextMenu() {
		
		MenuManager menuManager = new MenuManager("#PopupMenu");
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {
			
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(menuManager);
				
				// Other plug-ins can contribute there actions here
				manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			}
		});

		presentation.hookContextMenu(menuManager);
		getSite().registerContextMenu(menuManager, presentation.getSelectionProvider());
	}

	protected void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().removeAll();
		bars.getToolBarManager().removeAll();
		
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
		
		bars.getMenuManager().update(true);
		bars.getToolBarManager().update(true);
	}

	protected void fillLocalPullDown(IMenuManager manager) {
		presentation.createLocalPullDown(manager);
	}

	protected void fillContextMenu(MenuManager manager) {
		presentation.createContextMenu(manager);
	}

	protected void fillLocalToolBar(IToolBarManager manager) {
		presentation.createLocalToolBar(manager);
	}

	@Override
	public void resultChanged(RepairJob<?> repairJob) {
		presentation.resultChanged(repairJob);
	}
	
	public void setFocus() {
		presentation.setFocus();
	}
	
	public void clear() {
		presentation.clear();
	}
}
