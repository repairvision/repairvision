package org.sidiff.graphpattern.tools.editrules;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
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
	
	public static GraphPattern generate(
			GraphPattern preConstraint, GraphPattern postConstraint, 
			Map<NodePattern, NodePattern> nodeMatching) {
		
		Map<EdgePattern,EdgePattern> edgeMatching = EditRuleGeneratorUtil.getEdgeMatching(nodeMatching);
		
		GraphPattern editRule = GraphpatternFactory.eINSTANCE.createGraphPattern();
		Copier copier = new Copier();
		
		// << create/preserve >> nodes/edges:
		// NOTE: Edges will be copied implicitly.
		for (NodePattern postNode : postConstraint.getNodes()) {
			if (nodeMatching.containsValue(postNode)) {
				
				// << preserve >> node/edges:
				NodePattern contextNode = (NodePattern) copier.copy(postNode);
				contextNode.getStereotypes().add(preserveST);
				editRule.getNodes().add(contextNode);
				
				for (EdgePattern createOrContextEdge : contextNode.getOutgoings()) {
					EdgePattern postEdge = (EdgePattern) copier.get(createOrContextEdge);
					
					if (edgeMatching.containsValue(postEdge)) {
						createOrContextEdge.getStereotypes().add(preserveST);
					} else {
						createOrContextEdge.getStereotypes().add(createST);
					}
				}
			} else {
				
				// << create >> node/edges:
				NodePattern createNode = (NodePattern) copier.copy(postNode);
				createNode.getStereotypes().add(createST);
				editRule.getNodes().add(createNode);
				
				for (EdgePattern createEdge : createNode.getOutgoings()) {
					createEdge.getStereotypes().add(createST);
				}
			}
		}
		
		// << delete >> nodes/edges:
		// NOTE: Edges of create-nodes will be copied implicitly.
		for (NodePattern preNode : preConstraint.getNodes()) {
			
			if (nodeMatching.containsKey(preNode)) {
				
				// << delete >> edges
				NodePattern contextNode = (NodePattern) copier.get(nodeMatching.get(preNode));
						
				for (EdgePattern preEdge : preNode.getOutgoings()) {
					if (!edgeMatching.containsKey(preEdge)) {
						EdgePattern deleteEdge = (EdgePattern) copier.copy(preEdge);
						deleteEdge.getStereotypes().add(deleteST);
						contextNode.getOutgoings().add(deleteEdge);
					}
				}
			} else {
				
				// << delete >> node/edges:
				NodePattern deleteNode = (NodePattern) copier.copy(preNode);
				deleteNode.getStereotypes().add(deleteST);
				editRule.getNodes().add(deleteNode);
				
				for (EdgePattern deleteEdge : deleteNode.getOutgoings()) {
					deleteEdge.getStereotypes().add(deleteST);
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
}
