package org.sidiff.editrule.recognition.impact;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.validation.constraint.impact.PotentialImpactAnalysis;

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
	public boolean check(Collection<GraphElement> changes) {

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = MatchingHelper.isStrictMatchingType(((Edge) change).getSource());
					
				// Delete:
				if (change.getGraph().isLhs()) {
					if (impact.onDelete(sourceContextType, referenceType, strictContextType)) {
						return true;
					}

					// Repair which deletes the root element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						boolean strictTargetContextType = MatchingHelper.isStrictMatchingType(((Edge) change).getTarget());

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
				boolean strictContextType = MatchingHelper.isStrictMatchingType(((Attribute) change).getNode());
				
				if (impact.onModify(contextType, attributeType, strictContextType)) {
					return true;
				}
			}
		}

		return false;
	}
}
