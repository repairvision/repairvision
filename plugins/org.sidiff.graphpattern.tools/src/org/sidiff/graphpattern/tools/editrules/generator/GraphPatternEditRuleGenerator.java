package org.sidiff.graphpattern.tools.editrules.generator;

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
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class GraphPatternEditRuleGenerator extends BasicEditRuleGenerator {

	protected static Profile editRuleProfile = GraphPatternProfileLibrary.getEntry("org.sidiff.graphpattern.profile.henshin").getProfile().getProfile();
	
	protected static Stereotype preserveST = editRuleProfile.getStereotype("preserve");
	
	protected static Stereotype createST = editRuleProfile.getStereotype("create");
	
	protected static Stereotype deleteST = editRuleProfile.getStereotype("delete");
	
	protected static Stereotype forbidST = editRuleProfile.getStereotype("forbid");
	
	protected Copier copier = createCopier();
	
	protected Map<NodePattern, NodePattern> contextTrace = new HashMap<>();
	
	protected GraphPattern editRule = GraphpatternFactory.eINSTANCE.createGraphPattern();
	
	public GraphPatternEditRuleGenerator(GraphPattern fromGraph, GraphPattern toGraph, Map<NodePattern, NodePattern> match) {
		super(fromGraph, toGraph, match);
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
	}
	
	protected NodePattern generateNode(NodePattern node, Stereotype action) {
		NodePattern eoNode = copyNode(node, copier);
		eoNode.getStereotypes().add(action);
		editRule.getNodes().add(eoNode);
		
		return eoNode;
	}
	
	protected EdgePattern generateEdge(EdgePattern edge, Stereotype action) {
		NodePattern eoSourceNode = contextTrace.get(edge.getSource());
		
		EdgePattern eoEdge = copyEdge(edge, copier);
		eoEdge.getStereotypes().add(action);
		eoSourceNode.getOutgoings().add(eoEdge);
		
		return edge;
	}
	
	protected AttributePattern generateAttribute(AttributePattern attribute, Stereotype action) {
		NodePattern eoNode = contextTrace.get(attribute.getNode());
		
		AttributePattern eoAttribute = copyAttribute(attribute, copier);
		eoAttribute.getStereotypes().add(action);
		eoNode.getAttributes().add(eoAttribute);
		
		return eoAttribute;
	}
	
	protected void generateCreate(NodePattern toNode) {
		generateNode(toNode, createST);
	}
	
	protected void generateCreate(EdgePattern toEdge) {
		generateEdge(toEdge, createST);
	}
	
	protected void generateCreate(AttributePattern toAttribute) {
		generateAttribute(toAttribute, createST);
	}
	
	protected void generateDelete(NodePattern fromNode) {
		generateNode(fromNode, deleteST);
	}
	
	protected void generateDelete(EdgePattern fromEdge) {
		generateEdge(fromEdge, deleteST);
	}
	
	protected void generateDelete(AttributePattern fromAttribute) {
		generateAttribute(fromAttribute, deleteST);
	}
	
	protected void generateContext(NodePattern fromNode, NodePattern toNode) {
		NodePattern eoNode = generateNode(toNode, preserveST);
		
		contextTrace.put(fromNode, eoNode);
		contextTrace.put(toNode, eoNode);
	}
	
	protected void generateContext(EdgePattern fromEdge, EdgePattern toEdge) {
		generateEdge(toEdge, preserveST);
	}
	
	protected void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute) {
		generateAttribute(fromAttribute, preserveST);
	}
	
	protected void generateForbid(NodePattern toNode) {
		generateNode(toNode, forbidST);
	}
	
	protected void generateForbid(EdgePattern toEdge) {
		generateEdge(toEdge, forbidST);
	}
	
	protected void generateForbid(AttributePattern toAttribute) {
		generateAttribute(toAttribute, forbidST);
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
		copy.getStereotypes().addAll(node.getStereotypes());
		return copy;
	}
	
	protected EdgePattern copyEdge(EdgePattern edge, Copier copier) {
		EdgePattern copy = (EdgePattern) copier.copy(edge);
		copy.setType(edge.getType());
		copy.getStereotypes().addAll(edge.getStereotypes());
		return copy;
	}
	
	protected AttributePattern copyAttribute(AttributePattern attribute, Copier copier) {
		AttributePattern copy = (AttributePattern) copier.copy(attribute);
		copy.setType(attribute.getType());
		copy.getStereotypes().addAll(attribute.getStereotypes());
		return copy;
	}
}
