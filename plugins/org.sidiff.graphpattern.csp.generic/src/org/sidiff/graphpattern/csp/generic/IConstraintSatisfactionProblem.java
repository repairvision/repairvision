package org.sidiff.graphpattern.csp.generic;

public interface IConstraintSatisfactionProblem<R, D> {

	void setSolver(ICSPSolver<R, D> solver);
	
	void addVariable(IVariable<R, D> variable);
	
	IVariableList<R, D> getVariables();
	
	/**
	 * @param subject 
	 *             A subject to be resolved to a variable.
	 * @return The associated variable.
	 */
	IVariable<R, D> getVariable(R subject);
	
	boolean isSearchInjectiveSolutions();
	
	void setSearchInjectiveSolutions(boolean searchInjectiveSolutions);
	
	int getMinimumSolutionSize();

	void setMinimumSolutionSize(int minimumSolutionSize);

	int getMaximumSolutionSize();

	void setMaximumSolutionSize(int maximumSolutionSize);

	/**
	 * Checks the last picked variable.
	 * 
	 * @param solutionVariables
	 *            All currently picked variables.
	 * @return <code>true</code> if this interim solution is correct;
	 *         <code>false</code> otherwise.
	 */
	boolean checkPickedSolution(IStackReader<IVariable<R, D>> solutionVariables);

	/**
	 * Checks last removed variable.
	 * 
	 * @param removedVariables
	 *            All currently removed variables.
	 * @return <code>true</code> if this interim solution is correct;
	 *         <code>false</code> otherwise.
	 */
	boolean checkPartialSolution(IStackReader<IVariable<R, D>> removedVariables);

	/**
	 * Checks the final solution.
	 * 
	 * @param removedVariables
	 *            All currently removed variables.
	 * @return <code>true</code> if this interim solution is correct;
	 *         <code>false</code> otherwise.
	 */
	boolean checkFinalSolution(IStackReader<IVariable<R, D>> solutionVariables);
}