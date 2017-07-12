package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public class Xor extends BinaryFormula {

	public Xor(Formula left, Formula right) {
		super(left, right);
		this.name = "xor";
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
