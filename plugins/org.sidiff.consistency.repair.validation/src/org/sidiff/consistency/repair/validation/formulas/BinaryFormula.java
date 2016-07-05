package org.sidiff.consistency.repair.validation.formulas;

public abstract class BinaryFormula extends Formula {

	protected Formula left;
	
	protected Formula right;

	protected BinaryFormula(Formula left, Formula right) {
		super();
		this.left = left;
		this.right = right;
	}

	public Formula getLeft() {
		return left;
	}

	public void setLeft(Formula left) {
		this.left = left;
	}

	public Formula getRight() {
		return right;
	}

	public void setRight(Formula right) {
		this.right = right;
	}
}
