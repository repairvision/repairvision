package org.sidiff.graphpattern.csp.generic.impl;

import org.sidiff.graphpattern.csp.generic.ICSPSolver;
import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.ISolution;
import org.sidiff.graphpattern.csp.generic.ISolutions;
import org.sidiff.graphpattern.csp.generic.IStackReader;
import org.sidiff.graphpattern.csp.generic.IVariable;
import org.sidiff.graphpattern.csp.generic.IVariableList;

public class CSPSolver<R, D> implements ICSPSolver<R, D> {
	
	protected IConstraintSatisfactionProblem<R, D> problem;
	
	protected ISolutions<R, D, ISolution<R, D>> solutions;
	
	protected IVariableList<R, D> pickableVariables;
	
	protected Stack<IVariable<R, D>> removedVariables;
	
	protected Stack<IVariable<R, D>> solutionVariables;
	
	private boolean checkForMaximumSolution;	// derived from variables
	
	private int droppedSolutions = 0;
	
	@SuppressWarnings("unchecked")
	public CSPSolver(
			IConstraintSatisfactionProblem<R, D> problem, 
			ISolutions<R, D, ? extends ISolution<R, D>> solutions) {
		this.problem = problem;
		this.problem.setSolver(this);
		this.solutions = (ISolutions<R, D, ISolution<R, D>>) solutions;
	}
	
	protected void initialize() {
		this.pickableVariables = problem.getVariables();
		this.removedVariables = new Stack<IVariable<R, D>>(pickableVariables.currentSize());
		this.solutionVariables = new Stack<IVariable<R, D>>(pickableVariables.currentSize());
		
		// check if at least one variable needs to be checked:
		this.checkForMaximumSolution = false;
		
		for (IVariable<R, D> variable : problem.getVariables()) {
			if (variable.isMaximizeSolution()) {
				this.checkForMaximumSolution = true;
				break;
			}
		}
	}
	
	@Override
	public void run() {
		initialize();
		expandSolution();
	}
	
	@Override
	public void reset() {
		this.solutions.reset();
		this.pickableVariables.reset();
		this.droppedSolutions = 0;
	}
	
	protected void expandSolution() {
		
		// (A) is expandable?
		IVariable<R, D> variable = pickableVariables.pick();
		
		if (variable != null) {
			
			// (A) expand solution:
			solutionVariables.push(variable);
			
			// find all assignments which >include< the picked variable:
			if (!variable.getDomain().isEmpty() 
					&& checkMaximumBound() 
					&& problem.checkPickedSolution(solutionVariables)) {
				
				// assign all values of the picked variable:
				for (D value : variable.getDomain()) {

					// (B) assign the variable with the value:
					if (variable.assign(value)) {
						expandSolution();
					}
					
					// (B) backtracking:
					variable.free();
				}
			} else {
				++droppedSolutions;
			}
				
			// find all assignments which >exclude< the picked variable:
			if (variable.isRemovable()) {

				// (C) remove variable:
				IVariable<R, D> lastVariable = solutionVariables.pop();
				removedVariables.push(lastVariable);

				if (checkMinimumBound() && problem.checkPartialSolution(removedVariables)) {
					expandSolution();
				}

				// (C) backtracking:
				removedVariables.pop();
				solutionVariables.push(lastVariable);
			}
			
			// (A) backtracking:
			solutionVariables.pop();
			pickableVariables.put(variable);
			
		} else {
			
			// save actual assignment:
			if (checkFinalSolution()) {
				storeSolution();
			} else {
				++droppedSolutions;
			}
		}
	}
	
	protected boolean checkFinalSolution() {
		return (solutionVariables.size() >= problem.getMinimumSolutionSize())
			&& (solutionVariables.size() <= problem.getMaximumSolutionSize())
			&& checkMaximumSolution() 
			&& problem.checkFinalSolution(solutionVariables);
	}
	
	protected boolean checkMinimumBound() {
		return (solutionVariables.size() >= problem.getMinimumSolutionSize())
			|| ((solutionVariables.size() + pickableVariables.potentialSize()) >= problem.getMinimumSolutionSize());
	}
	
	protected boolean checkMaximumBound() {
		return solutionVariables.size() <= problem.getMaximumSolutionSize();
	}
	
	protected boolean checkMaximumSolution() {
		assert (pickableVariables.currentSize() == 0);
		
		// Check that no removed variable can be assigned with a value:
		if (checkForMaximumSolution) {
			for (IVariable<R, D> removedVariable : removedVariables) {
				if (removedVariable.isMaximizeSolution() && removedVariable.isAssignable()) {
					return false;
				}
			}
		}
		
		return true;
	}

	protected void storeSolution() {
		ISolution<R, D> solution = solutions.createSolution(solutionVariables.size());
		
		for (int i = 0; i < solutionVariables.size(); i++) {
			IVariable<R, D> variable = solutionVariables.get(i);
			solution.store(variable.getSubject(), variable.getValue());
		}
		
		solutions.add(solution);
	}
	
	public int getDroppedSolutions() {
		return droppedSolutions;
	}
	
	@Override
	public IStackReader<IVariable<R, D>> getRemovedVariables() {
		return removedVariables;
	}
	
	@Override
	public IStackReader<IVariable<R, D>> getSolutionVariables() {
		return solutionVariables;
	}
	
	@Override
	public IConstraintSatisfactionProblem<R, D> getProblem() {
		return problem;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append("Current Solution:\n");
		
		for (IVariable<R, D> variable : solutionVariables) {
			string.append(variable + "\n");
		}
		
		string.append("Currently Removed Variables:\n");
		
		for (IVariable<R, D> variable : removedVariables) {
			string.append(variable + "\n");
		}
		
		string.append("Pickable Variables:\n");
		
		for (IVariable<R, D> variable : pickableVariables) {
			string.append(variable + "\n");
		}
		
		return string.toString();
	}
}
