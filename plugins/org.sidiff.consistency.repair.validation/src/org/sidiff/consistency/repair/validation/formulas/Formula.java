package org.sidiff.consistency.repair.validation.formulas;

import org.sidiff.consistency.repair.validation.NamedElement;

public abstract class Formula extends NamedElement {

	protected boolean result;
	
	public abstract boolean evaluate();
	
	public boolean getResult() {
		return result;
	}
}
