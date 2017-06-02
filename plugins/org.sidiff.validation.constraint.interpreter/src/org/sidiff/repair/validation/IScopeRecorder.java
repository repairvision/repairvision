package org.sidiff.repair.validation;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public interface IScopeRecorder {

	void addElement(Object modelElement);
	
	Set<EObject> getScope();
}
