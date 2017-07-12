package org.sidiff.validation.constraint.interpreter.scope;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionLeaf;

public class ScopeNode implements IDecisionLeaf {

	private ScopeRecorder scope = new ScopeRecorder();
	
	public static ScopeNode getScopeNode(IDecisionBranch parent) {
		
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
	
	public ScopeRecorder getScope() {
		return scope;
	}

	@Override
	public int compareTo(IDecisionLeaf leaf) {
		
		if (leaf instanceof ScopeNode) {
			ScopeNode otherScope = (ScopeNode) leaf;
			
			if (this.getScope().getScope().equals(otherScope.getScope().getScope())) {
				return 0;
			}
		}
		
		return this.toString().compareTo(leaf.toString());
	}
}
