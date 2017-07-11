package org.sidiff.validation.constraint.interpreter.formulas.unary;

import org.sidiff.validation.constraint.interpreter.formulas.binary.Formula;

public abstract class UnaryFormula extends Formula {

	protected Formula child;

	protected UnaryFormula(Formula child) {
		super();
		this.child = child;
	}

	public Formula getChild() {
		return child;
	}

	public void setChild(Formula child) {
		this.child = child;
	}
}
