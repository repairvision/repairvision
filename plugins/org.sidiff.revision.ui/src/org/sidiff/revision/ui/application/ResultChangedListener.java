package org.sidiff.revision.ui.application;

import org.sidiff.revision.api.ComplementationJob;

public interface ResultChangedListener<J extends ComplementationJob<?>> {

	void resultChanged(J complementationJob);
}
