package org.sidiff.repair.ui.presentation;

import org.eclipse.swt.widgets.Composite;
import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.controls.IRepairUI;

public interface IRepairPresentation {
	
	IRepairUI<? extends Composite, ? extends IRepairApplication<?,?>> getRepairPresentation();
}
