package org.sidiff.consistency.repair.validation.formulas.predicates;

import org.sidiff.consistency.repair.validation.terms.Term;

public class Equality extends Predicate {

	protected Equality(Term... terms) {
		super(2, terms);
	}

	@Override
	public boolean evaluate() {
		return terms[0].getValue().equals(terms[1].getValue());
	}
}
