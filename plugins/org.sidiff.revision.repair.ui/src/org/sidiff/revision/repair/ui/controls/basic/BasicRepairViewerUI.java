package org.sidiff.revision.repair.ui.controls.basic;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.part.DrillDownAdapter;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.integration.editor.highlighting.EditorHighlighting;
import org.sidiff.integration.editor.highlighting.ISelectionHighlightingAdapter;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.app.IRepairApplication;
import org.sidiff.revision.repair.ui.config.RepairPreferencePage;
import org.sidiff.revision.repair.ui.provider.IHighlightableElement;
import org.sidiff.revision.repair.ui.provider.RepairContentProvider;
import org.sidiff.revision.repair.ui.provider.RepairLabelProvider;
import org.sidiff.revision.repair.ui.provider.model.IParameterInput;
import org.sidiff.revision.repair.ui.provider.model.ParameterItem;
import org.sidiff.revision.repair.ui.provider.model.RepairPlanItem;

public class BasicRepairViewerUI<A extends IRepairApplication<?, ?>> extends BasicRepairUI<A> {

	protected TreeViewer viewer_repairs;
	
	protected ISelectionHighlightingAdapter highlightingAdapter;
	
	private DrillDownAdapter drillDownAdapter;
	
	protected Action openConfiguration;
	
	protected Action calculateRepairs;
	
	protected Action rollbackInducingChanges;
	
	protected Action setParameter;
	
	protected Action unsetParameter;
	
	protected Action applyRepairs;
	
	protected Action undoRepairs;
	
