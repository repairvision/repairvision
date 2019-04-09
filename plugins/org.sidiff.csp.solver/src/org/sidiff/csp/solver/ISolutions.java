package org.sidiff.csp.solver;

public interface ISolutions<R, D, S extends ISolution<R, D>> {
	
	void add(S solution);
	
	void reset();
	
	S createSolution(int size);
}
