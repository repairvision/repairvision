package org.sidiff.csp.solver.impl;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.csp.solver.ICSPSolver;
import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.IStackReader;
import org.sidiff.csp.solver.IVariable;
import org.sidiff.csp.solver.IVariableList;

public class ConstraintSatisfactionProblem<R, D> implements IConstraintSatisfactionProblem<R, D> {

	private ICSPSolver<R, D> solver;
	
	private Map<R, IVariable<R, D>> subjectToVariable = new HashMap<>();
	
	private IVariableList<R, D> variables;
	
	private boolean searchInjectiveSolutions = false;
	
	private boolean searchMaximumSolutions = false;
	
	private int minimumSolutionSize = 0;
	
	private int maximumSolutionSize = Integer.MAX_VALUE;
	
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
	public void addVariable(IVariable<R, D> variable) {
		subjectToVariable.put(variable.getSubject(), variable);
		variables.init(variable);
		variable.setCSP(this);
	}
	
	@Override
	public IVariableList<R, D> getVariables() {
		return variables;
	}
	
	@Override
	public IVariable<R, D> getVariable(R subject) {
		return subjectToVariable.get(subject);
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
