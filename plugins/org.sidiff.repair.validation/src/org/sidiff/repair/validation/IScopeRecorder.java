package org.sidiff.repair.validation;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public interface IScopeRecorder {

	void addElement(Object modelElement);
	
	void addElement(Collection<Object> elements);
	
	Set<EObject> getScope();
}
