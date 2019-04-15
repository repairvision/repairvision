package org.sidiff.common.emf.access;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Interface that can be implemented by clients that one or several model
 * elements that can be highlighted on diagrams.
 * 
 * @author kehrer
 */
public interface HighlightableElement {

	public List<EObject> getElements();
}
