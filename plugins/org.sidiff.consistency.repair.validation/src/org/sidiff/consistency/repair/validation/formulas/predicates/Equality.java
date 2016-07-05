package org.sidiff.consistency.repair.validation.formulas.predicates;

import org.sidiff.consistency.repair.validation.terms.Term;

public class Equality extends Predicate {

	protected Term termA;
	
	protected Term termB;
	
	public Equality(Term termA, Term termB) {
		super();
		this.termA = termA;
		this.termB = termB;
	}

	@Override
	public boolean evaluate() {
		return termA.evaluate().equals(termB.evaluate());
	}
}
