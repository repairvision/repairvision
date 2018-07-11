package org.sidiff.graphpattern.tools.editrules;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	
	public static AttributePattern getAttributeMatch(Map<NodePattern, NodePattern> proToPostMatch, AttributePattern postAttribute) {
		NodePattern preNode = postAttribute.getNode();
		NodePattern postNode = proToPostMatch.get(preNode);
		
		if (postNode != null) {
			return postNode.getAttribute(postAttribute.getType());
		}
		
		return null;
	}
	
	public static EdgePattern getEdgeMatch(Map<NodePattern, NodePattern> preToPostMatch, EdgePattern preEdge) {
		NodePattern preSourceNode = preEdge.getSource();
		NodePattern preTargetNode = preEdge.getTarget();
		NodePattern postSourceNode = preToPostMatch.get(preSourceNode);
		NodePattern postTargetNode = preToPostMatch.get(preTargetNode);
		
		if ((postSourceNode != null) && (postTargetNode != null)) {
			for (EdgePattern postEdge : postSourceNode.getOutgoings(preEdge.getType())) {
				if (postEdge.getTarget() == postTargetNode) {
					return postEdge;
				}
			}
		}
		
		return null;
	}
	
	public static Map<EdgePattern, EdgePattern> getEdgeMatching(Map<NodePattern, NodePattern> preToPostNodeMatch) {
		Map<EdgePattern, EdgePattern> preToPostEdgeMatch = new HashMap<>();
		
		for (Entry<NodePattern, NodePattern> matched : preToPostNodeMatch.entrySet()) {
			NodePattern preSourceNode = matched.getKey();
			NodePattern postSourceNode = matched.getValue();
			
			for (EdgePattern preOutgoing : preSourceNode.getOutgoings()) {
				NodePattern preTargetNode = preOutgoing.getTarget();
				NodePattern postTargetNode = preToPostNodeMatch.get(preTargetNode);
				
				if (postTargetNode != null) {
					for (EdgePattern postOutgoing : postSourceNode.getOutgoings()) {
						if (postOutgoing.getType() == preOutgoing.getType()) {
							if (postOutgoing.getTarget() == postTargetNode) {
								preToPostEdgeMatch.put(preOutgoing, postOutgoing);
								break;
							}
						}
					}
				}
			}
		}
		
		return preToPostEdgeMatch;
	}
}
