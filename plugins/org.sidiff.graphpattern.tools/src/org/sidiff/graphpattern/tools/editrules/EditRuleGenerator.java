package org.sidiff.graphpattern.tools.editrules;

import java.util.Map;

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
		
		// << delete/preserve >>
		for (NodePattern preNode : preConstraint.getNodes()) {
			NodePattern deleteOrContextNode = (NodePattern) copier.copy(preNode);
			editRule.getNodes().add(deleteOrContextNode);
			
			if (!nodeMatching.containsKey(preNode)) {
				deleteOrContextNode.getStereotypes().add(deleteST);
			} else {
				deleteOrContextNode.getStereotypes().add(preserveST);
			}
			
			for (EdgePattern preEdge : preNode.getOutgoings()) {
				EdgePattern deleteOrContextEdge = (EdgePattern) copier.copy(preEdge);
				deleteOrContextNode.getOutgoings().add(deleteOrContextEdge);
				
				if (edgeMatching.containsKey(preEdge)) {
					deleteOrContextEdge.getStereotypes().add(deleteST);
				} else {
					deleteOrContextEdge.getStereotypes().add(preserveST);
				}
			}
		}
		
		// << create >>
		for (NodePattern postNode : postConstraint.getNodes()) {
			if (!nodeMatching.containsValue(postNode)) {
				NodePattern createNode = (NodePattern) copier.copy(postNode);
				createNode.getStereotypes().add(createST);
				editRule.getNodes().add(createNode);
				
				for (EdgePattern postEdge : postNode.getOutgoings()) {
					if (!edgeMatching.containsKey(postEdge)) {
						EdgePattern createEdge = (EdgePattern) copier.copy(postEdge);
						createEdge.getStereotypes().add(createST);
						createNode.getOutgoings().add(createEdge);
					}
				}
			}
		}
		
		return editRule;
	}
}
