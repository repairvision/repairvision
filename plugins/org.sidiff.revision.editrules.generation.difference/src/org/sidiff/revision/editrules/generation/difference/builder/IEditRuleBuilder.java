package org.sidiff.revision.editrules.generation.difference.builder;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.editrules.generation.difference.util.Pair;

/**
 * @param <Rule> The graph transformation root element type.
 * @param <Node> The graph transformation node type.
 * @param <Edge> The graph transformation edge type.
 * @param <Attribute> The graph transformation attribute type.
 * 
 * @author Manuel Ohrndorf
 */
public interface IEditRuleBuilder<Rule, Node, Edge, Attribute> {

	String getBuilderName();
	
	Rule createEditRule(String name);
	
	void finalizeEditRule();
	
	Node createDeleteNode(String name, EClass type);
	
	Edge createDeleteEdge(Node source, Node target, EReference type);
	
	Attribute createDeleteAttribute(Node node, EAttribute type, Object value);
	
	Node createCreateNode(String name, EClass type);
	
	Edge createCreateEdge(Node source, Node target, EReference type);
	
	Attribute createCreateAttribute(Node node, EAttribute type, Object value);
	
	Pair<Node> createPreservedNode(String name, EClass type);

	Pair<Edge> createPreservedEdge(Pair<Node> source, EReference type, Pair<Node> target);
	
	Pair<Attribute> createPreserveAttribute(Pair<Node> node, EAttribute type, Object value);
	
	Pair<Attribute> createAttributeValueChange(Pair<Node> node, EAttribute type, Object valueA, Object valueB);

	Node getNodeLhs(String name);
	
	Node getNodeRhs(String name);
	
	void setNodeType(Node node, EClass type);
	
	Attribute getAttribute(Node node, EAttribute type);
	
	void setAttributeType(Attribute attribute, EAttribute type);
	
	void setAttributeNode(Attribute attribute, Node node);
	
	void setAttributeValue(Attribute attribute, Object value);
	
	Edge getEdge(Node source, EReference type, Node target);
	
	void setEdgeType(Edge edge, EReference type);
	
	void setEdgeSource(Edge edge, Node source);
	
	void setEdgeTarget(Edge edge, Node target);
	
	int sizeNodes();
	
	int sizeEdges();
	
	int sizeAttributes();
	
	Resource createResource(URI folder, String fileNameWithoutExtension);
	
	URI createRepresentation();
	
	void openRepresentation(URI diagram);

}
