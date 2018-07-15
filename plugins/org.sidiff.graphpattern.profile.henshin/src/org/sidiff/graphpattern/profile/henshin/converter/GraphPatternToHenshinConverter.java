package org.sidiff.graphpattern.profile.henshin.converter;

import static org.sidiff.graphpattern.profile.henshin.HenshinGraphPatternProfile.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinGraphPatternProfile.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinGraphPatternProfile.preserve;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResource;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GraphPatternToHenshinConverter {

	protected Map<NodePattern, Node> lhsTrace = new HashMap<>();
	
	protected Map<NodePattern, Node> rhsTrace = new HashMap<>();
	
	public Rule convert(GraphPattern graph) {
		Rule rule =  HenshinFactory.eINSTANCE.createRule();
		
		for (NodePattern pNode : graph.getNodes()) {
			convert(rule, pNode);
		}
		
		for (NodePattern pNode : graph.getNodes()) {
			for (AttributePattern pAttribute : pNode.getAttributes()) {
				convert(rule, pAttribute);
			}
		}
		
		for (NodePattern pNode : graph.getNodes()) {
			for (EdgePattern pEdge : pNode.getOutgoings()) {
				convert(rule, pEdge);
			}
		}
		
		return rule;
	}
	
	public Resource createResource(Rule rule, URI uri) {
		Resource resource = new HenshinResource(uri);
		resource.getContents().add(rule);
		return resource;
	}
	
	protected void convert(Rule rule, NodePattern pNode) {
		
		if (pNode.getStereotypes().contains(delete)  || pNode.getStereotypes().contains(preserve)) {
			Node node = HenshinFactory.eINSTANCE.createNode();
			node.setName(pNode.getName());
			node.setDescription(pNode.getDescription());
			node.setType(pNode.getType());

			rule.getLhs().getNodes().add(node);
			lhsTrace.put(pNode, node);
		}
		
		if (pNode.getStereotypes().contains(create)  || pNode.getStereotypes().contains(preserve)) {
			Node node = HenshinFactory.eINSTANCE.createNode();
			node.setName(pNode.getName());
			node.setDescription(pNode.getDescription());
			node.setType(pNode.getType());

			rule.getRhs().getNodes().add(node);
			rhsTrace.put(pNode, node);
		}
		
		if (pNode.getStereotypes().contains(preserve)) {
			rule.getMappings().add(lhsTrace.get(pNode), rhsTrace.get(pNode));
		}
	}
	
	protected void convert(Rule rule, AttributePattern pAttribute) {
		
		if (pAttribute.getStereotypes().contains(delete) || pAttribute.getStereotypes().contains(preserve)) {
			Attribute attribute = HenshinFactory.eINSTANCE.createAttribute();
			attribute.setType(pAttribute.getType());
			attribute.setValue(pAttribute.getValue());
			
			Node lhsNode = lhsTrace.get(pAttribute.getNode());
			lhsNode.getAttributes().add(attribute);
		}
		
		if (pAttribute.getStereotypes().contains(create) || pAttribute.getStereotypes().contains(preserve)) {
			Attribute attribute = HenshinFactory.eINSTANCE.createAttribute();
			attribute.setType(pAttribute.getType());
			attribute.setValue(pAttribute.getValue());
			
			Node rhsNode = rhsTrace.get(pAttribute.getNode());
			rhsNode.getAttributes().add(attribute);
		}
		
	}
	
	protected void convert(Rule rule, EdgePattern pEdge) {
		
		if (pEdge.getStereotypes().contains(delete) || pEdge.getStereotypes().contains(preserve)) {
			Edge edge = HenshinFactory.eINSTANCE.createEdge();
			edge.setType(pEdge.getType());
			edge.setSource(lhsTrace.get(pEdge.getSource()));
			edge.setTarget(lhsTrace.get(pEdge.getTarget()));
			
			rule.getLhs().getEdges().add(edge);
		}
		
		if (pEdge.getStereotypes().contains(create) || pEdge.getStereotypes().contains(preserve)) {
			Edge edge = HenshinFactory.eINSTANCE.createEdge();
			edge.setType(pEdge.getType());
			edge.setSource(rhsTrace.get(pEdge.getSource()));
			edge.setTarget(rhsTrace.get(pEdge.getTarget()));
			
			rule.getRhs().getEdges().add(edge);
		}
	}
}
