package org.sidiff.graphpattern.matching.util;

import java.util.Arrays;

public class Stack<T extends Object> {

	private T[] stack;
	
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		stack = (T[]) new Object[capacity];
	}
	
	public T[] getStack() {
		return stack;
	}
	
	public void push(T element) {
		stack[size] = element;
		++size;
	}
	
	public T pop() {
		--size;
		return stack[size];
	}
	
	public T peek() {
		return stack[size - 1];
	}
	
	public T get(int i) {
		return stack[i];
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int size() {
		return size;
	}
	
	public void reset() {
		for (int i = 0; i < stack.length; ++i) {
			stack[i] = null;
		}
		size = 0;
	}
	
	public T[] toArray() {
		return Arrays.copyOf(stack, size);
	}
}
