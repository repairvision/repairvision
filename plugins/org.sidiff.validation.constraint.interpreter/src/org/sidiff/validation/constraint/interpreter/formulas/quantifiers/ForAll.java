package org.sidiff.validation.constraint.interpreter.formulas.quantifiers;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.Variable;
import org.sidiff.validation.constraint.interpreter.terms.functions.navigation.GetClosure;

/**
 * Represents an universal quantifier.
 * 
 * @author Manuel Ohrndorf
 */
public class ForAll extends Quantifier {

	// forAll(Type bounded in iteration : formula)
	
	public ForAll(Variable bounded, Term iteration, Formula formula) {
		super(bounded, iteration, formula);
		this.name = "forAll";  
	}
	
	@Override
	public String toString() {
		return super.toString();
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
	public void analyze(IDecisionBranch parent, boolean expected) {
		Sequence sequence = Sequence.nextSequence(parent);
		formula.analyze(sequence, expected);
		
		if (expected) {
			iteration.generate(sequence, ConstraintType.REQUIRE);
		} else {
			iteration.generate(sequence, ConstraintType.FORBID);
		}
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {

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
	public void repair(IDecisionBranch parent, boolean expected) {
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
