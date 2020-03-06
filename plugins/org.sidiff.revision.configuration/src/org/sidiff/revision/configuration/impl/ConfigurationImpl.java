package org.sidiff.revision.configuration.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;

/**
 * A (insertion-ordered) map based implementation of {@link Configuration}.
 * 
 * @author Manuel Ohrndorf
 * @see Configuration
 * @see SingletonsImpl
 */
public class ConfigurationImpl extends BindingsImpl implements Configuration {

	private Map<Class<? extends Enum<?>>, Settings<? extends Enum<?>>> settings;

	@Override
	public <P extends Enum<?>> Settings<P> add(Class<P> properties, Settings<P> settings) {
		Settings<P> oldSettings = remove(properties);
		this.settings.put(properties, settings);
		return oldSettings;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <P extends Enum<?>> Settings<P> remove(Class<P> properties) {
		return (Settings<P>) settings.remove(properties);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <P extends Enum<?>> Settings<P> settings(Class<P> properties) {
		if (settings == null) {
			return null;
		} else {
			return (Settings<P>) getBindings().get(properties);
		}
	}

	@Override
	public Set<Settings<? extends Enum<?>>> settings() {
		if (settings == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(new LinkedHashSet<>(getBindings().values()));
		}
	}

	private Map<Class<? extends Enum<?>>, Settings<? extends Enum<?>>> getBindings() {
		if (settings == null) {
			this.settings = new LinkedHashMap<>();
		}
		return settings;
	}
}
