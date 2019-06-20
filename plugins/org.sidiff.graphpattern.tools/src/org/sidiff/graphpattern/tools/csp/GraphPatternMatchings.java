package org.sidiff.graphpattern.tools.csp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.sidiff.csp.solver.ISolutions;
import org.sidiff.csp.solver.impl.domain.Domain;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GraphPatternMatchings implements ISolutions<NodePattern, NodePattern, GraphPatternMatch> {

	protected GraphPattern graphPatternA;
	
	protected GraphPattern graphPatternB;
	
	protected int minimumGraphEditDistance; 
	
	protected List<GraphPatternMatch> matches = new ArrayList<>();
	
	public GraphPatternMatchings(GraphPattern graphPatternA, GraphPattern graphPatternB) {
		super();
		this.graphPatternA = graphPatternA;
		this.graphPatternB = graphPatternB;
		reset();
	}

	@Override
	public void add(GraphPatternMatch match) {
		matches.add(match);
	}

	@Override
	public void reset() {
		matches.clear();
	}

	@Override
	public GraphPatternMatch createSolution(int size) {
		return new GraphPatternMatch(graphPatternA, graphPatternB, size);
	}
	
	public List<GraphPatternMatch> getMatches() {
		return matches;
	}
	
	public static Domain<NodePattern> getDomain(NodePattern node, List<NodePattern> values) {
		return getDomain(node, values, n -> true);
	}
	
	public static Domain<NodePattern> getDomain(NodePattern node, List<NodePattern> values, Predicate<NodePattern> predicate) {
		Domain<NodePattern> domain = new Domain<NodePattern>();
		
		for (NodePattern  value : values) {
			if (node.getType().equals(value.getType()) && predicate.test(value)) {
				domain.add(value);
			}
		}
		
		return domain;
	}
}
