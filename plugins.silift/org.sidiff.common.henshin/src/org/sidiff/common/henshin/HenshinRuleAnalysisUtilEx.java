package org.sidiff.common.henshin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Formula;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Not;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.common.henshin.view.EdgePair;
import org.sidiff.common.henshin.view.NodePair;

/**
 * Utility methods for analyzing Henshin Modules, Units and Rules.
 */
public class HenshinRuleAnalysisUtilEx {

	
	public static enum NodeKindSelection{
		CREATE,DELETE,PRESERVED,FORBID,ALL,REQUIRED
	}
	
	public static enum FormulaCombineOperator {
		AND,OR,XOR
	}
	

	/**
	 * Get all rules of the module.
	 * 
	 * @param module
	 *            the module.
	 * @return all Rules contained by the module in an unmodifiable list.
	 */
	public static EList<Rule> getRules(Module module) {
		EList<Rule> rules = new BasicEList<Rule>();
		
		for (Unit unit : module.getUnits()) {
			if (unit instanceof Rule) {
				Rule rule = (Rule) unit;
				rules.add(rule);
				rules.addAll(rule.getAllMultiRules());
			}
		}
		
		for (Module subModule : module.getSubModules()) {
			rules.addAll(getRules(subModule));
		}
		
		return ECollections.unmodifiableEList(rules);
	}

	/**
	 * @param rule
	 * @param nodename
	 * @param isLhs
	 * @return
	 */
	public static Node getNodeByName(Rule rule, String nodename, boolean isLhs) {
		for (Node node : (isLhs) ? rule.getLhs().getNodes() : rule.getRhs().getNodes()) {
			if (nodename.equals(node.getName())) {
				return node;
			}
		}
		
		return null;
	}
	
	/**
	 * Copies a given node into the given graph.
	 * 
	 * @param graph
	 *            The graph which will contain the node.
	 * @param node
	 *            The node to copy
	 * @param attributes
	 *            Set <code>true</code> to copy all attributes; <code>false</code> otherwise;
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
	 * @param rule
	 *            The rule which will contain the node.
	 * @param node
	 *            The node to copy.
	 * @param attributes
	 *            Set <code>true</code> to copy all attributes; <code>false</code> otherwise;
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
	 * @param node
	 *            The node which will contain the attribute.
	 * @param attribute
	 *            The attribute to copy.
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
	 * @param src
	 *            The source node of the copied edge.
	 * @param tgt
	 *            The target node of the copied edge.
	 * @param edge
	 *            The edge to copy.
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
	 * @param rule
	 *            The rule which will contain the copied parameter.
	 * @param parameter
	 *            The parameter to copy.
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
	 * @param graph
	 *            The graph which will contain the node.
	 * @param type
	 *            The type of the node.
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
	 * @param from
	 *            Source node of the new edge.
	 * @param to
	 *            The target node of the new edge.
	 * @param type
	 *            Edge type.
	 * @param rule
	 *            The new created edge.
	 */
	public static Edge createEdge(Node from, Node to, EReference type, Graph graph) {
		Edge edge = HenshinFactory.eINSTANCE.createEdge(from, to, type);
		graph.getEdges().add(edge);
		return edge;
	}

	/**
	 * Returns all attributes of a graph.
	 * 
	 * @param rule
	 *            The Henshin graph.
	 * @return A list of all attributes.
	 */
	public static List<Attribute> getAttributes(Graph graph) {
		List<Attribute> attributes = new LinkedList<Attribute>();

		for (Node node : graph.getNodes()) {
			attributes.addAll(node.getAttributes());
		}

		return attributes;
	}
	
	/**
	 * Creates a << preserve >> edge for the given rule.
	 * Expecting one source and one target NodePair
	 * @param rule
	 *            the Henshin rule.
	 * @param src
	 *            the source nodes of the new edge.
	 * @param tgt
	 *            the target nodes of the new edge.
	 * @param type
	 *            the type of the new edge.
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
	 * @param rule
	 *            the Henshin rule.
	 * @param name
	 *            the name of new the node.
	 * @param nodeType
	 *            the type of new the node.
	 * @param attrType
	 *            the type of the new attribute.
	 * @param attrValue
	 *            the attribute value.
	 * @param attributeOnlyInLHS
	 * 			  set this to true if the attribute shall only be created in LHS.
	 * @return
	 */
	public static NodePair createPreservedNodeWithAttribute(Rule rule, String name, EClass nodeType, EAttribute attrType, String attrValue, Boolean attributeOnlyInLHS) {
		NodePair res = createPreservedNode(rule, name, nodeType);
		createPreservedAttribute(res, attrType, "\"" + attrValue + "\"", attributeOnlyInLHS);

		return res;
	}

	/**
	 * Creates a << preserve >> node.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @param name
	 *            the name of the new node
	 * @param type
	 *            the the type of new the node.
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
	 * Creates a << preserve >> attribute for the given node, i.e. it will
	 * create a LHS attribute in an << preserve >> node.
	 * 
	 * @param node
	 *            the node of the new attribute.
	 * @param type
	 *            the type of the new attribute.
	 * @param value
	 *            the value of the new attribute.
	 * @param onlyInLHS
	 * 			  set this to true if the attribute shall only be created in LHS
	 */
	public static void createPreservedAttribute(NodePair node, EAttribute type, String value, Boolean onlyInLHS) {
		HenshinFactory.eINSTANCE.createAttribute(node.getLhsNode(), type, value);
		// We do not need RHS. 
		//HenshinFactory.eINSTANCE.createAttribute(node.getRhsNode(), type, value);
		
		if(!onlyInLHS) {
			// Actually we do need RHS, otherwise the attribute will be a
			// <<delete>>, not a <<preserved>> one.
			HenshinFactory.eINSTANCE.createAttribute(node.getRhsNode(), type, value);
		}

	}
	
	/**
	 * Creates a << create >> node.
	 * 
	 * @param graph
	 *            the graph under which the node should be created.
	 * @param name
	 *            the name of the new node.
	 * @param type
	 *            the type of the new node.
	 * @return the new node.
	 */
	public static Node createCreateNode(Graph graph, String name, EClass type) {

		Node newNode = HenshinFactory.eINSTANCE.createNode(graph, type, name);
		newNode.setName(name); // only required because of a bug in factory method createNode: name will not be set.

		return newNode;
	}
	
	/**
	 * Creates a << create >> node.
	 * 
	 * @param name
	 *            the name of the new node.
	 * @param type
	 *            the type of the new node.
	 * @param rule
	 *            the rule under which the node should be created.
	 * @return the new node.
	 */
	public static Node createCreateNode(String name, EClass type, Rule rule) {

		Node newNode = HenshinFactory.eINSTANCE.createNode(rule.getRhs(), type, name);
		newNode.setName(name); // only required because of a bug in factory method createNode: name will not be set.

		return newNode;
	}

	/**
	 * Creates a << create >> edge between nodes and automatically for its
	 * opposite EReference.
	 * 
	 * @param from
	 *            the source node.
	 * @param to
	 *            the target node.
	 * @param eRef
	 *            the EReference.
	 */
	public static void createCreateEdge(Node from, Node to, EReference eRef) {

		HenshinFactory.eINSTANCE.createEdge(from, to, eRef);
		
		if(eRef.getEOpposite()!=null) {
			HenshinFactory.eINSTANCE.createEdge(to, from, eRef.getEOpposite()); 
		}
	}

	/**
	 * Creates a << create >> attribute under a node and sets a name for the
	 * attribute value placeholder.
	 * 
	 * @param node
	 *            the node which should be given the attribute.
	 * @param type
	 *            the type of the attribute.
	 * @param value
	 *            the name for the attribute value placeholder.
	 */
	public static void createCreateAttribute(Node node, EAttribute type, String value) {

		HenshinFactory.eINSTANCE.createAttribute(node, type, value);

	}

	
	/**
	 * Creates a << delete >> node in the LHS of a given rule.
	 * 
	 * @param name
	 *            the name of the << delete >> node.
	 * @param type
	 *            the type of the << delete >> node.
	 * @param rule
	 *            the rule in which the << delete >> node will be created.
	 * @return the << delete >> node.
	 */
	public static Node createDeleteNode(String name, EClass type, Rule rule) {

		Node deleteNode = HenshinFactory.eINSTANCE.createNode(rule.getLhs(), type, name);
		deleteNode.setName(name); // only required because of a bug in factory method createNode: name will not be set.

		return deleteNode;
	}
	
	
	
