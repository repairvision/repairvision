package org.sidiff.validation.constraint.interpreter.terms;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;

public class Variable extends Term {

	private EClass type;
	
	public Variable(EClass type, String name) {
		this.type = type;
		this.name = name;
	}
	
	@Override
	public EClassifier getType() {
		return type;
	}
	
	public void assign(Object value) {
		this.value = value;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		scope.addElement(value);
		return value;
	}

	@Override
	public Object getValue() {
		return value;
	}
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		// nothing to do...
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		// nothing to do...
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		// nothing to do...
	}
}
