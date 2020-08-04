package org.sidiff.revision.impact.changetree.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.Sequence;

public class SequenceCombinations implements Iterator<List<? extends IDecisionNode>> {

	private Sequence sequence;
	
	private ListIterator<IDecisionNode> directChildren;
	
	private Stack<Iterator<List<? extends IDecisionNode>>> childIterator = new Stack<>();
	
	private Stack<List<? extends IDecisionNode>> previous;
	
	private Stack<List<? extends IDecisionNode>> next;
	
	public SequenceCombinations(Sequence sequence) {
		this.sequence = sequence;
		this.directChildren = sequence.getChildDecisions().listIterator();
		
		// Calculate first decision:
		this.next = new Stack<>();
		completeNextDecision();
	}
	
	private void completeNextDecision() {
		
		this.directChildren.forEachRemaining(child -> {
			Iterator<List<? extends IDecisionNode>> childTraversal = child.combinations();
			this.childIterator.push(childTraversal);
			
			if (childTraversal.hasNext()) {
				next.add(childTraversal.next());
			} else {
				next.add(Collections.emptyList());
			}
		});
	}
	
	public Sequence getSequence() {
		return sequence;
	}

	@Override
	public boolean hasNext() {
		
		if (next == null) {
			
			next = previous;
			previous = null;
			
			// Backtracking:
			while (!childIterator.isEmpty() && !childIterator.peek().hasNext()) {
				childIterator.pop();
				next.pop();
				
				assert directChildren.hasPrevious();
				directChildren.previous();
			}
			
			// Search next decision:
			if (!childIterator.isEmpty()) {
				
				// Initialize next decision:
				assert childIterator.peek().hasNext();
				
				next.pop();
				next.add(childIterator.peek().next());
				
				// Complete next decision:
				completeNextDecision();
			} else {
				next = null;
			}
		}
		
		return (next != null);
	}

	@Override
	public List<? extends IDecisionNode> next() {
		
		if (hasNext()) {
			List<IDecisionNode> flatNext = new ArrayList<>();
			next.forEach(flatNext::addAll);
			
			previous = next;
			next = null;
			
			return flatNext;
		} else {
			throw new NoSuchElementException();
		}
	}
}
