package org.sidiff.revision.difference.matcher;

import java.util.List;

/**
 * Provides a set of matchers.
 */
public interface IMatcherProviderBundle {
	
	public static final String EXTENSION_POINT_ID = "org.sidiff.revision.difference.matcher.provider";
	
	public static final String EXTENSION_POINT_ELEMENT = "bundle";

	/**
	 * @return A set of matcher providers.
	 */
	List<IMatcherProvider> getProviderBundle();
	
}
