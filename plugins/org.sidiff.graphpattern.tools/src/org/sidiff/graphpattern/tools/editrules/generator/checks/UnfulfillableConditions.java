package org.sidiff.graphpattern.tools.editrules.generator.checks;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.isEditCondition;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.isPost;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.isPre;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.*;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class UnfulfillableConditions {

	/**
	 * @param editRule An edit rule containing forbid/require pre/post conditions
	 * @return <code>true</code> if all conditions could be fulfilled;
	 *         <code>false</code> otherwise.
	 */
	public static boolean check(GraphPattern editRule) {

		for (NodePattern eoNode : editRule.getNodes()) {
			for (EdgePattern eoEdge : eoNode.getOutgoings()) {
				if (isEditCondition(eoEdge)) {
					
					// NOTE: Ignore derived pre/post condition edges!
					if (!isUnmodifiable(eoEdge)) {

						/*
						 * NOTE: Search for nodes with the same outgoing pre/post condition multiplicity
						 * one edge that have different targets. This condition can only be fulfilled if
						 * the pre-condition edge has a corresponding delete edge and the post-condition
						 * edge has a corresponding create edge.
						 */
						if (isUnfulfillableMultiplicityRequirment(eoNode, eoEdge)) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private static boolean isUnfulfillableMultiplicityRequirment(NodePattern eoNode, EdgePattern eoEdge) {
		
		if (isRequire(eoEdge) && !eoEdge.getType().isMany()) {
			for (EdgePattern conflictingEdge : eoNode.getOutgoings()) {
				if (conflictingEdge != eoEdge) {
					if (conflictingEdge.getTarget() != eoEdge.getTarget()) {
						EdgePattern preEdge = null;
						EdgePattern postEdge = null;
						
						if (isPre(eoEdge) && isPost(conflictingEdge)) {
							preEdge = eoEdge;
							postEdge = conflictingEdge;
						} else if (isPre(conflictingEdge) && isPost(eoEdge)) {
							preEdge = conflictingEdge;
							postEdge = eoEdge;
						}
						
						if ((preEdge != null) && (postEdge != null)) {
							if ((eoNode.getOutgoing(preEdge.getType(), preEdge.getTarget(), delete) == null) 
									|| (eoNode.getOutgoing(postEdge.getType(), postEdge.getTarget(), create) == null)) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
}
