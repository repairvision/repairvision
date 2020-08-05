package org.sidiff.revision.editrules.impact.graph;

import static org.sidiff.revision.common.henshin.HenshinChangesUtil.isStrictMatchingType;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getContainingReference;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.impact.analysis.PotentialImpactAnalysis;

public class PotentialGraphActionImpactAnalysis {

	private PotentialImpactAnalysis impact;
	
	public PotentialGraphActionImpactAnalysis(PotentialImpactAnalysis impact) {
		this.impact = impact;
	}

	/**
	 * Checks if the set of changes contains at least one change with a potential validation impact.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @return <code>true</code> if the changes have a potential validation impact;
	 *         <code>false</code> otherwise.
	 */
	public boolean hasImpact(Collection<GraphElement> changes) {
	
		for (GraphElement change : changes) {
	
			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = isStrictMatchingType(((Edge) change).getSource());
					
				// Delete:
				if (change.getGraph().isLhs()) {
					if (impact.onDeleteReference(sourceContextType, referenceType, strictContextType)) {
						return true;
					}
				}
	
				// Create:
				else if (change.getGraph().isRhs()) {
					if (impact.onCreateReference(sourceContextType, referenceType, strictContextType)) {
						return true;
					}
				}
	
				else {
					assert false : "Edge is not a change!";
				}
			}
			
			else if (change instanceof Attribute) {
				EAttribute attributeType = ((Attribute) change).getType();
				EClass contextType = ((Attribute) change).getNode().getType();
				boolean strictContextType = isStrictMatchingType(((Attribute) change).getNode());
				
				if (impact.onModifyAttribute(contextType, attributeType, strictContextType)) {
					return true;
				}
			}
			
			else if (change instanceof Node) {
				EClass objectType = ((Node) change).getType();
				boolean strictObjectType = isStrictMatchingType((Node) change);
	
				// Delete:
				if (change.getGraph().isLhs()) {
					if (impact.onDeleteObject(getContainingReference((Node) change), objectType, strictObjectType)) {
						return true;
					}
				}
	
				// Create:
				else if (change.getGraph().isRhs()) {
					if (impact.onCreateObject(getContainingReference((Node) change), objectType, strictObjectType)) {
						return true;
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
