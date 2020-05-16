package org.sidiff.revision.configuration.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.Singletons;

/**
 * A (insertion-ordered) map based implementation of {@link Configuration}.
 * 
 * @author Manuel Ohrndorf
 * @see Configuration
 * @see SingletonsImpl
 */
public class ConfigurationImpl implements Configuration {

	private Map<Class<? extends Enum<?>>, Settings<? extends Enum<?>>> settings;

	private Map<Class<?>, Singletons> singletons;

	private Map<Class<?>, Factories> factories;

	@Override
	public <P extends Enum<?>> Settings<P> addSettings(Class<P> properties, Settings<P> settings) {
		Settings<P> oldSettings = removeSettings(properties);
		getSettings().put(properties, settings);
		return oldSettings;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <P extends Enum<?>> Settings<P> removeSettings(Class<P> properties) {
		return (Settings<P>) getSettings().remove(properties);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <P extends Enum<?>> Settings<P> settings(Class<P> properties) {
		if (settings == null) {
			return null;
		} else {
			return (Settings<P>) getSettings().get(properties);
		}
	}

	@Override
	public Set<Settings<? extends Enum<?>>> settings() {
		if (settings == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(new LinkedHashSet<>(getSettings().values()));
		}
	}

	private Map<Class<? extends Enum<?>>, Settings<? extends Enum<?>>> getSettings() {
		if (settings == null) {
			this.settings = new LinkedHashMap<>();
		}
		return settings;
	}

	@Override
	public Singletons addSingletons(Class<?> component, Singletons singletons) {
		Singletons oldSingletons = removeSingletons(component);
		getSingletons().put(component, singletons);
		return oldSingletons;
	}

	@Override
	public Singletons removeSingletons(Class<?> component) {
		return getSingletons().remove(component);
	}

	@Override
	public Singletons singletons(Class<?> component) {
		if (singletons == null) {
			return null;
		} else {
			return getSingletons().get(component);
		}
	}

	@Override
	public Set<Singletons> singletons() {
		if (singletons == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(new LinkedHashSet<>(getSingletons().values()));
		}
	}

	private Map<Class<?>, Singletons> getSingletons() {
		if (singletons == null) {
			this.singletons = new LinkedHashMap<>();
		}
		return singletons;
	}

	@Override
	public Factories addFactories(Class<?> component, Factories Factories) {
		Factories oldFactories = removeFactories(component);
		getFactories().put(component, Factories);
		return oldFactories;
	}

	@Override
	public Factories removeFactories(Class<?> component) {
		return getFactories().remove(component);
	}

	@Override
	public Factories factories(Class<?> component) {
		if (factories == null) {
			return null;
		} else {
			return getFactories().get(component);
		}
	}

	@Override
	public Set<Factories> factories() {
		if (factories == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(new LinkedHashSet<>(getFactories().values()));
		}
	}
	
	private Map<Class<?>, Factories> getFactories() {
		if (factories == null) {
			this.factories = new LinkedHashMap<>();
		}
		return factories;
	}
}
