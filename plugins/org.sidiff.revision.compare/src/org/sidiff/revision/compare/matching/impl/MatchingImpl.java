package org.sidiff.revision.compare.matching.impl;

import java.util.Iterator;

import org.sidiff.revision.compare.Match;
import org.sidiff.revision.compare.impl.MatchImpl;
import org.sidiff.revision.compare.matching.Candidate;
import org.sidiff.revision.compare.matching.CandidateList;
import org.sidiff.revision.compare.matching.Candidates;
import org.sidiff.revision.compare.matching.Matching;
import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.annotations.ConfigFactories;
import org.sidiff.revision.model.ModelASG;
import org.sidiff.revision.model.ModelSet;
import org.sidiff.revision.model.util.ASTIterator;

/**
 * A basic configurable ({@link CandidatesImpl}) matching algorithm.
 * 
 * @author Manuel Ohrndorf
 * @see MatchingImpl#settings()
 */
public class MatchingImpl implements Configurable, Matching {

	@ConfigFactories
	protected Factories factories;

	/**
	 * The matching of corresponding elements between model A and B.
	 */
	private Match match;

	/**
	 * The model A for comparison.
	 */
	private ModelSet modelA;

	/**
	 * The model B for comparison.
	 */
	private ModelSet modelB;

	/**
	 * @param config An un- or a pre-configured configuration for this component.
	 */
	public MatchingImpl(Configuration config) {
		configure(config);
	}

	public MatchingImpl() {
		this(null);
	}
	
	@Override
	public void init(ModelSet modelA, ModelSet modelB) {
		this.modelA = modelA;
		this.modelB = modelB;
	}

	/**
	 * @see CandidatesImpl
	 */
	@Override
	public void configureDefaultFactories(Configuration config) {
		factories.set(Candidates.class, () -> new CandidatesImpl(config));
		factories.set(Match.class, () -> new MatchImpl(config));
	}

	/**
	 * Starts the matching of model A with model B.
	 */
	@Override
	public Match match() {
		this.match = factories.create(Match.class);

		// Match model sets:
		if (compare(modelA, modelB)) {
			match.add(modelA, modelB);

			for (ModelASG astA : modelA) {
				for (ModelASG astB : modelB) {
					match(match, astA, astB);
				}
			}
		}

		return match;
	}

	protected void match(Match match, ModelASG astA, ModelASG astB) {

		// Match ASG root elements:
		if (!match.contains(astA, astB)) {
			if (compare(astA, astB)) {
				match.add(astA, astB);

				CandidatesImpl candidatesB = factories.create(CandidatesImpl.class);
				candidatesB.init(astB);
				
				match(match, astA, candidatesB);
			}
		}
	}

	protected void match(Match match, ModelASG astA, Candidates candidatesB) {

		// Match elements of model A to candidates of model B:
		for (Object elementA : (Iterable<Object>) () -> new ASTIterator(astA)) {
			match(match, elementA, candidatesB);
		}
	}

	protected void match(Match match, Object elemetA, Candidates candidatesB) {

		// Match element A in available candidates:
		Object keyA = candidatesB.getKey(elemetA);
		CandidateList candidatesByKeyB = candidatesB.getCandidates(keyA);

		// An iterator can efficiently find and delete the candidate in the linked list.
		for (Iterator<Candidate> iterator = candidatesByKeyB.iterator(); iterator.hasNext();) {
			Candidate candidateB = iterator.next();

			if (compare(elemetA, candidateB.getElement())) {

				// Synchronize matching and candidates!
				match.add(elemetA, candidateB.getElement());
				iterator.remove();
				break;
			}
		}
	}

	protected boolean compare(Object objA, Object objB) {
		return objA.getClass() == objB.getClass();
	}

	/**
	 * @return {@link #match}
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * @return {@link #modelA}
	 */
	public ModelSet getModelA() {
		return modelA;
	}

	/**
	 * @return {@link #modelB}
	 */
	public ModelSet getModelB() {
		return modelB;
	}
}
