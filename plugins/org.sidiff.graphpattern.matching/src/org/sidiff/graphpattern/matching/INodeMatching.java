package org.sidiff.graphpattern.matching;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;

/**
 * Stores the match of {@link NodePattern}.
 * 
 * @author Manuel Ohrndorf
 */
public interface INodeMatching {

	/**
	 * @return The corresponding node.
	 */
	public NodePattern getNode();

	/**
	 * @return The matched object.
	 */
	public EObject getMatch();
}
