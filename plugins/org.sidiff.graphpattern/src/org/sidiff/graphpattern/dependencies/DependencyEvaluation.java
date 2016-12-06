package org.sidiff.graphpattern.dependencies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	
	private Set<DependencyNode> actualIndependent = new HashSet<>();
	
	private Set<DependencyNode> removedNodes = new HashSet<>();
	
	private Stack<DependencyNode> removedNodesTrace = new Stack<>();

	public DependencyEvaluation(GraphPattern graph) {
		this.graph = graph.getDependencyGraph();
		
		for (DependencyNode dependency : this.graph.getNodes()) {
			
			// trace:
			for (NodePattern node : dependency.getNodes()) {
				nodeToDependency.put(node, dependency);
			}
			
			// atomics:
			if (dependency.getNodes().size() > 1) {
				atomics.add(dependency);
			}
		}
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
		
		// update independent nodes:
		if (actualIndependent.contains(dependency)) {
			
			// (virtual) remove dependency:
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
		
		return Collections.emptyList();
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
	public boolean add(NodePattern node) {
		DependencyNode dependency = nodeToDependency.get(node);

		if (removedNodesTrace.peek() == dependency) {
			
			for (DependencyEdge incomingDependency : dependency.getIncomings()) {
				DependencyNode adjacentDependency = incomingDependency.getSource();
				actualIndependent.remove(adjacentDependency);
			}
			
			actualIndependent.add(dependency);
			removedNodesTrace.pop();
			
			return removedNodes.remove(dependency);
		} else {
			return false;
		}
	}
}
