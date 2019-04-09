package org.sidiff.csp.solver;

public interface ICSPSolver<R, D> extends Runnable {

	void reset();

	IConstraintSatisfactionProblem<R, D> getProblem();

	IStackReader<IVariable<R, D>> getRemovedVariables();

	IStackReader<IVariable<R, D>> getSolutionVariables();
}