package org.sidiff.repair.validation.formulas.binary;

import org.sidiff.repair.validation.fix.IRepairDecision;

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
	
	@Override
	public boolean evaluate() {
		
		// Clear old evaluation:
		left.clear();
		right.clear();;
		
		return false;
	}
	
	@Override
	public void repair(IRepairDecision parentRepairDecision, boolean expected) {
		
		// Ensure complete (unoptimized) evaluation:
		if (left.getResult() == null) {
			left.evaluate();
		}
		
		if (right.getResult() == null) {
			right.evaluate();
		}
	}
}
