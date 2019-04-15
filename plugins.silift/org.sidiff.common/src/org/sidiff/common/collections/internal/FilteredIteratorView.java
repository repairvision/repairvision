package org.sidiff.common.collections.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.sidiff.common.collections.Selector;

/**
 * A read-only iterator that provides a filtered view onto another iterator.
 */
public class FilteredIteratorView<E> extends ReadOnlyIterator<E> {

	private Iterator<? extends E> iterator = null;
	Selector<E> selector = null;
	boolean include = false;

	private E nextItem = null;

	public FilteredIteratorView(Iterator<? extends E> iterator, Selector<E> selector, boolean include) {
		this.iterator = iterator;
		this.selector = selector;
		this.include = include;
		proceed();
	}

	@Override
	public boolean hasNext() {
		return this.nextItem != null;
	}

	@Override
	public E next() {
		E result = null;
		if (this.nextItem != null) {
			result = this.nextItem;
			proceed();
		} else {
			throw new NoSuchElementException();
		}
		return result;
	}

	private void proceed() {
		while (this.iterator.hasNext()) {
			E item = this.iterator.next();
			if (this.selector.select(item) == this.include) {
				this.nextItem = item;
				return;
			}
		}
		this.nextItem = null;
	}
}