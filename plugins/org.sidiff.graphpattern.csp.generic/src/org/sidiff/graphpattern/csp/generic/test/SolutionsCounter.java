package org.sidiff.graphpattern.csp.generic.test;

import org.sidiff.graphpattern.csp.generic.ISolutions;
import org.sidiff.graphpattern.csp.generic.impl.solution.Solution;

public class SolutionsCounter<R, D> implements ISolutions<R, D, Solution<R, D>> {

	private int counter = 0;
	
	private boolean PRINT_SOLUTIONS = false;
	
	public SolutionsCounter(boolean printSolutions) {
		this.PRINT_SOLUTIONS = printSolutions;
	}

	@Override
	public void add(Solution<R, D> solution) {
		++counter;
		
		if (PRINT_SOLUTIONS) {
			System.out.println();
			System.out.println("Solution #" + counter);
			
			solution.forEach((subject, value) -> {
				System.out.println(subject + "->" + value);
			});
		}
	}

	@Override
	public void reset() {
		this.counter = 0;
	}
	
	public int getCounter() {
		return counter;
	}

	@Override
	public Solution<R, D> createSolution(int size) {
		return new Solution<R, D>(size);
	}
}
