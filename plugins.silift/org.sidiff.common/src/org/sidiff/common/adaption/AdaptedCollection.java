package org.sidiff.common.adaption;

import java.util.*;

/**
 * This class adapts a collection so that for each element of the original collection an adapted element
 * is returned. The elements are adapted on demand, i.e. there is no copy of the original collection.
 *
 * @param <A> type of unadapted elements
 * @param <B> type of adapted elements
 */
public class AdaptedCollection<A,B> implements Collection<B>{

	protected ContentAdapter<A,B> contentAdapter = null;
	protected Collection<A> adaptableCollection = null;
	
	public AdaptedCollection(Collection<A> adaptableCollection,ContentAdapter<A, B> contentAdapter){
		
		assert(contentAdapter!=null);
		assert(adaptableCollection!=null);
		
		this.contentAdapter = contentAdapter;
		this.adaptableCollection = adaptableCollection;
	}
	
	@Override
	public boolean add(B e) {
		return this.adaptableCollection.add(this.contentAdapter.unadapt(e));
	}

	@Override
	public boolean addAll(Collection<? extends B> c) {

		boolean result=false;
		for(B item : c){
			result |= add(item);
		}
		return result;
	}

	@Override
	public void clear() {
		this.adaptableCollection.clear();
	}

	@Override
	public boolean contains(Object o) {
		for(B item : this){
			if(o.equals(item)) return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c){
			if(!contains(o)) return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.adaptableCollection.isEmpty();
	}

	@Override
	public Iterator<B> iterator() {
		
		return new AdaptedIterator<A, B>(this.adaptableCollection.iterator(),this.contentAdapter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		try{
			return this.adaptableCollection.remove(this.contentAdapter.unadapt((B)o));
		} catch (Exception e){
			return false;
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean result=false;
		for(Object item : c){
			result |= remove(item);
		}
		return result;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean result=false;
		Collection<B> del = new HashSet<B>();
		for(B item : this){
			if (!c.contains(item))
				del.add(item);
		}
		for (Object item : del) {
			result |= remove(item);
		}
		return result;
	}

	@Override
	public int size() {
		return this.adaptableCollection.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		A[] adapable = (A[])this.adaptableCollection.toArray();
		Object[] adaptedArray = new Object[adapable.length];
		for(int i=0;i<adapable.length;i++){
			adaptedArray[i]= this.contentAdapter.adapt(adapable[i]);
		}
		return adaptedArray;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
        return (T[])toArray();
	}

}
