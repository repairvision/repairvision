package org.sidiff.common.emf.nsregistry;

import org.sidiff.common.exceptions.SiDiffRuntimeException;


@SuppressWarnings("serial")
public class NamespaceException extends SiDiffRuntimeException {

	public NamespaceException(Object... message) {
		super(message);
	}
}
