package org.sidiff.revision.configuration;

import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;
import org.sidiff.revision.configuration.impl.ConfigurationImpl;
import org.sidiff.revision.configuration.impl.SettingsImpl;
import org.sidiff.revision.configuration.util.ConfigUtil;

/**
 * Creates the default configuration for a component.
 * 
 * @author Manuel Ohrndorf
 * @see ConfigField
 * @see ConfigProperties
 */
public interface Configurable {

	/**
	 * Creates the default settings for this component.
	 * 
	 * @param config A configuration container.
	 */
	default void configureDefaultSettings(Configuration config) {
	}

	/**
	 * Creates the default singleton bindings for this component.
	 * 
	 * @param config A configuration container.
	 */
	default void configureDefaultSingletons(Configuration config) {
	}

	/**
	 * Creates the default factory bindings for this component.
	 * 
	 * @param config A configuration container.
	 */
	default void configureDefaultFactories(Configuration config) {
	}
	
	/**
	 * @param config The global configuration.
	 * @return Setups the settings for this class.
	 */
	default Settings<? extends Enum<?>> configure(Configuration config) {
		Class<? extends Enum<?>> properties = ConfigUtil.getConfigProperties(this);

		// Configure internally?
		if (config == null) {
			config = new ConfigurationImpl();
		}
		
		// Inject configuration:
		ConfigUtil.inject(this, ConfigField.class, config);

		// Create new settings?
		Settings<? extends Enum<?>> settings = config.settings(properties);
		
		if (settings == null) {
			
			// Create and inject new settings:
			config.add(properties, new SettingsImpl<>(properties));
			settings = config.settings(properties);
			
			ConfigUtil.inject(this, ConfigSettings.class, settings);
			ConfigUtil.setupDefaultConfiguration(this, config);
		} else {
			
			// Inject existing settings:
			ConfigUtil.inject(this, ConfigSettings.class, settings);
		}

		return settings;
	}

}
