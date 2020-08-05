package org.sidiff.revision.common.henshin;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;

/**
 * Utility methods for analyzing Henshin Modules, Units and Rules.
 */
public class HenshinRuleAnalysisUtil {

	/**
	 * @param node A LHS/RHS/Nested Condition node.
	 * @return The LHS node; <code>null</code> otherwise.
	 */
	public static Node getLHS(Node node) {
		if (node.getGraph().isLhs()) {
			return node;
		} else if (node.getGraph().isRhs()) {
			return getRemoteNode(node.getGraph().getRule().getMappings(), node);
	
		} else if (node.getGraph().isNestedCondition()) {
			return getRemoteNode(((NestedCondition) node.getGraph().eContainer()).getMappings(), node);
		}
		return null;
	}
	
	/**
	 * @param node A LHS/RHS/Nested Condition edge.
	 * @return The LHS edge; <code>null</code> otherwise.
	 */
	public static Edge getLHS(Edge edge) {
		if (edge.getGraph().isLhs()) {
			return edge;
		} else if (edge.getGraph().isRhs()) {
			return getRemoteEdge(edge.getGraph().getRule().getMappings(), edge);
	
		} else if (edge.getGraph().isNestedCondition()) {
			return getRemoteEdge(((NestedCondition) edge.getGraph().eContainer()).getMappings(), edge);
		}
		return null;
	}
	
	/**
	 * @param node A LHS/RHS/Nested Condition attribute.
	 * @return The LHS attribute; <code>null</code> otherwise.
	 */
	public static Attribute getLHS(Attribute attribute) {
		if (attribute.getGraph().isLhs()) {
			return attribute;
		} else if (attribute.getGraph().isRhs()) {
			return getRemoteAttribute(attribute.getGraph().getRule().getMappings(), attribute);
	
		}
		return null;
	}

	/**
	 * Searches the corresponding RHS node of the given LHS node.
	 * 
	 * @param rhsNode
	 *            A LHS node.
	 * @return The corresponding RHS node or <code>null</code> if no node was found.
	 */
	public static Node getRHS(Node lhsNode) {
		if (lhsNode != null) {
			if (lhsNode.getGraph().isRhs()) {
				return lhsNode;
			} else {
				return getRemoteNode(lhsNode.getGraph().getRule().getMappings(), lhsNode);
			}
		}
		return null;
	}

	/**
	 * @param node A LHS/RHS edge.
	 * @return The LHS edge; <code>null</code> otherwise.
	 */
	public static Edge getRHS(Edge edge) {
		if (edge.getGraph().isRhs()) {
			return edge;
		} else if (edge.getGraph().isLhs()) {
			return getRemoteEdge(edge.getGraph().getRule().getMappings(), edge);
	
		}
		return null;
	}
	
	/**
	 * @param node A LHS/RHS attribute.
	 * @return The LHS attribute; <code>null</code> otherwise.
	 */
	public static Attribute getRHS(Attribute attribute) {
		if (attribute.getGraph().isRhs()) {
			return attribute;
		} else if (attribute.getGraph().isLhs()) {
			return getRemoteAttribute(attribute.getNode().getGraph().getRule().getMappings(), attribute);
		}
		return null;
	}

	/**
	 * @param node A LHS/RHS/Nested Condition node.
	 * @return The LHS node if a mapping exists; the given node otherwise.
	 */
	public static Node tryLHS(Node node) {
		if (node.getGraph().isLhs()) {
			return node;
		} else if (node.getGraph().isRhs()) {
			Node lhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
	
			if (lhsNode != null) {
				return lhsNode;
			}
		} else if (node.getGraph().isNestedCondition()) {
			Node lhsNode = getRemoteNode(((NestedCondition) node.getGraph().eContainer()).getMappings(), node);
	
			if (lhsNode != null) {
				return lhsNode;
			}
		}
		return node;
	}
	
