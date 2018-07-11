package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.sidiff.csp.solver.impl.solution.Solution;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GraphPatternMatch extends Solution<NodePattern, NodePattern> {

	protected GraphPattern lhsGraph;
	
	protected GraphPattern rhsGraph;
	
	public GraphPatternMatch(GraphPattern lhsGraph, GraphPattern rhsGraph, int size) {
		super(size);
		this.lhsGraph = lhsGraph;
		this.rhsGraph = rhsGraph;
	}

	public int getGraphEditDistance() {
		
		// nodes:
		int deletedNodes = Math.abs(lhsGraph.getNodes().size() - size());
		int createdNodes = Math.abs(rhsGraph.getNodes().size() - size());
		
		// edges:
		int deletedEdges = 0;
		int createdEdges = 0;
		
		Map<NodePattern, NodePattern> lhsToRhsMatch = getAssignmentMapping();
		
		for (Entry<NodePattern, NodePattern> lhsToRhsMatched : lhsToRhsMatch.entrySet()) {
			NodePattern lhsNode = lhsToRhsMatched.getKey();
			NodePattern rhsNode = lhsToRhsMatched.getValue();
			
			List<EdgePattern> rhsMatchedEdges = new ArrayList<>();
			
			for (EdgePattern lhsEdge : lhsNode.getOutgoings()) {
				EdgePattern rhsEdge = getEdgeMatch(lhsToRhsMatch, lhsEdge);
				
				if (rhsEdge != null) {
					rhsMatchedEdges.add(rhsEdge);
				} else {
					++deletedEdges;
				}
			}
			
			for (EdgePattern rhsEdge : rhsNode.getOutgoings()) {
				if (!rhsMatchedEdges.contains(rhsEdge)) {
					++createdEdges;
				}
			}
		}
		
		// attributes:
		int attributeValueChanges = 0;
		
		for (Entry<NodePattern, NodePattern> lhsToRhsMatched : lhsToRhsMatch.entrySet()) {
			NodePattern lhsNode = lhsToRhsMatched.getKey();
		
			for (AttributePattern lhsAttribute : lhsNode.getAttributes()) {
				AttributePattern rhsAttribute = getAttributeMatch(lhsToRhsMatch, lhsAttribute);
				
				if (rhsAttribute != null) {
					if (!lhsAttribute.getValue().equals(rhsAttribute.getValue())) {
						++attributeValueChanges;
					}
				}
			}
		}
		
		int editDistance = deletedNodes + createdNodes + deletedEdges + createdEdges + attributeValueChanges;
		return editDistance;
	}
	
	public AttributePattern getAttributeMatch(Map<NodePattern, NodePattern> lhsToRhsMatch, AttributePattern lhsAttribute) {
		NodePattern lhsNode = lhsAttribute.getNode();
		NodePattern rhsNode = lhsToRhsMatch.get(lhsNode);
		
		if (rhsNode != null) {
			return rhsNode.getAttribute(lhsAttribute.getType());
		}
		
		return null;
	}
	
	public EdgePattern getEdgeMatch(Map<NodePattern, NodePattern> lhsToRhsMatch, EdgePattern lhsEdge) {
		NodePattern lhsSourceNode = lhsEdge.getSource();
		NodePattern lhsTargetNode = lhsEdge.getTarget();
		NodePattern rhsSourceNode = lhsToRhsMatch.get(lhsSourceNode);
		NodePattern rhsTargetNode = lhsToRhsMatch.get(lhsTargetNode);
		
		if ((rhsSourceNode != null) && (rhsTargetNode != null)) {
			for (EdgePattern rhsEdge : rhsSourceNode.getOutgoings(lhsEdge.getType())) {
				if (rhsEdge.getTarget() == rhsTargetNode) {
					return rhsEdge;
				}
			}
		}
		
		return null;
	}
}
