package org.sidiff.repair.ui.peo.evaluation.history;

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
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.ui.controls.basic.BasicRepairViewerUI;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;
import org.sidiff.repair.ui.peo.evaluation.Activator;
import org.sidiff.repair.ui.peo.evaluation.HistoryEvaluationApplication;
import org.sidiff.repair.validation.ui.widgets.ValidationWidget;

public class HistoryRepairUI extends BasicRepairViewerUI<HistoryEvaluationApplication> {

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
	private TreeViewer historyViewer;
	
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
		
		historyViewer = new TreeViewer(composite_historyViewer, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			historyViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			historyViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			
			historyViewer.addDoubleClickListener(event -> {
				Object selection = ((StructuredSelection) event.getSelection()).getFirstElement();

				if (selection instanceof ValidationError) {
					getApplication().selectInconsistency((ValidationError) selection);
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
					History history = (History) rootElement;
					
					getApplication().setHistory(history);
					historyViewer.setInput(getApplication().getValidations());
					
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
				getApplication().learnEditRule();
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
		
		// Clear Application:
		getApplication().clear();
		
		// Clear UI:
		validationWidget.clear();
		editRules.clear();
		histroyStoreInput.clear();
		
		historyViewer.setInput(null);
	}
	
	@Override
	public void dispose() {
		validationWidget.dispose();
	}
}