	/**
	 * @param node A LHS/RHS node.
	 * @return The RHS node if a mapping exists; the given node otherwise.
	 */
	public static Node tryRHS(Node node) {
		if (node.getGraph().isRhs()) {
			return node;
		} else if (node.getGraph().isLhs()) {
			Node rhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
	
			if (rhsNode != null) {
				return rhsNode;
			}
		}
		return node;
	}

	/**
	 * Returns the image or origin of the specified node. If the node is not part of
	 * a mapping, null will be returned. If the node is part of multiple mappings,
	 * only the first remote node is returned.
	 * 
	 * @param mappings All mappings to be searched.
	 * @param node     The node that is mapped.
	 * @return The mapped node.
	 */
	public static Node getRemoteNode(Collection<Mapping> mappings, Node node) {
		for (Mapping mapping : mappings) {
			if (mapping.getOrigin() == node) {
				return mapping.getImage();
			}
			if (mapping.getImage() == node) {
				return mapping.getOrigin();
			}
		}
	
		return null;
	}

	/**
	 * Returns the LHS/RHS attribute corresponding to the RHS/LHS attribute.
	 * 
	 * @param mappings All node mappings to be searched.
	 * @param attribute  the known attribute.
	 * @return the corresponding remote attribute or null if it not exists.
	 */
	public static Attribute getRemoteAttribute(Collection<Mapping> mappings, Attribute attribute) {
	
		if (attribute.getNode() == null) {
			return null;
		}
	
		Node node = attribute.getNode();
		Node remoteNode = getRemoteNode(mappings, attribute.getNode());
	
		if ((node != null) && (remoteNode != null)) {
			for (Attribute remoteAttribute : remoteNode.getAttributes()) {
				if (remoteAttribute.getType() == attribute.getType()) {
					return remoteAttribute;
				}
			}
		}
	
		return null;
	}

	/**
	 * Returns the LHS/RHS edge corresponding to the RHS/LHS edge.
	 * 
	 * @param mappings the node mappings of the corresponding rule.
	 * @param edge     the known edge.
	 * @return the corresponding remote edge.
	 */
	public static Edge getRemoteEdge(Collection<Mapping> mappings, Edge edge) {
		Node sourceNode = edge.getSource();
		Node targetNode = edge.getTarget();
	
		Node remoteSourceNode = getRemoteNode(mappings, sourceNode);
		Node remoteTargetNode = getRemoteNode(mappings, targetNode);
	
		if (remoteSourceNode != null && remoteTargetNode != null) {
			for (Edge remoteEdge : remoteSourceNode.getOutgoing()) {
				if (remoteEdge.getTarget() == remoteTargetNode
						&& edge.getType() == remoteEdge.getType()) {
					return remoteEdge;
				}
			}
		}
	
		return null;
	}
	
