package org.sidiff.validation.constraint.impact.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.utilities.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;
import org.sidiff.validation.constraint.impact.PotentialImpactAnalysis;

public class GraphActionImpactUtil {
	
	/**
	 * Checks if the set of changes contains at least one change with a potential validation impact.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @return <code>true</code> if the changes have a potential validation impact;
	 *         <code>false</code> otherwise.
	 */
	public static boolean potential(PotentialImpactAnalysis impact, Collection<GraphElement> changes) {

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = isStrictMatchingType(((Edge) change).getSource());
					
				// Delete:
				if (change.getGraph().isLhs()) {
					if (impact.onDelete(sourceContextType, referenceType, strictContextType)) {
						return true;
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					if (impact.onCreate(sourceContextType, referenceType, strictContextType)) {
						return true;
					}
				}

				else {
					assert false : "We should never get here...!";
				}
			}
			
			else if (change instanceof Attribute) {
				EAttribute attributeType = ((Attribute) change).getType();
				EClass contextType = ((Attribute) change).getNode().getType();
				boolean strictContextType = isStrictMatchingType(((Attribute) change).getNode());
				
				if (impact.onModify(contextType, attributeType, strictContextType)) {
					return true;
				}
			}
			
			else if (change instanceof Node) {
				EClass objectType = ((Node) change).getType();
				boolean strictObjectType = isStrictMatchingType((Node) change);

				// Delete:
				if (change.getGraph().isLhs()) {
					if (impact.onDelete(getContainingReference((Node) change), objectType, strictObjectType)) {
						return true;
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					if (impact.onCreate(getContainingReference((Node) change), objectType, strictObjectType)) {
						return true;
					}
				}

				else {
					assert false : "We should never get here...!";
				}
			}
		}

		return false;
	}
	
	private static EReference getContainingReference(Node change) {
		for (Edge incomingEdge : change.getIncoming()) {
			if (incomingEdge.getType().isContainment()) {
				return incomingEdge.getType();
			}
		}
		return null;
	}
	
	/**
	 * Checks if the set of changes contains at least one change with a validation impact.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @param matching
	 *            The matching of the complement rule nodes to model elements.
	 * @return <code>true</code> if the changes have a validation impact;
	 *         <code>false</code> otherwise.
	 */
	public static boolean real(ImpactAnalysis impact, Collection<GraphElement> changes, Matching matching) {

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				
				// Get the context object of the edge:
				Node sourceContextNode = HenshinRuleAnalysisUtil.tryLHS(((Edge) change).getSource());
				EObject sourceContextObject = matching.getMatch(sourceContextNode);
				
				if (sourceContextObject != null) {
					
					// Delete:
					if (change.getGraph().isLhs()) {
						if (impact.onDelete(sourceContextObject, referenceType)) {
							return true;
						}
					}
					
					// Create:
					else if (change.getGraph().isRhs()) {
						if (impact.onCreate(sourceContextObject, referenceType)) {
							return true;
						}
					}
					
					else {
						assert false : "We should never get here...!";
					}
				}
			}
			
			else if (change instanceof Attribute) {
				EAttribute attributeType = ((Attribute) change).getType();
				
				// Get the context object of the edge:
				Node contextNode = HenshinRuleAnalysisUtil.tryLHS(((Attribute) change).getNode());
				EObject contextObject = matching.getMatch(contextNode);
				
				if (contextObject != null) {
					if (impact.onModify(contextObject, attributeType)) {
						return true;
					}
				}
			}
			
			else if (change instanceof Node) {
				EObject object = matching.getMatch((Node) change);
				
				if (object != null) {
					
					// Delete:
					if (change.getGraph().isLhs()) {
						if (impact.onDelete(object)) {
							return true;
						}
					}
					
					// Create:
					else if (change.getGraph().isRhs()) {
						if (impact.onCreate(object)) {
							return true;
						}
					}
				}

				else {
					assert false : "We should never get here...!";
				}
			}
		}

		return false;
	}

	/**
	 * @param node
	 *            A typed node.
	 * @return <code>true</code> if the type is a concrete (none abstract, interface) creation node.
	 */
	public static boolean isStrictMatchingType(Node node) {
		return !(node.getType().isAbstract() || node.getType().isInterface()) && HenshinRuleAnalysisUtil.isCreationNode(node);
	}
}
