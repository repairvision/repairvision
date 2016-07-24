package org.sidiff.consistency.graphpattern.matcher.matching.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;

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
			return new LinkedList<>(matchAtomicPattern(atomicPattern, position, initialMatches));
		} else {
			// Initial node is a simple node:
			selectMatches(position, initialMatches);
			
			LinkedList<PathSelector> initialPathSelectorSingleton = new LinkedList<>();
			initialPathSelectorSingleton.add(this);
			
			return initialPathSelectorSingleton;
		}
	}
	
	public LinkedList<PathSelector> move() {
		LinkedList<PathSelector> nextPathSelectors = new LinkedList<>();
		NodePattern position = getPosition();
		
		// Calculate the next paths (from the target node):
		for (NodePattern adjacent : position.getAdjacent()) {
			
			// Check if the paths would intersect itself:
			if (!history.contains(adjacent)) {
				
				// Match all parallel edges:
				// TODO: Do this in getPositionAdjacentMatches in one step!
				Set<EObject> matches = new HashSet<>();
				
				for (EdgePattern incident : position.getIncident(adjacent)) {
					
					// Filter opposite incoming edges:
					if (!((incident.getTarget() == position) && (incident.getOpposite() != null))) {
					
						//// Calculate the target match ////
						matches.addAll(getPositionAdjacentMatches(incident, adjacent));
					}
				}
				
				// Was a move possible?
				if (!matches.isEmpty()) {
					
					// Match atomic patterns;
					// NOTE: matchAtomicPatterns() does the selection for the new matches,
					// but only if the atomic pattern can be matched completely.
					List<PathSelector> atomicSelections = matchAtomicPatterns(adjacent, matches);
					
					// Add selectors for the next paths:
					if (atomicSelections != null) {
						nextPathSelectors.addAll(atomicSelections);
					} else {
						
						// Add reachable matches to target node selection:
						selectMatches(adjacent, matches);
						
						PathSelector nextPathSelector = this.fork();
						nextPathSelector.history.append(adjacent, matches);
						
						nextPathSelectors.add(nextPathSelector);
					}
				}
			}
		}
		
		// FIXME: Merge duplicated path selectors on the same node!?
		return nextPathSelectors;
	}
	
	public List<PathSelector> matchAtomicPatterns(NodePattern initialNode, Collection<EObject> matches) {	
		
		// Get the atomic pattern for the target node:
		AtomicPattern atomicPattern = atomicPatternFactory.getAtomicPattern(this, initialNode);
		
		// Match Atomic Patter:
		if (atomicPattern != null) {
			return matchAtomicPattern(atomicPattern, initialNode, matches);
		} else {
			return null;
		}
	}
	
	public List<PathSelector> matchAtomicPattern(AtomicPattern atomicPattern,
			NodePattern initialNode , Collection<EObject> matches) {
		
		//// Atomic Pattern Move ////
		List<PathSelector> nextPathSelectors = new ArrayList<>();

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
