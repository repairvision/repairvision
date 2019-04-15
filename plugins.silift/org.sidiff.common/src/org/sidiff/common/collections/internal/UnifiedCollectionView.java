package org.sidiff.common.collections.internal;

import java.util.*;

/**
 * Provides a single collections that provides a unified view onto multiple collections.
 * It behaves equal to a new collection into which the others have been added with the
 * "addAll()" operation, however, the data is not copied, but stays in the original collections.
 */
public class UnifiedCollectionView<E> extends ReadOnlyCollection<E> {

	private Collection<? extends Collection<? extends E>> collections = null;

	public UnifiedCollectionView(Collection<? extends Collection<? extends E>> collections) {
		this.collections = collections;
	}


	@Override
	public boolean contains(Object o) {
		for (Collection<? extends E> c : collections) {
			if (c.contains(o))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Set<?> cs = new HashSet<Object>(c);
		for (Collection<? extends E> cc : collections) {
			cs.removeAll(cc);
			if (cs.isEmpty())
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {

		for (Collection<? extends E> c : collections) {
			if (!c.isEmpty())
				return false;
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new UnifiedCollectionIterator<E>(collections);
	}


	@Override
	public int size() {
		int size = 0;
		for (Collection<? extends E> c : collections) {
			size += c.size();
		}
		return size;
	}

	@Override
	public Object[] toArray() {
		List<Object> result = new ArrayList<Object>(size());
		for (Collection<? extends E> c : collections) {
			result.addAll(c);
		}
		return result.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) toArray();
	}
}
