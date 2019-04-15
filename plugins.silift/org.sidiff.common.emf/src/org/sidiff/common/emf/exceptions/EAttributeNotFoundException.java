package org.sidiff.common.emf.exceptions;

import org.eclipse.emf.ecore.EClass;

public class EAttributeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EAttributeNotFoundException(String eAttribute, EClass eClass) {
		super("The EClass with the name'"+eClass.getName()+"' does not contain any EAttribute with the name '"+eAttribute+"'.");
	}
}
