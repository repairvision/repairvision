package org.sidiff.revision.ui.viewer.controls.basic;

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
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.ui.application.ComplementationApplication;
import org.sidiff.revision.ui.configuration.page.ComplementationPreferencePage;
import org.sidiff.revision.ui.editors.highlighting.EditorHighlighting;
import org.sidiff.revision.ui.editors.highlighting.ISelectionHighlightingAdapter;
import org.sidiff.revision.ui.viewer.Activator;
import org.sidiff.revision.ui.viewer.provider.IHighlightableElement;
import org.sidiff.revision.ui.viewer.provider.ComplementationContentProvider;
import org.sidiff.revision.ui.viewer.provider.ComplementationLabelProvider;
import org.sidiff.revision.ui.viewer.provider.model.IParameterInput;
import org.sidiff.revision.ui.viewer.provider.model.ParameterItem;
import org.sidiff.revision.ui.viewer.provider.model.ComplementationPlanItem;

public class BasicComplementationViewerUI<A extends ComplementationApplication<?, ?>> extends BasicComplementationUI<A> {

	protected TreeViewer viewer_complementations;
	
	protected ISelectionHighlightingAdapter highlightingAdapter;
	
	private DrillDownAdapter drillDownAdapter;
	
	protected Action openConfiguration;
	
	protected Action calculateComplementations;
	
	protected Action rollbackInducingChanges;
	
	protected Action setParameter;
	
	protected Action unsetParameter;
	
	protected Action applyComplementation;
	
	protected Action undoComplementation;
	
	protected Action clearSetup;
	
