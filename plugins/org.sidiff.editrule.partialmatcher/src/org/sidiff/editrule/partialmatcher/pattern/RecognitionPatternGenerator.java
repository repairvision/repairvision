package org.sidiff.editrule.partialmatcher.pattern;

import java.util.Map;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionEdge;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionGraph;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.editrule.partialmatcher.util.MatchingHelper;
import org.sidiff.graphpattern.GraphPattern;

public class RecognitionPatternGenerator {

	public static RecognitionPattern createRecognitionPattern(
			Rule editRule, GraphPattern recognitionGraphPattern,
			MatchingHelper matchingHelper, LiftingGraphIndex changeIndex) {
		
		// create recognition-pattern:
		RecognitionPattern recognitionPattern = new RecognitionPattern(editRule, recognitionGraphPattern);
		
		// create action-graph:
		ActionGraph actionGraph = new ActionGraph(editRule, matchingHelper, changeIndex);
		
		// create action-graph nodes:
		Map<Node, ActionNode> nodeTrace = recognitionPattern.getNodeTrace();
		
		// Nodes: <<delete>> / <<preserve>>:
		for (Node lhsNode : editRule.getLhs().getNodes()) {
			ActionNode actionNode = new ActionNode(actionGraph, lhsNode, nodeTrace);
			
			recognitionPattern.addGraphNodePattern(actionNode.getNodePatternA());
			recognitionPattern.addGraphNodePattern(actionNode.getNodePatternB());
			recognitionPattern.addGraphNodePattern(actionNode.getCorrespondence());
			
			if (actionNode.getChange() != null) {
				recognitionPattern.addChangePattern(actionNode.getChange().getChangeNodePattern(), actionNode.getChange());
			}
			
			if (actionNode.getAttributeChanges() != null) {
				for (ChangePattern attributeChange : actionNode.getAttributeChanges()) {
					recognitionPattern.addChangePattern(attributeChange.getChangeNodePattern(), attributeChange);
				}
			}
		}
		
		// Nodes: <<create>>:
		for (Node createNode : HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(editRule)) {
			ActionNode actionNode = new ActionNode(actionGraph, createNode, nodeTrace);
			
			recognitionPattern.addGraphNodePattern(actionNode.getNodePatternA());
			recognitionPattern.addGraphNodePattern(actionNode.getNodePatternB());
			recognitionPattern.addGraphNodePattern(actionNode.getCorrespondence());
			
			if (actionNode.getChange() != null) {
				recognitionPattern.addChangePattern(actionNode.getChange().getChangeNodePattern(), actionNode.getChange());
			}
			
			if (actionNode.getAttributeChanges() != null) {
				for (ChangePattern attributeChange : actionNode.getAttributeChanges()) {
					recognitionPattern.addChangePattern(attributeChange.getChangeNodePattern(), attributeChange);
				}
			}
		}
		
		// create action-graph edges:
		Map<Edge, ActionEdge> edgeTrace = recognitionPattern.getEdgeTrace();
		
		// Edges: <<delete>> / <<preserve>>:
		for (Edge lhsEdge : editRule.getLhs().getEdges()) {
			ActionEdge actionEdge = new ActionEdge(lhsEdge, nodeTrace, edgeTrace);
			
			if (actionEdge.getChange() != null) {
				recognitionPattern.addChangePattern(actionEdge.getChange().getChangeNodePattern(), actionEdge.getChange());
			}
		}
		
		// Edges: <<create>>:
		for (Edge createEdge : HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges(editRule)) {
			ActionEdge actionEdge = new ActionEdge(createEdge, nodeTrace, edgeTrace);
			
			if (actionEdge.getChange() != null) {
				recognitionPattern.addChangePattern(actionEdge.getChange().getChangeNodePattern(), actionEdge.getChange());
			}
		}
		
		// connect nodes and edges:
		for (ActionEdge actionEdge : edgeTrace.values()) {
			actionEdge.getSource().addAdjacent(actionEdge.getTarget(), actionEdge);
			actionEdge.getTarget().addAdjacent(actionEdge.getSource(), actionEdge);
		}
		
		return recognitionPattern;
	}
}
