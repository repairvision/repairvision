package org.sidiff.graphpattern.profile;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public interface IGraphPatternVisualization {

	/**
	 * Gradient color:
	 */
	enum Gradient {
		FROM, TO
	};

	/**
	 * @param node
	 *            A node of a graph pattern (with stereotypes).
	 * @param gradient
	 *            The kind of the gradient color.
	 * @return The background color of the node.
	 */
	int[] getNodeBackgroundColor(NodePattern node, Gradient gradient);

	/**
	 * @param element
	 *            A node of a graph pattern (with stereotypes).
	 * @return The frame color of the node.
	 */
	int[] getNodeFrameColor(NodePattern node);

	/**
	 * @param element
	 *            A node of a graph pattern (with stereotypes).
	 * @return The label color of the node.
	 */
	int[] getNodeLabelColor(NodePattern node);

	/**
	 * @param element
	 *            A edge of a graph pattern (with stereotypes).
	 * @return The line color of the edge.
	 */
	int[] getEdgeLineColor(EdgePattern edge);

	/**
	 * @param element
	 *            A edge of a graph pattern (with stereotypes).
	 * @return The label color of the edge.
	 */
	int[] getEdgeLabelColor(EdgePattern edge);
}
