package org.sidiff.revision.repair.ui.presentation;

import org.sidiff.revision.repair.ui.app.IRepairApplication;
import org.sidiff.revision.repair.ui.controls.IRepairUI;

public interface IRepairPresentation {
	
	IRepairUI<? extends IRepairApplication<?,?>> getRepairPresentation();
}
