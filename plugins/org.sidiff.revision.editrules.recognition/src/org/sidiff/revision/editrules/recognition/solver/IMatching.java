package org.sidiff.revision.editrules.recognition.solver;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;

/**
 * A matching container interface.
 * 
 * @author Manuel Ohrndorf
 */
public interface IMatching {

	/**
	 * @param node
	 *            A node of a matched graph pattern.
	 * @return The corresponding matched object.
	 */
	Iterator<EObject> getMatch(NodePattern node);

	/**
	 * @param node
	 *            A node of a matched graph pattern.
	 * @return The first corresponding matched object or <code>null</code>.
	 */
	EObject getFirstMatch(NodePattern node);

	/**
	 * @return All nodes of the matched graph pattern.
	 */
	Collection<NodePattern> getNodes();

	/**
	 * @return <code>true</code> if not all nodes of the graph pattern are matched;
	 *         <code>false</code> otherwise.
	 */
	boolean isPartialMatching();
}
