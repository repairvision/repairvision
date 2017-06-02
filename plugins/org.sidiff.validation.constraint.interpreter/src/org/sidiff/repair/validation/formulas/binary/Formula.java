package org.sidiff.repair.validation.formulas.binary;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.NamedElement;
import org.sidiff.repair.validation.fix.IRepairDecision;

public abstract class Formula extends NamedElement {

	protected Boolean result;
	
	public abstract boolean evaluate(IScopeRecorder scope);
	
	public Boolean getResult() {
		return result;
	}
	
	public void clear() {
		result = null;
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
	public abstract void repair(IRepairDecision parent, boolean expected, IScopeRecorder scope);
}
