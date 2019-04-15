package org.sidiff.common.adaption;

import java.util.Set;
 
/**
 * This class adapts a set so that for each element of the original set an adapted element
 * is returned. The elements are adapted on demand, i.e. there is no copy of the original set.
 *
 * @param <A> type of unadapted elements
 * @param <B> type of adapted elements
 */
public class AdaptedSet<A,B> extends AdaptedCollection<A, B> implements Set<B> {

	public AdaptedSet(Set<A> adaptableSet, ContentAdapter<A, B> contentAdapter) {
		super(adaptableSet, contentAdapter);
	}

}
