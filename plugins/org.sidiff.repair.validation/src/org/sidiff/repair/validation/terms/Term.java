package org.sidiff.repair.validation.terms;

import org.sidiff.repair.validation.NamedElement;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;

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
	public abstract void repair(IRepairDecision parent, RepairType type);
}
