package org.sidiff.common.emf.exceptions;

@SuppressWarnings("serial")
public class NoRootElementFoundException extends Exception{

	public NoRootElementFoundException(String nsUri) {
		super("No root element found for the meta model: " + nsUri);
	}
	
}
