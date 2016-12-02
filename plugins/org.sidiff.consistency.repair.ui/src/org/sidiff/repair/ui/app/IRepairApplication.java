package org.sidiff.repair.ui.app;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairSettings;
import org.sidiff.repair.api.RepairJob;

/**
 * Interface between the UI and the {@link IRepairFacade}.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <J>
 *            The kind of repair job.
 * @param <F>
 *            The kind of repair settings.
 */
public interface IRepairApplication<J extends RepairJob<?>, F extends IRepairSettings> {

	/**
	 * @param repairFacade
	 *            Access to the Repair calculation.
	 */
	void initialize(IRepairFacade<J, F> repairFacade);
	
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
	 * Starts a new repair calculation.
	 */
	void calculateRepairs();
	
	/**
	 * Recalculates the repair with the previous input.
	 */
	void recalculateRepairs();
	
	/**
	 * @param repair
	 *            The repairs which will be applied in the given order.
	 * @return <code>true</code> if everything was fine; <code>false</code> otherwise.
	 */
	boolean applyRepairs(List<IRepair> repair);
	
	/**
	 * @return The reverted repairs.
	 */
	List<RuleApplication> undoLastRepairs();
	
	/**
	 * Clear application state.
	 */
	void clear();
}
