package org.sidiff.validation.constraint.interpreter.terms;

import org.eclipse.emf.ecore.EClassifier;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.NamedElement;

public abstract class Term extends NamedElement  {

	protected Object value;
	
	public Object getValue() {
		return value;
	}
	
	public abstract EClassifier getType();
	
	@Override
	public String toString() {
		if (name != null) {
			return name + " -> " + value;
		} else {
			if (value != null) {
				return value.toString();
			} else {
				return "null";
			}
		}
	}
	
	public abstract Object evaluate(IScopeRecorder scope);

	public abstract void generate(IDecisionBranch parent, ConstraintType type);
	
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
