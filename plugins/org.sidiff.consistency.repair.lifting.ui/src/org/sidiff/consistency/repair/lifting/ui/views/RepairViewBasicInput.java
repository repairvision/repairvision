package org.sidiff.consistency.repair.lifting.ui.views;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class RepairViewBasicInput implements IInputControl {

	private ModelDropWidget modelA;
	
	private ModelDropWidget modelB;
	
	public void createInputPartControl(Composite parent, RepairViewBasicApp app) {
		
		// Model A:
		Composite composite_modelA = new Composite(parent, SWT.BORDER);
		composite_modelA.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		modelA = new ModelDropWidget(composite_modelA, "Please drop the previous model version here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return app.removeModelA(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				removeModel(app.modelAFile);
				return app.addModelA(element);
			}
		};

		// Model B:
		Composite composite_modelB = new Composite(parent, SWT.BORDER);
		composite_modelB.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		modelB = new ModelDropWidget(composite_modelB, "Please drop the actual model version here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return app.removeModelB(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				removeModel(app.modelBFile);
				return app.addModelB(element);
			}
		};
	}

	@Override
	public void clear() {
		modelA.clear();
		modelB.clear();
	}
}
