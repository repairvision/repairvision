//TODO Check whether to keep this code or delete it!
package org.sidiff.common.collections.internal;

import java.util.*;


/**
 * Implements a list class whose content is represented by a passed iterator.
 * 
 * 
 * @param <E>
 *            The type parameter which indicates the type of elements used in collection(s).
 */
@Deprecated
public class IteratorListView<E> extends IteratorCollectionView<E> implements List<E> {

	/**
	 * Constructor.
	 * 
	 * @param iterator
	 *            The underlying iterator.
	 */
	public IteratorListView(Iterator<? extends E> iterator) {

		super(iterator);
	}

	@Override
	public void add(int index, E element) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int index, E element) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		try {
			return this.traversedElements.get(index);
		} catch (IndexOutOfBoundsException e) {
			E result = null;
			for (int seek = (this.traversedElements.size() - 1); seek < index; seek++) {
				result = performCopyStep();
				if (result == null)
					throw e;
			}
			return result;
		}
	}

	@Override
	public int indexOf(Object o) {

		if (contains(o)) {
			return this.traversedElements.indexOf(o);
		} else {
			return -1;
		}
	}

	@Override
	public int lastIndexOf(Object o) {

		performCopyAll();
		return this.traversedElements.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return new IteratorListViewIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new IteratorListViewIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
		
		try{
			return this.traversedElements.subList(fromIndex, toIndex);
		} catch (IndexOutOfBoundsException e) {
			for (int seek = (this.traversedElements.size() - 1); seek < toIndex; seek++) {
				if(performCopyStep()==null)
					throw e;
			}
			return this.traversedElements.subList(fromIndex, toIndex);
		}
	}

	class IteratorListViewIterator extends IteratorCollectionViewIterator implements ListIterator<E> {

		private int fromIndex = 0;
		
		public IteratorListViewIterator() {
			super();
		}

		public IteratorListViewIterator(int i) {
			fromIndex = i;
			try {
				this.traversedElementsIterator = IteratorListView.this.traversedElements.listIterator(i);
			} catch (IndexOutOfBoundsException e) {
				for (int seek = (IteratorListView.this.traversedElements.size() - 1); seek < i; seek++) {
					if(performCopyStep()==null)
						throw e;
				}
				if(!IteratorListView.this.underlyingIterator.hasNext()){
					throw e;
				}
			} 
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();

		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasPrevious() {
			//TO DO: Implement Me
			throw new UnsupportedOperationException();
		}

		@Override
		public int nextIndex() {
			//TO DO: Implement Me
			throw new UnsupportedOperationException();
		}

		@Override
		public E previous() {
			//TO DO: Implement Me
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			//TO DO: Implement Me
			throw new UnsupportedOperationException();
		}

	
	}

}
