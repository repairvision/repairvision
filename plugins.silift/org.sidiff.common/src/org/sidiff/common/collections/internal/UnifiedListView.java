package org.sidiff.common.collections.internal;

import java.util.*;

/**
 * Provides a single list that provides a unified view onto multiple lists.
 * It behaves equal to a new list into which the others have been added with the
 * "addAll()" operation, however, the data is not copied, but stays in the original lists.
 * Only read access is allowed.
 */
public class UnifiedListView<E> extends UnifiedCollectionView<E> implements List<E> {

	private Collection<? extends List<? extends E>> lists = null;

	public UnifiedListView(Collection<? extends List<? extends E>> lists) {
		super(lists);
		this.lists = lists;
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
		for (List<? extends E> l : this.lists) {
			if (index > l.size()) {
				index -= l.size();
			} else {
				return l.get(index);
			}
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(Object o) {
		int offset = 0;
		for (List<? extends E> l : this.lists) {
			int localIndex = l.indexOf(o);
			if (l.indexOf(o) != -1) {
				return localIndex + offset;
			}
			offset += l.size();
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int lastIndex = -1;
		int offset = 0;
		for (List<? extends E> l : this.lists) {
			int localIndex = l.indexOf(o);
			if (l.indexOf(o) != -1) {
				lastIndex = localIndex + offset;
			}
			offset += l.size();
		}
		return lastIndex;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new UnifiedListIterator<E>(this, lists);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new UnifiedListIterator<E>(this, lists, index);
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> result = new ArrayList<E>();
		for (int i = fromIndex; i < toIndex; i++) {
			result.add(get(i));
		}
		return result;
	}
}
