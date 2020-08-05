package org.sidiff.revision.ui.viewer.controls.basic;

import org.sidiff.revision.ui.application.ComplementationApplication;
import org.sidiff.revision.ui.presentation.ComplementationUI;

public abstract class BasicComplementationUI<A extends ComplementationApplication<?, ?>> implements ComplementationUI<A> {

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
