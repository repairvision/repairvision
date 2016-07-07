package org.sidiff.consistency.repair.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Sequence;
import org.sidiff.consistency.repair.validation.formulas.Formula;
import org.sidiff.consistency.repair.validation.terms.Variable;

public class ConsistencyRule extends NamedElement {

	protected EClass contextType;
	
	protected Variable context;
	
	protected Formula formula;
	
	public ConsistencyRule(EClass contextType, Variable context, Formula formula) {
		super();
		this.contextType = contextType;
		this.context = context;
		this.formula = formula;
	}

	public boolean evaluate(EObject contextElement) {
		this.context.assign(contextElement);
		return formula.evaluate();
	}

	public EClass getContextType() {
		return contextType;
	}

	public void setContextType(EClass contextType) {
		this.contextType = contextType;
	}

	public Variable getContext() {
		return context;
	}

	public void setContext(Variable context) {
		this.context = context;
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	public IRepairDecision generateRepairs() {
		IRepairDecision repairTreeRoot = new Sequence();
		formula.generateRepairs(repairTreeRoot, true);
		return repairTreeRoot;
	}
}
