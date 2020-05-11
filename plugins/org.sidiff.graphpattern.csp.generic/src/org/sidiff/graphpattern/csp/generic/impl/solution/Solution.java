package org.sidiff.graphpattern.csp.generic.impl.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.sidiff.graphpattern.csp.generic.ISolution;

public class Solution<R, D> implements ISolution<R, D> {

	protected Object[][] assignment;
	
	protected int pointer = 0;
	
	public Solution(int size) {
		this.assignment = new Object[size][2];
	}
	
	@Override
	public void store(R subject, D value) {
		assignment[pointer][0] = subject;
		assignment[pointer][1] = value;
		++pointer;
	}
	
	@SuppressWarnings("unchecked")
	public void forEach(BiConsumer<R, D> action) {
		for (int i = 0; i < assignment.length; i++) {
			action.accept((R) assignment[i][0], (D) assignment[i][1]);
		}
	}
	
	public Map<R, D> getAssignmentMapping() {
		Map<R, D> assignmentMapping = new HashMap<>();
		forEach(assignmentMapping::put);
		return assignmentMapping;
	}
	
	public Object[][] getAssignment() {
		return assignment;
	}

	public int size() {
		return assignment.length;
	}
}
