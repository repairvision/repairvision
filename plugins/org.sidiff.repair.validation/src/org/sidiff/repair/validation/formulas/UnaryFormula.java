package org.sidiff.repair.validation.formulas;

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
