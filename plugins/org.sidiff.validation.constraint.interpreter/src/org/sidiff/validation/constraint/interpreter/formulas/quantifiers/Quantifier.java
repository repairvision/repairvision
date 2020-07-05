package org.sidiff.validation.constraint.interpreter.formulas.quantifiers;

import java.util.Collections;

import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.formulas.FormulaImpl;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.Variable;

// TODO: Store evaluation iteration for repair generation!
//       - copy the formula for each iteration step

public abstract class Quantifier extends FormulaImpl {

	// Quantifier(Type bounded in iteration : formula)
	
	protected Variable bounded;
	
	protected Term iteration;
	
	protected Formula formula;

	protected Quantifier(Variable next, Term iteration, Formula formula) {
		super();
		this.bounded = next;
		this.iteration = iteration;
		this.formula = formula;
	}
	
	@Override
	public String toString() {
		return name + "(" + bounded.toString() + " in " + iteration.toString() + " : " + formula.toString() + ")";
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
