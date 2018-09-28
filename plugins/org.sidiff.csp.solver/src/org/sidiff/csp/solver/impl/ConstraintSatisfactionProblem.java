package org.sidiff.csp.solver.impl;

import org.sidiff.csp.solver.ICSPSolver;
import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.IStackReader;
import org.sidiff.csp.solver.IVariable;
import org.sidiff.csp.solver.IVariableList;

public class ConstraintSatisfactionProblem<R, D> implements IConstraintSatisfactionProblem<R, D> {

	protected ICSPSolver<R, D> solver;
	
	protected IVariableList<R, D> variables;
	
	protected boolean searchInjectiveSolutions = false;
	
	protected boolean searchMaximumSolutions = false;
	
	protected int minimumSolutionSize = 0;
	
	protected int maximumSolutionSize = Integer.MAX_VALUE;
	
	public ConstraintSatisfactionProblem(int size) {
		this.variables = new VariableListImpl<R, D>(size);
	}
	
	@Override
	public void setSolver(ICSPSolver<R, D> solver) {
		
		if (this.solver != null) {
			throw new RuntimeException("This constraint satisfaction problem is already assigned to a solver!");
		}
		
		this.solver = solver;
	}
	
	@Override
	public IVariableList<R, D> getVariables() {
		return variables;
	}
	
	@Override
	public void addVariable(IVariable<R, D> variable) {
		variables.init(variable);
		variable.setCSP(this);
	}
	
	@Override
	public boolean isSearchInjectiveSolutions() {
		return searchInjectiveSolutions;
	}
	
	@Override
	public void setSearchInjectiveSolutions(boolean searchInjectiveSolutions) {
		this.searchInjectiveSolutions = searchInjectiveSolutions;
	}

	@Override
	public boolean isSearchMaximumSolutions() {
		return searchMaximumSolutions;
	}
	
	@Override
	public void setSearchMaximumSolutions(boolean searchMaximumSolutions) {
		this.searchMaximumSolutions = searchMaximumSolutions;
	}
	
	@Override
	public int getMinimumSolutionSize() {
		return minimumSolutionSize;
	}
	
	@Override
	public void setMinimumSolutionSize(int minimumSolutionSize) {
		this.minimumSolutionSize = minimumSolutionSize;
	}
	
	@Override
	public int getMaximumSolutionSize() {
		return maximumSolutionSize;
	}
	
	@Override
	public void setMaximumSolutionSize(int maximumSolutionSize) {
		this.maximumSolutionSize = maximumSolutionSize;
	}

	@Override
	public boolean checkPickedSolution(IStackReader<IVariable<R, D>> solutionVariables) {
		// TODO: Check last picked variable!
		return true;
	}

	@Override
	public boolean checkPartialSolution(IStackReader<IVariable<R, D>> removedVariables) {
		// TODO: Check last removed variable!
		return true;
	}

	@Override
	public boolean checkFinalSolution(IStackReader<IVariable<R, D>> solutionVariables) {
		// TODO: Check the final solution!
		return true;
	}
}
