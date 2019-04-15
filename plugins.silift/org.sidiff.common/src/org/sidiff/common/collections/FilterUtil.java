package org.sidiff.common.collections;

import java.util.*;


public class FilterUtil {

	private FilterUtil() {}

	/**
	 * Filters a collection with a selector. Selection can be included or excluded.
	 * 
	 * @param from a collection 
	 * @param include true if Selection included, false if Selection excluded
	 * @param selector describes Selection
	 * @return filtered Set
	 */
	public static <T,C extends Collection<T>> C copy(Collection<T> from, C to, boolean include, Selector<T> selector) {

		for (T e : from) {
			if (selector.select(e) == include) {
				to.add(e);
			}
		}
		return to;
	}
	
	/**
	 * Filters a collection with a selector. Selection can be included or excluded.
	 * 
	 * @param from a collection 
	 * @param include true if Selection included, false if Selection excluded
	 * @param selector describes Selection
	 * @return filtered Set
	 */
	public static <T> Set<T> filter(Collection<T> from, boolean include, Selector<T> selector) {

		return copy(from, new HashSet<T>(), include, selector);
	}

	/**
	 * Filters a list with a selector. Selection can be included or excluded.
	 * 
	 * @param from a list 
	 * @param include true if Selection included, false if Selection excluded
	 * @param selector describes Selection
	 * @return filtered list
	 */
	public static <T> List<T> filter(List<T> from, boolean include, Selector<T> selector) {

		return copy(from, new LinkedList<T>(), include, selector);
	}

}
