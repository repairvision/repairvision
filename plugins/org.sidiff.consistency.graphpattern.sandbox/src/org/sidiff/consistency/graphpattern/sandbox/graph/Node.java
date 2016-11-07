package org.sidiff.consistency.graphpattern.sandbox.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name = "";
	
	private Node label;
	
	private List<Node> adjacent = new ArrayList<>();

	public Node(String name) {
		super();
		this.name = name;
	}
	
	public Node(String name, Node label) {
		super();
		this.name = name;
		this.label = label;
	}

	public void addAdjacent(Node node) {
		if (!adjacent.contains(node)) {
			adjacent.add(node);
			node.addAdjacent(this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(List<Node> adjacent) {
		this.adjacent = adjacent;
	}

	public Node getLabel() {
		return label;
	}

	public void setLabel(Node label) {
		this.label = label;
	}
	
}
