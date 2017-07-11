package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public class And extends BinaryFormula {

	public And(Formula left, Formula right) {
		super(left, right);
		this.name = "and";
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {

		if (optimize) {
			result = left.evaluate(scope, optimize) && right.evaluate(scope, optimize);
		} else {
			left.evaluate(scope, optimize);
			right.evaluate(scope, optimize);
			result = left.getResult() && right.getResult();
		}
		
		return result;
	}
	
	@Override
	public void required(IDecisionNode parent, boolean expected) {
		
		// A AND B = true:
		// t*    t*  t*
		// t     f   f
		// f     t   f
		// f     f   f
		// > Sequence
		
		// A AND B = false:
		// t     t   t
		// t     f*  f*
		// f*    t   f*
		// f*    f*  f*
		// > Alternative

		if (getResult() == expected) {
			if (expected && left.getResult() && right.getResult()) {
				Sequence sequence = new Sequence();
				parent.appendChildDecisions(sequence);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}

			else if (!expected && left.getResult() && !right.getResult()) {
				right.required(parent, right.getResult());
			}

			else if (!expected && !left.getResult() && right.getResult()) {
				left.required(parent, left.getResult());
			}

			else if (!expected && !left.getResult() && !right.getResult()) {
				Alternative alternative = new Alternative();
				parent.appendChildDecisions(alternative);
				left.required(alternative, left.getResult());
				right.required(alternative, right.getResult());
			}
		}
	}

	@Override
	public void repair(IDecisionNode parent, boolean expected) {
		
		// A AND B = true:
		// t     t   t
		// t     f*  f*
		// f*    t   f*
		// f*    f*  f*
		// > Sequence
		
		// A AND B = false:
		// t*    t*  t*
		// t     f   f
		// f     t   f
		// f     f   f
		// > Alternative
		
		if (getResult() != expected) {
			if (expected && left.getResult() && !right.getResult()) {
				right.repair(parent, !right.getResult());
			}
			
			else if (expected && !left.getResult() && right.getResult()) {
				left.repair(parent, !left.getResult());
			}
			
			else if (expected && !left.getResult() && !right.getResult()) {
				Sequence newRepairSequence = new Sequence();
				parent.appendChildDecisions(newRepairSequence);
				left.repair(newRepairSequence, !left.getResult());
				right.repair(newRepairSequence, !right.getResult());
			}
			
			else if (!expected && left.getResult() && right.getResult()) {
				Alternative newRepairAlternative = new Alternative();
				parent.appendChildDecisions(newRepairAlternative);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
		}
	}
}
