package org.sidiff.revision.compare.impl;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.revision.compare.Match;

/**
 * A plain map based implementation of {@link Match}.
 * 
 * @author Manuel Ohrndorf
 */
public class MatchImpl implements Match {

	private Map<Object, Object> correspondencesA2B = new HashMap<>();

	private Map<Object, Object> correspondencesB2A = new HashMap<>();

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

}
