/**
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A sample validator interface for {@link org.sidiff.difference.symmetric.RemoveReference}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RemoveReferenceValidator {
	boolean validate();

	boolean validateSrc(EObject value);
	boolean validateTgt(EObject value);
	boolean validateType(EReference value);
}
