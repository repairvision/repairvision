package org.sidiff.revision.repair.ui.peo.integrated;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.repair.ui.controls.basic.BasicRepairViewerUI;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.ui.widgets.ValidationWidget;

public class IntegratedRepairUI extends BasicRepairViewerUI<IntegratedRepairApplication> {

	/**
	 * Shows the abstract repairs.
	 */
	private ValidationWidget validationWidget;

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
		
		validationWidget.getViewer().addCheckStateListener(new ICheckStateListener() {
			
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				
				if (event.getElement() instanceof Validation) {
					
					// Clear selection:
					validationWidget.getViewer().setCheckedElements(new Object[0]);
					
					// Start repair calculation:
					if (event.getChecked()) {
						validationWidget.getViewer().setChecked(event.getElement(), event.getChecked());
						
						// Get inconsistency that should be repaired:
						Validation inconsistency = (Validation) event.getElement();
						application.setInconsistency(inconsistency);
						
						// Search for repairs:
						application.calculateRepairs();
					}
				} else {
					// Ignore other selections:
					validationWidget.getViewer().setChecked(event.getElement(), false);
				}
			}
		});

		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 32});
	}

	@Override
	public void resultChanged(ComplementationJob<?> repairJob) {
		assert (repairJob == application.getRepairJob());

		super.resultChanged(repairJob);
		validationWidget.setInput(application.getValidations());
	}

	@Override
	public void clear() {
		super.clear();
		validationWidget.clear();
	}

	@Override
	public void dispose() {
		super.dispose();
		validationWidget.dispose();
	}
}
