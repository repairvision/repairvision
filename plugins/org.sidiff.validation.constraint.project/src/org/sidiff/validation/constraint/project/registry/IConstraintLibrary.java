package org.sidiff.validation.constraint.project.registry;

import java.util.List;
import java.util.Set;

import org.sidiff.validation.constraint.interpreter.IConstraint;

public interface IConstraintLibrary {

	/**
	 * @return The name of the constraint library.
	 */
	String getName();
	
	/**
	 * @return The domain meta-model(s) used by constraints of this library.
	 */
	Set<String> getDomains();
	
	/**
	 * @return The document type(s) of this constraint library (based on the context types).
	 */
	Set<String> getDocumentTypes();
	
	/**
	 * @return All constraints of this library.
	 */
	List<IConstraint> getConstraints();
	
	/**
	 * @param name
	 *            The identifier of a constraint.
	 * @return The corresponding constraint.
	 */
	IConstraint getConstraint(String name);
}
