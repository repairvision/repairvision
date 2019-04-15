package org.sidiff.correspondences.exceptions;

@SuppressWarnings("serial")
public class OverlappingMatchException extends CannotMatchException {

	public OverlappingMatchException(Object... message) {
		super(message);
	}

}
