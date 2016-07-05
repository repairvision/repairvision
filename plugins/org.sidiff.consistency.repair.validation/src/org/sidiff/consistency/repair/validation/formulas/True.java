package org.sidiff.consistency.repair.validation.formulas;

public class True extends Formula {

	public True() {
		this.name = "true";
		this.result = true;
	}

	@Override
	public boolean evaluate() {
		return result;
	}
}
