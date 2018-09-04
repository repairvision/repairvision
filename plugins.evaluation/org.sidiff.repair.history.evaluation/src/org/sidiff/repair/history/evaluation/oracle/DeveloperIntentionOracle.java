package org.sidiff.repair.history.evaluation.oracle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.sidiff.editrule.recognition.impact.GraphActionImpactAnalysis;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.impact.PositiveImpactAnalysis;
import org.sidiff.validation.constraint.impact.index.RepairActionIndex;

public class DeveloperIntentionOracle {

	private Collection<RepairValidation> repairTrees;

	private Set<String> currentToResolvedSignatures;
	
	public DeveloperIntentionOracle(
			SymmetricDifference currentToResolvedDifference, 
			Collection<RepairValidation> repairTrees) {
		
		this.repairTrees = repairTrees;
		this.currentToResolvedSignatures = toChangeSignatures(currentToResolvedDifference);
	}

	/**
	 * @return <code>true</code> if the complementing changes can be observed in
	 *         the difference and if the the changes overlap with the given
	 *         repair trees; <code>false</code> otherwise.
	 */
	public boolean isHistoricallyObservableRepair(IRepairPlan repair) {

		// We check if all action-induced low level changes can be observed
		List<GraphElement> observableChanges = findObservableChanges(repair.getComplementingEditRule(), currentToResolvedSignatures);
		
		if (observableChanges == null) {
			return false;
		}

		// NOTE: Since attribute changes are optional -> re-check repair tree overlapping for observable changes:
		GraphActionImpactAnalysis repairFilter = new GraphActionImpactAnalysis(new PositiveImpactAnalysis(new RepairActionIndex(repairTrees)));
		
		for (Match preMatch : repair.getComplementMatches()) {
			if (repairFilter.check(observableChanges, preMatch)) {
				return true;
			}
		}

		// All right, observable
		return true;
	}
	
	private Set<String> toChangeSignatures(SymmetricDifference difference) {
		Set<String> changeSignatures = new HashSet<>();
		
		for (Change change : difference.getChanges()) {
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
		
		return changeSignatures;
	}

	private List<GraphElement> findObservableChanges(Rule editRule, Set<String> difference) {
		List<GraphElement> observableChanges = new ArrayList<>();
		
		// Create nodes
		for (Node node : HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(editRule)) {
			String signature = "AddObject_" + node.getType().getName();
			
			if (difference.contains(signature)) {
				observableChanges.add(node);
			} else {
				return null;
			}
		}

		// Delete nodes
		for (Node node : HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes(editRule)) {
			String signature = "RemoveObject_" + node.getType().getName();
			
			if (difference.contains(signature)) {
				observableChanges.add(node);
			} else {
				return null;
			}
		}

		// Create edges
		for (Edge edge : HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges(editRule)) {
			String signature = "AddReference_" + edge.getType().getName();
			
			if (difference.contains(signature)) {
				observableChanges.add(edge);
			} else {
				return null;
			}
		}

		// Delete edges
		for (Edge edge : HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges(editRule)) {
			String signature = "RemoveReference_" + edge.getType().getName();
			
			if (difference.contains(signature)) {
				observableChanges.add(edge);
			} else {
				return null;
			}
		}
		
		// Set attributes:
		for (Node node : HenshinRuleAnalysisUtilEx.getLHSIntersectRHSNodes(editRule)) {
			for (AttributePair attribute : ChangePatternUtil.getChangingAttributes(node)) {
				
				// Is fix value change?
				if (editRule.getParameter(attribute.getRhsAttribute().getValue()) == null) {
					String signature = "AttributeValueChange_" + attribute.getType().getName();
					
					if (!difference.contains(signature)) {
						return null;
					}
				}
				
				// NOTE: Variable attribute changes are optional.
				observableChanges.add(attribute.getRhsAttribute());
			}
		}
		
		// => We found all change actions in the low-level difference!
		return observableChanges;
	}
}
