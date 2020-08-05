package org.sidiff.validation.constraint.interpreter.formulas;

import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.INamedElement;

public interface Formula extends INamedElement {

	String toString();

	boolean evaluate(IScopeRecorder scope, boolean optimize);

	void analyze(IDecisionBranch parent, boolean expected);

	void required(IDecisionBranch parent, boolean expected);

	void repair(IDecisionBranch parent, boolean expected);

	Boolean getResult();

	void clear();

}