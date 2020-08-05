package org.sidiff.validation.constraint.interpreter.formulas.predicates.types;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.PredicateImpl;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class IsValueLiteralOf extends PredicateImpl {

	protected Term term;
	
	protected EDataType type;
	
	protected Term typeTerm;
	
	public IsValueLiteralOf(Term term, EDataType type) {
		this.name = "isValueLiteralOf";
		this.term = term;
		this.type = type;
	}
	
	public IsValueLiteralOf(Term term, Term typeTerm) {
		this.name = "isValueLiteralOf";
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
			
			if (term.getValue() != null) {
				try {
					Object defaultValue = type.getEPackage().getEFactoryInstance().createFromString(type, (String) term.getValue());
					result = Diagnostician.INSTANCE.validate(type, defaultValue, null, null);
				} catch (Exception e) {
					result = false;
				}
			} else {
				result = true;
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
