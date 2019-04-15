package org.sidiff.common.collections.internal;

import java.util.*;

import org.sidiff.common.collections.Selector;

/**
 * A read-only collection that provides a filtered view onto another collection.
 */
public class FilteredCollectionView<E> extends ReadOnlyCollection<E> {

	private Collection<? extends E> collection = null;
	private Selector<E> selector = null;
	private boolean include = false;

	public FilteredCollectionView(Collection<? extends E> collection, Selector<E> selector, boolean include) {
		this.collection = collection;
		this.selector = selector;
		this.include = include;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {

		try {
			if (collection.isEmpty() || o == null || selector.select((E) o) != this.include) {
				return false;
			}
		} catch (ClassCastException e) {
			return false;
		}

		return this.collection.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (collection.isEmpty() || c.isEmpty()) {
			return false;
		} else {
			if (c.iterator().next().getClass().equals(collection.iterator().next().getClass())) {
				return collection.containsAll(c);
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean isEmpty() {

		if (!collection.isEmpty()) {
			for (E item : this.collection) {
				if (this.selector.select(item) == this.include) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new FilteredIteratorView<E>(this.collection.iterator(), this.selector, this.include);
	}

	@Override
	public int size() {
		int size = 0;
		for (E item : collection) {
			if (this.selector.select(item) == this.include) {
				size++;
			}
		}
		return size;
	}

	@Override
	public Object[] toArray() {
		LinkedList<E> list = new LinkedList<E>();
		for (E item : collection) {
			if (this.selector.select(item) == this.include) {
				list.add(item);
			}
		}
		return list.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) toArray();
	}
}
