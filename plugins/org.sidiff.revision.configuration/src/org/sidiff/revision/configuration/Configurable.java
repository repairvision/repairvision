package org.sidiff.revision.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
	 * @param config The global configuration.
	 * @param reset  Reset/Overwrite existing settings?
	 * @return Setups the settings for this class.
	 */
	default Settings<? extends Enum<?>> setup(Configuration config, boolean reset) {
		Class<? extends Enum<?>> properties = ConfigUtil.getConfigProperties(this);

		// Configure internally?
		if (config == null) {
			config = new ConfigurationImpl();
		}

		// Create new settings?
		Settings<? extends Enum<?>> settings = config.settings(properties);

		if (reset || (settings == null)) {
			setupDefaultSettings(config);
			setupDefaultSingletons(config);
			setupDefaultFactories(config);

			settings = config.settings(properties);
		}

		// Do injection:
		ConfigUtil.inject(this, ConfigField.class, config);
		ConfigUtil.inject(this, ConfigSettings.class, settings);

		return settings;
	}

	/**
	 * @param config The global configuration.
	 * @return Setups the settings for this class.
	 */
	default Settings<? extends Enum<?>> setup(Configuration config) {
		return setup(config, false);
	}

	/**
	 * Creates the default settings for this component.
	 * 
	 * @param config A configuration container.
	 */
	default void setupDefaultSettings(Configuration config) {
		Class<? extends Enum<?>> properties = ConfigUtil.getConfigProperties(this);

		if (properties != null) {
			config.add(properties, new SettingsImpl<>());
		}
	}

	/**
	 * @return All used/required settings properties of this component.
	 */
	default Set<? extends Enum<?>> settings() {
		Class<? extends Enum<?>> properties = ConfigUtil.getConfigProperties(this);

		if (properties != null) {
			return new HashSet<>(Arrays.asList(properties.getEnumConstants()));
		} else {
			return Collections.emptySet();
		}
	}

	/**
	 * Creates the default singleton bindings for this component.
	 * 
	 * @param config A configuration container.
	 */
	default void setupDefaultSingletons(Configuration config) {
	}

	/**
	 * @return All used/required singleton bindings (class type to object) of this
	 *         component.
	 */
	default Set<Class<?>> singletons() {
		return Collections.emptySet();
	}

	/**
	 * Creates the default factory bindings for this component.
	 * 
	 * @param config A configuration container.
	 */
	default void setupDefaultFactories(Configuration config) {
	}

	/**
	 * @return All used/required factory bindings (class type to object) of this
	 *         component.
	 */
	default Set<Class<?>> factories() {
		return Collections.emptySet();
	}
}
