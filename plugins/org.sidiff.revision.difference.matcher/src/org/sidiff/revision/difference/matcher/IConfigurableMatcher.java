package org.sidiff.revision.difference.matcher;

import java.util.Map;

/**
 * Extends a match with configuration option (which can be shown in the UI).
 */
public interface IConfigurableMatcher extends IMatcherProvider {

	/**
	 * @return All possible options with defaults settings.
	 */
	Map<String, Object> getConfigurationOptions();	
	
	/**
	 * @param key The configuration options key.
	 * @param value The options value to be set.
	 */
	void setConfigurationOption(String key, Object value);
	
	/**
	 * @param config All configuration options with settings.
	 */
	void configure(Map<String, Object> config);
}
