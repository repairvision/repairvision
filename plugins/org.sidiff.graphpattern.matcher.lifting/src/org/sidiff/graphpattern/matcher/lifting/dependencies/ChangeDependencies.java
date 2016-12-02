package org.sidiff.graphpattern.matcher.lifting.dependencies;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.*;

import java.util.Map;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.common.henshin.view.NodePair;
import org.sidiff.difference.lifting.edit2recognition.traces.AttributeValueChangePattern;
import org.sidiff.difference.lifting.edit2recognition.traces.TransformationPatterns;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class ChangeDependencies {

	private Rule editRule;
	
	private GraphPattern recognitionRule;
	
	private Map<Node, NodePattern> henshinToGraphPatternTrace;
	
	private TransformationPatterns edit2RecognitionTrace;

	public ChangeDependencies(Rule editRule, GraphPattern recognitionRule,
			Map<Node, NodePattern> henshinToGraphPatternTrace, 
			TransformationPatterns edit2RecognitionTrace) {
		
		this.editRule = editRule;
		this.recognitionRule = recognitionRule;
		this.henshinToGraphPatternTrace = henshinToGraphPatternTrace;
		this.edit2RecognitionTrace = edit2RecognitionTrace;
	}
	
	/**
	 * Creates the dependency graph for a recognition rule.
	 */
	public void calculateDependencyGraph() {
		createRemoveObjectDependencies();
		createRemoveReferenceDependencies();
		createAddObjectDependencies();
		createAddReferenceDependencies();
		createAttributeValueChangePatterns();
	}
	
	private void createRemoveObjectDependencies() {
		
		// edit rule LHS \ RHS <<delete>> node:
		for (Node node : getLHSMinusRHSNodes(editRule)) {
			
		}
	}
	
	private void createRemoveReferenceDependencies() {
		
		// edit rule LHS \ RHS <<delete>> node:
		for (Edge edge : getLHSMinusRHSEdges(editRule)) {
			
		}
	}
	
	private void createAddObjectDependencies() {
		
		// edit rule RHS \ LHS <<create>> node:
		for (Node node : getRHSMinusLHSNodes(editRule)) {
			
		}
	}
	
	private void createAddReferenceDependencies() {
		
		// edit rule RHS \ LHS (added):
		for (Edge edge : getRHSMinusLHSEdges(editRule)) {
			
		}
	}
	
	private void createAttributeValueChangePatterns() {
		
		// edit rule attribute: value1->value2:
		for (AttributePair attribute : getLHStoRHSChangingAttributes(editRule)) {
			
		}
	}
	
	private NodePattern getRecognitionChange(Node change) {
		
		if (isDeletionNode(change)) {
			NodePair removeObjectNode = edit2RecognitionTrace.getRemoveObjectPattern(change).getRemoveObject();
			return henshinToGraphPatternTrace.get(removeObjectNode.getLhsNode());
		}
		
		else if (isCreationNode(change)) {
			NodePair addObjectNode = edit2RecognitionTrace.getAddObjectPattern(change).getAddObject();
			return henshinToGraphPatternTrace.get(addObjectNode.getLhsNode());
		}
		
		return null;
	}
	
	private NodePattern getRecognitionChange(Edge change) {
		
		if (isDeletionEdge(change)) {
			NodePair removeReferenceNode = edit2RecognitionTrace.getRemoveReferencePattern(change).getRemoveReference();
			return henshinToGraphPatternTrace.get(removeReferenceNode.getLhsNode());
		}
		
		else if (isCreationEdge(change)) {
			NodePair addReferenceNode = edit2RecognitionTrace.getAddReferencePattern(change).getAddReference();
			return henshinToGraphPatternTrace.get(addReferenceNode.getLhsNode());
		}
		
		return null;		
	}
	
	private NodePattern getRecognitionChange(Attribute change) {
		AttributeValueChangePattern avcPattern = edit2RecognitionTrace.getAttributeValueChangePattern(change);
		
		if (avcPattern != null) {
			return henshinToGraphPatternTrace.get(avcPattern.getAttributeValueChange().getLhsNode());
		}
		
		return null;
	}
}
