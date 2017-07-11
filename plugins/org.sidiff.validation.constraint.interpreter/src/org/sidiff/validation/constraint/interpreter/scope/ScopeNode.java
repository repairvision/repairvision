package org.sidiff.validation.constraint.interpreter.scope;

import java.util.List;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;

public class ScopeNode implements IDecisionNode {

	private ScopeRecorder scope = new ScopeRecorder();
	
	public static ScopeNode getScopeNode(IDecisionNode parent) {
		
		// Check for existing scope node:
		if (parent.getChildDecisions().size() == 1) {
			if (parent.getChildDecisions().get(0) instanceof ScopeNode) {
				return (ScopeNode) parent.getChildDecisions().get(0);
			}
		}

		// New scope node:
		ScopeNode newScopeNode = new ScopeNode();
		parent.appendChildDecisions(newScopeNode);
		return newScopeNode;
	}
	
	public void addElement(Object element) {
		scope.addElement(element);
	}
	
	@Override
	public void appendChildDecisions(IDecisionNode... children) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeChildDecision(IDecisionNode child) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<IDecisionNode> getChildDecisions() {
		throw new UnsupportedOperationException();
	}
}
