package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.sidiff.csp.solver.ISolution;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.tools.editrules.EditRuleGeneratorUtil;

public class GraphPatternMatch implements ISolution<NodePattern, NodePattern> {

	protected GraphPattern lhsGraph;
	
	protected GraphPattern rhsGraph;
	
	protected Map<NodePattern, NodePattern> lhsToRhsMatch;
	
	public GraphPatternMatch(GraphPattern lhsGraph, GraphPattern rhsGraph, int size) {
		this.lhsGraph = lhsGraph;
		this.rhsGraph = rhsGraph;
		this.lhsToRhsMatch = new HashMap<NodePattern, NodePattern>((int) ((float) size / 0.75f + 1.0f));
	}
	
	public GraphPattern getLhsGraph() {
		return lhsGraph;
	}
	
	public GraphPattern getRhsGraph() {
		return rhsGraph;
	}
	
	@Override
	public void store(NodePattern subject, NodePattern value) {
		lhsToRhsMatch.put(subject, value);
	}
	
	public int getGraphEditDistance() {
		
		// nodes:
		int deletedNodes = Math.abs(lhsGraph.getNodes().size() - size());
		int createdNodes = Math.abs(rhsGraph.getNodes().size() - size());
		
		// edges:
		int deletedEdges = 0;
		int createdEdges = 0;
		
		for (Entry<NodePattern, NodePattern> lhsToRhsMatched : lhsToRhsMatch.entrySet()) {
			NodePattern lhsNode = lhsToRhsMatched.getKey();
			NodePattern rhsNode = lhsToRhsMatched.getValue();
			
			List<EdgePattern> rhsMatchedEdges = new ArrayList<>();
			
			for (EdgePattern lhsEdge : lhsNode.getOutgoings()) {
				EdgePattern rhsEdge = EditRuleGeneratorUtil.getEdgeMatch(lhsToRhsMatch, lhsEdge);
				
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
				AttributePattern rhsAttribute = EditRuleGeneratorUtil.getAttributeMatch(lhsToRhsMatch, lhsAttribute);
				
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
	
	public Map<NodePattern, NodePattern> getLhsToRhsMatch() {
		return lhsToRhsMatch;
	}

	public int size() {
		return lhsToRhsMatch.size();
	}
}
