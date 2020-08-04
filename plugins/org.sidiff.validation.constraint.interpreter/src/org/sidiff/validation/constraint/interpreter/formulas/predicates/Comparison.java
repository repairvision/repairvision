package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public abstract class Comparison extends PredicateImpl {

	protected Term left;
	
	protected Term right;
	
	protected Comparison(String name, Term left, Term right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
		Sequence sequence = Sequence.nextSequence(parent);
		
		if (expected) {
			left.generate(sequence, ConstraintType.REQUIRE);
			right.generate(sequence, ConstraintType.REQUIRE);
		} else {
			left.generate(sequence, ConstraintType.FORBID);
			right.generate(sequence, ConstraintType.FORBID);
		}
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		if (expected && getResult()) {
			Sequence sequence = Sequence.nextSequence(parent);
			
			left.required(sequence);
			right.required(sequence);
		}
	}
}
