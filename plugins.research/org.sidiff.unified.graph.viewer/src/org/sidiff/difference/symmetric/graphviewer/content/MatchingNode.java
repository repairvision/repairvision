package org.sidiff.difference.symmetric.graphviewer.content;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.graph.Node;

public abstract class MatchingNode extends MatchingGraphElement {

	protected Node graphNode;
	
	public MatchingNode() {
		super();
		this.graphNode = new Node();
		this.graphNode.getAttributes().put(MatchingGraphElement.ATTRIBUTE_CONTENT, this);
	}

	public Node getGraphNode() {
		return graphNode;
	}
	
	public void setGraphNode(Node graphNode) {
		this.graphNode = graphNode;
	}
	
	public abstract EClass getType();
	
	public abstract List<EObject> getElements();
	
	public abstract int getElementCount();
	
	public abstract EObject getRepresentativeElement();
}
