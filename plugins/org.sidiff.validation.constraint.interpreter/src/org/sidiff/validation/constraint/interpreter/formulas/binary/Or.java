package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;

public class Or extends BinaryFormula {

	public Or(Formula left, Formula right) {
		super(left, right);
		this.name = "or";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		
		if (optimize) {
			result = left.evaluate(scope, optimize) || right.evaluate(scope, optimize);
		} else {
			left.evaluate(scope, optimize);
			right.evaluate(scope, optimize);
			result = left.getResult() || right.getResult();
		}
		
		return result;
	}
	
	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
		
		if (expected) {
			
			// t t / t f / f t
			Alternative alternative = Alternative.nextAlternative(parent);
			left.analyze(alternative, true);
			right.analyze(alternative, true);
			
		} else {
			
			// f f
			Sequence sequence = Sequence.nextSequence(parent);
			left.analyze(sequence, false);
			right.analyze(sequence, false);
		}
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		// A OR B = true:
		// t*   t*  t*
		// t*   f   t*
		// f    t*  t*
		// f    f   f
		// > Alternative

		// A OR B = false:
		// t    t   t
		// t    f   t
		// f    t   t
		// f*   f*  f*
		// > Sequence

		if (result == expected) {
			if (expected && left.getResult() && right.getResult()) {
				Alternative alternative = Alternative.nextAlternative(parent);
				left.required(alternative, left.getResult());
				right.required(alternative, right.getResult());
			}
			
			else if (expected && left.getResult() && !right.getResult()) {
				left.required(parent, left.getResult());
			}
			
			else if (expected && !left.getResult() && right.getResult()) {
				right.required(parent, right.getResult());
			}
			
			else if (!expected && !left.getResult() && !right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
		}
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		// A OR B = true:
		// t    t   t
		// t    f   t
		// f    t   t
		// f*   f*  f*
		// > Alternative

		// A OR B = false:
		// t*   t*  t*
		// t*   f   t*
		// f    t*  t*
		// f    f   f
		// > Sequence
		
		if (getResult() != expected) {
			if (expected && !left.getResult() && !right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (!expected && left.getResult() && right.getResult()) {
				Sequence newRepairSequence = Sequence.nextSequence(parent);
				left.repair(newRepairSequence, !left.getResult());
				right.repair(newRepairSequence, !right.getResult());
			}
			
			else if (!expected && left.getResult() && !right.getResult()) {
				left.repair(parent, !left.getResult());
			}
			
			else if (!expected && !left.getResult() && right.getResult()) {
				right.repair(parent, !right.getResult());
			}
		}
	}
}
