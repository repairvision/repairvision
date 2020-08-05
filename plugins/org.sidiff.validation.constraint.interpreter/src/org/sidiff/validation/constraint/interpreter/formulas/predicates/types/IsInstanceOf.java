package org.sidiff.validation.constraint.interpreter.formulas.predicates.types;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.PredicateImpl;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class IsInstanceOf extends PredicateImpl {

	protected Term term;
	
	protected EClassifier type;
	
	protected Term typeTerm;
	
	public IsInstanceOf(Term term, EClassifier type) {
		this.name = "isInstanceOf";
		this.term = term;
		this.type = type;
	}
	
	public IsInstanceOf(Term term, Term typeTerm) {
		this.name = "isInstanceOf";
		this.term = term;
		this.typeTerm = typeTerm;
	}
	
	@Override
	public String toString() {
		return name + "(" + term.getValue() + ", " + type.getName() + ")";
	}
	
	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		
		// calculate type:
		if (typeTerm != null) {
			typeTerm.evaluate(scope);
			
			if (typeTerm.getValue() instanceof EDataType) {
				type = (EDataType) typeTerm.getValue();
			}
		}
		
		// evaluate instance:
		if (type != null) {
			term.evaluate(scope);
			
			if (term.getValue() == null) {
				result = false;
			} else {
				if ((type instanceof EClass) && (term.getValue() instanceof EObject)) {
					result = (((EObject) term.getValue()).eClass() == type)
							|| (((EObject) term.getValue()).eClass()).getESuperTypes().contains(type);
				} else {
					result = type.getInstanceClass().isInstance(term.getValue());
				}
			}
		} else {
			result = false;
		}
		
		return result;
	}
	
	@Override
	public void analyze(IDecisionBranch parent, boolean expected) {
		
		if (expected) {
			term.generate(parent, ConstraintType.REQUIRE);
			
			if (typeTerm != null) {
				typeTerm.generate(parent, ConstraintType.REQUIRE);
			}
		} else {
			term.generate(parent, ConstraintType.FORBID);
			
			if (typeTerm != null) {
				typeTerm.generate(parent, ConstraintType.FORBID);
			}
		}
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		if (expected && getResult()) {
			term.required(parent);
			
			if (typeTerm != null) {
				typeTerm.required(parent);
			}
		}
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		if (!getResult()) {
			term.repair(parent, RepairType.MODIFY);
			
			if (typeTerm != null) {
				typeTerm.repair(parent, RepairType.MODIFY);
			}
		}
	}
}
