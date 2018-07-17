package org.sidiff.graphpattern.profile.henshin.util;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;

import org.sidiff.graphpattern.EdgePattern;
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
}
