package org.sidiff.repair.validation.formulas.predicates;

import org.sidiff.repair.validation.terms.Term;

public abstract class Comparison extends Predicate {

	protected Term left;
	
	protected Term right;
	
	protected Comparison(String name, Term left, Term right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
}
