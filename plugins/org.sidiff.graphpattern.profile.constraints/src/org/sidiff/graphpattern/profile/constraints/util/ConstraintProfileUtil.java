package org.sidiff.graphpattern.profile.constraints.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class ConstraintProfileUtil {

	public static void removeNAC(GraphPattern constraint) {
		for (NodePattern node : new ArrayList<>(constraint.getNodes())) {
			
			if (node.getStereotypes().contains(not)) {
				EcoreUtil.remove(node);
			}
			
			for (AttributePattern attribute : new ArrayList<>(node.getAttributes())) {
				if (attribute.getStereotypes().contains(not)) {
					EcoreUtil.remove(attribute);
				}
			}
			
			for (EdgePattern edge : new ArrayList<>(node.getOutgoings())) {
				if (edge.getStereotypes().contains(not)) {
					EcoreUtil.delete(edge);
				}
			}
		}
	}
}
