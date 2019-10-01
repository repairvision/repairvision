package org.sidiff.graphpattern.tools.editrules.filter;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.getChange;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isChange;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isContext;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isCreate;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isDelete;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isEditCondition;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isPost;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isPre;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isRequire;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.isUnmodifiable;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;

public class UnfulfillableConditionsFilter implements IEditRuleFilter {

	private boolean checkDangling;
	
	/**
	 * @param checkDangling <code>true</code> for DPO; <code>false</code> for SPO.
	 */
	public UnfulfillableConditionsFilter(boolean checkDangling) {
		this.checkDangling = checkDangling;
	}
	
	/**
	 * @return <code>true</code> if all conditions could be fulfilled;
	 *         <code>false</code> otherwise.
	 */
	@Override
	public boolean filter(Pattern editRule, GraphPattern editGraph, Iterable<GraphPattern> rulebase) {
		return !check(editGraph);
	}

	/**
	 * @param editRule An edit rule containing forbid/require pre/post conditions
	 * @return <code>true</code> if all conditions could be fulfilled;
	 *         <code>false</code> otherwise.
	 */
	private boolean check(GraphPattern editRule) {

		for (NodePattern eoNode : editRule.getNodes()) {
			
			for (EdgePattern eoEdge : eoNode.getOutgoings()) {
				if (isEditCondition(eoEdge)) {
					
					// NOTE: Ignore derived pre/post condition edges!
					if (!isUnmodifiable(eoEdge)) {
						if (isUnfulfillableMultiplicityRequirement(eoNode, eoEdge)) {
							return false;
						}
						if (isUnfulfillableRequirement(eoNode, eoEdge, checkDangling)) {
							return false;
						}
						if (isUnfulfillableRequirement(eoEdge.getTarget(), eoEdge, checkDangling)) {
							return false;
						}
					}
				} else if (isChange(eoEdge)) {
					
					// Changes only between context nodes or nodes of the same change!
					if (!isContext(eoEdge.getSource()) && !getChange(eoEdge.getSource()).equals(getChange(eoEdge))) {
						return false;
					}
					
					if (!isContext(eoEdge.getTarget()) && !getChange(eoEdge.getTarget()).equals(getChange(eoEdge))) {
						return false;
					}
				}
			}
			
			for (AttributePattern eoAttribute : eoNode.getAttributes()) {
				if (isEditCondition(eoAttribute)) {
					
					// NOTE: Ignore derived pre/post condition attributes!
					if (!isUnmodifiable(eoAttribute)) {
						if (isUnfulfillableRequirement(eoNode, eoAttribute, checkDangling)) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}
	
	/**
	 * NOTE: Unfulfillable:
	 * - DPO: require edge/attribute on delete node
	 * - SPO/DPO: require edge/attribute on create node
	 */
	private boolean isUnfulfillableRequirement(NodePattern eoNode, GraphElement element, boolean checkDangling) {
		
		if (checkDangling) {
			if (isDelete(eoNode) && isRequire(element)) {
				return true;
			}
		}
	
		if (isCreate(eoNode) && isRequire(element)) {
			return true;
		}
		
		return false;
	}

	/**
	 * NOTE: Search for nodes with the same outgoing pre/post condition
	 * multiplicity-one edges that have different targets. This condition can only
	 * be fulfilled if the pre-condition edge has a corresponding delete edge and
	 * post-condition edge has a corresponding create edge.
	 */
	private boolean isUnfulfillableMultiplicityRequirement(NodePattern eoNode, EdgePattern eoEdge) {
		
		if (isRequire(eoEdge) && !eoEdge.getType().isMany()) {
			for (EdgePattern conflictingEdge : eoNode.getOutgoings()) {
				if ((conflictingEdge != eoEdge) 
						&& isEditCondition(conflictingEdge) 
						&& (eoEdge.getType() ==conflictingEdge.getType())) {
					
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

						// This condition can only be fulfilled if the pre-condition edge has a corresponding 
						// delete edge and post-condition edge has a corresponding create edge.
						if ((eoNode.getOutgoing(preEdge.getType(), preEdge.getTarget(), delete) == null) 
								|| (eoNode.getOutgoing(postEdge.getType(), postEdge.getTarget(), create) == null)) {
							
							// We have to check if the preconditions can be merged/matched with each other:
							if (!matchCondition(conflictingEdge, eoEdge)) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}

	private boolean matchCondition(EdgePattern eoEdge, EdgePattern conflictingEdge) {
		
		if (eoEdge.getType() == conflictingEdge.getType()) {
			if (isEditCondition(eoEdge.getTarget()) && isEditCondition(conflictingEdge.getTarget())) {
				
				// FIXME: We have to check if the preconditions can be merged/matched with each other.
				
				return true;
			} else {
				return eoEdge.getTarget() == conflictingEdge.getTarget();
			}
		}
		
		return false;
	}
}
