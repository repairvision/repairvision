package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class IsInstanceOf extends Predicate {

	protected Term term;
	
	protected EClass type;
	
	public IsInstanceOf(Term term, EClass type) {
		this.name = "isInstanceOf";
		this.term = term;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name + "(" + term.getValue() + ", " + type.getName() + ")";
	}
	
	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		term.evaluate(scope);
		
		if (term.getValue() == null) {
			result = false;
		} else {
			result = (((EObject) term.getValue()).eClass() == type);
		}
		
		return result;
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		if (expected && getResult()) {
			term.required(parent);
		}
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		if (!getResult()) {
			term.repair(parent, RepairType.MODIFY);
		}
	}
}
