package org.sidiff.csp.solver.impl.solution;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.csp.solver.ISolutions;

public class SolutionsList<R, D> implements ISolutions<R, D, Solution<R, D>> {

	List<Solution<R, D>> solutions = new ArrayList<>();
	
	@Override
	public void add(Solution<R, D> solution) {
		solutions.add(solution);
	}

	@Override
	public void reset() {
		solutions.clear();
	}
	
	public List<Solution<R, D>> getSolutions() {
		return solutions;
	}

	@Override
	public Solution<R, D> createSolution(int size) {
		return new Solution<R, D>(size);
	}
}
