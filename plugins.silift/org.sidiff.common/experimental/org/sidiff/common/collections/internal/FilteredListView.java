//TODO Check whether to keep this code or delete it!
package org.sidiff.common.collections.internal;

import java.util.*;

import org.sidiff.common.collections.Selector;

@Deprecated
public class FilteredListView<E> extends FilteredCollectionView<E> implements List<E> {

	private List<? extends E> list = null;
	private Selector<E> selector = null;
	private boolean include = false;

	public FilteredListView(List<? extends E> list, Selector<E> selector, boolean include) {
		super(list, selector, include);
		this.list = list;
		this.selector = selector;
		this.include = include;
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E get(int index) {
		int i = 0;
		for (E item : this.list) {
			if (this.selector.select(item) == include) {
				i++;
				if (i == index) {
					return item;
				}
			}
		}
		throw new IndexOutOfBoundsException(Integer.toString(index));
	}

	// TO DO ?? Implement: Indexposition berechnen (SW, 27.10.08)
	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	// TO DO ?? Implement: Indexposition berechnen (SW, 27.10.08)
	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		return new FilteredListIterator<E>(this.list, this.selector, this.include);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new FilteredListIterator<E>(this.list, this.selector, this.include, index);
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	// TO DO ?? Implement: Subliste berechnen (SW, 27.10.08)
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
}
