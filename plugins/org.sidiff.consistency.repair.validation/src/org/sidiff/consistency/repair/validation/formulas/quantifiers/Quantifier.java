package org.sidiff.consistency.repair.validation.formulas.quantifiers;

import org.sidiff.consistency.repair.validation.formulas.Formula;
import org.sidiff.consistency.repair.validation.terms.Term;
import org.sidiff.consistency.repair.validation.terms.Variable;

public abstract class Quantifier extends Formula {

	protected Variable next;
	
	protected Term iteration;
	
	protected Formula formula;

	protected Quantifier(Variable next, Term iteration, Formula formula) {
		super();
		this.next = next;
		this.iteration = iteration;
		this.formula = formula;
	}

	public Variable getNext() {
		return next;
	}

	public void setNext(Variable next) {
		this.next = next;
	}

	public Term getIteration() {
		return iteration;
	}

	public void setIteration(Term iteration) {
		this.iteration = iteration;
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}
}
