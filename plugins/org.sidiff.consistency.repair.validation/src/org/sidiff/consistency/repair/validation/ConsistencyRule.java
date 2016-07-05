package org.sidiff.consistency.repair.validation;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.repair.validation.formulas.Formula;
import org.sidiff.consistency.repair.validation.terms.Variable;

public class ConsistencyRule extends NamedElement {

	protected Variable context;
	
	protected Formula formula;
	
	public ConsistencyRule(Variable context, Formula formula) {
		this.context = context;
		this.formula = formula;
	}
	
	public boolean evaluate(EObject contextElement) {
		this.context.assign(Collections.singletonList(contextElement));
		return formula.evaluate();
	}
}
