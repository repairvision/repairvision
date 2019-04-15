package org.sidiff.common.emf.exceptions;


@SuppressWarnings("serial")
public class EClassifierUnresolvableException extends Exception {

	public EClassifierUnresolvableException(String eClassifierName) {
		super("The EClassifier with the name'"+eClassifierName+"' couldn't be found in one of the active EPackages.");
	}
}
