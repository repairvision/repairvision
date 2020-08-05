package org.sidiff.revision.common.henshin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.common.henshin.pairs.AttributePair;

public class HenshinChangesUtil {

	/**
	 * @param rule The rule from which the changes will be collected.
	 * @return All changes (<< delete >> / << create >> nodes / edges / << set >>
	 *         attributes of << preserve >> nodes) of the given rule.
	 */
	public static List<GraphElement> getChanges(Rule rule) {
		List<GraphElement> changes = new ArrayList<GraphElement>();

		// << delete >> nodes:
		for (Node deleteNode : HenshinRuleAnalysisUtil.getDeletionNodes(rule)) {
			changes.add(deleteNode);
		}

		// << delete >> edges:
		for (Edge deleteEdge : HenshinRuleAnalysisUtil.getDeletionEdges(rule)) {
			changes.add(deleteEdge);
		}

		// << create >> nodes:
		for (Node createNode : HenshinRuleAnalysisUtil.getCreationNodes(rule)) {
			changes.add(createNode);
		}

		// << create >> edges:
		for (Edge createEdge : HenshinRuleAnalysisUtil.getCreationEdges(rule)) {
			changes.add(createEdge);
		}

		// << create >> attributes (attribute value changes):
		for (Node lhsNode : rule.getLhs().getNodes()) {
			for (AttributePair attributePair : getChangingAttributes(lhsNode)) {
				changes.add(attributePair.getRhsAttribute());
			}
		}

		return changes;
	}

	/**
	 * @param rule The rule from which the changes will be collected.
	 * @return All changes (<< delete >> / << create >> nodes / edges / << set >>
	 *         attributes) of the given rule.
	 */
	public static List<GraphElement> getPotentialChanges(Rule rule) {
		List<GraphElement> changes = getChanges(rule);
		changes.addAll(getSettingAttributes(rule));
		return changes;
	}

	/**
	 * @return All << set >> attributes in << create >> nodes.
	 */
	public static List<Attribute> getSettingAttributes(Rule rule) {
		List<Attribute> setAttributes = new ArrayList<>();

		for (Node createNode : HenshinRuleAnalysisUtil.getCreationNodes(rule)) {
			setAttributes.addAll(createNode.getAttributes());
		}

		return setAttributes;
	}

	/**
	 * @return All attributes of the form value1->value2 and << set >> value in <<
	 *         preserve >> nodes.
	 */
	public static List<AttributePair> getChangingAttributes(Rule rule) {
		List<AttributePair> changingAttributes = new ArrayList<>();

		for (Node lhsNode : rule.getLhs().getNodes()) {
			changingAttributes.addAll(getChangingAttributes(lhsNode));
		}

		return changingAttributes;
	}

	/**
	 * Returns all attributes of the form value1->value2 and << set >> value in a <<
	 * preserve >> node.
	 * 
	 * @param node the Henshin node.
	 * @return the changing attributes.
	 */
	public static List<AttributePair> getChangingAttributes(Node node) {
		List<AttributePair> changingAttributes = getAllChangingAttributes(node);

		for (Iterator<AttributePair> iterator = changingAttributes.iterator(); iterator.hasNext();) {
			AttributePair attribute = iterator.next();

			// Filter unconsidered attributes:
			if (DocumentType.isUnconsideredStructualFeature(attribute.getRhsAttribute().getType())) {
				iterator.remove();
			}
		}

		return changingAttributes;
	}

	private static List<AttributePair> getAllChangingAttributes(Node node) {
		Node rhsNode = HenshinRuleAnalysisUtil.getRHS(node);
		Node lhsNode = HenshinRuleAnalysisUtil.getLHS(node);

		if ((rhsNode != null) && (lhsNode != null)) {
			List<AttributePair> changingAttributes = new LinkedList<AttributePair>();

			for (Attribute rhsAttribute : rhsNode.getAttributes()) {
				Attribute lhsAttribute = HenshinRuleAnalysisUtil.getRemoteAttribute(
						rhsNode.getGraph().getRule().getMappings(), rhsAttribute);

				if (lhsAttribute == null) {
					// <<set>> value:
					changingAttributes.add(new AttributePair(null, rhsAttribute));
				} else {
					// value1->value2:
					if (!lhsAttribute.getValue().equals(rhsAttribute.getValue())) {
						changingAttributes.add(new AttributePair(lhsAttribute, rhsAttribute));
					}
				}
			}

			return changingAttributes;
		}
		return Collections.emptyList();
	}

	/**
	 * Returns all << preserve >> attributes of a rule and also << delete >>
	 * attributes in a << preserve >> node. A << delete >> attribute in a <<
	 * preserve >> node acts like a << preserve >> attribute.
	 * 
	 * @param rule the Henshin LHS node.
	 * @return the << preserve >> LHS attributes.
	 */
	public static List<Attribute> getPreservedAttributes(Node lhsNode) {
		List<Attribute> res = new LinkedList<Attribute>();

		for (Attribute lhsAttribute : lhsNode.getAttributes()) {
			Attribute rhsAttribute = HenshinRuleAnalysisUtil.getRemoteAttribute(
					lhsNode.getGraph().getRule().getMappings(), lhsAttribute);

			if (rhsAttribute == null) {
				// A <<delete>> attribute in a <<preserve>> node acts like a
				// <<preserve>> attribute.
				res.add(lhsAttribute);
			} else {
				if (lhsAttribute.getValue().equals(rhsAttribute.getValue())) {
					res.add(lhsAttribute);
				}
			}
		}

		return res;
	}
	
	/**
	 * @param node A typed node.
	 * @return <code>true</code> if the type is a concrete (none abstract,
	 *         interface) creation node, i.e., this allows type
	 *         parameters/replacements for abstract/interface creation nodes.
	 */
	public static boolean isStrictMatchingType(Node node) {
		return !(node.getType().isAbstract() || node.getType().isInterface()) && HenshinRuleAnalysisUtil.isCreationNode(node);
	}
}
