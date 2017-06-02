package org.sidiff.repair.ui.controls.basic;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.consistency.common.ui.widgets.IUnsetableControl;
import org.sidiff.repair.ui.app.impl.EclipseResourceRepairApplication;

public class ModelVersionsDropWidget implements IUnsetableControl {
	
	protected EclipseResourceRepairApplication<?, ?> application;
	
	protected ModelDropWidget modelA;
	
	protected ModelDropWidget modelB;
	
	public ModelVersionsDropWidget(EclipseResourceRepairApplication<?, ?> application) {
		this.application = application;
	}
	
	public void createModelAControls(Composite parent) {
		
		// Model A:
		Composite composite_modelA = new Composite(parent, SWT.BORDER);
		composite_modelA.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		modelA = new ModelDropWidget(composite_modelA, "Please drop the previous model version here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.unsetModelA(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				removeModel(application.getModelAFile());
				return application.setModelA(element);
			}
		};
	}
	
	public void createModelBControls(Composite parent) {
		
		// Model B:
		Composite composite_modelB = new Composite(parent, SWT.BORDER);
		composite_modelB.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		modelB = new ModelDropWidget(composite_modelB, "Please drop the actual model version here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.unsetModelB(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				removeModel(application.getModelBFile());
				return application.setModelB(element);
			}
		};
	}
	
	@Override
	public void clear() {
		modelA.clear();
		modelB.clear();
	}
}
