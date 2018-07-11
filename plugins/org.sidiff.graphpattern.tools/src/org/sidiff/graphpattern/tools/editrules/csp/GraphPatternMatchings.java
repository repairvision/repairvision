package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.csp.solver.Solutions;
import org.sidiff.csp.solver.impl.domain.DomainImpl;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GraphPatternMatchings implements Solutions<NodePattern, NodePattern, GraphPatternMatch> {

	protected GraphPattern lhsGraph;
	
	protected GraphPattern rhsGraph;
	
	protected int minimumGraphEditDistance; 
	
	protected List<GraphPatternMatch> matches = new ArrayList<>();
	
	public GraphPatternMatchings(GraphPattern lhsGraph, GraphPattern rhsGraph) {
		super();
		this.lhsGraph = lhsGraph;
		this.rhsGraph = rhsGraph;
		reset();
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

	@Override
	public GraphPatternMatch createSolution(int size) {
		return new GraphPatternMatch(lhsGraph, rhsGraph, size);
	}
	
	public List<GraphPatternMatch> getMatches() {
		return matches;
	}
	
	public static DomainImpl<NodePattern> getDomain(NodePattern node, List<NodePattern> values) {
		DomainImpl<NodePattern> domain = new DomainImpl<NodePattern>();
		
		for (NodePattern value : values) {
			if (node.getType().equals(value.getType())) {
				domain.add(value);
			}
		}
		
		return domain;
	}
}
