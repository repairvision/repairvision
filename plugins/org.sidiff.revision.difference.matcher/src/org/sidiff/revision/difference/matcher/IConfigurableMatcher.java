package org.sidiff.revision.difference.matcher;

import java.util.Map;

public interface IConfigurableMatcher extends IMatcher {

	Map<String, Object> getConfigurationOptions();	
	
	void setConfigurationOption(String key, Object value);
	
	void configure(Map<String, Object> config);
}
