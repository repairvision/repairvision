package org.sidiff.graphpattern.tools.csp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.csp.generic.ISolutions;
import org.sidiff.graphpattern.csp.generic.impl.domain.Domain;

public abstract class AbstractGraphPatternMatchings<M extends GraphPatternMatch> implements ISolutions<NodePattern, NodePattern, M> {

	protected GraphPattern subjectGraph;
	
	protected GraphPattern valueGraph;
	
	protected int minimumGraphEditDistance; 
	
	protected List<M> matches = new ArrayList<>();
	
	public AbstractGraphPatternMatchings(GraphPattern subjectGraph, GraphPattern valueGraph) {
		super();
		this.subjectGraph = subjectGraph;
		this.valueGraph = valueGraph;
		reset();
	}
	
	public GraphPattern getSubjectGraph() {
		return subjectGraph;
	}
	
	public GraphPattern getValueGraph() {
		return valueGraph;
	}

	@Override
	public void add(M match) {
		matches.add(match);
	}

	@Override
	public void reset() {
		matches.clear();
	}

	public List<M> getMatches() {
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
