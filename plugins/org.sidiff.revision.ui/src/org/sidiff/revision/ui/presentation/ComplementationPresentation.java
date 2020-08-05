package org.sidiff.revision.ui.presentation;

import org.sidiff.revision.ui.application.ComplementationApplication;

public interface ComplementationPresentation {
	
	ComplementationUI<? extends ComplementationApplication<?,?>> getComplementationPresentation();
}
