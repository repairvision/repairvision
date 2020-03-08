package org.sidiff.revision.compare.matching;

import java.util.Map;

import org.sidiff.revision.compare.matching.impl.CandidatesImpl;
import org.sidiff.revision.model.ModelASG;

public interface Candidates {

	/**
	 * Initializes the candidate management.
	 * 
	 * @param model {@link #model}
	 */
	void init(ModelASG model);
	
	/**
	 * Adds a new candidate by calculating its key ({@link #getKey(Object)}).
	 * 
	 * @param element A unmatched candidate.
	 */
	void add(Object element);

	/**
	 * @param key A key ({@link #getKey(Object)}).
	 * @return The associated candidates.
	 */
	CandidateList getCandidates(Object key);

	/**
	 * @param element A model element of the candidate {@link CandidatesImpl#model}.
	 * @return The key for grouping the candidates.
	 */
	Object getKey(Object element);

	/**
	 * @return {@link #candidates}
	 */
	Map<Object, CandidateList> getCandidates();

}