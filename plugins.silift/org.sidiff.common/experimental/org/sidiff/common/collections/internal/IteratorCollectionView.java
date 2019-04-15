//TODO Check whether to keep this code or delete it!
package org.sidiff.common.collections.internal;

import java.util.*;

/**
 * Implements a collection class whose content is represented by a passed iterator.
 * 
 * 
 * @param <E>
 *            The type parameter which indicates the type of elements used in collection(s).
 */
@Deprecated
public class IteratorCollectionView<E> extends ReadOnlyCollection<E> {
	
	/**
	 * Holds the underlying iterator.
	 */
	protected Iterator<? extends E> underlyingIterator = null;
	
	/**
	 * The collection which will be stepwise on demand filled and holds values behind iterator.
	 */
	protected List<E> traversedElements = null;

	/**
	 * Constructor.
	 * 
	 * @param iterator
	 *            The underlying iterator.
	 */
	public IteratorCollectionView(Iterator<? extends E> iterator) {
		
		this.underlyingIterator = iterator;
		this.traversedElements = new LinkedList<E>();
	}


	@Override
	public boolean contains(Object o) {
		
		if(o != null){
			if(!this.traversedElements.contains(o)){
				E item = performCopyStep();
				while(item!=null){
					if(item.equals(o)){
						return true;
					} else {
						item=performCopyStep();
					}
				}
				
				return false;
			} else {
				// Object contained in traversed Elements!
				return true;
			}
		} 
		// Object is null
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		Iterator<?> e = c.iterator();
		while (e.hasNext())
			if (!contains(e.next()))
				return false;
		return true;
	}

	@Override
	public boolean isEmpty() {

		return this.traversedElements.isEmpty()
			&&!this.underlyingIterator.hasNext();
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorCollectionViewIterator();
	}

	@Override
	public int size() {
	
		performCopyAll();
		return this.traversedElements.size();
	}

	@Override
	public Object[] toArray() {
		
		performCopyAll();
		return this.traversedElements.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) toArray();
	}

	protected boolean performCopyAll(){
		
		boolean appended = false;
		while(this.underlyingIterator.hasNext()){
			appended |= this.traversedElements.add(this.underlyingIterator.next());
		}
		return appended;
	}
	
	protected E performCopyStep(){
		
		E item = null;
		if(this.underlyingIterator.hasNext()){
			item = this.underlyingIterator.next();
			this.traversedElements.add(item);
		}
		return item;
	}
	
	class IteratorCollectionViewIterator extends ReadOnlyIterator<E> {
		 	
			protected Iterator<E> traversedElementsIterator = null;
		
			public IteratorCollectionViewIterator() {
				Iterator<E>  iter = IteratorCollectionView.this.traversedElements.iterator();
				if(iter.hasNext()){
					this.traversedElementsIterator = iter;
				}
			}
			
			@Override
			public boolean hasNext() {
				
				return (this.traversedElementsIterator!=null)
					 ||IteratorCollectionView.this.underlyingIterator.hasNext();
			}

			@Override
			public E next() {
				E result = null;
				if(this.traversedElementsIterator!=null){
					result = this.traversedElementsIterator.next();
					if(!this.traversedElementsIterator.hasNext()){
						this.traversedElementsIterator=null;
					}
				} else {
					result= performCopyStep();
				}
				return result;
			}
	 } 
}
