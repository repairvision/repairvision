package org.sidiff.revision.difference.builder;

import java.util.Set;

/**
 * This interface belongs to the Difference Builder extension point. This
 * extension point is used to add a new technical difference builder to the
 * lifting engine. A plug-in that adds this extension point has to implement
 * this interface.
 * 
 * A generic implementation is given by {@link GenericDifferenceBuilderProvider}
 */
public interface IDifferenceBuilderProvider {
	
	public static final String EXTENSION_POINT_ID = "org.sidiff.revision.difference.builder.provider";
	
	public static final String EXTENSION_POINT_ELEMENT = "builder";
	
	public static final String EXTENSION_POINT_ATTRIBUTE = "class";

	/**
	 * Returns the description name of the technical difference builder.
	 * 
	 * @return the technical difference builder name.
	 */
	public String getName();

	/**
	 * Returns the short name (used as a key) of the technical difference builder.
	 * 
	 * @return the technical difference builder short name (used as key).
	 */
	public String getKey();

	/**
	 * @return the document types the technical difference builder is primarily
	 *         implemented for.
	 */
	public Set<String> getDocumentTypes();
	
	/**
	 * @return Creates a fresh Difference Builder.
	 */
	public IDifferenceBuilder createDifferenceBuilder();

}
