package org.sidiff.validation.constraint.interpreter.decisiontree;

import java.util.LinkedList;
import java.util.List;

public class DecisionNode implements IDecisionNode {
	
	protected List<IDecisionNode> children = new LinkedList<>();

	@Override
	public void appendChildDecisions(IDecisionNode... children) {
		for (IDecisionNode child : children) {
			this.children.add(child);
		}
	}
	
	@Override
	public void removeChildDecision(IDecisionNode child) {
		children.remove(child);
	}

	@Override
	public List<IDecisionNode> getChildDecisions() {
		return children;
	}
	
	public String toString(int indent) {
		StringBuffer print = new StringBuffer();
		
		// This Container:
		appendIndent(indent, print);
		print.append(containerToString() + "\n");
		
		// Repairs:
		for (IDecisionNode child : children) {
			if (!(child instanceof DecisionNode)) {
				appendIndent(indent + 2, print);
				print.append(child + "\n");
			}
		}
		
		// Container:
		for (IDecisionNode child : children) {
			if (child instanceof DecisionNode) {
				print.append(((DecisionNode) child).toString(indent + 2));
			}
		}
		
		return print.toString();
	}
	
	private void appendIndent(int indent, StringBuffer print) {
		for (int i = 0; i < indent; i++) {
			print.append(" ");
		}
	}
	
	public String containerToString() {
		return super.toString();
	}
	
	public String childrenToString() {
		StringBuffer print = new StringBuffer();
		
		// Repairs:
		for (IDecisionNode child : children) {
			if (!(child instanceof DecisionNode)) {
				print.append("  " + child + "\n");
			}
		}
		
		// Container:
		for (IDecisionNode child : children) {
			if (child instanceof DecisionNode) {
				print.append(((DecisionNode) child).toString(2));
			}
		}
		
		return print.toString();
	}
}