	/**
	 * @param mappings the node mappings of the corresponding embedding.
	 * @param node     The node to test.
	 * @return <code>true</code> if the given node is an embedded node which has
	 *         adjacent none embedded nodes or attributes; <code>false</code>
	 *         otherwise.
	 */
	public static boolean isBoundaryNode(Collection<Mapping> mappings, Node node) {
		if (getRemoteNode(mappings, node) != null) {
			
			for (Edge outgoing : node.getOutgoing()) {
				if (getRemoteNode(mappings, outgoing.getTarget()) == null) {
					return true;
				}
			}
			
			for (Edge incoming : node.getIncoming()) {
				if (getRemoteNode(mappings, incoming.getSource()) == null) {
					return true;
				}
			}
			
			for (Attribute attribute : node.getAttributes()) {
				if (getRemoteAttribute(mappings, attribute) == null) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * @param node A node within a containment edge.
	 * @return The containment edge containing the given node or <code>null</code>.
	 */
	public static EReference getContainingReference(Node node) {
		for (Edge incomingEdge : node.getIncoming()) {
			if (incomingEdge.getType().isContainment()) {
				return incomingEdge.getType();
			}
		}
		return null;
	}

	/**
	 * Returns all << delete >> edges of a rule.
	 * 
	 * @param rule the Henshin rule.
	 * @return the <<delete>> edges.
	 */
	public static List<Edge> getDeletionEdges(Rule rule) {
		List<Edge> res = new LinkedList<Edge>();
		
		for (Edge lhsEdge : rule.getLhs().getEdges()) {
			if (getRemoteEdge(rule.getMappings(), lhsEdge) == null) {
				res.add(lhsEdge);
			}
		}

		return res;
	}

	/**
	 * Returns all << delete >> nodes of a rule.
	 * 
	 * @param rule the Henshin rule.
	 * @return the << delete >> nodes.
	 */
	public static List<Node> getDeletionNodes(Rule rule) {
		List<Node> res = new LinkedList<Node>();
		
		for (Node lhsNode : rule.getLhs().getNodes()) {
			if (getRemoteNode(rule.getMappings(), lhsNode) == null) {
				res.add(lhsNode);
			}
		}

		return res;
	}

	/**
	 * Returns all << create >> edges of a rule.
	 * 
	 * @param rule the Henshin rule.
	 * @return the << create >> edges.
	 */
	public static List<Edge> getCreationEdges(Rule rule) {
		List<Edge> res = new LinkedList<Edge>();
		
		for (Edge rhsEdge : rule.getRhs().getEdges()) {
			if (getRemoteEdge(rule.getMappings(), rhsEdge) == null) {
				res.add(rhsEdge);
			}
		}

		return res;
	}

	/**
	 * Returns all << create >> nodes of a rule.
	 * 
	 * @param rule the Henshin rule.
	 * @return the << create >> nodes.
	 */
	public static List<Node> getCreationNodes(Rule rule) {
		List<Node> res = new LinkedList<Node>();
		
		for (Node rhsNode : rule.getRhs().getNodes()) {
			if (getRemoteNode(rule.getMappings(), rhsNode) == null) {
				res.add(rhsNode);
			}
		}

		return res;
	}

	/**
	 * Returns all << preserve >> edges of a rule.
	 * 
	 * @param rule the Henshin rule.
	 * @return the << preserve >> edges.
	 */
	public static List<Edge> getPreservedEdges(Rule r) {
		List<Edge> res = new LinkedList<Edge>();
		
		for (Edge lhsEdge : r.getLhs().getEdges()) {
			if (getRemoteEdge(r.getMappings(), lhsEdge) != null) {
				res.add(lhsEdge);
			}
		}

		return res;
	}

	/**
	 * Returns all LHS nodes of a rule which intersects with a RHS node. These nodes
	 * are << preserve >>.
	 * 
	 * @param rule the Henshin rule.
	 * @return the << preserve >> nodes.
	 */
	public static List<Node> getPreservedNodes(Rule rule) {
		List<Node> res = new LinkedList<Node>();
		
		for (Node lhsNode : rule.getLhs().getNodes()) {
			if (getRemoteNode(rule.getMappings(), lhsNode) != null) {
				res.add(lhsNode);
			}
		}

		return res;
	}
	
	/**
	 * Returns whether the Node is a LHS of a Rule.
	 * 
	 * @param node the node to test.
	 * @return whether the Node is a LHS of a Rule.
	 */
	public static boolean isLHSNode(Node node) {
		return node.getGraph().isLhs();
	}

	/**
	 * Returns whether the Edge is a LHS of a Rule.
	 * 
	 * @param edge the edge to test.
	 * @return whether the Edge is a LHS of a Rule.
	 */
	public static boolean isLHSEdge(Edge edge) {
		return edge.getGraph().isLhs();
	}

	/**
	 * Returns whether the Attribute is a LHS of a Rule.
	 * 
	 * @param attribute the attribute to test.
	 * @return whether the Attribute is a LHS of a Rule.
	 */
	public static boolean isLHSAttribute(Attribute attribute) {
		return isLHSNode(attribute.getNode());
	}

	/**
	 * Returns whether the Node is a RHS of a Rule.
	 * 
	 * @param node the node to test.
	 * @return whether the Node is a RHS of a Rule.
	 */
	public static boolean isRHSNode(Node node) {
		return node.getGraph().isRhs();
	}

	/**
	 * Returns whether the Edge is a RHS of a Rule.
	 * 
	 * @param edge the edge to test.
	 * @return whether the Edge is a RHS of a Rule.
	 */
	public static boolean isRHSEdge(Edge edge) {
		return edge.getGraph().isRhs();
	}

	/**
	 * Returns whether the Attribute is a RHS of a Rule.
	 * 
	 * @param attribute the attribute to test.
	 * @return whether the Attribute is a RHS of a Rule.
	 */
	public static boolean isRHSAttribute(Attribute attribute) {
		return isRHSNode(attribute.getNode());
	}

	/**
	 * Returns whether the node is << delete >> or not.
	 * 
	 * @param node the node to test.
	 * @return true if node is << delete >>; false otherwise.
	 */
	public static boolean isDeletionNode(Node node) {
	
		// Load node container
		Object container = node.getGraph().eContainer();
	
		// Container must be a Rule
		if (!(container instanceof Rule)) {
			return false;
		}
	
		// Rule that contains the node
		Rule rule = (Rule) container;
	
		for (Mapping mapping : rule.getMappings()) {
	
			// Node is preserve node
			if (mapping.getOrigin() == node) {
				return false;
			}
		}
	
		// Node is delete node
		if (rule.getLhs() == node.getGraph()) {
			return true;
		}
	
		// Node is create node
		return false;
	}

	/**
	 * Checks if the given edge represents a 'deletion' edge. This is the case, if
	 * it is contained in a LHS and if there is no corresponding image edge in the
	 * RHS.<br>
	 * 
	 * @param edge
	 * @return true if the edge could be identified to be a 'deletion' edge. In
	 *         every other case this method returns false.
	 */
	public static boolean isDeletionEdge(Edge edge) {
		Rule rule = edge.getGraph().getRule();
		return edge.getGraph().isLhs() && (getRemoteEdge(rule.getMappings(), edge) == null);
	}
	
	/**
	 * Is the given attribute a << delete >> attribute, i.e. the attribute is only
	 * in the LHS.
	 * 
	 * @param attribute the attribute to test.
	 * @return <code>true</code> if the attribute is a << delete >> attribute;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isDeletionAttribute(Attribute attribute) {
	
		// Attribute on RHS
		if (!isLHSAttribute(attribute)) {
			return false;
		}
	
		// Attribute has no LHS
		if (attribute.getGraph() != null && attribute.getGraph().getRule() != null) {
			if (getRemoteAttribute(attribute.getGraph().getRule().getMappings(), attribute) == null) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Returns whether the node is << create >> or not.
	 * 
	 * @param node the node to test.
	 * @return true if node is << create >>; false otherwise.
	 */
	public static boolean isCreationNode(Node node) {
	
		// Load node container
		Object container = node.getGraph().eContainer();
	
		// Container must be a Rule
		if (!(container instanceof Rule)) {
			return false;
		}
	
		// Rule that contains the node
		Rule rule = (Rule) container;
	
		for (Mapping mapping : rule.getMappings()) {
	
			// Node is preserve node
			if (mapping.getImage() == node) {
				return false;
			}
		}
	
		// Node is create node
		if (rule.getRhs() == node.getGraph()) {
			return true;
		}
	
		// Node is delete node
		return false;
	}

	/**
	 * Checks if the given edge represents a 'creation' edge. This is the case, if
	 * it is contained in a RHS and if there is no corresponding origin edge in the
	 * LHS.
	 * 
	 * @param edge
	 * @return true if the edge could be identified to be a 'creation' edge. In
	 *         every other case this method returns false.
	 */
	public static boolean isCreationEdge(Edge edge) {
		Rule rule = edge.getGraph().getRule();
		return edge.getGraph().isRhs() && (getRemoteEdge(rule.getMappings(), edge) == null);
	}

	/**
	 * Is the given attribute a << create >> attribute, i.e. the attribute is only
	 * in the RHS.
	 * 
	 * @param attribute the attribute to test.
	 * @return <code>true</code> if the attribute is a << create >> attribute;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isCreationAttribute(Attribute attribute) {
	
		// Attribute on RHS
		if (!isRHSAttribute(attribute)) {
			return false;
		}
	
		// Attribute has no LHS
		if (attribute.getGraph() != null && attribute.getGraph().getRule() != null) {
			if (getRemoteAttribute(attribute.getGraph().getRule().getMappings(), attribute) == null) {
				return true;
			}
		}
	
		return false;
	}

	/**
	 * Is the given attribute a << preserve >> attribute and LHS/RHS differs in
	 * value.
	 * 
	 * @param attribute the attribute to test.
	 * @return <code>true</code> if the attribute is a << preserve >> attribute and
	 *         LHS/RHS differs in value; <code>false</code> otherwise.
	 */
	public static boolean isModifyAttribute(Attribute attribute) {
		if (isPreservedNode(attribute.getNode())) {
			Attribute remoteAttribute = getRemoteAttribute(attribute.getNode().getGraph().getRule().getMappings(), attribute);
			
			if (remoteAttribute != null) {
				if (!remoteAttribute.getValue().equals(attribute.getValue())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns whether the node is << preserve >> or not.
	 * 
	 * @param node the node to test.
	 * @return true if node is << preserve >>; false otherwise.
	 */
	public static boolean isPreservedNode(Node node) {
	
		// Load node container
		Object container = node.getGraph().eContainer();
	
		// Container must be a Rule
		if (!(container instanceof Rule)) {
			return false;
		}
	
		// Rule that contains the node
		Rule rule = (Rule) container;
	
		for (Mapping mapping : rule.getMappings()) {
	
			// Node is preserve node
			if ((mapping.getOrigin() == node) || (mapping.getImage() == node)) {
				return true;
			}
		}
	
		// Node is not a preserve node
		return false;
	}

	/**
	 * Returns whether the edge is << preserve >> or not.
	 * 
	 * @param edge the edge to test.
	 * @return true if edge is << preserve >>; false otherwise.
	 */
	public static boolean isPreservedEdge(Edge edge) {
		Rule rule = edge.getGraph().getRule();
	
		// Test if edge is mapped
		if (getRemoteEdge(rule.getMappings(), edge) != null) {
			return true;
		}
	
		return false;
	}

	/**
	 * Returns whether this is a << preserve / delete >> attribute in a << preserve
	 * >> node or not.
	 * 
	 * @param node the node to test.
	 * @return <code>true</code> if this is a << preserve / delete >> attribute in a
	 *         << preserve >> node; <code>false</code> otherwise.
	 */
	public static boolean isPreservedAttribute(Attribute attribute) {
		
		Attribute remoteAttribute = getRemoteAttribute(attribute.getGraph().getRule().getMappings(), attribute);
		
		if (remoteAttribute != null) {
			// << preserve >> attribute in << preserve >> node?
			if (remoteAttribute.getValue() != null) {
				if (remoteAttribute.getValue().equals(attribute.getValue())) {
					return true;
				}
			} else {
				if (attribute.getValue() == null) {
					return true;
				}
			}
		} else {
			// << delete >> attribute in << preserve >> node?
			if (isPreservedNode(attribute.getNode()) && isLHSAttribute(attribute)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Returns whether the node is << require >> or not.
	 * 
	 * @param node the node to test.
	 * @return true if node is << require >>; false otherwise.
	 */
	public static boolean isRequireNode(Node node) {
		Object container = node.getGraph().eContainer();
	
		// Container must be a NestedCondition:
		if (!(container instanceof NestedCondition)) {
			return false;
		}
	
		// Nested condition that contains the node:
		NestedCondition nestedCondition = (NestedCondition) container;
	
		if (!(nestedCondition.isPAC())) {
			return false;
		}
	
		if (getRemoteNode(nestedCondition.getMappings(), node) == null) {
			return true;
		}

		return false;
	}

	/**
	 * Returns whether the edge is << require >> or not.
	 * 
	 * @param edge the edge to test.
	 * @return true if edge is << require >>; false otherwise.
	 */
	public static boolean isRequireEdge(Edge edge) {
		Object container = edge.getGraph().eContainer();
	
		// Container must be a NestedCondition:
		if (!(container instanceof NestedCondition)) {
			return false;
		}
	
		// Nested condition that contains the attribute:
		NestedCondition nestedCondition = (NestedCondition) container;
	
		if (!(nestedCondition.isPAC())) {
			return false;
		}
		
		if (getRemoteEdge(nestedCondition.getMappings(), edge) == null) {
			return true;
		}
	
		return false;
	}

	/**
	 * Checks if the given attribute is a << require >> attribute.
	 * 
	 * @param attribute The attribute to test.
	 * @return <code>true</code> if the attribute is a << require >> attribute;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isRequireAttribute(Attribute attribute) {
		Object container = attribute.getNode().getGraph().eContainer();
	
		// Container must be a NestedCondition:
		if (!(container instanceof NestedCondition)) {
			return false;
		}
	
		// Nested condition that contains the attribute:
		NestedCondition nestedCondition = (NestedCondition) container;
	
		if (!(nestedCondition.isPAC())) {
			return false;
		}
	
		if (getRemoteAttribute(nestedCondition.getMappings(), attribute) == null) {
			return true;
		}
	
		return false;
	}

	/**
	 * Returns whether the node is << forbid >> or not.
	 * 
	 * @param node the node to test.
	 * @return true if node is << forbid >>; false otherwise.
	 */
	public static boolean isForbiddenNode(Node node) {
		Object container = node.getGraph().eContainer();
		
		// Container must be a NestedCondition:
		if (!(container instanceof NestedCondition)) {
			return false;
		}
	
		// Nested condition that contains the node:
		NestedCondition nestedCondition = (NestedCondition) container;
	
		if (!(nestedCondition.isNAC())) {
			return false;
		}
	
		if (getRemoteNode(nestedCondition.getMappings(), node) == null) {
			return true;
		}

		return false;
	}

	/**
	 * Returns whether the edge is << forbid >> or not.
	 * 
	 * @param edge the edge to test.
	 * @return true if edge is << forbid >>; false otherwise.
	 */
	public static boolean isForbiddenEdge(Edge edge) {
		Object container = edge.getGraph().eContainer();

		// Container must be a NestedCondition:
		if (!(container instanceof NestedCondition)) {
			return false;
		}

		// Nested condition that contains the attribute:
		NestedCondition nestedCondition = (NestedCondition) container;

		if (!(nestedCondition.isNAC())) {
			return false;
		}
		
		if (getRemoteEdge(nestedCondition.getMappings(), edge) == null) {
			return true;
		}

		return false;
	}

	/**
	 * Returns whether the attribute is << forbid >> or not.
	 * 
	 * @param attribute the attribute to test.
	 * @return true if attribute is << forbid >>; false otherwise.
	 */
	public static boolean isForbiddenAttribute(Attribute attribute) {
		Object container = attribute.getNode().getGraph().eContainer();

		// Container must be a NestedCondition:
		if (!(container instanceof NestedCondition)) {
			return false;
		}

		// Nested condition that contains the attribute:
		NestedCondition nestedCondition = (NestedCondition) container;

		if (!(nestedCondition.isNAC())) {
			return false;
		}

		if (getRemoteAttribute(nestedCondition.getMappings(), attribute) == null) {
			return true;
		}

		return false;
	}
}
