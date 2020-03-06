package org.sidiff.revision.compare.impl;

import org.sidiff.revision.compare.Match;
import org.sidiff.revision.compare.Matcher;
import org.sidiff.revision.compare.matching.Matching;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.model.ModelSet;

/**
 * A basic configurable matcher implementation.
 * 
 * @author Manuel Ohrndorf
 */
public class MatcherImpl implements Matcher {

	@Override
	public boolean canHandle(ModelSet model, Configuration config) {
		return true; // TODO: Based on doc-type
	}

	@Override
	public void match(Match match, ModelSet modelA, ModelSet modelB, Configuration config) {
		new Matching(match, modelA, modelB, config);
	}

}
