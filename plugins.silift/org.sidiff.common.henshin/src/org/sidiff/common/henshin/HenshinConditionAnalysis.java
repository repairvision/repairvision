package org.sidiff.common.henshin;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.findMappingByImage;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;

public class HenshinConditionAnalysis {

	/**
	 * Check whether the given node is a node of a nested condition.
	 * 
	 * @param node
	 *            The node to test.
	 * @return <code>true</code> if the node is part of a nested condition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isNestedConditionNode(Node node) {
		return node.getGraph().isNestedCondition();
	}

	/**
	 * Check whether the given edge is a edge of a nested condition.
	 * 
	 * @param edge
	 *            The edge to test.
	 * @return <code>true</code> if the edge is part of a nested condition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isNestedConditionEdge(Edge edge) {
		return edge.getGraph().isNestedCondition();
	}
	
	/**
	 * Check whether the given attribute is a attribute of a nested condition.
	 * 
	 * @param edge
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is part of a nested condition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isNestedConditionAttribute(Attribute attribute) {
		return attribute.getNode().getGraph().isNestedCondition();
	}
	
	/**
	 * @param condition
	 *            The nested condition.
	 * @return All embedded/mapped nodes as a hash set.
	 * 
	 * @see HenshinRuleAnalysisUtilEx#getEmbeddedNodes(Collection)
	 */
	public static Set<Node> getEmbeddedNodes(NestedCondition condition) {
		return HenshinRuleAnalysisUtilEx.getEmbeddedNodes(condition.getMappings());
	}
	
	/**
	 * @param condition
	 *            The nested condition.
	 * @param embeddedNodes
	 *            {@link HenshinConditionAnalysis#getEmbeddedNodes(NestedCondition)}
	 * @return All embedded/mapped edges as a hash set.
	 * 
	 * @see HenshinRuleAnalysisUtilEx#getEmbeddedEdges(Graph, Collection)
	 */
	public static Set<Edge> getEmbeddedEdges(NestedCondition condition, Collection<Node> embeddedNodes) {
		Set<Edge> embeddedNestedEdges = HenshinRuleAnalysisUtilEx.getEmbeddedEdges(condition.getConclusion(), embeddedNodes);
		return embeddedNestedEdges;
	}
	
	/**
	 * @param condition
	 *            The nested condition.
	 * @param embeddedNodes
	 *            {@link HenshinConditionAnalysis#getEmbeddedNodes(NestedCondition)}
	 * @return All embedded/mapped attributes as a hash set.
	 * 
	 * @see HenshinRuleAnalysisUtilEx#getEmbeddedAttributes(Graph, Collection)
	 */
	public static Set<Attribute> getEmbeddedAttributes(NestedCondition condition, Collection<Node> embeddedNodes) {
		Set<Attribute> embeddedNestedAttributes = HenshinRuleAnalysisUtilEx.getEmbeddedAttributes(condition.getConclusion(), embeddedNodes);
		return embeddedNestedAttributes;
	}
	
	/**
	 * An attribute is embedded if its corresponding node is embedded and if one
	 * of the mapped nodes contains the same attribute.
	 * 
	 * @param attribute
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is embedded; <code>false</code> otherwise.
	 * 
	 * @see HenshinRuleAnalysisUtilEx#isEmbedddeAttribute(Attribute)
	 */
	public static boolean isEmbedddeAttribute(Attribute attribute) {
		return HenshinRuleAnalysisUtilEx.isEmbedddeAttribute(attribute);
	}

	/**
	 * Checks whether the given node is an application condition (AC) boundary
	 * node. An AC boundary node is an AC context node with incident AC edges.
	 * 
	 * @param node
	 *            The node to test.
	 * @return <code>true</code> if the node is a glue node; <code>false</code>
	 *         otherwise.
	 */
	public static boolean isACBoundaryNode(Node node) {

		if (!isNestedConditionNode(node)) {
			return false;
		}

		if (isACContextNode(node)) {
			
			// Check for non-context edges:
			for (Edge edge : node.getAllEdges()) {
				if (!isACContextEdge(edge)) {
					return true;
				}
			}
			
			// Check for non-context attributes:
			for (Attribute attribute : node.getAttributes()) {
				if (!isACContextAttribute(attribute)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks whether this node is a context node of an application condition
	 * (AC). An AC context node is a node of an AC graph which is mapped to the
	 * LHS of the parent graph.
	 * 
	 * @param node
	 *            The node to test.
	 * @return <code>true</code> if the node is a context node;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isACContextNode(Node node) {

		if (!isNestedConditionNode(node)) {
			return false;
		}

		List<Mapping> mappings = ((NestedCondition) node.getGraph().eContainer()).getMappings();

		if (HenshinRuleAnalysisUtilEx.isNodeMapped(mappings, node)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks whether this edge is a context edge of an application condition
	 * (AC). An AC context edge is a edge of an AC graph which is mapped (by its
	 * source and target nodes) to the LHS of the parent graph.
	 * 
	 * @param edge
	 *            The edge to test.
	 * @return <code>true</code> if the edge is a context edge;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isACContextEdge(Edge edge) {

		if (!isNestedConditionEdge(edge)) {
			return false;
		}

		// Mappings for context AC nodes:
		List<Mapping> mappings = ((NestedCondition) edge.getGraph().eContainer()).getMappings();
		Mapping source_mapping = findMappingByImage(mappings, edge.getSource());
		Mapping target_mapping = findMappingByImage(mappings, edge.getTarget());

		// Is edge mapped?
		if ((source_mapping != null) && (target_mapping != null)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks whether this attribute is a context attribute of an application
	 * condition (AC). An AC context attribute is a attribute of an AC graph
	 * which is mapped (by its type) to a LHS attribute of the parent graph.
	 * 
	 * @param edge
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is a context attribute;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isACContextAttribute(Attribute attribute) {
		
		if (!isNestedConditionAttribute(attribute)) {
			return false;
		}

		List<Mapping> mappings = ((NestedCondition) attribute.getNode().getGraph().eContainer())
				.getMappings();
		Mapping mapping = findMappingByImage(mappings, attribute.getNode());

		// Is AC context node?
		if (mapping != null) {
			Node lhsNode = mapping.getOrigin();
			
			// Is mapped AC attribute?
			for (Attribute lhsAttribute : lhsNode.getAttributes()) {
				if (lhsAttribute.getType().equals(attribute.getType())) {
					return true;
				}
			}
		}
		
		return false;
	}
}
