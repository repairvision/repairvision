package org.sidiff.revision.editrules.recognition.dependencies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import org.sidiff.graphpattern.DependencyEdge;
import org.sidiff.graphpattern.DependencyGraph;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class DependencyEvaluation {

	private DependencyGraph graph;
	
	private List<DependencyNode> atomics = new ArrayList<>();
	
	private Map<NodePattern, DependencyNode> nodeToDependency = new HashMap<>();
	
	private Map<DependencyNode, Set<NodePattern>> dependent = new HashMap<>();
	
	private Set<DependencyNode> actualIndependent = new HashSet<>();
	
	private Set<DependencyNode> removedNodes = new HashSet<>();
	
	private Stack<DependencyNode> removedNodesTrace = new Stack<>();

	public DependencyEvaluation(GraphPattern graph) {
		this.graph = graph.getDependencyGraph();
		Map<DependencyNode, Set<DependencyNode>> dependenciesPerNodes = new HashMap<>();
		
		for (DependencyNode dependency : this.graph.getNodes()) {
			
			// trace:
			for (NodePattern node : dependency.getNodes()) {
				nodeToDependency.put(node, dependency);
			}
			
			// atomics:
			if (dependency.getNodes().size() > 1) {
				atomics.add(dependency);
			}
			
			// depended:
			Set<DependencyNode> dependenciesPerNode = calculateDependenciesPerNode(dependency);
			dependenciesPerNodes.put(dependency, dependenciesPerNode);
		}
		
		// convert dependencies per node:
		for (Entry<DependencyNode, Set<DependencyNode>> dependency : dependenciesPerNodes.entrySet()) {
			Set<NodePattern> dependedNodes = new HashSet<>();
			dependent.put(dependency.getKey(), dependedNodes);

			for (DependencyNode dependedDependency : dependency.getValue()) {
				dependedNodes.addAll(dependedDependency.getNodes());
			}
		}
	}
	
	private Set<DependencyNode> calculateDependenciesPerNode(DependencyNode dependency) {
		Set<DependencyNode> dependent = new HashSet<>();
		calculateDependenciesPerNode(dependency, dependent);
		return dependent;
	}
	
	private void calculateDependenciesPerNode(DependencyNode dependency, Set<DependencyNode> dependent) {
		for (DependencyEdge edge : dependency.getIncomings()) {
			DependencyNode sourceNode = edge.getSource();
			
			if (dependent.add(sourceNode)) {
				calculateDependenciesPerNode(sourceNode, dependent);
			}	
		}
	}
	
	public Set<NodePattern> getDependent(NodePattern node) {
		return dependent.get(nodeToDependency.get(node));
	}
	
	public Set<DependencyNode> getActualIndependent() {
		return actualIndependent;
	}

	public List<DependencyNode> getAtomics() {
		return atomics;
	}
	
	public List<NodePattern> getAtomic(NodePattern node) {
		return nodeToDependency.get(node).getNodes();
	}
	
	/**
	 * Must be called for (re)initialization.
	 */
	public void start() {
		actualIndependent = new HashSet<>(graph.getIndependent());
		removedNodes = new HashSet<>();
	}
	
	public boolean canRemove(NodePattern node) {
		return actualIndependent.contains(nodeToDependency.get(node));
	}
	
	/**
	 * @param node
	 *            A node which corresponds to a dependency. NOTE: A dependency
	 *            can have multiple nodes but this function should be called
	 *            only for one corresponding node.
	 * @return <code>true</code> if the corresponding dependency could be
	 *         removed successfully; <code>false</code> otherwise.
	 */
	public List<NodePattern> remove(NodePattern node) {
		
		// A node can be removed if its corresponding dependency node is independent!
		DependencyNode dependency = nodeToDependency.get(node);
		assert (actualIndependent.contains(dependency)) : "Node ist not independent!";
		
		// update independent nodes:
		removedNodes.add(dependency);
		removedNodesTrace.push(dependency);
		actualIndependent.remove(dependency);

		// check for new independent nodes:
		for (DependencyEdge incomingDependency : dependency.getIncomings()) {
			DependencyNode adjacentDependency = incomingDependency.getSource();

			if (isIndependent(adjacentDependency)) {
				actualIndependent.add(adjacentDependency);
			}
		}

		return dependency.getNodes();
	}
	
	private boolean isIndependent(DependencyNode node) {
		
		for (DependencyEdge outgoing : node.getOutgoings()) {
			if (!removedNodes.contains(outgoing.getTarget())) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @param node
	 *            A node which corresponds to a dependency. NOTE: A dependency
	 *            can have multiple nodes but this function should be called
	 *            only for one corresponding node.
	 * @return <code>true</code> if the corresponding dependency could be
	 *         added successfully; <code>false</code> otherwise.
	 */
	public void undoRemoveDependency() {
		DependencyNode dependency = removedNodesTrace.pop();
		actualIndependent.add(dependency);
		removedNodes.remove(dependency);

		for (DependencyEdge incomingDependency : dependency.getIncomings()) {
			DependencyNode adjacentDependency = incomingDependency.getSource();
			actualIndependent.remove(adjacentDependency);
		}
	}
	
	public DependencyGraph getGraph() {
		return graph;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		// Evaluation:
		string.append("Currently Independent Dependencies:\n");
		
		for (DependencyNode independent : actualIndependent) {
			string.append(independent);
			string.append("\n");
		}
		
		string.append("\n");
		string.append("Currently Removed Dependencies:\n");
		
		for (DependencyNode removed : removedNodes) {
			string.append(removed);
			string.append("\n");
		}
		
		// Dependency graph:
		string.append("\n");
		string.append("Dependency Graph:\n\n");
		
		for (DependencyNode dependencyNode : graph.getNodes()) {
			string.append("--------------------------------------------------------------------------------\n");
			string.append(dependencyNode);
			string.append(":\n");
			
			for (NodePattern nodePattern : dependencyNode.getNodes()) {
				string.append("  ");
				string.append(nodePattern);
				string.append("\n");
			}
			
			string.append("Outgoings (targets):\n");
			
			for (DependencyEdge dependencyEdge : dependencyNode.getOutgoings()) {
				string.append("  ");
				string.append(dependencyEdge.getTarget());
				string.append("\n");
			}
			
			string.append("Incomings (sources):\n");
			
			for (DependencyEdge dependencyEdge : dependencyNode.getIncomings()) {
				string.append("  ");
				string.append(dependencyEdge.getSource());
				string.append("\n");
			}
		}
		
		string.append("--------------------------------------------------------------------------------\n");
		return string.toString();
	}
}
