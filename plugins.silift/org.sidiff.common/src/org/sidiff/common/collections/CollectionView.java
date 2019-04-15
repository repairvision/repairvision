package org.sidiff.common.collections;

import java.util.Collection;
import java.util.Iterator;

public final class CollectionView {

	static class JoinedCollectionView<E> implements Collection<E> {

		private final Collection<? extends E>[] items;

		public JoinedCollectionView(final Collection<? extends E>[] items) {
			this.items = items;
		}

		@Override
		public boolean addAll(final Collection<? extends E> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			for (final Collection<? extends E> coll : items) {
				coll.clear();
			}
		}

		@Override
		public boolean contains(final Object o) {
			for (int i = 0; i < items.length; i++) {
				if (items[i].contains(o)) {
					return true;
				}
			}
			
			return false;
		}

		@Override
		public boolean containsAll(final Collection<?> c) {
			for (Object object : c) {
				if (!contains(object)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean isEmpty() {
			return !iterator().hasNext();
		}

		@Override
		public Iterator<E> iterator() {
			return new Iterator<E>() {

				private Iterator<? extends E> it = items[0].iterator();
				private int i = 0;

				@Override
				public boolean hasNext() {
					boolean hasNext = it.hasNext();

					if (!hasNext && ((i + 1) < items.length)) {
						i++;
						it = items[i].iterator();
						hasNext = it.hasNext();
					}

					return hasNext;
				}

				@Override
				public E next() {
					return it.next();
				}

				@Override
				public void remove() {
					it.remove();
				}
			};
		}

		@Override
		public boolean remove(final Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(final Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(final Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int size() {
			int ct = 0;
			for (final Collection<? extends E> coll : items) {
				ct += coll.size();
			}
			return ct;
		}

		@Override
		public Object[] toArray() {
			throw new UnsupportedOperationException();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean add(E e) {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Returns a live aggregated collection view of the collections passed in.
	 * <p>
	 * All methods except {@link Collection#size()}, {@link Collection#clear()},
	 * {@link Collection#isEmpty()} and {@link Iterable#iterator()} throw
	 * {@link UnsupportedOperationException} in the returned Collection.
	 * <p>
	 * None of the above methods is thread safe (nor would there be an easy way of making them).
	 */
	public static <T> Collection<T> combine(final Collection<? extends T>... items) {
		return new JoinedCollectionView<T>(items);
	}

	private CollectionView() {
	}
}
