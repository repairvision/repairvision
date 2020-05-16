package org.sidiff.revision.compare.impl;

import org.sidiff.revision.compare.Match;
import org.sidiff.revision.compare.Matcher;
import org.sidiff.revision.compare.matching.Matching;
import org.sidiff.revision.compare.matching.impl.MatchingImpl;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.annotations.ConfigFactories;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.model.ModelSet;

/**
 * A basic configurable matcher implementation.
 * 
 * @author Manuel Ohrndorf
 */
public class MatcherImpl implements Matcher {

	@ConfigField
	protected Configuration config;

	@ConfigFactories
	protected Factories factories;

	/**
	 * @param config An un- or a pre-configured configuration for this component.
	 */
	public MatcherImpl(Configuration config) {
		configure(config);
	}
	
	public MatcherImpl() {
		this(null);
	}

	@Override
	public void configureDefaultFactories(Configuration config) {
		factories.set(Matching.class, () -> new MatchingImpl(config));
	}

	@Override
	public boolean canHandle(ModelSet model) {
		return true; // TODO: Based on doc-type
	}

	@Override
	public Match match(ModelSet modelA, ModelSet modelB) {
		Matching matching = factories.create(Matching.class);
		matching.init(modelA, modelB);
		return matching.match();
	}

}
