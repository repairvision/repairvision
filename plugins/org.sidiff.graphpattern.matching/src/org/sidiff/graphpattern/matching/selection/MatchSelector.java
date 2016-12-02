package org.sidiff.graphpattern.matching.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.wgraph.selection.MatchSelection;
import org.sidiff.graphpattern.wgraph.util.WGraph;

public class MatchSelector {

	private LinkedList<LinkedList<PathSelector>> pathSelectors = new LinkedList<LinkedList<PathSelector>>();
	
	private Collection<NodePattern> graphPattern;
	
	private IAtomicPatternFactory atomicPatternFactory;
	
	public MatchSelector(IAtomicPatternFactory atomicPatternFactory, Collection<NodePattern> graphPattern, 
			NodePattern selectedNode, Collection<EObject> selectedMatches) {
		this.graphPattern = graphPattern;
		this.atomicPatternFactory = atomicPatternFactory;
				
		for (NodePattern node : graphPattern) {
			MatchSelection matchSelection = WGraph.getDataStore(node.getEvaluation()).getMatchSelection();
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
	
	// MatchSelector.DEBUG = false
	// MatchSelector.DEBUG = true
	private static boolean DEBUG = false;
	
	private void selectPaths() {

		// Move all path selectors until there are no moves possible (DFS):
		// TODO: Let a selector itself store the last selector...!?
		while (!pathSelectors.isEmpty()) {
			LinkedList<PathSelector> lastMoves = pathSelectors.getLast();
			PathSelector lastMove = lastMoves.getLast();
			
			if (DEBUG) {
				System.out.println("Position: " + removeBundleNames(lastMove.getPosition()));
			}
				
			if (lastMoves.size() == 1) {
				// Update the move stack:
				pathSelectors.removeLast();
			} else {
				// Remove the last move because it was completely processed:
				lastMoves.removeLast();
			}
			
			// Create new Path-Selector for each moved edge:
			LinkedList<PathSelector> nextPaths = lastMove.move();
			
			if (!nextPaths.isEmpty()) {
				pathSelectors.add(nextPaths);
			}
			
			if (DEBUG) {
				if (nextPaths.isEmpty()) {
					System.out.println(">END OF PATH<");
				}
			}
		}
	}
	
	private String removeBundleNames(Object obj) {
		String name = obj.toString().replaceFirst("org\\.sidiff\\.consistency\\.graphpattern\\.impl\\.", "");
		name = name.replaceFirst("org\\.eclipse\\.uml2\\.uml\\.internal\\.impl\\.", "");
		return name;
	}
	
	@SuppressWarnings("unused")
	private Collection<EObject> getSelection(NodePattern node) {
		List<EObject> selection = new ArrayList<>();
		WGraph.getDataStore(node).getMatchSelection().getSelectedMatches()
		.forEachRemaining(selection::add);
		return selection;
	}
	
	@SuppressWarnings("unused")
	private String printSelection(NodePattern node) {
		StringBuffer selectionPrint = new StringBuffer();
		WGraph.getDataStore(node).getMatchSelection().getSelectedMatches()
		.forEachRemaining(selection -> {selectionPrint.append(removeBundleNames(selection) + "\n");});
		return selectionPrint.toString();
	}
}
