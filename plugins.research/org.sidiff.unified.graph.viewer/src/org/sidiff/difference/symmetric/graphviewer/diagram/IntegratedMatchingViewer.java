package org.sidiff.difference.symmetric.graphviewer.diagram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.sidiff.difference.symmetric.graphviewer.content.DifferenceImporter;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.history.analysis.util.HistoryAnalysisUtil;
import org.sidiff.history.revision.incremental.IncrementalDifference;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.historymodel.ChangeSet;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.repair.history.editrules.learn.resolved.InconsistencyAnalysis;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.repair.history.evaluation.util.EvaluationUtil;

public class IntegratedMatchingViewer extends ViewPart implements ISelectionProvider {

	public static final String ID = "org.sidiff.difference.symmetric.graphviewer.impl.IntegratedMatchingViewer"; //$NON-NLS-1$

	protected IntegratedMatchingDiagram diagram;
	
	protected TreeViewer treeViewer_history;
	
	protected CheckboxTreeViewer treeViewer_modelA;
	
	protected HistoryState historyStateA = HistoryState.HISTORIC;
	
	protected CheckboxTreeViewer treeViewer_modelB;
	
	protected HistoryState historyStateB = HistoryState.INTRODUCED;
	
	protected CheckboxTreeViewer treeViewer_difference;
	
	protected IncrementalDifference difference;
	
	protected Problem validationError;
	
	protected Object[] selection;
	
	protected Set<ISelectionChangedListener> listeners = new HashSet<>();
	
	protected ExtendedPropertySheetPage propertyPage;
	
	protected static final ISelection emptySelection = new ISelection() {
		
		@Override
		public boolean isEmpty() {
			return true;
		}
	};
	
	private enum HistoryState {
		HISTORIC, INTRODUCED, CURRENT, RESOLVED
	}
	
