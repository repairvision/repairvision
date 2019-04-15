package org.sidiff.editrule.analysis.transienteffects;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithCreationAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithCreationEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithDeletionAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithDeletionEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithPreservedAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithPreservedEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithoutAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithoutEdges;
import static org.sidiff.editrule.analysis.conditions.EditRuleConditionsConfiguration.isPreservedAttributePostCondition;
import static org.sidiff.editrule.analysis.conditions.EditRuleConditionsConfiguration.isPreservedAttributePreCondition;
import static org.sidiff.editrule.analysis.conditions.EditRuleConditionsConfiguration.isPreservedEdgePostCondition;
import static org.sidiff.editrule.analysis.conditions.EditRuleConditionsConfiguration.isPreservedEdgePreCondition;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.common.henshin.view.NodePair;

/**
 * Analysis of edit-rule transient effects from model version A to model version B.
 * 
 * @author Manuel Ohrndorf
 */
public class EditRuleTransientEffects {

	/**
	 * Tests if a << preserve >> node will be searched in model A.
	 * 
	 * @param editRuleNode
	 *            The << preserve >> edit rule node to test.
	 * @return <code>true</code> if it will be searched in model A;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPreservedNodeSearchedInModelA(NodePair editRuleNode) {
		Node lhsNode = editRuleNode.getLhsNode();

		if (isNodeWithDeletionEdges(lhsNode) 
				|| isNodeWithChangingAttributes(lhsNode)
				|| (isPreservedAttributePreCondition() && isNodeWithPreservedAttributes(lhsNode))
				|| (isPreservedEdgePreCondition() && isNodeWithPreservedEdges(lhsNode))) {
			return true;
		}

		else if (isMultiContextNodeModelA(editRuleNode)) {
			return true;
		}

		return false;
	}

	/**
	 * Tests if a << preserve >> node will be searched in model B.
	 * 
	 * @param editRuleNode
	 *            The << preserve >> edit rule node to test.
	 * @return <code>true</code> if it will be searched in model B;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPreservedNodeSearchedInModelB(NodePair editRuleNode) {
		Node lhsNode = editRuleNode.getLhsNode();
		Node rhsNode = editRuleNode.getRhsNode();

		if (isNodeWithCreationEdges(rhsNode)
				|| isNodeWithCreationAttributes(rhsNode)
				|| isNodeWithDeletionAttributes(lhsNode)
				|| isNodeWithChangingAttributes(lhsNode)
				|| (isPreservedAttributePostCondition() && isNodeWithPreservedAttributes(lhsNode))
				|| (isPreservedEdgePostCondition() && isNodeWithPreservedEdges(lhsNode))) {
			return true;
		}

		else if (isMultiContextNodeModelB(editRuleNode)) {
			return true;
		}

		else if (!isPreservedNodeSearchedInModelA(editRuleNode)) {
			// Empty node!?
			return true;
		}

		return false;
	}
	
	/**
	 * A multi-context-node is a node of a kernel-rule which has exclusively
	 * incident edges of multi-rules. The model A/B side is only determined by
	 * this multi-rule edges, i.e. a multi-context-node has no edges/attributes
	 * in the kernel-rule.
	 * 
	 * @param editRuleNode
	 *            the edit-rule node to test.
	 * @return <code>true</code> if the given node is a multi-context node
	 *         <code>false</code> otherwise.
	 */
	public static boolean isMultiContextNode(NodePair editRuleNode) {

		if ((editRuleNode.getLhsNode() != null) && (editRuleNode.getRhsNode() != null)) {
			return isMultiContextNodeModelA(editRuleNode) || isMultiContextNodeModelB(editRuleNode);
		} else {
			return false;
		}
	}

