package org.sidiff.common.collections.internal;

import java.util.*;

/**
 * Provides a single list iterator that provides a unified view onto multiple list iterators.
 * They are traversed one after another.
 */
class UnifiedListIterator<E> extends UnifiedCollectionIterator<E> implements ListIterator<E> {

	private int superIndex = 0;
	private int thisIndex = 0;
	private List<E> baseList = null;

	public UnifiedListIterator(List<E> base, Collection<? extends Collection<? extends E>> collections) {
		super(collections);
		this.baseList = base;
	}

	public UnifiedListIterator(List<E> base, Collection<? extends Collection<? extends E>> collections, int i) {
		super(collections);
		this.baseList = base;
		superIndex = i;
		for (int j = 0; i < superIndex; j++)
			super.next();
		thisIndex = i;
	}

	@Override
	public void add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPrevious() {
		return thisIndex > 0;
	}

	@Override
	public int nextIndex() {
		return thisIndex + 1;
	}

	@Override
	public E previous() {
		thisIndex--;
		return this.baseList.get(thisIndex);
	}

	@Override
	public int previousIndex() {
		return thisIndex - 1;
	}

	@Override
	public void set(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {
		if (superIndex == thisIndex) {
			return super.hasNext();
		} else {
			return thisIndex < baseList.size();
		}
	}

	@Override
	public E next() {
		if (superIndex == thisIndex) {
			superIndex++;
			thisIndex++;
			return super.next();
		} else {
			thisIndex++;
			return this.baseList.get(thisIndex);
		}
	}

	@Override
	public void remove() {
		super.remove();
	}
}
