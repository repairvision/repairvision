package org.sidiff.graphpattern.tools.editrules.csp;

import org.sidiff.csp.solver.impl.solution.SolutionImpl;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GraphPatternMatch extends SolutionImpl<NodePattern, NodePattern> {

	protected GraphPattern lhsGraph;
	
	protected GraphPattern rhsGraph;
	
	public GraphPatternMatch(GraphPattern lhsGraph, GraphPattern rhsGraph, int size) {
		super(size);
		this.lhsGraph = lhsGraph;
		this.rhsGraph = rhsGraph;
	}

	public int getGraphEditDistance() {
		int deletedNodes = Math.abs(lhsGraph.getNodes().size() - size());
		int createdNodes = Math.abs(rhsGraph.getNodes().size() - size());
		
		int editDistance = deletedNodes + createdNodes;
		return editDistance;
	}
}