	public IntegratedMatchingViewer() {
	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		// EMF content and label provider:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		// Drag and Drop support:
		int dndOperations = DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { 
				LocalTransfer.getInstance(), 
				LocalSelectionTransfer.getTransfer(), 
				FileTransfer.getInstance() };
		
		// Controls:
		{
			SashForm sashForm_viewer = new SashForm(parent, SWT.NONE);
			{
				SashForm sashForm_input = new SashForm(sashForm_viewer, SWT.VERTICAL);
				{
					{
						treeViewer_history = new TreeViewer(sashForm_input, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
						treeViewer_history.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
						treeViewer_history.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
						
						treeViewer_history.addDropSupport(dndOperations, transfers, new ViewerDropAdapter(treeViewer_history) {
							
							@Override
							public boolean validateDrop(Object target, int operation, TransferData transferType) {
								return true;
							}
							
							@SuppressWarnings("unchecked")
							@Override
							public boolean performDrop(Object data) {
								
								if (data instanceof StructuredSelection) {
									StructuredSelection selection = (StructuredSelection) data;
									
									selection.iterator().forEachRemaining(element -> {
										if (element instanceof IResource) {
											URI uri = getURI((IResource) element);
											EObject history = EMFStorage.eLoad(uri);
											
											if (history instanceof History) {
												List<Problem> validationErrorTraces = HistoryAnalysisUtil.getAllUniqueValidations((History) history);
												treeViewer_history.setInput(EvaluationUtil.toEObjectList(validationErrorTraces, "Validation Error Traces"));
											}
										}
									});
									return true;
								}
								return false;
							}
						});
						
						treeViewer_history.addSelectionChangedListener(new ISelectionChangedListener() {
							
							@Override
							public void selectionChanged(SelectionChangedEvent event) {
								Object firstSelected = ((StructuredSelection) event.getSelection()).getFirstElement();
								Object[] selected = ((StructuredSelection) event.getSelection()).toArray();
								fireSelection(selected);
								
								if (firstSelected instanceof Problem) {
									setHistoryViewers((Problem) firstSelected);
								}
								
								else if (firstSelected instanceof EObject) {
									setHistoryViewersSelection((EObject) firstSelected);
								}
							}
						});
					}
					{
						treeViewer_difference = new CheckboxTreeViewer(sashForm_input, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
						treeViewer_difference.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
						treeViewer_difference.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
						
						treeViewer_difference.addSelectionChangedListener(new ISelectionChangedListener() {
							
							@Override
							public void selectionChanged(SelectionChangedEvent event) {
								if (event.getSelection() instanceof StructuredSelection) {
									Object[] selected = ((StructuredSelection) event.getSelection()).toArray();
									fireSelection(selected);
								}
							}
						});
						
						treeViewer_difference.addCheckStateListener(new ICheckStateListener() {
							
							@Override
							public void checkStateChanged(CheckStateChangedEvent event) {
								Object selected = event.getElement();
								
								if (selected instanceof Change) {
									updateDifferenceViewers(getUncheckedChanges());
								}
							}
						});
					}
					
				}
				sashForm_input.setWeights(new int[] {30, 70});
			}
			{
				Composite container_diagram = new Composite(sashForm_viewer, SWT.NONE);
				container_diagram.setLayout(new FillLayout(SWT.HORIZONTAL));
				
				diagram = new IntegratedMatchingDiagram();
				diagram.createControls(container_diagram);
			}
			{
				treeViewer_modelA = new CheckboxTreeViewer(sashForm_viewer, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
				treeViewer_modelA.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
				treeViewer_modelA.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
				
				treeViewer_modelA.addSelectionChangedListener(new ISelectionChangedListener() {
					
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						if (event.getSelection() instanceof StructuredSelection) {
							Object[] selected = ((StructuredSelection) event.getSelection()).toArray();
							fireSelection(selected);
						}
					}
				});
				
				treeViewer_modelA.addCheckStateListener(new ICheckStateListener() {
					
					@Override
					public void checkStateChanged(CheckStateChangedEvent event) {
						Object selected = event.getElement();
						
						if (selected instanceof EObject) {
							EObject selectedElement = (EObject) selected;
							
							if (event.getChecked()) {
								selectElementA(selectedElement);
							} else {
								deselectElementA(selectedElement);
							}
						}
					}
				});
			}
			{
				treeViewer_modelB = new CheckboxTreeViewer(sashForm_viewer, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
				treeViewer_modelB.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
				treeViewer_modelB.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
				
				treeViewer_modelB.addSelectionChangedListener(new ISelectionChangedListener() {
					
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						if (event.getSelection() instanceof StructuredSelection) {
							Object[] selected = ((StructuredSelection) event.getSelection()).toArray();
							fireSelection(selected);
						}
					}
				});
				
				treeViewer_modelB.addCheckStateListener(new ICheckStateListener() {
					
					@Override
					public void checkStateChanged(CheckStateChangedEvent event) {
						Object selected = event.getElement();
						
						if (selected instanceof EObject) {
							EObject selectedElement = (EObject) selected;
							
							if (event.getChecked()) {
								selectElementB(selectedElement);
							} else {
								deselectElementB(selectedElement);
							}
						}
					}
				});
			}
			sashForm_viewer.setWeights(new int[] {15, 55, 15, 15});
		}
		
		// Workbench selection provider:
		getViewSite().setSelectionProvider(IntegratedMatchingViewer.this);
		
		// Actions:
		createActions();
		initializeToolBar();
		initializeMenu();
	}
	
	@Override
	public void setSelection(ISelection selection) {
		treeViewer_difference.setSelection(selection);
		treeViewer_history.setSelection(selection);
		treeViewer_modelA.setSelection(selection);
		treeViewer_modelB.setSelection(selection);
	}
	
	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.remove(listener);
	}
	
	@Override
	public ISelection getSelection() {
		if (selection != null) {
			return new StructuredSelection(selection);
		}
		return emptySelection;
	}
	
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getAdapter(Class adapter) {
		
		if (adapter.equals(IPropertySheetPage.class)) {
			if (propertyPage == null) {
				propertyPage = new ExtendedPropertySheetPage(null) {
					
					@Override
					public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
						locateValueAction = new ExtendedPropertySheetPage.LocateValueAction() {
							@Override
							public void run() {
								List<Object> selection = new ArrayList<Object>();
								for (Object object : objectsToSelect) {
									selection.add(object);
								}
								setSelectionToViewer(selection);
							}
						};
						super.makeContributions(menuManager, toolBarManager, statusLineManager);
					}

					@Override
					protected void setSelectionToViewer(List<?> selection) {
						IntegratedMatchingViewer.this.selection = selection.toArray();
						IntegratedMatchingViewer.this.setSelection(new StructuredSelection(selection));
						super.setSelectionToViewer(selection);
					}
				};
				propertyPage.setPropertySourceProvider(new AdapterFactoryContentProvider(
						new ReflectiveItemProviderAdapterFactory()));
			}
			return propertyPage;
		}
		
		return super.getAdapter(adapter);
	}
	
