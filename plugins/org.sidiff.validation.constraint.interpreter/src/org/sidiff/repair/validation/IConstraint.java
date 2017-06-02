package org.sidiff.repair.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.formulas.binary.Formula;

public interface IConstraint extends INamedElement {

	boolean evaluate(EObject contextElement);
	
	boolean evaluate(EObject contextElement, IScopeRecorder scope);

	boolean getResult();

	EClass getContextType();

	void setContextType(EClass contextType);

	EObject getContext();

	void setContext(EObject contextElement);

	Formula getFormula();

	void setFormula(Formula formula);

	String getMessage();

	void setMessage(String message);

	IRepairDecision repair();
	
	IRepairDecision repair(IScopeRecorder scope);
}