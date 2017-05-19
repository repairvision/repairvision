package org.sidiff.repair.ui.peo.evaluation.history;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.ui.controls.basic.BasicRepairViewerUI;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;
import org.sidiff.repair.ui.decoration.ISelectionAdapter;
import org.sidiff.repair.ui.decoration.RepairSelectionController;
import org.sidiff.repair.ui.decoration.SelectionAdapterRegistry;
import org.sidiff.repair.ui.peo.evaluation.Activator;
import org.sidiff.repair.ui.peo.evaluation.HistoryEvaluationApplication;
import org.sidiff.repair.validation.fix.RepairAction;
import org.sidiff.repair.validation.ui.provider.RepairTreeContentProvider;
import org.sidiff.repair.validation.ui.provider.RepairTreeLabelProvider;
import org.sidiff.repair.validation.util.Validation;

public class HistoryRepairUI extends BasicRepairViewerUI<HistoryEvaluationApplication> {

	/**
	 * Shows the abstract repairs.
	 */
	private TreeViewer viewer_validation;

	// TODO: Generalize this!
	private ISelectionAdapter decorationAdapter;
	
	/**
	 * Drop target to create a rulebase.
	 */
	private ModelDropWidget editRules;
	
	/**
	 * Drop target for the model history.
	 */
	private ModelDropWidget histroyStoreInput;
	
	/**
	 * Shows all differences.
	 */
	private TreeViewer historyViewer;
	
	
	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		
		// Sash-Form:
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		// Repair viewer:
		super.createPartControls(sashForm, site);
		
		// Validation-Viewer:
		Composite composite_viewer_validation = new Composite(sashForm, SWT.BORDER);
		composite_viewer_validation.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		viewer_validation = new TreeViewer(composite_viewer_validation, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_validation.setContentProvider(new RepairTreeContentProvider());
		viewer_validation.setLabelProvider(new RepairTreeLabelProvider());
//		viewer_validation.setSorter(new NameSorter());
		
		viewer_validation.addSelectionChangedListener(RepairSelectionController.getInstance());
		
		decorationAdapter = new ISelectionAdapter() {
			
			@Override
			public Iterator<EObject> getElements(ISelection selection) {
				
				if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
					Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
					
					if (selectedElement instanceof Validation) {
						Validation validation = (Validation) selectedElement;
						return Collections.singletonList(validation.getContext()).iterator();
					}
					
					else if (selectedElement instanceof RepairAction) {
						RepairAction repair = (RepairAction) selectedElement;
						return Collections.singletonList(repair.getContext()).iterator();
					}
				}
				
				return null;
			}
		};
		SelectionAdapterRegistry.registerAdapter(decorationAdapter);
		
		viewer_validation.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();

			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection).getFirstElement();

				if (item == null) {
					return;
				}
				if (viewer_validation.getExpandedState(item)) {
					viewer_validation.collapseToLevel(item, 1);
				}
				else {
					viewer_validation.expandToLevel(item, 1);
				}
			}
		});

		// Create history viewer:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
							ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		Composite composite_historyViewer = new Composite(sashForm, SWT.BORDER);
		composite_historyViewer.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		historyViewer = new TreeViewer(composite_historyViewer, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			historyViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			historyViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			
			historyViewer.addDoubleClickListener(event -> {
				Object selection = ((StructuredSelection) event.getSelection()).getFirstElement();

				if (selection instanceof ValidationError) {
					getApplication().selectValidationError((ValidationError) selection);
					getApplication().startEvaluationForInconsistency();
				} else {
					WorkbenchUtil.showMessage("Please select a validation error!");
				}
			});
		}
		
		// Create the history input:
		Composite composite_histroyStoreInput = new Composite(sashForm, SWT.BORDER);
		composite_histroyStoreInput.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		histroyStoreInput = new ModelDropWidget(composite_histroyStoreInput, "Please drop the model history here!") {
			
			@Override
			protected IResource removeModel(IResource selection) {
				HistoryRepairUI.this.clear();
				return selection;
			}
			
			@Override
			protected IResource addModel(IResource element) {
				HistoryRepairUI.this.clear();
				
				ResourceSet historyRSS  = new ResourceSetImpl();
				Resource historyResource = historyRSS.getResource(ModelDropWidget.getURI(element), true);
				EObject rootElement = historyResource.getContents().get(0);
				
				if (rootElement instanceof History) {
					getApplication().setHistory((History) rootElement);
					historyViewer.setInput(getApplication().getValidations());
				}
				
				return element;
			}
		};
		
		// Edit-Rules:
		Composite composite_editRules = new Composite(sashForm, SWT.BORDER);
		composite_editRules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		editRules = new ModelDropWidget(composite_editRules, "Please drop the edit-rule(s) here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.removeEditRule(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				return application.addEditRule(element);
			}
		};
		
		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 50, 40, 10, 10});
	}
	
	@Override
	public void createLocalToolBar(IToolBarManager manager) {
		super.createLocalToolBar(manager);
		
		Action recordEditRule = new Action() {
			@Override
			public void run() {
				System.out.println("HistoryRepairUI.createLocalToolBar(...).new Action() {...}.run()");
			}
		};
		
		recordEditRule.setText("Learn Edit-Rule");
		recordEditRule.setToolTipText("Learn Edit-Rule");
		recordEditRule.setImageDescriptor(Activator.getImageDescriptor("icons/cat-icon.png"));
		
		manager.add(new Separator());
		manager.add(recordEditRule);
		manager.add(new Separator());
	}
	
	@Override
	public void resultChanged(RepairJob<?> repairJob) {
		assert (repairJob  == application.getRepairJob());
		
		super.resultChanged(repairJob);
		viewer_validation.setInput(application.getRepairJob().getValidations());
	}

	@Override
	public void clear() {
		
		// Clear Application:
		getApplication().clear();
		
		// Clear UI:
		viewer_validation.setInput(null);
		editRules.clear();
		histroyStoreInput.clear();
		historyViewer.setInput(null);
	}
	
	@Override
	public void dispose() {
		SelectionAdapterRegistry.deregisterAdapter(decorationAdapter);
	}
}
