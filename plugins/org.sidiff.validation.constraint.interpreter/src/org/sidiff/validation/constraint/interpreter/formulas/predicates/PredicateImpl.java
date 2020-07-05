package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import org.sidiff.validation.constraint.interpreter.formulas.FormulaImpl;
import org.sidiff.validation.constraint.interpreter.terms.Term;

/**
 * A {@link PredicateImpl} (or relation) is a formula which takes {@link Term}s
 * (objects) as arguments and evaluates those {@link Term}s to a truth value.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class PredicateImpl extends FormulaImpl implements Predicate {

	@Override
	public String toString() {
		return super.toString();
	}
}
