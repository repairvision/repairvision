package org.sidiff.graphpattern.tools.editrules.csp;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.tools.csp.AbstractGraphPatternMatchings;

public class MinGraphEditDistanceMatchings extends AbstractGraphPatternMatchings<MinGraphEditDistanceMatch> {
	
	public MinGraphEditDistanceMatchings(GraphPattern subjectGraph, GraphPattern valueGraph) {
		super(subjectGraph, valueGraph);
	}

	@Override
	public MinGraphEditDistanceMatch createSolution(int size) {
		return new MinGraphEditDistanceMatch(size);
	}
	
	@Override
	public void add(MinGraphEditDistanceMatch match) {
		int graphEditDistance = match.getGraphEditDistance(subjectGraph, valueGraph);
		
		if (graphEditDistance <= 0) {
			return;
		}
		
		if (graphEditDistance < minimumGraphEditDistance) {
			minimumGraphEditDistance = graphEditDistance;
			matches.clear();
		} 
		
		if (graphEditDistance == minimumGraphEditDistance) {
			matches.add(match);
		}
	}

	@Override
	public void reset() {
		minimumGraphEditDistance = Integer.MAX_VALUE;
		matches.clear();
	}
}