	protected void fireSelection(Object[] obj) {
		this.selection = obj;
		
		if (selection != null) {
			this.listeners.forEach(l -> {
				l.selectionChanged(new SelectionChangedEvent(this, new StructuredSelection(selection)));
			});
		}
	}
	
	private void setHistoryViewersSelection(EObject selected) {
		EObject elementA = ((Resource) treeViewer_modelA.getInput()).getEObject(EcoreUtil.getURI(selected).fragment());
		EObject elementB = ((Resource) treeViewer_modelB.getInput()).getEObject(EcoreUtil.getURI(selected).fragment());

		if (elementA != null) {
			treeViewer_modelA.setSelection(new StructuredSelection(elementA), true);
		}

		if (elementB != null) {
			treeViewer_modelB.setSelection(new StructuredSelection(elementB), true);
		}
	}
	
	private void setHistoryViewers(Problem validationError) {
		this.validationError = validationError; 
		
		InconsistencyTrace validationErrorTrace = InconsistencyTrace
				.createRepairedInconsistency(validationError, false);
		
		Resource resourceA = setHistoryViewer(historyStateA, treeViewer_modelA, validationErrorTrace);
		Resource resourceB = setHistoryViewer(historyStateB, treeViewer_modelB, validationErrorTrace);
		
		treeViewer_modelA.setCheckedElements(new Object[0]);
		treeViewer_modelB.setCheckedElements(new Object[0]);
		
		setDifferenceViewers(resourceA, resourceB);
		
		getScope(historyStateA, validationErrorTrace).forEach(s -> {
			if (s.eResource() == resourceA) {
				selectElementA(s);
			}
		});
		
		getScope(historyStateB, validationErrorTrace).forEach(s -> {
			if (s.eResource() == resourceB) {
				selectElementB(s);
			}
		});
	}
	
	private List<EObject> getScope(HistoryState state, InconsistencyTrace inconsistency) {
		
		switch (state) {
		case INTRODUCED:
			return inconsistency.getProblemInIntroducedModel().getInvalidElements();
		case CURRENT:
			return inconsistency.getProblemCurrentModel().getInvalidElements();
			
		default:
			return Collections.emptyList();
		}
	}
	
	private Resource setHistoryViewer(HistoryState state, CheckboxTreeViewer viewer, InconsistencyTrace inconsistency) {
		
		switch (state) {
		case HISTORIC:
			viewer.setInput(inconsistency.getModelHistorical());
			return inconsistency.getModelHistorical();
		case INTRODUCED:
			viewer.setInput(inconsistency.getModelIntroduced());
			return  inconsistency.getModelIntroduced();
		case CURRENT:
			viewer.setInput(inconsistency.getModelCurrent());
			return  inconsistency.getModelCurrent();
		case RESOLVED:
			viewer.setInput(inconsistency.getModelResolved());
			return  inconsistency.getModelResolved();
			
		default:
			return null;
		}
	}
	
