package org.sidiff.consistency.repair.lifting.ui.views.cpo;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.consistency.repair.lifting.ui.views.IInputControl;
import org.sidiff.consistency.repair.lifting.ui.views.ModelDropWidget;
import org.sidiff.consistency.repair.lifting.ui.views.RepairViewBasicInput;

public class CPORepairView implements IInputControl {

	private ModelDropWidget cpEditRules;
	
	private ModelDropWidget subEditRules;
	
	private RepairViewBasicInput models;
	
	public void createInputPartControl(SashForm sashForm, RepairViewCPOApp app) {
		
		// Consistency-Preserving-Edit-Rules:
		Composite composite_supereditrules = new Composite(sashForm, SWT.BORDER);
		composite_supereditrules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		cpEditRules = new ModelDropWidget(composite_supereditrules, "Please drop the consistency-preserving-edit-rule(s) here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return app.removeCPEditRule(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				return app.addCPEditRule(element);
			}
		};
		
		// Sub-Edit-Rules:
		Composite composite_subeditrules = new Composite(sashForm, SWT.BORDER);
		composite_subeditrules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		subEditRules = new ModelDropWidget(composite_subeditrules, "Please drop the sub-edit-rule(s) here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return app.removeSubEditRule(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				return app.addSubEditRule(element);
			}
		};
		
		// Create the model input:
		models = new RepairViewBasicInput();
		models.createInputPartControl(sashForm, app);

		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 10, 10, 10, 10});
	}

	@Override
	public void clear() {
		cpEditRules.clear();
		subEditRules.clear();
		models.clear();
	} 
}
