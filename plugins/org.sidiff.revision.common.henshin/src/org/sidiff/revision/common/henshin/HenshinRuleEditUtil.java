package org.sidiff.revision.common.henshin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.revision.common.henshin.pairs.AttributePair;
import org.sidiff.revision.common.henshin.pairs.EdgePair;
import org.sidiff.revision.common.henshin.pairs.NodePair;

public class HenshinRuleEditUtil {

	/**
	 * Copies a given node into the given graph.
	 * 
	 * @param graph      The graph which will contain the node.
	 * @param node       The node to copy
	 * @param attributes Set <code>true</code> to copy all attributes;
	 *                   <code>false</code> otherwise;
	 * @return The new created Node.
	 */
	public static Node copyNode(Graph graph, Node node, boolean attributes) {
		Node newNode = HenshinFactory.eINSTANCE.createNode();
		newNode.setGraph(graph);
		newNode.setType(node.getType());
		newNode.setName(node.getName());
	
		if (attributes) {
			for (Attribute attribute : node.getAttributes()) {
				copyAttribute(newNode, attribute);
			}
		}
	
		return newNode;
	}

	/**
	 * Copies a given << preserve >> node into the given rule.
	 * 
	 * @param rule       The rule which will contain the node.
	 * @param node       The node to copy.
	 * @param attributes Set <code>true</code> to copy all attributes;
	 *                   <code>false</code> otherwise;
	 * @return The new created << preserve >> node.
	 */
	public static NodePair copyPreserveNodes(Rule rule, NodePair node, boolean attributes) {
		Node lhsNode = copyNode(rule.getLhs(), node.getLhsNode(), attributes);
		Node rhsNode = copyNode(rule.getRhs(), node.getRhsNode(), attributes);
	
		Mapping mapping = HenshinFactory.eINSTANCE.createMapping(lhsNode, rhsNode);
		rule.getMappings().add(mapping);
	
		return new NodePair(lhsNode, rhsNode);
	}

	/**
	 * Copies a given attribute into a given node.
	 * 
	 * @param node      The node which will contain the attribute.
	 * @param attribute The attribute to copy.
	 * @return The copied attribute.
	 */
	public static Attribute copyAttribute(Node node, Attribute attribute) {
		Attribute newAttribute = HenshinFactory.eINSTANCE.createAttribute();
		newAttribute.setType(attribute.getType());
		newAttribute.setValue(attribute.getValue());
	
		node.getAttributes().add(newAttribute);
	
		return newAttribute;
	}

	/**
	 * Copies a given edge into the graph of the source/target node.
	 * 
	 * @param src  The source node of the copied edge.
	 * @param tgt  The target node of the copied edge.
	 * @param edge The edge to copy.
	 * @return The copied edge.
	 */
	public static Edge copyEdge(Edge edge, Node src, Node tgt) {
		Edge newEdge = HenshinFactory.eINSTANCE.createEdge();
		newEdge.setIndex(edge.getIndex());
		newEdge.setSource(src);
		newEdge.setTarget(tgt);
		newEdge.setType(edge.getType());
	
		src.getGraph().getEdges().add(newEdge);
	
		return edge;
	}

	/**
	 * Copies a given parameter.
	 * 
	 * @param rule      The rule which will contain the copied parameter.
	 * @param parameter The parameter to copy.
	 * @return The copied parameter.
	 */
	public static Parameter copyParameter(Unit unit, Parameter parameter) {
		Parameter newParameter = HenshinFactory.eINSTANCE.createParameter();
		newParameter.setDescription(parameter.getDescription());
		newParameter.setName(parameter.getName());
		newParameter.setType(parameter.getType());
		newParameter.setUnit(unit);
		return newParameter;
	}

	/**
	 * Create a new node inside a given graph.
	 * 
	 * @param graph The graph which will contain the node.
	 * @param name The name of the node.
	 * @param type  The type of the node.
	 * @return The new created Node.
	 */
	public static Node createNode(Graph graph, String name, EClass type) {
		// Now create new Node:
		Node newNode = HenshinFactory.eINSTANCE.createNode();
		newNode.setGraph(graph);
		newNode.setType(type);
		newNode.setName(name);
		return newNode;
	}

