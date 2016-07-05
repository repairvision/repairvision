package org.sidiff.consistency.repair.validation.terms;

import org.sidiff.consistency.repair.validation.NamedElement;

public abstract class Term extends NamedElement  {

	protected Object value;
	
	public Object getValue() {
		return value;
	}
	
	public abstract Object evaluate();
}
