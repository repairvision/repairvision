package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;

public class Xor extends BinaryFormula {

	public Xor(Formula left, Formula right) {
		super(left, right);
		this.name = "xor";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
	
		if (optimize) {
			result = left.evaluate(scope, optimize) != right.evaluate(scope, optimize);
		} else {
			left.evaluate(scope, optimize);
			right.evaluate(scope, optimize);
			result = left.getResult() != right.getResult();
		}
		
		return result;
	}
	
	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
		
		if (expected) {
			
			// t f / f t
			Alternative alternative = Alternative.nextAlternative(parent);
			
			// t f
			Sequence sequenceTrueFalse = Sequence.nextSequence(alternative);
			left.analyze(sequenceTrueFalse, true);
			right.analyze(sequenceTrueFalse, false);
			
			// f t
			Sequence sequenceFalseTrue = Sequence.nextSequence(alternative);
			left.analyze(sequenceFalseTrue, false);
			right.analyze(sequenceFalseTrue, true);
			
		} else {
			
			// t t / f f
			Alternative alternative = Alternative.nextAlternative(parent);
			
			// t t
			Sequence sequenceTrueTrue = Sequence.nextSequence(alternative);
			left.analyze(sequenceTrueTrue, true);
			right.analyze(sequenceTrueTrue, true);
			
			// f f
			Sequence sequenceFalseFalse = Sequence.nextSequence(alternative);
			left.analyze(sequenceFalseFalse, false);
			right.analyze(sequenceFalseFalse, false);
		}
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		// A XOR B = true:
		// t     t   f
		// t*    f*  t*
		// f*    t*  t*
		// f     f   f
		// > Sequence
		
		// A XOR B = false:
		// t*    t*  f*
		// t     f   t
		// f     t   t
		// f*    f*  f*
		// > Sequence
		
		if (result == expected) {
			if (!expected && left.getResult() && right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
			
			else if (expected && left.getResult() && !right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
			
			else if (expected && !left.getResult() && right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
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
		
		// A XOR B = true:
		// t*    t*  f*
		// t     f   t
		// f     t   t
		// f*    f*  f*
		// > Alternative
		
		// A XOR B = false:
		// t     t   f
		// t*    f*  t*
		// f*    t*  t*
		// f     f   f
		// > Alternative
		
		if (getResult() != expected) {
			if (expected && left.getResult() && right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult()); 
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (expected && !left.getResult() && !right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (!expected && left.getResult() && !right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (!expected && !left.getResult() && right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
		}
	}
}
