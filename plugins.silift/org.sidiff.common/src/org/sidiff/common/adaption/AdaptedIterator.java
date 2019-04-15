package org.sidiff.common.adaption;

import java.util.Iterator;

/**
 * This class adapts an iterator so that for each element of the original iterator an adapted element
 * is returned. The elements are adapted on demand, i.e. there is no copy of the original iterator.
 *
 * @param <A> type of unadapted elements
 * @param <B> type of adapted elements
 */
public class AdaptedIterator<A,B> implements Iterator<B> {

	protected ContentAdapter<A,B> contentAdapter = null;
	protected Iterator<A> adaptableIterator = null;
	
	public AdaptedIterator(Iterator<A> adaptableIterator, ContentAdapter<A, B> contentAdapter) {
		this.contentAdapter = contentAdapter;
		this.adaptableIterator = adaptableIterator;
	}

	@Override
	public boolean hasNext() {

		return adaptableIterator.hasNext();
	}

	@Override
	public B next() {
		return this.contentAdapter.adapt(this.adaptableIterator.next());
	}

	@Override
	public void remove() {
		adaptableIterator.remove();
	}

}
