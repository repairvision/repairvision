package org.sidiff.graphpattern.tools.editrules.generator;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.forbid;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

public class GraphPatternEditRuleGenerator extends BasicEditRuleGenerator {

	protected Copier copier = createCopier();
	
	protected Map<NodePattern, NodePattern> contextTrace = new HashMap<>();
	
	protected Pattern editOperation;
	
	protected GraphPattern editRule;
	
	public GraphPatternEditRuleGenerator(GraphPattern fromGraph, GraphPattern toGraph, Map<NodePattern, NodePattern> match) {
		super(fromGraph, toGraph, match);
		
		this.editRule = GraphpatternFactory.eINSTANCE.createGraphPattern();
		this.editRule.getStereotypes().add(rule);
		
		this.editOperation = GraphpatternFactory.eINSTANCE.createPattern();
		this.editOperation.getGraphs().add(editRule);
	}
	
	public void setName(String name) {
		editOperation.setName(name);
		editRule.setName(name);
	}
	
	public Pattern getEditOperation() {
		return editOperation;
	}
	
	public GraphPattern getEditRule() {
		return editRule;
	}
	
	@Override
	public void generate(List<NodePattern> fromFragment, List<NodePattern> toFragment) {
		super.generate(fromFragment, toFragment);
		
		// Set edge targets:
		for (EObject constraintGraphElement : copier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				EdgePattern constraintEdge = (EdgePattern) constraintGraphElement;
				EdgePattern editRuleEdge = (EdgePattern) copier.get(constraintEdge);
				
				NodePattern constraintTargetNode = constraintEdge.getTarget();
				NodePattern editRuleTargetNode = null;
				
				if (copier.containsKey(constraintTargetNode)) {
					editRuleTargetNode = (NodePattern) copier.get(constraintTargetNode);
				} else {
					editRuleTargetNode = (NodePattern) copier.get(getNodeMatch(constraintTargetNode));
				}
				
				editRuleEdge.setTarget(editRuleTargetNode);
			}
		}
		
		// Generate parameters:
		GraphPatternGeneratorUtil.generateINParameters(editOperation);
	}
	
	protected NodePattern generateNode(NodePattern node, Stereotype action) {
		NodePattern eoNode = copyNode(node, copier);
		eoNode.getStereotypes().add(action);
		editRule.getNodes().add(eoNode);
		
		return eoNode;
	}
	
	protected EdgePattern generateEdge(EdgePattern edge, Stereotype action) {
		NodePattern eoSourceNode = (NodePattern) copier.get(edge.getSource());
		
		if (eoSourceNode == null) {
			eoSourceNode = contextTrace.get(edge.getSource());
		}
		
		EdgePattern eoEdge = copyEdge(edge, copier);
		eoEdge.getStereotypes().add(action);
		eoSourceNode.getOutgoings().add(eoEdge);
		
		return edge;
	}
	
	protected AttributePattern generateAttribute(AttributePattern attribute, Stereotype action) {
		NodePattern eoNode = (NodePattern) copier.get(attribute.getNode());
		
		if (eoNode == null) {
			eoNode = contextTrace.get(attribute.getNode());
		}
		
		AttributePattern eoAttribute = copyAttribute(attribute, copier);
		eoAttribute.getStereotypes().add(action);
		eoNode.getAttributes().add(eoAttribute);
		
		return eoAttribute;
	}
	
	@Override
	protected void generateCreate(NodePattern toNode) {
		generateNode(toNode, create);
	}
	
	@Override
	protected void generateCreate(EdgePattern toEdge) {
		generateEdge(toEdge, create);
	}
	
	@Override
	protected void generateCreate(AttributePattern toAttribute) {
		generateAttribute(toAttribute, create);
	}
	
	@Override
	protected void generateDelete(NodePattern fromNode) {
		generateNode(fromNode, delete);
	}
	
	@Override
	protected void generateDelete(EdgePattern fromEdge) {
		generateEdge(fromEdge, delete);
	}
	
	@Override
	protected void generateDelete(AttributePattern fromAttribute) {
		generateAttribute(fromAttribute, delete);
	}
	
	@Override
	protected void generateContext(NodePattern fromNode, NodePattern toNode) {
		NodePattern eoNode = generateNode(toNode, preserve);
		
		contextTrace.put(fromNode, eoNode);
		contextTrace.put(toNode, eoNode);
	}
	
	@Override
	protected void generateModify(AttributePattern fromAttribute, String toAttributeValue) {
		
		// From:
		generateAttribute(fromAttribute, delete);
		
		// To:
		AttributePattern rhsAttribute = generateAttribute(fromAttribute, create);
		rhsAttribute.setValue(toAttributeValue);
	}
	
	@Override
	protected void generateContext(EdgePattern fromEdge, EdgePattern toEdge) {
		generateEdge(toEdge, preserve);
	}
	
	@Override
	protected void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute) {
		generateAttribute(fromAttribute, preserve);
	}
	
	@Override
	protected void generateForbid(NodePattern toNode) {
		generateNode(toNode, forbid);
	}
	
	@Override
	protected void generateForbid(EdgePattern toEdge) {
		generateEdge(toEdge, forbid);
	}
	
	@Override
	protected void generateForbid(AttributePattern toAttribute) {
		generateAttribute(toAttribute, forbid);
	}
	
	@SuppressWarnings("serial")
	protected Copier createCopier() {
		return new Copier() {
			@Override
			protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
			}
		};
	}
	
	protected NodePattern copyNode(NodePattern node, Copier copier) {
		NodePattern copy = (NodePattern) copier.copy(node);
		copy.setType(node.getType());
//		copy.getStereotypes().addAll(node.getStereotypes());
		return copy;
	}
	
	protected EdgePattern copyEdge(EdgePattern edge, Copier copier) {
		EdgePattern copy = (EdgePattern) copier.copy(edge);
		copy.setType(edge.getType());
//		copy.getStereotypes().addAll(edge.getStereotypes());
		return copy;
	}
	
	protected AttributePattern copyAttribute(AttributePattern attribute, Copier copier) {
		AttributePattern copy = (AttributePattern) copier.copy(attribute);
		copy.setType(attribute.getType());
//		copy.getStereotypes().addAll(attribute.getStereotypes());
		return copy;
	}
}
