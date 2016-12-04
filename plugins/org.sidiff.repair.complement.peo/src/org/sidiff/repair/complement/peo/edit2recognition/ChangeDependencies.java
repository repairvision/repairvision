package org.sidiff.repair.complement.peo.edit2recognition;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHStoRHSChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
import org.sidiff.graphpattern.DependencyEdge;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.NodePatternDependency;
import org.sidiff.graphpattern.dependencies.DependencyCalculation;

public class ChangeDependencies {

	private Rule editRule;
	
	private GraphPattern recognitionRule;
	
	private Map<Node, NodePattern> henshinToGraphPatternTrace;
	
	private TransformationPatterns edit2RecognitionTrace;
	
	private Map<GraphElement, DependencyNode> dependencyTrace = new HashMap<>();

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
		
		D: Every << delete >> node conjunction [A] has direct dependency to its parent container << delete >> node.
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
		
		D: Every << create >> node conjunction [A] has a direct dependencies to its child << create >> nodes.   
		   - Only leaf nodes of a << create >> tree may be removed from an edit rule!
		   
		- Normal (non container/containment) edges, opposite conjunctions have no dependencies!
		--------------------------------------------------------------------------------------------------------------*/
		
		createAddChangeDependencies();
		
		/*--------------------------------------------------------------------------------------------------------------
		- Each attribute value change can be treated independently of each other.
		- An attribute value change has >no< dependencies to other changes.
		--------------------------------------------------------------------------------------------------------------*/
		
		createAttributeValueChangePatterns();
		
