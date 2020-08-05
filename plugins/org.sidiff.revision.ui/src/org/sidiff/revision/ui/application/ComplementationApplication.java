package org.sidiff.revision.ui.application;

import org.eclipse.emf.henshin.interpreter.Match;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.api.ComplementationSettings;

/**
 * Interface between the UI and the {@link ComplementationFacade}.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <J>
 *            The kind of complementation job.
 * @param <F>
 *            The kind of complementation settings.
 */
public interface ComplementationApplication<J extends ComplementationJob<?>, F extends ComplementationSettings> {

	/**
	 * @param complementationFacade
	 *            Access to the complementation calculation.
	 */
	void initialize(ComplementationFacade<J, F> complementationFacade);
	
	/**
	 * @return The actual complementation job.
	 */
	J getComplementationJob();
	
	/**
	 * @param listener
	 *            Adds a new listener that will be called if the complementation result
	 *            has changed.
	 */
	void addResultChangedListener(ResultChangedListener<J> listener);
	
	/**
	 * @param listener
	 *            Removes the given listener.
	 */
	void removeResultChangeListener(ResultChangedListener<J> listener);
	
	/**
	 * Removes all listeners.
	 */
	void clearResultChangeListener();
	
	/**
	 * Starts the model validation.
	 */
	void validation();
	
	/**
	 * Starts a new complementation calculation.
	 */
	void calculateComplementations();
	
	/**
	 * Recalculates the complementations with the previous input.
	 */
	void recalculateComplementations();
	
	/**
	 * @param complementation
	 *            The complementation which will be applied.
	 * @param match
	 *            The (full) match of the complement rule.
	 * @return <code>true</code> if everything was fine; <code>false</code> otherwise.
	 */
	boolean applyComplementation(ComplementationPlan complementation, Match match);
	
	/**
	 * Reverts the last complementations.
	 */
	boolean undoComplementation();
	
	/**
	 * @param complementation  The incomplete edit step changes to be rolled back.
	 * @return <code>true</code> if everything was fine; <code>false</code> otherwise.
	 */
	boolean rollbackIncomplete(ComplementationPlan complementation);
	
	/**
	 * Clear application state.
	 */
	void clear();
}
