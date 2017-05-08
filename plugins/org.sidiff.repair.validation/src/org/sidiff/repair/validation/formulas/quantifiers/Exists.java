package org.sidiff.repair.validation.formulas.quantifiers;

import java.util.HashSet;
import java.util.Set;

import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.fix.Sequence;
import org.sidiff.repair.validation.formulas.binary.Formula;
import org.sidiff.repair.validation.terms.Term;
import org.sidiff.repair.validation.terms.Variable;
import org.sidiff.repair.validation.terms.functions.GetClosure;

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
		iteration.evaluate();

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
			if (iteration instanceof GetClosure) {
				// Closure:
				Set<Object> invalid = new HashSet<>();
				
				for (Object nextObject : getIterable()) {
					bounded.assign(nextObject);

					if (!formula.evaluate())  {
						invalid.add(nextObject);
					}
				}
				
				((GetClosure) iteration).repair(alternativ, RepairType.ADD, invalid);
			} else {
				if (isMany()) {
					iteration.repair(alternativ, RepairType.ADD);
				} else {
					// Singleton:
					if (isEmpty()) {
						iteration.repair(alternativ, RepairType.ADD);
					} else {
						iteration.repair(alternativ, RepairType.MODIFY);
					}
				}
			}

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
			if (iteration instanceof GetClosure) {
				// Closure:
				Set<Object> invalid = new HashSet<>();
				
				for (Object nextObject : getIterable()) {
					bounded.assign(nextObject);

					if (!formula.evaluate())  {
						invalid.add(nextObject);
					}
				}
				
				((GetClosure) iteration).repair(alternativ, RepairType.DELETE, invalid);
			} else {
				iteration.repair(alternativ, RepairType.DELETE);
			}

			// B: Make all valid elements (terms) of the set invalid!
			Sequence sequence = Sequence.nextSequence(alternativ);

			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);

				if (formula.evaluate())  {
					formula.repair(sequence, expected);
				}
			}
		}
	}
}
