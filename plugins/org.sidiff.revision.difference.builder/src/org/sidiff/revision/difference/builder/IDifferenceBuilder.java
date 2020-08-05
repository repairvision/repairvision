package org.sidiff.revision.difference.builder;

import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Difference;

/**
 * Derives the technical difference.
 */
public interface IDifferenceBuilder {

	/**
	 * Derives the technical difference. A default implementation is given by the
	 * abstract class {@link GenericDifferenceBuilder}
	 * 
	 * @param difference
	 * @return {@link Difference}
	 */
	public Difference deriveTechDiff(Difference difference, Scope scope);
}
