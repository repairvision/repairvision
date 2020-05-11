package org.sidiff.revision.editrules.recognition.solver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VariableSet implements Iterable<Variable> {

	private Variable[] variables;
	
	private int size = 0;
	
	public VariableSet(int capacity) {
		variables = new Variable[capacity];
	}
	
	public void add(Variable variable) {
		variables[variable.index] = variable;
		++size;
	}
	
	public void remove(Variable variable) {
		variables[variable.index] = null;
		--size;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Variable variable) {
		return variables[variable.index] != null;
	}

	@Override
	public Iterator<Variable> iterator() {
		return new Iterator<Variable>() {
			int i = 0;
			int view = 0;
			
			public boolean hasNext() {
				return i < size;
			}

			public Variable next() {
				while (view < variables.length) {
					++view;
					
					if (variables[view - 1] != null) {
						++i;
						return variables[view - 1];
					}
				}
				
				throw new NoSuchElementException();
			}
		};
	}
}
