package org.sidiff.revision.impact.changetree.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.Sequence;

public class DecisionTreeUtil {
	
	/**
	 * Removes all unnecessary nodes from the tree.
	 * 
	 * @param root
	 *            The root node of the tree.
	 */
	public static IDecisionNode cleanup(IDecisionNode root) {
		
		// Clean up children:
		if (root instanceof IDecisionBranch)  {
			IDecisionBranch rootBranch = (IDecisionBranch) root;
			
			while (cleanup(rootBranch, rootBranch.getChildDecisions()));
			
			// Clean up root:
			if (rootBranch.getChildDecisions().size() == 1) {
				return rootBranch.getChildDecisions().get(0);
			} else {
				return root;
			}
		}
		
		return root;
	}
	
	private static boolean cleanup(IDecisionBranch parent, List<IDecisionNode> children) {
		List<IDecisionNode> pullUps = new LinkedList<>(); 
		
		// Identify unnecessary nodes (alternatives / sequences):
		for (Iterator<IDecisionNode> iterator = children.iterator(); iterator.hasNext();) {
			IDecisionNode child = iterator.next();
			
			if (child instanceof IDecisionLeaf) {
				continue;
			}
			
			else if (child instanceof IDecisionBranch) {
				IDecisionBranch childBranch = (IDecisionBranch) child;
				
				// Empty node:
				if (childBranch.getChildDecisions().isEmpty()) {
					iterator.remove();
				}
				
				// Alternatives of alternatives:
				else if ((childBranch instanceof Alternative) && (parent instanceof Alternative)) {
					pullUps.addAll(childBranch.getChildDecisions());
					iterator.remove();
				}
				
				// Sequences of sequences:
				else if ((childBranch instanceof Sequence) && (parent instanceof Sequence)) {
					pullUps.addAll(childBranch.getChildDecisions());
					iterator.remove();
				}
				
				// Only one decision:
				else if (childBranch.getChildDecisions().size() == 1) {
					if ((childBranch instanceof Alternative) || (childBranch instanceof Sequence)) {
						if ((parent instanceof Alternative) || (parent instanceof Sequence)) {
							pullUps.addAll(childBranch.getChildDecisions());
							iterator.remove();
						}
					}
				}
			}
		}
		
		// Recursively clean up repair tree:
		if (!pullUps.isEmpty()) {
			cleanup(parent, pullUps);
		}
		
		for (IDecisionNode child : parent.getChildDecisions()) {
			if (child instanceof IDecisionBranch) {
				cleanup((IDecisionBranch) child, ((IDecisionBranch) child).getChildDecisions());
			}
		}
		
		// Pull up repairs:
		for (IDecisionNode pullUpRepair : pullUps) {
			parent.appendChildDecisions(pullUpRepair);
		}
		
		// Remove duplicates:
		for (Iterator<IDecisionNode> iterator = parent.getChildDecisions().iterator(); iterator.hasNext();) {
			IDecisionNode decision = iterator.next();
			
			if (decision instanceof IDecisionLeaf) {
				if (hasDuplicate(parent.getChildDecisions(), (IDecisionLeaf) decision)) {
					iterator.remove();
				}
			}
		}
		
		return !pullUps.isEmpty();
	}
	
	public static boolean equals(IDecisionLeaf leafA, IDecisionLeaf leafB) {
		return (leafA.compareTo(leafB) == 0);
	}
	
	public static boolean hasDuplicate(List<IDecisionNode> nodes, IDecisionLeaf leaf) {
		for (IDecisionNode node : nodes) {
			if (node instanceof IDecisionLeaf) {
				if (node != leaf) {
					if (equals((IDecisionLeaf) node, leaf)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void getPathCount(IDecisionNode node, int[] counter) {
		
		if (node instanceof IDecisionLeaf) {
			counter[0]++;
		}
		
		else if (node instanceof IDecisionBranch) {
			if (((IDecisionBranch) node).getChildDecisions().isEmpty()) {
				counter[1]++;
			} else {
				for (IDecisionNode child : ((IDecisionBranch) node).getChildDecisions()) {
					getPathCount(child, counter);
				}
			}
		}
	}
}
