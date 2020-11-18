package org.sidiff.reverseengineering.java;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;

public interface TransformationListener {

	void typeModelTransformed(IResource resource, TransformationTrace trace);
	
	void typeModelRemoved(IResource resource, EObject oldContainer, EObject removedModelElement);
}
