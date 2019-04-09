package org.sidiff.repair.ui.app;

import org.sidiff.repair.api.RepairJob;

public interface IResultChangedListener<J extends RepairJob<?>> {

	void resultChanged(J repairJob);
}
