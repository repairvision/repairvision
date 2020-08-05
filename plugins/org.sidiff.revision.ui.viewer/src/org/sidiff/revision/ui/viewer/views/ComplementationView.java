package org.sidiff.revision.ui.viewer.views;

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
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.ui.application.ResultChangedListener;
import org.sidiff.revision.ui.configuration.page.ComplementationPreferencePage;
import org.sidiff.revision.ui.configuration.page.UserInterfaceProvider;
import org.sidiff.revision.ui.presentation.ComplementationUI;

public class ComplementationView extends ViewPart implements ResultChangedListener<ComplementationJob<?>> {

	protected ComplementationUI<?>  presentation;
	
	protected UserInterfaceProvider compelementationEgineProvider;
	
	public ComplementationView() {
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

		// Setup compelementation engine:
		compelementationEgineProvider = ComplementationPreferencePage.getUserInterfaceProvider();
		compelementationEgineProvider.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				// The selected (settings) compelementation engine has changed:
				presentation.getApplication().removeResultChangeListener(ComplementationView.this);
				presentation.dispose();

				container.dispose();
				createPartControl(parent);
				parent.layout();

				compelementationEgineProvider.removeSelectionChangedListener(this);
			}
		});
		
		// Add compelementation engine:
		setupCompelementationEngine(container);
		
		// Setup actions:
		hookContextMenu();
		
		// Setup actions:
		contributeToActionBars();
	}
	
	protected void setupCompelementationEngine(Composite parent) {
		presentation = (ComplementationUI<?>) compelementationEgineProvider.getSelectedEngine()
				.getPresentationInstance().getComplementationPresentation();

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
	public void resultChanged(ComplementationJob<?> compelementationJob) {
		presentation.resultChanged(compelementationJob);
	}
	
	public void setFocus() {
		presentation.setFocus();
	}
	
	public void clear() {
		presentation.clear();
	}
}
