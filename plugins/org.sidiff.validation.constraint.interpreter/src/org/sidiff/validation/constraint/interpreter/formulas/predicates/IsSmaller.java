package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class IsSmaller extends Comparison {

	public IsSmaller(Term left, Term right) {
		super("isSmaller", left, right);
	}
	
	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		left.evaluate(scope);
		right.evaluate(scope);
		
		Integer left_value = (Integer) left.getValue();
		Integer right_value = (Integer) right.getValue();
		result = left_value < right_value;
		
		return result;
	}

	@Override
	public void repair(IDecisionNode parent, boolean expected) {
		
		if (expected && !getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.DELETE);
			right.repair(newRepairAlternative, RepairType.CREATE);
		} 
		
		else if (!expected && getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.CREATE);
			right.repair(newRepairAlternative, RepairType.DELETE);
		}
	}
}
