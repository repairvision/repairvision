package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.formulas.FormulaImpl;

public abstract class BinaryFormula extends FormulaImpl {

	protected Formula left;
	
	protected Formula right;

	protected BinaryFormula(Formula left, Formula right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return left.getResult() + " " + name + " " + right.getResult();
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
