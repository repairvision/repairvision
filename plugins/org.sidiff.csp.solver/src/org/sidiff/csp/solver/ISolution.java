package org.sidiff.csp.solver;

public interface ISolution<R, D> {
	
	void store(R subject, D value);
}
