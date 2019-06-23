package org.sidiff.graphpattern.profile.henshin.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.Extendable;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class HenshinProfileUtil {

	public static boolean hasEdgeChanges(NodePattern node) {
		for (EdgePattern incident : node.getIncident()) {
			if (incident.getStereotypes().contains(delete) || incident.getStereotypes().contains(create)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasPostCondition(GraphPattern editRule) {
		for (NodePattern node : editRule.getNodes()) {
			for (EdgePattern edge : node.getOutgoings()) {
				if (edge.getStereotypes().contains(not)) {
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
	
	public static boolean isDelete(Extendable element) {
		return element.getStereotypes().contains(delete);
	}
	
	public static boolean isCreate(Extendable element) {
		return element.getStereotypes().contains(create);
	}
	
	public static boolean isContext(Extendable element) {
		return element.getStereotypes().contains(preserve);
	}
}
