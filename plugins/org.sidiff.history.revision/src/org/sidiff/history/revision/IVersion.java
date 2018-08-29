package org.sidiff.history.revision;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

public interface IVersion {

	Set<Resource> getResources();
	
	Resource getTargetResource();
	
	Iterator<? extends EObject> getTarget(EObject source, EReference outgoing);
	
	Iterator<? extends EObject> getSource(EObject target, EReference incoming);
	
}
