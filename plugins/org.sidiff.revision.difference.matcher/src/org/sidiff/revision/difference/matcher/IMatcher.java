package org.sidiff.revision.difference.matcher;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.revision.difference.Difference;

public interface IMatcher {

	public static final String EXTENSION_POINT_ID = "org.sidiff.revision.difference.matcher.engine";

	/**
	 * Returns the short name (used as a key) of the matcher.
	 * 
	 * @return the matcher short name (used as key).
	 */
	public String getKey();

	/**
	 * Returns the description name of the matcher.
	 * 
	 * @return the matcher name.
	 */
	public String getName();

	/**
	 * @return the document types the matcher is implemented for.
	 */
	public Set<String> getDocumentTypes();

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
