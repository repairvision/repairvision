/**
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.SemanticChangeSet;

/**
 * A sample validator interface for {@link org.sidiff.difference.symmetric.FragmentSplit}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface FragmentSplitValidator {
	boolean validate();

	boolean validateScs(SemanticChangeSet value);
	boolean validateSplitFrom(EList<EObject> value);
	boolean validateSplitInto(EList<EObject> value);
}
