package org.sidiff.common.collections;

import java.util.*;

/**
 * Completely untested and currently not used.
 */
@Deprecated
public class SetUtil {

	private SetUtil() {} // No Instances

	/**
	 * Returns an unified unmodifiable set view of the specified sets
	 * 
	 * @param e the sets for which an unified unmodifiable view is to be returned
	 * @return an unmodifiable set view of the specified sets
	 */
	public static <T> Set<T> Union(Set<? extends T>... e) {

		Set<T> result = new HashSet<T>();
		for (Set<? extends T> s : e) {
			result.addAll(s);
		}
		return result;
	}

	/**
	 * Returns a unified list of the specified collections
	 * 
	 * @param e the collections for which the list is to be returned
	 * @return a unified list of the specified collections
	 */
	public static <T> List<T> Union(Collection<? extends T>... e) {

		List<T> result = new ArrayList<T>();
		for (Collection<? extends T> s : e) {
			if (s != null)
				result.addAll(s);
		}
		return result;
	}
	
	/**
	 * Returns a set of the intersection of the specified sets
	 * 
	 * @param a a set
	 * @param b a set
	 * @return  a set of the intersection of the specified sets
	 */
	public static <T> Set<T> Intersection(Set<? extends T> a, Set<? extends T> b) {

		Set<T> result = new HashSet<T>();
		for (T ea : a) {
			if (b.contains(ea)) {
				result.add(ea);
			}
		}
		return result;
	}

	public static <T> Set<T> Intersection(Set<? extends T> a, Set<? extends T> b, Set<? extends T>... more) {
		throw new UnsupportedOperationException();
//		Set<T> result = new HashSet<T>();
//		for (T ea : a) {
//			if (b.contains(ea)) {
//				result.add(ea);
//			}
//		}
//		return result;
	}

	
	public static <T> Set<T> DifferenceA(Set<? extends T> a, Set<? extends T> b) {

		Set<T> result = new HashSet<T>();
		for (T ea : a) {
			if (b.contains(ea)) {
				result.add(ea);
			}
		}
		return result;
	}

	public static <T> Set<T> DifferenceB(Set<? extends T> a, Set<? extends T> b) {

		Set<T> result = new HashSet<T>();
		for (T ea : a) {
			if (b.contains(ea)) {
				result.add(ea);
			}
		}
		return result;
	}

	

	/**
	 * Returns a set of the symetric difference of the specified sets
	 * 
	 * @param a a set
	 * @param b a set
	 * @return a set of the symetric difference of the specified sets
	 */
	public static <T> Set<T> SymmetricDifference(Set<? extends T> a, Set<? extends T> b) {

		Set<T> result = new HashSet<T>(b);
		for (T ea : a) {
			if (result.contains(ea)) {
				result.remove(ea);
			}
		}
		return result;
	}
}
