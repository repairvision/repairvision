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

public class InitialPathSelector extends PathSelector {

	public InitialPathSelector(IAtomicPatternFactory atomicPatternFactory,
			NodePattern initialPosition, Collection<EObject> initialMatches) {
		super(atomicPatternFactory, initialPosition, initialMatches);
	}
	
	protected InitialPathSelector(IAtomicPatternFactory atomicPatternFactory) {
		super(atomicPatternFactory);
	}
	
	@Override
	protected PathSelector createPathSelector() {
		return new InitialPathSelector(atomicPatternFactory);
	}

	@Override
	protected List<EObject> getPositionAdjacentMatches(EdgePattern edge, NodePattern target) {
		
		NavigableMatchesDS sourceDS = getDataStore(history.getPosition());
		List<EObject> adjacentMatches = new ArrayList<EObject>();
		
		for (EObject lastMatch : history.getLastMatch()) {
			sourceDS.getRemoteMatchIterator(lastMatch, edge).forEachRemaining(match -> {
				if (!adjacentMatches.contains(match)) {	// TODO: Use a Set?
					adjacentMatches.add(match);
				}
			});
		}
		
		return adjacentMatches;
	}
	
	@Override
	protected List<EObject> getAdjacentMatches(EObject match, NodePattern source, EdgePattern edge, NodePattern target) {
		
		NavigableMatchesDS sourceDS = getDataStore(source);
		List<EObject> adjacentMatches = new ArrayList<EObject>();
		
		sourceDS.getRemoteMatchIterator(match, edge).forEachRemaining(adjacentMatch -> {
			adjacentMatches.add(adjacentMatch);
		});
		
		return adjacentMatches;
	}

	@Override
	protected void selectMatches(NodePattern node, Collection<EObject> matches) {
		MatchSelection targetSelection = getDataStore(node).getMatchSelection();
		targetSelection.selectMatches(matches);
	}
	
	@Override
	protected void selectMatch(NodePattern node, EObject match) {
		MatchSelection targetSelection = getDataStore(node).getMatchSelection();
		targetSelection.selectMatch(match);
	}
}
