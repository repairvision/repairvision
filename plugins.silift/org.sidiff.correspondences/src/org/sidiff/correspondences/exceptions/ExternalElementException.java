package org.sidiff.correspondences.exceptions;

/**
 * This Exception can be thrown by CorrespondencesServices that support the evaluation of 
 * elements in other (not loaded) resources that are referenced (i.e. external elements).
 * It is thrown if the partners of external elements are requested.
 * 
 * @author wenzel
 *
 */
public class ExternalElementException extends RuntimeException {

	private static final long serialVersionUID = -6375838414130121634L;

}
