package org.sidiff.common.emf.adapters;

import org.eclipse.emf.ecore.EObject;

/**
 * Adapter that holds an index of all model elements inside a resource.
 * The adapter is assigned to a Resource.
 * @author wenzel
 *
 */
public interface ElementByIDAdapter extends SiDiffAdapter {
	
	public EObject getElement(String id);

}
