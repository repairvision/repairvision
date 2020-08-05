package org.sidiff.graphpattern.profile.constraints.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.constraint;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.exists;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.forall;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.Extendable;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.revision.common.emf.ModelingUtil;

public class ConstraintProfileUtil {

	public static void removeNAC(GraphPattern constraint) {
		for (NodePattern node : new ArrayList<>(constraint.getNodes())) {

			for (EdgePattern edge : new ArrayList<>(node.getOutgoings())) {
				if (edge.getStereotypes().contains(not)) {
					node.removeEdge(edge);
				}
			}

			for (AttributePattern attribute : new ArrayList<>(node.getAttributes())) {
				if (attribute.getStereotypes().contains(not)) {
					EcoreUtil.remove(attribute);
				}
			}

			if (node.getStereotypes().contains(not)) {
				EcoreUtil.remove(node);
			}
		}
	}

	public static boolean isCondition(GraphElement graphElement) {
		return isNot(graphElement) || isExists(graphElement) || isForAll(graphElement);
	}

	public static boolean isPositiveCondition(GraphElement graphElement) {
		return isExists(graphElement) || isForAll(graphElement);
	}

	public static boolean isNegativeCondition(GraphElement graphElement) {
		return isNot(graphElement);
	}

	public static boolean isNot(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(not);
	}

	public static boolean isExists(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(exists);
	}

	public static boolean isForAll(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(forall);
	}
	
	public static boolean isConstraint(Extendable element) {
		return element.getStereotypes().contains(constraint);
	}
	
	public static Pattern getParentConstraint(EObject element) {
		for (EObject parent : (Iterable<EObject>) () -> ModelingUtil.getRootPath(element)) {
			if (parent instanceof Pattern) {
				if (isConstraint((Pattern) parent)) {
					return (Pattern) parent;
				}
			}
		}
		return null;
	}
}
