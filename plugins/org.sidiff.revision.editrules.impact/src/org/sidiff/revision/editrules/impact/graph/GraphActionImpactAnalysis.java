package org.sidiff.revision.editrules.impact.graph;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.editrules.impact.util.GraphMatching;
import org.sidiff.revision.impact.analysis.ImpactAnalysis;

public class GraphActionImpactAnalysis {

	private ImpactAnalysis impact;
	
	public GraphActionImpactAnalysis(ImpactAnalysis impact) {
		this.impact = impact;
	}

	/**
	 * Checks if the set of changes contains at least one change with a validation impact.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @param graphMatching
	 *            The matching of the complement rule nodes to model elements.
	 * @return <code>true</code> if the changes have a validation impact;
	 *         <code>false</code> otherwise.
	 */
	public boolean hasImpact(Collection<GraphElement> changes, GraphMatching graphMatching) {
	
		for (GraphElement change : changes) {
	
			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				
				// Get the context object of the edge:
				Node sourceContextNode = HenshinRuleAnalysisUtil.tryLHS(((Edge) change).getSource());
				EObject sourceContextObject = graphMatching.getMatch(sourceContextNode);
				
				if (sourceContextObject != null) {
					
					// Delete:
					if (change.getGraph().isLhs()) {
						if (impact.onDeleteReference(sourceContextObject, referenceType)) {
							return true;
						}
					}
					
					// Create:
					else if (change.getGraph().isRhs()) {
						if (impact.onCreateReference(sourceContextObject, referenceType)) {
							return true;
						}
					}
					
					else {
						assert false : "Edge is not a change!";
					}
				}
			}
			
			else if (change instanceof Attribute) {
				EAttribute attributeType = ((Attribute) change).getType();
				
				// Get the context object of the edge:
				Node contextNode = HenshinRuleAnalysisUtil.tryLHS(((Attribute) change).getNode());
				EObject contextObject = graphMatching.getMatch(contextNode);
				
				if (contextObject != null) {
					if (impact.onModifyAttribute(contextObject, attributeType)) {
						return true;
					}
				}
			}
			
			else if (change instanceof Node) {
				EObject object = graphMatching.getMatch((Node) change);
				
				if (object != null) {
					
					// Delete:
					if (change.getGraph().isLhs()) {
						//  Asserting that the containment in the rule is already matched to the object containment.
						if (impact.onDeleteObject(object.eContainmentFeature(), object)) {
							return true;
						}
					}
					
					// Create:
					else if (change.getGraph().isRhs()) {
						//  Asserting that the containment in the rule is already matched to the object containment.
						if (impact.onCreateObject(object.eContainmentFeature(), object)) {
							return true;
						}
					}
				}
	
				else {
					assert false : "Node is not a change!";
				}
			}
		}
	
		return false;
	}

}
