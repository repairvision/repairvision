package org.sidiff.graphpattern.profile.henshin.converter;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResource;
import org.sidiff.common.henshin.INamingConventions;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;

public class GraphPatternToHenshinConverter {

	protected Module module;
	
	protected Unit unit;
	
	protected Rule rule;

	protected Map<NodePattern, Node> lhsTrace = new HashMap<>();
	
	protected Map<NodePattern, Node> rhsTrace = new HashMap<>();
	
	protected Map<NodePattern, Node> acTrace = new HashMap<>(); 
	
	public GraphPatternToHenshinConverter(Pattern editOperation) {
		
		// create rule:
		this.rule = HenshinFactory.eINSTANCE.createRule();
		this.rule.setName(editOperation.getName());
		
		for (GraphPattern editRule : editOperation.getGraphs()) {
			convert(editRule);
		}
		
		// create main unit:
		SequentialUnit mainUnit = HenshinFactory.eINSTANCE.createSequentialUnit();
		mainUnit.setName(INamingConventions.MAIN_UNIT);
		mainUnit.getSubUnits().add(rule);
		
		for (Parameter ruleParameter : rule.getParameters()) {
			Parameter unitParameter = EcoreUtil.copy(ruleParameter);
			mainUnit.getParameters().add(unitParameter);
			
			ParameterMapping mapping = HenshinFactory.eINSTANCE.createParameterMapping();
			mapping.setSource(unitParameter);
			mapping.setTarget(ruleParameter);
			mainUnit.getParameterMappings().add(mapping);
		}
		
		this.unit = mainUnit;
		
		// create module:
		this.module = HenshinFactory.eINSTANCE.createModule();
		this.module.getUnits().add(getMainUnit());
		this.module.getUnits().add(getRule());
		this.module.setName(editOperation.getName());
		this.module.setDescription((editOperation.getDescription() != null) ? editOperation.getDescription() : editOperation.getName());
	}
	
	protected Rule convert(GraphPattern graph) {
		NestedCondition nac = rule.getLhs().createNAC(null);
		
		for (NodePattern pNode : graph.getNodes()) {
			if (pNode.getStereotypes().contains(not)) {
				convert(nac, pNode);
			} else {
				convert(rule, pNode);
			}
		}
		
		for (NodePattern pNode : graph.getNodes()) {
			for (AttributePattern pAttribute : pNode.getAttributes()) {
				if (pAttribute.getStereotypes().contains(not)) {
					convert(nac, pAttribute);
				} else {
					convert(rule, pAttribute);
				}
			}
		}
		
		for (NodePattern pNode : graph.getNodes()) {
			for (EdgePattern pEdge : pNode.getOutgoings()) {
				if (pEdge.getStereotypes().contains(not)) {
					convert(nac, pEdge);
				} else {
					convert(rule, pEdge);
				}
			}
		}
		
		if (graph.getPattern() != null) {
			for (org.sidiff.graphpattern.Parameter pParameter : graph.getPattern().getParameters()) {
				convert(pParameter);
			}
		}
		
		// remove empty NACs:
		if (nac.getConclusion().getNodes().size() == 0) {
			// TODO: Remove NAC only!
			rule.getLhs().getNestedConditions().clear();
		}
		
		return rule;
	}
	
	public Rule getRule() {
		return rule;
	}
	
	public Unit getMainUnit() {
		return unit;
	}
	
	public Module getModule() {
		return module;
	}
	
	public Resource getResource(URI uri) {
		Resource resource = new HenshinResource(uri);
		resource.getContents().add(getModule());
		
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
	
	protected void convert(NestedCondition ac, NodePattern pNode) {
		Node node = HenshinFactory.eINSTANCE.createNode();
		node.setName(pNode.getName());
		node.setDescription(pNode.getDescription());
		node.setType(pNode.getType());
		
		ac.getConclusion().getNodes().add(node);
		acTrace.put(pNode, node);
	}
	
	protected void convert(NestedCondition ac, AttributePattern pAttribute) {
		Attribute attribute = HenshinFactory.eINSTANCE.createAttribute();
		attribute.setType(pAttribute.getType());
		attribute.setValue(pAttribute.getValue());
		
		Node node = acTrace.get(pAttribute.getNode());
		
		if (node == null) {
			node = createApplicationConditionContextNode(ac, pAttribute.getNode());
		}
		
		node.getAttributes().add(attribute);
	}
	
	protected void convert(NestedCondition ac, EdgePattern pEdge) {
		Edge edge = HenshinFactory.eINSTANCE.createEdge();
		edge.setType(pEdge.getType());
		
		Node sourceNode = acTrace.get(pEdge.getSource());
		
		if (sourceNode == null) {
			sourceNode = createApplicationConditionContextNode(ac, pEdge.getSource());
		}
		
		Node targetNode = acTrace.get(pEdge.getTarget());
		
		if (targetNode == null) {
			targetNode = createApplicationConditionContextNode(ac, pEdge.getTarget());
		}
		
		edge.setSource(sourceNode);
		edge.setTarget(targetNode);
		
		ac.getConclusion().getEdges().add(edge);
	}
	
	protected Node createApplicationConditionContextNode(NestedCondition ac, NodePattern pNode) {
		convert(ac, pNode);
		Node node = acTrace.get(pNode);
		ac.getMappings().add(lhsTrace.get(pNode), node);
		
		return node;
	}
	
	protected void convert(org.sidiff.graphpattern.Parameter pParameter) {
		Parameter parameter = HenshinFactory.eINSTANCE.createParameter();
		parameter.setName(pParameter.getName());
		parameter.setDescription(pParameter.getDescription());
		parameter.setKind(ParameterKind.IN);
		
		rule.getParameters().add(parameter);
	}
	
}
