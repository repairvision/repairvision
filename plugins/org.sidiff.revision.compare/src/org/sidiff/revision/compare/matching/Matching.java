package org.sidiff.revision.compare.matching;

import org.sidiff.revision.compare.Match;
import org.sidiff.revision.model.ModelSet;

public interface Matching {

	/**
	 * @param modelA Contains all model elements that should be compared to
	 *               {@code modelB}.
	 * @param modelB Contains all model elements that should be compared to
	 *               {@code modelA}.
	 */
	void init(ModelSet modelA, ModelSet modelB);

	/**
	 * Starts the matching of model A with model B.
	 * 
	 * @return The calculated matches between both models.
	 */
	Match match();

}