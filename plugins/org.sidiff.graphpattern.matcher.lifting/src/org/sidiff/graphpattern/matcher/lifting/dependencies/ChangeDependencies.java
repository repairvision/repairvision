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
		
		/*--------------------------------------------------------------------------------------------------------------
		A: Every << delete >> node + container/containment edges forms a dependency conjunction.
		B: All << delete >> opposite edges form a dependency conjunction.
		   - node + container/containment, opposite edges => atomic patterns
		
		C: Every << delete >> edge has a direct dependency to its << delete >> source and target node.
		   - 1. set source and target << delete >> node to << preserve >> 
		   - 2. set the << delete >> edge to << preserve >>
		
		D: Every << delete >> node conjunction [A] has direct dependency to its parent << delete >> node.
		   - Only the root of a << delete >> tree may be removed (to << preserve >>) from an edit rule!
		   - Inner and leaf nodes of a << delete >> tree may not be removed (to << preserve >>) from an edit rule!
		--------------------------------------------------------------------------------------------------------------*/
		
		createRemoveObjectDependencies();
		createRemoveReferenceDependencies();
		
		/*--------------------------------------------------------------------------------------------------------------
		A: Every << create >> node + container/containment references forms a dependency conjunction.
		B: All << create >> opposite edges form a dependency conjunction.
		   - node + container/containment, opposite edges => atomic patterns
		
		C: Every << create >> node conjunction [A] has a direct dependency to its incident << create >> edges.
		   - 1. remove normal (non container/containment) edges, opposite conjunctions
		   - 2. remove << create >> node + container/containment edges
		
		D: Every << create >> node conjunction [A] has direct dependencies to its child << create >> nodes.   
		   - Only leaf nodes of a << create >> tree may be removed from an edit rule!
		   
		- Normal (non container/containment) edges, opposite conjunctions have no dependencies!
		--------------------------------------------------------------------------------------------------------------*/
		
		createAddObjectDependencies();
		createAddReferenceDependencies();
		
		/*--------------------------------------------------------------------------------------------------------------
		- Each attribute value change can be treated independently of each other.
		- An attribute value change has >no< dependencies to other changes.
		--------------------------------------------------------------------------------------------------------------*/
		
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
