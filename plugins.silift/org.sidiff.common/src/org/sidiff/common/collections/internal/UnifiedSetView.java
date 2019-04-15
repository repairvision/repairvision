package org.sidiff.common.collections.internal;

import java.util.Collection;
import java.util.Set;

/**
 * Provides a single set that provides a unified view onto multiple sets.
 * It behaves equal to a new set into which the others have been added with the
 * "addAll()" operation, however, the data is not copied, but stays in the original sets.
 * Only read access is allowed.
 */
public class UnifiedSetView<E> extends UnifiedCollectionView<E> implements Set<E> {

	public UnifiedSetView(Collection<? extends Set<? extends E>> sets) {
		super(sets);
	}
}
