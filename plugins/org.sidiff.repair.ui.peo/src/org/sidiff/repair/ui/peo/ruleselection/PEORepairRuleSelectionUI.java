package org.sidiff.repair.ui.peo.ruleselection;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.controls.basic.BasicRepairViewerUI;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;
import org.sidiff.repair.ui.controls.basic.ModelVersionsDropWidget;
import org.sidiff.repair.validation.ui.provider.RepairTreeContentProvider;
import org.sidiff.repair.validation.ui.provider.RepairTreeLabelProvider;

public class PEORepairRuleSelectionUI extends BasicRepairViewerUI<PEORepairApplication> {

	/**
	 * Shows the abstract repairs.
	 */
	private TreeViewer viewer_validation;

	/**
	 * Drop target to create a rulebase.
	 */
	private ModelDropWidget editRules;
	
	/**
	 * Drop target for the model versions
	 */
	private ModelVersionsDropWidget modelVersions;
	
	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		
		// Sash-Form:
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		// Repair viewer:
		super.createPartControls(sashForm, site);
		
		// Validation-Viewer:
		viewer_validation = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
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

		// Edit-Rules:
		Composite composite_editrules = new Composite(sashForm, SWT.BORDER);
		composite_editrules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		editRules = new ModelDropWidget(composite_editrules, "Please drop the edit-rule(s) here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.removeEditRule(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				return application.addEditRule(element);
			}
		};
		
		// Model version input:
		modelVersions = new ModelVersionsDropWidget(getApplication());
		modelVersions.createModelAControls(sashForm);
		modelVersions.createModelBControls(sashForm);

		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 32, 10, 10, 10});
	}
	
	@Override
	public void resultChanged(RepairJob<?> repairJob) {
		assert (repairJob  == application.getRepairJob());
		
		super.resultChanged(repairJob);
		viewer_validation.setInput(application.getRepairJob().getValidations());
	}

	@Override
	public void clear() {
		super.clear();
		viewer_validation.setInput(null);
		editRules.clear();
		modelVersions.clear();
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
}
