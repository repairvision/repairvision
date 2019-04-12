package org.sidiff.difference.symmetric.graphviewer.content;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.graph.Edge;

import javafx.scene.paint.Color;

public abstract class MatchingEdge extends MatchingGraphElement {

	protected Edge graphEdge;
	
	protected MatchingEdge opposite;
	
	public MatchingEdge(MatchingNode source, MatchingNode target) {
		super();
		this.graphEdge = new Edge(source.getGraphNode(), target.getGraphNode());
		this.graphEdge.getAttributes().put(MatchingGraphElement.ATTRIBUTE_CONTENT, this);
	}

	public Edge getGraphEdge() {
		return graphEdge;
	}
	
	public void setGraphEdge(Edge graphEdge) {
		this.graphEdge = graphEdge;
	}
	
	public MatchingNode getSource() {
		return (MatchingNode) getGraphEdge().getSource().getAttributes().get(MatchingGraphElement.ATTRIBUTE_CONTENT);
	}
	
	public MatchingNode getTarget() {
		return (MatchingNode) getGraphEdge().getTarget().getAttributes().get(MatchingGraphElement.ATTRIBUTE_CONTENT);
	}
	
	public MatchingEdge getOpposite() {
		return opposite;
	}
	
	public void setOpposite(MatchingEdge opposite) {
		this.opposite = opposite;
	}
	
	/**
	 * @return All types represented by this edge.
	 */
	public abstract List<EReference> getTypes();

	/**
	 * @param type
	 *            A reference type.
	 * @return All source objects of the matched references with the given type.
	 */
	public abstract List<EObject> getReferences(EReference type);
	
	@Override
	public Color getTextColor() {
		return new Color(0.0, 0.0, 0.0, 0.6);
	}
	
	@Override
	public Color getBorderColor() {
		return new Color(0.0, 0.0, 0.0, 0.3);
	}
	
	@Override
	public Color getBackgroundColor() {
		return new Color(1.0, 1.0, 1.0, 0.0);
	}
	
	public Color getDecorationColor() {
		return new Color(0.0, 0.0, 0.0, 0.6);
	}
}
