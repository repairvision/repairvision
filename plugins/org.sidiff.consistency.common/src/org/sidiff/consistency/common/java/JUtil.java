package org.sidiff.consistency.common.java;

import java.util.Collections;
import java.util.Iterator;

public class JUtil {

	public static <T> Iterator<T> singeltonIterator(T obj) {
		return Collections.singletonList(obj).iterator();
	}
	
	public static <T> Iterable<T> toIterable(Iterator<T> it) {
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				return it;
			}
		};
	}
}
