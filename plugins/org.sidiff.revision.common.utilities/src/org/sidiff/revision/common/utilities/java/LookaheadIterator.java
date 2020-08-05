package org.sidiff.revision.common.utilities.java;

import java.util.Iterator;

public class LookaheadIterator<T> implements Iterator<T> {

	private Iterator<T> iterator;
	
	private T next;
	
	private boolean isCached = false;
	
	public LookaheadIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}
	
	public T lookahead() {
		if (!isCached) {
			next = next();
			isCached = true;
		}
		return next;
	}

	@Override
	public boolean hasNext() {
		return isCached || iterator.hasNext();
	}

	@Override
	public T next() {
		if (!isCached) {
			return iterator.next();
		} else {
			isCached = false;
			next = null;
			return next;
		}
	}
}
