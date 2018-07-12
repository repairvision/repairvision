package org.sidiff.graphpattern.tools.editrules;

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

public class EditRuleGenerator {
	
	private static Profile editRuleProfile = GraphPatternProfileLibrary.getEntry("org.sidiff.graphpattern.profile.henshin").getProfile().getProfile();
	
	private static Stereotype preserveST = editRuleProfile.getStereotype("preserve");
	
	private static Stereotype createST = editRuleProfile.getStereotype("create");
	
	private static Stereotype deleteST = editRuleProfile.getStereotype("delete");
	
	public static GraphPattern generate(String name,
			GraphPattern preConstraint, GraphPattern postConstraint, 
			Map<NodePattern, NodePattern> nodeMatching) {
		
		Map<EdgePattern, EdgePattern> edgeMatching = EditRuleGeneratorUtil.getEdgeMatching(nodeMatching);
		Copier copier = createCopier();
		
		// (1.) Merge pre- and post-constraint based on the given matching:
		// (2.) Assign edit rule actions to the merge graph.
		GraphPattern editRule = GraphpatternFactory.eINSTANCE.createGraphPattern();
		editRule.setName(name);
		
		// << create/preserve >>:
		for (NodePattern postNode : postConstraint.getNodes()) {
			if (nodeMatching.containsValue(postNode)) {
				NodePattern contextNode = copyNode(postNode, copier);
				contextNode.getStereotypes().add(preserveST);
				editRule.getNodes().add(contextNode);
				
				for (EdgePattern postEdge : postNode.getOutgoings()) {
					if (edgeMatching.containsValue(postEdge)) {
						EdgePattern createEdge = copyEdge(postEdge, copier);
						createEdge.getStereotypes().add(preserveST);
						contextNode.getOutgoings().add(createEdge);
					} else {
						EdgePattern contextEdge = copyEdge(postEdge, copier);
						contextEdge.getStereotypes().add(createST);
						contextNode.getOutgoings().add(contextEdge);
					}
				}
				
				for (AttributePattern postAttribute : postNode.getAttributes()) {
					if (EditRuleGeneratorUtil.getAttributeMatch(nodeMatching, postAttribute) != null) {
						AttributePattern contextAttribute = copyAttribute(postAttribute, copier);
						contextAttribute.getStereotypes().add(preserveST);
						contextNode.getAttributes().add(contextAttribute);
					} else {
						AttributePattern createAttribute = copyAttribute(postAttribute, copier);
						createAttribute.getStereotypes().add(createST);
						contextNode.getAttributes().add(createAttribute);
					}
				}
			} else {
				NodePattern createNode = copyNode(postNode, copier);
				createNode.getStereotypes().add(createST);
				editRule.getNodes().add(createNode);
				
				for (EdgePattern postEdge : postNode.getOutgoings()) {
					EdgePattern createEdge = copyEdge(postEdge, copier);
					createEdge.getStereotypes().add(createST);
					createNode.getOutgoings().add(createEdge);
				}
				
				for (AttributePattern postAttribute : postNode.getAttributes()) {
					AttributePattern createAttribute = copyAttribute(postAttribute, copier);
					createAttribute.getStereotypes().add(createST);
					createNode.getAttributes().add(createAttribute);
				}
			}
		}
		
		// << delete >>:
		for (NodePattern preNode : preConstraint.getNodes()) {
			if (nodeMatching.containsKey(preNode)) {
				NodePattern contextNode = (NodePattern) copier.get(nodeMatching.get(preNode));
						
				for (EdgePattern preEdge : preNode.getOutgoings()) {
					if (!edgeMatching.containsKey(preEdge)) {
						EdgePattern deleteEdge = copyEdge(preEdge, copier);
						deleteEdge.getStereotypes().add(deleteST);
						contextNode.getOutgoings().add(deleteEdge);
					}
				}
			} else {
				NodePattern deleteNode = copyNode(preNode, copier);
				deleteNode.getStereotypes().add(deleteST);
				editRule.getNodes().add(deleteNode);
				
				for (EdgePattern preEdge : preNode.getOutgoings()) {
					EdgePattern deleteEdge = copyEdge(preEdge, copier);
					deleteEdge.getStereotypes().add(deleteST);
					deleteNode.getOutgoings().add(deleteEdge);
				}
				
				for (AttributePattern preAttribute : preNode.getAttributes()) {
					AttributePattern deleteAttribute = copyAttribute(preAttribute, copier);
					deleteAttribute.getStereotypes().add(deleteST);
					deleteNode.getAttributes().add(deleteAttribute);
				}
			}
		}
		
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
					editRuleTargetNode = (NodePattern) copier.get(nodeMatching.get(constraintTargetNode));
				}
				
				editRuleEdge.setTarget(editRuleTargetNode);
			}
		}
		
		return editRule;
	}
	
	@SuppressWarnings("serial")
	private static Copier createCopier() {
		return new Copier() {
			@Override
			protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
			}
		};
	}
	
	private static NodePattern copyNode(NodePattern node, Copier copier) {
		NodePattern copy = (NodePattern) copier.copy(node);
		copy.setType(node.getType());
		copy.getStereotypes().addAll(node.getStereotypes());
		return copy;
	}
	
	private static EdgePattern copyEdge(EdgePattern edge, Copier copier) {
		EdgePattern copy = (EdgePattern) copier.copy(edge);
		copy.setType(edge.getType());
		copy.getStereotypes().addAll(edge.getStereotypes());
		return copy;
	}
	
	private static AttributePattern copyAttribute(AttributePattern attribute, Copier copier) {
		AttributePattern copy = (AttributePattern) copier.copy(attribute);
		copy.setType(attribute.getType());
		copy.getStereotypes().addAll(attribute.getStereotypes());
		return copy;
	}
}
