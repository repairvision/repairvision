package org.sidiff.common.emf.exceptions;

public class NoCorrespondencesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4911109852204584000L;
	private static final String message = "No Correspondences found between models.\n" +
			"This could be due to a wrong Matcher for this document/model type.";

	public NoCorrespondencesException() {
		super(message);
	}
}
