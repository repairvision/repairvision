package org.sidiff.consistency.repair.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
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
import org.sidiff.consistency.common.ui.NameUtil;
import org.sidiff.consistency.repair.api.IRepair;
import org.sidiff.consistency.repair.api.RepairJob;
import org.sidiff.consistency.repair.ui.Activator;
import org.sidiff.consistency.repair.ui.app.IRepairApplication;
import org.sidiff.consistency.repair.ui.app.IResultChangedListener;
import org.sidiff.consistency.repair.ui.config.RepairDectectionEngineProvider;
import org.sidiff.consistency.repair.ui.config.RepairPreferencePage;
import org.sidiff.consistency.repair.ui.controls.IRepairUI;
import org.sidiff.consistency.repair.ui.decoration.RepairSelectionController;
import org.sidiff.consistency.repair.ui.provider.RepairContentProvider;
import org.sidiff.consistency.repair.ui.provider.RepairLabelProvider;
import org.sidiff.consistency.repair.ui.views.rankings.HistoricComplementingRatioRepairRanking;

public class RepairView extends ViewPart implements IResultChangedListener<RepairJob<?>> {

	public static final String ID = "org.sidiff.consistency.repair.lifting.ui.views.RepairView";

	private IRepairApplication<?, ?> viewerApp;
	
	private RepairDectectionEngineProvider repairEgineProvider;
	
	private TreeViewer viewer_repairs;
	
	private IRepairUI<SashForm,?>  presentation;
	
	private DrillDownAdapter drillDownAdapter;

	private Action openConfiguration;
	
	private Action calculateRepairs;
	
	private Action applyRepairs;
	
	private Action undoRepairs;
	
	private Action clearSetup;

	public RepairView() {
	}
	
//	Composite parent;

	public void createPartControl(Composite parent) {
//		this.parent = parent;
		// Create controls:
		internal_createPartControl(parent);
		
		// Setup actions:
		makeActions();
		contributeToActionBars();
	}
	
	private void internal_createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		gl_composite.horizontalSpacing = 0;
		container.setLayout(gl_composite);

		// Sash-Form:
		SashForm sashForm = new SashForm(container, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		// Repair-Viewer:
		viewer_repairs = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_repairs.setContentProvider(new RepairContentProvider());
		viewer_repairs.setLabelProvider(new RepairLabelProvider());
		viewer_repairs.setComparator(new HistoricComplementingRatioRepairRanking());
		
		viewer_repairs.addSelectionChangedListener(RepairSelectionController.getInstance());
		
		drillDownAdapter = new DrillDownAdapter(viewer_repairs);

		getSite().setSelectionProvider(viewer_repairs);
		
		// Setup repair engine:
		repairEgineProvider = RepairPreferencePage.getRepairDectectionProvider();
		repairEgineProvider.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				viewerApp.removeResultChangeListener(RepairView.this);
				presentation.dispose();
				
				container.dispose();
				internal_createPartControl(parent);
				parent.layout();
				
				repairEgineProvider.removeSelectionChangedListener(this);
			}
		});
		
		// Add repair engine:
		setupRepairEngine(sashForm);
		
		// Setup actions:
		hookContextMenu();
		hookDoubleClickAction();
	}
	
	@SuppressWarnings("unchecked")
	private void setupRepairEngine(SashForm sashForm) {
		
		// FIXME: How to deal with the type of the parent container.
		presentation = (IRepairUI<SashForm, ?>) repairEgineProvider.getSelectedEngine()
				.getPresentationInstance().getRepairPresentation();

		presentation.createPartControls(sashForm);
		presentation.getApplication().addResultChangedListener(this);
		this.viewerApp = presentation.getApplication();
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
		manager.add(undoRepairs);
		manager.add(new Separator());
		manager.add(clearSetup);
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
			@SuppressWarnings("unchecked")
			public void run() {
				ISelection selection = viewer_repairs.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					List<IRepair> selectedRepairs = new ArrayList<>();
					
					((IStructuredSelection)selection).iterator().forEachRemaining(o -> {
						if (o instanceof IRepair) {
							selectedRepairs.add((IRepair) o);
						}
					});
					
					if (!selectedRepairs.isEmpty()) {
						if (viewerApp.applyRepairs(selectedRepairs)) {
							
							// TODO: Ask the user what to do!
							// Recalculate repairs:
							viewerApp.recalculateRepairs();
							
							showMessage("Repair successfully applied!");
						} else {
							showMessage("Repair could not be applied!");
						}
						return;
					}
				}
				
				showMessage("Please select a repair operation!");
			}
		};
		applyRepairs.setText("Apply Repair");
		applyRepairs.setToolTipText("Apply Repair");
		applyRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/apply.png"));
		
		// Undo repair:
		undoRepairs = new Action() {
			public void run() {
				List<RuleApplication> lastRepairs = viewerApp.undoLastRepairs();
				
				if (lastRepairs != null) {
					
					// TODO: Ask the user what to do!
					// Recalculate repairs:
					viewerApp.recalculateRepairs();
					
					// Show user message:
					String rules = "";
					
					for (RuleApplication lastRepair : lastRepairs) {
						rules += NameUtil.beautifyName(lastRepair.getRule().getName());
					}
					
					showMessage("Repair ("+ rules +") successfully undone!");
				} else {
					showMessage("Repair could not be undone!");
				}
			}
		};
		undoRepairs.setText("Undo Repair");
		undoRepairs.setToolTipText("Undo Repair");
		undoRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/undo.png"));
		
		// Clear setup:
		clearSetup = new Action() {
			public void run() {
				viewerApp.clear();
				clear();
			}
		};
		clearSetup.setText("Clear");
		clearSetup.setToolTipText("Clear");
		clearSetup.setImageDescriptor(Activator.getImageDescriptor("icons/clear.png"));
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
				
				try {
					if (viewer_repairs.getExpandedState(item)) {

						// Collapse:
						viewer_repairs.collapseToLevel(item, TreeViewer.ALL_LEVELS);
					} else {
						
						// Expand:
						if (item instanceof IRepair) {
							viewer_repairs.expandToLevel(item, 3);
						} else {
							viewer_repairs.expandToLevel(item, 1);
						}
					}
				} catch (Exception e) {
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
	
	@Override
	public void resultChanged(RepairJob<?> repairJob) {
		viewer_repairs.setInput(repairJob.getRepairs());
	}
	
	public void clear() {
		viewer_repairs.setInput(null);
		presentation.clear();
	}
}
