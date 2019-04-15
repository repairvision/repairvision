//TODO Check whether to keep this code or delete it!
package org.sidiff.common.collections.internal;

import java.util.List;
import java.util.ListIterator;

import org.sidiff.common.collections.Selector;

@Deprecated
public class FilteredListIterator<E> extends FilteredIteratorView<E> implements ListIterator<E> {

	private List<? extends E> list =null;
	private int i = 0;
	
	public FilteredListIterator(List<? extends E> list, Selector<E> selector, boolean include) {
		super(list.iterator(), selector, include);
		this.list=list;
	}

	public FilteredListIterator(List<? extends E> list, Selector<E> selector, boolean include, int i) {
		super(list.iterator(), selector, include);
		if(list.size()>i){
			this.i=i;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public int nextIndex() {
		return 0;
	}

	@Override
	public E previous() {
		return null;
	}

	@Override
	public int previousIndex() {
		return 0;
	}

	@Override
	public void set(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		return null;
	}
}
