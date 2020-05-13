package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;

public interface IVariable {

	Iterator<? extends EObject> getDomain();

	/**
	 * Starts a new search.
	 * 
	 * @param path
	 *            The currently searched path.
	 * @param change
	 *            The selected change.
	 */
	void searchPaths(MatchingPath path, Change change);
}
