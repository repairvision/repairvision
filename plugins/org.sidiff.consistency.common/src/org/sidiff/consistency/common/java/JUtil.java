package org.sidiff.consistency.common.java;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class JUtil {

	@SuppressWarnings("unchecked")
	public static <T> Iterator<T> emptyIterator() {
		return (Iterator<T>) Collections.emptyList().iterator();
	}
	
	public static <T> Iterator<T> singeltonIterator(T obj) {
		return new Iterator<T>() {
			private boolean hasNext = true;

			public boolean hasNext() {
				return hasNext;
			}

			public T next() {
				if (hasNext) {
					hasNext = false;
					return obj;
				}
				throw new NoSuchElementException();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void forEachRemaining(Consumer<? super T> action) {
				Objects.requireNonNull(action);
				if (hasNext) {
					action.accept(obj);
					hasNext = false;
				}
			}
		};
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
