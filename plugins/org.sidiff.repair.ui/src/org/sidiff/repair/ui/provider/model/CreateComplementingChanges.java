package org.sidiff.repair.ui.provider.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.repair.api.matching.EditOperationMatching;

public class CreateComplementingChanges {

	public static Change create(GraphElement graphElement, EditOperationMatching preMatch) {
		
		if (graphElement instanceof Edge) {
			return toComplementingChange((Edge) graphElement, preMatch);
		}
		
		else if (graphElement instanceof Node) {
			return toComplementingChange((Node) graphElement, preMatch);
		}
		
		else  if (graphElement instanceof Attribute) {
			return toComplementingChange((Attribute) graphElement, preMatch);
		}
		
		return null;
	}
	
	private static Change toComplementingChange(Edge edge, EditOperationMatching preMatch) {
		Change change = new Change();
		change.graphElement = edge;
		
		// Get edge context:
		EObject contextMatchSrc = null;
		EObject contextMatchTgt = null;
		
		Node contextNodeSrc = edge.getSource();
		Node contextNodeTgt = edge.getTarget();

		if (contextNodeSrc.getGraph().isRhs()) {
			contextNodeSrc = HenshinRuleAnalysisUtilEx.getLHS(contextNodeSrc);
		}

		if (contextNodeTgt.getGraph().isRhs()) {
			contextNodeTgt = HenshinRuleAnalysisUtilEx.getLHS(contextNodeTgt);
		}

		// Get match:
		if (contextNodeSrc != null) {
			contextMatchSrc = preMatch.getMatch().getNodeTarget(contextNodeSrc);
		}
		
		if (contextNodeTgt != null) {
			contextMatchTgt = preMatch.getMatch().getNodeTarget(contextNodeTgt);
		}
		
		// Create change: [0] Source, [1] Target
		if ((contextMatchSrc != null) && (contextMatchTgt != null)) {
			change.nodes = new Node[2];
			change.matches = new EObject[2];
			
			change.nodes[0] = contextNodeSrc;
			change.nodes[1] = contextNodeTgt;
			
			change.matches[0] = contextMatchSrc;
			change.matches[1] = contextMatchTgt;
		}
		
		else if (contextMatchSrc != null) {
			change.nodes = new Node[1];
			change.matches = new EObject[1];
			
			change.nodes[0] = contextNodeSrc;
			change.matches[0] = contextMatchSrc;
		}
		
		else if (contextMatchTgt != null) {
			change.nodes = new Node[1];
			change.matches = new EObject[1];
			
			change.nodes[0] = contextNodeTgt;
			change.matches[0] = contextMatchTgt;
		}
		
		return change;
	}
	
	private static Change toComplementingChange(Node node, EditOperationMatching preMatch) {
		Change change = new Change();
		change.graphElement = node;
			
		List<Node> contextNodes = new ArrayList<>();
		List<EObject> contextMatches = new ArrayList<>(); 

		// Get node match:
		Node lhsNode = HenshinRuleAnalysisUtilEx.getLHS(node);
		EObject match = preMatch.getMatch().getNodeTarget(lhsNode);

		if (match != null) {
			contextNodes.add(lhsNode);
			contextMatches.add(match);
		}

		// Get node context:
		for (Edge outgoing : node.getOutgoing()) {
			Node contextNode = outgoing.getTarget();

			if (contextNode.getGraph().isRhs()) {
				contextNode = HenshinRuleAnalysisUtilEx.getLHS(contextNode);
			}

			if (contextNode != null) {
				EObject contextMatch = preMatch.getMatch().getNodeTarget(contextNode);

				if (contextMatch != null) {
					contextNodes.add(contextNode);
					contextMatches.add(contextMatch);
				}
			}
		}

		for (Edge incoming : node.getIncoming()) {
			Node contextNode = incoming.getSource();

			if (contextNode.getGraph().isRhs()) {
				contextNode = HenshinRuleAnalysisUtilEx.getLHS(contextNode);
			}

			if (contextNode != null) {
				EObject contextMatch = preMatch.getMatch().getNodeTarget(contextNode);

				if ((contextMatch != null) && (!contextMatches.contains(contextMatch))) {
					contextNodes.add(contextNode);
					contextMatches.add(contextMatch);
				}
			}
		}

		change.nodes = contextNodes.toArray(new Node[0]);
		change.matches = contextMatches.toArray(new EObject[0]);
		
		return change;
	}
	
	private static Change toComplementingChange(Attribute attribute, EditOperationMatching preMatch) {
		AttributeChange change = new AttributeChange();
		change.graphElement = attribute;
		
		
		Parameter parameter = preMatch.getMatch().getRule().getParameter(attribute.getValue());
		change.matches = new EObject[] {preMatch.getMatch().getNodeTarget(
				HenshinRuleAnalysisUtilEx.getLHS(attribute.getNode()))};
		change.value = preMatch.getMatch().getParameterValue(parameter);
		
		return change;
	}
}
