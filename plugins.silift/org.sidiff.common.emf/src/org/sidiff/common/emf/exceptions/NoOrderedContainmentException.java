package org.sidiff.common.emf.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;

public class NoOrderedContainmentException extends SiDiffRuntimeException {

	private static final long serialVersionUID = -6277507152272861586L;

	public NoOrderedContainmentException(Object... message) {
		super(message);
	}

}
