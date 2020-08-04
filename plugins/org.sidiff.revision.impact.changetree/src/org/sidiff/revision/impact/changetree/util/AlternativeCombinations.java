package org.sidiff.revision.impact.changetree.util;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionNode;

public class AlternativeCombinations implements Iterator<List<? extends IDecisionNode>> {

	private Alternative alternative;
	
	private Iterator<IDecisionNode> directChildren;
	
	private Iterator<List<? extends IDecisionNode>> childIterator;
	
	public AlternativeCombinations(Alternative alternative) {
		this.alternative = alternative;
		this.directChildren = alternative.getChildDecisions().iterator();
		this.childIterator = directChildren.hasNext() ? directChildren.next().combinations() : null;
	}
	
	public Alternative getAlternative() {
		return alternative;
	}

	@Override
	public boolean hasNext() {
		
		while (directChildren.hasNext() && !childIterator.hasNext()) {
			childIterator = directChildren.next().combinations();
		}
		
		return directChildren.hasNext() || ((childIterator != null) && childIterator.hasNext());
	}

	@Override
	public List<? extends IDecisionNode> next() {
		
		if (hasNext()) {
			return childIterator.next();
		} else {
			throw new NoSuchElementException();
		}
	}
}
