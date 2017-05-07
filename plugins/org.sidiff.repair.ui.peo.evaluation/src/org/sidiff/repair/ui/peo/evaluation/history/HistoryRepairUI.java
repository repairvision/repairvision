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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.controls.impl.BasicRepairUI;
import org.sidiff.repair.ui.controls.impl.ModelDropWidget;
import org.sidiff.repair.ui.peo.evaluation.HistoryEvaluation;
import org.sidiff.repair.validation.ui.provider.RepairTreeContentProvider;
import org.sidiff.repair.validation.ui.provider.RepairTreeLabelProvider;

public class HistoryRepairUI extends BasicRepairUI<SashForm, HistoryRepairApplication>
		implements IResultChangedListener<PEORepairJob> {

	/**
	 * Shows the abstract repairs.
	 */
	private TreeViewer viewer_validation;

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
	
	/**
	 * The history resource.
	 */
	private History history;
	
	/**
	 * The selected validation error.
	 */
	private ValidationError validationError;
	
	@Override
	public void createPartControls(SashForm parent) {
		
		// Validation-Viewer:
		Composite composite_viewer_validation = new Composite(parent, SWT.BORDER);
		composite_viewer_validation.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		viewer_validation = new TreeViewer(composite_viewer_validation, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_validation.setContentProvider(new RepairTreeContentProvider());
		viewer_validation.setLabelProvider(new RepairTreeLabelProvider());
//		viewer_validation.setSorter(new NameSorter());
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
		
		application.addResultChangedListener(this);

		// Create history viewer:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
							ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		Composite composite_historyViewer = new Composite(parent, SWT.BORDER);
		composite_historyViewer.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		historyViewer = new TreeViewer(composite_historyViewer, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			historyViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			historyViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			
			historyViewer.addDoubleClickListener(event -> {
				Object selection = ((StructuredSelection) event.getSelection()).getFirstElement();

				if (selection instanceof ValidationError) {
					validationError = (ValidationError) selection;
					Version V_t = validationError.getIntroducedIn();
					
					if (V_t != null) {
						Version V_tminus1 = getPrecessorRevision(V_t);
						
						if (V_tminus1 != null) {
							Version V_resolved = validationError.getResolvedIn();
							
							if (V_resolved != null) {
								Version V_actual = getSuccessorRevision(V_resolved);
								
								new HistoryEvaluation().startEvaluation(getApplication(),
										V_tminus1.getModel(), V_actual.getModel());
							} else {
								WorkbenchUtil.showMessage(
										"There is no version in which the inconsistency has been resolved! "
										+ "The last version in the history will be used as actual model!");
								
								Version V_actual = history.getVersions().get(history.getVersions().size() - 1);
								
								new HistoryEvaluation().startEvaluation(getApplication(),
										V_tminus1.getModel(), V_actual.getModel());
							}
						} else {
							WorkbenchUtil.showError("There is no previous consistent version available!");
						}
					} else {
						WorkbenchUtil.showError("The version in which the inconsistency was introduced is missing!");
					}
				} else {
					WorkbenchUtil.showMessage("Please select a validation error!");
				}
			});
		}
		
		// Create the history input:
		Composite composite_histroyStoreInput = new Composite(parent, SWT.BORDER);
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
					history = (History) rootElement;
					historyViewer.setInput(history);
				}
				
				return element;
			}
		};
		
		// Edit-Rules:
		Composite composite_editRules = new Composite(parent, SWT.BORDER);
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
		parent.setWeights(new int[] {100, 50, 40, 10, 10});
	}
	
	public Version getPrecessorRevision(Version version) {
		int index = history.getVersions().indexOf(version);

		if ((index - 1) >= 0) {
			return history.getVersions().get(index);
		}
		
		return null;
	}

	public Version getSuccessorRevision(Version version) {
		int index = history.getVersions().indexOf(version);

		if ((index + 1) < history.getVersions().size()) {
			return history.getVersions().get(index);
		}
		
		return null;
	}
	
	@Override
	public void resultChanged(PEORepairJob repairJob) {
		viewer_validation.setInput(repairJob.getValidations());
	}

	@Override
	public void clear() {
		viewer_validation.setInput(null);
		
		editRules.clear();
		
		histroyStoreInput.clear();
		historyViewer.setInput(null);
		history = null;
		validationError = null;
	}
	
	@Override
	public void dispose() {
		application.removeResultChangeListener(this);
	}
}
