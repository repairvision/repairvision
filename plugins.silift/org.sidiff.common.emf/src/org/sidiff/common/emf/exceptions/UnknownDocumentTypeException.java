package org.sidiff.common.emf.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;

/**
 * Exception that is thrown if the document type is unknown or not supported.
 */
public class UnknownDocumentTypeException extends SiDiffRuntimeException {

	private static final long serialVersionUID = -1058428634529368842L;

	public UnknownDocumentTypeException(Object... message) {
		super(message);
	}

}
