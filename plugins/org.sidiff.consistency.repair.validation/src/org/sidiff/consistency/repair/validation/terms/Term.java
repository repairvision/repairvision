package org.sidiff.consistency.repair.validation.terms;

import org.sidiff.consistency.repair.validation.NamedElement;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;

public abstract class Term extends NamedElement  {

	protected Object value;
	
	public Object getValue() {
		return value;
	}
	
	public abstract Object evaluate();
	
	/**
	 * Appends all child repair decisions (from left to right) of this
	 * {@link IValidation} to the given repair decision.
	 * 
	 * @param parentRepairDecision
	 *            The parent repair decision (in the repair tree) of this
	 *            validation fragment.
	 * @param type
	 *            The modification kind.
	 * 
	 */
	public abstract void generateRepairs(IRepairDecision parentRepairDecision, RepairType type);
}
