package org.sidiff.graphpattern.csp.generic;

public interface IVariable<R, D> {

	R getSubject();
	
	void setCSP(IConstraintSatisfactionProblem<R, D> csp);
	
	int getIndex();

	void setIndex(int index);

	boolean isRemovable();

	void setRemovable(boolean removable);
	
	boolean isMaximizeSolution();
	
	void setMaximizeSolution(boolean maximize);

	IDomain<D> getDomain();

	D getValue();

	boolean isAssignable();

	boolean assign(D value);

	void free();
	
	boolean applyRestrictions();

	void undoRestrictions();
	
}