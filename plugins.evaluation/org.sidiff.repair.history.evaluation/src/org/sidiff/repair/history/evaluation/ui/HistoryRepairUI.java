package org.sidiff.repair.history.evaluation.ui;

import org.eclipse.core.resources.IResource;
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
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.history.evaluation.Activator;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.ui.controls.basic.BasicRepairViewerUI;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;
import org.sidiff.repair.validation.ui.widgets.ValidationWidget;

public class HistoryRepairUI extends BasicRepairViewerUI<HistoryRepairApplication> {

	/**
	 * Shows the abstract repairs.
	 */
	private ValidationWidget validationWidget;
	
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
	private TreeViewer historyInconsistenciesViewer;
	
	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		
		// Sash-Form:
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		// Repair viewer:
		super.createPartControls(sashForm, site);
		
		// Validation-Viewer:
		validationWidget = new ValidationWidget();
		validationWidget.createControls(sashForm);

		// Create history viewer:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
							ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		Composite composite_historyViewer = new Composite(sashForm, SWT.BORDER);
		composite_historyViewer.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		historyInconsistenciesViewer = new TreeViewer(composite_historyViewer, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		{
			historyInconsistenciesViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			historyInconsistenciesViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			
			historyInconsistenciesViewer.addDoubleClickListener(event -> {
				Object selection = ((StructuredSelection) event.getSelection()).getFirstElement();

				if (selection instanceof ValidationError) {
					getApplication().repairInconsistency((ValidationError) selection);
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
				
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource historyResource = resourceSet.getResource(ModelDropWidget.getURI(element), true);
				
				if (historyResource.getContents().get(0) instanceof History) {
					History history = (History) historyResource.getContents().get(0);
					
					getApplication().setHistory(history);
					historyInconsistenciesViewer.setInput(getApplication().getValidations());
					
					// Set models for matching settings...
					if (history.getVersions().size() > 1) {
						getApplication().populateSettings(
								history.getVersions().get(0).getModel(),
								history.getVersions().get(1).getModel());
					}
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
		
		// Edit-Rule Recorder //
		
		Action recordEditRule = new Action() {
			@Override
			public void run() {
				ISelection selection = historyInconsistenciesViewer.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					for (Object selected : ((IStructuredSelection) selection).toList()) {
						if (selected instanceof ValidationError) {
							getApplication().learnEditRule((ValidationError) selected);
						}
					}
				}
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
		validationWidget.setInput(application.getRepairJob().getValidations());
	}

	@Override
	public void clear() {
		super.clear();
		
		// Clear Application:
		getApplication().clear();
		
		// Clear UI:
		validationWidget.clear();
		editRules.clear();
		histroyStoreInput.clear();
		
		historyInconsistenciesViewer.setInput(null);
	}
	
	@Override
	public void dispose() {
		validationWidget.dispose();
	}
}
