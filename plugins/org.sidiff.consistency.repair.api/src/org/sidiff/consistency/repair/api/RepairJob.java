package org.sidiff.consistency.repair.api;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Rule;

/**
 * A container for all applicable repairs.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <R>
 *            The kind of {@link Repair}.
 */
public class RepairJob<R extends IRepair> {

	/**
	 * History of applied repairs.
	 */
	protected Stack<List<RuleApplication>> repairStack = new Stack<>();

	/**
	 * All applicable repairs per CPO.
	 */
	protected Map<Rule, List<R>> repairs;

	/**
	 * The historic model version.
	 */
	protected Resource modelA;

	/**
	 * The actual model version which have to be repaired.
	 */
	protected Resource modelB;

	/**
	 * The difference between model A and model B.
	 */
	protected Resource difference;

	/**
	 * Initializes an empty repair job.
	 */
	public RepairJob() {
	}

	/**
	 * Copies the history of applied repairs from the given repair job.
	 * 
	 * @param repairJob
	 *            The repair job that contains the repair history.
	 */
	public void copyHistory(RepairJob<R> repairJob) {
		this.repairStack = repairJob.repairStack;
	}

	public List<RuleApplication> applyRepairs(List<IRepair> repairs) {
		List<RuleApplication> appliedRepairs = new LinkedList<>();

		// Apply repair:
		for (IRepair repair : repairs) {
			RuleApplication repairApplication = repair.apply();
			appliedRepairs.add(repairApplication);

			// Save model
			if (repairApplication != null) {
				try {
					getModelB().save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (!appliedRepairs.isEmpty()) {
			repairStack.push(appliedRepairs);
			return appliedRepairs;
		} else {
			return null;
		}
	}

	public List<RuleApplication> undoLastRepairs() {

		// Undo repair:
		if (!repairStack.isEmpty()) {
			List<RuleApplication> lastRepairs = repairStack.pop();

			// Save model
			for (RuleApplication ruleApplication : lastRepairs) {
				if (ruleApplication.undo(null)) {
					try {
						getModelB().save(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			return lastRepairs;
		} else {
			return null;
		}
	}

	public Map<Rule, List<R>> getRepairs() {
		return repairs;
	}

	public void setRepairs(Map<Rule, List<R>> repairs) {
		this.repairs = repairs;
	}

	public Resource getModelA() {
		return modelA;
	}

	public void setModelA(Resource modelA) {
		this.modelA = modelA;
	}

	public Resource getModelB() {
		return modelB;
	}

	public void setModelB(Resource modelB) {
		this.modelB = modelB;
	}

	public Resource getDifference() {
		return difference;
	}

	public void setDifference(Resource difference) {
		this.difference = difference;
	}
}
