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
 * @see BindingImpl
 */
public class ConfigurationImpl extends BindingImpl implements Configuration {

	private Map<Class<? extends Enum<?>>, Settings<? extends Enum<?>>> settings;
	
	@SuppressWarnings("unchecked")
	@Override
	public <P extends Enum<?>> Settings<P> settings(Class<P> properties) {
		if (settings == null) {
			return null;
		} else {
			return (Settings<P>) getBindings().get(properties);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <P extends Enum<?>> Settings<P> remove(Class<P> properties) {
		return (Settings<P>) settings.remove(properties);
	}

	@Override
	public Set<Settings<? extends Enum<?>>> settings() {
		if (settings == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(new LinkedHashSet<>(getBindings().values()));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object get(Enum<?> property) {
		if (settings(property.getClass()) != null) {
			Settings<Enum<?>> settings = (Settings<Enum<?>>) settings(property.getClass());
			return settings.get(property);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object set(Enum<?> property, Object value) {
		
		if (settings(property.getClass()) == null) {
			Settings<Enum<?>> newSettings = new SettingsImpl<Enum<?>>();
			getBindings().put((Class<? extends Enum<?>>) property.getClass(), newSettings);
		}
		
		Settings<Enum<?>> settings = (Settings<Enum<?>>) settings(property.getClass());
		return settings.set(property, value);
	}
	
	private Map<Class<? extends Enum<?>>, Settings<? extends Enum<?>>> getBindings() {
		if (settings == null) {
			this.settings = new LinkedHashMap<>();
		}
		return settings;
	}
}
