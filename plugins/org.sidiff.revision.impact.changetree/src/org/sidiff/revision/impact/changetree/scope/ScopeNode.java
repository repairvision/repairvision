package org.sidiff.revision.impact.changetree.scope;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;
import org.sidiff.revision.impact.changetree.IDecisionNode;

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
	
	public void addReference(EObject source, EObject target, EReference type) {
		scope.addReference(source, target, type);
	}
	
	public void addAttribute(EObject object, Object value, EAttribute type) {
		scope.addAttribute(object, value, type);
	}
	
	public void addEqualityTest(EObject object, Object value, EAttribute type) {
		scope.addEqualityTest(object, value, type);
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
	
	@Override
	public Iterator<? extends IDecisionNode> traversal() {
		return JUtil.singeltonIterator(this);
	}

	@Override
	public Iterator<List<? extends IDecisionNode>> combinations() {
		List<? extends IDecisionNode> leafSingleton = Collections.singletonList(this);
		List<List<? extends IDecisionNode>> leafIterable = Collections.singletonList(leafSingleton);
		return leafIterable.iterator();
	}
	
	@Override
	public String toString(int indent) {
		return scope.toString(indent);
	}
	
	@Override
	public String toString() {
		return scope.toString();
	}

	@Override
	public IDecisionNode deepCopy() {
		ScopeNode copy = new ScopeNode();
		copy.getScope().getScope().addAll(scope.getScope());
		return copy;
	}
}
