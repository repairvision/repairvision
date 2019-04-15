package org.sidiff.common.collections.internal;

import java.util.Set;

import org.sidiff.common.collections.Selector;

/**
 * A read-only set that provides a filtered view onto another set.
 */
public class FilteredSetView<T> extends FilteredCollectionView<T> implements Set<T> {

	public FilteredSetView(Set<? extends T> values, Selector<T> selector, boolean include) {
		super(values, selector, include);
	}
}
