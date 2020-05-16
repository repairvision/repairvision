package org.sidiff.revision.compare.matching.impl;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.revision.compare.matching.Candidate;
import org.sidiff.revision.compare.matching.CandidateList;
import org.sidiff.revision.compare.matching.Candidates;
import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.Factory;
import org.sidiff.revision.configuration.annotations.ConfigFactories;
import org.sidiff.revision.model.ModelASG;
import org.sidiff.revision.model.util.ASTIterator;

/**
 * General candidate management for unmatched model elements mapped to keys.
 * 
 * @author Manuel Ohrndorf
 */
public class CandidatesImpl implements Configurable, Candidates {

	@ConfigFactories
	protected Factories factories;
	
	/**
	 * Cache the candidate list factory for efficiency.
	 */
	protected Factory<CandidateList> factoryCandidateList;
	
	/**
	 * Cache the candidate factory for efficiency.
	 */
	protected Factory<Candidate> factoryCandidate;

	/**
	 * The model containing the candidate elements.
	 */
	protected ModelASG model;

	/**
	 * The key to candidate map.
	 */
	protected Map<Object, CandidateList> candidates;
	
	/**
	 * Represents all empty candidate lists.
	 */
	protected CandidateList emptyCandidateList;

	/**
	 * @param config An un- or a pre-configured configuration for this component.
	 */
	public CandidatesImpl(Configuration config) {
		configure(config);
		
		this.factoryCandidateList = factories.get(CandidateList.class);
		this.factoryCandidate = factories.get(Candidate.class);
		this.emptyCandidateList = factoryCandidateList.create();
	}

	public CandidatesImpl() {
		this(null);
	}
	
	@Override
	public void configureDefaultFactories(Configuration config) {
		factories.set(CandidateList.class, () -> new CandidateListImpl(() -> new CandidateImpl()));
	}

	public void init(ModelASG model) {
		this.model = model;
		this.candidates = new HashMap<>();

		for (Object elementB : (Iterable<Object>) () -> new ASTIterator(model)) {
			add(elementB);
		}
	}

	@Override
	public void add(Object element) {
		Object key = getKey(element);
		CandidateList candidates = this.candidates.get(key);

		if (candidates == null) {
			candidates = factoryCandidateList.create();
			this.candidates.put(key, candidates);
		}

		Candidate candidate = factoryCandidate.create();
		candidate.setElement(element);
		
		candidates.add(candidate);
	}


	@Override
	public CandidateList getCandidates(Object key) {
		CandidateList candidates = this.candidates.get(key);

		if (candidates == null) {
			return emptyCandidateList;
		}

		return candidates;
	}

	@Override
	public Object getKey(Object element) {
		return model.eClass(element);
	}

	/**
	 * @return {@link #model}
	 */
	public ModelASG getModel() {
		return model;
	}

	/**
	 * @return {@link #candidates}
	 */
	@Override
	public Map<Object, CandidateList> getCandidates() {
		return candidates;
	}
}
