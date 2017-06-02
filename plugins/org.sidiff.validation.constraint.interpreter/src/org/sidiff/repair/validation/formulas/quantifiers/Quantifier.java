package org.sidiff.repair.validation.formulas.quantifiers;

import java.util.Collections;

import org.sidiff.repair.validation.formulas.binary.Formula;
import org.sidiff.repair.validation.terms.Term;
import org.sidiff.repair.validation.terms.Variable;

// TODO: Store evaluation iteration for repair generation!
//       - copy the formula for each iteration step

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
	
	protected boolean isMany() {
		if ((iteration.getValue() != null) && (iteration.getValue() instanceof Iterable<?>)) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isEmpty() {
		if ((iteration.getValue() != null) && (iteration.getValue() instanceof Iterable<?>)) {
			return ((Iterable<?>)iteration.getValue()).iterator().hasNext();
		} else {
			return (iteration.getValue() == null);
		}
	}
	
	protected Iterable<?> getIterable() {
		if ((iteration.getValue() != null) && (iteration.getValue() instanceof Iterable<?>)) {
			return (Iterable<?>) iteration.getValue();
		} else {
			if (isEmpty()) {
				return Collections.emptyList();
			} else {
				return Collections.singletonList(iteration.getValue());
			}
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
