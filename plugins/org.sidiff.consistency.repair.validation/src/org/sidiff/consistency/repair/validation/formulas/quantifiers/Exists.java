package org.sidiff.consistency.repair.validation.formulas.quantifiers;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
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
		
		for (EObject nextObject : iteration.getValue()) {
			next.assign(Collections.singletonList(nextObject));
			
			if (formula.evaluate())  {
				return true;
			}
		}
		
		return false;
	}
}
