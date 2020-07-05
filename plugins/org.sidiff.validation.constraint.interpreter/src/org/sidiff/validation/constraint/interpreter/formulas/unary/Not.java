package org.sidiff.validation.constraint.interpreter.formulas.unary;

import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public class Not extends UnaryFormula {

	public Not(Formula child) {
		super(child);
		this.name = "not";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		result = !child.evaluate(scope, optimize);
		return result;
	}
	
	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
		child.analyze(parent, !expected);
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		// NOT A = true
		//     t   f
		//     f*  t*
		
		// NOT A = false
		//     t*  f*
		//     f   t
		
		if (getResult() ==  expected) {
			child.required(parent, !expected);
		}
	}

	@Override
	public void repair(IDecisionBranch parentRepairDecision, boolean expected) {
		
		// NOT A = true
		//     t*  f*
		//     f   t
		
		// NOT A = false
		//     t   f
		//     f*  t*
		
		if (getResult() !=  expected) {
			child.repair(parentRepairDecision, !expected);
		}
	}
}
