package org.sidiff.validation.constraint.interpreter.terms.functions.strings;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.functions.Function;

public class Capitalize extends Function {

	protected Term string;
	
	public Capitalize(Term string) {
		this.name = "capitalize";
		this.string = string;
	}
	
	@Override
	public EClassifier getType() {
		return EcorePackage.eINSTANCE.getEString();
	}
	
	@Override
	public String toString() {
		return string.getValue() + " -> " + super.toString();
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		String string_value = (String) string.evaluate(scope);
		
		value = ("" + string_value.charAt(0)).toUpperCase() + string_value.substring(1);
		
		return value;
	}
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		string.generate(parent, type);
	}

	@Override
	public void required(IDecisionBranch parent) {
		string.required(parent);
	}
	
	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		string.repair(parent, type);
	}
}
