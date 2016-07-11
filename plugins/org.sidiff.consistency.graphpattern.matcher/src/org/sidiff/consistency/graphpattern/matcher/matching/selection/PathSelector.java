package org.sidiff.consistency.graphpattern.matcher.matching.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;

public abstract class PathSelector {
	
	protected LinkedList<PathSelector> EMPTY_PATHSELECTOR_LIST = new LinkedList<PathSelector>();
	
	protected IAtomicPatternFactory atomicPatternFactory;
	
	protected Path history = new Path();
	
	protected PathSelector(IAtomicPatternFactory atomicPatternFactory) {
		this.atomicPatternFactory = atomicPatternFactory;
	}
	
	public PathSelector(IAtomicPatternFactory atomicPatternFactory, 
			NodePattern initialPosition, Collection<EObject> initialMatches) {
		this(atomicPatternFactory);
		history.append(initialPosition, initialMatches);
	}
	
	public LinkedList<PathSelector> start() {
		NodePattern position = history.getPosition();
		Collection<EObject> initialMatches = history.getLastMatch();
		AtomicPattern atomicPattern = atomicPatternFactory.getAtomicPattern(this, getPosition());
		
		if (atomicPattern != null) {
			// Initial node is part of an atomic pattern:
			return matchAtomicPattern(atomicPattern, position, initialMatches);
		} else {
			// Initial node is a simple node:
			selectMatches(position, initialMatches);
			
			LinkedList<PathSelector> initialPathSelectorSingleton = new LinkedList<>();
			initialPathSelectorSingleton.add(this);
			
			return initialPathSelectorSingleton;
		}
	}
	
	public LinkedList<PathSelector> move(EdgePattern edge) {
		NodePattern source = getPosition();
		NodePattern target = MatchingHelper.getAdjacent(source, edge);
		
		// Intersecting edges are filtered by getNextEdges()!
		assert (!history.contains(target)) : "Path would intersect itself!";
		
		// Get all matches (over the given edge) which are adjacent to last matches:
		return nextMatch(edge, target);
	}
	
	private LinkedList<PathSelector> nextMatch(EdgePattern edge, NodePattern target) {
		
		// Calculate the target match:
		Collection<EObject> matches = getPositionAdjacentMatches(edge, target);
		
		// Was a move possible?
		if (matches.isEmpty()) {
			return EMPTY_PATHSELECTOR_LIST;
		}
		
		// Get the atomic pattern for the target node:
		AtomicPattern atomicPattern = atomicPatternFactory.getAtomicPattern(this, target);
		
		if (atomicPattern != null) {
			//// Match Atomic Patter ////
			return matchAtomicPattern(atomicPattern, target, matches);
		} else {
			//// Simple Move ////
			
			// Add reachable matches to target node selection:
			selectMatches(target, matches);
			
			// Create a selector for the next path:
			PathSelector nextPathSelector = this.fork();
			nextPathSelector.history.append(target, matches);
			
			LinkedList<PathSelector> nextPathSelectorSingleton = new LinkedList<>();
			nextPathSelectorSingleton.add(nextPathSelector);
			
			return nextPathSelectorSingleton;
		}
	}
	
	public LinkedList<PathSelector> matchAtomicPattern(AtomicPattern atomicPattern,
			NodePattern initialNode , Collection<EObject> matches) {
		
		//// Atomic Pattern Move ////
		LinkedList<PathSelector> nextPathSelectors = new LinkedList<>();

		// Calculate the atomic match:
		Collection<EObject[]> atomicMatches = atomicPattern.getAtomicMatch(this, initialNode, matches);

		// Set the atomic matching (if it completely exists):
		if (!atomicMatches.isEmpty()) {
			List<NodePattern> atomicNodes = atomicPattern.getNodes();
			List<Collection<EObject>> atomicNodeMaches = new ArrayList<>(atomicNodes.size());
			
			for (NodePattern atomicNode : atomicNodes) {
				
				// Convert match:
				Collection<EObject> atomicMatch = atomicPattern.getNodeMatch(atomicNode, atomicMatches);
				atomicNodeMaches.add(atomicMatch);

				// Set the node matches:
				selectMatches(atomicNode, atomicMatch);
			}
			
			// Create new path selectors for each border node of the atomic pattern:
			for (NodePattern borderNode : atomicPattern.getBorderNodes()) {
				if (!history.contains(borderNode)) {
					PathSelector nextPathSelector = this.fork();
					nextPathSelectors.add(nextPathSelector);

					// Update path history:
					for (int i = 0; i < atomicNodes.size(); i++) {
						NodePattern atomicNode = atomicNodes.get(i);
						
						if (atomicNode != borderNode) {
							nextPathSelector.history.append(atomicNode, atomicNodeMaches.get(i));
						}
					}

					// Set border node as last position of this path selector:
					nextPathSelector.history.append(borderNode, atomicNodeMaches.get(atomicNodes.indexOf(borderNode)));
				}
			}
		}
		
		return nextPathSelectors;
	}
	
	public NodePattern getPosition() {
		return history.getPosition();
	}
	
	public Path getPath() {
		return history;
	}
	
	public List<EdgePattern> getNextEdges() {
		List<EdgePattern> nextEdges = new ArrayList<>();
		
		// Calculate the next paths (from the target node):
		for (EdgePattern incident : MatchingHelper.getIncidents(getPosition())) {
			NodePattern adjacent = MatchingHelper.getAdjacent(getPosition(), incident);
			
			// Check if the paths would intersect itself:
			if (!history.contains(adjacent)) {
				nextEdges.add(incident);
			}
		}
		
		return nextEdges;
	}

	public PathSelector fork() {
		PathSelector clonedPathSelector = createPathSelector();
		clonedPathSelector.history = history.fork();
		return clonedPathSelector;
	}
	
	protected abstract PathSelector createPathSelector();
	
	protected abstract Collection<EObject> getPositionAdjacentMatches(EdgePattern edge, NodePattern target);

	protected abstract Collection<EObject> getAdjacentMatches(EObject match, NodePattern source, EdgePattern edge, NodePattern target);
	
	protected abstract void selectMatches(NodePattern node, Collection<EObject> matches);
	
	protected abstract void selectMatch(NodePattern node, EObject matches);
}
