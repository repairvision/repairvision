package org.sidiff.common.collections;

/**
 * Interface for a selector that is to be used with the FilterUtil or the ViewUtil. 
 */
public interface Selector<T> {
	public boolean select(T item);
}