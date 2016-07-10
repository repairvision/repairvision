package org.sidiff.consistency.repair.lifting.ui.views;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.ui.Activator;
import org.sidiff.consistency.repair.lifting.ui.provider.RepairContentProvider;
import org.sidiff.consistency.repair.lifting.ui.provider.RepairLabelProvider;
import org.sidiff.consistency.repair.validation.ui.provider.RepairTreeContentProvider;
import org.sidiff.consistency.repair.validation.ui.provider.RepairTreeLabelProvider;

public class RepairView extends ViewPart {

	public static final String ID = "org.sidiff.consistency.repair.lifting.ui.views.RepairView";

	private RepairViewApp viewerApp;

	protected TreeViewer viewer_repairs;
	
	protected TreeViewer viewer_validation;

	private DrillDownAdapter drillDownAdapter;

	private Action openConfiguration;
	
	private Action calculateRepairs;
	
	private Action applyRepairs;

	class NameSorter extends ViewerSorter {
	}

	public RepairView() {
	}

	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		gl_composite.horizontalSpacing = 0;
		composite.setLayout(gl_composite);

		// Sash-Form:
		SashForm sashForm = new SashForm(composite, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		// Repair-Viewer:
		viewer_repairs = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_repairs.setContentProvider(new RepairContentProvider());
		viewer_repairs.setLabelProvider(new RepairLabelProvider());
//		viewer_repairs.setSorter(new NameSorter());
		
		drillDownAdapter = new DrillDownAdapter(viewer_repairs);

		getSite().setSelectionProvider(viewer_repairs);
		
		// Validation-Viewer:
		viewer_validation = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_validation.setContentProvider(new RepairTreeContentProvider());
		viewer_validation.setLabelProvider(new RepairTreeLabelProvider());
//		viewer_validation.setSorter(new NameSorter());

		// Edit-Rules:
		Composite composite_editrules = new Composite(sashForm, SWT.BORDER);
		composite_editrules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		new ModelDropWidget(composite_editrules) {

			@Override
			protected boolean removeModel(IResource selection) {
				return viewerApp.removeEditRule(selection);
			}

			@Override
			protected boolean addModel(IResource element) {
				return viewerApp.addEditRule(element);
			}
		};
		
		// Model A:
		Composite composite_modelA = new Composite(sashForm, SWT.BORDER);
		composite_modelA.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		new ModelDropWidget(composite_modelA) {

			@Override
			protected boolean removeModel(IResource selection) {
				return viewerApp.removeModelA(selection);
			}

			@Override
			protected boolean addModel(IResource element) {
				clear();
				return viewerApp.addModelA(element);
			}
		};

		// Model B:
		Composite composite_modelB = new Composite(sashForm, SWT.BORDER);
		composite_modelB.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		new ModelDropWidget(composite_modelB) {

			@Override
			protected boolean removeModel(IResource selection) {
				return viewerApp.removeModelB(selection);
			}

			@Override
			protected boolean addModel(IResource element) {
				clear();
				return viewerApp.addModelB(element);
			}
		};

		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 32, 10, 10, 10});

		// Application logic:
		viewerApp = new RepairViewApp(this);

		// Actions:
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				RepairView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer_repairs.getControl());
		viewer_repairs.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer_repairs);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(calculateRepairs);
		manager.add(new Separator());
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(applyRepairs);
		manager.add(new Separator());

		drillDownAdapter.addNavigationActions(manager);

		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(calculateRepairs);
		manager.add(applyRepairs);
		manager.add(new Separator());
		manager.add(openConfiguration);
		manager.add(new Separator());
		
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {

		// Open configuration:
		openConfiguration = new Action() {
			public void run() {
				PreferenceDialog configurationPage = PreferencesUtil.createPreferenceDialogOn(
						getViewSite().getShell(), RepairPreferencePage.ID, null, null);
				
				if (configurationPage != null) {
					configurationPage.open();
				}
			}
		};
		openConfiguration.setText("Configuration");
		openConfiguration.setToolTipText("Open Configuration");
		openConfiguration.setImageDescriptor(Activator.getImageDescriptor("icons/configuration.png"));
		
		
		// Calculate repairs:
		calculateRepairs = new Action() {
			public void run() {
				viewerApp.calculateRepairs();
			}
		};
		calculateRepairs.setText("Search Repairs");
		calculateRepairs.setToolTipText("Search Repairs");
		calculateRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/bulb.png"));
		
		// Apply repair:
		applyRepairs = new Action() {
			public void run() {
				ISelection selection = viewer_repairs.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
					
					if (selectedElement instanceof Repair) {
						viewerApp.applyRepairs((Repair) selectedElement);
						return;
					}
				}
				
				showMessage("Please select a repair operation!");
			}
		};
		applyRepairs.setText("Apply Repairs");
		applyRepairs.setToolTipText("Apply Repairs");
		applyRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/apply.png"));
	}

	private void hookDoubleClickAction() {
		
		// Expand / Collapse on double click:
		viewer_repairs.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();

			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection).getFirstElement();

				if (item == null) {
					return;
				}
				
				if (viewer_repairs.getExpandedState(item)) {

					// Collapse:
					viewer_repairs.collapseToLevel(item, TreeViewer.ALL_LEVELS);
				} else {
					
					// Expand:
					if (item instanceof Repair) {
						viewer_repairs.expandToLevel(item, 3);
					} else {
						viewer_repairs.expandToLevel(item, 1);
					}
				}
			}
		});
	}

	public void setFocus() {
		viewer_repairs.getControl().setFocus();
	}
	
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer_repairs.getControl().getShell(),
			this.getTitle(),
			message);
	}
}
