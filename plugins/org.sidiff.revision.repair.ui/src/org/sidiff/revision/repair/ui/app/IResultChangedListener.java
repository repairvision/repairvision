package org.sidiff.revision.repair.ui.app;

import org.sidiff.revision.api.ComplementationJob;

public interface IResultChangedListener<J extends ComplementationJob<?>> {

	void resultChanged(J repairJob);
}
