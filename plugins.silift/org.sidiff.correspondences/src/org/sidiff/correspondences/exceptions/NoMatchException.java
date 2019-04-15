package org.sidiff.correspondences.exceptions;

@SuppressWarnings("serial")
public class NoMatchException extends CannotMatchException {

	public NoMatchException(Object... message) {
		super(message);
	}

}
