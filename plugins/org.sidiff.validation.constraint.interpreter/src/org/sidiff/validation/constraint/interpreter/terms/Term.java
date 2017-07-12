package org.sidiff.validation.constraint.interpreter.terms;

import org.sidiff.validation.constraint.interpreter.NamedElement;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public abstract class Term extends NamedElement  {

	protected Object value;
	
	public Object getValue() {
		return value;
	}
	
	public abstract Object evaluate(IScopeRecorder scope);
	
	public abstract void required(IDecisionBranch parent);
	
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
	public abstract void repair(IDecisionBranch parent, RepairType type);
}
