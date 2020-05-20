package org.sidiff.revision.difference.matcher;

import java.util.Map;

/**
 * Extends a match with configuration options.
 */
public interface IConfigurableMatcherProvider extends IMatcherProvider {

	/**
	 * @return All possible options with defaults settings.
	 */
	Map<String, Object> getConfiguration();	
	
	/**
	 * @param key   The configuration option key.
	 * @param value The configuration option value.
	 */
	default void setConfiguration(String key, Object value) {
		if (getConfiguration().containsKey(key)) {
			getConfiguration().put(key, value);
		} else {
			throw new UnsupportedOperationException("Key '" + key + "' doesn't exist.");
		}
	}
	
}
