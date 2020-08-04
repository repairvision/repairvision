package org.sidiff.revision.impact.changetree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class DecisionBranch implements IDecisionBranch {
	
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
	
	@Override
	public Iterator<? extends IDecisionNode> traversal() {
		List<IDecisionNode> nodes = new ArrayList<>();
		nodes.add(this);
		getDescendants(nodes);
		return nodes.iterator();
	}
	
	private void getDescendants(List<IDecisionNode> nodes) {
		for (IDecisionNode child : children) {
			child.traversal().forEachRemaining(nodes::add);
		}
	}
	
	protected void appendIndent(int indent, StringBuffer print) {
		for (int i = 0; i < indent; i++) {
			print.append(" ");
		}
	}
	
	@Override
	public String toString(int indent) {
		StringBuffer print = new StringBuffer();
		print.append(containerToString(indent));
		
		if (children.size() > 0) {
			print.append("\n");
			print.append(childrenToString(indent + 2));
		}
		
		return print.toString();
	}
	
	public String containerToString(int indent) {
		StringBuffer print = new StringBuffer();
		appendIndent(indent, print);
		print.append(containerToString());
		return print.toString();
	}
	
	public String containerToString() {
		return super.toString();
	}
	
	public String childrenToString(int indent) {
		StringBuffer print = new StringBuffer();
		boolean first = true;
		
		for (IDecisionNode child : children) {
			if (!first) {
				print.append("\n");
			} else {
				first = false;
			}
			print.append(child.toString(indent));
		}
		
		return print.toString();
	}
	
	@Override
	public String toString() {
		return toString(0);
	}
}
