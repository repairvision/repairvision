package org.sidiff.revision.configuration.test.data;

import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;

public class ConfigurableA implements Configurable {

	@ConfigProperties
	public enum Properties {
		PROPERTY_A1,
		PROPERTY_A2,
		PROPERTY_A3
	}
	
	@ConfigField
	public Configuration config;
	
	@ConfigSettings
	public Settings<Properties> settings;

	public Configuration getConfig() {
		return config;
	}

	public Settings<Properties> getSettings() {
		return settings;
	}

}
