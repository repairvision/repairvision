package org.sidiff.repair.ui.decoration;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;

public interface ISelectionAdapter {
	
	/**
	 * @param selection
	 *            The actual selection to highlight.
	 * @return A model element iterator or <code>null</code>.
	 */
	Iterator<EObject> getElements(ISelection selection);
	
}
