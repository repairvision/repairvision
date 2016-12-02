package org.sidiff.graphpattern.matcher.matching.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.wgraph.selection.MatchSelection;
import org.sidiff.graphpattern.wgraph.store.NavigableMatchesDS;
import org.sidiff.graphpattern.wgraph.util.WGraph;

public class RestrictivePathSelector extends PathSelector {

	public RestrictivePathSelector(IAtomicPatternFactory atomicPatternFactory, 
			NodePattern initialPosition, Collection<EObject> initialMatches) {
		super(atomicPatternFactory, initialPosition, initialMatches);
	}
	
	protected RestrictivePathSelector(IAtomicPatternFactory atomicPatternFactory) {
		super(atomicPatternFactory);
	}
	
	@Override
	protected PathSelector createPathSelector() {
		return new RestrictivePathSelector(atomicPatternFactory);
	}

	@Override
	protected Set<EObject> getPositionAdjacentMatches(EdgePattern edge, NodePattern target) {
		NavigableMatchesDS sourceDS = WGraph.getDataStore(history.getPosition().getEvaluation());
		MatchSelection targetSelection = WGraph.getDataStore(target.getEvaluation()).getMatchSelection();
		Set<EObject> adjacentMatches = new HashSet<EObject>();
		
		for (EObject lastMatch : history.getLastMatch()) {
			sourceDS.getRemoteMatchIterator(lastMatch, edge).forEachRemaining(match -> {
				
				// Filter for selected matches:
				if (targetSelection.isSelectedMatch(match) && !adjacentMatches.contains(match)) {
					adjacentMatches.add(match);
				}
			});
		}
		
		return adjacentMatches;
	}

	@Override
	protected List<EObject> getAdjacentMatches(EObject match, NodePattern source, EdgePattern edge, NodePattern target) {
		NavigableMatchesDS sourceDS = WGraph.getDataStore(source.getEvaluation());
		MatchSelection targetSelection = WGraph.getDataStore(target.getEvaluation()).getMatchSelection();
		List<EObject> adjacentMatches = new ArrayList<EObject>();
		
		sourceDS.getRemoteMatchIterator(match, edge).forEachRemaining(adjacentMatch -> {

			// Filter for selected matches:
			if (targetSelection.isSelectedMatch(adjacentMatch)) {
				adjacentMatches.add(adjacentMatch);
			}
		});
		
		return adjacentMatches;
	}

	@Override
	protected void selectMatches(NodePattern node, Collection<EObject> matches) {
		MatchSelection matchSelection = WGraph.getDataStore(node.getEvaluation()).getMatchSelection();
		matchSelection.markSelection(matches);
	}
	
	@Override
	protected void selectMatch(NodePattern node, EObject match) {
		MatchSelection matchSelection = WGraph.getDataStore(node.getEvaluation()).getMatchSelection();
		matchSelection.markSelection(match);
	}
	
	public static void restrictSelection(Collection<NodePattern> nodes, NodePattern restrictionSource) {
		
		// Restrict matching (for all nodes):
		for (NodePattern node : nodes) {
			MatchSelection matchSelection = WGraph.getDataStore(node.getEvaluation()).getMatchSelection();
			matchSelection.restrictSelection(restrictionSource);
		}
	}
}
