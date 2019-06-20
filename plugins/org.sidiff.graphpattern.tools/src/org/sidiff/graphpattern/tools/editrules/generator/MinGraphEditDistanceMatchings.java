package org.sidiff.graphpattern.tools.editrules.generator;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatch;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatchings;

public class MinGraphEditDistanceMatchings extends GraphPatternMatchings {

	public MinGraphEditDistanceMatchings(GraphPattern graphPatternA, GraphPattern graphPatternB) {
		super(graphPatternA, graphPatternB);
	}
	
	@Override
	public void add(GraphPatternMatch match) {
		int graphEditDistance = match.getGraphEditDistance();
		
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
