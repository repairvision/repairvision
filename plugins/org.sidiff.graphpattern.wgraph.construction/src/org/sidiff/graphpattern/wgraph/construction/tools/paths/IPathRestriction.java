package org.sidiff.graphpattern.wgraph.construction.tools.paths;

import org.sidiff.graphpattern.EdgePattern;

public interface IPathRestriction {

	/**
	 * Restricts the traversal from the source node over the given outgoing edge.
	 * 
	 * @param edge
	 *            The outgoing edge.
	 * @return <code>true</code> if the traversal is restricted;
	 *         <code>false</code> otherwise
	 */
	public boolean isRestrictedOutgoing(EdgePattern edge);

	/**
	 * Restricts the traversal from the target node over the given incoming edge.
	 * 
	 * @param edge
	 *            The outgoing edge.
	 * @return <code>true</code> if the traversal is restricted;
	 *         <code>false</code> otherwise
	 */
	public boolean isRestrictedIncoming(EdgePattern edge);
}
