package org.sidiff.graphpattern.csp.generic.impl.domain;

/**
 * Selection iterator which is locked by the restriction state (as debugging helper).
 * 
 * @author Manuel Ohrndorf
 */
public class VisibileIterationLocked<D> extends VisibileIteration<D> {

	private Domain<D> domain;

	private ValueRestriction<D> restrictionState;

	public VisibileIterationLocked(Domain<D> matchSelection) {
		super(matchSelection);

		this.domain = matchSelection;
		this.restrictionState = (matchSelection.restrictions.size() > 0) ?
				matchSelection.restrictions.firstElement() : null;
	}

	@Override
	public D next() {

		// NOTE: next() may only be called again if the restriction is in the
		// same state as the iterator was created.
		if ((restrictionState == null) || (domain.restrictions.firstElement() == restrictionState)) {
			return super.next();
		} else {
			throw new RuntimeException("Unexpexted selection state!");
		}
	}
}