	/**
	 * Creates a << delete >> edge between two nodes within a rule.
	 * 
	 * @param from
	 * 			 	the context node.
	 * @param to
	 * 				the target node.
	 * @param eRef
	 * 				the used EReference.
	 * @param rule
	 * 				the rule under which the nodes lie.
	 */
	public static void createDeleteEdge(Node from, Node to, EReference eRef, Rule rule) {
		
	
		Edge edge = HenshinFactory.eINSTANCE.createEdge(from, to, eRef);		
		rule.getLhs().getEdges().add(edge);
		
		if(eRef.getEOpposite()!=null) {
			Edge eOppositeEdge = HenshinFactory.eINSTANCE.createEdge(to, from, eRef.getEOpposite());
			rule.getLhs().getEdges().add(eOppositeEdge);
		}

	}
	
	
	
	
	/**
	 * Creates a << forbid >> node under a rule
	 * @param rule
	 * 				the rule which shall contain the forbid node.
	 * @param type
	 * 				the type of the forbid node.
	 * @return the created Not-Object
	 */
	public static Node createForbidNode(Rule rule, EClass type) {
		
		//FIXME This method requires a differentiation of Formulas like Not, And, Or, Xor..
		
		Formula formula = rule.getLhs().getFormula();
		NestedCondition nestedCondition = null;
		Not not = null;
		
		// check if there is already a Not and a NestedCondition
		if(formula!=null) {
			not = (Not) formula; // formula is a not actually
			Formula childFormula = not.getChild();
			if(childFormula!=null) {
				nestedCondition = (NestedCondition) childFormula;
			}
		}
		// else create new Not, Graph and NestedCondition
		else{
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
	 * @param from
	 * 			 	the context node.
	 * @param to
	 * 				the target node.
	 * @param eRef
	 * 				the used EReference.
	 * @param rule
	 * 				the rule under which the nodes lie.
	 */
	public static Edge createForbidEdge(Node from, Node to, EReference eRef, Rule rule) {

		Edge edge = HenshinFactory.eINSTANCE.createEdge(from, to, eRef);
		
		if(rule.getLhs().getFormula() instanceof Not) {
			Not not = (Not) rule.getLhs().getFormula();
			NestedCondition nestedCond = (NestedCondition) not.getChild();
			nestedCond.getConclusion().getEdges().add(edge);
		}
		
		return edge;
	}

	/**
	 * Creates a rule parameter if it not already exists.
	 * 
	 * @param rule
	 *            the rule of the new parameter.
	 * @param name
	 *            the name of the new parameter.
	 * @param type
	 * 			  the type of the new parameter
	 * @return the new parameter or null if the parameter already exists.
	 */
	public static Parameter createParameter(Rule rule, String name, EClassifier type) {

		if (rule.getParameter(name) == null) {
			Parameter parameter = HenshinFactory.eINSTANCE.createParameter();
			parameter.setName(name);
			if(type != null) {
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
	 * @param name
	 * 				the name of the rule.
	 * @param description
	 * 				the description of the rule.
	 * @param activated
	 * 				== true if rule should be activated.
	 * @param module
	 * 				the module which shall contain the new rule.
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

	/**
	 * Searches for a mapped unit parameter for given rule parameter.
	 * 
	 * @param mapping
	 *            the list of parameter mappings to be searched.
	 * @param ruleParameter
	 *            the rule parameter.
	 * @return the unit parameter or null if no mapping exists.
	 */
	public static ParameterMapping findUnitParamterMapping(List<ParameterMapping> mapping, Parameter ruleParameter) {

		for (ParameterMapping unitMapping : mapping) {
			if ((unitMapping.getSource() == ruleParameter) || (unitMapping.getTarget() == ruleParameter)) {
				return unitMapping;
			}
		}
		return null;
	}

	
	/**
	 * Finds the corresponding preserved node in LHS to a preserved Node in RHS
	 *
	 * @param rhsNode
	 * 				the node in RHS which shall be looked up in LHS.
	 * @return the corresponding LHS node.
	 */
	public static Node findCorrespondingNodeInLHS(Node rhsNode) {
		
		Rule rule = (Rule) rhsNode.getGraph().eContainer();
		
		Node lhsNode = null;
		for(Mapping mapping: rule.getMappings()) {
			if(mapping.getImage().equals(rhsNode)) {
				lhsNode = mapping.getOrigin();
			}
		}

		return lhsNode;
	}
	
	/**
	 * Finds the corresponding preserved node in RHS to a preserved Node in LHS
	 *
	 * @param lhsNode
	 * 				the node in LHS which shall be looked up in RHS.
	 * @return the corresponding RHS node.
	 */
	public static Node findCorrespondingNodeInRHS(Node lhsNode) {
		
		Rule rule = (Rule) lhsNode.getGraph().eContainer();
		
		Node rhsNode = null;
		for(Mapping mapping: rule.getMappings()) {
			if(mapping.getOrigin().equals(lhsNode)) {
				rhsNode = mapping.getImage();
			}
		}

		return rhsNode;
	}
	
	/**
	 * Finds the corresponding preserved edge in LHS to a preserved edge in RHS
	 *
	 * @param rhsNode
	 * 				the edge in RHS which shall be looked up in LHS.
	 * @return the corresponding LHS edge.
	 */
	public static Edge findCorrespondingEdgeInLHS(Edge rhsEdge) {				
		Node lhsSrc = findCorrespondingNodeInLHS(rhsEdge.getSource());
		Node lhsTgt = findCorrespondingNodeInLHS(rhsEdge.getTarget());
		
		for (Edge lhsEdge : lhsSrc.getOutgoing()) {
			if (lhsEdge.getTarget() == lhsTgt && lhsEdge.getType() == rhsEdge.getType()){
				return lhsEdge;
			}
		}
		
		assert (false) : "No lhs node found";
		return null;
	}

	/**
	 * @param rule
	 *            The rule from which the changes will be collected.
	 * @return All changes (<< delete >> / << create >> nodes / edges) of the
	 *         given rule.
	 */
	public static List<GraphElement> getChanges(Rule rule) {
		List<GraphElement> changes = new ArrayList<GraphElement>();

		// << delete >> nodes:
		for (Node deleteNode : getLHSMinusRHSNodes(rule)) {
			changes.add(deleteNode);
		}

		// << delete >> edges:
		for (Edge deleteEdge : getLHSMinusRHSEdges(rule)) {
			changes.add(deleteEdge);
		}

		// << create >> nodes:
		for (Node createNode : getRHSMinusLHSNodes(rule)) {
			changes.add(createNode);
		}

		// << create >> edges:
		for (Edge createEdge : getRHSMinusLHSEdges(rule)) {
			changes.add(createEdge);
		}
		
		// << create >> attributes (attribute value changes):
		for (NodePair preserveNode : getPreservedNodes(rule)) {
			changes.addAll(getChangingAttributes(preserveNode.getLhsNode(), preserveNode.getRhsNode()));
		}

		return changes;
	}
	
	/**
	 * @param lhs
	 *            The LHS node of the << preserve >> node.
	 * @param rhs
	 *            The RHS node of the << preserve >> node.
	 * @return All << create >> attributes of the << preserve >> node.
	 */
	public static List<Attribute> getChangingAttributes(Node lhs, Node rhs) {
		
		if (!rhs.getAttributes().isEmpty()) {
			List<Attribute> changingAttributes = new ArrayList<Attribute>(rhs.getAttributes().size());
			
			for (Attribute rhsAttribute : rhs.getAttributes()) {
				boolean hasRemote = false;
				
				for (Attribute lhsAttribute : lhs.getAttributes()) {
					if (lhsAttribute.getType() == rhsAttribute.getType()) {
						hasRemote = true;
						break;
					}
				}
				
				if (!hasRemote) {
					changingAttributes.add(rhsAttribute);
				}
			}
			
			return changingAttributes;
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * Returns all << delete >> edges of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the <<delete>> edges.
	 */
	public static List<Edge> getLHSMinusRHSEdges(Rule rule) {
		List<Edge> res = new LinkedList<Edge>();
		for (Edge lhsEdge : rule.getLhs().getEdges()) {
			if (!isEdgeMapped(rule.getMappings(), lhsEdge)) {
				res.add(lhsEdge);
			}
		}

		return res;
	}

	/**
	 * Returns all << delete >> nodes of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << delete >> nodes.
	 */
	public static List<Node> getLHSMinusRHSNodes(Rule rule) {
		List<Node> res = new LinkedList<Node>();
		for (Node lhsNode : rule.getLhs().getNodes()) {
			if (!isNodeMapped(rule.getMappings(), lhsNode)) {
				res.add(lhsNode);
			}
		}

		return res;
	}

	/**
	 * Returns all << create >> edges of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << create >> edges.
	 */
	public static List<Edge> getRHSMinusLHSEdges(Rule rule) {
		List<Edge> res = new LinkedList<Edge>();
		for (Edge rhsEdge : rule.getRhs().getEdges()) {
			if (!isEdgeMapped(rule.getMappings(), rhsEdge)) {
				res.add(rhsEdge);
			}
		}

		return res;
	}

	/**
	 * Returns all << create >> nodes of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << create >> nodes.
	 */
	public static List<Node> getRHSMinusLHSNodes(Rule rule) {
		List<Node> res = new LinkedList<Node>();
		for (Node rhsNode : rule.getRhs().getNodes()) {
			if (!isNodeMapped(rule.getMappings(), rhsNode)) {
				res.add(rhsNode);
			}
		}

		return res;
	}

	/**
	 * Returns all << preserve >> edges of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << preserve >> edges.
	 */
	public static List<Edge> getLHSIntersectRHSEdges(Rule r) {
		List<Edge> res = new LinkedList<Edge>();
		for (Edge lhsEdge : r.getLhs().getEdges()) {
			if (isEdgeMapped(r.getMappings(), lhsEdge)) {
				res.add(lhsEdge);
			}
		}

		return res;
	}

	/**
	 * Returns all LHS nodes of a rule which intersects with a RHS node. These nodes are << preserve >>.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << preserve >> nodes.
	 */
	public static List<Node> getLHSIntersectRHSNodes(Rule rule) {
		List<Node> res = new LinkedList<Node>();
		for (Node lhsNode : rule.getLhs().getNodes()) {
			if (isNodeMapped(rule.getMappings(), lhsNode)) {
				res.add(lhsNode);
			}
		}

		return res;
	}

	/**
	 * Returns all << preserve >> nodes of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << preserve >> nodes.
	 */
	public static List<NodePair> getPreservedNodes(Rule rule) {
		List<NodePair> res = new LinkedList<NodePair>();

		for (Node lhsNode : rule.getLhs().getNodes()) {
			Node rhsNode = getRemoteNode(rule.getMappings(), lhsNode);

			if (rhsNode != null) {
				res.add(new NodePair(lhsNode, rhsNode));
			}
		}

		return res;
	}

	
	/**
	 * Returns all forbid nodes (i.e. all nodes that are graphically displayed as 
	 * <<forbid>> node) under a rule.
	 * 
	 * @param rule
	 * 			under which to search.
	 * @return the list of forbid nodes.
	 */
	public static List<Node> getForbidNodes(Rule rule) {
		ArrayList<Node> forbidNodes = new ArrayList<Node>();
		
		for (NestedCondition nc : rule.getLhs().getNestedConditions()) {
			if (nc.eContainer() instanceof Not){
				// nc is a NAC
				for(Node node : nc.getConclusion().getNodes()) {
					// Mapped nodes are not part of the NAC.
					// Mapped nodes are needed e.g. <<forbid>> attribute in <<preserve>> node. 
					if(findMappingByImage(nc.getMappings(), node) == null) {
						forbidNodes.add(node);	
					}	
				}
			}
		}
		
		return forbidNodes;
	}
	
	/**
	 * Returns all require nodes (i.e. all nodes that are graphically displayed as 
	 * <<require>> node) under a rule.
	 * 
	 * @param rule
	 * 			under which to search.
	 * @return the list of require nodes.
	 */
	public static List<Node> getRequireNodes(Rule rule) {
		ArrayList<Node> forbidNodes = new ArrayList<Node>();
		
		for (NestedCondition nc : rule.getLhs().getNestedConditions()) {
			if (!(nc.eContainer() instanceof Not)){
				// nc is a PAC
				for(Node node : nc.getConclusion().getNodes()) {
					// Mapped nodes are not part of the NAC.
					// Mapped nodes are needed e.g. <<forbid>> attribute in <<preserve>> node. 
					if(findMappingByImage(nc.getMappings(), node) == null) {
						forbidNodes.add(node);	
					}	
				}
			}
		}
		
		return forbidNodes;
	}
	
	/**
	 * Returns all << preserve >> edges of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << preserve >> edges.
	 */
	public static List<EdgePair> getPreservedEdges(Rule r) {
		List<EdgePair> res = new LinkedList<EdgePair>();
		
		for (Edge lhsEdge : r.getLhs().getEdges()) {
			Edge lhsRemoteEdge = getRemoteEdge(r.getMappings(), lhsEdge);
			if (lhsRemoteEdge != null) {
				EdgePair nextEdgePair = new EdgePair(lhsEdge, lhsRemoteEdge);
				res.add(nextEdgePair);
			}
		}

		return res;
	}
	
	/**
	 * Returns all << forbid >> edges of a rule.
	 * 
	 * @param rule
	 * 			the Henshin rule.
	 * @return the << forbid >> edges.
	 * 
	 */
	public static List<Edge> getForbidEdges(Rule rule) {
		List<Edge> res = new LinkedList<Edge>();
		
		for (NestedCondition nc : rule.getLhs().getNestedConditions()) {
			if (nc.eContainer() instanceof Not){
				for (Edge edge : nc.getConclusion().getEdges()) {
					// Edge must not be mapped to LHS
					if (!isEdgeMapped(nc.getMappings(), edge)){
						res.add(edge);
					}		
				}	
			}
		}
		
		return res;
	}
	
	/**
	 * Returns all <<require>> edges of a rule.
	 * 
	 * @param rule
	 * 			the Henshin rule.
	 * @return the << require >> edges.
	 * 
	 */
	public static List<Edge> getRequireEdges(Rule rule) {
		List<Edge> res = new LinkedList<Edge>();
		
		for (NestedCondition nc : rule.getLhs().getNestedConditions()) {
			if (!(nc.eContainer() instanceof Not)){
				res.addAll(nc.getConclusion().getEdges());
			}
		}
		
		return res;
	}
	
	/**
	 * Checks if the given attribute is a << require >> attribute.
	 * 
	 * @param attribute
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is a << require >> attribute; <code>false</code> otherwise.
	 */
	public static boolean isRequireAttribute(Attribute attribute) {

		// Load attribute container:
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
		
		for (Mapping mapping : nestedCondition.getMappings()) {
			if (mapping.getImage() == attribute.getNode()) {
				// Node is a context attribute!
				for (Attribute originAttribute : mapping.getOrigin().getAttributes()) {
					if (originAttribute.getType().equals(attribute.getType())) {
						// Mapped Attribute:
						return false;
					}
				}
			}
		}

		// Attribute is require attribute!
		return true;
	}

	
	/**
	 * Returns whether the edge is << require >> or not.
	 * 
	 * @param edge
	 *            the edge to test.
	 * @return true if edge is << require >>; false otherwise.
	 */
	public static boolean isRequireEdge(Edge edge){
		return getRequireEdges(edge.getGraph().getRule()).contains(edge);
	}
	
	/**
	 * Returns all << preserve >> attributes of a rule and also << delete >>
	 * attributes in a << preserve >> node. A << delete >> attribute in a <<
	 * preserve >> node acts like a << preserve >> attribute.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << preserve >> attributes (LHS).
	 */
	public static List<Attribute> getPreservedAttributes(Rule rule) {
		List<Attribute> res = new LinkedList<Attribute>();
		for (Node lhsNode : getLHSIntersectRHSNodes(rule)) {
			for (Attribute lhsAttribute : lhsNode.getAttributes()) {
				Attribute rhsAttribute = getRemoteAttribute(lhsAttribute);

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
		}

		return res;
	}

	/**
	 * Returns all attributes of the form value1->value2.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the changing attributes.
	 */
	public static List<AttributePair> getLHStoRHSChangingAttributes(Rule rule) {
		List<AttributePair> res = new LinkedList<AttributePair>();

		for (Node lhsNode : getLHSIntersectRHSNodes(rule)) {
			for (Attribute lhsAttribute : lhsNode.getAttributes()) {
				Attribute rhsAttribute = getRemoteAttribute(lhsAttribute);

				if (rhsAttribute != null) {
					if (!lhsAttribute.getValue().equals(rhsAttribute.getValue())) {
						res.add(new AttributePair(lhsAttribute, rhsAttribute));
					}
				}
			}
		}

		return res;
	}

	/**
	 * Returns all << create >> attributes in a << preserve >> node.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << create >> attributes.
	 */
	public static List<Attribute> getRHSChangingAttributes(Rule rule) {
		List<Attribute> res = new LinkedList<Attribute>();

		for (Node rhsNode : rule.getRhs().getNodes()) {
			if (isNodeMapped(rule.getMappings(), rhsNode)) {
				for (Attribute rhsAttribute : rhsNode.getAttributes()) {
					Attribute lhsAttribute = getRemoteAttribute(rhsAttribute);

					if (lhsAttribute == null) {
						res.add(rhsAttribute);
					}
				}
			}
		}

		return res;
	}

	/**
	 * Returns all << delete >> attributes in a << delete >> node.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << delete >> attributes.
	 */
	public static List<Attribute> getDeletionAttributes(Rule rule) {
		List<Attribute> res = new LinkedList<Attribute>();

		for (Node lhsNode : getLHSMinusRHSNodes(rule)) {
			for (Attribute lhsAttribute : lhsNode.getAttributes()) {
				res.add(lhsAttribute);
			}
		}

		return res;
	}

	/**
	 * Returns all << create >> attributes in a << create >> node.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << create >> attributes.
	 */
	public static List<Attribute> getCreationAttributes(Rule rule) {
		List<Attribute> res = new LinkedList<Attribute>();

		for (Node rhsNode : getRHSMinusLHSNodes(rule)) {
			for (Attribute rhsAttribute : rhsNode.getAttributes()) {
				res.add(rhsAttribute);
			}
		}

		return res;
	}
	
	/**
	 * Returns all << forbid >> attributes of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << forbid >> attributes.
	 */
	public static List<Attribute> getForbidAttributes(Rule rule) {
		List<Attribute> res = new LinkedList<Attribute>();

		for (NestedCondition nc : rule.getLhs().getNestedConditions()) {
			if (nc.eContainer() instanceof Not){
				// nc is a NAC
				for(Node node : nc.getConclusion().getNodes()) {
					res.addAll(node.getAttributes());
				}
			}
		}
		
		return res;
	}
	
	/**
	 * Returns all << forbid >> attributes of a node.
	 * 
	 * @param rule
	 *            the node.
	 * @return the << forbid >> attributes.
	 */
	public static Set<Attribute> getForbidAttributes(Node node) {
		
		// Collect all << forbid >> nodes:
		List<Node> forbidNodes = new ArrayList<Node>();
		
		if(isForbiddenNode(node)) {
			// Given node is a forbid node:
			forbidNodes.add(node);
		} else {
			Node lhsNode;
			
			if(isLHSNode(node)) {
				lhsNode = node;
			} else {
				lhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
			}
			
			if (lhsNode != null) {
				for (NestedCondition nac : node.getGraph().getNACs()) {
					Node forbidNode = getRemoteNode(nac.getMappings(), lhsNode);
					
					if (forbidNode != null) {
						forbidNodes.add(forbidNode);
					}
				}
			} else {
				return Collections.emptySet();
			}
		}
		
		// Collect all << forbid >> attributes:
		Set<Attribute> forbidAttributes = new HashSet<Attribute>();
		
		for (Node forbidNode : forbidNodes) {
			forbidAttributes.addAll(forbidNode.getAttributes());
		}
		
		return forbidAttributes;
	}
	
	/**
	 * Returns all incident << forbid >> edges of a node.
	 * 
	 * @param rule
	 *            the node.
	 * @return the << forbid >> edges.
	 */
	public static Set<Edge> getForbidEdges(Node node) {
		
		// Collect all << forbid >> nodes:
		List<Node> forbidNodes = new ArrayList<Node>();
		
		if(isForbiddenNode(node)) {
			// Given node is a forbid node:
			forbidNodes.add(node);
		} else {
			Node lhsNode;
			
			if(isLHSNode(node)) {
				lhsNode = node;
			} else {
				lhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
			}
			
			if (lhsNode != null) {
				for (NestedCondition nac : node.getGraph().getNACs()) {
					Node forbidNode = getRemoteNode(nac.getMappings(), lhsNode);
					
					if (forbidNode != null) {
						forbidNodes.add(forbidNode);
					}
				}
			} else {
				return Collections.emptySet();
			}
		}
		
		// Collect all << forbid >> attributes:
		Set<Edge> forbidEdges = new HashSet<Edge>();
		
		for (Node forbidNode : forbidNodes) {
			forbidEdges.addAll(forbidNode.getAllEdges());
		}
		
		return forbidEdges;
	}
	
	/**
	 * Returns all << require >> attributes of a rule.
	 * 
	 * @param rule
	 *            the Henshin rule.
	 * @return the << require >> attributes.
	 */
	public static List<Attribute> getRequireAttributes(Rule rule) {
		List<Attribute> res = new LinkedList<Attribute>();

		for (NestedCondition nc : rule.getLhs().getNestedConditions()) {
			if (!(nc.eContainer() instanceof Not)){
				// nc is a PAC
				for(Node node : nc.getConclusion().getNodes()) {
					res.addAll(node.getAttributes());
				}
			}
		}
		
		return res;
	}
	
	/**
	 * Returns all << require >> attributes of a node.
	 * 
	 * @param rule
	 *            the node.
	 * @return the << require >> attributes.
	 */
	public static Set<Attribute> getRequireAttributes(Node node) {
		
		// Collect all << forbid >> nodes:
		List<Node> requireNodes = new ArrayList<Node>();
		
		if(isRequireNode(node)) {
			// Given node is a forbid node:
			requireNodes.add(node);
		} else {
			Node lhsNode;
			
			if(isLHSNode(node)) {
				lhsNode = node;
			} else {
				lhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
			}
			
			if (lhsNode != null) {
				for (NestedCondition nac : node.getGraph().getPACs()) {
					Node requireNode = getRemoteNode(nac.getMappings(), lhsNode);
					
					if (requireNode != null) {
						requireNodes.add(requireNode);
					}
				}
			} else {
				return Collections.emptySet();
			}
		}
		
		// Collect all << require >> attributes:
		Set<Attribute> requireAttributes = new HashSet<Attribute>();
		
		for (Node requireNode: requireNodes) {
			requireAttributes.addAll(requireNode.getAttributes());
		}
		
		return requireAttributes;
	}
	
	/**
	 * Returns all incident << require >> edges of a node.
	 * 
	 * @param rule
	 *            the node.
	 * @return the << require >> edges.
	 */
	public static Set<Edge> getRequireEdges(Node node) {
		
		// Collect all << forbid >> nodes:
		List<Node> requireNodes = new ArrayList<Node>();
		
		if(isRequireNode(node)) {
			// Given node is a forbid node:
			requireNodes.add(node);
		} else {
			Node lhsNode;
			
			if(isLHSNode(node)) {
				lhsNode = node;
			} else {
				lhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
			}
			
			if (lhsNode != null) {
				for (NestedCondition nac : node.getGraph().getPACs()) {
					Node requireNode = getRemoteNode(nac.getMappings(), lhsNode);
					
					if (requireNode != null) {
						requireNodes.add(requireNode);
					}
				}
			} else {
				return Collections.emptySet();
			}
		}
		
		// Collect all << require >> attributes:
		Set<Edge> requireAttributes = new HashSet<Edge>();
		
		for (Node requireNode: requireNodes) {
			requireAttributes.addAll(requireNode.getAllEdges());
		}
		
		return requireAttributes;
	}

	/**
	 * Returns the LHS/RHS attribute corresponding to the RHS/LHS attribute.
	 * 
	 * @param attribute
	 *            the known attribute.
	 * @return the corresponding remote attribute or null if it not exists.
	 */
	public static Attribute getRemoteAttribute(Attribute attribute) {
		
		if (attribute.getNode().getGraph().getRule() == null) {
			return null;
		}
		
		Node node = attribute.getNode();
		Node remoteNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);

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
	 * This method searches in LHS and RHS for Nodes with given EClass and given name.
	 * 
	 * @param rule
	 * 				the rule in which to search for nodes.
	 * @param eClass
	 * 				the type which a node must have.
	 * @param name
	 * 				the name which a node must have.
	 * @return the NodePair.
	 */
	public static NodePair getNodePair(Rule rule, EClass eClass, String name) {
		
		NodePair nodePair = null;
		Node nodeLHS = null;
		Node nodeRHS = null;
		
		for(Node n: rule.getLhs().getNodes()) {
			if(n.getType().equals(eClass) && n.getName().equals(name)) {
				nodeLHS = n;
			}
		}

		for(Node n: rule.getRhs().getNodes()) {
			if(n.getType().equals(eClass) && n.getName().equals(name)) {
				nodeRHS = n;
			}
		}
		
		nodePair = new NodePair(nodeLHS, nodeRHS);
		
		return nodePair;
	}
	
	
	/**
	 * Gets all nodes from a node list where their type equals the type argument and the eRef argument
	 * is the reference type of one connected edge.
	 * @param type
	 * 				the type a node has to match.
	 * @param eRef
	 * 				the EReference one of the node's edge types has to match.
	 * @param isIncomingERef
	 * 				true if EReference is an incoming edge for the node.
	 * @param allNodes
	 * 				list of nodes to apply match.
	 * @return list of matched nodes.
	 */
	public static List<Node> getNodesBy(EClass type, EReference eRef, Boolean isIncomingERef, List<Node> allNodes) {

		ArrayList<Node> nodeList = new ArrayList<Node>();

		for(Node n: allNodes) {

			if(n.getType().equals(type) && isIncomingERef && !n.getIncoming().isEmpty()) {			
				for(Edge e: n.getIncoming()) {
					if(e.getType().equals(eRef)) {
						nodeList.add(n);
					}
				}				
			}
			if(n.getType().equals(type) && !isIncomingERef && !n.getOutgoing().isEmpty()) {
				for(Edge e: n.getOutgoing()) {
					if(e.getType().equals(eRef)) {

						nodeList.add(n);
					}
				}			
			}

		}

		return nodeList;
	}
	
	/**
	 * Returns a list of (abstract) child nodes which are part of a containment edge reference.
	 * @param allNodes
	 * 				the input nodes to check.
	 * @param nodeKind
	 * 				the node kind which shall be looked for.
	 * @param onlyAbstracts
	 * 				if true, only containment relations with abstract children are considered.
	 * @return the nodes that match.
	 */
	public static List<Node> getChildNodesWithinAContainmentRelation(Module module, NodeKindSelection nodeKind, Boolean onlyAbstracts) {
	
		ArrayList<Node> nodeList = new ArrayList<Node>();
		ArrayList<Node> resultList = new ArrayList<Node>();
		
		// choose the correct nodeList
		for(Unit u: module.getUnits()) {
			if(u instanceof Rule){
				
				Rule r = (Rule) u;
				switch(nodeKind) {
					case CREATE: 
						nodeList.addAll(getRHSMinusLHSNodes(r));
						break;
					case DELETE:
						nodeList.addAll(getLHSMinusRHSNodes(r));
						break;
					case PRESERVED:
						nodeList.addAll(getLHSIntersectRHSNodes(r));
						break;
					case FORBID: 
						nodeList.addAll(getForbidNodes(r));
						break;
					case ALL:
						nodeList.addAll(r.getLhs().getNodes());
						nodeList.addAll(r.getRhs().getNodes());
						break;
				default:
					break;		
				}
			}
		}

		// search for nodes which are connected to other nodes via a composite edge
		for(Node n: nodeList) {
	
			for(Edge e: n.getIncoming()) {
				// only add nodes that are abstract children
				if(onlyAbstracts && e.getType().isContainment() && n.getType().isAbstract() && !resultList.contains(n)) {		
					resultList.add(n);
				}
				// only add nodes that are children
				else if(!onlyAbstracts && e.getType().isContainment() && !resultList.contains(n)) {
					resultList.add(n);
				}
			}				

		}
		
		return resultList;
	
	}
	

	
	/**
	 * Returns a parameter under a given unit if its name equals the given name.
	 * A unit can also be a Rule.
	 * 
	 * @param unit
	 * 				the unit/rule under which the parameter is assumed
	 * @param name
	 * 				the name a parameter must match
	 * @return parameter
	 * 				the matching parameter
	 */
	public static Parameter getParameterByName(Unit unit, String name) {
		
		for(Parameter p: unit.getParameters()) {
			String pName = p.getName();
			
			if(pName.equals(name)) {
				return p;
			}			
		}
		return null;	
	}
	
	/**
	 * Returns the number of parameters contained in the given rule.
	 * @param  rulee
	 * @return number of parameters 
	 */
	public static int getNumberOfParameters(Rule rule){
		
		return rule.getParameters().size();
	}
	
	/**
	 * This function is copied from the Henshin ModelHelper but enhanced with a
	 * type check: An edge is only mapped if the type of the remoteEdge is also
	 * equal. Mapping of source and target node is not sufficient.
	 * 
	 * @param mappings
	 *            the node mappings of the corresponding rule.
	 * @param edge
	 *            the known edge.
	 * @return true if edge is mapped; false otherwise.
	 */
	public static boolean isEdgeMapped(List<Mapping> mappings, Edge edge) {
		Node sourceNode = edge.getSource();
		Node targetNode = edge.getTarget();

		Node remoteSourceNode = getRemoteNode(mappings, sourceNode);
		Node remoteTargetNode = getRemoteNode(mappings, targetNode);

		if (remoteSourceNode != null && remoteTargetNode != null) {
			for (Edge remoteEdge : remoteSourceNode.getOutgoing()) {
				if (remoteEdge.getTarget() == remoteTargetNode && equalReferenceType(edge.getType(), remoteEdge.getType())) {
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Returns the LHS/RHS edge corresponding to the RHS/LHS edge.
	 * 
	 * @param mappings
	 *            the node mappings of the corresponding rule.
	 * @param edge
	 *            the known edge.
	 * @return the corresponding remote edge.
	 */
	public static Edge getRemoteEdge(List<Mapping> mappings, Edge edge) {
		Node sourceNode = edge.getSource();
		Node targetNode = edge.getTarget();

		Node remoteSourceNode = getRemoteNode(mappings, sourceNode);
		Node remoteTargetNode = getRemoteNode(mappings, targetNode);

		if (remoteSourceNode != null && remoteTargetNode != null) {
			for (Edge remoteEdge : remoteSourceNode.getOutgoing()) {
				if (remoteEdge.getTarget() == remoteTargetNode && equalReferenceType(edge.getType(), remoteEdge.getType())) {
					return remoteEdge;
				}
			}
		}

		return null;
	}

	/**
	 * Compares two EReferences. The compare differentiate between proxy and
	 * resolved EMF instances.
	 * 
	 * @param r1
	 *            the first EReference
	 * @param r2
	 *            the second EReference
	 * @return true if the types are equal; false otherwise.
	 */
	public static boolean equalReferenceType(EReference r1, EReference r2) {
		if (r1.eIsProxy() && r2.eIsProxy()) {
			return EcoreUtil.getURI(r1).equals(EcoreUtil.getURI(r2));
		} else if (!r1.eIsProxy() && !r2.eIsProxy()) {
			return r1.equals(r2);
		} else {
			return false;
		}
	}

	public static Attribute getAttributeByType(Collection<Attribute> attributes, EAttribute type) {
		for (Attribute attribute : attributes) {
			if (attribute.getType().equals(type)) {
				return attribute;
			}
		}
		return null;
	}

	/**
	 * Returns the mapping of the image and origin node or null if no mapping
	 * exists.
	 * 
	 * @param mappings
	 *            the mappings to search.
	 * @param origin
	 *            the origin node.
	 * @param image
	 *            the image node.
	 * @return the node mapping or null if no mapping exists.
	 */
	public static Mapping findMapping(Collection<Mapping> mappings, Node origin, Node image) {
		for (Mapping mapping : mappings) {
			if (mapping.getImage() == image && mapping.getOrigin() == origin) {
				return mapping;
			}
		}
		return null;
	}

	/**
	 * Returns the mapping of the origin node or null if no mapping exists.
	 * 
	 * @param mappings
	 *            the mappings to search.
	 * @param origin
	 *            the origin node.
	 * @return the node mapping or null if no mapping exists.
	 */
	public static Mapping findMappingByOrigin(Collection<Mapping> mappings, Node origin) {
		for (Mapping mapping : mappings) {
			if (mapping.getOrigin() == origin) {
				return mapping;
			}
		}
		return null;
	}

	/**
	 * Returns the mapping of the image node or null if no mapping exists.
	 * 
	 * @param mappings
	 *            the mappings to search.
	 * @param image
	 *            the image node.
	 * @return the node mapping or null if no mapping exists.
	 */
	public static Mapping findMappingByImage(Collection<Mapping> mappings, Node image) {
		for (Mapping mapping : mappings) {
			if (mapping.getImage() == image) {
				return mapping;
			}
		}
		return null;
	}

	/**
	 * Returns the unit with the given name.
	 * 
	 * @param name
	 *            the unit name.
	 * @param units
	 *            the unit list to search.
	 * @return the unit with the given name.
	 */
	public static Unit getUnitByName(String name, List<Unit> units) {
		for (Unit unit : units) {
			if ((unit.getName() != null) && unit.getName().equalsIgnoreCase(name)) {
				return unit;
			}
		}
		return null;
	}
	
	/**
	 * Returns whether the node is << preserve >> or not.
	 * 
	 * @param node
	 *            the node to test.
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
	 * @param edge
	 *            the edge to test.
	 * @return true if edge is << preserve >>; false otherwise.
	 */
	public static boolean isPreservedEdge(Edge edge) {

		// Edge must be connected and part of Rule
		if ((edge.getSource() != null) && (edge.getTarget() != null) && (edge.getGraph() != null) && (edge.getGraph().getRule() != null)) {

			Rule rule = edge.getGraph().getRule();

			// Test if edge is mapped
			if ((getEdgeOrigin(edge, rule.getMappings()) != null)
					|| (getEdgeImage(edge, rule.getRhs(), rule.getMappings()) != null)) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Returns whether this is a << preserve / delete >> attribute in a <<
	 * preserve >> node or not.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code>true</code> if this is a << preserve / delete >> attribute
	 *         in a << preserve >> node; <code>false</code> otherwise.
	 */
	public static boolean isPreservedAttribute(Attribute attribute) {

		if (getRemoteAttribute(attribute) != null) {
			// << preserve >> attribute in << preserve >> node:
			return true;
		} else {
			if (isPreservedNode(attribute.getNode()) && isLHSAttribute(attribute)) {
				// << delete >> attribute in << preserve >> node:
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns whether the node is << delete >> or not.
	 * 
	 * @param node
	 *            the node to test.
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
	 * Returns whether the node is << create >> or not.
	 * 
	 * @param node
	 *            the node to test.
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
	 * Is the given attribute a << preserve >> attribute and LHS/RHS differs in value.
	 * 
	 * @param attribute
	 *            the attribute to test.
	 * @return <code>true</code> if the attribute is a << preserve >> attribute
	 *         and LHS/RHS differs in value; <code>false</code> otherwise.
	 */
	public static boolean isChangingAttribute(Attribute attribute){
		if(isPreservedNode(attribute.getNode())){
			Attribute remoteAttribute = getRemoteAttribute(attribute);
			if(remoteAttribute != null){
				if(!remoteAttribute.getValue().equals(attribute.getValue())){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Is the given attribute a << create >> attribute in a << preserve >> node.
	 * 
	 * @param attribute
	 *            the attribute to test.
	 * @return <code>true</code> if the attribute is a << create >> attribute in a << preserve >> node;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isRHSChangingAttribute(Attribute attribute) {

		// Parent node is a << preserve >> node
		if (isPreservedNode(attribute.getNode())) {

			// Attribute has no LHS
			if (getRemoteAttribute(attribute) == null) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Is the given attribute a << create >> attribute, i.e. the attribute is only in the RHS.
	 * 
	 * @param attribute
	 *            the attribute to test.
	 * @return <code>true</code> if the attribute is a << create >> attribute; <code>false</code> otherwise.
	 */
	public static boolean isCreationAttribute(Attribute attribute) {
		
		// Attribute on RHS
		if (!isRHSAttribute(attribute)) {
			return false;
		}
		
		// Attribute has no LHS
		if (getRemoteAttribute(attribute) == null) {
			return true;
		}
		
		return false;
	}

	/**
	 * Returns whether the node is << forbid >> or not.
	 * 
	 * @param node
	 *            the node to test.
	 * @return true if node is << forbid >>; false otherwise.
	 */
	public static boolean isForbiddenNode(Node node) {

		// Load node container:
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
		
		for (Mapping mapping : nestedCondition.getMappings()) {
			if (mapping.getImage() == node) {
				// Node is a context node!
				return false;
			}
		}

		// Node is forbid note!
		return true;
	}
	
	/**
	 * Returns whether the node is << require >> or not.
	 * 
	 * @param node
	 *            the node to test.
	 * @return true if node is << require >>; false otherwise.
	 */
	public static boolean isRequireNode(Node node) {

		// Load node container:
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
		
		for (Mapping mapping : nestedCondition.getMappings()) {
			if (mapping.getImage() == node) {
				// Node is a context node!
				return false;
			}
		}

		// Node is require note!
		return true;
	}
	
	/**
	 * Returns whether the edge is << forbid >> or not.
	 * 
	 * @param edge
	 *            the edge to test.
	 * @return true if edge is << forbid >>; false otherwise.
	 */
	public static boolean isForbiddenEdge(Edge edge) {

		// Load edge container
		EObject nestedCondition = edge.getGraph().eContainer();

		// Container must be a NestedCondition
		if (nestedCondition instanceof NestedCondition) {
			// Container of NestedCondition must be Not
			if (nestedCondition.eContainer() instanceof Not) {
				// Edge must not be mapped to LHS
				if (!isEdgeMapped(((NestedCondition)nestedCondition).getMappings(), edge)){
					return true;
				}					
			}
		}

		return false;
	}
	
	public static boolean isForbiddenAttribute(Attribute attribute) {
		
		// Load attribute container
		EObject nestedCondition = attribute.getNode().getGraph().eContainer();

		// Container must be a NestedCondition
		if (nestedCondition instanceof NestedCondition) {
			// Container of NestedCondition must be Not
			if (nestedCondition.eContainer() instanceof Not) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Checks whether two nodes n1 and n2 have the same node identifiers (names).
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static boolean haveEqualNodeIdentifiers(Node n1, Node n2) {
		if (n1.getName() == null && n2.getName() == null) {
			return true;
		} else if (n1.getName() == null && n2.getName() != null) {
			return false;
		} else if (n1.getName() != null && n2.getName() == null) {
			return false;
		} else {
			return n1.getName().equals(n2.getName());
		}
	}
	
	/**
	 * Returns whether the Node is a LHS of a Rule.
	 * 
	 * @param node
	 *            the node to test.
	 * @return whether the Node is a LHS of a Rule.
	 */
	public static boolean isLHSNode(Node node) {
		return node.getGraph().isLhs();
	}
	
	/**
	 * Returns whether the Edge is a LHS of a Rule.
	 * 
	 * @param edge
	 *            the edge to test.
	 * @return whether the Edge is a LHS of a Rule.
	 */
	public static boolean isLHSEdge(Edge edge) {
		return edge.getGraph().isLhs();
	}
	
	/**
	 * Returns whether the Attribute is a LHS of a Rule.
	 * 
	 * @param attribute
	 *            the attribute to test.
	 * @return whether the Attribute is a LHS of a Rule.
	 */
	public static boolean isLHSAttribute(Attribute attribute) {
		return isLHSNode(attribute.getNode());
	}
	
	/**
	 * Returns whether the Node is a RHS of a Rule.
	 * 
	 * @param node
	 *            the node to test.
	 * @return whether the Node is a RHS of a Rule.
	 */
	public static boolean isRHSNode(Node node) {
		return node.getGraph().isRhs();
	}

	/**
	 * Returns whether the Edge is a RHS of a Rule.
	 * 
	 * @param edge
	 *            the edge to test.
	 * @return whether the Edge is a RHS of a Rule.
	 */
	public static boolean isRHSEdge(Edge edge) {
		return edge.getGraph().isRhs();		
	}
	
	/**
	 * Returns whether the Attribute is a RHS of a Rule.
	 * 
	 * @param attribute
	 *            the attribute to test.
	 * @return whether the Attribute is a RHS of a Rule.
	 */
	public static boolean isRHSAttribute(Attribute attribute) {
		return isRHSNode(attribute.getNode());
	}
	
	/**
	 * @param node
	 *            The node to check.
	 * @return <code>true</code> if the node is contained by other node;
	 *         <code>false</code> otherwise
	 */
	public static boolean isContainedNode(Node node) {
		for (Edge incoming : node.getIncoming()) {
			if (incoming.getType().isContainment()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param node
	 *            The node to check.
	 * @return <code>true</code> if the node is a delete/create node;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isChangedNode(Node node) {
		if (node.getGraph().isLhs() || node.getGraph().isRhs()) {
			return (HenshinRuleAnalysisUtilEx.getRemoteNode(node.getGraph().getRule().getMappings(), node) == null);
		} else {
			return false;
		}
	}
	
	/**
	 * Searches for the first incoming or outgoing << preserve >> edge of the given node. Returns
	 * <code> true </code> if there is a << preserve >> edge; <code> false </code> otherwise.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << preserve >> edge; <code> false </code>
	 *         otherwise.
	 */
	public static boolean isNodeWithPreservedEdges(Node node) {

		for (Edge edge : node.getIncoming()) {
			if (isPreservedEdge(edge)) {
				return true;
			}
		}
		
		for (Edge edge : node.getOutgoing()) {
			if (isPreservedEdge(edge)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Searches for the first incoming or outgoing << delete >> edge of the given node. Returns
	 * <code> true </code> if there is a << delete >> edge; <code> false </code> otherwise.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << delete >> edge; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithDeletionEdges(Node node) {

		for (Edge edge : node.getIncoming()) {
			if (isDeletionEdge(edge)) {
				return true;
			}
		}
		
		for (Edge edge : node.getOutgoing()) {
			if (isDeletionEdge(edge)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Searches for the first incoming or outgoing << create >> edge of the given node. Returns
	 * <code> true </code> if there is a << create >> edge; <code> false </code> otherwise.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << create >> edge; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithCreationEdges(Node node) {

		for (Edge edge : node.getIncoming()) {
			if (isCreationEdge(edge)) {
				return true;
			}
		}
		
		for (Edge edge : node.getOutgoing()) {
			if (isCreationEdge(edge)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Searches for << create >> attribute in a node.
	 * 
	 * @param node the node to test.
	 * @return <code> true </code> if there is a << create >> attribute;
	 *         <code> false </code> otherwise.
	 */
	public static boolean isNodeWithCreationAttributes(Node node) {

		Node rhsNode = null;

		if (node.getGraph().isRhs()) {
			rhsNode = node;
		} else {
			rhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
		}

		for (Attribute rhsAttribute : rhsNode.getAttributes()) {
			Attribute lhsAttribute = getRemoteAttribute(rhsAttribute);

			if (lhsAttribute == null) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Searches for << preserved >> attributes in a << preserve >> node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << preserved >> attribute;
	 *         <code> false </code> otherwise.
	 */
	public static boolean isNodeWithPreservedAttributes(Node node) {
		
		Node lhsNode;
		
		if(isLHSNode(node)) {
			lhsNode = node;
		} else {
			lhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
		}
		
		if((lhsNode != null) && (lhsNode.getAttributes().size() > 0)) {
			for (Attribute lhsAttribute : lhsNode.getAttributes()) {
				Attribute rhsAttribute = getRemoteAttribute(lhsAttribute);
				
				if ((rhsAttribute != null) && (lhsAttribute.getValue().equals(rhsAttribute.getValue()))) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Searches for << delete >> attributes in a node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a << delete >> attribute;
	 *         <code> false </code> otherwise.
	 */
	public static boolean isNodeWithDeletionAttributes(Node node) {
		
		Node lhsNode;
		
		if(isLHSNode(node)) {
			lhsNode = node;
		} else {
			lhsNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
		}
		
		if((lhsNode != null) && (lhsNode.getAttributes().size() > 0)) {
			for (Attribute lhsAttribute : lhsNode.getAttributes()) {
				Attribute rhsAttribute = getRemoteAttribute(lhsAttribute);
				
				if ((rhsAttribute == null)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Searches for (X -> Y) attributes in a << preserve >> node.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if there is a (X -> Y) attribute;
	 *         <code> false </code> otherwise.
	 */
	public static boolean isNodeWithChangingAttributes(Node node) {
		
		for (Attribute attribute : node.getAttributes()) {
			if (isChangingAttribute(attribute)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns <code> true </code> if the node has no attributes; <code> false </code> otherwise.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if the node has no attributes; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithoutAttributes(Node node) {

		if (node.getAttributes().size() == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Returns <code> true </code> if the node has no edges; <code> false </code> otherwise.
	 * 
	 * @param node
	 *            the node to test.
	 * @return <code> true </code> if the node has no edges; <code> false </code> otherwise.
	 */
	public static boolean isNodeWithoutEdges(Node node) {

		if (node.getAllEdges().size() == 0) {
			return true;
		}

		return false;
	}
	
	/**
	 * Apply a Henshin amalgamation unit and save the temporary generated rule
	 * for debugging.
	 * 
	 * @param ts
	 *            the Henshin transformation system.
	 * @param emfEngine
	 *            the Henshin EMF Engine.
	 * @param unitName
	 *            apply unit by name.
	 * @param path
	 *            save temporary amalgamation rule to this path.
	 * @return the success of the unit.
	 */
	/*public boolean applyAndSaveAmalgamationUnit(TransformationSystem ts, EmfEngine emfEngine,
			String unitName, String path) {

		TransformationUnit unit = ts.findUnitByName(unitName);
		UnitApplication unitApp = new UnitApplication(emfEngine, unit);
		boolean success = unitApp.execute();

		Stack<RuleApplication> appliedRules = unitApp.getAppliedRules();

		for (Iterator<RuleApplication> iterator = appliedRules.iterator(); iterator.hasNext();) {
			RuleApplication ruleApplication = (RuleApplication) iterator.next();

			// Save temporary Amalgamation Rule
			TransformationSystem newTS = HenshinFactory.eINSTANCE.createTransformationSystem();
			newTS.getRules().add(ruleApplication.getRule());

			URI uri = URI.createFileURI(new File(path).getAbsolutePath());
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(uri);
			resource.getContents().add((EObject) newTS);

			Map<String, Boolean> options = new HashMap<String, Boolean>();
			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

			try {
				resource.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return success;
	}*/
	
	/**
	 * Returns the {@link Module} the given unit is (recursively) 
	 * contained in. If unit is contained in no transformation system at all, this method
	 * does not throw an exception but simply returns <code>null</code>.
	 * 
	 * @param unit
	 * @return
	 */
	public Module getContainingTransformationSystem(Unit unit){
		EObject parent = unit.eContainer();
		while ((parent != null) && !(parent instanceof Module)){
			parent = parent.eContainer();
		}
		
		if (parent == null){
			return null;
		}
		
		// we can be sure that we have a trafo system here
		return (Module) parent;
	}
	
	/**
	 * Checks whether the specified node is part of the mappings.
	 * 
	 * @param mappings
	 *            A list of mappings.
	 * @param node
	 *            The node which should be checked for origin or image in one of
	 *            the mappings.
	 * @return true, if the node is mapped
	 */
	public static boolean isNodeMapped(Collection<Mapping> mappings, Node node) {
		return getRemoteNode(mappings, node) != null;
	}
	
	/**
	 * Returns the image or origin of the specified node. If the node is not
	 * part of a mapping, null will be returned. If the node is part of multiple
	 * mappings, only the first remote node is returned.
	 * 
	 * @param mappings
	 * @param node
	 * @return
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
	 * Searches the corresponding LHS node of the given RHS node.
	 * 
	 * @param rhsNode
	 *            A RHS node.
	 * @return The corresponding LHS node or <code>null</code> if no node was found.
	 */
	public static Node getLHS(Node rhsNode) {
		if (rhsNode != null) {
			if (rhsNode.getGraph().isLhs()) {
				return rhsNode;
			} else {
				return getRemoteNode(rhsNode.getGraph().getRule().getMappings(), rhsNode);
			}
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
	 * Checks if the given edge represents a 'deletion' edge. This is the case,
	 * if it is contained in a LHS and if there is no corresponding image edge
	 * in the RHS.<br>
	 * 
	 * @param edge
	 * @return true if the edge could be identified to be a 'deletion' edge. In
	 *         every other case this method returns false.
	 */
	public static boolean isDeletionEdge(Edge edge) {
		if (edge.getSource() != null && edge.getTarget() != null && edge.getGraph() != null
				&& edge.getGraph().getRule() != null) {
			Rule rule = edge.getGraph().getRule();
			return edge.getGraph().isLhs()
					&& (getEdgeImage(edge, rule.getRhs(), rule.getMappings()) == null);
		} else {
			return false;
		}
	}// isDeletionEdge
	
	/**
	 * Checks if the given edge represents a 'creation' edge. This is the case,
	 * if it is contained in a RHS and if there is no corresponding origin edge
	 * in the LHS.
	 * 
	 * @param edge
	 * @return true if the edge could be identified to be a 'creation' edge. In
	 *         every other case this method returns false.
	 */
	public static boolean isCreationEdge(Edge edge) {
		if (edge.getSource() != null && edge.getTarget() != null && edge.getGraph() != null
				&& edge.getGraph().getRule() != null) {
			Rule rule = edge.getGraph().getRule();
			return edge.getGraph().isRhs()
					&& (getEdgeOrigin(edge, rule.getMappings()) == null);
		} else {
			return false;
		}
	}// isCreationEdge
	
	/**
	 * Find the image of an edge.
	 * @param edge Origin edge.
	 * @param targetGraph Graph the sought image is contained in
	 * @param mappings Mappings.
	 * @return Edge image.
	 */
	public static Edge getEdgeImage(Edge edge, Graph targetGraph,
			List<Mapping> mappings) {
		if (edge.getSource() == null || edge.getTarget() == null) {
			return null;
		}
		Node source = getNodeImage(edge.getSource(), targetGraph, mappings);
		Node target = getNodeImage(edge.getTarget(), targetGraph, mappings);
		if (source == null || target == null) {
			return null;
		}
		return source.getOutgoing(edge.getType(), target);
	}
	
	/**
	 * Find the image of a node with respect to a target graph and a list of
	 * mappings.
	 * @param origin Origin node.
	 * @param targetGraph Target graph.
	 * @param mappings Mappings.
	 * @return The image of the node.
	 */
	public static Node getNodeImage(Node origin, Graph targetGraph,
			List<Mapping> mappings) {
		Mapping mapping = getNodeImageMapping(origin, targetGraph, mappings);
		return (mapping != null) ? mapping.getImage() : null;
	}
	
	/**
	 * Find a corresponding mapping for a given origin nodes and target graph.
	 * @param origin Origin node.
	 * @param targetGraph Target graph.
	 * @param mappings Mappings.
	 * @return Mapping if found, <code>null</code> otherwise.
	 */
	public static Mapping getNodeImageMapping(Node origin, Graph targetGraph,
			List<Mapping> mappings) {
		for (Mapping mapping : mappings) {
			if (mapping.getOrigin() == origin
					&& mapping.getImage().getGraph() == targetGraph) {
				return mapping;
			}
		}
		return null;
	}
	
	/**
	 * Find the origin of an edge.
	 * @param edge Image edge.
	 * @param mappings Mappings.
	 * @return Edge image.
	 */
	public static Edge getEdgeOrigin(Edge edge, List<Mapping> mappings) {
		if (edge.getSource() == null || edge.getTarget() == null) {
			return null;
		}
		Node source = getNodeOrigin(edge.getSource(), mappings);
		Node target = getNodeOrigin(edge.getTarget(), mappings);
		if (source == null || target == null) {
			return null;
		}
		return source.getOutgoing(edge.getType(), target);
	}
	
	/**
	 * Find the corresponding mapping for a given image node.
	 * @param image Image node.
	 * @param mappings Mappings.
	 * @return Mapping if found, <code>null</code> otherwise.
	 */
	public static Mapping getNodeOriginMapping(Node image,
			List<Mapping> mappings) {
		for (Mapping mapping : mappings) {
			if (mapping.getImage() == image) {
				return mapping;
			}
		}
		return null;
	}
	
	/**
	 * Find the origin of a node with respect to a list of mappings.
	 * @param image Image node.
	 * @param target Target graph.
	 * @param mappings Mappings.
	 * @return The image of the node.
	 */
	public static Node getNodeOrigin(Node image, List<Mapping> mappings) {
		Mapping mapping = getNodeOriginMapping(image, mappings);
		return (mapping != null) ? mapping.getOrigin() : null;
	}
	
	/**
	 * Filters the list of mappings for LHS mappings.
	 * 
	 * @param mappings
	 *            LHS and RHS mappings.
	 * @return only LHS mappings.
	 */
	public static Set<Mapping> getLHSMappings(Collection<Mapping> mappings) {
		Set<Mapping> lhsMappings = new HashSet<Mapping>();

		for (Mapping mapping : mappings) {
			if (isLHSNode(mapping.getImage())) {
				lhsMappings.add(mapping);
			}
		}

		return lhsMappings;
	}
	
	/**
	 * Filters the list of mappings for RHS mappings.
	 * 
	 * @param mappings
	 *            LHS and RHS mappings.
	 * @return only RHS mappings.
	 */
	public static  Set<Mapping> getRHSMappings(Collection<Mapping> mappings) {
		Set<Mapping> rhsMappings = new HashSet<Mapping>();

		for (Mapping mapping : mappings) {
			if (isRHSNode(mapping.getImage())) {
				rhsMappings.add(mapping);
			}
		}

		return rhsMappings;
	}
	
	/**
	 * Tests if the rule is kernel-rule of multi-rules
	 * 
	 * @param kernelRule the rule to test.
	 * @return <code>true</code> if the rule is a kernel rule; <code>false</code> otherwise.
	 */
	public static boolean isKernelRule(Rule kernelRule) {
		if (kernelRule.getMultiRules().size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Tests if the unit is a amalgamation unit := unit -> kernel-rule -> multi-rules
	 * 
	 * @param unit the unit to test.
	 * @return <code>true</code> if the unit is a amalgamation unit; <code>false</code> otherwise.
	 */
	public static boolean isAmalgamationUnit(Unit unit) {
		List<Unit> subUnits = unit.getSubUnits(false);
		
		if ((subUnits.size() == 1) && (subUnits.get(0) instanceof Rule)) {
			Rule kernelRule = (Rule) subUnits.get(0);
			return isKernelRule(kernelRule);
		} else {
			return false;
		}
	}

	/**
	 * Returns the list of NestedConditions contained in the editrule / SCS
	 * @param editRule editRule to search in
	 * @return list of nestedconditions
	 */
	public static List<NestedCondition> getNestedConditions(Rule editRule) {
		return editRule.getLhs().getNestedConditions();
	}
	
	/**
	 * @param mappings
	 *            All mappings of the embedded nodes.
	 * @return All embedded/mapped nodes as a hash set.
	 */
	public static Set<Node> getEmbeddedNodes(Collection<Mapping> mappings) {
		Set<Node> embeddedNodes = new HashSet<Node>();
		
		for (Mapping mapping : mappings) {
			embeddedNodes.add(mapping.getImage());
		}
		
		return embeddedNodes;
	}
	
	/**
	 * @param graph
	 *            The Graph that contains the edges.
	 * @param embeddedNodes
	 *            {@link HenshinRuleAnalysisUtilEx#getEmbeddedNodes(Collection)}
	 * @return All embedded/mapped edges as a hash set.
	 */
	public static Set<Edge> getEmbeddedEdges(Graph graph, Collection<Node> embeddedNodes) {
		
		// An edge is embedded if source and target nodes are embedded:
		Set<Edge> embeddedEdges = new HashSet<Edge>();
		
		for(Edge lhsEdge : graph.getEdges()) {
			if(embeddedNodes.contains(lhsEdge.getSource()) 
					&& embeddedNodes.contains(lhsEdge.getTarget())) {
				embeddedEdges.add(lhsEdge);
			}
		}
		
		return embeddedEdges;
	}
	
	/**
	 * @param graph
	 *            The Graph that contains the attributes.
	 * @param embeddedNodes
	 *            {@link HenshinRuleAnalysisUtilEx#getEmbeddedNodes(Collection)}
	 * @return All embedded/mapped attributes as a hash set.
	 */
	public static Set<Attribute> getEmbeddedAttributes(Graph graph, Collection<Node> embeddedNodes) {
		
		// An attribute is embedded if its corresponding node is embedded and if
		// one of the mapped (parent) nodes contains the same attribute:
		Set<Attribute> embeddedAttributes = new HashSet<Attribute>();
		
		for (Node node : graph.getNodes()) {
			if (embeddedNodes.contains(node)) {
				for (Attribute attribute : node.getAttributes()) {
					if (isEmbedddeAttribute(attribute)) {
						embeddedAttributes.add(attribute);
					}
				}
			}
		}
		
		return embeddedAttributes;
	}
	
	/**
	 * An attribute is embedded if its corresponding node is embedded and if one
	 * of the mapped nodes contains the same attribute.
	 * 
	 * @param attribute
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is embedded; <code>false</code> otherwise.
	 */
	public static boolean isEmbedddeAttribute(Attribute attribute) {
		return isEmbedddeAttribute(attribute.getNode(), attribute);
	}
	
	/**
	 * An attribute is embedded if its corresponding node is embedded and if one
	 * of the mapped nodes contains the same attribute.
	 * 
	 * @param node
	 *            The containing node or a mapped node (recursively).
	 * @param attribute
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is embedded; <code>false</code> otherwise.
	 */
	private static boolean isEmbedddeAttribute(Node node, Attribute attribute) {
		
		// An attribute is embedded if its corresponding node is embedded and if
		// one of the mapped (parent) nodes contains the same attribute:
		Collection<Mapping> mappings;
		
		if (node.getGraph().isNestedCondition()) {
			// NestedCondition:
			mappings = ((NestedCondition) node.getGraph().eContainer()).getMappings();
		} else {
			// Rule:
			mappings = node.getGraph().getRule().getMultiMappings();
		}
		
		Node parentNode = getRemoteNode(mappings, node);
		
		if (parentNode != null) {
			for (Attribute parentAttribute : parentNode.getAttributes()) {
				if (attribute.getType().equals(parentAttribute.getType())) {
					return true;
				}
			}
			// Find attribute recursively in the mapped parent nodes:
			return isEmbedddeAttribute(parentNode, attribute);
		}
		
		return false;
	}
}
