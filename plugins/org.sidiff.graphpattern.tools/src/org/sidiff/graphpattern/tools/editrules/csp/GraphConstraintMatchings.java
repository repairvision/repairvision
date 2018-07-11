package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.csp.solver.ISolutions;
import org.sidiff.csp.solver.impl.domain.Domain;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GraphConstraintMatchings implements ISolutions<NodePattern, NodePattern, GraphConstraintMatch> {

	protected GraphPattern preConstraint;
	
	protected GraphPattern postConstraint;
	
	protected int minimumGraphEditDistance; 
	
	protected List<GraphConstraintMatch> matches = new ArrayList<>();
	
	public GraphConstraintMatchings(GraphPattern preConstraint, GraphPattern postConstraint) {
		super();
		this.preConstraint = preConstraint;
		this.postConstraint = postConstraint;
		reset();
	}

	@Override
	public void add(GraphConstraintMatch match) {
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
	public GraphConstraintMatch createSolution(int size) {
		return new GraphConstraintMatch(preConstraint, postConstraint, size);
	}
	
	public List<GraphConstraintMatch> getMatches() {
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
