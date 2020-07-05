package org.sidiff.validation.constraint.interpreter.formulas.unary;

import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.formulas.FormulaImpl;

public abstract class UnaryFormula extends FormulaImpl {

	protected Formula child;

	protected UnaryFormula(Formula child) {
		super();
		this.child = child;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	public Formula getChild() {
		return child;
	}

	public void setChild(Formula child) {
		this.child = child;
	}
}
