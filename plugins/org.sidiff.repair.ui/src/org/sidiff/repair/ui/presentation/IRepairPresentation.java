package org.sidiff.repair.ui.presentation;

import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.controls.IRepairUI;

public interface IRepairPresentation {
	
	IRepairUI<? extends IRepairApplication<?,?>> getRepairPresentation();
}
