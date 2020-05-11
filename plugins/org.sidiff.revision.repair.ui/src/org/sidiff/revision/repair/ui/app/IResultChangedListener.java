package org.sidiff.revision.repair.ui.app;

import org.sidiff.revision.repair.api.RepairJob;

public interface IResultChangedListener<J extends RepairJob<?>> {

	void resultChanged(J repairJob);
}
