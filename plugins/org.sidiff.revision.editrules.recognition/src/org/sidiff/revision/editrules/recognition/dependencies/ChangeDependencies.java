package org.sidiff.revision.editrules.recognition.dependencies;

import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getCreationEdges;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getDeletionEdges;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isCreationNode;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isDeletionNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.DependencyEdge;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.henshin.HenshinChangesUtil;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.common.henshin.pairs.AttributePair;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.pattern.graph.ChangePatternAttributeValueChange;

public class ChangeDependencies {

	private Rule editRule;
	
	private GraphPattern graphPattern;
	
	private RecognitionPattern recognitionPattern;
	
	private Map<GraphElement, DependencyNode> dependencyTrace = new HashMap<>();

	public ChangeDependencies(Rule editRule, RecognitionPattern recognitionPattern) {
		
		this.editRule = editRule;
		this.graphPattern = recognitionPattern.getGraphPattern();
		this.recognitionPattern = recognitionPattern;
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

		C: Every << delete >> node conjunction [A] has a direct dependency to its incident << delete >> edges:
			- delete references, then delete element

		D: Every << delete >> node conjunction [A] have direct dependency to its contained child << delete >> nodes.
			- delete all child elements, then delete the container
		--------------------------------------------------------------------------------------------------------------*/
		
		createRemoveChangeDependencies();
		
		/*--------------------------------------------------------------------------------------------------------------
		A: Every << create >> node + container/containment references forms a dependency conjunction.
		B: All << create >> opposite edges form a dependency conjunction.
		   - node + container/containment, opposite edges => atomic patterns
		
		C: Every << create >> edge has a direct dependency to its << create >> source and target node.
			- create the element, then create the references

		D: Every << create >> node conjunction [A] has a direct dependency to its parent container << create >> node.
			- create the container, then create the contained elements
		--------------------------------------------------------------------------------------------------------------*/
		
		createAddChangeDependencies();
		
		/*--------------------------------------------------------------------------------------------------------------
		- Each attribute value change can be treated independently of each other.
		- An attribute value change has >no< dependencies to other changes.
		--------------------------------------------------------------------------------------------------------------*/
		
		createAttributeValueChangePatterns();
		
		// setup all independent nodes:
		DependencyCalculation.findIndependent(graphPattern);
	}
	
