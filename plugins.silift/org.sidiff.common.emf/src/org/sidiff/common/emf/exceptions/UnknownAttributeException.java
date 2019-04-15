package org.sidiff.common.emf.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;

/**
 * Exception that is thrown if an attribute does not exist.
 */
public class UnknownAttributeException extends SiDiffRuntimeException {

	private static final long serialVersionUID = 2902417114575317516L;

	public UnknownAttributeException(Object... message) {
		super(message);
	}

}
