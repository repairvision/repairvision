package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public abstract class Comparison extends Predicate {

	protected Term left;
	
	protected Term right;
	
	protected Comparison(String name, Term left, Term right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void required(IDecisionNode parent, boolean expected) {
		
		if (expected && getResult()) {
			Sequence sequence = Sequence.nextSequence(parent);
			
			left.required(sequence);
			right.required(sequence);
		}
	}
}
