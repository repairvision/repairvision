package org.sidiff.consistency.repair.lifting.ui.views.partial;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.consistency.repair.lifting.ui.views.ModelDropWidget;
import org.sidiff.consistency.repair.lifting.ui.views.RepairViewBasicInput;
import org.sidiff.consistency.repair.validation.ui.provider.RepairTreeContentProvider;
import org.sidiff.consistency.repair.validation.ui.provider.RepairTreeLabelProvider;

public class PartialEORepairView {

	public static TreeViewer createInputPartControl(SashForm sashForm, RepairViewPartialEOApp app) {
		
		// Validation-Viewer:
		TreeViewer viewer_validation = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
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
		
		new ModelDropWidget(composite_editrules, "Please drop the edit-rule(s) here!") {

			@Override
			protected boolean removeModel(IResource selection) {
				return app.removeEditRule(selection);
			}

			@Override
			protected boolean addModel(IResource element) {
				return app.addEditRule(element);
			}
		};
		
		// Create the model input:
		RepairViewBasicInput.createInputPartControl(sashForm, app);

		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 32, 10, 10, 10});
		
		return viewer_validation;
	}
}
