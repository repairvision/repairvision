package org.sidiff.graphpattern.tools.editrules;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public class EditRuleGeneratorUtil {
	
	public static boolean isTypeEqual(List<NodePattern> nodesA, List<NodePattern> nodesB) {
		if (nodesA.size() == nodesB.size()) {
			Set<NodePattern> remainingB = new HashSet<>(nodesB);
			
			for (NodePattern nodePatternA : nodesA) {
				NodePattern match = null;
				
				for (NodePattern nodePatternB : remainingB) {
					if (nodePatternA.getType().equals(nodePatternB.getType())) {
						match = nodePatternB;
						break;
					}
				}
				
				if (match != null) {
					remainingB.remove(match);
				} else {
					return false;
				}
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public static AttributePattern getAttributeMatch(Map<NodePattern, NodePattern> lhsToRhsMatch, AttributePattern lhsAttribute) {
		NodePattern lhsNode = lhsAttribute.getNode();
		NodePattern rhsNode = lhsToRhsMatch.get(lhsNode);
		
		if (rhsNode != null) {
			return rhsNode.getAttribute(lhsAttribute.getType());
		}
		
		return null;
	}
	
	public static EdgePattern getEdgeMatch(Map<NodePattern, NodePattern> lhsToRhsMatch, EdgePattern lhsEdge) {
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
