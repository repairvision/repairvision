package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;

public abstract class EditRuleNodeMatch extends EditRuleMatch {

	private Node node;
	
	public EditRuleNodeMatch(Type action, Node node) {
		super(action);
		this.node = node;
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