	/**
	 * Creates an edge between two nodes within a rule.
	 * 
	 * @param source Source node of the new edge.
	 * @param target The target node of the new edge.
	 * @param type   Edge type.
	 * @param rule   The new created edge.
	 */
	public static Edge createEdge(Graph graph, Node source, EReference type, Node target) {
		Edge edge = HenshinFactory.eINSTANCE.createEdge(source, target, type);
		graph.getEdges().add(edge);
		return edge;
	}
	
	/**
	 * Creates an attribute between two nodes within a rule.
	 * 
	 * @param container The node containing the attribute.
	 * @param type      The attributes type.
	 * @param value     The assigned value of the attribute
	 * @return The new created attribute.
	 */
	public static Attribute createAttribute(Node container, EAttribute type, String value) {
		return HenshinFactory.eINSTANCE.createAttribute(container, type, value);
	}

	/**
	 * Creates a << preserve >> edge for the given rule. Expecting one source and
	 * one target NodePair
	 * 
	 * @param rule   the Henshin rule.
	 * @param source the source nodes of the new edge.
	 * @param target the target nodes of the new edge.
	 * @param type   the type of the new edge.
	 */
	public static EdgePair createPreservedEdge(Rule rule, NodePair source, EReference type, NodePair target) {
		Edge lhsEdge = HenshinFactory.eINSTANCE.createEdge(source.getLhsNode(), target.getLhsNode(), type);
		lhsEdge.setGraph(rule.getLhs());
	
		Edge rhsEdge = HenshinFactory.eINSTANCE.createEdge(source.getRhsNode(), target.getRhsNode(), type);
		rhsEdge.setGraph(rule.getRhs());
	
		return new EdgePair(lhsEdge, rhsEdge);
	}

	/**
	 * Creates a << preserve >> node.
	 * 
	 * @param rule the Henshin rule.
	 * @param name the name of the new node
	 * @param type the the type of new the node.
	 * @return
	 */
	public static NodePair createPreservedNode(Rule rule, String name, EClass type) {
		Node l = HenshinFactory.eINSTANCE.createNode();
		l.setName(name);
		l.setType(type);
		l.setGraph(rule.getLhs());
	
		Node r = HenshinFactory.eINSTANCE.createNode();
		r.setName(name);
		r.setType(type);
		r.setGraph(rule.getRhs());
	
		Mapping m = HenshinFactory.eINSTANCE.createMapping(l, r);
		rule.getMappings().add(m);
	
		return new NodePair(l, r);
	}

	/**
	 * Creates a << preserve >> attribute for the given node, i.e. it will create a
	 * LHS attribute in an << preserve >> node.
	 * 
	 * @param node      the node of the new attribute.
	 * @param type      the type of the new attribute.
	 * @param value     the value of the new attribute.
	 */
	public static AttributePair createPreservedAttribute(NodePair node, EAttribute type, String value) {
		Attribute lhsAttribute = HenshinFactory.eINSTANCE.createAttribute(node.getLhsNode(), type, value);
		Attribute rhsAttribute = HenshinFactory.eINSTANCE.createAttribute(node.getRhsNode(), type, value);
		return new AttributePair(lhsAttribute, rhsAttribute);
	}

	/**
	 * Creates a rule parameter if it not already exists.
	 * 
	 * @param rule the rule of the new parameter.
	 * @param name the name of the new parameter.
	 * @param type the type of the new parameter
	 * @return the new parameter or null if the parameter already exists.
	 */
	public static Parameter createParameter(Rule rule, String name, EClassifier type) {
	
		if (rule.getParameter(name) == null) {
			Parameter parameter = HenshinFactory.eINSTANCE.createParameter();
			parameter.setName(name);
			if (type != null) {
				parameter.setType(type);
			}
			rule.getParameters().add(parameter);
			return parameter;
		}
		return null;
	}

	/**
	 * Creates a rule under a given Module.
	 * 
	 * @param name        the name of the rule.
	 * @param description the description of the rule.
	 * @param activated   == true if rule should be activated.
	 * @param module      the module which shall contain the new rule.
	 * @return the rule.
	 */
	public static Rule createRule(Module module, String name, String description, Boolean activated) {
		Rule rule = HenshinFactory.eINSTANCE.createRule();
		rule.setName(name);
		rule.setDescription(description);
		rule.setActivated(activated);
		module.getUnits().add(rule);
	
		return rule;
	}

}
