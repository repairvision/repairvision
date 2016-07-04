package org.sidiff.consistency.graphpattern.matcher.matching.selection;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.data.selection.MatchSelection;

public class MatchSelector {

	private LinkedList<LinkedList<PathSelector>> pathSelectors = new LinkedList<LinkedList<PathSelector>>();
	
	private Collection<NodePattern> graphPattern;
	
	private IAtomicPatternFactory atomicPatternFactory;
	
	public MatchSelector(IAtomicPatternFactory atomicPatternFactory, Collection<NodePattern> graphPattern, 
			NodePattern selectedNode, Collection<EObject> selectedMatches) {
		this.graphPattern = graphPattern;
		this.atomicPatternFactory = atomicPatternFactory;
				
		for (NodePattern node : graphPattern) {
			MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
			matchSelection.clearSelection();
		}
		
		selectInitialMatches(selectedNode, selectedMatches);
	}
	
	public MatchSelector(IAtomicPatternFactory atomicPatternFactory, Collection<NodePattern> graphPattern, 
			NodePattern selectedNode, EObject selectedMatch) {
		this(atomicPatternFactory, graphPattern, selectedNode, Collections.singletonList(selectedMatch));
	}
	
	private void selectInitialMatches(NodePattern selectedNode, Collection<EObject> selectedMatches) {
		InitialPathSelector initialPathSelector = new InitialPathSelector(atomicPatternFactory, selectedNode, selectedMatches);
		LinkedList<PathSelector> initialPathSelectors = initialPathSelector.start();
		
		// Select paths:
		if (!initialPathSelectors.isEmpty()) {
			pathSelectors.add(initialPathSelectors);
			selectPaths();
		}
	}
	
	public void selectMatch(NodePattern selectedNode, Collection<EObject> selectedMatches) {
		pathSelectors.clear(); // Just to be sure...
		
		// Select paths:
		RestrictivePathSelector restrictivePathSelector = new RestrictivePathSelector(atomicPatternFactory, selectedNode, selectedMatches);
		LinkedList<PathSelector> initialPathSelectors = restrictivePathSelector.start();
		
		// Select paths:
		if (!initialPathSelectors.isEmpty()) {
			pathSelectors.add(initialPathSelectors);
			selectPaths();
		}
		
		// Restrict matching (for all nodes):
		RestrictivePathSelector.restrictSelection(graphPattern, selectedNode);
	}
	
	public void selectMatch(NodePattern selectedNode, EObject selectedMatch) {
		selectMatch(selectedNode, Collections.singletonList(selectedMatch));
	}
	
	private void selectPaths() {
		
		// Move all path selectors until there are no moves possible (DFS):
		while (!pathSelectors.isEmpty()) {
			LinkedList<PathSelector> lastMoves = pathSelectors.getLast();
			PathSelector lastMove = lastMoves.getLast();
			
//			System.out.println(lastMove.getPosition());
			
			if (lastMoves.size() == 1) {
				// Update the move stack:
				pathSelectors.removeLast();
			} else {
				// Remove the last move because it was completely processed:
				lastMoves.removeLast();
			}

//			boolean pathStopped = true;
//			EdgePattern lastEdge = null;
			
			// Create new Path-Selector for each moved edge:
			for (EdgePattern nextEdge : lastMove.getNextEdges()) {
				
				LinkedList<PathSelector> nextMoves = lastMove.move(nextEdge);
				
				if (!nextMoves.isEmpty()) {
//					lastEdge = nextEdge;
//					pathStopped = false;
					pathSelectors.add(nextMoves);
				}
			}
			
//			System.out.println(lastEdge);
//			
//			if (pathStopped) {
//				System.out.println("STOP!");
//			}
		}
	}
}
