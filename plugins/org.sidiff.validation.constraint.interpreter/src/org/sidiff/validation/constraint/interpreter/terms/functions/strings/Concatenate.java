package org.sidiff.validation.constraint.interpreter.terms.functions.strings;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.functions.Function;

public class Concatenate extends Function {

	protected Term left;
	
	protected Term right;
	
	public Concatenate(Term left, Term right) {
		this.name = "concatenate";
		this.left = left;
		this.right = right;
	}
	
	@Override
	public EClassifier getType() {
		return EcorePackage.eINSTANCE.getEString();
	}
	
	@Override
	public String toString() {
		return left.getValue() + ", " + right.getValue() + " -> " + super.toString();
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		left.evaluate(scope);
		right.evaluate(scope);
		
		value = "" + left.getValue() + right.getValue(); 
		
		return value;
	}
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		left.generate(parent, type);
		right.generate(parent, type);
	}

	@Override
	public void required(IDecisionBranch parent) {
		left.required(parent);
		right.required(parent);
	}
	
	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		left.repair(parent, type);
		right.repair(parent, type);
	}
}
