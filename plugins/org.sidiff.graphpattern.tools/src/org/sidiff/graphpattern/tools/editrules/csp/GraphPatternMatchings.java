package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.csp.solver.ISolutions;
import org.sidiff.csp.solver.impl.domain.Domain;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GraphPatternMatchings implements ISolutions<NodePattern, NodePattern, GraphPatternMatch> {

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
	
	public static Domain<NodePattern> getDomain(NodePattern node, List<NodePattern> values) {
		Domain<NodePattern> domain = new Domain<NodePattern>();
		
		for (NodePattern value : values) {
			if (node.getType().equals(value.getType())) {
				domain.add(value);
			}
		}
		
		return domain;
	}
}
