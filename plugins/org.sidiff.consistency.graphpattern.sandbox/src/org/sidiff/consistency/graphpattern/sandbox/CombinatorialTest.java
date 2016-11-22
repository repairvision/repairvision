package org.sidiff.consistency.graphpattern.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinatorialTest {

	private static LinkedList<Integer> variables = new LinkedList<>();
	
	private static List<List<Integer>> domains = new ArrayList<>();
	
	private static List<Integer> assignment = new ArrayList<>();
	
	private static int solutions = 0;
	
	public static void main(String[] args) {
		
		// Variables:
		variables.add(0);
		variables.add(1);
		variables.add(2);
//		variables.add(3);
//		variables.add(4);
		
		// Domains:
		setDomain(0, new Integer[] {0,1});
		setDomain(1, new Integer[] {0,1});
		setDomain(2, new Integer[] {0,1});
//		setDomain(3, new Integer[] {0,1});
//		setDomain(4, new Integer[] {0,1});
		
		for (int i = 0; i < variables.size(); ++i) {
			assignment.add(null);
		}
		
		expandAssignment(0);
		System.out.println("Solutions: " + solutions);
	}
	
	private static void expandAssignment(int variable) {
		
		if (variable < variables.size()) {
			List<Integer> domain = domains.get(variable);
			
			for (Integer value : domain) {
				assignment.set(variable, value);
				expandAssignment(variable + 1);
			}
			
			assignment.set(variable, null);
			expandAssignment(variable + 1);
		} else {
			++solutions;
			System.out.println(assignment);
		}
	}
	
	public static void setDomain(int variable, Integer[] values) {
		domains.add(variable, Arrays.asList(values));
	}
}
