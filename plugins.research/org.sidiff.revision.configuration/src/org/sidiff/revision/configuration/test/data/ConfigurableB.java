package org.sidiff.revision.configuration.test.data;

import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;

public class ConfigurableB implements Configurable {

	@ConfigProperties
	public enum Properties {
	}
	
	@ConfigField
	private Configuration config;
	
	@ConfigSettings
	private Settings<Properties> settings;
	
	public Configuration getConfig() {
		return config;
	}

	public Settings<Properties> getSettings() {
		return settings;
	}
}
