package org.sidiff.revision.configuration.test.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.Singletons;
import org.sidiff.revision.configuration.annotations.ConfigFactories;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;
import org.sidiff.revision.configuration.annotations.ConfigSingletons;

public class ConfigurableD implements Configurable {

	@ConfigProperties
	public enum Properties {
		PROPERTY_D1, PROPERTY_D2,
	}

	@ConfigField
	public Configuration config;

	@ConfigSettings
	public Settings<Properties> settings;

	@ConfigSingletons
	public Singletons singletons;

	@ConfigFactories
	public Factories factories;

	public ConfigurableD(Configuration config) {
		configure(config);
	}

	@Override
	public void configureDefaultSettings(Configuration config) {
		settings.set(Properties.PROPERTY_D1, "Hallo");
		settings.set(Properties.PROPERTY_D1, "Welt");
	}

	@Override
	public void configureDefaultFactories(Configuration config) {
		factories.set(List.class, () -> new ArrayList<>());
		factories.set(Set.class, () -> new HashSet<>());
	}

	@Override
	public void configureDefaultSingletons(Configuration config) {
		singletons.set(List.class, Collections.singletonList("Hallo"));
		singletons.set(Set.class, Collections.singleton("Welt"));
	}

	public Configuration getConfig() {
		return config;
	}

	public Settings<Properties> getSettings() {
		return settings;
	}

	public Singletons getSingletons() {
		return singletons;
	}

	public Factories getFactories() {
		return factories;
	}

}
