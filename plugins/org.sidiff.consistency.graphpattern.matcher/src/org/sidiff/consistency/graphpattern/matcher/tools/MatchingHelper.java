package org.sidiff.consistency.graphpattern.matcher.tools;

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
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;

public class MatchingHelper {

//	private Map<EClass, Set<EClass>> subTypes = new HashMap<>();
	
	private CrossReferencer crossReferencer;
	
	private Set<EReference> inverseIndexed = new HashSet<>();
	
	/**
	 * Initializes a new matching helper.
	 * 
	 * @param crossReferencer
	 *            The generic or domain specific cross-reference calculator.
	 */
	public MatchingHelper(CrossReferencer crossReferencer) {
		this.crossReferencer = crossReferencer;
	}
	
	/**
	 * @param edgePattern
	 *            An edge with type T.
	 * @return <code>true</code> if type T was already inverse indexed
	 *         <code>false</code> otherwise.
	 */
	public boolean isInverseIndexed(EdgePattern edgePattern) {
		return inverseIndexed.contains(edgePattern.getType());
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
		
		if (edge.isCrossReference() || (edge.getTarget() == sourceNode)) {
			
			// Create inverse list:
			Iterator<? extends EObject> inverse = crossReferencer.getInverse(object, type);
			
			// Update index list:
			inverseIndexed.add(type);
			
			return inverse;
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
		return a.getEAllSuperTypes().contains(b) || a.equals(b) || b.equals(EcorePackage.eINSTANCE.getEObject());
	}
	
//	/**
//	 * @param superType
//	 *            A meta-class of the domain model.
//	 * @return All corresponding sub-types (i.e. sub-meta-classes).
//	 */
//	public Set<EClass> getSubTypes(EClass superType) {
//		Set<EClass> subTypes = this.subTypes.get(superType);
//		
//		if (subTypes == null) {
//			createSubtypeIndex(superType.getEPackage());
//			subTypes = this.subTypes.get(superType);
//		}
//		
//		return subTypes;
//	}
//	
//	private void createSubtypeIndex(EPackage ePackage) {
//
//		// Iterate over all classes in the package
//		for (Iterator<EObject> i = ePackage.eAllContents(); i.hasNext();) {
//			EObject obj = i.next();
//
//			if (obj instanceof EClass) {
//				// Next class (A)
//				EClass eSubClass = (EClass) obj;
//
//				if (!subTypes.containsKey(eSubClass)) {
//					subTypes.put(eSubClass, new HashSet<EClass>(0));
//				}
//
//				// Lookup the super types (X,Y,Z) of class (A) and add
//				// class (A) as sub type to the classes (X, Y, Z)
//				for (EClass eSuperClass : eSubClass.getEAllSuperTypes()) {
//					Set<EClass> allSubTypes = subTypes.get(eSuperClass);
//
//					if (allSubTypes == null) {
//						allSubTypes = new HashSet<EClass>(0);
//						subTypes.put(eSuperClass, allSubTypes);
//					}
//
//					allSubTypes.add(eSubClass);
//				}
//			}
//		}
//	}
	
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
	 * @param evaluation
	 *            An node evaluation adapter.
	 * @return The underlying navigable data store.
	 */
	// TODO: Only one interface!?
	public static NavigableMatchesDS getDataStore(Evaluation evaluation) {
		if (evaluation.getStore() instanceof NavigableMatchesDS) {
			return (NavigableMatchesDS) evaluation.getStore();
		} else {
			throw new RuntimeException("This algorithm needs a navigable data store!");
		}
	}
	
	/**
	 * @param node
	 *            An node pattern.
	 * @return The underlying navigable data store.
	 */
	// TODO: Only one interface!?
	public static NavigableMatchesDS getDataStore(NodePattern node) {
		DataStore ds = (node.getEvaluation() != null) ? node.getEvaluation().getStore() : null;
		
		if (ds instanceof NavigableMatchesDS) {
			return (NavigableMatchesDS) ds;
		} else {
			throw new RuntimeException("This algorithm needs a navigable data store!");
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
