package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.INamedElement;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public interface Formula extends INamedElement {

	String toString();

	boolean evaluate(IScopeRecorder scope, boolean optimize);

	void generate(IDecisionBranch parent, boolean expected);

	void required(IDecisionBranch parent, boolean expected);

	void repair(IDecisionBranch parent, boolean expected);

	Boolean getResult();

	void clear();

}