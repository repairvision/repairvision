package org.sidiff.graphpattern.csp.generic;

public interface ISolutions<R, D, S extends ISolution<R, D>> {
	
	void add(S solution);
	
	void reset();
	
	/**
	 * Solution factory.
	 * 
	 * @param size The size of the solution.
	 * @return A new solution.
	 */
	S createSolution(int size);
}
