package org.sidiff.common.collections;

import java.util.Collection;

/**
 * This class provides default selectors to be used in the FilterUtil or ViewUtil.  
 */
public class DefaultSelectors {

	private final static Selector<Object> anythingSelector = new Selector<Object>(){
		@Override 
		public boolean select(Object item){
			return true;
		}
	};
	
	/**
	 * Returns a selector that selects each element it is asked for.
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> Selector<T> anything() {
		return (Selector<T>)anythingSelector;
	}
	
	private final static Selector<Object> nothingSelector = new Selector<Object>(){
		@Override 
		public boolean select(Object item){
			return false;
		}
	};
	
	/**
	 * Returns a selected that never selects an elements.
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> Selector<T> nothing() {
		return (Selector<T>)nothingSelector;
	}
	
	private static final class CollectionSelector implements Selector<Object>{

		private Collection<? extends Object> items = null;
		
		public CollectionSelector(Collection<? extends Object> items) {
			this.items=items;
		}
		@Override
		public boolean select(Object item) {
			return this.items.contains(item);
		}	
	}
	
	/**
	 * Returns a selector that only selects elements that are contained in the given collections.
	 * @param <T>
	 * @param collection
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> Selector<T> anyoneOf(Collection<T> collection){
		return (Selector<T>)new CollectionSelector(collection);
	}
	
}
