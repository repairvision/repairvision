package org.sidiff.graphpattern.profile;

import org.sidiff.graphpattern.NodePattern;

public interface IGraphPatternVisualization {

	/**
	 * @param node
	 *            A node of a graph pattern (with stereotypes).
	 * @return The background color of the node.
	 */
	int[] getBackgroundColor(NodePattern node);
}
