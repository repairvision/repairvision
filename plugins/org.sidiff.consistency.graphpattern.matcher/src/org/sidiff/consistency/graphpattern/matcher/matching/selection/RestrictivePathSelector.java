package org.sidiff.consistency.graphpattern.matcher.matching.selection;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.data.selection.MatchSelection;

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
	protected List<EObject> getPositionAdjacentMatches(EdgePattern edge, NodePattern target) {
		NavigableMatchesDS sourceDS = getDataStore(history.getPosition().getEvaluation());
		MatchSelection targetSelection = getDataStore(target.getEvaluation()).getMatchSelection();
		List<EObject> adjacentMatches = new ArrayList<EObject>();
		
		for (EObject lastMatch : history.getLastMatch()) {
			sourceDS.getRemoteMatchIterator(lastMatch, edge).forEachRemaining(match -> {
				
				// Filter for selected matches:
				// TODO: Collect as Set -> toArray() for history? 
				if (targetSelection.isSelectedMatch(match) && !adjacentMatches.contains(match)) {
					adjacentMatches.add(match);
				}
			});
		}
		
		return adjacentMatches;
	}

	@Override
	protected List<EObject> getAdjacentMatches(EObject match, NodePattern source, EdgePattern edge, NodePattern target) {
		NavigableMatchesDS sourceDS = getDataStore(source.getEvaluation());
		MatchSelection targetSelection = getDataStore(target.getEvaluation()).getMatchSelection();
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
		MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
		matchSelection.markSelection(matches);
	}
	
	@Override
	protected void selectMatch(NodePattern node, EObject match) {
		MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
		matchSelection.markSelection(match);
	}
	
	public static void restrictSelection(Collection<NodePattern> nodes, NodePattern restrictionSource) {
		
		// Restrict matching (for all nodes):
		for (NodePattern node : nodes) {
			MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
			matchSelection.restrictSelection(restrictionSource);
		}
	}
}
