package org.sidiff.common.utilities.henshin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Formula;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Not;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.utilities.henshin.pairs.EdgePair;
import org.sidiff.common.utilities.henshin.pairs.NodePair;

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
		// Now create new Node:
		Node newNode = HenshinFactory.eINSTANCE.createNode();
		newNode.setGraph(graph);
		newNode.setType(node.getType());
		newNode.setName(node.getName());
	
		// Copy attributes
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
	
		assert (src.getGraph() == tgt.getGraph()) : "Source and target node of the edge have to be in the same graph";
	
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
	 * @param type  The type of the node.
	 * @return The new created Node.
	 */
	public static Node createNode(Graph graph, EClass type) {
		// Now create new Node:
		Node newNode = HenshinFactory.eINSTANCE.createNode();
		newNode.setGraph(graph);
		newNode.setType(type);
		newNode.setName("");
		return newNode;
	}

	/**
	 * Creates a NAC/PAC edge between two nodes within a rule.
	 * 
	 * @param from Source node of the new edge.
	 * @param to   The target node of the new edge.
	 * @param type Edge type.
	 * @param rule The new created edge.
	 */
	public static Edge createEdge(Node from, Node to, EReference type, Graph graph) {
		Edge edge = HenshinFactory.eINSTANCE.createEdge(from, to, type);
		graph.getEdges().add(edge);
		return edge;
	}

	/**
	 * Creates a << preserve >> edge for the given rule. Expecting one source and
	 * one target NodePair
	 * 
	 * @param rule the Henshin rule.
	 * @param src  the source nodes of the new edge.
	 * @param tgt  the target nodes of the new edge.
	 * @param type the type of the new edge.
	 */
	public static EdgePair createPreservedEdge(Rule rule, NodePair src, NodePair tgt, EReference type) {
		Edge lhsEdge = HenshinFactory.eINSTANCE.createEdge(src.getLhsNode(), tgt.getLhsNode(), type);
		lhsEdge.setGraph(rule.getLhs());
	
		Edge rhsEdge = HenshinFactory.eINSTANCE.createEdge(src.getRhsNode(), tgt.getRhsNode(), type);
		rhsEdge.setGraph(rule.getRhs());
	
		return new EdgePair(lhsEdge, rhsEdge);
	}

	/**
	 * Creates a << preserve >> node with an String ("attrValue") attribute.
	 * 
	 * @param rule               the Henshin rule.
	 * @param name               the name of new the node.
	 * @param nodeType           the type of new the node.
	 * @param attrType           the type of the new attribute.
	 * @param attrValue          the attribute value.
	 * @param attributeOnlyInLHS set this to true if the attribute shall only be
	 *                           created in LHS.
	 * @return
	 */
	public static NodePair createPreservedNodeWithAttribute(Rule rule, String name, EClass nodeType,
			EAttribute attrType, String attrValue, Boolean attributeOnlyInLHS) {
		NodePair res = createPreservedNode(rule, name, nodeType);
		createPreservedAttribute(res, attrType, "\"" + attrValue + "\"", attributeOnlyInLHS);
	
		return res;
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
	 * @param onlyInLHS set this to true if the attribute shall only be created in
	 *                  LHS
	 */
	public static void createPreservedAttribute(NodePair node, EAttribute type, String value, Boolean onlyInLHS) {
		HenshinFactory.eINSTANCE.createAttribute(node.getLhsNode(), type, value);
		// We do not need RHS.
		// HenshinFactory.eINSTANCE.createAttribute(node.getRhsNode(), type, value);
	
		if (!onlyInLHS) {
			// Actually we do need RHS, otherwise the attribute will be a
			// <<delete>>, not a <<preserved>> one.
			HenshinFactory.eINSTANCE.createAttribute(node.getRhsNode(), type, value);
		}
	
	}

	/**
	 * Creates a << create >> node.
	 * 
	 * @param graph the graph under which the node should be created.
	 * @param name  the name of the new node.
	 * @param type  the type of the new node.
	 * @return the new node.
	 */
	public static Node createCreateNode(Graph graph, String name, EClass type) {
	
		Node newNode = HenshinFactory.eINSTANCE.createNode(graph, type, name);
		newNode.setName(name); // only required because of a bug in factory method createNode: name will not be
								// set.
	
		return newNode;
	}

	/**
	 * Creates a << create >> node.
	 * 
	 * @param name the name of the new node.
	 * @param type the type of the new node.
	 * @param rule the rule under which the node should be created.
	 * @return the new node.
	 */
	public static Node createCreateNode(String name, EClass type, Rule rule) {
	
		Node newNode = HenshinFactory.eINSTANCE.createNode(rule.getRhs(), type, name);
		newNode.setName(name); // only required because of a bug in factory method createNode: name will not be
								// set.
	
		return newNode;
	}

	/**
	 * Creates a << create >> edge between nodes and automatically for its opposite
	 * EReference.
	 * 
	 * @param from the source node.
	 * @param to   the target node.
	 * @param eRef the EReference.
	 */
	public static void createCreateEdge(Node from, Node to, EReference eRef) {
	
		HenshinFactory.eINSTANCE.createEdge(from, to, eRef);
	
		if (eRef.getEOpposite() != null) {
			HenshinFactory.eINSTANCE.createEdge(to, from, eRef.getEOpposite());
		}
	}

	/**
	 * Creates a << create >> attribute under a node and sets a name for the
	 * attribute value placeholder.
	 * 
	 * @param node  the node which should be given the attribute.
	 * @param type  the type of the attribute.
	 * @param value the name for the attribute value placeholder.
	 */
	public static void createCreateAttribute(Node node, EAttribute type, String value) {
		HenshinFactory.eINSTANCE.createAttribute(node, type, value);
	}

	/**
	 * Creates a << delete >> node in the LHS of a given rule.
	 * 
	 * @param name the name of the << delete >> node.
	 * @param type the type of the << delete >> node.
	 * @param rule the rule in which the << delete >> node will be created.
	 * @return the << delete >> node.
	 */
	public static Node createDeleteNode(String name, EClass type, Rule rule) {
	
		Node deleteNode = HenshinFactory.eINSTANCE.createNode(rule.getLhs(), type, name);
		deleteNode.setName(name); // only required because of a bug in factory method createNode: name will not be
									// set.
	
		return deleteNode;
	}

	/**
	 * Creates a << delete >> edge between two nodes within a rule.
	 * 
	 * @param from the context node.
	 * @param to   the target node.
	 * @param eRef the used EReference.
	 * @param rule the rule under which the nodes lie.
	 */
	public static void createDeleteEdge(Node from, Node to, EReference eRef, Rule rule) {
	
		Edge edge = HenshinFactory.eINSTANCE.createEdge(from, to, eRef);
		rule.getLhs().getEdges().add(edge);
	
		if (eRef.getEOpposite() != null) {
			Edge eOppositeEdge = HenshinFactory.eINSTANCE.createEdge(to, from, eRef.getEOpposite());
			rule.getLhs().getEdges().add(eOppositeEdge);
		}
	
	}

	/**
	 * Creates a << forbid >> node under a rule
	 * 
	 * @param rule the rule which shall contain the forbid node.
	 * @param type the type of the forbid node.
	 * @return the created Not-Object
	 */
	public static Node createForbidNode(Rule rule, EClass type) {
	
		// FIXME This method requires a differentiation of Formulas like Not, And, Or,
		// Xor..
	
		Formula formula = rule.getLhs().getFormula();
		NestedCondition nestedCondition = null;
		Not not = null;
	
		// check if there is already a Not and a NestedCondition
		if (formula != null) {
			not = (Not) formula; // formula is a not actually
			Formula childFormula = not.getChild();
			if (childFormula != null) {
				nestedCondition = (NestedCondition) childFormula;
			}
		}
		// else create new Not, Graph and NestedCondition
		else {
			not = HenshinFactory.eINSTANCE.createNot();
			Graph newGraph = HenshinFactory.eINSTANCE.createGraph();
			newGraph.setName("graph");
			nestedCondition = HenshinFactory.eINSTANCE.createNestedCondition();
			nestedCondition.setConclusion(newGraph);
		}
	
		// Now create new <<forbid>> Node
		Node newNode = HenshinFactory.eINSTANCE.createNode();
		newNode.setType(type);
		newNode.setGraph(nestedCondition.getConclusion());
		newNode.setName("");
	
		nestedCondition.getConclusion().getNodes().add(newNode);
		not.setChild(nestedCondition);
		rule.getLhs().setFormula(not);
	
		return newNode;
	}

	/**
	 * Creates a << forbid >> edge between two nodes within a rule.
	 * 
	 * @param from the context node.
	 * @param to   the target node.
	 * @param eRef the used EReference.
	 * @param rule the rule under which the nodes lie.
	 */
	public static Edge createForbidEdge(Node from, Node to, EReference eRef, Rule rule) {
	
		Edge edge = HenshinFactory.eINSTANCE.createEdge(from, to, eRef);
	
		if (rule.getLhs().getFormula() instanceof Not) {
			Not not = (Not) rule.getLhs().getFormula();
			NestedCondition nestedCond = (NestedCondition) not.getChild();
			nestedCond.getConclusion().getEdges().add(edge);
		}
	
		return edge;
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
	public static Rule createRule(String name, String description, Boolean activated, Module module) {
	
		Rule rule = HenshinFactory.eINSTANCE.createRule();
		rule.setName(name);
		rule.setDescription(description);
		rule.setActivated(activated);
		module.getUnits().add(rule);
	
		return rule;
	}

}
