package org.sidiff.consistency.repair.validation.formulas.quantifiers;

import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
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
		
		// Bind variable:
		next.bind(iteration);
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

	@Override
	public void generateRepairs(IRepairDecision parentRepairDecision, boolean expected) {
		
		// if σ = t
		if (expected) {
			// A: Delete all invalid elements (terms) of the set!
			// B: Make all invalid elements (terms) of the set valid!
			
		}
		
		// if σ = f
		else {
			// A: Add at least one invalid element (term) to the iterated set!
			// B: Make at least one element (term) of set invalid!
			
		}
	}
}
