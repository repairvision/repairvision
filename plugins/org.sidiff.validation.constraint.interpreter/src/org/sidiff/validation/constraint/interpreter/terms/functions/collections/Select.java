package org.sidiff.validation.constraint.interpreter.terms.functions.collections;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.Variable;

/**
 * Represents the select function.
 * 
 * @author Manuel Ohrndorf
 */
public class Select extends Iterator {

	// select(Type bounded in iteration : formula)
	
	public Select(Variable bounded, Term iteration, Formula formula) {
		super(bounded, iteration, formula);
		this.name = "select";  
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public EClassifier getType() {
		return bounded.getType();
	}

	@Override
	public Object evaluate(IScopeRecorder scope) {
		iteration.evaluate(scope);
		Set<Object> selection = new LinkedHashSet<>();
		value = selection;

		for (Object nextObject : getIterable()) {
			bounded.assign(nextObject);

			if (formula.evaluate(scope, true))  {
				selection.add(nextObject);
			}
		}
		
		return value;
	}
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		// TODO
	}

	@Override
	public void required(IDecisionBranch parent) {
		// TODO
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		Alternative alternativ = Alternative.nextAlternative(parent);
		iteration.repair(alternativ, RepairType.MODIFY);
		
		for (Object nextObject : getIterable()) {
			bounded.assign(nextObject);
			boolean result = formula.evaluate(IScopeRecorder.DUMMY, false);
			
			if (type.equals(RepairType.MODIFY)) {
				formula.repair(alternativ, !result);
			} else {
				if (result)  {
					if (type.equals(RepairType.DELETE)) {
						formula.repair(alternativ, false);
					}
				} else {
					if (type.equals(RepairType.CREATE)) {
						formula.repair(alternativ, true);
					}
				}
			}
		}
	}
}
