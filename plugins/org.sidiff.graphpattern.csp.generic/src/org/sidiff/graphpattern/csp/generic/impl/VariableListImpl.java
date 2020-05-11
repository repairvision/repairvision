package org.sidiff.graphpattern.csp.generic.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.sidiff.graphpattern.csp.generic.IStackReader;
import org.sidiff.graphpattern.csp.generic.IVariable;
import org.sidiff.graphpattern.csp.generic.IVariableList;

public class VariableListImpl<R, D> implements IVariableList<R, D> {
	
	private Stack<IVariable<R, D>> allVariables;
	
	private IVariable<R, D>[] variables;
	
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public VariableListImpl(int capacity) {
		variables = (IVariable<R, D>[]) new IVariable[capacity];
		allVariables = new Stack<>(capacity);
	}
	
	public IStackReader<IVariable<R, D>> getAllIVariables() {
		return allVariables;
	}
	
	@Override
	public int init(IVariable<R, D> variable) {
		
		if (variable.getIndex() != -1) {
			throw new RuntimeException("Variable with index " + variable.getIndex() + " is already contained in a variable list!");
		}
		
		// pickable variables:
		variable.setIndex(size);
		variables[variable.getIndex()] = variable;
		++size;
		
		// all variables:
		allVariables.push(variable);
		
		return variable.getIndex();
	}
	
	@Override
	public IVariable<R, D> pick() {
		
		// check if there are any more variables to assign:
		if (size > 0) {
			for (IVariable<R, D> variable : variables) {
				if (variable != null) {
					remove(variable);
					return variable;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public void put(IVariable<R, D> variable) {
		if (!contains(variable)) {
			variables[variable.getIndex()] = variable;
			++size;
		}
	}
	
	protected void remove(IVariable<R, D> variable) {
		if (contains(variable)) {
			variables[variable.getIndex()] = null;
			--size;
		}
	}

	@Override
	public void reset() {
		for (IVariable<R, D> variable : allVariables) {
			put(variable);
		}
	}
	
	public int currentSize() {
		return size;
	}
	
	@Override
	public Iterator<IVariable<R, D>> getCurrent() {
		return new Iterator<IVariable<R, D>>() {
			int i = 0;
			int view = 0;
			
			public boolean hasNext() {
				return i < size;
			}

			public IVariable<R, D> next() {
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
	
	public boolean contains(IVariable<R, D> variable) {
		return variables[variable.getIndex()] != null;
	}

	@Override
	public int fullSize() {
		return allVariables.size();
	}
	
	@Override
	public Iterator<IVariable<R, D>> getFull() {
		return allVariables.iterator();
	}

	@Override
	public int potentialSize() {
		int potentialSize = 0;
		
		for (IVariable<R, D> variable : variables) {
			if ((variable != null) && (!variable.getDomain().isEmpty())) {
				++potentialSize;
			}
		}
		
		return potentialSize;
	}
	
	@Override
	public Iterator<IVariable<R, D>> getPotential() {
		return getCurrent();
	}
}
