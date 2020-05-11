package org.sidiff.graphpattern.csp.generic;

import java.util.Iterator;

public interface IStackReader<T extends Object> {

	T peek();

	T get(int i);
	
	Iterator<T> iterator();

	boolean isEmpty();

	int size();

	T[] toArray();
}