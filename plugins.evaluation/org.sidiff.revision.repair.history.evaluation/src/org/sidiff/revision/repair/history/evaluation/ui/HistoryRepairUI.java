package org.sidiff.revision.repair.history.evaluation.ui;

import java.io.FileNotFoundException;
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
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.ui.editors.highlighting.EditorHighlighting;
import org.sidiff.revision.ui.editors.highlighting.ISelectionHighlightingAdapter;
import org.sidiff.revision.ui.viewer.controls.basic.BasicComplementationViewerUI;
import org.sidiff.revision.ui.viewer.controls.basic.dnd.ModelDropWidget;
import org.sidiff.validation.constraint.interpreter.ui.widgets.ValidationWidget;

public class HistoryRepairUI extends BasicComplementationViewerUI<HistoryRepairApplication> {

	/**
	 * Shows the abstract repairs.
	 */
	protected ValidationWidget validationWidget;
	
	/**
	 * Drop target to create a rulebase.
	 */
	protected ModelDropWidget editRules;
	
	/**
	 * Drop target for the model history.
	 */
	protected ModelDropWidget histroyStoreInput;
	
	/**
	 * Shows all differences.
	 */
	protected TreeViewer historyInconsistenciesViewer;
	
	/**
	 * Editor decoration.
	 */
	protected ISelectionHighlightingAdapter historyInconsistenciesViewerDecorationAdapter;
	
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

				if (selection instanceof Problem) {
					clearResults();
					Problem validationError = (Problem) selection;
					getApplication().repairInconsistency(validationError);
					
					try {
						InconsistencyTrace repaired = InconsistencyTrace.createRepairedInconsistency(validationError, true);
						
						if (repaired != null) {
							WorkbenchUtil.openEditor(EMFStorage.uriToPath(repaired.getModelHistorical().getURI()));
							WorkbenchUtil.openEditor(EMFStorage.uriToPath(repaired.getModelIntroduced().getURI()));
							WorkbenchUtil.openEditor(EMFStorage.uriToPath(repaired.getModelCurrent().getURI()));
							WorkbenchUtil.openEditor(EMFStorage.uriToPath(repaired.getModelResolved().getURI()));
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} else {
					WorkbenchUtil.showMessage("Please select a validation error!");
				}
			});
		}
		
		// Setup history viewer highlighting:
		historyInconsistenciesViewerDecorationAdapter = new ISelectionHighlightingAdapter() {
			
			@Override
			public Iterator<EObject> getElements(ISelection selection) {
				
				if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
					Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
					
					if (selectedElement instanceof EObject) {
						return Collections.singletonList((EObject) selectedElement).iterator();
					}
				}
				
				return null;
			}
		};
		EditorHighlighting.getInstance().registerAdapter(historyInconsistenciesViewerDecorationAdapter);
		historyInconsistenciesViewer.addSelectionChangedListener(EditorHighlighting.getInstance().getSelectionChangedListener());
		
		// Create the history input:
		Composite composite_histroyStoreInput = new Composite(sashForm, SWT.BORDER);
		composite_histroyStoreInput.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		histroyStoreInput = new ModelDropWidget(composite_histroyStoreInput, "Please drop the model history here!") {
			
			@Override
			protected IResource removeModel(IResource selection) {
				HistoryRepairUI.this.clearCalculation();
				return selection;
			}
			
			@Override
			protected IResource addModel(IResource element) {
				HistoryRepairUI.this.clearCalculation();
				
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource historyResource = resourceSet.getResource(WorkbenchUtil.getURI(element), true);
				
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
	public void resultChanged(ComplementationJob<?> repairJob) {
		assert (repairJob  == application.getComplementationJob());
		
		super.resultChanged(repairJob);
		validationWidget.setInput(application.getComplementationJob().getValidations());
	}
	
	public void clearResults() {
		validationWidget.clear();
		viewer_complementations.setInput(null);
	}

	@Override
	public void clear() {
		super.clear();
		
		// Clear calculation:
		getApplication().clear();	// (!)
		
		// Clear UI:
		validationWidget.clear();
		histroyStoreInput.clear();
		editRules.clear();			// (!)
		
		historyInconsistenciesViewer.setInput(null);
	}
	
	public void clearCalculation() {
		super.clear();
		
		// Clear Application:
		getApplication().clearCalculation();
		
		// Clear UI:
		validationWidget.clear();
		histroyStoreInput.clear();
		
		historyInconsistenciesViewer.setInput(null);
	}
	
	@Override
	public void dispose() {
		validationWidget.dispose();
		EditorHighlighting.getInstance().deregisterAdapter(historyInconsistenciesViewerDecorationAdapter);
	}
}
