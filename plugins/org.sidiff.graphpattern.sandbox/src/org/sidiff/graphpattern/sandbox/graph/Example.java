package org.sidiff.graphpattern.sandbox.graph;

import java.util.ArrayList;
import java.util.List;

public class Example {

	private List<Node> patternGraph = new ArrayList<>();
	
	private List<Node> workingGraph = new ArrayList<>();

	public void addPatternGraphNode(Node node) {
		patternGraph.add(node);
		node.setIndex(patternGraph.size() - 1);
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
		node.setIndex(workingGraph.size() - 1);
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

	public List<Node> getWorkingGraph() {
		return workingGraph;
	}
}
