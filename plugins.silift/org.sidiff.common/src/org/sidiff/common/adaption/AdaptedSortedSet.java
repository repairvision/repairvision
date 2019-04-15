package org.sidiff.common.adaption;

import java.util.Comparator;
import java.util.SortedSet;

/**
 * This class adapts a sorted set so that for each element of the original set an adapted element
 * is returned. The elements are adapted on demand, i.e. there is no copy of the original set.
 *
 * @param <A> type of unadapted elements
 * @param <B> type of adapted elements
 */
public class AdaptedSortedSet<A,B> extends AdaptedSet<A, B> implements SortedSet<B>{

	private SortedSet<A> adaptableSortedSet = null;
	
	public AdaptedSortedSet(SortedSet<A> adaptableSortedSet, ContentAdapter<A, B> contentAdapter) {
		super(adaptableSortedSet, contentAdapter);
		this.adaptableSortedSet=adaptableSortedSet;
	}
	
	@Override
	public Comparator<? super B> comparator() {
		throw new UnsupportedOperationException("The comparator for similarities cannot be returned since the comparison relies on internal object structures!");
	}

	@Override
	public B first() {
		return this.contentAdapter.adapt(this.adaptableSortedSet.first());
	}
	
	@Override
	public B last() {
		return this.contentAdapter.adapt(this.adaptableSortedSet.last());
	}

	@Override
	public SortedSet<B> headSet(B toElement) {
		return new AdaptedSortedSet<A, B>(this.adaptableSortedSet.headSet(this.contentAdapter.unadapt(toElement)),this.contentAdapter);
	}

	@Override
	public SortedSet<B> subSet(B fromElement, B toElement) {
		return new AdaptedSortedSet<A, B>(this.adaptableSortedSet.subSet(this.contentAdapter.unadapt(fromElement),this.contentAdapter.unadapt(toElement)),this.contentAdapter);
	}

	@Override
	public SortedSet<B> tailSet(B fromElement) {
		return new AdaptedSortedSet<A, B>(this.adaptableSortedSet.tailSet(this.contentAdapter.unadapt(fromElement)),this.contentAdapter);
	}



}