	protected Action openHistoricModel;
	
	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		createComplementationViewer(parent, site);
		makeActions(site);
	}
	
	protected void createComplementationViewer(Composite parent, IWorkbenchPartSite site) {
		
		// Complementation-Viewer:
		viewer_complementations = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_complementations.setContentProvider(new ComplementationContentProvider());
		viewer_complementations.setLabelProvider(new ComplementationLabelProvider());

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
		viewer_complementations.addSelectionChangedListener(
				EditorHighlighting.getInstance().getSelectionChangedListener());
		
		// Workbench selection:
		site.setSelectionProvider(viewer_complementations);
		
		// Expand / Collapse on double click:
		viewer_complementations.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();

			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection).getFirstElement();

				if (item == null) {
					return;
				}
				
				try {
					if (viewer_complementations.getExpandedState(item)) {

						// Collapse:
						viewer_complementations.collapseToLevel(item, TreeViewer.ALL_LEVELS);
					} else {
						
						// Expand:
						if (item instanceof ComplementationPlanItem) {
							viewer_complementations.expandToLevel(item, 3);
						} else {
							viewer_complementations.expandToLevel(item, 1);
						}
					}
				} catch (Exception e) {
				}
			}
		});
		
		// Enable/Disable actions:
		viewer_complementations.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				refreshActionStates();
			}
		});
	}
	
	protected void refreshActionStates() {
		openConfiguration.isEnabled();
		calculateComplementations.isEnabled();
		applyComplementation.isEnabled();
		undoComplementation.isEnabled();
		clearSetup.isEnabled();
		setParameter.isEnabled();
		unsetParameter.isEnabled();
		openHistoricModel.isEnabled();
	}
	
	protected void makeActions(IWorkbenchPartSite site) {
		
		this.drillDownAdapter = new DrillDownAdapter(viewer_complementations);

		// Calculate complementations:
		calculateComplementations = new Action() {
			public void run() {
				application.validation();
			}
		};
		calculateComplementations.setText("Validate Model");
		calculateComplementations.setToolTipText("Validate Model");
		calculateComplementations.setImageDescriptor(Activator.getImageDescriptor("icons/bulb.png"));
		
		// Apply complementations:
		applyComplementation = new Action() {

			public void run() {
				ISelection selection = viewer_complementations.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					Object selected = ((IStructuredSelection) selection).getFirstElement();

					if (selected instanceof ComplementationPlanItem) {
						ComplementationPlan complementationPlan = ((ComplementationPlanItem) selected).getComplementationPlan();
						List<Match> matches = complementationPlan.getComplementMatches();
						
						if (matches.size() == 1) {
							if (application.applyComplementation(complementationPlan, matches.get(0))) {
								WorkbenchUtil.showMessage("Complementation successfully applied!");
								
								// Recalculate complementations:
								application.recalculateComplementations();
							} else {
								WorkbenchUtil.showMessage("Complementation could not be applied!");
							}
						} else {
							WorkbenchUtil.showMessage("Please specify all parameters!");
						}
						
						return;
					}
				}
				
				WorkbenchUtil.showMessage("Please select a complementation operation!");
			}
			
			@Override
			public boolean isEnabled() {
				IStructuredSelection selection = (IStructuredSelection) viewer_complementations.getSelection();
				
				if (selection.getFirstElement() instanceof ComplementationPlanItem) {
					applyComplementation.setEnabled(true);
				} else {
					applyComplementation.setEnabled(false);
				}
				
				return super.isEnabled();
			}
		};
		applyComplementation.setText("Apply Complementation");
		applyComplementation.setToolTipText("Apply Complementation");
		applyComplementation.setImageDescriptor(Activator.getImageDescriptor("icons/apply.png"));
		
		// Undo complementation:
		rollbackInducingChanges = new Action() {
			public void run() {
				
				ISelection selection = viewer_complementations.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					Object selected = ((IStructuredSelection) selection).getFirstElement();

					if (selected instanceof ComplementationPlanItem) {
						ComplementationPlan complementation = ((ComplementationPlanItem) selected).getComplementationPlan();
						
						if (application.rollbackIncomplete(complementation)) {
							WorkbenchUtil.showMessage("Inconsistency-inducing changes successfully undone!");
							
							// Recalculate complementations:
							application.recalculateComplementations();
						} else {
							WorkbenchUtil.showMessage("Inconsistency-inducing changes could not be undone!");
						}
						
						return;
					}
				}
				
				WorkbenchUtil.showMessage("Please select a complementation operation!");
			}
		};
		rollbackInducingChanges.setText("Undo Inconsistency-Inducing Changes");
		rollbackInducingChanges.setToolTipText("Undo Inconsistency-Inducing Changes from Model History");
		rollbackInducingChanges.setImageDescriptor(Activator.getImageDescriptor("icons/rollback_incomplete.png"));
		
		// Set parameter value:
		setParameter = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) viewer_complementations.getSelection();
				
				if (selection.getFirstElement() instanceof IParameterInput) {
					IParameterInput valueItem = (IParameterInput) selection.getFirstElement();
					valueItem.setParameterValue();
					
					viewer_complementations.refresh();
					return;
				}
				
				WorkbenchUtil.showMessage("Please select a parameter value!");
			}
			
			@Override
			public boolean isEnabled() {
				IStructuredSelection selection = (IStructuredSelection) viewer_complementations.getSelection();
				
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
				IStructuredSelection selection = (IStructuredSelection) viewer_complementations.getSelection();
				
				if (selection.getFirstElement() instanceof ParameterItem) {
					ParameterItem parameterItem = (ParameterItem) selection.getFirstElement();
					parameterItem.unsetParameter();
					
					viewer_complementations.refresh();
					return;
				}
				
				WorkbenchUtil.showMessage("Please select a parameter value!");
			}
			
			@Override
			public boolean isEnabled() {
				IStructuredSelection selection = (IStructuredSelection) viewer_complementations.getSelection();
				
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
		
		// Undo complementation:
		undoComplementation = new Action() {
			public void run() {
				
				if (application.undoComplementation()) {
					
					// Recalculate complementations:
					application.recalculateComplementations();

					WorkbenchUtil.showMessage("Complementation successfully undone!");
				} else {
					WorkbenchUtil.showMessage("Complementation could not be undone!");
				}
			}
		};
		undoComplementation.setText("Undo Complementation");
		undoComplementation.setToolTipText("Undo Complementation");
		undoComplementation.setImageDescriptor(Activator.getImageDescriptor("icons/undo.png"));
		
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
					WorkbenchUtil.openEditor(EMFStorage.uriToPath(application.getComplementationJob().getRevision().getVersionA().getTargetResource().getURI()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public boolean isEnabled() {
				
				if ((application.getComplementationJob() != null) && (application.getComplementationJob().getRevision().getVersionA().getTargetResource() != null)) {
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
						site.getShell(), ComplementationPreferencePage.ID, null, null);
				
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
		manager.add(calculateComplementations);
		manager.add(openHistoricModel);
		manager.add(applyComplementation);
		manager.add(rollbackInducingChanges);
		manager.add(new Separator());
		manager.add(setParameter);
		manager.add(unsetParameter);
		manager.add(new Separator());
		manager.add(undoComplementation);
		manager.add(clearSetup);
		manager.add(openConfiguration);
		manager.add(new Separator());
		
		drillDownAdapter.addNavigationActions(manager);
	}

	@Override
	public void createLocalPullDown(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(calculateComplementations);
		manager.add(openHistoricModel);
		manager.add(applyComplementation);
		manager.add(rollbackInducingChanges);
		manager.add(new Separator());
		manager.add(setParameter);
		manager.add(unsetParameter);
		manager.add(new Separator());
		manager.add(undoComplementation);
		manager.add(clearSetup);
		manager.add(openConfiguration);
		manager.add(new Separator());
	}

	@Override
	public void createContextMenu(IMenuManager manager) {
		
		manager.add(new Separator());
		manager.add(applyComplementation);
		manager.add(setParameter);
		manager.add(unsetParameter);
		manager.add(new Separator());

		drillDownAdapter.addNavigationActions(manager);
	}
	
	@Override
	public void hookContextMenu(MenuManager manager) {
		
		// Hook menu to complementation viewer:
		Menu menu = manager.createContextMenu(viewer_complementations.getControl());
		viewer_complementations.getControl().setMenu(menu);
	}
	
	@Override
	public void resultChanged(ComplementationJob<?> complementationJob) {
		
		// NOTE: Unset old comparator:
		// - set input triggers compare -> new data with old comparator
		// - set comparator triggers compare -> new comparator with old data
		viewer_complementations.setComparator(null); 
		viewer_complementations.setInput(complementationJob);
		
		viewer_complementations.setComparator(new ViewerComparator() {
			
			@Override
			public int compare(Viewer viewer, Object o1, Object o2) {
				if ((o1 instanceof ComplementationPlanItem) && (o1 instanceof ComplementationPlanItem)) {
					return complementationJob.getRanking().compare(
							((ComplementationPlanItem) o1).getComplementationPlan(), 
							((ComplementationPlanItem) o2).getComplementationPlan());
				}
				return 0;
			}
		});
		
		refreshActionStates();
	}
	
	@Override
	public ISelectionProvider getSelectionProvider() {
		return viewer_complementations;
	}
	
	@Override
	public void clear() {
		viewer_complementations.setInput(null);
	}
	
	@Override
	public void setFocus() {
		viewer_complementations.getControl().setFocus();
	}

	@Override
	public void dispose() {
		EditorHighlighting.getInstance().deregisterAdapter(highlightingAdapter);
	}
}
