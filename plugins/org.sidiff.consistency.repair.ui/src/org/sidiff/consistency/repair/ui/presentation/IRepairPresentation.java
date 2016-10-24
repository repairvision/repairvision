package org.sidiff.consistency.repair.ui.presentation;

import org.eclipse.swt.widgets.Composite;
import org.sidiff.consistency.repair.ui.app.IRepairApplication;
import org.sidiff.consistency.repair.ui.controls.IRepairUI;

public interface IRepairPresentation {
	
	IRepairUI<? extends Composite, ? extends IRepairApplication<?,?>> getRepairPresentation();
}
