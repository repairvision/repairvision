package org.sidiff.common.henshin.exceptions;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;

/**
 * Exception is thrown while transforming an edit rule into a recognition rule. It indicates that
 * there is no unit named 'mainUnit'.
 */
public class NoMainUnitFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new exception: It indicates that there is no unit named 'mainUnit'.
	 * 
	 * @param module
	 *            The module that should contain a main-unit.
	 */
	public NoMainUnitFoundException(Module module) {
		super("\nNo Main Unit found in " + EcoreUtil.getURI(module));
	}
}
