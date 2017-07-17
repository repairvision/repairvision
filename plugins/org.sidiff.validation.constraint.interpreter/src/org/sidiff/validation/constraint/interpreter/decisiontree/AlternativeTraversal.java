package org.sidiff.validation.constraint.interpreter.decisiontree;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class AlternativeTraversal implements Iterator<List<? extends IDecisionNode>> {

	private Alternative alternative;
	
	private Iterator<IDecisionNode> directChildren;
	
	private Iterator<List<? extends IDecisionNode>> childIterator;
	
	public AlternativeTraversal(Alternative alternative) {
		this.alternative = alternative;
		this.directChildren = alternative.getChildDecisions().iterator();
		this.childIterator = directChildren.hasNext() ? directChildren.next().traversal() : null;
	}
	
	public Alternative getAlternative() {
		return alternative;
	}

	@Override
	public boolean hasNext() {
		
		while (directChildren.hasNext() && !childIterator.hasNext()) {
			childIterator = directChildren.next().traversal();
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
