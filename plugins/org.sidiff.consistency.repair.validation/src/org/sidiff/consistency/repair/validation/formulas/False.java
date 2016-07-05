package org.sidiff.consistency.repair.validation.formulas;

public class False extends Formula {

	public False() {
		this.name = "false";
		this.result = false;
	}
	
	@Override
	public boolean evaluate() {
		return result;
	}
}
