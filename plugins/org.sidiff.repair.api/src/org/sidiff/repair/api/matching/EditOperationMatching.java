package org.sidiff.repair.api.matching;

import org.eclipse.emf.henshin.interpreter.Match;

/**
 * A pre-match for a complement rule.
 */
public class EditOperationMatching {

	private Match preMatch;

	public EditOperationMatching(Match preMatch) {
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
