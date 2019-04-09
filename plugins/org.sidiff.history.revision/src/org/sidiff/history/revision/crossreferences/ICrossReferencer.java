package org.sidiff.history.revision.crossreferences;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

public interface ICrossReferencer {

	Iterator<? extends EObject> getInverse(EObject target, EReference incoming);
	
	void addResource(Resource resource);

}