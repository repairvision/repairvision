package org.sidiff.common.collections;

import java.util.*;

import org.sidiff.common.collections.internal.*;

public class ViewUtil {

	private ViewUtil() {} // No Instances
		
	/**
	 * Returns an unmodifiable view of the specified collection of collections.
	 * The set methods are overridden and now refers to the Objects of the collections of the collection
	 * 
	 * @param values the collection of collections whereof the view shall be created
	 * @return a unified collection view of the specified collection
	 */
	public static <T> Collection<T> unifiedCollectionView(Collection<? extends Collection<? extends T>> values) {
		return new UnifiedCollectionView<T>(values);
	}

	/**
	 * Returns an unmodifiable view of the specified set of sets.
	 * The set methods are overridden and now refers to the Objects of the Sets of the Set
	 * 
	 * @param values the set of sets whereof the view shall be created
	 * @return a unified set view of the specified set
	 */
	public static <T> Set<T> unifiedSetView(Collection<? extends Set<? extends T>> values) {
		return new UnifiedSetView<T>(values);
	}

	/**
	 * Returns an unmodifiable view of the specified list of lists.
	 * The set methods are overridden and now refers to the Objects of the lists of the list
	 * 
	 * @param values the list of lists whereof the view shall be created
	 * @return a unified list view of the specified list
	 */
	public static <T> List<T> unifiedListView(Collection<? extends List<? extends T>> values) {
		return new UnifiedListView<T>(values);
	}

	/**
	 * Returns a filtered view onto a collection of elements. 
	 * @param values
	 * @param selector
	 * @param include
	 * @return
	 */
	public static <T> Collection<T> filteredCollectionView(Collection<? extends T> values, Selector<T> selector, boolean include) {
		return new FilteredCollectionView<T>(values, selector, include);
	}

	/**
	 * Returns a filtered view onto a set of elements. 
	 * @param values
	 * @param selector
	 * @param include
	 * @return
	 */
	public static <T> Set<T> filteredSetView(Set<? extends T> values, Selector<T> selector, boolean include) {
		return new FilteredSetView<T>(values, selector, include);
	}

	/**
	 * Returns a filtered view onto an iterator of elements. 
	 * @param iter
	 * @param selector
	 * @param include
	 * @return
	 */
	public static <T> Iterator<T> filteredIteratorView(Iterator<T> iter, Selector<T> selector, boolean include){
		return new FilteredIteratorView<T>(iter,selector,include);
	}

}