	/**
	 * A multi-context-node is a node of a kernel-rule which has exclusively
	 * incident edges of multi-rules. The model A/B side is only determined by
	 * this multi-rule edges, i.e. a multi-context-node has no edges/attributes
	 * in the kernel-rule.
	 * 
	 * @param editRuleNode
	 *            the edit-rule node to test.
	 * @return <code>true</code> if the given node is a multi-context node that
	 *         will be searched in model A. <code>false</code> otherwise.
	 */
	public static boolean isMultiContextNodeModelA(NodePair editRuleNode) {
		Node lhsNode = editRuleNode.getLhsNode();
		Node rhsNode = editRuleNode.getRhsNode();

		// Is node without any edges/attributes?
		if (isNodeWithoutEdges(rhsNode) && isNodeWithoutEdges(lhsNode)
				&& isNodeWithoutAttributes(rhsNode) && isNodeWithoutAttributes(lhsNode)) {

			for (Rule multiRule : lhsNode.getGraph().getRule().getMultiRules()) {
				Node lhsNodeMulti = multiRule.getMultiMappings().getImage(lhsNode,
						multiRule.getLhs());
				Node rhsNodeMulti = multiRule.getMultiMappings().getImage(rhsNode,
						multiRule.getRhs());

				// Is multi-node?
				if ((lhsNodeMulti != null) && (rhsNodeMulti != null)) {
					return isPreservedNodeSearchedInModelA(new NodePair(lhsNodeMulti, rhsNodeMulti));
				}
			}
		}

		return false;
	}

	/**
	 * A multi-context-node is a node of a kernel-rule which has exclusively
	 * incident edges of multi-rules. The model A/B side is only determined by
	 * this multi-rule edges, i.e. a multi-context-node has no edges/attributes
	 * in the kernel-rule.
	 * 
	 * @param editRuleNode
	 *            the edit-rule node to test.
	 * @return <code>true</code> if the given node is a multi-context node that
	 *         will be searched in model B. <code>false</code> otherwise.
	 */
	public static boolean isMultiContextNodeModelB(NodePair editRuleNode) {
		Node lhsNode = editRuleNode.getLhsNode();
		Node rhsNode = editRuleNode.getRhsNode();

		// Is node without any edges/attributes?
		if (isNodeWithoutEdges(rhsNode) && isNodeWithoutEdges(lhsNode)
				&& isNodeWithoutAttributes(rhsNode) && isNodeWithoutAttributes(lhsNode)) {

			for (Rule multiRule : lhsNode.getGraph().getRule().getMultiRules()) {
				Node lhsNodeMulti = multiRule.getMultiMappings().getImage(lhsNode,
						multiRule.getLhs());
				Node rhsNodeMulti = multiRule.getMultiMappings().getImage(rhsNode,
						multiRule.getRhs());

				// Is multi-node?
				if ((lhsNodeMulti != null) && (rhsNodeMulti != null)) {
					return isPreservedNodeSearchedInModelB(new NodePair(lhsNodeMulti, rhsNodeMulti));
				}
			}
		}

		return false;
	}

	/**
	 * Test attribute value change (attributeX -> attributeY) for containing
	 * parameters/variables, which makes the attribute value change optional.
	 * 
	 * @param attribute
	 *            The attribute (attributeX -> attributeY).
	 * 
	 * @return <code>true</code> if the AVC is only optional; 
	 *         <code>false</code> otherwise.
	 */
	public static boolean isOptionalAttributeValueChange(AttributePair attribute) {
		return containsParameters(attribute.getLhsAttribute())
				|| containsParameters(attribute.getRhsAttribute());
	}

	/**
	 * Test attribute contains parameters/variables.
	 * 
	 * @param attribute
	 *            The attribute to test.
	 * 
	 * @return <code>true</code> if the attribute contains parameters;
	 *         <code>false</code> otherwise.
	 */
	private static boolean containsParameters(Attribute attribute) {

		Rule containingRule = attribute.getNode().getGraph().getRule();

		// LHS or RHS attribute contains a variable/parameter:
		for (Parameter parameter : containingRule.getParameters()) {
			// FIXME: Need real parsing:
			if (attribute.getValue().contains(parameter.getName())) {
				return true;
			}
		}

		return false;
	}
}
