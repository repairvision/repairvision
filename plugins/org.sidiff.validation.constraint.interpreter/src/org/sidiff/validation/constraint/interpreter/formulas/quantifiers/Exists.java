package org.sidiff.validation.constraint.interpreter.formulas.quantifiers;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.formulas.binary.Formula;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.Variable;
import org.sidiff.validation.constraint.interpreter.terms.functions.GetClosure;

/**
 * Represents an existential quantifier.
 * 
 * @author Manuel Ohrndorf
 */
public class Exists extends Quantifier {

	// exists(Type bounded in iteration : formula)
	
	public Exists(Variable bounded, Term iteration, Formula formula) {
		super(bounded, iteration, formula);
		this.name = "exists";
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimze) {
		iteration.evaluate(scope);

		for (Object nextObject : getIterable()) {
			bounded.assign(nextObject);

			if (formula.evaluate(scope, optimze))  {
				result = true;
				return result;
			}
		}

		result = false;
		return result;
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {

		if (getResult() == expected) {
			Sequence sequence = Sequence.nextSequence(parent);
			
			if (expected) {
				iteration.required(sequence);
			}
			
			Alternative alternative = Alternative.nextAlternative(sequence);
			
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (formula.evaluate(IScopeRecorder.DUMMY, false) == expected)  {
					Sequence alternativeSequence = Sequence.nextSequence(alternative);
					formula.required(alternativeSequence, expected);
					
					if (iteration instanceof GetClosure) {
						((GetClosure) iteration).required(alternativeSequence, (EObject) nextObject);
					}
				}
			}
		}
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		Alternative alternativ = Alternative.nextAlternative(parent);

		// if σ = t
		if (expected) {
			
			// A: Add at least one valid element (term) to the iterated set!
			if (isMany()) {
				iteration.repair(alternativ, RepairType.CREATE);
			} else {
				// Singleton:
				if (isEmpty()) {
					iteration.repair(alternativ, RepairType.CREATE);
				} else {
					iteration.repair(alternativ, RepairType.MODIFY);
				}
			}

			// B: Make at least one element (term) of the set valid!
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);

				if (!formula.evaluate(IScopeRecorder.DUMMY, false))  {
					formula.repair(alternativ, expected);
					
					if (iteration instanceof GetClosure) {
						((GetClosure) iteration).repair(alternativ, RepairType.CREATE, (EObject) nextObject);
					}
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

				if (formula.evaluate(IScopeRecorder.DUMMY, false))  {
					formula.repair(sequence, expected);
					
					if (iteration instanceof GetClosure) {
						((GetClosure) iteration).repair(alternativ, RepairType.DELETE, (EObject) nextObject);
					}
				}
			}
		}
	}
}
