package org.sidiff.repair.complement.peo.impact;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.consistency.common.henshin.ChangePatternUtil.tryLHS;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.editrule.recognition.match.RecognitionAttributeMatch;
import org.sidiff.revision.editrule.recognition.match.RecognitionEdgeMatch;
import org.sidiff.revision.editrule.recognition.match.RecognitionMatch;
import org.sidiff.revision.editrule.recognition.match.RecognitionNodeSingleMatch;
import org.sidiff.revision.editrule.recognition.revision.RevisionGraph;
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
				boolean strictContextType = RevisionGraph.isStrictMatchingType(((Edge) change).getSource());
					
				// Delete:
				if (change.getGraph().isLhs()) {
					if (impact.onDelete(sourceContextType, referenceType, strictContextType)) {
						return true;
					}

					// Repair which deletes the root element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						boolean strictTargetContextType = RevisionGraph.isStrictMatchingType(((Edge) change).getTarget());

						if (impact.onDelete(targetContextType, referenceType, strictTargetContextType)) {
							return true;
						}
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
				boolean strictContextType = RevisionGraph.isStrictMatchingType(((Attribute) change).getNode());
				
				if (impact.onModify(contextType, attributeType, strictContextType)) {
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Checks if the set of changes contains at least one change with a validation impact.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @param complementMatch
	 *            The matching of the complement rule nodes to model elements.
	 * @return <code>true</code> if the changes have a validation impact;
	 *         <code>false</code> otherwise.
	 */
	public static boolean real(ImpactAnalysis impact, Collection<GraphElement> changes, Match complementMatch) {
		return real(impact, changes, (Object) complementMatch);
	}
	
	/**
	 * Checks if the set of changes contains at least one change with a validation impact.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @param recognitionMatch
	 *            The matching of the sub-rule nodes to model elements.
	 * @return <code>true</code> if the changes have a validation impact;
	 *         <code>false</code> otherwise.
	 */
	public static boolean real(ImpactAnalysis impact, Collection<GraphElement> changes, List<RecognitionMatch> recognitionMatch) {
		return real(impact, changes, (Object) recognitionMatch);
	}
	
	private static boolean real(ImpactAnalysis impact, Collection<GraphElement> changes, Object match) {

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				
				// Get the context object of the edge:
				Node sourceContextNode = tryLHS(((Edge) change).getSource());
				EObject sourceContextObject = getMatch(sourceContextNode, match);
				
				if (sourceContextObject != null) {
					
					// Delete:
					if (change.getGraph().isLhs()) {
						if (impact.onDelete(sourceContextObject, referenceType)) {
							return true;
						}
						
						// Repair which deletes the root element of a validation:
						if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
							
							// Get the context object of the edge:
							Node targetContextNode = getLHS(((Edge) change).getTarget());
							EObject targetContextObject = getMatch(targetContextNode, match);
							
							if (impact.onDelete(targetContextObject, referenceType)) {
								return true;
							}
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
				Node contextNode = tryLHS(((Attribute) change).getNode());
				EObject contextObject = getMatch(contextNode, match);
				
				if (contextObject != null) {
					if (impact.onModify(contextObject, attributeType)) {
						return true;
					}
				}
			}
		}

		return false;
	}
	
	// TODO: Create/Use a common matching interface:
	
	@SuppressWarnings("unchecked")
	private static EObject getMatch(Node node, Object match) {
		if (match instanceof Match) {
			return getMatch(node, (Match) match);
		} else {
			return getMatch(node, (List<RecognitionMatch>) match);
		}
	}
	
	private static EObject getMatch(Node node, Match complementMatch) {
		return complementMatch.getNodeTarget(node);
	}
	
	private static EObject getMatch(Node node, List<RecognitionMatch> recognitionMatch) {
		for (RecognitionMatch match : recognitionMatch) {
			if (match instanceof RecognitionNodeSingleMatch) {
				if (((RecognitionNodeSingleMatch) match).getNode() == node) {
					return ((RecognitionNodeSingleMatch) match).getModelBElement();
				}
			} else if (match instanceof RecognitionEdgeMatch) {
				Edge edge = ((RecognitionEdgeMatch) match).getEdge();
				
				if (tryLHS(edge.getSource()) == node) {
					return ((RecognitionEdgeMatch) match).getSrcModelBElement();
				} else if (tryLHS(edge.getTarget()) == node) {
					return ((RecognitionEdgeMatch) match).getTgtModelBElement();
				}
			} else if (match instanceof RecognitionAttributeMatch) {
				Attribute attribute = ((RecognitionAttributeMatch) match).getAttribute();
				
				if (tryLHS(attribute.getNode()) == node) {
					return ((RecognitionAttributeMatch) match).getObject();
				}
			}
		}
		return null;
	}
}
