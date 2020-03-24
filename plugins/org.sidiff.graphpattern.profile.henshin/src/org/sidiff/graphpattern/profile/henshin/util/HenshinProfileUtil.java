 package org.sidiff.graphpattern.profile.henshin.util;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.forbid;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.post;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.pre;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.require;

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
	
	public static boolean hasAttributeChanges(NodePattern node) {
		for (AttributePattern contained : node.getAttributes()) {
			if (contained.getStereotypes().contains(delete) || contained.getStereotypes().contains(create)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasChanges(NodePattern node) {
		return hasEdgeChanges(node) || hasAttributeChanges(node);
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
	
	public static boolean isPreserve(Extendable element) {
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
