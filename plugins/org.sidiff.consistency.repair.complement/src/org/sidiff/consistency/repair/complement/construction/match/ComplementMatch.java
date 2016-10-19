package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.henshin.interpreter.Match;

/**
 * A pre-match for a complement rule.
 */
public class ComplementMatch {

	private Match preMatch;

	public ComplementMatch(Match preMatch) {
		super();
		this.preMatch = preMatch;
	}

	public Match getMatch() {
		return preMatch;
	}

	public void setPreMatch(Match preMatch) {
		this.preMatch = preMatch;
	}
}
