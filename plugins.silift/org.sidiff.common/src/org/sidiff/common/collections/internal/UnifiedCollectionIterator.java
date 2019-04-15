package org.sidiff.common.collections.internal;

import java.util.*;

/**
 * Provides a single iterator that provides a unified view onto multiple iterators.
 * They are traversed one after another.
 */
class UnifiedCollectionIterator<E> extends ReadOnlyIterator<E> {

	private List<Iterator<? extends E>> iterators = null;

	public UnifiedCollectionIterator(Collection<? extends Collection<? extends E>> collections) {
		this.iterators = new ArrayList<Iterator<? extends E>>(collections.size());
		for (Collection<? extends E> c : collections) {
			this.iterators.add(c.iterator());
		}
	}

	@Override
	public boolean hasNext() {
		if (iterators.isEmpty()) {
			return false;
		} else if (iterators.get(0).hasNext()) {
			return true;
		} else {
			iterators.remove(0);
			return hasNext();
		}
	}

	@Override
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		} else {
			return iterators.get(0).next();
		}
	}

}