package org.sidiff.revision.compare.matching;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.sidiff.revision.model.ModelASG;
import org.sidiff.revision.model.util.ASTIterator;

/**
 * General candidate management for unmatched model elements mapped to keys.
 * 
 * @author Manuel Ohrndorf
 */
public class Candidates {

	/**
	 * The model containing the candidate elements.
	 */
	protected ModelASG model;

	/**
	 * The key to candidate map.
	 */
	protected Map<Object, List<Object>> candidates = new HashMap<>();

	/**
	 * Creates and initializes the candidate management.
	 * 
	 * @param model {@link #model}
	 */
	public Candidates(ModelASG model) {
		init(model);
	}

	/**
	 * Creates the candidate management which need initialization
	 * ({@link #init(ModelASG)}).
	 */
	public Candidates() {
	}

	/**
	 * Initializes the candidate management.
	 * 
	 * @param model {@link #model}
	 */
	public void init(ModelASG model) {
		this.model = model;
		this.candidates = new HashMap<>();

		for (Object elementB : (Iterable<Object>) () -> new ASTIterator(model)) {
			add(elementB);
		}
	}

	/**
	 * Adds a new candidate by calculating its key ({@link #getKey(Object)}).
	 * 
	 * @param element A unmatched candidate.
	 */
	public void add(Object element) {
		Object key = getKey(element);
		List<Object> candidates = this.candidates.get(key);

		if (candidates == null) {
			candidates = new LinkedList<>();
			this.candidates.put(key, candidates);
		}

		candidates.add(element);
	}

	/**
	 * @param key A key ({@link #getKey(Object)}).
	 * @return The associated candidates.
	 */
	public List<Object> getCandidates(Object key) {
		List<Object> candidates = this.candidates.get(key);

		if (candidates == null) {
			return Collections.emptyList();
		}

		return candidates;
	}

	/**
	 * @param element A model element of the candidate {@link Candidates#model}.
	 * @return The key for grouping the candidates.
	 */
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
	public Map<Object, List<Object>> getCandidates() {
		return candidates;
	}
}
