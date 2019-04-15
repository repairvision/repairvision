package org.sidiff.common.collections.internal;

import java.util.Iterator;

/**
 * Defines a read-only iterator.
 * The remove operation throw an UnsupportedOperationException.
 */
public abstract class ReadOnlyIterator<E> implements Iterator<E> {

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
