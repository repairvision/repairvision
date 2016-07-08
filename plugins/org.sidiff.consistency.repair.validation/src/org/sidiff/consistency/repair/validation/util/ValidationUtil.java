package org.sidiff.consistency.repair.validation.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.consistency.repair.validation.fix.Alternative;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair;
import org.sidiff.consistency.repair.validation.fix.Sequence;

public class ValidationUtil {

	/**
	 * Removes all unnecessary repair nodes (alternatives / sequences) 
	 * from the repair tree.
	 * 
	 * @param root
	 *            The root node of the repair tree.
	 */
	public static IRepairDecision cleanup(IRepairDecision root) {
		if (root == null) {
			return null;
		}
		
		// Clean up children:
		cleanup(root, root.getChildDecisions());
		
		// Clean up root:
		if (root.getChildDecisions().size() == 1) {
			return root.getChildDecisions().get(0);
		} else {
			return root;
		}
	}
	
	private static void cleanup(IRepairDecision parent, List<IRepairDecision> children) {
		List<IRepairDecision> pullUpRepairs = new LinkedList<>(); 
		
		// Identify unnecessary repair nodes (alternatives / sequences) :
		for (Iterator<IRepairDecision> iterator = children.iterator(); iterator.hasNext();) {
			IRepairDecision child = iterator.next();
			
			if (child instanceof Repair) {
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
		
		for (IRepairDecision child : parent.getChildDecisions()) {
			if (!(child instanceof Repair)) {
				cleanup(child, child.getChildDecisions());
			}
		}
		
		// Pull up repairs:
		for (IRepairDecision pullUpRepair : pullUpRepairs) {
			parent.appendChildDecisions(pullUpRepair);
		}
		
	}
}
