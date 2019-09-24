package org.sidiff.graphpattern.tools.editrules.csp;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.tools.csp.AbstractGraphPatternMatchings;
import org.sidiff.graphpattern.tools.editrules.generator.conditions.UnfulfillableConditions;

public class MinGraphEditDistanceMatchings extends AbstractGraphPatternMatchings<MinGraphEditDistanceMatch> {
	
	private boolean checkDangling;
	
	public MinGraphEditDistanceMatchings(GraphPattern subjectGraph, GraphPattern valueGraph, boolean checkDangling) {
		super(subjectGraph, valueGraph);
		this.checkDangling = checkDangling;
	}

	@Override
	public MinGraphEditDistanceMatch createSolution(int size) {
		return new MinGraphEditDistanceMatch(size);
	}
	
	@Override
	public void add(MinGraphEditDistanceMatch match) {
		
		// TODO: Might be optimized? The match size is monotonously decreasing!
		
		// Generate edit rule but just count the changes:
		int graphEditDistance = match.getGraphEditDistance(subjectGraph, valueGraph);
		
		if (graphEditDistance <= 0) {
			return;
		}
		
		// Generate real edit rule:
		if (graphEditDistance <= minimumGraphEditDistance) {
			match.generateEditOperation(subjectGraph, valueGraph);
			
			if (!UnfulfillableConditions.check(match.getEditRule(), checkDangling)) {
				return;
			}
		}
		
		// Store minimal GED matches:
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
