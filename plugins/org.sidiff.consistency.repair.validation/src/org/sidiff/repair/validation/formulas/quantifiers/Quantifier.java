package org.sidiff.repair.validation.formulas.quantifiers;

import java.util.Collections;

import org.sidiff.repair.validation.formulas.Formula;
import org.sidiff.repair.validation.terms.Term;
import org.sidiff.repair.validation.terms.Variable;

public abstract class Quantifier extends Formula {

	protected Variable bounded;
	
	protected Term iteration;
	
	protected Formula formula;

	protected Quantifier(Variable next, Term iteration, Formula formula) {
		super();
		this.bounded = next;
		this.iteration = iteration;
		this.formula = formula;
	}
	
	protected Iterable<?> getIterable() {
		iteration.evaluate();
		
		if ((iteration.getValue() != null) && (iteration.getValue() instanceof Iterable<?>)) {
			return (Iterable<?>) iteration.getValue();
		} else {
			return Collections.emptyList();
		}
	}

	public Variable getNext() {
		return bounded;
	}

	public void setNext(Variable next) {
		this.bounded = next;
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
