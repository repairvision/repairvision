package org.sidiff.revision.editrules.generation.constructors.util;

import java.util.List;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.tools.csp.AbstractGraphPatternMatchings;
import org.sidiff.revision.editrules.generation.filter.IEditRuleFilter;

public class MinGraphEditDistanceMatchings extends AbstractGraphPatternMatchings<MinGraphEditDistanceMatch> {
	
	private List<IEditRuleFilter> filter;
	
	public MinGraphEditDistanceMatchings(GraphPattern subjectGraph, GraphPattern valueGraph, List<IEditRuleFilter> filter) {
		super(subjectGraph, valueGraph);
		this.filter = filter;
	}

	@Override
	public MinGraphEditDistanceMatch createSolution(int size) {
		return new MinGraphEditDistanceMatch(size);
	}
	
	@Override
	public void add(MinGraphEditDistanceMatch match) {
		
		// TODO: Might be optimized? Always update the minimum match size in the CSP to make the matching monotonously decreasing!?
		
		// Generate edit rule but just count the changes:
		int graphEditDistance = match.getGraphEditDistance(subjectGraph, valueGraph);
		
		if (graphEditDistance <= 0) {
			return;
		}
		
		// Generate real edit rule:
		if (graphEditDistance <= minimumGraphEditDistance) {
			match.generateEditOperation(subjectGraph, valueGraph);
			
			if (IEditRuleFilter.filter(filter, match.getEditOperation(), match.getEditRule(), getCurrentMatches())) {
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
	
	private Iterable<GraphPattern> getCurrentMatches() {
		return () -> matches.stream().map(m -> m.getEditRule()).iterator();
	}

	@Override
	public void reset() {
		minimumGraphEditDistance = Integer.MAX_VALUE;
		matches.clear();
	}
}
