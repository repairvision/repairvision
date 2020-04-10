package org.sidiff.graphpattern.csp.generic.impl;

import java.util.Arrays;
import java.util.Iterator;

import org.sidiff.graphpattern.csp.generic.IStackReader;

public class Stack<T extends Object> implements Iterable<T>, IStackReader<T> {

	private T[] stack;
	
	private int pointer = 0;
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		stack = (T[]) new Object[capacity];
	}
	
	protected T[] getStack() {
		return stack;
	}
	
	protected void push(T element) {
		stack[pointer] = element;
		++pointer;
	}
	
	protected T pop() {
		--pointer;
		return stack[pointer];
	}
	
	@Override
	public T peek() {
		return stack[pointer - 1];
	}
	
	@Override
	public T get(int i) {
		return stack[i];
	}
	
	@Override
	public boolean isEmpty() {
		return (pointer == 0);
	}
	
	@Override
	public int size() {
		return pointer;
	}
	
	protected void reset() {
		for (int i = 0; i < stack.length; ++i) {
			stack[i] = null;
		}
		pointer = 0;
	}
	
	/* (non-Javadoc)
	 * @see org.sidiff.graphpattern.csp.generic.impl.UnmodifiableStack#toArray()
	 */
	@Override
	public T[] toArray() {
		return Arrays.copyOf(stack, pointer);
	}
	
	/* (non-Javadoc)
	 * @see org.sidiff.graphpattern.csp.generic.impl.UnmodifiableStack#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private int i = 0;
			
			@Override
			public boolean hasNext() {
				return (i < pointer);
			}

			@Override
			public T next() {
				if (hasNext()) {
					return stack[i++];
				} else {
					throw new UnsupportedOperationException();
				}
			}
		};
	}
}
