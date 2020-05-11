package org.sidiff.revision.editrules.recognition.pattern.domain;

import org.eclipse.emf.ecore.EObject;

/**
 * Selection iterator which is locked by the restriction state (as debugging helper).
 * 
 * @author Manuel Ohrndorf
 */
public class IteratorSearchedLocked extends IteratorSearched {

	private Domain domain;

	private Restriction restrictionState;

	public IteratorSearchedLocked(Domain matchSelection) {
		super(matchSelection);

		this.domain = matchSelection;
		this.restrictionState = (matchSelection.restrictions.size() > 0) ?
				matchSelection.restrictions.firstElement() : null;
	}

	@Override
	public EObject next() {

		// NOTE: next() may only be called again if the restriction is in the
		// same state as the iterator was created.
		if ((restrictionState == null) || (domain.restrictions.firstElement() == restrictionState)) {
			return super.next();
		} else {
			throw new RuntimeException("Unexpexted selection state!");
		}
	}
}
