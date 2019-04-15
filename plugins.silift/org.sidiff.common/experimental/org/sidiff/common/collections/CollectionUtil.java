package org.sidiff.common.collections;

import java.util.*;

/**
 * Completely untested and currently not used.
 */
@Deprecated
public class CollectionUtil {

	private CollectionUtil() {
	}

	/**
	 * Returns true if the specified vectors contains the same elements
	 * 
	 * @param v1 a vector
	 * @param v2 a vector
	 * @return true if the specified vectors contains the same elements
	 */
	public static boolean containSameElements(Vector<?> v1, Vector<?> v2) {

		Vector<?> v1_ = (Vector<?>) v1.clone();
		Vector<?> v2_ = (Vector<?>) v2.clone();

		for (Object v1_e : v1_) {
			if (!v2_.remove(v1_e)) {
				return false;
			}
		}
		if (!v2_.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Creates a copy of an iterator.
	 * It is very expensive, because once the given iterator has to be traversed totally 
	 * @param <T>
	 * @param iterator
	 * @return
	 */
	public static <T> Iterable<T> iterableFrom(final Iterator<T> iterator){
		final ArrayList<T> tmplist = new ArrayList<T>();
		while (iterator.hasNext()) {
			tmplist.add(iterator.next());
		}
		return new Iterable<T>(){
			private ArrayList<T> list = tmplist;
			@Override
			public Iterator<T> iterator() {
				return list.iterator();
			}
		};
	}
}
