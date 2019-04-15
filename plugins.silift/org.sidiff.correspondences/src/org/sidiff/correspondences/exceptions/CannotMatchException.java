package org.sidiff.correspondences.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;

@SuppressWarnings("serial")
public class CannotMatchException extends SiDiffRuntimeException {

	public CannotMatchException(Object... message) {
		super(message);
	}

}
