package org.sidiff.graphpattern.csp.generic;

import java.util.Iterator;

public interface IVariableList<R, D> extends Iterable<IVariable<R, D>> {
	
	/**
	 * @return The number of all variables.
	 */
	int fullSize();
	
	/**
	 * @return All variables.
	 */
	Iterator<IVariable<R, D>> getFull();
	
	/**
	 * @return The number of the currently pickable variables.
	 */
	int currentSize();
	
	/**
	 * @return All currently pickable variables.
	 */
	Iterator<IVariable<R, D>> getCurrent();
	
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	default Iterator<IVariable<R, D>> iterator() {
		return getCurrent();
	}
	
	/**
	 * @return The current number of all variables, which will be potentially pickable.
	 */
	int potentialSize();
	
	/**
	 * @return All variables, which will be potentially pickable.
	 */
	Iterator<IVariable<R, D>> getPotential();

	/**
	 * @param variable
	 *            A variable.
	 * @return The assigned index of the variable.
	 */
	int init(IVariable<R, D> variable);

	/**
	 * Picks and removes a variable from the list.
	 * 
	 * @return The picked variable.
	 */
	IVariable<R, D> pick();

	/**
	 * Puts back a variable into the list.
	 * 
	 * @param variable A variable.
	 */
	void put(IVariable<R, D> variable);

	/**
	 * Resets the list to its initial state.
	 */
	void reset();
}
