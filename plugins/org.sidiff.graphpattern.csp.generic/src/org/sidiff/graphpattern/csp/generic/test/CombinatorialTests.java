package org.sidiff.graphpattern.csp.generic.test;

import org.junit.Assert;
import org.junit.Test;
import org.sidiff.graphpattern.csp.generic.ICSPSolver;
import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.CSPSolver;
import org.sidiff.graphpattern.csp.generic.impl.ConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.Variable;
import org.sidiff.graphpattern.csp.generic.impl.domain.Domain;

public class CombinatorialTests {

	public static boolean PRINT_SOLUTIONS = false;
	
	public static void main(String[] args) {
		new CombinatorialTests().twoValuesAllCombinationsTest();
	}
	
	@Test
	public void oneValueAllCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		IConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A"), true, false));
		problem.addVariable(new Variable<>("v2", new Domain<>("B"), true, false));
		problem.addVariable(new Variable<>("v3", new Domain<>("C"), true, false));
		problem.addVariable(new Variable<>("v4", new Domain<>("D"), true, false));
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test:
		Assert.assertEquals(Math.pow(2, problem.getVariables().currentSize()), solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void oneValueOnlyPartialCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		ConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A"), true, false));
		problem.addVariable(new Variable<>("v2", new Domain<>("B"), true, false));
		problem.addVariable(new Variable<>("v3", new Domain<>("C"), true, false));
		problem.addVariable(new Variable<>("v4", new Domain<>("D"), true, false));
		
		// only partial solutions:
		problem.setMaximumSolutionSize(problem.getVariables().currentSize() - 1);
		problem.setMinimumSolutionSize(1);
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test (all combination minus full (cross-product) and empty solution):
		Assert.assertEquals(Math.pow(2, problem.getVariables().currentSize()) - (1*1) - 1, solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void oneValueOnlyMaximalPartialCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		ConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A"), true, true));
		problem.addVariable(new Variable<>("v2", new Domain<>("B"), true, true));
		problem.addVariable(new Variable<>("v3", new Domain<>("C"), true, true));
		problem.addVariable(new Variable<>("v4", new Domain<>("D"), true, true));
		
		// only maximal partial solutions:
		problem.setMaximumSolutionSize(problem.getVariables().currentSize() - 1);
		problem.setMinimumSolutionSize(1);
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test (all values are independent of each other -> power set minus full and empty solution):
		Assert.assertEquals(Math.pow(2, problem.getVariables().currentSize()) - 2, solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void oneValueOnlyMaximalFullCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		ConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A"), true, true));
		problem.addVariable(new Variable<>("v2", new Domain<>("B"), true, true));
		problem.addVariable(new Variable<>("v3", new Domain<>("C"), true, true));
		problem.addVariable(new Variable<>("v4", new Domain<>("D"), true, true));
		
		// only maximal partial solutions:
		problem.setMaximumSolutionSize(problem.getVariables().currentSize());
		problem.setMinimumSolutionSize(problem.getVariables().currentSize());
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test (all values are independent of each other -> cross-product -> one full solution):
		Assert.assertEquals(1, solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void twoValuesOnlyPartialCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		IConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A1", "A2"), true, false));
		problem.addVariable(new Variable<>("v2", new Domain<>("B1", "B2"), true, false));
		problem.addVariable(new Variable<>("v3", new Domain<>("C1", "C2"), true, false));
		problem.addVariable(new Variable<>("v4", new Domain<>("D1", "D2"), true, false));

		// only partial solutions:
		problem.setMaximumSolutionSize(problem.getVariables().currentSize() - 1);
		problem.setMinimumSolutionSize(1);
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test (all combination minus all full (cross-product) and empty solution):
		Assert.assertEquals(Math.pow(3, problem.getVariables().currentSize()) - (4*4) - 1, solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void twoValuesAllCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		IConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A1", "A2"), true, false));
		problem.addVariable(new Variable<>("v2", new Domain<>("B1", "B2"), true, false));
		problem.addVariable(new Variable<>("v3", new Domain<>("C1", "C2"), true, false));
		problem.addVariable(new Variable<>("v4", new Domain<>("D1", "D2"), true, false));
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test:
		Assert.assertEquals(Math.pow(3, problem.getVariables().currentSize()), solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void twoValuesOnlyMaximalPartialCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		ConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A1", "A2"), true, true));
		problem.addVariable(new Variable<>("v2", new Domain<>("B1", "B2"), true, true));
		problem.addVariable(new Variable<>("v3", new Domain<>("C1", "C2"), true, true));
		problem.addVariable(new Variable<>("v4", new Domain<>("D1", "D2"), true, true));
		
		// only maximal partial solutions:
		problem.setMaximumSolutionSize(problem.getVariables().currentSize() - 1);
		problem.setMinimumSolutionSize(1);
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test (all values are independent of each other -> power set minus all full solutions and empty solution):
		Assert.assertEquals(Math.pow(3, problem.getVariables().currentSize()) - 4*4 - 1, solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void twoValuesOnlyMaximalFullCombinationsTest() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		ConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		problem.addVariable(new Variable<>("v1", new Domain<>("A1", "A2"), true, true));
		problem.addVariable(new Variable<>("v2", new Domain<>("B1", "B2"), true, true));
		problem.addVariable(new Variable<>("v3", new Domain<>("C1", "C2"), true, true));
		problem.addVariable(new Variable<>("v4", new Domain<>("D1", "D2"), true, true));
		
		// only maximal partial solutions:
		problem.setMaximumSolutionSize(problem.getVariables().currentSize());
		problem.setMinimumSolutionSize(problem.getVariables().currentSize());
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test (all values are independent of each other -> cross-product -> 4*4 full solution):
		Assert.assertEquals(4*4, solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
	
	@Test
	public void injectiveSolutions() {
		if (PRINT_SOLUTIONS) System.out.println("---------------- STARTING CSP ----------------");
		
		// setup:
		SolutionsCounter<String, String> solutions = new SolutionsCounter<String, String>(PRINT_SOLUTIONS);
		ConstraintSatisfactionProblem<String, String> problem = new ConstraintSatisfactionProblem<String, String>(10);
		
		String a = "A";
		String b = "B";
		String c = "C";
		
		problem.addVariable(new Variable<>("v1", new Domain<>(a, b, c), true, true));
		problem.addVariable(new Variable<>("v2", new Domain<>(a, b, c), true, true));
		
		// only maximal partial solutions:
		problem.setMaximumSolutionSize(problem.getVariables().currentSize());
		problem.setMinimumSolutionSize(problem.getVariables().currentSize());
		problem.setSearchInjectiveSolutions(true);
		
		// solve:
		ICSPSolver<String, String> solver = new CSPSolver<String, String>(problem, solutions);
		solver.run();
		
		// test (3*3 (cross-product) - 3 (non injective solutions: aa, bb, cc)):
		Assert.assertEquals(3*3 - 3, solutions.getCounter(), 0);
		
		if (PRINT_SOLUTIONS) System.out.println();
		if (PRINT_SOLUTIONS) System.out.println("---------------- FINISHED CSP ----------------");
	}
}
