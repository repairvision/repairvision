package org.sidiff.consistency.graphpattern.sandbox.io;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;

public class WriteVisualization {

	public static String writeVisualization(String name, Example example, Match match) {
		StringBuffer viz = new StringBuffer();
		
		// Header:
		viz.append("graph " + name + " {\n");
		viz.append("\n");
		viz.append("	compound=true;\n");
		viz.append("\n");
		
		// Pattern-Node:
		Map<Node, String> patternCluster = new HashMap<>();
		Map<Node, String> patternNodeAnchor = new HashMap<>();
		
		for (int i = 0; i < example.getPatternGraph().size(); i++) {
			Node patternNode = example.getPatternGraph().get(i);
			String patternClusterName = "cluster" + i;
			patternCluster.put(patternNode, patternClusterName);
			
			viz.append("	subgraph " + patternClusterName + " {\n");
			viz.append("		node [style=filled, shape=circle, color=white, height=0.02, width=0.01, margin=0.0];\n");
			viz.append("\n");
			viz.append("		style=filled;\n");
			viz.append("		color=lightgrey;\n");
			viz.append("\n");
			viz.append("		fontcolor=white;\n");
			viz.append("		fontname=bold;\n");
			viz.append("		fontsize=10;\n");
			viz.append("\n");
			viz.append("		label=\"" + patternNode.getName() + "\";\n");
			viz.append("\n");
			
			// Mapped-Nodes:
			String anchorNodeName = null;
			
			for (Node workingNode : example.getWorkingGraph()) {
				if (workingNode.getLabel() == patternNode) {
					anchorNodeName = workingNode.getName();
					
					viz.append("		" + workingNode.getName());
					
					if (match.getMatch().contains(workingNode)) {
						viz.append(" [color=royalblue];");
					} else {
						viz.append(";\n");
					}
				}
			}
			
			// create invisible pseudo anchor node:
			if (anchorNodeName == null) {
				anchorNodeName = patternClusterName;
				viz.append("		" + anchorNodeName + " [style=invis, label=\"\", height=0.02, width=0.01];\n");
			}
			
			patternNodeAnchor.put(patternNode, anchorNodeName);
			
			viz.append("	}\n");
			viz.append("\n");
		}
		
		// Pattern-Edges:
		Set<String> patternEdges = new HashSet<>();
		
		for (Node patternNode : example.getPatternGraph()) {
			for (Node adjacentPatternNode : patternNode.getAdjacent()) {
				String edge = patternNodeAnchor.get(patternNode) + " -- " + patternNodeAnchor.get(adjacentPatternNode);
				
				if (!patternEdges.contains(edge)) {
					String oppositeEdge = patternNodeAnchor.get(adjacentPatternNode) + " -- " + patternNodeAnchor.get(patternNode) ;
					patternEdges.add(edge);
					patternEdges.add(oppositeEdge);

					viz.append("	" + edge + " [ltail=" + patternCluster.get(patternNode) + ", lhead="
							+ patternCluster.get(adjacentPatternNode) + ", penwidth=2, color=lightgrey];\n");
				}
			}
		}
		
		// Node-Edges:
		Set<String> workingEdges = new HashSet<>();
		
		for (Node workingNode : example.getWorkingGraph()) {
			for (Node adjacentWorkingNode : workingNode.getAdjacent()) {
				String edge = workingNode.getName() + " -- " + adjacentWorkingNode.getName();
				
				if (!workingEdges.contains(edge)) {
					String oppositeEdge = adjacentWorkingNode.getName() + " -- " + workingNode.getName() ;
					workingEdges.add(edge);
					workingEdges.add(oppositeEdge);
					
					viz.append("	" + edge + ";\n");
				}
			}
		}
		
		// Footer:
		viz.append("}\n");
		
		return viz.toString();
	}
}
