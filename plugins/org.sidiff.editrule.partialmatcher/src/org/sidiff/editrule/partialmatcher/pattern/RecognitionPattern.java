package org.sidiff.editrule.partialmatcher.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionEdge;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class RecognitionPattern {
	
	protected Rule editRule;
	
	protected Map<Node, ActionNode> nodeTrace = new HashMap<>();
	
	protected Map<Edge, ActionEdge> edgeTrace = new HashMap<>();

	protected GraphPattern recognitionPattern;
	
	protected List<NodePattern> changeNodePatterns = new ArrayList<>();
	
	protected List<NodePattern> graphNodePatterns = new ArrayList<>();
	
	protected Map<NodePattern, ChangePattern> changePatterns = new HashMap<>();
	
	public RecognitionPattern(Rule editRule, GraphPattern recognitionPattern) {
		this.editRule = editRule;
		this.recognitionPattern = recognitionPattern; 
	}
	
	public Rule getEditRule() {
		return editRule;
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
		recognitionPattern.getNodes().add(changeNodePattern);
	}
	
	public void addGraphNodePattern(NodePattern graphNodePattern) {
		if (graphNodePattern != null) {
			graphNodePatterns.add(graphNodePattern);
			recognitionPattern.getNodes().add(graphNodePattern);
		}
	}

	public GraphPattern getGraphPattern() {
		return recognitionPattern;
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