		// setup all independent nodes:
		DependencyCalculation.findIndependent(recognitionRule);
	}
	
	private void createRemoveChangeDependencies() {
		
		// edit rule LHS \ RHS <<delete>> node:
		List<Edge> deletionEdges =  getLHSMinusRHSEdges(editRule);
		
		// A: Every << delete >> node + container/containment edges forms a dependency conjunction:
		ceateContainmentDependencies(deletionEdges);
		
		// B: All << delete >> opposite edges form a dependency conjunction:
		// C: Every << delete >> edge has a direct dependency to its << delete >> source and target node:
		for (Edge edge : deletionEdges) {
			EReference type = edge.getType();
			
			if (!(type.isContainment() || type.isContainer())) {
				DependencyNode edgeDependency = null;
				
				// B: All << delete >> opposite edges form a dependency conjunction:
				if (edge.getType().getEOpposite() != null) {
					if (!dependencyTrace.containsKey(edge)) {
						Edge opposite = getOpposite(edge);
						edgeDependency = createDependencyNode(edge, opposite);
						
						dependencyTrace.put(edge, edgeDependency);
						dependencyTrace.put(opposite, edgeDependency);
					}
				} else {
					edgeDependency = createDependencyNode(edge);
					dependencyTrace.put(edge, edgeDependency);
				}
				
				// C: Every << delete >> edge has a direct dependency to its << delete >> source and target node:
				if (edgeDependency != null) {	// (already created opposite)
					
					if (isDeletionNode(edge.getSource())) {
						DependencyNode nodeDependency = dependencyTrace.get(edge.getSource());
						createDependencyEdge(edgeDependency, nodeDependency);
					}
					
					if (isCreationNode(edge.getTarget())) {
						DependencyNode nodeDependency = dependencyTrace.get(edge.getTarget());
						createDependencyEdge(edgeDependency, nodeDependency);
					}
				}
			}
		}
		
		// D: Every << delete >> node conjunction [A] has direct dependency to its parent container << delete >> node:
		for (Edge edge : deletionEdges) {
			EReference type = edge.getType();
			
			if (type.isContainment()) {
				Node containerNode = edge.getSource();
				Node containedNode = edge.getTarget();
				
				if (isDeletionNode(containerNode)) {
					createDependencyEdge(dependencyTrace.get(containedNode), dependencyTrace.get(containerNode));
				}
			}
		}
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
		List<Edge> creationEdges = getRHSMinusLHSEdges(editRule);
		
		// A: Every << create >> node + container/containment references forms a dependency conjunction.
		ceateContainmentDependencies(creationEdges);
		
		// B: All << create >> opposite edges form a dependency conjunction.
		for (Edge edge : getRHSMinusLHSEdges(editRule)) {
			EReference type = edge.getType();
			
			if (!(type.isContainment() || type.isContainer())) {
				if (edge.getType().getEOpposite() != null) {
					if (!dependencyTrace.containsKey(edge)) {
						Edge opposite = getOpposite(edge);
						DependencyNode dependency = createDependencyNode(edge, opposite);
						
						dependencyTrace.put(edge, dependency);
						dependencyTrace.put(opposite, dependency);
					}
				} else {
					DependencyNode edgeDependency = createDependencyNode(edge);
					dependencyTrace.put(edge, edgeDependency);
				}
			}
		}
		
		for (Edge edge : creationEdges) {
			EReference type = edge.getType();
			
			if (type.isContainment()) {
				Node containerNode = edge.getSource();
				Node containedNode = edge.getTarget();
				DependencyNode containedNodeDependency = dependencyTrace.get(containedNode);
				
				// C: Every << create >> node conjunction [A] has a direct dependency to its incident << create >> edges.
				for (Edge outgoing : containedNode.getOutgoing()) {
					if (!(outgoing.getType().isContainment() || outgoing.getType().isContainer())) {
						createDependencyEdge(containedNodeDependency, dependencyTrace.get(outgoing));
					}
				}
				for (Edge incoming : containedNode.getIncoming()) {
					if (!(incoming.getType().isContainment() || incoming.getType().isContainer())) {
						if (incoming.getType().getEOpposite() == null) {
							createDependencyEdge(containedNodeDependency, dependencyTrace.get(incoming));
						}
					}
				}
				
				// D: Every << create >> node conjunction [A] has a direct dependencies to its child << create >> nodes.
				if (isCreationNode(containerNode)) {
					createDependencyEdge(dependencyTrace.get(containerNode), containedNodeDependency);
				}
			}
		}
	}
	
	private void createAttributeValueChangePatterns() {
		
		// edit rule attribute: value1->value2:
		for (AttributePair attribute : getLHStoRHSChangingAttributes(editRule)) {
			createDependencyNode(attribute.getRhsAttribute());
		}
	}
	
	private void ceateContainmentDependencies(List<Edge> edges) {
		for (Edge edge : edges) {
			EReference type = edge.getType();
			
			if (type.isContainment()) {
				Edge containerEdge = getOpposite(edge);
				Node containedNode = edge.getTarget();
				DependencyNode dependency = createDependencyNode(containedNode, edge, containerEdge);
				dependencyTrace.put(containedNode, dependency);
			}
		}
	}
	
	private void createDependencyGraph() {
		recognitionRule.setDependencyGraph(GraphpatternFactory.eINSTANCE.createDependencyGraph());
	}
	
	private DependencyEdge createDependencyEdge(DependencyNode source, DependencyNode target) {
		DependencyEdge dependency = GraphpatternFactory.eINSTANCE.createDependencyEdge();
		
		dependency.setSource(source);
		dependency.setTarget(target);
		
		recognitionRule.getDependencyGraph().getEdges().add(dependency);
		return dependency;
	}
	
	private DependencyNode createDependencyNode(GraphElement... changes) {
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
	
	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		print.append(super.toString() + ":\n\n");
		
		// dependencies:
		for (Entry<GraphElement, DependencyNode> trace : dependencyTrace.entrySet()) {
			DependencyNode dependency = trace.getValue();
			
			print.append("Change: " + trace.getKey() + "\n");
			print.append("  Dependency: " + dependency + "\n");
			
			if (dependency instanceof NodePatternDependency) {
				print.append("  Nodes:" + "\n");
				
				for (NodePattern node : ((NodePatternDependency) dependency).getNodes()) {
					print.append("    " + node + "\n");
				}
			}
			
			if (!dependency.getIncomings().isEmpty()) {
				print.append("  Incomings:" + "\n");
				
				for (DependencyEdge incoming : dependency.getIncomings()) {
					print.append("    Source: " + incoming.getSource() + "\n");
					
					for (GraphElement index : getTrace(incoming.getSource())) {
						print.append("      Trace: " + index + "\n");
					}
				}
			}
			
			if (!dependency.getOutgoings().isEmpty()) {
				print.append("  Outgoings:" + "\n");
				
				for (DependencyEdge outgoing : dependency.getOutgoings()) {
					print.append("    Target: " + outgoing.getTarget() + "\n");
					
					for (GraphElement index : getTrace(outgoing.getTarget())) {
						print.append("      Trace: " + index + "\n");
					}
				}
			}
		}
		
		// independent:
		print.append("\n" + "Independent:" + "\n");
		
		for (DependencyNode dependency : recognitionRule.getDependencyGraph().getIndependent()) {
			print.append("  Dependency: " + dependency + "\n");
			
			for (GraphElement index : getTrace(dependency)) {
				print.append("    Trace: " + index + "\n");
			}
		}
		
		return print.toString();
	}
	
	private List<GraphElement> getTrace(DependencyNode dependency) {
		return dependencyTrace.entrySet().parallelStream()
				.filter(e -> (e.getValue() == dependency))
				.map(Map.Entry::getKey).collect(Collectors.toList());
	}
}
