package org.sidiff.revision.difference.matcher;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Difference;

/**
 * A matching engine implementation.
 */
public interface IMatcher {
	
	/**
	 * Calculates a matching between models. That means a Correspondence for each
	 * preserved object between models.
	 * 
	 * @param difference the difference to store the matching.
	 * @param models     the models to compare
	 * @param scope      RESOURCE or RESOURCE_SET
	 */
	public void startMatching(Difference difference, Resource modelA, Resource modelB, Scope scope);
}
