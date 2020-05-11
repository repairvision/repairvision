package org.sidiff.graphpattern.csp.generic.impl;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.graphpattern.csp.generic.ICSPSolver;
import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.IStackReader;
import org.sidiff.graphpattern.csp.generic.IVariable;
import org.sidiff.graphpattern.csp.generic.IVariableList;

public class ConstraintSatisfactionProblem<R, D> implements IConstraintSatisfactionProblem<R, D> {

	private ICSPSolver<R, D> solver;
	
	private Map<R, IVariable<R, D>> subjectToVariable = new HashMap<>();
	
	private IVariableList<R, D> variables;
	
	private boolean searchInjectiveSolutions = false;
	
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
		// TODO[Subclasses]: Check last picked variable!
		return true;
	}

	@Override
	public boolean checkPartialSolution(IStackReader<IVariable<R, D>> removedVariables) {
		// TODO[Subclasses]: Check last removed variable!
		return true;
	}

	@Override
	public boolean checkFinalSolution(IStackReader<IVariable<R, D>> solutionVariables) {
		// TODO[Subclasses]: Check the final solution!
		return true;
	}
}
