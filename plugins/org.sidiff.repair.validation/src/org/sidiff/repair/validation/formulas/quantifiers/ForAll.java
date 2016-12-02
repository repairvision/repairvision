package org.sidiff.repair.validation.formulas.quantifiers;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Sequence;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.formulas.Formula;
import org.sidiff.repair.validation.terms.Term;
import org.sidiff.repair.validation.terms.Variable;

/**
 * Represents an universal quantifier.
 * 
 * @author Manuel Ohrndorf
 */
public class ForAll extends Quantifier {

	public ForAll(Variable bounded, Term iteration, Formula formula) {
		super(bounded, iteration, formula);
		
		// Bind variable:
		bounded.bind(iteration);
	}

	@Override
	public boolean evaluate() {
		iteration.evaluate();

		for (Object nextObject : getIterable()) {
			bounded.assign(nextObject);

			if (!formula.evaluate())  {
				result = false;
				return result;
			}
		}
		
		result = true;
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected) {
		Alternative alternativ = Alternative.nextAlternative(parent);
		
		// if σ = t
		if (expected) {
			// A: Delete all invalid elements (terms) of the set!
			iteration.repair(alternativ, RepairType.DELETE);
			
			// B: Make all invalid elements (terms) of the set valid!
			Sequence sequence = Sequence.nextSequence(alternativ);
			
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (!formula.evaluate())  {
					formula.repair(sequence, expected);
					
					// TODO: Case A: Concrete vs. abstract remove!?
//					bounded.repair(sequence, RepairType.DELETE);
				}
			}
		}
		
		// if σ = f
		else {
			// A: Add at least one invalid element (term) to the iterated set!
			iteration.repair(alternativ, RepairType.ADD);
			
			// B: Make at least one element (term) of the set invalid!
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (formula.evaluate())  {
					formula.repair(alternativ, expected);
				}
			}
		}
	}
}
