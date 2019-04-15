package org.sidiff.common.exceptions;

import org.sidiff.common.util.StringUtil;

/**
 * Root exception for all (non-runtime) exceptions in SiDiff.
 */
public class SiDiffException extends Exception {

	private static final long serialVersionUID = -1726238997249174286L;
	private Object[] message;
	private Exception originalException;

	public SiDiffException(Object... message) {
		this.message = message;
		this.originalException = getOriginalException(message);
	}

	@Override
	public String getMessage() {
		return StringUtil.resolve(message);
	}

	public Exception getOriginalException() {
		return originalException;
	}

	static Exception getOriginalException(Object[] message) {
		for (Object msgPart : message) {
			if (msgPart instanceof Exception) {
				return (Exception) msgPart;
			}
		}
		return null;
	}

}
