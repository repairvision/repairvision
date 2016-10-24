package org.sidiff.consistency.repair.ui.controls.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.consistency.repair.ui.app.impl.BasicRepairApplication;
import org.sidiff.consistency.repair.ui.controls.IRepairUI;

public class BasicRepairUI<C extends Composite, A extends BasicRepairApplication<?, ?>> implements IRepairUI<C, A> {

	protected A application;
	
	protected ModelDropWidget modelA;
	
	protected ModelDropWidget modelB;
	
	@Override
	public void initialize(A application) {
		this.application = application;
	}
	
	@Override
	public A getApplication() {
		return application;
	}
	
	@Override
	public void createPartControls(C parent) {
		
		// Model A:
		Composite composite_modelA = new Composite(parent, SWT.BORDER);
		composite_modelA.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		modelA = new ModelDropWidget(composite_modelA, "Please drop the previous model version here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.removeModelA(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				removeModel(application.getModelAFile());
				return application.addModelA(element);
			}
		};

		// Model B:
		Composite composite_modelB = new Composite(parent, SWT.BORDER);
		composite_modelB.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		modelB = new ModelDropWidget(composite_modelB, "Please drop the actual model version here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.removeModelB(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				removeModel(application.getModelBFile());
				return application.addModelB(element);
			}
		};
	}

	@Override
	public void clear() {
		modelA.clear();
		modelB.clear();
	}

	@Override
	public void dispose() {
	}
}
