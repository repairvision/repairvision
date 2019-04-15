package org.sidiff.configuration;

import java.util.Map;

public interface IConfigurable {

	public abstract Map<String, Object> getConfigurationOptions();	
	public abstract void setConfigurationOption(String key, Object value);	
	public abstract void configure(Map<String, Object> config);
}
