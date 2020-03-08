package org.sidiff.revision.compare.impl;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.revision.compare.Match;
import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.annotations.ConfigFactories;

/**
 * A plain map based implementation of {@link Match}.
 * 
 * @author Manuel Ohrndorf
 */
public class MatchImpl implements Match, Configurable {

	@ConfigFactories
	protected Factories factories;

	private Map<Object, Object> correspondencesA2B;

	private Map<Object, Object> correspondencesB2A;

	/**
	 * @param config An un- or a pre-configured configuration for this component.
	 */
	@SuppressWarnings("unchecked")
	public MatchImpl(Configuration config) {
		configure(config);

		this.correspondencesA2B = factories.create(Map.class);
		this.correspondencesB2A = factories.create(Map.class);
	}

	public MatchImpl() {
		this(null);
	}

	@Override
	public void configureDefaultFactories(Configuration config) {
		factories.set(Map.class, () -> new HashMap<>());
	}

	@Override
	public boolean add(Object elementA, Object elementB) {
		assert (!correspondencesA2B.containsKey(elementA));
		assert (!correspondencesB2A.containsKey(elementB));

		correspondencesA2B.put(elementA, elementB);
		correspondencesB2A.put(elementB, elementA);
		return true;
	}

	@Override
	public boolean remove(Object elementA, Object elementB) {
		assert (correspondencesA2B.containsKey(elementA));
		assert (correspondencesB2A.containsKey(elementB));
		assert (correspondencesA2B.get(elementA) == elementB);
		assert (correspondencesB2A.get(elementB) == elementA);

		correspondencesA2B.remove(elementA);
		correspondencesB2A.remove(elementB);
		return true;
	}

	@Override
	public boolean contains(Object elementA, Object elementB) {
		assert (correspondencesB2A.get(elementB) == elementA);
		return (correspondencesA2B.get(elementA) == elementB);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E getInA(E elementB) {
		return (E) correspondencesB2A.get(elementB);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E getInB(E elementA) {
		return (E) correspondencesA2B.get(elementA);
	}

	public Map<Object, Object> getCorrespondencesA2B() {
		return correspondencesA2B;
	}

	public Map<Object, Object> getCorrespondencesB2A() {
		return correspondencesB2A;
	}
	
}
