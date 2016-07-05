package org.sidiff.consistency.repair.validation.formulas.predicates;

import org.sidiff.consistency.repair.validation.formulas.Formula;
import org.sidiff.consistency.repair.validation.terms.Term;

/**
 * A {@link Predicate} (or relation) is a formula which takes {@link Term}s
 * (objects) as arguments and evaluates those {@link Term}s to a truth value.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class Predicate extends Formula {

	protected int arity;
	
	protected Term[] terms;
	
	protected Predicate(int arity, Term... terms) {
		this.arity = arity;
	}
	
	public Predicate(Term... terms) {
		assert (terms.length == arity) 
		: "Wrong count of parameters: (expected: " + arity + " actual: " + terms.length + ")";

		this.terms = terms;
	}
}
