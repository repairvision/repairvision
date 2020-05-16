package org.sidiff.revision.difference.matcher;

import java.util.Set;

/**
 * Provides a matcher.
 */
public interface IMatcherProvider {

	public static final String EXTENSION_POINT_ID = "org.sidiff.revision.difference.matcher.provider";
	
	public static final String EXTENSION_POINT_ELEMENT = "matcher";

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
	 * @return Creates a fresh matcher.
	 */
	IMatcher createMatcher();

}
