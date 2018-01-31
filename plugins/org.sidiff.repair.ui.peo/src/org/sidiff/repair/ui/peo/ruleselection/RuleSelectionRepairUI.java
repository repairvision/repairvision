package org.sidiff.repair.ui.peo.ruleselection;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
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
import org.sidiff.repair.validation.ui.widgets.ValidationWidget;
import org.sidiff.validation.constraint.api.util.Validation;

public class RuleSelectionRepairUI extends BasicRepairViewerUI<RuleSelectionRepairApplication> {

	/**
	 * Shows the abstract repairs.
	 */
	private ValidationWidget validationWidget;

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
						application.calculateRepairProposals();
					}
				} else {
					// Ignore other selections:
					validationWidget.getViewer().setChecked(event.getElement(), false);
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
		validationWidget.setInput(application.getValidations());
	}

	@Override
	public void clear() {
		super.clear();
		validationWidget.clear();
		editRules.clear();
		modelVersions.clear();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		validationWidget.dispose();
	}
}
