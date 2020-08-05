package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;

public class Iff extends BinaryFormula {

	public Iff(Formula left, Formula right) {
		super(left, right);
		this.name = "equals";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
		
		if (expected) {
			
			// t t / f f
			Alternative alternative = Alternative.nextAlternative(parent);
			
			// t t
			Sequence sequenceTrue = Sequence.nextSequence(alternative);
			left.analyze(sequenceTrue, true);
			right.analyze(sequenceTrue, true);
			
			// f f
			Sequence sequenceFalse = Sequence.nextSequence(alternative);
			left.analyze(sequenceFalse, true);
			right.analyze(sequenceFalse, true);
			
		} else {
			
			// f t / t f
			Alternative alternative = Alternative.nextAlternative(parent);
			
			// f t
			Sequence sequenceFalseTrue = Sequence.nextSequence(alternative);
			left.analyze(sequenceFalseTrue, false);
			right.analyze(sequenceFalseTrue, true);
			
			// t f
			Sequence sequenceTrueFalse = Sequence.nextSequence(alternative);
			left.analyze(sequenceTrueFalse, true);
			right.analyze(sequenceTrueFalse, false);
		}
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		
		if (optimize) {
			result = left.evaluate(scope, optimize) == right.evaluate(scope, optimize);
		} else {
			left.evaluate(scope, optimize);
			right.evaluate(scope, optimize);
			result = left.getResult() == right.getResult();
		}
		
		return result;
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		// A AND B = true:
		// t*    t*  t*
		// t     f   f
		// f     t   f
		// f*    f*  t*
		// > Sequence
		
		// A AND B = false:
		// t     t   t
		// t*    f*  f*
		// f*    t*  f*
		// f     f   t
		// > Sequence
		
		if (result == expected) {
			if (expected && left.getResult() && right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
			
			else if (expected && !left.getResult() && !right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
			
			else if (!expected && left.getResult() && !right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
			
			else if (!expected && !left.getResult() && right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
		}
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		// A AND B = true:
		// t     t   t
		// t*    f*  f*
		// f*    t*  f*
		// f     f   t
		// > Alternative
		
		// A AND B = false:
		// t*    t*  t*
		// t     f   f
		// f     t   f
		// f*    f*  t*
		// > Alternative
		
		if (getResult() != expected) {
			if (expected && left.getResult() && !right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (expected && !left.getResult() && right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (!expected && left.getResult() && right.getResult()) {
				Alternative newRepairSequence = Alternative.nextAlternative(parent);
				left.repair(newRepairSequence, !left.getResult());
				right.repair(newRepairSequence, !right.getResult());
			}
			
			else if (!expected && !left.getResult() && !right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
		}
	}
}
