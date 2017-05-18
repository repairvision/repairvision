package org.sidiff.repair.ui.cpo.ruleselection;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.sidiff.repair.ui.controls.basic.BasicRepairViewerUI;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;
import org.sidiff.repair.ui.controls.basic.ModelVersionsDropWidget;

public class CPORepairRuleSelectionUI extends BasicRepairViewerUI<CPORepairApplication> {

	private ModelVersionsDropWidget modelVersions;
	
	private ModelDropWidget cpEditRules;
	
	private ModelDropWidget subEditRules;
	
	public CPORepairRuleSelectionUI() {
		super();
	}

	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		
		// Sash-Form:
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		// Repair viewer:
		super.createPartControls(sashForm, site);
		
		// Consistency-Preserving-Edit-Rules:
		Composite composite_supereditrules = new Composite(sashForm, SWT.BORDER);
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
		Composite composite_subeditrules = new Composite(sashForm, SWT.BORDER);
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
		
		// Model version input:
		modelVersions = new ModelVersionsDropWidget(getApplication());
		modelVersions.createModelAControls(sashForm);
		modelVersions.createModelBControls(sashForm);

		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 10, 10, 10, 10});
	}

	@Override
	public void clear() {
		super.clear();
		cpEditRules.clear();
		subEditRules.clear();
	}
}
