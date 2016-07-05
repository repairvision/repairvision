package org.sidiff.consistency.repair.validation.formulas.quantifiers;

import org.sidiff.consistency.repair.validation.formulas.Formula;
import org.sidiff.consistency.repair.validation.terms.Term;
import org.sidiff.consistency.repair.validation.terms.Variable;

/**
 * Represents an existential quantifier.
 * 
 * @author Manuel Ohrndorf
 */
public class Exists extends Quantifier {

	public Exists(Variable next, Term iteration, Formula formula) {
		super(next, iteration, formula);
	}

	@Override
	public boolean evaluate() {
		
		for (Object nextObject : ((Iterable<?>) iteration.evaluate())) {
			next.assign(nextObject);
			
			if (formula.evaluate())  {
				return true;
			}
		}
		
		return false;
	}
}
