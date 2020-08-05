package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;

public class If extends BinaryFormula {

	public If(Formula left, Formula right) {
		super(left, right);
		this.name = "implies";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
		
		if (expected) {
			
			// t t / f t / f f
			Alternative alternative = Alternative.nextAlternative(parent);
			
			// t t
			Sequence sequence = Sequence.nextSequence(alternative);
			left.analyze(sequence, true);
			right.analyze(sequence, true);
			
			// f t / f f
			left.analyze(alternative, false);
		} else {
			
			// t f
			Sequence sequence = Sequence.nextSequence(parent);
			left.analyze(sequence, true);
			right.analyze(sequence, false);
		}
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		
		if (optimize) {
			result = !left.evaluate(scope, optimize) || right.evaluate(scope, optimize);
		} else {
			left.evaluate(scope, optimize);
			right.evaluate(scope, optimize);
			result = !left.getResult() || right.getResult();
		}
		
		return result;
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		// A IMPLIES B = !A OR B:
		
		// A IMPLIES B = true:
		// t         t*  t*
		// t         f   f
		// f*        t*  t*
		// f*        f   t*
		// > Alternative

		// A IMPLIES B = false:
		// t         t   t
		// t*        f*  f*
		// f         t   t
		// f         f   t
		// > Sequence

		if (result == expected) {
			if (expected && left.getResult() && right.getResult()) {
				
				// FIXME: ??? A IMPLIES B = !A OR B = !A OR (A AND B)
//				right.required(parent, left.getResult());
				
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
			
			else if (expected && !left.getResult() && right.getResult()) {
				Alternative alternative = Alternative.nextAlternative(parent);
				left.required(alternative, left.getResult());
				right.required(parent, right.getResult());
			}
			
			else if (expected && !left.getResult() && !right.getResult()) {
				left.required(parent, left.getResult());
			}
			
			else if (!expected && left.getResult() && !right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
		}
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		// A IMPLIES B = !A OR B:
		
		// A IMPLIES B = true:
		// t         t   t
		// t*        f*  f*
		// f         t   t
		// f         f   t
		// > Alternative

		// A IMPLIES B = false:
		// t         t*  t*
		// t         f   f
		// f*        t*  t*
		// f*        f   t*
		// > Sequence
		
		if (getResult() != expected) {
			if (expected && left.getResult() && !right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (!expected && left.getResult() && right.getResult()) {
				right.repair(parent, !right.getResult());
			}
			
			else if (!expected && !left.getResult() && right.getResult()) {
				Sequence newRepairSequence = Sequence.nextSequence(parent);
				left.repair(newRepairSequence, !left.getResult());
				right.repair(newRepairSequence, !right.getResult());
			}
			
			else if (!expected && !left.getResult() && !right.getResult()) {
				left.repair(parent, !left.getResult());
			}
		}
	}
}
