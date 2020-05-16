package org.sidiff.revision.configuration;

import org.sidiff.revision.configuration.annotations.ConfigFactories;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;
import org.sidiff.revision.configuration.annotations.ConfigSingletons;
import org.sidiff.revision.configuration.impl.ConfigurationImpl;
import org.sidiff.revision.configuration.impl.FactoriesImpl;
import org.sidiff.revision.configuration.impl.SettingsImpl;
import org.sidiff.revision.configuration.impl.SingletonsImpl;
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
	default void configure(Configuration config) {

		// configure internally?
		if (config == null) {
			config = new ConfigurationImpl();
		}

		// inject configuration:
		ConfigUtil.write(this, ConfigField.class, config);

		// setup new settings:
		Class<? extends Enum<?>> properties = ConfigUtil.getConfigProperties(this);

		if (properties != null) {
			Settings<? extends Enum<?>> settings = config.settings(properties);

			if (settings == null) {

				// Create and inject new settings:
				config.addSettings(properties, new SettingsImpl<>(properties));
				settings = config.settings(properties);

				ConfigUtil.write(this, ConfigSettings.class, settings);
				configureDefaultSettings(config);
			} else {

				// Inject existing settings:
				ConfigUtil.write(this, ConfigSettings.class, settings);
			}
		}

		// setup new singletons:
		Singletons singletons = config.singletons(getClass());

		if (singletons == null) {

			// Create and inject new settings:
			config.addSingletons(getClass(), new SingletonsImpl());
			singletons = config.singletons(getClass());

			ConfigUtil.write(this, ConfigSingletons.class, singletons);
			configureDefaultSingletons(config);
		} else {

			// Inject existing settings:
			ConfigUtil.write(this, ConfigSingletons.class, singletons);
		}

		// setup new factories:
		Factories factories = config.factories(getClass());

		if (factories == null) {

			// Create and inject new settings:
			config.addFactories(getClass(), new FactoriesImpl());
			factories = config.factories(getClass());

			ConfigUtil.write(this, ConfigFactories.class, factories);
			configureDefaultFactories(config);
		} else {

			// Inject existing settings:
			ConfigUtil.write(this, ConfigFactories.class, factories);
		}
	}

}
