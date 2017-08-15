package org.sidiff.validation.constraint.interpreter.terms.functions;

import org.sidiff.validation.constraint.interpreter.terms.Term;

/**
 * A {@link Function} takes {@link Term}s (objects) as arguments 
 * and produces objects as its result.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class Function extends Term {

	@Override
	public String toString() {
		return super.toString();
	}
}
