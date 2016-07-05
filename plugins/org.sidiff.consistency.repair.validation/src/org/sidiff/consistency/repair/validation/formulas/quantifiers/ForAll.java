package org.sidiff.consistency.repair.validation.formulas.quantifiers;

import org.sidiff.consistency.repair.validation.formulas.Formula;
import org.sidiff.consistency.repair.validation.terms.Term;
import org.sidiff.consistency.repair.validation.terms.Variable;

/**
 * Represents an universal quantifier.
 * 
 * @author Manuel Ohrndorf
 */
public class ForAll extends Quantifier {

	public ForAll(Variable next, Term iteration, Formula formula) {
		super(next, iteration, formula);
	}

	@Override
	public boolean evaluate() {
		
		for (Object nextObject : ((Iterable<?>) iteration.evaluate())) {
			next.assign(nextObject);
			
			if (!formula.evaluate())  {
				return false;
			}
		}
		
		return true;
	}
}
