package org.sidiff.repair.ui.cpo.ruleselection;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.repair.ui.controls.impl.BasicModelDropRepairUI;
import org.sidiff.repair.ui.controls.impl.ModelDropWidget;

public class CPORepairRuleSelectionUI extends BasicModelDropRepairUI<SashForm, CPORepairApplication> {

	private ModelDropWidget cpEditRules;
	
	private ModelDropWidget subEditRules;
	
	public CPORepairRuleSelectionUI() {
		super();
	}

	@Override
	public void createPartControls(SashForm parent) {
		
		// Consistency-Preserving-Edit-Rules:
		Composite composite_supereditrules = new Composite(parent, SWT.BORDER);
		composite_supereditrules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		cpEditRules = new ModelDropWidget(composite_supereditrules, "Please drop the consistency-preserving-edit-rule(s) here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.removeCPEditRule(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				return application.addCPEditRule(element);
			}
		};
		
		// Sub-Edit-Rules:
		Composite composite_subeditrules = new Composite(parent, SWT.BORDER);
		composite_subeditrules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		subEditRules = new ModelDropWidget(composite_subeditrules, "Please drop the sub-edit-rule(s) here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.removeSubEditRule(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				return application.addSubEditRule(element);
			}
		};
		
		// Create the model input:
		super.createPartControls(parent);

		// Setup Sash-Form:
		parent.setWeights(new int[] {100, 10, 10, 10, 10});
	}

	@Override
	public void clear() {
		cpEditRules.clear();
		subEditRules.clear();
		super.clear();
	}
}
