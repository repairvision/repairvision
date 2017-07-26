package org.sidiff.consistency.common.java;

import java.util.Collections;
import java.util.Iterator;

public class JUtil {

	public static <T> Iterator<T> singeltonIterator(T obj) {
		return Collections.singletonList(obj).iterator();
	}
	
	public static void offset(Iterator<?> it, int startIndex) {
		for (int i = 0; i < startIndex; i++) {
			if (it.hasNext()) {
				it.next();
			} else {
				break;
			}
		}
	}
}
