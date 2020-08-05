package org.sidiff.validation.constraint.interpreter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;

public interface IConstraint extends INamedElement {

	boolean evaluate(EObject contextElement);
	
	boolean evaluate(EObject contextElement, IScopeRecorder scope);

	IDecisionNode repair();
	
	IDecisionNode required();
	
	boolean getResult();

	EClass getContextType();

	void setContextType(EClass contextType);

	EObject getContext();

	void setContext(EObject contextElement);

	Formula getFormula();

	void setFormula(Formula formula);

	String getMessage();

	void setMessage(String message);

}