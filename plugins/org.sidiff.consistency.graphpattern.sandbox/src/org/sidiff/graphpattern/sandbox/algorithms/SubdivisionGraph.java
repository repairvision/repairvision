package org.sidiff.graphpattern.sandbox.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.sidiff.graphpattern.sandbox.graph.Example;
import org.sidiff.graphpattern.sandbox.graph.Match;
import org.sidiff.graphpattern.sandbox.graph.Node;

public class SubdivisionGraph {

	private Example example;
	
	private Example subdivisionExample;
	
	private Map<Node, Node> nodeTrace = new HashMap<>();
	
	private Map<String, Node> edgeTrace = new HashMap<>();
	
	public SubdivisionGraph(Example example) {
		this.example = example;
		this.subdivisionExample = new Example();
		
		translate(example.getPatternGraph(), subdivisionExample.getPatternGraph());
		translate(example.getWorkingGraph(), subdivisionExample.getWorkingGraph());
	}
	
	private void translate(List<Node> graph, List<Node> subdivisionGraph) {
		
		for (Node node : graph) {
			Node sdNode = nodeTrace.get(node); 
			
			if (sdNode == null) {
				sdNode = new Node(node.getName());
				nodeTrace.put(node, sdNode);
				
				subdivisionGraph.add(sdNode);
				sdNode.setIndex(subdivisionGraph.size() - 1);
				
				if (node.getLabel() != null) {
					sdNode.setLabel(nodeTrace.get(node.getLabel()));
				}
			}
			
			for (Node adjacent : node.getAdjacent()) {
				Node sdAdjacent = nodeTrace.get(adjacent);
				
				if (sdAdjacent == null) {
					sdAdjacent =  new Node(adjacent.getName());
					nodeTrace.put(adjacent, sdAdjacent);
					
					subdivisionGraph.add(sdAdjacent);
					sdAdjacent.setIndex(subdivisionGraph.size() - 1);
					
					if (adjacent.getLabel() != null) {
						sdAdjacent.setLabel(nodeTrace.get(adjacent.getLabel()));
					}
				}
				
				// Replace edge with node:
				Node edgeNode = edgeTrace.get(adjacent.getName() + node.getName());
				
				if (edgeNode == null) {
					edgeNode = new Node(node.getName() + adjacent.getName());
					edgeTrace.put(edgeNode.getName(), edgeNode);
					
					edgeNode.addAdjacent(sdNode);
					edgeNode.addAdjacent(sdAdjacent);
					
					subdivisionGraph.add(edgeNode);
					edgeNode.setIndex(subdivisionGraph.size() - 1);
					
					if ((node.getLabel() != null) && (adjacent.getLabel() != null)) {
						// Set label:
						Node edgeLabel = edgeTrace.get(node.getLabel().getName() + adjacent.getLabel().getName());
						
						if (edgeLabel == null) {
							edgeLabel = edgeTrace.get(adjacent.getLabel().getName() + node.getLabel().getName());
						}
						
						edgeNode.setLabel(edgeLabel);
					}
				}
			}
		}
	}
	
	public List<Match> translate(List<Match> subdivisionMatching) {
		List<Match> graphMatching = new ArrayList<>(subdivisionMatching.size());
		Map<Node, Node> nodeTrace = new HashMap<>();
		
		for (Entry<Node, Node> traceEntry : this.nodeTrace.entrySet()) {
			nodeTrace.put(traceEntry.getValue(), traceEntry.getKey());
		}
		
		for (Match subdivisionMatch : subdivisionMatching) {
			graphMatching.add(translate(subdivisionMatch, nodeTrace));
		}
		
		return graphMatching;
	}
	
	private Match translate(Match subdivisionMatch, Map<Node, Node> nodeTrace) {
		Match graphMatch = new Match();
		
		for (Node sdNode : subdivisionMatch.getMatch()) {
			Node node = nodeTrace.get(sdNode);
			
			// null -> edge
			if (node != null) {
				graphMatch.addMatch(node);
			}
		}
		
		return graphMatch;
	}

	public Example getExample() {
		return example;
	}

	public Example getSubdivisionExample() {
		return subdivisionExample;
	}

	public Map<Node, Node> getTrace() {
		return nodeTrace;
	}
}
