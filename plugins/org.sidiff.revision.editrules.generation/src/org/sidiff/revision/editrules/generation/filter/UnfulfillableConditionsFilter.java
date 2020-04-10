package org.sidiff.revision.editrules.generation.filter;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.getChange;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isChange;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isCreate;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isDelete;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isEditCondition;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isPost;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isPre;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isPreserve;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isRequire;
import static org.sidiff.revision.editrules.generation.generator.util.GraphPatternGeneratorUtil.isUnmodifiable;

import java.util.Collection;
import java.util.HashSet;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;

public class UnfulfillableConditionsFilter implements IEditRuleFilter {

	private boolean checkDangling;
	
	private boolean injectiveMatching;
	
	/**
	 * @param injectiveMatching <code>true</code> for injective LHS node matching;
	 *                          <code>false</code> otherwise.
	 * @param checkDangling     <code>true</code> for DPO; <code>false</code> for
	 *                          SPO.
	 */
	public UnfulfillableConditionsFilter(boolean checkDangling, boolean injectiveMatching) {
		this.checkDangling = checkDangling;
		this.injectiveMatching = injectiveMatching;
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
						if (!injectiveMatching || isUnfulfillableMultiplicityRequirement(eoNode, eoEdge)) {
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

					if (!isPreserve(eoEdge.getSource()) && !isEqualChanges(eoEdge.getSource(), eoEdge)) {
						return false;
					}

					if (!isPreserve(eoEdge.getTarget()) && !isEqualChanges(eoEdge.getTarget(), eoEdge)) {
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
	
	private boolean isEqualChanges(GraphElement elementA, GraphElement elementB) {
		if (isChange(elementA) && isChange(elementB)) {
			return getChange(elementA).equals(getChange(elementB));
		}
		return false;
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
						&& isRequire(conflictingEdge) 
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
							
							if (isUnfulfillableRequirmentPaths(conflictingEdge, eoEdge)) {
								return true;
							}
						} 
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * Checks for equal pre/post require multiplicity-one paths which starts at the
	 * same node A and lead to different target node. This is not fulfillable for
	 * injective matching of the source and target node of the path.
	 * 
	 * @param eoEdge          A require edge starting from node A.
	 * @param conflictingEdge A require edge starting from node A.
	 * @return <code>true</code> if such a unfulfillable path is found;
	 *         <code>false</code> otherwise.
	 */
	private boolean isUnfulfillableRequirmentPaths(EdgePattern eoEdge, EdgePattern conflictingEdge) {
		
		if (eoEdge.getSource() == conflictingEdge.getSource()) {
			return isUnfulfillableRequirmentPaths(eoEdge, conflictingEdge, new HashSet<>());
		}

		return false;
	}
	
	private boolean isUnfulfillableRequirmentPaths(EdgePattern eoEdge, EdgePattern conflictingEdge, Collection<EdgePattern> currentEOPath) {
		
		if (eoEdge.getType() == conflictingEdge.getType() && !eoEdge.getType().isMany()) {
			if (isRequire(eoEdge) && isRequire(conflictingEdge)) {
				if ((isPre(eoEdge) && isPost(conflictingEdge)) || (isPre(conflictingEdge) && isPost(eoEdge))) {
					if (isRequire(eoEdge.getTarget()) && isRequire(conflictingEdge.getTarget())) {

						for (EdgePattern eoPath : eoEdge.getTarget().getOutgoings()) {
							
							// Prevent cyclic paths:
							if (!currentEOPath.contains(eoEdge)) {
								currentEOPath.add(eoEdge);
								
								for (EdgePattern conflictingPath : conflictingEdge.getTarget().getOutgoings()) {
									if (isUnfulfillableRequirmentPaths(eoPath, conflictingPath, currentEOPath)) {
										return true;
									}
								}
								
								currentEOPath.remove(eoEdge);	// backtracking
							}
						}
					} else {
						return eoEdge.getTarget() != conflictingEdge.getTarget();
					}
				}
			}
		}

		return false;
	}
}
