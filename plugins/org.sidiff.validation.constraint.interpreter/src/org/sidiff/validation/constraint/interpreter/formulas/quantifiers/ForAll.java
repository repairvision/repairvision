package org.sidiff.validation.constraint.interpreter.formulas.quantifiers;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.formulas.binary.Formula;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.Variable;
import org.sidiff.validation.constraint.interpreter.terms.functions.GetClosure;

/**
 * Represents an universal quantifier.
 * 
 * @author Manuel Ohrndorf
 */
public class ForAll extends Quantifier {

	// forAll(Type bounded in iteration : formula)
	
	public ForAll(Variable bounded, Term iteration, Formula formula) {
		super(bounded, iteration, formula);
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		iteration.evaluate(scope);

		for (Object nextObject : getIterable()) {
			bounded.assign(nextObject);

			if (!formula.evaluate(scope, optimize))  {
				result = false;
				return result;
			}
		}
		
		result = true;
		return result;
	}
	
	@Override
	public void required(IDecisionNode parent, boolean expected) {

		if (getResult() == expected) {
			Sequence sequence = Sequence.nextSequence(parent);
			
			if (expected) {
				iteration.required(sequence);
			}
			
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (formula.evaluate(IScopeRecorder.DUMMY, false) == expected)  {
					formula.required(sequence, expected);
					
					if (iteration instanceof GetClosure) {
						((GetClosure) iteration).required(sequence, (EObject) nextObject);
					} 
				}
			}
			
		}
	}

	@Override
	public void repair(IDecisionNode parent, boolean expected) {
		Alternative alternativ = Alternative.nextAlternative(parent);
		
		// if σ = t
		if (expected) {
			
			// A: Delete all invalid elements (terms) of the set!
			iteration.repair(alternativ, RepairType.DELETE);
			
			// B: Make all invalid elements (terms) of the set valid!
			Sequence sequence = Sequence.nextSequence(alternativ);
			
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (!formula.evaluate(IScopeRecorder.DUMMY, false))  {
					formula.repair(sequence, expected);
					
					// A: Delete all invalid elements (terms) of the set!
					if (iteration instanceof GetClosure) {
						((GetClosure) iteration).repair(alternativ, RepairType.DELETE, (EObject) nextObject);
					}
				}
			}
		}
		
		// if σ = f
		else {
			
			// A: Add at least one invalid element (term) to the iterated set!
			if (isMany()) {
				iteration.repair(alternativ, RepairType.CREATE);
			} else {
				if (isEmpty()) {
					iteration.repair(alternativ, RepairType.CREATE);
				} else {
					iteration.repair(alternativ, RepairType.MODIFY);
				}
			}
			
			// B: Make at least one element (term) of the set invalid!
			for (Object nextObject : getIterable()) {
				bounded.assign(nextObject);
				
				if (formula.evaluate(IScopeRecorder.DUMMY, false))  {
					formula.repair(alternativ, expected);
					
					// A: Add at least one invalid element (term) to the iterated set!
					if (iteration instanceof GetClosure) {
						((GetClosure) iteration).repair(alternativ, RepairType.CREATE, (EObject) nextObject);
					}
				}
			}
		}
	}
}
