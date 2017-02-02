package org.sidiff.repair.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.formulas.binary.Formula;
import org.sidiff.repair.validation.terms.Variable;

public class ConsistencyRule extends NamedElement {

	private EClass contextType;
	
	private Variable context;
	
	private Formula formula;
	
	private String message;
	
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
	
	public boolean getResult() {
		return formula.getResult();
	}

	public EClass getContextType() {
		return contextType;
	}

	public void setContextType(EClass contextType) {
		this.contextType = contextType;
	}

	public EObject getContext() {
		return (EObject) context.getValue();
	}

	public void setContext(EObject contextElement) {
		this.context.assign(contextElement);
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IRepairDecision repair() {
		IRepairDecision repairTreeRoot = new Alternative();
		formula.repair(repairTreeRoot, true);
		return repairTreeRoot;
	}
}
