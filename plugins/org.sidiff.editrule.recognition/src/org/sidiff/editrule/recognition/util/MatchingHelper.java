package org.sidiff.editrule.recognition.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class MatchingHelper {

	private ICrossReferencer crossReferencer;
	
	/**
	 * Initializes a new matching helper.
	 * 
	 * @param crossReferencer
	 *            The generic or domain specific cross-reference calculator.
	 */
	public MatchingHelper(ICrossReferencer crossReferencer) {
		this.crossReferencer = crossReferencer;
	}

	/**
	 * @param object
	 *            The source object.
	 * @param edge
	 *            The edge of the source object.
	 * @return An unmodifiable list of target objects.
	 */
	@SuppressWarnings("unchecked")
	public Iterator<? extends EObject> getTargets(EObject object, NodePattern sourceNode, EdgePattern edge) {
		EReference type = edge.getType();
		
		if (edge.getTarget() == sourceNode) {
			return crossReferencer.getInverse(object, type);
		} else {
			assert (edge.getSource() == sourceNode) : "The given edge is not incident with the given node!";
			
			// Create reference list:
			List<EObject> targets;
			
			if (type.isMany()) {
				targets = ( List<EObject>) object.eGet(type, true);
			} else {
				EObject value = (EObject) object.eGet(type, true);
				
				if (value != null) {
					targets = Collections.singletonList(value);
				} else {
					targets = Collections.emptyList();
				}
			}
			
			return targets.iterator();
		}
	}
	
	/**
	 * Is class A assignable to class B (B = A).
	 * 
	 * @param a
	 *            From class A.
	 * @param b
	 *            To class B.
	 * @return <code>true</code> if A is assignable to B; <code>false</code> otherwise.
	 */
	public static boolean isAssignableTo(EClass a, EClass b) {
		return  a.equals(b) || b.equals(EcorePackage.eINSTANCE.getEObject()) || a.getEAllSuperTypes().contains(b);
	}
	
	/**
	 * Returns all incident edges of the given node. While opposite edges are
	 * handled as a single edge.
	 * 
	 * @param node
	 *            A node.
	 * @return All outgoing edges and all incoming edges with no opposites.
	 */
	public static List<EdgePattern> getIncidents(NodePattern node) {
		List<EdgePattern> incidents = new ArrayList<EdgePattern>(
				node.getIncomings().size() + node.getOutgoings().size());
		
		// Outgoings:
		incidents.addAll(node.getOutgoings());
		
		// (Non-opposite) Incomings:
		for (EdgePattern incoming : node.getIncomings()) {
			if (incoming.getOpposite() == null) {
				incidents.add(incoming);
			}
		}
		
		return incidents;
	}
	
	/**
	 * @param node
	 *            A node.
	 * @param incident
	 *            An edge which is incident with the given node.
	 * @return The adjacent node of the incident edge.
	 */
	public static NodePattern getAdjacent(NodePattern node, EdgePattern incident) {
		
		if (incident.getSource() == node) {
			// Incident edge is outgoing:
			return incident.getTarget();
		} else {
			// Incident edge is incoming:
			assert (incident.getTarget() == node) : "The given edge is not incident with the given node!";
			return incident.getSource();
		}
	}
	
	/**
	 * @param node
	 *            The start node.
	 * @return The start node and all connected nodes.
	 */
	public static Set<NodePattern> getClosure(NodePattern node) {
		Set<NodePattern> closure = new HashSet<>();
		calcualteClosure(node, closure);
		return closure;
	}
	
	private static void calcualteClosure(NodePattern nextNode, Set<NodePattern> closure) {
		closure.add(nextNode);
		
		for (EdgePattern outgoing : nextNode.getOutgoings()) {
			if (!closure.contains(outgoing.getTarget())) {
				calcualteClosure(outgoing.getTarget(), closure);
			}
		}
		
		for (EdgePattern incoming : nextNode.getIncomings()) {
			if (incoming.getOpposite() == null) {
				if (!closure.contains(incoming.getSource())) {
					calcualteClosure(incoming.getSource(), closure);
				}
			}
		}
	}
	
	/**
	 * @param graphPattern
	 *            Graph-Pattern which needs clean up.
	 */
	public static void fixEdges(GraphPattern graphPattern) {
		
		for (NodePattern node : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : node.getOutgoings()) {
				if (edgePattern.eIsProxy() || edgePattern.getTarget() == null) {
					System.err.println("Invalid edge removed: " + edgePattern);
					
					node.eSetDeliver(false);
					node.getOutgoings().remove(edgePattern);
					node.eSetDeliver(true);
				}
			}
		}
	}
}
