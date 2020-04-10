package org.sidiff.revision.editrules.recognition.match;

import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;

public abstract class RecognitionNodeMatch extends RecognitionActionMatch {

	private Node node;
	
	public RecognitionNodeMatch(Type action, Node node) {
		super(action);
		this.node = node;
	}
	
	@Override
	public GraphElement getGraphElement() {
		return node;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Type getAction() {
		return action;
	}

	public void setAction(Type action) {
		this.action = action;
	}
}
