package org.sidiff.consistency.graphpattern.sandbox.graph;

import java.util.ArrayList;
import java.util.List;

public class Match {
	
	private List<Node> match = new ArrayList<>();

	public void addMatch(Node node) {
		match.add(node);
	}
	
	public List<Node> getMatch() {
		return match;
	}

	public void setMatch(List<Node> match) {
		this.match = match;
	}
}