	private void createRemoveChangeDependencies() {
		
		// edit rule LHS \ RHS <<delete>> node:
		List<Edge> deletionEdges =  getDeletionEdges(editRule);
		
		// A: Every << delete >> node + container/containment edges forms a dependency conjunction:
		for (Edge containmentEdge : deletionEdges) {
			if (containmentEdge.getType().isContainment()) {
				Edge containerEdge = getOpposite(containmentEdge);
				Node containedNode = containmentEdge.getTarget();
				
				if (isDeletionNode(containedNode)) {
					// << delete >> node:
					DependencyNode dependency = createDependencyNode(containedNode, containmentEdge, containerEdge);
					dependencyTrace.put(containedNode, dependency);
				} else {
					// move node => container/containment edges as opposites:
					DependencyNode dependency = createDependencyNode(containmentEdge, containerEdge);
					
					dependencyTrace.put(containmentEdge, dependency);
					dependencyTrace.put(containerEdge, dependency);
				}
			}
		}
		
		// B: All << delete >> opposite edges form a dependency conjunction:
		for (Edge edge : deletionEdges) {
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
		
		for (Edge containmentEdge : deletionEdges) {
			EReference type = containmentEdge.getType();
			
			if (type.isContainment()) {
				Node containerNode = containmentEdge.getSource();
				Node containedNode = containmentEdge.getTarget();
				DependencyNode containedNodeDependency = dependencyTrace.get(containedNode);
				
				if (isDeletionNode(containedNode)) {

					// C: Every << delete >> node conjunction [A] has a direct dependency to its incident << delete >> edges:
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
					
					// D: Every << delete >> node conjunction [A] have direct dependency to its contained child << delete >> nodes:
					if (isDeletionNode(containerNode)) {
						
						// is root container node?
						if (!dependencyTrace.containsKey(containerNode)) {
							DependencyNode dependency = createDependencyNode(containerNode);
							dependencyTrace.put(containerNode, dependency);
						}
						
						createDependencyEdge(dependencyTrace.get(containerNode), containedNodeDependency);
					}
				}
			}
		}
	}
	
	private void createAddChangeDependencies() {
		
		// edit rule RHS \ LHS (added):
		List<Edge> creationEdges = getCreationEdges(editRule);
		
		// A: Every << create >> node + container/containment references forms a dependency conjunction:
		for (Edge containmentEdge : creationEdges) {
			if (containmentEdge.getType().isContainment()) {
				Edge containerEdge = getOpposite(containmentEdge);
				Node containedNode = containmentEdge.getTarget();
				
				if (isCreationNode(containedNode)) {
					// << create >> node:
					DependencyNode dependency = createDependencyNode(containedNode, containmentEdge, containerEdge);
					dependencyTrace.put(containedNode, dependency);
				} else {
					// move node => container/containment edges as opposites:
					if (containerEdge != null) {
						DependencyNode dependency = createDependencyNode(containmentEdge, containerEdge);
						
						dependencyTrace.put(containmentEdge, dependency);
						dependencyTrace.put(containerEdge, dependency);
					}
				}
			}
		}
		
		
		// B: All << create >> opposite edges form a dependency conjunction:
		// C: Every << create >> edge has a direct dependency to its << create >> source and target node:
		for (Edge edge : creationEdges) {
			EReference type = edge.getType();
			
			if (!(type.isContainment() || type.isContainer())) {
				DependencyNode edgeDependency = null;
				
				// B: All << create >> opposite edges form a dependency conjunction:
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
				
				// C: Every << create >> edge has a direct dependency to its << create >> source and target node:
				if (edgeDependency != null) {	// (already created opposite)
					
					if (isCreationNode(edge.getSource())) {
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
		
		// D: Every << create >> node conjunction [A] has direct dependency to its parent container << create >> node:
		for (Edge edge : creationEdges) {
			EReference type = edge.getType();
			
			if (type.isContainment()) {
				Node containerNode = edge.getSource();
				Node containedNode = edge.getTarget();
				
				if (isCreationNode(containerNode) && isCreationNode(containedNode)) {
					
					// is root container node?
					if (!dependencyTrace.containsKey(containerNode)) {
						DependencyNode dependency = createDependencyNode(containerNode);
						dependencyTrace.put(containerNode, dependency);
					}
					
					createDependencyEdge(dependencyTrace.get(containedNode), dependencyTrace.get(containerNode));
				}
			}
		}
	}

	private void createAttributeValueChangePatterns() {
		
		// edit rule attribute: value1->value2:
		for (Node lhsNode : editRule.getLhs().getNodes()) {
			for (AttributePair attribute : HenshinChangesUtil.getChangingAttributes(lhsNode)) {
				createDependencyNode(attribute.getRhsAttribute());
			}
		}
	}
	
	private void createDependencyGraph() {
		graphPattern.setDependencyGraph(GraphpatternFactory.eINSTANCE.createDependencyGraph());
	}
	
	private DependencyEdge createDependencyEdge(DependencyNode source, DependencyNode target) {
		Assert.isNotNull(source);
		Assert.isNotNull(target);
		
		DependencyEdge dependency = GraphpatternFactory.eINSTANCE.createDependencyEdge();
		
		dependency.setSource(source);
		dependency.setTarget(target);
		
		graphPattern.getDependencyGraph().getEdges().add(dependency);
		return dependency;
	}
	
	private DependencyNode createDependencyNode(GraphElement... changes) {
		DependencyNode dependency = GraphpatternFactory.eINSTANCE.createDependencyNode();
		
		for (GraphElement graphElement : changes) {
			if (graphElement != null) { // e.g. missing containment opposite
				NodePattern recognitionChange = getRecognitionChange(graphElement);
				dependency.getNodes().add(recognitionChange);
			}
		}
		
		graphPattern.getDependencyGraph().getNodes().add(dependency);
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
		return recognitionPattern.getNodeTrace().get(change).getChange().getChangeNodePattern();
	}
	
	private NodePattern getRecognitionChange(Edge change) {
		return recognitionPattern.getEdgeTrace().get(change).getChange().getChangeNodePattern();
	}
	
	private NodePattern getRecognitionChange(Attribute rhsAttribute) {
		for (ChangePatternAttributeValueChange attribute : 
			recognitionPattern.getNodeTrace().get(
					HenshinRuleAnalysisUtil.tryLHS(rhsAttribute.getNode())).getAttributeChanges()) {
			
			if (attribute.getAttribute().getRhsAttribute() == rhsAttribute) {
				return attribute.getChangeNodePattern();
			}
		}
		
		return null;
	}
	
	private Edge getOpposite(Edge edge) {
		if (edge.getType().getEOpposite() != null) {
			return edge.getTarget().getOutgoing(edge.getType().getEOpposite(), edge.getSource());
		} else {
			return null;
		}
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
			print.append("  Nodes:" + "\n");

			for (NodePattern node : dependency.getNodes()) {
				print.append("    " + node + "\n");
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
		
		for (DependencyNode dependency : graphPattern.getDependencyGraph().getIndependent()) {
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
