package org.sidiff.editrule.analysis.conditions;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getForbidAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getForbidEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRequireAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRequireEdges;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.editrule.analysis.annotations.EditRuleAnnotations;
import org.sidiff.editrule.analysis.annotations.EditRuleAnnotations.Condition;

/**
 * The pre-/postcondition interpretation of an edit-rule.
 * 
 * @author Manuel Ohrndorf
 */
public class EditRuleConditions {

	/**
	 * Tests if the given nested graph is an application precondition graph.
	 * 
	 * @param applicationCondition
	 *            A nested AC graph.
	 * @return <code>true</code> if the given AC is precondition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPrecondition(Graph applicationCondition) {
		return EditRuleAnnotations.getCondition(applicationCondition).equals(Condition.pre);
	}

	/**
	 * Tests if the given nested graph is an application postcondition graph.
	 * 
	 * @param applicationCondition
	 *            A nested AC graph.
	 * @return <code>true</code> if the given AC is postcondition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPostcondition(Graph applicationCondition) {
		return EditRuleAnnotations.getCondition(applicationCondition).equals(Condition.post);
	}

	/**
	 * Searches for incident << forbid >> (precondition) edges in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << forbid >> (precondition)
	 *         edge; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPreconditionForbidEdges(Node node) {
	
		for (Edge forbidEdge : getForbidEdges(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(forbidEdge.getGraph());
	
			if (conditionType.equals(Condition.pre)) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Searches for incident << forbid >> (postcondition) edges in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << forbid >> (postcondition)
	 *         edge; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPostconditionForbidEdges(Node node) {
	
		for (Edge forbidEdge : getForbidEdges(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(forbidEdge.getGraph());
	
			if (conditionType.equals(Condition.post)) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Searches for incident << require >> (precondition) edges in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << require >> (precondition)
	 *         edge; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPreconditionRequireEdges(Node node) {
	
		for (Edge requireEdge : getRequireEdges(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(requireEdge.getGraph());
	
			if (conditionType.equals(Condition.pre)) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Searches for incident << require >> (postcondition) edge in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << require >> (postcondition)
	 *         edge; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPostconditionRequireEdges(Node node) {
	
		for (Edge requireEdge : getRequireEdges(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(requireEdge.getGraph());
	
			if (conditionType.equals(Condition.post)) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Searches for << forbid >> (precondition) attributes in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << forbid >> (precondition)
	 *         attribute; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPreconditionForbidAttributes(Node node) {
	
		for (Attribute forbidAttribute : getForbidAttributes(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(forbidAttribute.getGraph());
	
			if (conditionType.equals(Condition.pre)) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Searches for << forbid >> (postcondition) attributes in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << forbid >> (postcondition)
	 *         attribute; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPostconditionForbidAttributes(Node node) {
	
		for (Attribute forbidAttribute : getForbidAttributes(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(forbidAttribute.getGraph());
	
			if (conditionType.equals(Condition.post)) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Searches for << require >> (precondition) attributes in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << require >> (precondition)
	 *         attribute; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPreconditionRequireAttributes(Node node) {
	
		for (Attribute requireAttribute : getRequireAttributes(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(requireAttribute.getGraph());
	
			if (conditionType.equals(Condition.pre)) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Searches for << require >> (postcondition) attributes in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << require >> (postcondition)
	 *         attribute; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPostconditionRequireAttributes(Node node) {
	
		for (Attribute requireAttribute : getRequireAttributes(node)) {
			Condition conditionType = EditRuleAnnotations.getCondition(requireAttribute.getGraph());
	
			if (conditionType.equals(Condition.post)) {
				return true;
			}
		}
	
		return false;
	}

}
