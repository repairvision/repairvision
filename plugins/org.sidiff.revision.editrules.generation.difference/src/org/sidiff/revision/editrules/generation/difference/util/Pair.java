package org.sidiff.revision.editrules.generation.difference.util;

public class Pair<GraphElement> {

	private GraphElement lhs;
	
	private GraphElement rhs;
	
	public Pair(GraphElement lhs, GraphElement rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public GraphElement getLhs() {
		return lhs;
	}

	public GraphElement getRhs() {
		return rhs;
	}

}
