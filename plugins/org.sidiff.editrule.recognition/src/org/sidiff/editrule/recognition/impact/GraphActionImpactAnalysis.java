package org.sidiff.editrule.recognition.impact;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;

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
	 * @return <code>true</code> if the changes have a validation impact;
	 *         <code>false</code> otherwise.
	 */
	public boolean check(Collection<GraphElement> changes, Match prematch) {

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				
				// Get the context object of the edge:
				Node sourceContextNode = getLHS(((Edge) change).getSource());
				EObject sourceContextObject = prematch.getNodeTarget(sourceContextNode);
				
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
							EObject targetContextObject = prematch.getNodeTarget(targetContextNode);
							
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
				Node contextNode = getLHS(((Attribute) change).getNode());
				EObject contextObject = prematch.getNodeTarget(contextNode);
				
				if (contextObject != null) {
					if (impact.onModify(contextObject, attributeType)) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
