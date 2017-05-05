package org.sidiff.editrule.partialmatcher.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionEdge;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class RecognitionPattern {
	
	protected Map<Node, ActionNode> nodeTrace = new HashMap<>();
	
	protected Map<Edge, ActionEdge> edgeTrace = new HashMap<>();

	protected GraphPattern graphPattern;
	
	protected List<NodePattern> changeNodePatterns = new ArrayList<>();
	
	protected List<NodePattern> graphNodePatterns = new ArrayList<>();
	
	protected Map<NodePattern, ChangePattern> changePatterns = new HashMap<>();
	
	public RecognitionPattern(GraphPattern graphPattern) {
		this.graphPattern = graphPattern; 
	}
	
	public Map<Node, ActionNode> getNodeTrace() {
		return nodeTrace;
	}
	
	public Map<Edge, ActionEdge> getEdgeTrace() {
		return edgeTrace;
	}
	
	public void addChangePattern(NodePattern changeNodePattern, ChangePattern changePattern) {
		changeNodePatterns.add(changeNodePattern);
		changePatterns.put(changeNodePattern, changePattern);
		graphPattern.getNodes().add(changeNodePattern);
	}
	
	public void addGraphNodePattern(NodePattern graphNodePattern) {
		if (graphNodePattern != null) {
			graphNodePatterns.add(graphNodePattern);
			graphPattern.getNodes().add(graphNodePattern);
		}
	}

	public GraphPattern getGraphPattern() {
		return graphPattern;
	}

	public List<NodePattern> getChangeNodePatterns() {
		return changeNodePatterns;
	}

	public List<NodePattern> getGraphNodePatterns() {
		return graphNodePatterns;
	}

	public ChangePattern getChangePattern(NodePattern nodePattern) {
		return changePatterns.get(nodePattern);
	}
}
