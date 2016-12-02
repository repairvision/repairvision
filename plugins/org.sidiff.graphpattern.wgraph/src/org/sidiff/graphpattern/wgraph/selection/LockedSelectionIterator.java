package org.sidiff.graphpattern.wgraph.selection;

import org.eclipse.emf.ecore.EObject;

/**
 * Selection iterator which is locked by the restriction state (as debugging helper).
 * 
 * @author Manuel Ohrndorf
 */
public class LockedSelectionIterator extends SelectionIterator {

	MatchSelection matchSelection;

	private Restriction restrictionState;

	public LockedSelectionIterator(MatchSelection matchSelection) {
		super(matchSelection);

		this.matchSelection = matchSelection;
		this.restrictionState = (matchSelection.restrictionHistory.size() > 0) ?
				matchSelection.restrictionHistory.firstElement() : null;
	}

	@Override
	public EObject next() {

		// NOTE: next() may only be called again if the restriction is in the
		// same state as the iterator was created.
		if ((restrictionState == null) || (matchSelection.restrictionHistory.firstElement() == restrictionState)) {
			return super.next();
		} else {
			throw new RuntimeException("Unexpexted selection state!");
		}
	}
}
