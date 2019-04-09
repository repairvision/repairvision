package org.sidiff.repair.ui.controls.basic;

import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.controls.IRepairUI;

public abstract class BasicRepairUI<A extends IRepairApplication<?, ?>> implements IRepairUI<A> {

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
