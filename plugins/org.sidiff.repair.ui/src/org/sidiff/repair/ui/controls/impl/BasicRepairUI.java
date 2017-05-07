package org.sidiff.repair.ui.controls.impl;

import org.eclipse.swt.widgets.Composite;
import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.controls.IRepairUI;

public abstract class BasicRepairUI<C extends Composite, A extends IRepairApplication<?, ?>> implements IRepairUI<C, A> {

	protected A application;
	
	@Override
	public void initialize(A application) {
		this.application = application;
	}
	
	@Override
	public A getApplication() {
		return application;
	}
}
