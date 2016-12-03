package org.sidiff.graphpattern.matcher.lifting.dependencies;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHStoRHSChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.common.henshin.view.NodePair;
import org.sidiff.difference.lifting.edit2recognition.traces.AttributeValueChangePattern;
import org.sidiff.difference.lifting.edit2recognition.traces.TransformationPatterns;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.NodePatternDependency;

public class ChangeDependencies {

	private Rule editRule;
	
	private GraphPattern recognitionRule;
	
	private Map<Node, NodePattern> henshinToGraphPatternTrace;
	
	private TransformationPatterns edit2RecognitionTrace;
	
	private Map<Edge, DependencyNode> dependencyTrace = new HashMap<>();

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
		
		createDependencyGraph();
		
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
		
		createRemoveChangeDependencies();
		
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
		
		createAddChangeDependencies();
		
		/*--------------------------------------------------------------------------------------------------------------
		- Each attribute value change can be treated independently of each other.
		- An attribute value change has >no< dependencies to other changes.
		--------------------------------------------------------------------------------------------------------------*/
		
		createAttributeValueChangePatterns();
	}
	
	private void createRemoveChangeDependencies() {
		
		// edit rule LHS \ RHS <<delete>> node:
		for (Edge edge : getLHSMinusRHSEdges(editRule)) {
			EReference type = edge.getType();
			
			if (type.isContainment() || type.isContainer()) {
				
				// A: Every << delete >> node + container/containment edges forms a dependency conjunction.
				if (!dependencyTrace.containsKey(edge)) {
					Edge containerEdge = getOpposite(edge);
					DependencyNode dependency = createDependency(edge.getTarget(), edge, containerEdge);
					
					dependencyTrace.put(edge, dependency);
					dependencyTrace.put(containerEdge, dependency);
				}
			} else {
				DependencyNode dependency = null;
				
				// B: All << delete >> opposite edges form a dependency conjunction.
				if (edge.getType().getEOpposite() != null) {
					if (!dependencyTrace.containsKey(edge)) {
						Edge opposite = getOpposite(edge);
						dependency = createDependency(edge, opposite);
						
						dependencyTrace.put(edge, dependency);
						dependencyTrace.put(opposite, dependency);
					}
				} else {
					dependency = createDependency(edge);
					dependencyTrace.put(edge, dependency);
				}
				
				// C: Every << delete >> edge has a direct dependency to its << delete >> source and target node.
				if (dependency != null) {
					
				}
			}
		}
		
		// D: Every << delete >> node conjunction [A] has direct dependency to its parent << delete >> node.
	}
	
	private Edge getOpposite(Edge edge) {
		if (edge.getType().getEOpposite() != null) {
			return edge.getTarget().getOutgoing(edge.getType().getEOpposite(), edge.getSource());
		} else {
			return null;
		}
	}
	
	private void createAddChangeDependencies() {
		
		// edit rule RHS \ LHS (added):
		for (Edge edge : getRHSMinusLHSEdges(editRule)) {
			EReference type = edge.getType();
			
			if (type.isContainment() || type.isContainer()) {
				
				// A: Every << create >> node + container/containment references forms a dependency conjunction.
				if (!dependencyTrace.containsKey(edge)) {
					Edge containerEdge = getOpposite(edge);
					DependencyNode dependency = createDependency(edge.getTarget(), edge, containerEdge);
					
					dependencyTrace.put(edge, dependency);
					dependencyTrace.put(containerEdge, dependency);
				}
			} else {
				
				// B: All << create >> opposite edges form a dependency conjunction.
				if (edge.getType().getEOpposite() != null) {
					if (!dependencyTrace.containsKey(edge)) {
						Edge opposite = getOpposite(edge);
						DependencyNode dependency = createDependency(edge, opposite);
						
						dependencyTrace.put(edge, dependency);
						dependencyTrace.put(opposite, dependency);
					}
				}
			}
		}
		
		// edit rule RHS \ LHS <<create>> node:
		for (Node node : getRHSMinusLHSNodes(editRule)) {
			// C: Every << create >> node conjunction [A] has a direct dependency to its incident << create >> edges.

		}
		
		// D: Every << create >> node conjunction [A] has direct dependencies to its child << create >> nodes. 
	}
	
	private void createAttributeValueChangePatterns() {
		
		// edit rule attribute: value1->value2:
		for (AttributePair attribute : getLHStoRHSChangingAttributes(editRule)) {
			
		}
	}
	
	private void createDependencyGraph() {
		recognitionRule.setDependencyGraph(GraphpatternFactory.eINSTANCE.createDependencyGraph());
	}
	
	private DependencyNode createDependency(GraphElement... changes) {
		NodePatternDependency dependency = GraphpatternFactory.eINSTANCE.createNodePatternDependency();
		
		for (GraphElement graphElement : changes) {
			NodePattern recognitionChange = getRecognitionChange(graphElement);
			dependency.getNodes().add(recognitionChange);
		}
		
		recognitionRule.getDependencyGraph().getNodes().add(dependency);
		return dependency;
	}
	
	private NodePattern getRecognitionChange(GraphElement change) {
		
		if (change instanceof Edge) {
			return getRecognitionChange((Edge) change);
		}
		
		else if (change instanceof Node) {
			return getRecognitionChange((Node) change);
		}
		
		else if (change instanceof Attribute) {
			return getRecognitionChange((Attribute) change);
		}
		
		return null;
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
