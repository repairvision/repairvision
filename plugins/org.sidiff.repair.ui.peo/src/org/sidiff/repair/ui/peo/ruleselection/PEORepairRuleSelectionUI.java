package org.sidiff.repair.ui.peo.ruleselection;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.controls.impl.BasicModelDropRepairUI;
import org.sidiff.repair.ui.controls.impl.ModelDropWidget;
import org.sidiff.repair.validation.ui.provider.RepairTreeContentProvider;
import org.sidiff.repair.validation.ui.provider.RepairTreeLabelProvider;

public class PEORepairRuleSelectionUI extends BasicModelDropRepairUI<SashForm, PEORepairApplication>
		implements IResultChangedListener<PEORepairJob> {

	/**
	 * Shows the abstract repairs.
	 */
	private TreeViewer viewer_validation;

	/**
	 * Drop target to create a rulebase.
	 */
	private ModelDropWidget editRules;
	
	@Override
	public void createPartControls(SashForm parent) {
		
		// Validation-Viewer:
		viewer_validation = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
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

		// Edit-Rules:
		Composite composite_editrules = new Composite(parent, SWT.BORDER);
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
		
		// Create the model input:
		super.createPartControls(parent);

		// Setup Sash-Form:
		parent.setWeights(new int[] {100, 32, 10, 10, 10});
	}
	
	@Override
	public void resultChanged(PEORepairJob repairJob) {
		viewer_validation.setInput(repairJob.getValidations());
	}

	@Override
	public void clear() {
		viewer_validation.setInput(null);
		editRules.clear();
		super.clear();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		application.removeResultChangeListener(this);
	}
}
