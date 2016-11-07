package org.sidiff.consistency.graphpattern.sandbox.graph;

import java.util.ArrayList;
import java.util.List;

public class Example {

	private List<Node> patternGraph = new ArrayList<>();
	
	private List<Node> workingGraph = new ArrayList<>();

	public void addPatternGraphNode(Node node) {
		patternGraph.add(node);
	}
	
	public Node getPatternGraphNode(String name) {
		for (Node patternNode : patternGraph) {
			if (patternNode.getName().equals(name)) {
				return patternNode;
			}
		}
		return null;
	}
	
	public void addWorkingGraphNode(Node node) {
		workingGraph.add(node);
	}
	
	public Node getWorklingGraphNode(String name) {
		for (Node workingNode : workingGraph) {
			if (workingNode.getName().equals(name)) {
				return workingNode;
			}
		}
		return null;
	}
	
	public List<Node> getPatternGraph() {
		return patternGraph;
	}

	public void setPatternGraph(List<Node> pattern) {
		this.patternGraph = pattern;
	}

	public List<Node> getWorkingGraph() {
		return workingGraph;
	}

	public void setWorkingGraph(List<Node> workingGraph) {
		this.workingGraph = workingGraph;
	}
}
