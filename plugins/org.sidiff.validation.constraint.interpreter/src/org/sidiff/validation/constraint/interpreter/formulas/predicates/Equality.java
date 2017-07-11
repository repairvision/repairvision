package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class Equality extends Comparison {

	public Equality(Term left, Term right) {
		super("equality", left, right);
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		left.evaluate(scope);
		right.evaluate(scope);
		
		if ((left.getValue() != null) && (right.getValue() != null)) {
			result = left.getValue().equals(right.getValue());
		} else {
			result = left.getValue() == right.getValue();
		}
		
		return result;
	}

	public Term getTermA() {
		return left;
	}

	public void setTermA(Term termA) {
		this.left = termA;
	}

	public Term getTermB() {
		return right;
	}

	public void setTermB(Term termB) {
		this.right = termB;
	}
	
	@Override
	public void repair(IDecisionNode parent, boolean expected) {
		
		if (expected != getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.MODIFY);
			right.repair(newRepairAlternative, RepairType.MODIFY);
		}
	}
}
