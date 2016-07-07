package org.sidiff.consistency.repair.validation.formulas;

import org.sidiff.consistency.repair.validation.NamedElement;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;

public abstract class Formula extends NamedElement {

	protected boolean result;
	
	public abstract boolean evaluate();
	
	public boolean getResult() {
		return result;
	}
	
	/**
	 * Appends all child repair decisions (from left to right) of this
	 * {@link IValidation} to the given repair decision.
	 * 
	 * @param parentRepairDecision
	 *            The parent repair decision (in the repair tree) of this
	 *            validation fragment.
	 * 
	 */
	public abstract void generateRepairs(IRepairDecision parentRepairDecision, boolean expected);
}
