package org.sidiff.revision.repair.ui.app;

import org.eclipse.emf.henshin.interpreter.Match;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.IComplementationFacade;
import org.sidiff.revision.api.IComplementationPlan;
import org.sidiff.revision.api.IComplementationSettings;

/**
 * Interface between the UI and the {@link IComplementationFacade}.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <J>
 *            The kind of repair job.
 * @param <F>
 *            The kind of repair settings.
 */
public interface IRepairApplication<J extends ComplementationJob<?>, F extends IComplementationSettings> {

	/**
	 * @param repairFacade
	 *            Access to the Repair calculation.
	 */
	void initialize(IComplementationFacade<J, F> repairFacade);
	
	/**
	 * @return The actual repair job.
	 */
	J getRepairJob();
	
	/**
	 * @param listener
	 *            Adds a new listener that will be called if the repair result
	 *            has changed.
	 */
	void addResultChangedListener(IResultChangedListener<J> listener);
	
	/**
	 * @param listener
	 *            Removes the given listener.
	 */
	void removeResultChangeListener(IResultChangedListener<J> listener);
	
	/**
	 * Removes all listeners.
	 */
	void clearResultChangeListener();
	
	/**
	 * Starts the model validation.
	 */
	void validation();
	
	/**
	 * Starts a new repair calculation.
	 */
	void calculateRepairs();
	
	/**
	 * Recalculates the repair with the previous input.
	 */
	void recalculateRepairs();
	
	/**
	 * @param repair
	 *            The repair which will be applied.
	 * @param match
	 *            The (full) match of the complement rule.
	 * @return <code>true</code> if everything was fine; <code>false</code> otherwise.
	 */
	boolean applyRepair(IComplementationPlan repair, Match match);
	
	/**
	 * Reverts the last repairs.
	 */
	boolean undoRepair();
	
	/**
	 * @param repair  The repair based on the inconsistency-inducing change to be rolled back.
	 * @return <code>true</code> if everything was fine; <code>false</code> otherwise.
	 */
	boolean rollbackInconsistencyInducingChanges(IComplementationPlan repair);
	
	/**
	 * Clear application state.
	 */
	void clear();
}
