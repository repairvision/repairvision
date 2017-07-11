package org.sidiff.validation.constraint.api.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;

public class ValidationUtil {
	
	/**
	 * Removes all unnecessary repair nodes (alternatives / sequences) 
	 * from the repair tree.
	 * 
	 * @param root
	 *            The root node of the repair tree.
	 */
	public static IDecisionNode cleanup(IDecisionNode root) {
		if (root == null) {
			return null;
		}
		
		// Clean up children:
		while (cleanup(root, root.getChildDecisions()));
		
		// Clean up root:
		if (root.getChildDecisions().size() == 1) {
			return root.getChildDecisions().get(0);
		} else {
			return root;
		}
	}
	
	public static boolean equals(RepairAction repairA, RepairAction repairB) {
		if (repairA.getType().equals(repairB.getType())) {
			if (repairA.getFeature().equals(repairB.getFeature())) {
				if (repairA.getContext().equals(repairB.getContext())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean hasDuplicate(List<IDecisionNode> repairs, RepairAction repair) {
		for (IDecisionNode iRepairDecision : repairs) {
			if (iRepairDecision instanceof RepairAction) {
				if (iRepairDecision != repair) {
					if (equals((RepairAction) iRepairDecision, repair)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean cleanup(IDecisionNode parent, List<IDecisionNode> children) {
		List<IDecisionNode> pullUpRepairs = new LinkedList<>(); 
		
		// Identify unnecessary repair nodes (alternatives / sequences) :
		for (Iterator<IDecisionNode> iterator = children.iterator(); iterator.hasNext();) {
			IDecisionNode child = iterator.next();
			
			if (child instanceof RepairAction) {
				continue;
			}
			
			if ((child instanceof Alternative) && (parent instanceof Alternative)) {
				pullUpRepairs.addAll(child.getChildDecisions());
				iterator.remove();
			}
			
			else if ((child instanceof Sequence) && (parent instanceof Sequence)) {
				pullUpRepairs.addAll(child.getChildDecisions());
				iterator.remove();
			}
			
			else if (child.getChildDecisions().size() == 1) {
				pullUpRepairs.addAll(child.getChildDecisions());
				iterator.remove();
			}
			
			else if ((child instanceof Alternative) && (parent instanceof Sequence)) {
				if (child.getChildDecisions().isEmpty()) {
					iterator.remove();
				}
			}
		}
		
		// Recursively clean up repair tree:
		if (!pullUpRepairs.isEmpty()) {
			cleanup(parent, pullUpRepairs);
		}
		
		for (IDecisionNode child : parent.getChildDecisions()) {
			if (!(child instanceof RepairAction)) {
				cleanup(child, child.getChildDecisions());
			}
		}
		
		// Pull up repairs:
		for (IDecisionNode pullUpRepair : pullUpRepairs) {
			parent.appendChildDecisions(pullUpRepair);
		}
		
		// Remove duplicates:
		for (Iterator<IDecisionNode> iterator = parent.getChildDecisions().iterator(); iterator.hasNext();) {
			IDecisionNode iRepairDecision = (IDecisionNode) iterator.next();
			
			if (iRepairDecision instanceof RepairAction) {
				if (hasDuplicate(parent.getChildDecisions(), (RepairAction) iRepairDecision)) {
					iterator.remove();
				}
			}
		}
		
		return !pullUpRepairs.isEmpty();
	}
}
