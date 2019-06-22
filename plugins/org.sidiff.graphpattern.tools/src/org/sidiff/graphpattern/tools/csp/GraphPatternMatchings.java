package org.sidiff.graphpattern.tools.csp;

import org.sidiff.graphpattern.GraphPattern;

public class GraphPatternMatchings extends AbstractGraphPatternMatchings<GraphPatternMatch>{

	public GraphPatternMatchings(GraphPattern subjectGraph, GraphPattern valueGraph) {
		super(subjectGraph, valueGraph);
	}

	@Override
	public GraphPatternMatch createSolution(int size) {
		return new GraphPatternMatch(size);
	}
}
