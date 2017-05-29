package org.sidiff.repair.validation;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public class ScopeRecorderDummy implements IScopeRecorder {

	@Override
	public void addElement(Object modelElement) {
		// Ignored...
	}

	@Override
	public Set<EObject> getScope() {
		return Collections.emptySet();
	}
}
