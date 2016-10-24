package org.sidiff.consistency.repair.ui.app;

import org.sidiff.consistency.repair.api.RepairJob;

public interface IResultChangedListener<J extends RepairJob<?>> {

	void resultChanged(J repairJob);
}
