package org.sidiff.revision.compare.matching;

import java.util.Iterator;
import java.util.List;

import org.sidiff.revision.compare.Match;
import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.annotations.ConfigFactories;
import org.sidiff.revision.model.ModelASG;
import org.sidiff.revision.model.ModelSet;
import org.sidiff.revision.model.util.ASTIterator;

/**
 * A basic configurable ({@link Candidates}) matching algorithm.
 * 
 * @author Manuel Ohrndorf
 * @see Matching#settings()
 */
public class Matching implements Configurable {

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
	 * @param modelA {@link #modelA}
	 * @param modelB {@link #modelB}
	 * @param config An un- or a pre-configured configuration for this component.
	 */
	public Matching(ModelSet modelA, ModelSet modelB, Configuration config) {
		this.modelA = modelA;
		this.modelB = modelB;

		configure(config);
	}

	/**
	 * @param modelA {@link #modelA}
	 * @param modelB {@link #modelB}
	 */
	public Matching(ModelSet modelA, ModelSet modelB) {
		this(modelA, modelB, null);
	}

	/**
	 * @see Candidates
	 */
	@Override
	public void configureDefaultFactories(Configuration config) {
		factories.set(Candidates.class, Candidates.class);
		factories.set(Matching.class, Matching.class);
	}

	/**
	 * Starts the matching of model A with model B.
	 */
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

				Candidates candidatesB = factories.create(Candidates.class, astB);
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
		List<Object> candidatesByKeyB = candidatesB.getCandidates(keyA);

		// An iterator can efficiently find and delete the candidate in the linked list.
		for (Iterator<Object> iterator = candidatesByKeyB.iterator(); iterator.hasNext();) {
			Object elementB = iterator.next();

			if (compare(elemetA, elementB)) {

				// Synchronize matching and candidates!
				match.add(elemetA, elementB);
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
