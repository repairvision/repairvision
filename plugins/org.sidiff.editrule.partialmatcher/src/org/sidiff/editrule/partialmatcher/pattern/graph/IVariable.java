package org.sidiff.editrule.partialmatcher.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.Change;

public interface IVariable {

	Iterator<? extends EObject> getDomain();

	/**
	 * @param change
	 *            The selected change.
	 */
	void searchPaths(Change change);
}
