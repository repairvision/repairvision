package org.sidiff.consistency.graphpattern.matcher.matching;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;

/**
 * A simple matching container interface.
 * 
 * @author Manuel Ohrndorf
 */
public interface IMatching {

	/**
	 * @param node
	 *            A node of a matched graph pattern.
	 * @return The corresponding matched object.
	 */
	public Iterator<EObject> getMatch(NodePattern node);
	
	public EObject getFirstMatch(NodePattern node);
	
	public Collection<NodePattern> getNodes();
}
