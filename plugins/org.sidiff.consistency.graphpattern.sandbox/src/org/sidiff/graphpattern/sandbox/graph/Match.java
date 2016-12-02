package org.sidiff.graphpattern.sandbox.graph;

import java.util.ArrayList;
import java.util.Collection;
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
	
	public static Match getMaxMatch(Collection<Match> matchings) {
		Match maxMatch = new Match();
		
		for (Match match : matchings) {
			if (match.getMatch().size() > maxMatch.getMatch().size()) {
				maxMatch = match;
			}
		}
		
		return maxMatch;
	}
}
