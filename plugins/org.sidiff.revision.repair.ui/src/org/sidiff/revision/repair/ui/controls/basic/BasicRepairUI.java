package org.sidiff.revision.repair.ui.controls.basic;

import org.sidiff.revision.repair.ui.app.IRepairApplication;
import org.sidiff.revision.repair.ui.controls.IRepairUI;

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
