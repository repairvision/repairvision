package org.sidiff.common.exceptions;

import org.sidiff.common.util.StringUtil;

/**
 * Root exception for all runtime exceptions in SiDiff.
 */
public class SiDiffRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7081327426269876189L;
	private Object[] message;
	private Exception originalException;

	public SiDiffRuntimeException(Object... message) {
		this.message = message;
		this.originalException = SiDiffException.getOriginalException(message);
	}

	@Override
	public String getMessage() {
		return StringUtil.resolve(message);
	}

	public Exception getOriginalException() {
		return originalException;
	}

}
