package org.sidiff.consistency.repair.validation.formulas.quantifiers;

import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
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
		
		// Bind variable:
		next.bind(iteration);
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

	@Override
	public void generateRepairs(IRepairDecision parentRepairDecision, boolean expected) {
		
		// if σ = t
		if (expected) {
			// A: Add at least one valid element (term) to the iterated set!
			// B: Make at least one element (term) of set valid!
			
		}
		
		// if σ = f
		else {
			// A: Delete all valid elements (terms) of the set!
			// B: Make all valid elements (terms) of the set invalid!
		}
	}
}
