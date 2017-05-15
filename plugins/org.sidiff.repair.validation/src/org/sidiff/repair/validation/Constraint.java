package org.sidiff.repair.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.formulas.binary.Formula;
import org.sidiff.repair.validation.terms.Variable;

public class Constraint extends NamedElement implements IConstraint {

	private EClass contextType;
	
	private Variable context;
	
	private Formula formula;
	
	private String message;
	
	public Constraint(EClass contextType, Variable context, Formula formula) {
		super();
		this.contextType = contextType;
		this.context = context;
		this.formula = formula;
	}
	
	@Override
	public boolean evaluate(EObject contextElement) {
		return evaluate(contextElement, new ScopeRecorderDummy());
	}
	
	@Override
	public boolean evaluate(EObject contextElement, IScopeRecorder scope) {
		this.context.assign(contextElement);
		return formula.evaluate(scope);
	}
	
	@Override
	public boolean getResult() {
		return formula.getResult();
	}

	@Override
	public EClass getContextType() {
		return contextType;
	}

	@Override
	public void setContextType(EClass contextType) {
		this.contextType = contextType;
	}

	@Override
	public EObject getContext() {
		return (EObject) context.getValue();
	}

	@Override
	public void setContext(EObject contextElement) {
		this.context.assign(contextElement);
	}

	@Override
	public Formula getFormula() {
		return formula;
	}

	@Override
	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public IRepairDecision repair() {
		return repair(new ScopeRecorderDummy());
	}

	@Override
	public IRepairDecision repair(IScopeRecorder scope) {
		IRepairDecision repairTreeRoot = new Alternative();
		
		// Repair which deletes the root element:
		if (getContext().eContainmentFeature() != null) {
			if (getContext().eContainmentFeature().getEOpposite() != null) {
				// Use container reference:
				repairTreeRoot.appendChildDecisions(new RepairAction(
						RepairType.DELETE, getContext(),  getContext().eContainmentFeature().getEOpposite()));
			} else {
				// Use containment reference (as cross-reference):
				repairTreeRoot.appendChildDecisions(new RepairAction(
						RepairType.DELETE, getContext(),  getContext().eContainmentFeature()));
			}
		}
		
		// Repairs for validation scope:
		formula.repair(repairTreeRoot, true, scope);
		
		return repairTreeRoot;
	}
}