	private void setDifferenceViewers(Resource resourceA, Resource resourceB) {
		difference = new IncrementalDifference(
				(XMIResource) resourceA,
				(XMIResource) resourceB);
		
		updateDifferenceViewers(Collections.emptySet());
	}
	
	private void selectElementA(EObject elementA) {
		treeViewer_modelA.setChecked(elementA, true);
		Set<Change> uncheckedChanges = getUncheckedChanges();
		
		if (difference.selectElementA(elementA)) {
			updateDifferenceViewers(uncheckedChanges);
			setCheckedChanges(uncheckedChanges);
		}
	}
	
	private void selectElementB(EObject elementB) {
		treeViewer_modelB.setChecked(elementB, true);
		Set<Change> uncheckedChanges = getUncheckedChanges();
		
		if (difference.selectElementB(elementB)) {
			updateDifferenceViewers(uncheckedChanges);
			setCheckedChanges(uncheckedChanges);
		}
	}
	
	private void deselectElementA(EObject elementA) {
		treeViewer_modelA.setChecked(elementA, false);
		Set<Change> uncheckedChanges = getUncheckedChanges();
		
		if (difference.deselectElementA(elementA)) {
			updateDifferenceViewers(uncheckedChanges);
			setCheckedChanges(uncheckedChanges);
		}
	}
	
	private void deselectElementB(EObject elementB) {
		treeViewer_modelB.setChecked(elementB, false);
		Set<Change> uncheckedChanges = getUncheckedChanges();
		
		if (difference.deselectElementB(elementB)) {
			updateDifferenceViewers(uncheckedChanges);
			setCheckedChanges(uncheckedChanges);
		}
	}
	
	private void updateDifferenceViewers(Set<Change> changeFilter) {
		
		// Show changes in tree:
		treeViewer_difference.setInput(EvaluationUtil.toEObjectList(difference.getSymmetricDifference().getChanges(), "Changes"));
		
		// Show changes as diagram:
		DifferenceImporter importer = new DifferenceImporter(
				difference.getSymmetricDifference(),
				changeFilter);
		diagram.setInput(importer);
	}
	
	private Set<Change> getUncheckedChanges() {
		Set<Change> uncheckedChanges = new HashSet<>();
		Set<Change> checkedChanges = getCheckedChanges();

		for (Change change : difference.getSymmetricDifference().getChanges()) {
			if (!checkedChanges.contains(change)) {
				uncheckedChanges.add(change);
			}
		}

		return uncheckedChanges;
	}
	
	private Set<Change> getCheckedChanges() {
		Set<Change> checkedChanges = new HashSet<>();
		
		for (Object checked : treeViewer_difference.getCheckedElements()) {
			if (checked instanceof Change) {
				checkedChanges.add((Change) checked);
			}
		}
		
		return checkedChanges;
	}
	
	private void setCheckedChanges(Set<Change> uncheckedChanges) {
		for (Change change : difference.getSymmetricDifference().getChanges()) {
			treeViewer_difference.setChecked(change, !uncheckedChanges.contains(change));
		}
	}
	
