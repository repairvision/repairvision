package org.sidiff.repair.validation.formulas.quantifiers;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Sequence;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.formulas.Formula;
import org.sidiff.repair.validation.terms.Term;
import org.sidiff.repair.validation.terms.Variable;

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

		for (Object nextObject : getIterable()) {
			bounded.assign(nextObject);

			if (formula.evaluate())  {
				result = true;
				return result;
			}
		}

		result = false;
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		Alternative alternativ = Alternative.nextAlternative(parent);
		
		// if σ = t
		if (expected) {
			// A: Add at least one valid element (term) to the iterated set!
			iteration.repair(alternativ, RepairType.ADD);
			
			// B: Make at least one element (term) of the set valid!
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (!formula.evaluate())  {
					formula.repair(alternativ, expected);
				}
			}
		}
		
		// if σ = f
		else {
			// A: Delete all valid elements (terms) of the set!
			iteration.repair(alternativ, RepairType.DELETE);
			
			// B: Make all valid elements (terms) of the set invalid!
			Sequence sequence = Sequence.nextSequence(alternativ);
			
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (formula.evaluate())  {
					formula.repair(sequence, expected);
					
					// TODO: Case A: Concrete vs. abstract remove!?
//					bounded.repair(sequence, RepairType.DELETE);
				}
			}
		}
	}
}
