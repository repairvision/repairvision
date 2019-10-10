 package org.sidiff.graphpattern.profile.henshin.util;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.forbid;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.post;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.pre;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.require;

import java.util.HashSet;
import java.util.Set;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.Extendable;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;

public class HenshinProfileUtil {

	public static boolean hasEdgeChanges(NodePattern node) {
		for (EdgePattern incident : node.getIncident()) {
			if (incident.getStereotypes().contains(delete) || incident.getStereotypes().contains(create)) {
				return true;
			}
		}
		return false;
	}
	
	public static Set<GraphElement> getPostCondition(GraphPattern editRule) {
		Set<GraphElement> postCondition = new HashSet<>();
		
		for (NodePattern node : editRule.getNodes()) {
			getPostCondition(node, postCondition);
		}
		
		return postCondition;
	}
	
	private static void getPostCondition(NodePattern node, Set<GraphElement> postCondition) {

		if (!postCondition.contains(node)) {
			
			// Find first incident edge of post condition, 
			// i.e., a forbid/require edge on a create node. 
			if (isCreate(node)) {
				
				// Search for outgoing conditions on create node:
				for (EdgePattern outgoingEdge : node.getOutgoings()) {
					if (isEditCondition(outgoingEdge)) {
						
						// Post condition found!
						postCondition.add(outgoingEdge);
						
						// Collect post condition sub-graph:
						NodePattern target = outgoingEdge.getTarget();
						
						if (isEditCondition(target)) {
							if (!postCondition.contains(target)) {
								postCondition.add(target);
								getPostCondition(target, postCondition);
							}
						}
					}
				}
				
				// Search for incoming conditions on create node:
				for (EdgePattern incomingEdge : node.getIncomings()) {
					if (isEditCondition(incomingEdge)) {
						
						// Post condition found!
						postCondition.add(incomingEdge);
						
						// Collect post condition sub-graph:
						NodePattern source = incomingEdge.getSource();
						
						if (isEditCondition(source)) {
							if (!postCondition.contains(source)) {
								postCondition.add(source);
								getPostCondition(source, postCondition);
							}
						}
					}
				}
				
				// Collect post condition attributes in create node:
				for (AttributePattern attribute : node.getAttributes()) {
					if (isEditCondition(attribute)) {
						postCondition.add(attribute);
					}
				}
			}
		} else {
			
			// Collect post condition sub-graph:
			for (EdgePattern outgoingEdge : node.getOutgoings()) {
				if (isEditCondition(outgoingEdge)) {
					NodePattern target = outgoingEdge.getTarget();
					
					if (isEditCondition(target)) {
						if (!postCondition.contains(target)) {
							postCondition.add(target);
							getPostCondition(target, postCondition);
						}
					}
				}
			}
			
			for (EdgePattern incomingEdge : node.getIncomings()) {
				if (isEditCondition(incomingEdge)) {
					NodePattern source = incomingEdge.getSource();
					
					if (isEditCondition(source)) {
						if (!postCondition.contains(source)) {
							postCondition.add(source);
							getPostCondition(source, postCondition);
						}
					}
				}
			}
			
			// Collect post condition attributes:
			for (AttributePattern attribute : node.getAttributes()) {
				if (isEditCondition(attribute)) {
					postCondition.add(attribute);
				}
			}
		}
	}
	
	public static boolean hasPostCondition(GraphPattern editRule) {
		for (NodePattern node : editRule.getNodes()) {
			for (EdgePattern edge : node.getOutgoings()) {
				if (isEditCondition(edge)) {
					if (edge.getSource().getStereotypes().contains(create) 
							|| edge.getTarget().getStereotypes().contains(create)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isChange(Extendable element) {
		return element.getStereotypes().contains(delete) || element.getStereotypes().contains(create);
	}
	
	public static Stereotype getChange(Extendable element) {
		for (Stereotype stereotype : element.getStereotypes()) {
			if ((stereotype == delete) || (stereotype == create)) {
				return stereotype;
			}
		}
		return null;
	}
	
	public static boolean isDelete(Extendable element) {
		return element.getStereotypes().contains(delete);
	}
	
	public static boolean isCreate(Extendable element) {
		return element.getStereotypes().contains(create);
	}
	
	public static boolean isContext(Extendable element) {
		return element.getStereotypes().contains(preserve);
	}

	public static boolean isEditCondition(GraphElement graphElement) {
		return isForbid(graphElement)|| isRequire(graphElement);
	}

	public static boolean isRequire(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(require);
	}

	public static boolean isForbid(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(forbid);
	}

	public static boolean isPre(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(pre);
	}

	public static boolean isPost(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(post);
	}
}