	private static URI getURI(IResource workbenchResource) {
		String projectName = workbenchResource.getProject().getName();
		String filePath = workbenchResource.getProjectRelativePath().toOSString();
		String platformPath = projectName + "/" + filePath;

		return URI.createPlatformResourceURI(platformPath, true);
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
		
		// Action: Deselect:
		toolbarManager.add(new Action() {

			@Override
			public String getText() {
				return "Deselect";
			}

			@Override
			public void run() {
				for (Object selected : selection) {
					treeViewer_difference.setChecked(selected, false);
					treeViewer_modelA.setChecked(selected, false);
					treeViewer_modelB.setChecked(selected, false);
				}
				updateDifferenceViewers(getUncheckedChanges());
			}
		});
		
		// Action: Create Change Set
		toolbarManager.add(new Action() {
			
			@Override
			public String getText() {
				return "Create Change Set";
			}
			
			@Override
			public void run() {
				
				// Create change set:
				ChangeSet changeSet = HistoryModelFactory.eINSTANCE.createChangeSet();
				changeSet.setName(historyStateA + "_TO_" + historyStateB);
				
				for (Change change : getCheckedChanges()) {
					changeSet.getChanges().add(SymmetricDifferenceUtil.copyChange(change));
				}
				
				validationError.getModifications().add(changeSet);
				
				// Save history:
				try {
					validationError.eResource().save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// Update view:
				treeViewer_history.refresh();
			}
		});
		
		// Action: Calculate Causing Change Set
		toolbarManager.add(new Action() {
			
			@Override
			public String getText() {
				return "Cause";
			}
			
			@Override
			public void run() {
				
				// Create change set:
//				String changeSetName = historyStateA + "_TO_" + historyStateB;
				String changeSetName = "CAUSE";
				
				InconsistencyAnalysis inconsistencyAnalysis = new InconsistencyAnalysis(validationError);
				List<ChangeSet> introducedChanges = inconsistencyAnalysis.getCausingChanges();
				
				for (ChangeSet changeSet : introducedChanges) {
					changeSet.setName(changeSetName);
				}
				
				validationError.getModifications().addAll(introducedChanges);
				
				// Save history:
//				try {
//					validationError.eResource().save(null);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				
				// Update view:
				treeViewer_history.refresh();
			}
		});
		
		// Action: Calculate Resolving Change Set
		toolbarManager.add(new Action() {
			
			@Override
			public String getText() {
				return "Resolving";
			}
			
			@Override
			public void run() {
				
				// Create change set:
//				String changeSetName = historyStateA + "_TO_" + historyStateB;
				String changeSetName = "REPAIR";
				
				InconsistencyAnalysis inconsistencyAnalysis = new InconsistencyAnalysis(validationError);
				List<ChangeSet> introducedChanges = inconsistencyAnalysis.getResolvedChanges();
				
				for (ChangeSet changeSet : introducedChanges) {
					changeSet.setName(changeSetName);
				}
				
				validationError.getModifications().addAll(introducedChanges);
				
				// Save history:
//				try {
//					validationError.eResource().save(null);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				
				// Update view:
				treeViewer_history.refresh();
			}
		});
		
		// Action: Delete EObject:
		toolbarManager.add(new Action() {

			@Override
			public String getText() {
				return "Delete";
			}

			@Override
			public void run() {
				if (WorkbenchUtil.askQuestion("Delete " + Arrays.toString(selection) + "?")) {
					Set<Resource> changed = new HashSet<>();
					
					for (Object selected : selection) {
						if (selected instanceof EObject) {
							changed.add(((EObject) selected).eResource());
							EcoreUtil.delete((EObject) selected);
						}
					}
					
					for (Resource changedResource : changed) {
						try {
							changedResource.save(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		// Action: Unresolved changes:
		toolbarManager.add(new Action() {

			@Override
			public String getText() {
				return "Outgoing Changes";
			}

			@Override
			public void run() {
				difference.addOutgoingChanges();
				updateDifferenceViewers(getUncheckedChanges());
			}
		});
		
		// Action: Set view historic to introduced:
		toolbarManager.add(new Action() {

			@Override
			public String getText() {
				return "Historic -> Introduced";
			}

			@Override
			public void run() {
				historyStateA = HistoryState.HISTORIC;
				historyStateB = HistoryState.INTRODUCED;
				setHistoryViewers(validationError);
			}
		});
		
		// Action: Set view introduced to resolved:
		toolbarManager.add(new Action() {

			@Override
			public String getText() {
				return "Introduced -> Resolved";
			}

			@Override
			public void run() {
				historyStateA = HistoryState.INTRODUCED;
				historyStateB = HistoryState.RESOLVED;
				setHistoryViewers(validationError);
			}
		});
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
//		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
