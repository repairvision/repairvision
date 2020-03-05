package org.sidiff.revision.compare;

import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.model.ModelSet;

/**
 * Interface for different matching algorithms, which compare the content of two
 * models. That means a correspondence for each preserved object between the
 * models.
 * 
 * @author Manuel Ohrndorf
 */
public interface Matcher extends Configurable {

	/**
	 * @param model  Contains all model elements that should be compared to another
	 *               model.
	 * @param config Matcher specific settings for this matching task.
	 * @return <code>true</code> if the matcher can process the given model;
	 *         <code>false</code> otherwise.
	 */
	boolean canHandle(ModelSet model, Configuration config);

	/**
	 * Calculates a matching between two models. That means a correspondence for
	 * each preserved object between the models.
	 * 
	 * @param match  Stores the matched elements.
	 * @param modelA Contains all model elements that should be compared to
	 *               {@code modelB}.
	 * @param modelB Contains all model elements that should be compared to
	 *               {@code modelA}.
	 * @param config Matcher specific settings for this matching task.
	 */
	void match(Match match, ModelSet modelA, ModelSet modelB, Configuration config);

}
