package org.sidiff.repair.history.evaluation.oracle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
//import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recognition.scope.RepairActionFilter;
import org.sidiff.validation.constraint.api.util.RepairValidation;

public class DeveloperIntentionOracle {

	private Match preMatch;
	private SymmetricDifference evolutionStep;
	private Collection<RepairValidation> repairTrees;
	
	private Rule complementRule;

	private HashSet<String> changeSignatures;
	private HashSet<String> xmiIDs;

	/**
	 * @param preMatch
	 *            the pre-match turning the complement rule into a repair
	 *            operation.
	 * @param evolutionStep
	 *            the evolution step in which the inconsistency addressed by the
	 *            repair operation has been historically resolved.
	 * @param repairTrees
	 *            Trees of abstract repairs.
	 * @return <code>true</code> if the complementing changes can be observed in
	 *         the difference and if the the changes overlap with the given
	 *         repair trees; <code>false</code> otherwise.
	 */
	public boolean isHistoricallyObservable(
			Match preMatch, SymmetricDifference evolutionStep, 
			Collection<RepairValidation> repairTrees) {
		
		this.preMatch = preMatch;
		this.evolutionStep = evolutionStep;
		this.repairTrees = repairTrees;
		
		this.complementRule = preMatch.getRule();
		this.changeSignatures = new HashSet<String>();
		this.xmiIDs = new HashSet<String>();

		// Collect these data once for performance reasons
		gatherChangeSignatures();
		gatherXmiIDs();

		// We always check if all action-induced low level changes can be
		// observed
		if (!checkChangeSignatures()) {
			return false;
		}

		// All right, observable
		return true;
	}

	/**
	 * Collect all signatures <ChangeType>_<Element_Type> of low-level changes
	 * in evolutionStep.
	 */
	private void gatherChangeSignatures() {
		for (Change change : evolutionStep.getChanges()) {
			String signature = null;
			
			if (change instanceof AddObject) {
				AddObject c = (AddObject) change;
				signature = "AddObject_" + c.getObj().eClass().getName();
			}
			if (change instanceof RemoveObject) {
				RemoveObject c = (RemoveObject) change;
				signature = "RemoveObject_" + c.getObj().eClass().getName();
			}
			if (change instanceof AddReference) {
				AddReference c = (AddReference) change;
				signature = "AddReference_" + c.getType().getName();
			}
			if (change instanceof RemoveReference) {
				RemoveReference c = (RemoveReference) change;
				signature = "RemoveReference_" + c.getType().getName();
			}
			if (change instanceof AttributeValueChange) {
				AttributeValueChange c = (AttributeValueChange) change;
				signature = "AttributeValueChange_" + c.getType().getName();
			}
			
			if (signature != null) {
				changeSignatures.add(signature);
			}
		}
	}

	/**
	 * Collect all XMI IDs of model elements in evolutionStep.modelA.
	 */
	private void gatherXmiIDs() {
		for (Iterator<EObject> iterator = evolutionStep.getModelA().getAllContents(); iterator.hasNext();) {
			xmiIDs.add(EcoreUtil.getURI(iterator.next()).fragment());
		}
	}

	private boolean checkChangeSignatures() {
		List<GraphElement> foundChanges = new ArrayList<>();
		
		// Create nodes
		for (Node node : HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(complementRule)) {
			String signature = "AddObject_" + node.getType().getName();
			
			if (changeSignatures.contains(signature)) {
				foundChanges.add(node);
			} else {
				return false;
			}
		}

		// Delete nodes
		for (Node node : HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes(complementRule)) {
			String signature = "RemoveObject_" + node.getType().getName();
			
			if (changeSignatures.contains(signature)) {
				foundChanges.add(node);
			} else {
				return false;
			}
		}

		// Create edges
		for (Edge edge : HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges(complementRule)) {
			String signature = "AddReference_" + edge.getType().getName();
			
			if (changeSignatures.contains(signature)) {
				foundChanges.add(edge);
			} else {
				return false;
			}
		}

		// Delete edges
		for (Edge edge : HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges(complementRule)) {
			String signature = "RemoveReference_" + edge.getType().getName();
			
			if (changeSignatures.contains(signature)) {
				foundChanges.add(edge);
			} else {
				return false;
			}
		}
		
		// Set attributes:
		for (Node node : HenshinRuleAnalysisUtilEx.getLHSIntersectRHSNodes(complementRule)) {
			for (AttributePair attribute : ChangePatternUtil.getChangingAttributes(node)) {
				
				// NOTE: Variable attribute changes are optional.
				if (complementRule.getParameter(attribute.getRhsAttribute().getValue()) == null) {
					String signature = "AttributeValueChange_" + attribute.getType().getName();
					
					if (!changeSignatures.contains(signature)) {
						return false;
					}
				}
				
				foundChanges.add(attribute.getRhsAttribute());
			}
		}
		
		// => We found all change actions in the low-level difference!

		// NOTE: Since attribute changes are optional -> re-check repair tree overlapping:
		RepairActionFilter repairFilter = new RepairActionFilter(repairTrees);
		return repairFilter.filter(foundChanges, preMatch);
	}
}
