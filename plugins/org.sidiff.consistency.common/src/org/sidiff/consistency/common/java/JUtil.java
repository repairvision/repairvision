package org.sidiff.consistency.common.java;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class JUtil {
	
	public static <T> Iterable<T> createIterable(Supplier<Iterator<T>> iterator) {
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				return iterator.get();
			}
		};
	}

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
	
	public static boolean contains(Object[] array, Object value) {
		for (Object object : array) {
			if (object.equals(value)) {
				return true;
			}
		}
		return false;
	}
}
