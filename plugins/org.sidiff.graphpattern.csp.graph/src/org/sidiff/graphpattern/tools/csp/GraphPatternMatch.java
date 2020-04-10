package org.sidiff.graphpattern.tools.csp;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.csp.generic.ISolution;

public class GraphPatternMatch implements ISolution<NodePattern, NodePattern> {

	protected Map<NodePattern, NodePattern> subjectNodeToValueNodeMatch;
	
	public GraphPatternMatch(int size) {
		this.subjectNodeToValueNodeMatch = new HashMap<NodePattern, NodePattern>((int) ((float) size / 0.75f + 1.0f));
	}
	
	@Override
	public void store(NodePattern subject, NodePattern value) {
		subjectNodeToValueNodeMatch.put(subject, value);
	}
	
	public Map<NodePattern, NodePattern> getMatch() {
		return subjectNodeToValueNodeMatch;
	}

	public int size() {
		return subjectNodeToValueNodeMatch.size();
	}
}