	protected Action clearSetup;
	
	
	protected Action openHistoricModel;
	
	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		createRepairViewer(parent, site);
		makeActions(site);
	}
	
	protected void createRepairViewer(Composite parent, IWorkbenchPartSite site) {
		
		// Repair-Viewer:
		viewer_repairs = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_repairs.setContentProvider(new RepairContentProvider());
		viewer_repairs.setLabelProvider(new RepairLabelProvider());

		// Setup editor highlighting:
		highlightingAdapter = new ISelectionHighlightingAdapter() {
			
			@Override
			public Iterator<? extends EObject> getElements(ISelection selection) {
				Object selectedElement = ISelectionHighlightingAdapter.getFirstElement(selection);
				
				if (selectedElement instanceof IHighlightableElement) {
					return ((IHighlightableElement) selectedElement).getModelElements();
				}
				
				return ISelectionHighlightingAdapter.EMPTY_ITERATOR;
			}
		};
		
		EditorHighlighting.getInstance().registerAdapter(highlightingAdapter);
		viewer_repairs.addSelectionChangedListener(
				EditorHighlighting.getInstance().getSelectionChangedListener());
		
		// Workbench selection:
		site.setSelectionProvider(viewer_repairs);
		
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
						if (item instanceof RepairPlanItem) {
							viewer_repairs.expandToLevel(item, 3);
						} else {
							viewer_repairs.expandToLevel(item, 1);
						}
					}
				} catch (Exception e) {
				}
			}
		});
		
		// Enable/Disable actions:
		viewer_repairs.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				refreshActionStates();
			}
		});
	}
	
	protected void refreshActionStates() {
		openConfiguration.isEnabled();
		calculateRepairs.isEnabled();
		applyRepairs.isEnabled();
		undoRepairs.isEnabled();
		clearSetup.isEnabled();
		setParameter.isEnabled();
		unsetParameter.isEnabled();
		openHistoricModel.isEnabled();
	}
	
	protected void makeActions(IWorkbenchPartSite site) {
		
		this.drillDownAdapter = new DrillDownAdapter(viewer_repairs);

		// Calculate repairs:
		calculateRepairs = new Action() {
			public void run() {
				application.validation();
			}
		};
		calculateRepairs.setText("Validate Model");
		calculateRepairs.setToolTipText("Validate Model");
		calculateRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/bulb.png"));
		
		// Apply repair:
		applyRepairs = new Action() {

			public void run() {
				ISelection selection = viewer_repairs.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					Object selected = ((IStructuredSelection) selection).getFirstElement();

					if (selected instanceof RepairPlanItem) {
						IRepairPlan repair = ((RepairPlanItem) selected).getRepairPlan();
						List<Match> matches = repair.getComplementMatches();
						
						if (matches.size() == 1) {
							if (application.applyRepair(repair, matches.get(0))) {
								WorkbenchUtil.showMessage("Repair successfully applied!");
								
								// Recalculate repairs:
								application.recalculateRepairs();
							} else {
								WorkbenchUtil.showMessage("Repair could not be applied!");
							}
						} else {
							WorkbenchUtil.showMessage("Please specify all parameters!");
						}
						
						return;
					}
				}
				
				WorkbenchUtil.showMessage("Please select a repair operation!");
			}
			
			@Override
			public boolean isEnabled() {
				IStructuredSelection selection = (IStructuredSelection) viewer_repairs.getSelection();
				
				if (selection.getFirstElement() instanceof RepairPlanItem) {
					applyRepairs.setEnabled(true);
				} else {
					applyRepairs.setEnabled(false);
				}
				
				return super.isEnabled();
			}
		};
		applyRepairs.setText("Apply Repair");
		applyRepairs.setToolTipText("Apply Repair");
		applyRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/apply.png"));
		
		// Undo repair:
		rollbackInducingChanges = new Action() {
			public void run() {
				
				ISelection selection = viewer_repairs.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					Object selected = ((IStructuredSelection) selection).getFirstElement();

					if (selected instanceof RepairPlanItem) {
						IRepairPlan repair = ((RepairPlanItem) selected).getRepairPlan();
						
						if (application.rollbackInconsistencyInducingChanges(repair)) {
							WorkbenchUtil.showMessage("Inconsistency-inducing changes successfully undone!");
							
							// Recalculate repairs:
							application.recalculateRepairs();
						} else {
							WorkbenchUtil.showMessage("Inconsistency-inducing changes could not be undone!");
						}
						
						return;
					}
				}
				
				WorkbenchUtil.showMessage("Please select a repair operation!");
			}
		};
		rollbackInducingChanges.setText("Undo Inconsistency-Inducing Changes");
		rollbackInducingChanges.setToolTipText("Undo Inconsistency-Inducing Changes from Model History");
		rollbackInducingChanges.setImageDescriptor(Activator.getImageDescriptor("icons/rollback_inducing.png"));
		
		// Set parameter value:
		setParameter = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) viewer_repairs.getSelection();
				
				if (selection.getFirstElement() instanceof IParameterInput) {
					IParameterInput valueItem = (IParameterInput) selection.getFirstElement();
					valueItem.setParameterValue();
					
					viewer_repairs.refresh();
					return;
				}
				
				WorkbenchUtil.showMessage("Please select a parameter value!");
			}
			
			@Override
			public boolean isEnabled() {
				IStructuredSelection selection = (IStructuredSelection) viewer_repairs.getSelection();
				
				if (selection.getFirstElement() instanceof IParameterInput) {
					setParameter.setEnabled(true);
				} else {
					setParameter.setEnabled(false);
				}
				
				return super.isEnabled();
			}
		};
		setParameter.setText("Set Parameter");
		setParameter.setToolTipText("Set Parameter");
		setParameter.setImageDescriptor(Activator.getImageDescriptor("icons/parameter_unassigned.gif"));
		
		// Set parameter value:
		unsetParameter = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) viewer_repairs.getSelection();
				
				if (selection.getFirstElement() instanceof ParameterItem) {
					ParameterItem parameterItem = (ParameterItem) selection.getFirstElement();
					parameterItem.unsetParameter();
					
					viewer_repairs.refresh();
					return;
				}
				
				WorkbenchUtil.showMessage("Please select a parameter value!");
			}
			
			@Override
			public boolean isEnabled() {
				IStructuredSelection selection = (IStructuredSelection) viewer_repairs.getSelection();
				
				if (selection.getFirstElement() instanceof ParameterItem) {
					unsetParameter.setEnabled(true);
				} else {
					unsetParameter.setEnabled(false);
				}
				
				return super.isEnabled();
			}
		};
		unsetParameter.setText("Unset Parameter");
		unsetParameter.setToolTipText("Unset Parameter");
		unsetParameter.setImageDescriptor(Activator.getImageDescriptor("icons/parameters.gif"));
		
		// Undo repair:
		undoRepairs = new Action() {
			public void run() {
				
				if (application.undoRepair()) {
					
					// Recalculate repairs:
					application.recalculateRepairs();

					WorkbenchUtil.showMessage("Repair successfully undone!");
				} else {
					WorkbenchUtil.showMessage("Repair could not be undone!");
				}
			}
		};
		undoRepairs.setText("Undo Repair");
		undoRepairs.setToolTipText("Undo Repair");
		undoRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/undo_repair.png"));
		
		// Clear setup:
		clearSetup = new Action() {
			public void run() {
				application.clear();
				clear();
			}
		};
		clearSetup.setText("Clear");
		clearSetup.setToolTipText("Clear");
		clearSetup.setImageDescriptor(Activator.getImageDescriptor("icons/clear.png"));
		
		// Opens the historic model version:
		openHistoricModel = new Action() {
			public void run() {
				try {
					WorkbenchUtil.openEditor(EMFStorage.uriToPath(application.getRepairJob().getRevision().getVersionA().getTargetResource().getURI()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public boolean isEnabled() {
				
				if ((application.getRepairJob() != null) && (application.getRepairJob().getRevision().getVersionA().getTargetResource() != null)) {
					openHistoricModel.setEnabled(true);
				} else {
					openHistoricModel.setEnabled(false);
				}
				
				return super.isEnabled();
			}
		};
		openHistoricModel.setText("Open Historic Model Version");
		openHistoricModel.setToolTipText("Open Historic Model Version");
		openHistoricModel.setImageDescriptor(Activator.getImageDescriptor("icons/history.png"));
		
		// Open configuration:
		openConfiguration = new Action() {
			public void run() {
				PreferenceDialog configurationPage = PreferencesUtil.createPreferenceDialogOn(
						site.getShell(), RepairPreferencePage.ID, null, null);
				
				if (configurationPage != null) {
					configurationPage.open();
				}
			}
		};
		openConfiguration.setText("Configuration");
		openConfiguration.setToolTipText("Open Configuration");
		openConfiguration.setImageDescriptor(Activator.getImageDescriptor("icons/configuration.png"));
	}
	
	@Override
	public void createLocalToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(calculateRepairs);
		manager.add(openHistoricModel);
		manager.add(applyRepairs);
		manager.add(rollbackInducingChanges);
		manager.add(new Separator());
		manager.add(setParameter);
		manager.add(unsetParameter);
		manager.add(new Separator());
		manager.add(undoRepairs);
		manager.add(clearSetup);
		manager.add(openConfiguration);
		manager.add(new Separator());
		
		drillDownAdapter.addNavigationActions(manager);
	}

	@Override
	public void createLocalPullDown(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(calculateRepairs);
		manager.add(openHistoricModel);
		manager.add(applyRepairs);
		manager.add(rollbackInducingChanges);
		manager.add(new Separator());
		manager.add(setParameter);
		manager.add(unsetParameter);
		manager.add(new Separator());
		manager.add(undoRepairs);
		manager.add(clearSetup);
		manager.add(openConfiguration);
		manager.add(new Separator());
	}

	@Override
	public void createContextMenu(IMenuManager manager) {
		
		manager.add(new Separator());
		manager.add(applyRepairs);
		manager.add(setParameter);
		manager.add(unsetParameter);
		manager.add(new Separator());

		drillDownAdapter.addNavigationActions(manager);
	}
	
	@Override
	public void hookContextMenu(MenuManager manager) {
		
		// Hook menu to repair viewer:
		Menu menu = manager.createContextMenu(viewer_repairs.getControl());
		viewer_repairs.getControl().setMenu(menu);
	}
	
	@Override
	public void resultChanged(RepairJob<?> repairJob) {
		
		// NOTE: Unset old comparator:
		// - set input triggers compare -> new data with old comparator
		// - set comparator triggers compare -> new comparator with old data
		viewer_repairs.setComparator(null); 
		viewer_repairs.setInput(repairJob);
		
		viewer_repairs.setComparator(new ViewerComparator() {
			
			@Override
			public int compare(Viewer viewer, Object o1, Object o2) {
				if ((o1 instanceof RepairPlanItem) && (o1 instanceof RepairPlanItem)) {
					return repairJob.getRanking().compare(
							((RepairPlanItem) o1).getRepairPlan(), 
							((RepairPlanItem) o2).getRepairPlan());
				}
				return 0;
			}
		});
		
		refreshActionStates();
	}
	
	@Override
	public ISelectionProvider getSelectionProvider() {
		return viewer_repairs;
	}
	
	@Override
	public void clear() {
		viewer_repairs.setInput(null);
	}
	
	@Override
	public void setFocus() {
		viewer_repairs.getControl().setFocus();
	}

	@Override
	public void dispose() {
		EditorHighlighting.getInstance().deregisterAdapter(highlightingAdapter);
	}
}
