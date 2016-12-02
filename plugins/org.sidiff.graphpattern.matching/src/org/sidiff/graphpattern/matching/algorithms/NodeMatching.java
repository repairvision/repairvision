package org.sidiff.graphpattern.matching.algorithms;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.matching.INodeMatching;

public class NodeMatching implements INodeMatching {
	
	protected NodePattern node;
	
	protected EObject match = null;
	
	private Iterator<EObject> matchIterator = Collections.emptyIterator();

	public NodeMatching(NodePattern node) {
		super();
		this.node = node;
	}

	public NodePattern getNode() {
		return node;
	}

	protected void setNode(NodePattern node) {
		this.node = node;
	}

	public EObject getMatch() {
		return match;
	}
	
	protected void setMatch(EObject match) {
		assert !isBound();
		this.match = match;
		matchIterator = Collections.emptyIterator();
	}
	
	protected boolean isBound() {
		return (match != null);
	}
	
	protected boolean hasNextMatch() {
		return matchIterator.hasNext();
	}
	
	protected boolean setNextMatch() {
		
		if (matchIterator.hasNext()) {
			match = matchIterator.next();
			return true;
		} else {
			return false;
		}
	}

	protected void setMatchIterator(Iterator<EObject> matchIterator) {
		this.matchIterator = matchIterator;
	}
	
	protected void resetMatching() {
		this.match = null;
		this.matchIterator = Collections.emptyIterator();
	}
	
	@Override
	public String toString() {
		return "Node-Matching" + ": " + node.toString() + "\n    Match: " + (((match != null) ? match.toString() : "null") + "\n");
	}
}
